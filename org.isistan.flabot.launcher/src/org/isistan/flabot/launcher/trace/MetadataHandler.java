/** * $Id: MetadataHandler.java,v 1.7 2006/02/22 00:48:51 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.launcher.trace;

import java.util.HashSet;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.JMember;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JavaModelObjectHashProvider;import org.isistan.flabot.trace.log.LogFactory;import org.isistan.flabot.trace.log.Tag;import org.isistan.flabot.trace.log.tagquery.TagQueryUtil.MetadataConstants;import org.isistan.flabot.util.custommap.CustomMap;/** * Creates tags representing the java metamodel * @author dacostae * */public class MetadataHandler {
	private Tag metadata;
	public MetadataHandler(Tag metadata) {
		this.metadata=metadata;
	}
	
	private CustomMap<JObject, Tag> fastTags=new CustomMap<JObject, Tag>(new JavaModelObjectHashProvider<JObject>());
	private Tag getTagFor(JObject object) {
		return fastTags.get(object);
	}
	private void setTagFor(JObject object, Tag tag) {
		fastTags.put(object, tag);
	}
	
	private HashSet<Tag> completedClasses=new HashSet<Tag>();
	private boolean isComplete(Tag classTag) {
		return completedClasses.contains(classTag);
	}
	private void setComplete(Tag classTag) {
		completedClasses.add(classTag);
	}

	
	public synchronized Tag getClass(JClass clazz) {
		Tag classTag=getTagFor(clazz);
		if(classTag==null) {
			String key=clazz.getName() + "@" + clazz.getId();
			classTag=createClass(clazz, key);
			completeClass(clazz, classTag);
		} else if(!isComplete(classTag)) {
			completeClass(clazz, classTag);
		}
		return classTag;
	}
	
	public synchronized Tag getClassLight(JClass clazz) {
		Tag classTag=getTagFor(clazz);
		if(classTag==null) {
			String key=clazz.getName() + "@" + clazz.getId();
			classTag=createClass(clazz, key);
		}
		return classTag;
	}


	private Tag createClass(JClass clazz, String key) {
		Tag classTag=LogFactory.eINSTANCE.createTag();
		classTag.setProperty(MetadataConstants.COMPLETE_PARAMETER, Boolean.FALSE.toString());

		classTag.setParent(key, metadata);
		setTagFor(clazz, classTag);
		
		classTag.setProperty(MetadataConstants.NAME_PARAMETER, clazz.getName());
		classTag.setProperty(MetadataConstants.MODIFIERS_PARAMETER, Integer.toString(clazz.getModifiers()));
		classTag.setProperty(MetadataConstants.ARRAY_PARAMETER, Boolean.toString(clazz.isArray()));
		classTag.setProperty(MetadataConstants.PRIMITIVE_PARAMETER, Boolean.toString(clazz.isPrimitive()));

		if(clazz.isPrimitive()) {
			completeClass(clazz, classTag);
		}
		return classTag;
	}
	
	private void completeClass(JClass clazz, Tag classTag) {
		setComplete(classTag);
		classTag.setProperty(MetadataConstants.COMPLETE_PARAMETER, Boolean.TRUE.toString());

		JClass enclosingClass=clazz.getEnclosingClass();
		if(enclosingClass!=null) {
			classTag.getTags().put(MetadataConstants.ENCLOSING_CLASS_TAG, getClassLight(enclosingClass));
		}

		JClass componentType=clazz.getComponentType();
		if(componentType!=null) {
			classTag.getTags().put(MetadataConstants.COMPONENT_TYPE_TAG, getClassLight(componentType));
		}

		JClass superclass=clazz.getSuperclass();
		if(superclass!=null) {
			classTag.getTags().put(MetadataConstants.SUPERCLASS_TAG, getClassLight(superclass));
		}
		
		createSuperinterfaces(clazz.getInterfaces(), classTag);

		createInnerClasses(clazz.getDeclaredClasses(), classTag);
		createConstructors(clazz.getDeclaredConstructors(), classTag);
		createFields(clazz.getDeclaredFields(), classTag);
		createMethods(clazz.getDeclaredMethods(), classTag);
	}


	private void createSuperinterfaces(JArray<? extends JClass> interfaces, Tag classTag) {
		Tag interfacesTag=TagUtil.getCollection(classTag, MetadataConstants.SUPERINTERFACES_TAG, true, true);
		for (JClass hinterface : interfaces) {
			Tag interfaceTag=getClassLight(hinterface);
			TagUtil.addToCollection(interfacesTag, interfaceTag, false);
		}	
	}


	private void createMethods(JArray<? extends JMethod> methods, Tag classTag) {
		Tag methodsTag=TagUtil.getCollection(classTag, MetadataConstants.METHODS_TAG, true, true);
		for (JMethod method : methods) {
			Tag methodTag=createMethod(method, classTag);
			TagUtil.addToCollection(methodsTag, methodTag, true);
			setTagFor(method, methodTag);
		}
	}
	
	private Tag createBehavior(JBehavior behavior, Tag classTag) {
		Tag behaviorTag=LogFactory.eINSTANCE.createTag();
		behaviorTag.setProperty(MetadataConstants.NAME_PARAMETER, behavior.getName());
		behaviorTag.setProperty(MetadataConstants.MODIFIERS_PARAMETER, Integer.toString(behavior.getModifiers()));

		behaviorTag.getTags().put(MetadataConstants.DECLARING_CLASS_TAG, classTag);

		Tag exceptionTypesTag=TagUtil.getCollection(behaviorTag, MetadataConstants.EXCEPTION_TYPES_TAG, true, true);
		
		for (JClass exceptionType: behavior.getExceptionTypes()) {
			Tag exceptionTypeTag=getClassLight(exceptionType);
			TagUtil.addToCollection(exceptionTypesTag, exceptionTypeTag, false);
		}
		
		Tag parameterTypesTag=TagUtil.getCollection(behaviorTag, MetadataConstants.PARAMETER_TYPES_TAG, true, true);
		for (JClass parameterType: behavior.getParameterTypes()) {
			Tag parameterTypeTag=getClassLight(parameterType);
			TagUtil.addToCollection(parameterTypesTag, parameterTypeTag, false);
		}
		return behaviorTag;
	}
	private Tag createMethod(JMethod method, Tag classTag) {
		Tag methodTag=createBehavior(method, classTag);
		
		Tag returnType=getClassLight(method.getType());
		methodTag.getTags().put(MetadataConstants.TYPE_TAG, returnType);
		
		return methodTag;
	}
	
	private void createConstructors(JArray<? extends JConstructor> constructors, Tag classTag) {
		Tag constructorsTag=TagUtil.getCollection(classTag, MetadataConstants.CONSTRUCTORS_TAG, true, true);
		for (JConstructor constructor : constructors) {
			Tag constructorTag=createConstructor(constructor, classTag);
			TagUtil.addToCollection(constructorsTag, constructorTag, true);
			setTagFor(constructor, constructorTag);
		}
	}

	private Tag createConstructor(JConstructor constructor, Tag classTag) {
		return createBehavior(constructor, classTag);
	}


	private void createInnerClasses(JArray<? extends JClass> innerClasses, Tag classTag) {
		Tag innerClassesTag=TagUtil.getCollection(classTag, MetadataConstants.INNER_CLASSES_TAG, true, true);
		for (JClass innerClass : innerClasses) {
			Tag innerClassTag=getClass(innerClass);
			TagUtil.addToCollection(innerClassesTag, innerClassTag, false);
		}
	}


	private void createFields(JArray<? extends JField> fields, Tag classTag) {
		Tag fieldsTag=TagUtil.getCollection(classTag, MetadataConstants.FIELDS_TAG, true, true);
		for (JField field : fields) {
			Tag fieldTag=createField(field, classTag);
			TagUtil.addToCollection(fieldsTag, fieldTag, true);
			setTagFor(field, fieldTag);
		}
		
	}

	private Tag createField(JField field, Tag classTag) {
		Tag fieldTag=LogFactory.eINSTANCE.createTag();
		fieldTag.setProperty(MetadataConstants.NAME_PARAMETER, field.getName());
		fieldTag.setProperty(MetadataConstants.MODIFIERS_PARAMETER, Integer.toString(field.getModifiers()));

		fieldTag.getTags().put(MetadataConstants.DECLARING_CLASS_TAG, classTag);

		Tag type=getClassLight(field.getType());
		fieldTag.getTags().put(MetadataConstants.TYPE_TAG, type);
		
		return fieldTag; 
	}


	public synchronized Tag getMember(JMember member) {
		getClass(member.getDeclaringClass());
		return getTagFor(member);
	}
}
