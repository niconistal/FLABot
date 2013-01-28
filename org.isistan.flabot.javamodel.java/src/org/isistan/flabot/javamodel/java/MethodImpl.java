/**

import java.lang.reflect.InvocationTargetException;

	private Method javaMethod;
	
	Method getJavaMethod() {
		return javaMethod;
	}
	
	static Method getJavaMethod(JMethod jMethod) {
		if(jMethod instanceof MethodImpl) {
			return ((MethodImpl)jMethod).getJavaMethod();
		} else {
			throw new MixedImplementationsException(jMethod);
		} 
	}
	
	MethodImpl(Method javaMethod) {
		super(javaMethod);
		this.javaMethod=javaMethod;
	}


	public JArray<? extends JClass> getParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getParameterTypes(),
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getGenericParameterTypes(),
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public JArray<? extends JClass> getExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getExceptionTypes(), 
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getGenericExceptionTypes(), 
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public String toGenericString() {
		return javaMethod.toGenericString();
	}

	public boolean isVarArgs() {
		return javaMethod.isVarArgs();
	}

	public JArray<? extends JAnnotation>/*2 dimensions*/ getParameterAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getParameterAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public void setAccessible(boolean flag) throws SecurityException {
		javaMethod.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaMethod.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaMethod.isAccessible();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(javaMethod.getAnnotation(ClassImpl.getJavaClass(annotationType)));
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getDeclaredAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		return JavaFactory.getInstance().buildArray(
				javaMethod.getTypeParameters(), 
				JavaFactory.getInstance().getTypeVariableBuilder()
			);	
	}

	public JClass getType() {
		return JavaFactory.getInstance().buildClass(javaMethod.getReturnType());
	}

	public JType getGenericReturnType() {
		return JavaFactory.getInstance().buildType(javaMethod.getGenericReturnType());
	}

	public JObject invoke(JObject object, JArray<? extends JObject> arguments) {
		Object[] javaArguments=new Object[arguments.length()];
		for(int i=0; i<arguments.length(); i++) {
			javaArguments[i]=ObjectImpl.getJavaObject(arguments.at(i));
		}
		Object javaObject=ObjectImpl.getJavaObject(object);
		try {
					javaMethod.invoke(javaObject, javaArguments)
				);
	}

	public boolean isBridge() {
		return javaMethod.isBridge();
	}

	public JObject getDefaultValue() {
		return JavaFactory.getInstance().buildObject(javaMethod.getDefaultValue());
	}
}