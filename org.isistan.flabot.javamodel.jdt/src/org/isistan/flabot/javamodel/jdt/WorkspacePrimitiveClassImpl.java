/**

import org.eclipse.jdt.core.IJavaProject;
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
	
	WorkspacePrimitiveClassImpl(PrimitiveClass jdtPrimitiveClass) {
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

	public boolean isPrimitive() {

	public boolean isAnnotation() {
		return false;
	}

	public boolean isSynthetic() {
		return false;
	}

	public String getName() {
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
	
	public JType getGenericSuperclass() {
		throw new NotSupportedFeatureException();
	}

	public JPackage getPackage() {
		return null;
	}
	
	public JArray<? extends JWorkspaceClass> interfaces=null;
	public JArray<? extends JWorkspaceClass> getInterfaces() {
			interfaces=JDTFactory.getInstance().buildArray(EMPTY_ARRAY,
	}

	public JArray<? extends JType> getGenericInterfaces() {
		throw new NotSupportedFeatureException();
	}

	public JClass getComponentType() {
	}

	public int getModifiers() {
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
	}

	public JClass getDeclaringClass() {
		
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
		throw new NotSupportedFeatureException();

		throw new NotSupportedFeatureException();

	public JField getField(String name) {
		throw new NotSupportedFeatureException();
	}

	public JMethod getMethod(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();

	public JConstructor getConstructor(JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();

	public JBehavior getBehavior(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JWorkspaceClass> getDeclaredClasses() {
		
	public JArray<? extends JField> getDeclaredFields() {
		throw new NotSupportedFeatureException();
	}

		return JDTFactory.getInstance().buildArray(
	}

	public JArray<? extends JConstructor> getDeclaredConstructors()
			throws SecurityException {
		return JDTFactory.getInstance().buildArray(
	}

	public JArray<? extends JBehavior> getDeclaredBehaviors() throws SecurityException {
		return JDTFactory.getInstance().buildArray(
	
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

	public boolean isEnum() {
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
	}
}