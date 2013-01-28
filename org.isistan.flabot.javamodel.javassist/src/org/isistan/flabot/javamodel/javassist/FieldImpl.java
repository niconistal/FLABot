/**

import javassist.CtField;

	private CtField javassistField;
	
	CtField getJavassistField() {
		return javassistField;
	}
	
	static CtField getJavassistField(JField jField) {
		if(jField instanceof FieldImpl) {
			return ((FieldImpl)jField).getJavassistField();
		} else {
			throw new MixedImplementationsException(jField);
		} 
	}
	
	FieldImpl(CtField javassistField) {
		super(javassistField);
		this.javassistField=javassistField;
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

	public boolean isEnumConstant() {
		throw new NotSupportedFeatureException();
	}

	public JClass getType() {
		try {
			return JavassistFactory.getInstance().buildClass(javassistField.getType());
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public JType getGenericType() {
		throw new NotSupportedFeatureException();
	}

	public String toGenericString() {
		throw new NotSupportedFeatureException();
	}

	public JObject get(JObject obj) {
		throw new NotSupportedFeatureException();
	}

	public void set(JObject obj, JObject value) {
		throw new NotSupportedFeatureException();
	}

	public String getDescriptor() {
}