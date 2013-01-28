/**

import java.lang.ref.WeakReference;
	private static final int CLASS_CHANGE_FLAG=0;
	private IType jdtClass;
	
	IType getJDTClass() {
		return jdtClass;
	}
	
	static IType getJDTClass(JClass jClass) {
		if(jClass instanceof WorkspaceClassImpl) {
			return ((WorkspaceClassImpl)jClass).getJDTClass();
		} else {
			throw new MixedImplementationsException(jClass);
		} 
	}
	
	WorkspaceClassImpl(IType jdtClass) {
		this.jdtClass=jdtClass;
		JavaModelListener.getInstance().add(this, CLASS_CHANGE_FLAG, jdtClass,
	
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
		try {
			return jdtClass.isInterface();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public boolean isArray() {
		throw new NotSupportedFeatureException();
	}

	public boolean isPrimitive() {

	public boolean isAnnotation() {
		try {
			return jdtClass.isAnnotation();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public boolean isSynthetic() {
		try {
			return Flags.isSynthetic(jdtClass.getFlags());
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	public String getName() {
				name=fqname;
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

	public JWorkspaceClass getSuperclass() {
	public JType getGenericSuperclass() {
		throw new NotSupportedFeatureException();
	}

	public JPackage getPackage() {
		return JDTFactory.getInstance().buildPackage(jdtClass.getPackageFragment());
	}
	
	private JArray<? extends JWorkspaceClass> interfaces=null;
	public JArray<? extends JWorkspaceClass> getInterfaces() {
			try {
	}

	public JArray<? extends JType> getGenericInterfaces() {
		throw new NotSupportedFeatureException();
	}

	public JClass getComponentType() {
		throw new NotSupportedFeatureException();
	}

	public int getModifiers() {
		try {
			int flags=jdtClass.getFlags();
			int modifiers=0;
			if(Flags.isAbstract(flags))
				modifiers=modifiers | Modifier.ABSTRACT;
			if(Flags.isFinal(flags))
				modifiers=modifiers | Modifier.FINAL;
			if(Flags.isInterface(flags))
				modifiers=modifiers | Modifier.INTERFACE;
			if(Flags.isNative(flags))
				modifiers=modifiers | Modifier.NATIVE;
			if(Flags.isPrivate(flags))
				modifiers=modifiers | Modifier.PRIVATE;
			if(Flags.isProtected(flags))
				modifiers=modifiers | Modifier.PROTECTED;
			if(Flags.isPublic(flags))
				modifiers=modifiers | Modifier.PUBLIC;
			if(Flags.isStatic(flags))
				modifiers=modifiers | Modifier.STATIC;
			if(Flags.isStrictfp(flags))
				modifiers=modifiers | Modifier.STRICT;
			if(Flags.isSynchronized(flags))
				modifiers=modifiers | Modifier.SYNCHRONIZED;
			if(Flags.isTransient(flags))
				modifiers=modifiers | Modifier.TRANSIENT;
			if(Flags.isVolatile(flags))
				modifiers=modifiers | Modifier.VOLATILE;
			return modifiers;
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
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

	public JClass getDeclaringClass() {
		
	}

	public JClass getEnclosingClass() {
		throw new NotSupportedFeatureException();
	}

	public String getSimpleName() {
		return jdtClass.getElementName();
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
	}

	public JArray<? extends JBehavior> getBehaviors() throws SecurityException {
		throw new NotSupportedFeatureException();

	public JField getField(String name) {
		throw new NotSupportedFeatureException();
	}

	public JMethod getMethod(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}

	public JConstructor getConstructor(JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}

	public JBehavior getBehavior(String name, JArray<? extends JClass> parameterTypes) {
		throw new NotSupportedFeatureException();
	}
	JArray<? extends JWorkspaceClass> declaredClasses=null;
	public JArray<? extends JWorkspaceClass> getDeclaredClasses() {
			List<IType> jdtDeclaredClasses=new LinkedList<IType>();

	public JArray<? extends JField> getDeclaredFields() {
		throw new NotSupportedFeatureException();
	}

	private JArray<? extends JMethod> declaredMethods=null;
		if(declaredMethods==null) {

	private JArray<? extends JConstructor> declaredConstructors=null;
		if(declaredConstructors==null) {
	}

	public JArray<? extends JBehavior> getDeclaredBehaviors() throws SecurityException {
			try {
	}
	
	public JField getDeclaredField(String name) {
		throw new NotSupportedFeatureException();
	}

	public JMethod getDeclaredMethod(String name, JArray<? extends JClass> parameterTypes) {
		return (JMethod) getDeclaredBehavior(name, parameterTypes);

	public JConstructor getDeclaredConstructor(JArray<? extends JClass> parameterTypes) {
		return (JConstructor) getDeclaredBehavior(JConstructor.BEHAVIOR_NAME, parameterTypes);
	}

	public JBehavior getDeclaredBehavior(String name, JArray<? extends JClass> parameterTypes) {
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
		try {
			return jdtClass.isEnum();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
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