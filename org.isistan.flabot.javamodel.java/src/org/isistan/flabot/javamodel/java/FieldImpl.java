/**

import java.lang.reflect.Field;

	private Field javaField;
	
	Field getJavaField() {
		return javaField;
	}
	
	static Field getJavaField(JField jField) {
		if(jField instanceof FieldImpl) {
			return ((FieldImpl)jField).getJavaField();
		} else {
			throw new MixedImplementationsException(jField);
		} 
	}
	
	FieldImpl(Field javaField) {
		super(javaField);
		this.javaField=javaField;
	}
	
	public void setAccessible(boolean flag) throws SecurityException {
		javaField.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaField.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaField.isAnnotationPresent(ClassImpl.getJavaClass(annotationType));
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(javaField.getAnnotation(ClassImpl.getJavaClass(annotationType)));
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaField.getAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaField.getDeclaredAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public boolean isEnumConstant() {
		return javaField.isEnumConstant();
	}

	public JClass getType() {
		return JavaFactory.getInstance().buildClass(javaField.getType());
	}

	public JType getGenericType() {
		return JavaFactory.getInstance().buildType(javaField.getGenericType());
	}

	public String toGenericString() {
		return javaField.toGenericString();
	}

	public JObject get(JObject obj) {
		try {
	}

	public void set(JObject obj, JObject value) {
		try {
	}

}