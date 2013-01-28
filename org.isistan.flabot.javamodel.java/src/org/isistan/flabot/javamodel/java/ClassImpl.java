/** * $Id: ClassImpl.java,v 1.6 2006/03/29 20:39:54 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.java;

import java.lang.reflect.Constructor;import java.lang.reflect.Member;import java.lang.reflect.Method;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JClassLoader;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JEnum;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;public class ClassImpl extends TypeImpl implements JClass {

	private Class javaClass;
	
	Class getJavaClass() {
		return javaClass;
	}
	
	static Class getJavaClass(JClass jClass) {
		if(jClass instanceof ClassImpl) {
			return ((ClassImpl)jClass).getJavaClass();
		} else {
			throw new MixedImplementationsException(jClass);
		} 
	}
	
	ClassImpl(Class javaClass) {
		super(javaClass);
		this.javaClass=javaClass;
	}
	
	public JObject newInstance() {
		try {			return JavaFactory.getInstance().buildObject(javaClass.newInstance());		} catch (InstantiationException e) {			throw new InternalModelException(e);		} catch (IllegalAccessException e) {			throw new InternalModelException(e);		}
	}

	public boolean isInstance(JObject obj) {
		return javaClass.isInstance(ObjectImpl.getJavaObject(obj));
	}

	public boolean isAssignableFrom(JClass cls) {
		return javaClass.isInstance(ClassImpl.getJavaClass(cls));
	}

	public boolean isInterface() {
		return javaClass.isInterface();
	}

	public boolean isArray() {
		return javaClass.isArray();
	}

	public boolean isPrimitive() {
		return javaClass.isPrimitive();
	}

	public boolean isAnnotation() {
		return javaClass.isAnnotation();
	}

	public boolean isSynthetic() {
		return javaClass.isSynthetic();
	}

	public String getName() {
		if(isArray()) {
			return Util.getName(
					javaClass.getName().replace(
							Util.PACKAGE_DELIMITER, 
							Util.JNI_PACKAGE_DELIMITER
						)
				);
		} else {
			return javaClass.getName();
		}
	}

	public String getJNIName() {
		if(isArray()) {
			return javaClass.getName().replace(
					Util.PACKAGE_DELIMITER,
					Util.JNI_PACKAGE_DELIMITER
				);
		} else {
			return Util.getJNIName(javaClass.getName());
		}
	}

	public JClassLoader getClassLoader() {
		return JavaFactory.getInstance().buildClassLoader(javaClass.getClassLoader());
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getTypeParameters(),
				JavaFactory.getInstance().getTypeVariableBuilder()
			);
	}

	public JClass getSuperclass() {
		return JavaFactory.getInstance().buildClass(javaClass.getSuperclass());
	}

	public JType getGenericSuperclass() {
		return JavaFactory.getInstance().buildType(javaClass.getGenericSuperclass());
	}

	public JPackage getPackage() {
		return JavaFactory.getInstance().buildPackage(javaClass.getPackage());
	}

	public JArray<? extends JClass> getInterfaces() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getInterfaces(), 
				JavaFactory.getInstance().getClassBuilder()
			);
	}

	public JArray<? extends JType> getGenericInterfaces() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getGenericInterfaces(), 
				JavaFactory.getInstance().getTypeBuilder()
			);
	}

	public JClass getComponentType() {
		return JavaFactory.getInstance().buildClass(javaClass.getComponentType());
	}

	public int getModifiers() {
		return javaClass.getModifiers();
	}

	public JArray<? extends JObject> getSigners() {
		return JavaFactory.getInstance().buildArray(javaClass.getSigners());
	}

	public JMethod getEnclosingMethod() {
		return JavaFactory.getInstance().buildMethod(javaClass.getEnclosingMethod());
	}

	public JConstructor getEnclosingConstructor() {
		return JavaFactory.getInstance().buildConstructor(javaClass.getEnclosingConstructor());
	}

	public JBehavior getEnclosingBehavior() {
		Method method=javaClass.getEnclosingMethod();
		if(method!=null) {
			return JavaFactory.getInstance().buildMethod(method);
		}
		Constructor constructor=javaClass.getEnclosingConstructor();
		if(constructor!=null) {
			return JavaFactory.getInstance().buildConstructor(constructor);
		}
		return null;
	}

	public JClass getDeclaringClass() {
		return JavaFactory.getInstance().buildClass(javaClass.getDeclaringClass());
	}

	public JClass getEnclosingClass() {
		return JavaFactory.getInstance().buildClass(javaClass.getEnclosingClass());
	}

	public String getSimpleName() {
		return javaClass.getSimpleName();
	}

	public String getCanonicalName() {
		return javaClass.getCanonicalName();
	}

	public boolean isAnonymousClass() {
		return javaClass.isAnonymousClass();
	}

	public boolean isLocalClass() {
		return javaClass.isLocalClass();
	}

	public boolean isMemberClass() {
		return javaClass.isMemberClass();
	}

	public JArray<? extends JClass> getClasses() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getClasses(), 
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JField> getFields() {		return JavaFactory.getInstance().buildArray(
				javaClass.getFields(), 
				JavaFactory.getInstance().getFieldBuilder()
			);	}

	public JArray<? extends JMethod> getMethods() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getMethods(), 
				JavaFactory.getInstance().getMethodBuilder()
			);	
	}

	public JArray<? extends JConstructor> getConstructors() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getConstructors(), 
				JavaFactory.getInstance().getConstructorBuilder()
			);	
	}

	private JArray<? extends JBehavior> behaviors=null;
	public JArray<? extends JBehavior> getBehaviors() {
		if(behaviors==null) {
			Method[] methods=javaClass.getMethods();
			Constructor[] constructors=javaClass.getConstructors();
			Member[] javaBehaviors=new Member[methods.length + constructors.length];
			for (int i = 0; i < methods.length; i++) {
				javaBehaviors[i]=methods[i];
			}
			for (int i = 0; i < constructors.length; i++) {
				javaBehaviors[methods.length + i]=constructors[i];
			}
			behaviors=JavaFactory.getInstance().buildArray(
					javaBehaviors, 
					JavaFactory.getInstance().getBehaviorBuilder()
				);	
		}
		return behaviors;
	}

	public JField getField(String name) {
		try {			return JavaFactory.getInstance().buildField(javaClass.getField(name));		} catch (SecurityException e) {			throw new InternalModelException(e);		} catch (NoSuchFieldException e) {			return null;		}
	}

	public JMethod getMethod(String name, JArray<? extends JClass> parameterTypes) {
		Class[] javaParameterTypes=new Class[parameterTypes.length()];
		for(int i=0; i<parameterTypes.length(); i++) {
			javaParameterTypes[i]=ClassImpl.getJavaClass(parameterTypes.at(i));
		}
		try {			return JavaFactory.getInstance().buildMethod(
					javaClass.getMethod(
							name, 
							javaParameterTypes)
						);		} catch (SecurityException e) {			throw new InternalModelException(e);		} catch (NoSuchMethodException e) {			return null;		}
	}

	public JConstructor getConstructor(JArray<? extends JClass> parameterTypes) {
		Class[] javaParameterTypes=new Class[parameterTypes.length()];
		for(int i=0; i<parameterTypes.length(); i++) {
			javaParameterTypes[i]=ClassImpl.getJavaClass(parameterTypes.at(i));
		}
		try {			return JavaFactory.getInstance().buildConstructor(javaClass.getConstructor(javaParameterTypes));		} catch (SecurityException e) {			throw new InternalModelException(e);		} catch (NoSuchMethodException e) {			return null;		}
	}

	public JBehavior getBehavior(String name, JArray<? extends JClass> parameterTypes) {
		if(name.equals(JConstructor.BEHAVIOR_NAME)) {
			return getConstructor(parameterTypes);
		} else {
			return getMethod(name, parameterTypes);
		}
	}

	public JArray<? extends JClass> getDeclaredClasses() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getDeclaredClasses(), 
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JField> getDeclaredFields() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getDeclaredFields(), 
				JavaFactory.getInstance().getFieldBuilder()
			);	
	}

	public JArray<? extends JMethod> getDeclaredMethods() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getDeclaredMethods(), 
				JavaFactory.getInstance().getMethodBuilder()
			);	
	}

	public JArray<? extends JConstructor> getDeclaredConstructors() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getDeclaredConstructors(), 
				JavaFactory.getInstance().getConstructorBuilder()
			);	
	}

	private JArray<? extends JBehavior> declaredBehaviors=null;
	public JArray<? extends JBehavior> getDeclaredBehaviors() {
		if(declaredBehaviors==null) {
			Method[] declaredMethods=javaClass.getDeclaredMethods();
			Constructor[] declaredConstructors=javaClass.getDeclaredConstructors();
			Member[] javaDeclaredBehaviors=new Member[declaredMethods.length + declaredConstructors.length];
			for (int i = 0; i < declaredMethods.length; i++) {
				javaDeclaredBehaviors[i]=declaredMethods[i];
			}
			for (int i = 0; i < declaredConstructors.length; i++) {
				javaDeclaredBehaviors[declaredMethods.length + i]=declaredConstructors[i];
			}
			declaredBehaviors=JavaFactory.getInstance().buildArray(
					javaDeclaredBehaviors, 
					JavaFactory.getInstance().getBehaviorBuilder()
				);	
		}
		return declaredBehaviors;
	}
	
	public JField getDeclaredField(String name) {
		try {			return JavaFactory.getInstance().buildField(javaClass.getDeclaredField(name));		} catch (SecurityException e) {			throw new InternalModelException(e);		} catch (NoSuchFieldException e) {			return null;		}
	}

	public JMethod getDeclaredMethod(String name, JArray<? extends JClass> parameterTypes) {
		Class[] javaParameterTypes=new Class[parameterTypes.length()];
		for(int i=0; i<parameterTypes.length(); i++) {
			javaParameterTypes[i]=ClassImpl.getJavaClass(parameterTypes.at(i));
		}
		try {			return JavaFactory.getInstance().buildMethod(javaClass.getDeclaredMethod(name, javaParameterTypes));		} catch (SecurityException e) {			throw new InternalModelException(e);		} catch (NoSuchMethodException e) {			return null;		}
	}

	public JConstructor getDeclaredConstructor(JArray<? extends JClass> parameterTypes) {
		Class[] javaParameterTypes=new Class[parameterTypes.length()];
		for(int i=0; i<parameterTypes.length(); i++) {
			javaParameterTypes[i]=ClassImpl.getJavaClass(parameterTypes.at(i));
		}
		try {			return JavaFactory.getInstance().buildConstructor(javaClass.getDeclaredConstructor(javaParameterTypes));		} catch (SecurityException e) {			throw new InternalModelException(e);		} catch (NoSuchMethodException e) {			return null;		}
	}

	public JBehavior getDeclaredBehavior(String name, JArray<? extends JClass> parameterTypes) {
		if(name.equals(JConstructor.BEHAVIOR_NAME)) {
			return getDeclaredConstructor(parameterTypes);
		} else {
			return getDeclaredMethod(name, parameterTypes);
		}
	}

	public JObject getResourceAsStream(String name) {
		return JavaFactory.getInstance().buildObject(javaClass.getResourceAsStream(name));
	}

	public JObject getResource(String name) {
		return JavaFactory.getInstance().buildObject(javaClass.getResource(name));
	}

	public JObject getProtectionDomain() {
		return JavaFactory.getInstance().buildObject(javaClass.getProtectionDomain());
	}

	public boolean desiredAssertionStatus() {
		return javaClass.desiredAssertionStatus();
	}

	public boolean isEnum() {
		return javaClass.isEnum();
	}

	public JArray<? extends JEnum> getEnumConstants() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getEnumConstants(), 
				JavaFactory.getInstance().getAnumBuilder()
			);	
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaClass.isAnnotationPresent(ClassImpl.getJavaClass(annotationType));
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(
				javaClass.getAnnotation(ClassImpl.getJavaClass(annotationType))
			);
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaClass.getDeclaredAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}	public JArray<? extends JClass> getSubclasses(boolean onlyDirect) {		throw new NotSupportedFeatureException();	}	public JSourceLocation getSourceLocation() {		throw new NotSupportedFeatureException();	}	public String getDescriptor() {		return Util.getClassDescriptor(this);	}
}
