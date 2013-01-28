/** * $Id: ClassImpl.java,v 1.5 2006/03/29 20:39:26 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.javassist;

import javassist.CtBehavior;import javassist.CtClass;import javassist.CtConstructor;import javassist.CtMethod;import javassist.NotFoundException;import javassist.bytecode.Descriptor;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JClassLoader;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JEnum;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;public class ClassImpl extends ObjectImpl implements JClass {

	private CtClass javassistClass;
	
	CtClass getJavassistClass() {
		return javassistClass;
	}
	
	static CtClass getJavassistClass(JClass jClass) {
		if(jClass instanceof ClassImpl) {
			return ((ClassImpl)jClass).getJavassistClass();
		} else {
			throw new MixedImplementationsException(jClass);
		} 
	}
	
	ClassImpl(CtClass javassistClass) {
		super(javassistClass);
		this.javassistClass=javassistClass;
	}
	
	public JObject newInstance() {
		throw new NotSupportedFeatureException();
	}

	public boolean isInstance(JObject obj) {
		throw new NotSupportedFeatureException();
	}

	public boolean isAssignableFrom(JClass cls) {
		throw new NotSupportedFeatureException();
	}

	public boolean isInterface() {
		return javassistClass.isInterface();
	}

	public boolean isArray() {
		return javassistClass.isArray();
	}

	public boolean isPrimitive() {
		return javassistClass.isPrimitive();
	}

	public boolean isAnnotation() {
		throw new NotSupportedFeatureException();
	}

	public boolean isSynthetic() {
		throw new NotSupportedFeatureException();
	}

	public String getName() {
		return javassistClass.getName();
	}

	public String getJNIName() {
		return Util.getJNIName(javassistClass.getName());
	}

	public JClassLoader getClassLoader() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		throw new NotSupportedFeatureException();
	}

	public JClass getSuperclass() {
		try {
			return JavassistFactory.getInstance().buildClass(javassistClass.getSuperclass());
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public JType getGenericSuperclass() {
		throw new NotSupportedFeatureException();
	}

	public JPackage getPackage() {
		return JavassistFactory.getInstance().buildPackage(javassistClass.getPackageName());
	}

	public JArray<? extends JClass> getInterfaces() {
		try {
			return JavassistFactory.getInstance().buildArray(
					javassistClass.getInterfaces(), 
					JavassistFactory.getInstance().getClassBuilder()
				);
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public JArray<? extends JType> getGenericInterfaces() {
		throw new NotSupportedFeatureException();
	}

	public JClass getComponentType() {
		try {
			return JavassistFactory.getInstance().buildClass(javassistClass.getComponentType());
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public int getModifiers() {
		return javassistClass.getModifiers();
	}

	public JArray<? extends JObject> getSigners() {
		throw new NotSupportedFeatureException();
	}

	public JMethod getEnclosingMethod() {
		throw new NotSupportedFeatureException();
	}

	public JConstructor getEnclosingConstructor() {
		throw new NotSupportedFeatureException();
	}

	public JBehavior getEnclosingBehavior() {
		throw new NotSupportedFeatureException();
	}

	public JClass getDeclaringClass() {
		try {
			return JavassistFactory.getInstance().buildClass(
					javassistClass.getDeclaringClass()
				);
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public JClass getEnclosingClass() {
		try {
			return JavassistFactory.getInstance().buildClass(
					javassistClass.getEnclosingClass()
				);
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public String getSimpleName() {
		return javassistClass.getSimpleName();
	}

	public String getCanonicalName() {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnonymousClass() {
		throw new NotSupportedFeatureException();
	}

	public boolean isLocalClass() {
		throw new NotSupportedFeatureException();
	}

	public boolean isMemberClass() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JClass> getClasses() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JField> getFields() throws SecurityException {
		return JavassistFactory.getInstance().buildArray(
				javassistClass.getFields(),
				JavassistFactory.getInstance().getFieldBuilder()
			);	
	}

	public JArray<? extends JMethod> getMethods() throws SecurityException {
		return JavassistFactory.getInstance().buildArray(
				javassistClass.getMethods(), 
				JavassistFactory.getInstance().getMethodBuilder()
			);	
	}

	public JArray<? extends JConstructor> getConstructors() throws SecurityException {
		return JavassistFactory.getInstance().buildArray(
				javassistClass.getConstructors(),
				JavassistFactory.getInstance().getConstructorBuilder()
			);	
	}

	private JArray<? extends JBehavior> behaviors=null;
	public JArray<? extends JBehavior> getBehaviors() throws SecurityException {
		if(behaviors==null) {
			CtMethod[] methods=javassistClass.getMethods();
			CtConstructor[] constructors=javassistClass.getConstructors();
			CtBehavior[] javassistBehaviors=new CtBehavior[methods.length + constructors.length];
			for (int i = 0; i < methods.length; i++) {
				javassistBehaviors[i]=methods[i];
			}
			for (int i = 0; i < constructors.length; i++) {
				javassistBehaviors[methods.length + i]=constructors[i];
			}
			behaviors=JavassistFactory.getInstance().buildArray(
					javassistBehaviors, 
					JavassistFactory.getInstance().getBehaviorBuilder()
				);	
		}
		return behaviors;
	}

	public JField getField(String name) {
		try {
			return JavassistFactory.getInstance().buildField(javassistClass.getField(name));
		} catch (NotFoundException e) {
			return null;
		}
	}

	public JMethod getMethod(String name, JArray<? extends JClass> parameterTypes) {
		CtClass[] javassistParameterTypes=new CtClass[parameterTypes.length()];
		for(int i=0; i<javassistParameterTypes.length; i++) {
			javassistParameterTypes[i]=ClassImpl.getJavassistClass(parameterTypes.at(i));
		}
		
		try {
			return JavassistFactory.getInstance().buildMethod(
					javassistClass.getMethod(
							name,
							Descriptor.ofParameters(javassistParameterTypes)
						)
				);
		} catch (NotFoundException e) {
			return null;
		}
	}

	public JConstructor getConstructor(JArray<? extends JClass> parameterTypes) {
		CtClass[] javassistParameterTypes=new CtClass[parameterTypes.length()];
		for(int i=0; i<parameterTypes.length(); i++) {
			javassistParameterTypes[i]=ClassImpl.getJavassistClass(parameterTypes.at(i));
		}

		try {
			return JavassistFactory.getInstance().buildConstructor(
					javassistClass.getConstructor(
							Descriptor.ofParameters(javassistParameterTypes)
						)
				);
		} catch (NotFoundException e) {
			return null;
		}	
	}

	public JBehavior getBehavior(String name, JArray<? extends JClass> parameterTypes) {
		if(name.equals(JConstructor.BEHAVIOR_NAME)) {
			return getConstructor(parameterTypes);
		} else {
			return getMethod(name, parameterTypes);
		}
	}

	public JArray<? extends JClass> getDeclaredClasses() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JField> getDeclaredFields() {
		return JavassistFactory.getInstance().buildArray(
				javassistClass.getDeclaredFields(),
				JavassistFactory.getInstance().getFieldBuilder()
			);	
	}

	public JArray<? extends JMethod> getDeclaredMethods() {
		return JavassistFactory.getInstance().buildArray(
				javassistClass.getDeclaredMethods(), 
				JavassistFactory.getInstance().getMethodBuilder()
			);	
	}

	public JArray<? extends JConstructor> getDeclaredConstructors()
			throws SecurityException {
		return JavassistFactory.getInstance().buildArray(
				javassistClass.getDeclaredConstructors(), 
				JavassistFactory.getInstance().getConstructorBuilder()
			);	
	}

	public JArray<? extends JBehavior> getDeclaredBehaviors() {
		return JavassistFactory.getInstance().buildArray(
				javassistClass.getDeclaredBehaviors(),
				JavassistFactory.getInstance().getBehaviorBuilder()
			);	
	}
	
	public JField getDeclaredField(String name) {
		try {
			return JavassistFactory.getInstance().buildField(javassistClass.getDeclaredField(name));
		} catch (NotFoundException e) {
			return null;
		}
	}

	public JMethod getDeclaredMethod(String name, JArray<? extends JClass> parameterTypes) {
		CtClass[] javassistParameterTypes=new CtClass[parameterTypes.length()];
		for(int i=0; i<parameterTypes.length(); i++) {
			javassistParameterTypes[i]=ClassImpl.getJavassistClass(parameterTypes.at(i));
		}
		
		try {
			return JavassistFactory.getInstance().buildMethod(javassistClass.getDeclaredMethod(name, javassistParameterTypes));
		} catch (NotFoundException e) {
			return null;
		}
	}

	public JConstructor getDeclaredConstructor(JArray<? extends JClass> parameterTypes) {
		CtClass[] javassistParameterTypes=new CtClass[parameterTypes.length()];
		for(int i=0; i<parameterTypes.length(); i++) {
			javassistParameterTypes[i]=ClassImpl.getJavassistClass(parameterTypes.at(i));
		}
		
		try {
			return JavassistFactory.getInstance().buildConstructor(javassistClass.getDeclaredConstructor(javassistParameterTypes));
		} catch (NotFoundException e) {
			return null;
		}
	}

	public JBehavior getDeclaredBehavior(String name, JArray<? extends JClass> parameterTypes) {
		if(name.equals(JConstructor.BEHAVIOR_NAME)) {
			return getDeclaredConstructor(parameterTypes);
		} else {
			return getDeclaredMethod(name, parameterTypes);
		}
	}

	public JObject getResourceAsStream(String name) {
		throw new NotSupportedFeatureException();
	}

	public JObject getResource(String name) {
		throw new NotSupportedFeatureException();
	}

	public JObject getProtectionDomain() {
		throw new NotSupportedFeatureException();
	}

	public boolean desiredAssertionStatus() {
		throw new NotSupportedFeatureException();
	}
	
	public boolean isEnum() {		
		return Util.isSubclassOf(this, java.lang.Enum.class.getName());
	}

	public JArray<? extends JEnum> getEnumConstants() {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		throw new NotSupportedFeatureException();
	}	public JArray<? extends JClass> getSubclasses(boolean onlyDirect) {		throw new NotSupportedFeatureException();	}	public JSourceLocation getSourceLocation() {		throw new NotSupportedFeatureException();	}
	public String getDescriptor() {		return Util.getClassDescriptor(this);	}}
