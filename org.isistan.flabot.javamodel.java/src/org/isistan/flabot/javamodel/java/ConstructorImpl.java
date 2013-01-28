/**

import java.lang.reflect.Constructor;

	private Constructor javaConstructor;
	
	Constructor getJavaConstructor() {
		return javaConstructor;
	}
	
	static Constructor getJavaConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ConstructorImpl) {
			return ((ConstructorImpl)jConstructor).getJavaConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ConstructorImpl(Constructor javaConstructor) {
		super(javaConstructor);
		this.javaConstructor=javaConstructor;
	}
	
	@Override
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
		Object[] javaArguments=new Object[arguments.length()];
		for(int i=0; i<arguments.length(); i++) {
			javaArguments[i]=ObjectImpl.getJavaObject(arguments.at(i));
		}
		try {
	}

	public JArray<? extends JClass> getParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getParameterTypes(), 
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericParameterTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getGenericParameterTypes(),
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public JArray<? extends JClass> getExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getExceptionTypes(),
				JavaFactory.getInstance().getClassBuilder()
			);	
	}

	public JArray<? extends JType> getGenericExceptionTypes() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getGenericExceptionTypes(),
				JavaFactory.getInstance().getTypeBuilder()
			);	
	}

	public String toGenericString() {
		return javaConstructor.toGenericString();
	}

	public boolean isVarArgs() {
		return javaConstructor.isVarArgs();
	}

	public JArray<? extends JAnnotation>/*2 dimensions*/ getParameterAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getParameterAnnotations(), 
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public void setAccessible(boolean flag) throws SecurityException {
		javaConstructor.setAccessible(flag);
	}

	public boolean isAccessible() {
		return javaConstructor.isAccessible();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		return javaConstructor.isAnnotationPresent(ClassImpl.getJavaClass(annotationType));
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		return JavaFactory.getInstance().buildAnnotation(javaConstructor.getAnnotation(ClassImpl.getJavaClass(annotationType)));
	}

	public JArray<? extends JAnnotation> getAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JAnnotation> getDeclaredAnnotations() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getDeclaredAnnotations(),
				JavaFactory.getInstance().getAnnotationBuilder()
			);	
	}

	public JArray<? extends JTypeVariable> getTypeParameters() {
		return JavaFactory.getInstance().buildArray(
				javaConstructor.getTypeParameters(), 
				JavaFactory.getInstance().getTypeVariableBuilder()
			);	
	}

	public JClass getType() {