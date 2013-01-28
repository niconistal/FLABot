/**

import java.lang.ref.WeakReference;
	private static final int BEHAVIOR_CHANGE_FLAG=0;
	private IMethod jdtBehavior;
	
	IMethod getJDTBehavior() {
		return jdtBehavior;
	}
	
	static IMethod getJDTBehavior(JBehavior jBehavior) {
		if(jBehavior instanceof BehaviorImpl) {
			return ((BehaviorImpl)jBehavior).getJDTBehavior();
		} else {
			throw new MixedImplementationsException(jBehavior);
		} 
	}
	
	BehaviorImpl(IMethod jdtBehavior) {
		super(jdtBehavior);
		this.jdtBehavior=jdtBehavior;

	public JArray<? extends JWorkspaceClass> getParameterTypes() {

	public JArray<? extends JType> getGenericParameterTypes() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JWorkspaceClass> getExceptionTypes() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JType> getGenericExceptionTypes() {
		throw new NotSupportedFeatureException();
	}

	public String toGenericString() {
		throw new NotSupportedFeatureException();
	}

	public boolean isVarArgs() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JAnnotation> getParameterAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public void setAccessible(boolean flag) throws SecurityException {
		throw new NotSupportedFeatureException();
	}

	public boolean isAccessible() {
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

	public JArray<? extends JTypeVariable> getTypeParameters() {
		throw new NotSupportedFeatureException();
	}

	private String signature=null;

}