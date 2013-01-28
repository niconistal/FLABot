/** * $Id: WorkspacePrimitiveClassImpl.java,v 1.6 2006/05/09 00:50:16 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;

import org.eclipse.jdt.core.IJavaProject;import org.eclipse.jdt.core.IType;import org.eclipse.jdt.core.JavaModelException;import org.isistan.flabot.javamodel.InternalModelException;import org.isistan.flabot.javamodel.JAnnotation;import org.isistan.flabot.javamodel.JArray;import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JClassLoader;import org.isistan.flabot.javamodel.JConstructor;import org.isistan.flabot.javamodel.JEnum;import org.isistan.flabot.javamodel.JField;import org.isistan.flabot.javamodel.JMethod;import org.isistan.flabot.javamodel.JObject;import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.javamodel.JSourceLocation;import org.isistan.flabot.javamodel.JType;import org.isistan.flabot.javamodel.JTypeVariable;import org.isistan.flabot.javamodel.MixedImplementationsException;import org.isistan.flabot.javamodel.NotSupportedFeatureException;import org.isistan.flabot.javamodel.Util;import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;import org.isistan.flabot.util.enums.Enum;public class WorkspacePrimitiveClassImpl extends ObjectImpl implements JWorkspaceClass {	private static final Object[] EMPTY_ARRAY=new Object[0];		static class PrimitiveType extends Enum {		public static final PrimitiveType BOOLEAN=new PrimitiveType("BOOLEAN");		public static final PrimitiveType BYTE=new PrimitiveType("BYTE");		public static final PrimitiveType CHAR=new PrimitiveType("CHAR");		public static final PrimitiveType DOUBLE=new PrimitiveType("DOUBLE");		public static final PrimitiveType FLOAT=new PrimitiveType("FLOAT");		public static final PrimitiveType INT=new PrimitiveType("INT");		public static final PrimitiveType LONG=new PrimitiveType("LONG");		public static final PrimitiveType SHORT=new PrimitiveType("SHORT");		public static final PrimitiveType VOID=new PrimitiveType("VOID");		private PrimitiveType(String name) {			super(name);		}				static PrimitiveType get(String primitiveTypeName) {			PrimitiveType result=Enum.getOption(PrimitiveType.class, primitiveTypeName.toUpperCase());			return result;		}	}		static class PrimitiveClass {		private PrimitiveType primitive;		private int dimensions;		private IJavaProject project;		public PrimitiveClass(PrimitiveType primitive, int dimensions, IJavaProject project) {			this.primitive=primitive;			this.dimensions=dimensions;			this.project=project;		}				public PrimitiveType getPrimitive() {			return primitive;		}				public int getDimensions() {			return dimensions;		}				public IJavaProject getProject() {			return project;		}				static PrimitiveClass get(String primitiveClassName, IJavaProject project) {			int dimensions=0;			int nameEnd=primitiveClassName.indexOf('[');			PrimitiveType primitive;			if(nameEnd==-1) {				primitive=PrimitiveType.get(primitiveClassName);			} else {				String name=primitiveClassName.substring(0, nameEnd);				primitive=PrimitiveType.get(name);				if(primitive!=null) {					for(int i=nameEnd; i<primitiveClassName.length(); i++) {						if(primitiveClassName.charAt(i)=='[') {							dimensions++;						}					}				}			}			if(primitive==null) {				return null;			}			return new PrimitiveClass(primitive, dimensions, project);		}	}	
	private PrimitiveClass jdtPrimitiveClass;
	
	PrimitiveClass getJDTPrimitiveClass() {
		return jdtPrimitiveClass;
	}
	
	static PrimitiveClass getJDTPrimitiveClass(JClass jClass) {
		if(jClass instanceof WorkspacePrimitiveClassImpl) {
			return ((WorkspacePrimitiveClassImpl)jClass).getJDTPrimitiveClass();
		} else {
			throw new MixedImplementationsException(jClass);
		} 
	}
	
	WorkspacePrimitiveClassImpl(PrimitiveClass jdtPrimitiveClass) {		super(jdtPrimitiveClass);
		this.jdtPrimitiveClass=jdtPrimitiveClass;
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
		return false;
	}

	public boolean isArray() {
		return jdtPrimitiveClass.getDimensions()>0;
	}

	public boolean isPrimitive() {		return jdtPrimitiveClass.getDimensions()==0;	}

	public boolean isAnnotation() {
		return false;
	}

	public boolean isSynthetic() {
		return false;
	}
	private String name=null; 
	public String getName() {		if(name==null) {			StringBuffer buffer=new StringBuffer();			buffer.append(jdtPrimitiveClass.getPrimitive().getName().toLowerCase());			for(int i=0; i<jdtPrimitiveClass.getDimensions(); i++) {				buffer.append("[]");			}			name=buffer.toString();		}		return name;
	}
	
	public String getJNIName() {
		return Util.getJNIName(getName());
	}

	public JClassLoader getClassLoader() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		throw new NotSupportedFeatureException();
	}
		private JWorkspaceClass superclass=null;	public JWorkspaceClass getSuperclass() {		if(superclass==null) {			IType jdtSuperclass;			try {				jdtSuperclass = jdtPrimitiveClass.getProject().findType("java.lang.Object");			} catch (JavaModelException e) {				throw new InternalModelException(e);			}			superclass=JDTFactory.getInstance().buildClass(jdtSuperclass);		}		return superclass;	}	
	public JType getGenericSuperclass() {
		throw new NotSupportedFeatureException();
	}

	public JPackage getPackage() {
		return null;
	}
	
	public JArray<? extends JWorkspaceClass> interfaces=null;
	public JArray<? extends JWorkspaceClass> getInterfaces() {		if(interfaces==null) {
			interfaces=JDTFactory.getInstance().buildArray(EMPTY_ARRAY,						JDTFactory.getInstance().getClassBuilder());		}		return interfaces;
	}

	public JArray<? extends JType> getGenericInterfaces() {
		throw new NotSupportedFeatureException();
	}
	private JClass componentType;	private boolean componentTypeCalculated=false;
	public JClass getComponentType() {		if(!componentTypeCalculated) {			if(jdtPrimitiveClass.getDimensions()==0) {				componentType=null;				componentTypeCalculated=true;			} else {				componentTypeCalculated=true;				PrimitiveClass jdtComponentType=new PrimitiveClass(jdtPrimitiveClass.getPrimitive(),						jdtPrimitiveClass.getDimensions()-1,						jdtPrimitiveClass.getProject());				componentType=JDTFactory.getInstance().buildClass(jdtComponentType);				componentTypeCalculated=true;			}		}		return componentType;
	}

	public int getModifiers() {		if(jdtPrimitiveClass.getDimensions()==0) {			return int.class.getModifiers();		} else {			return int[].class.getModifiers();		}
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

	public JBehavior getEnclosingBehavior() {		return null;
	}

	public JClass getDeclaringClass() {		return null;
		
	}

	public JClass getEnclosingClass() {
		throw new NotSupportedFeatureException();
	}

	public String getSimpleName() {
		return getName();
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
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JMethod> getMethods() throws SecurityException {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JConstructor> getConstructors() throws SecurityException {
		throw new NotSupportedFeatureException();	}
	public JArray<? extends JBehavior> getBehaviors() throws SecurityException {
		throw new NotSupportedFeatureException();	}

	public JField getField(String name) {
		throw new NotSupportedFeatureException();
	}

	public JMethod getMethod(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();	}

	public JConstructor getConstructor(JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();	}

	public JBehavior getBehavior(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JWorkspaceClass> getDeclaredClasses() {
				return JDTFactory.getInstance().buildArray(				EMPTY_ARRAY,				JDTFactory.getInstance().getClassBuilder()				);	}	
	public JArray<? extends JField> getDeclaredFields() {
		throw new NotSupportedFeatureException();
	}
	public JArray<? extends JMethod> getDeclaredMethods() throws SecurityException {
		return JDTFactory.getInstance().buildArray(				EMPTY_ARRAY,				JDTFactory.getInstance().getMethodBuilder()				);
	}

	public JArray<? extends JConstructor> getDeclaredConstructors()
			throws SecurityException {
		return JDTFactory.getInstance().buildArray(				EMPTY_ARRAY,				JDTFactory.getInstance().getConstructorBuilder()				);
	}

	public JArray<? extends JBehavior> getDeclaredBehaviors() throws SecurityException {
		return JDTFactory.getInstance().buildArray(				EMPTY_ARRAY,				JDTFactory.getInstance().getBehaviorBuilder()				);	}
	
	public JField getDeclaredField(String name) {
		throw new NotSupportedFeatureException();
	}

	public JMethod getDeclaredMethod(String name, JArray<? extends JClass> parameterTypes) {
		return null;
	}

	public JConstructor getDeclaredConstructor(JArray<? extends JClass> parameterTypes) {
		return null;
	}

	public JBehavior getDeclaredBehavior(String name, JArray<? extends JClass> parameterTypes) {
		return null;
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

	public boolean isEnum() {		return false;
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
	}	public JArray<? extends JWorkspaceClass> subclasses=null;	public JArray<? extends JWorkspaceClass> getSubclasses(boolean onlyDirect) {		return JDTFactory.getInstance().buildArray(EMPTY_ARRAY,				JDTFactory.getInstance().getClassBuilder());	}	public JJavaFile getJavaFile() {		return null;	}	public JSourceLocation getSourceLocation() {		return JSourceLocation.UNKNOWN;	}		public String getDescriptor() {		return Util.getClassDescriptor(this);	}
}
