/**

import javassist.CtBehavior;

	private CtBehavior javassistBehavior;
	
	CtBehavior getJavassistBehavior() {
		return javassistBehavior;
	}
	
	static CtBehavior getJavassistMember(JBehavior jBehavior) {
		if(jBehavior instanceof BehaviorImpl) {
			return ((BehaviorImpl)jBehavior).getJavassistBehavior();
		} else {
			throw new MixedImplementationsException(jBehavior);
		} 
	}
	
	BehaviorImpl(CtBehavior javassistBehavior) {
		super(javassistBehavior);
		this.javassistBehavior=javassistBehavior;
	}

	public JArray<? extends JClass> getParameterTypes() {
		try {
			return JavassistFactory.getInstance().buildArray(
					javassistBehavior.getParameterTypes(),
					JavassistFactory.getInstance().getClassBuilder()
				);
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public JArray<? extends JType> getGenericParameterTypes() {
		throw new NotSupportedFeatureException();
	}

	public JArray<? extends JClass> getExceptionTypes() {
		try {
			return JavassistFactory.getInstance().buildArray(
					javassistBehavior.getExceptionTypes(), 
					JavassistFactory.getInstance().getClassBuilder()
				);
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
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

	public JArray<? extends JAnnotation>/*2 dimensions*/ getParameterAnnotations() {
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