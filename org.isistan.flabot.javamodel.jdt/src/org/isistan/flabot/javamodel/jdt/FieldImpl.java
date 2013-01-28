/**

import org.eclipse.jdt.core.IField;

	private IField jdtField;
	
	IField getJDTField() {
		return jdtField;
	}
	
	static IField getJDTField(JField jField) {
		if(jField instanceof FieldImpl) {
			return ((FieldImpl)jField).getJDTField();
		} else {
			throw new MixedImplementationsException(jField);
		} 
	}
	
	FieldImpl(IField jdtField) {
		super(jdtField);
		this.jdtField=jdtField;
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
		try {
			return jdtField.isEnumConstant();
		} catch (JavaModelException e) {
			throw new InternalModelException(e);
		}
	}

	@Override
		return JDTFactory.getInstance().buildClass(jdtField.getDeclaringType());
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