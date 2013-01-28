/**

import java.lang.reflect.InvocationTargetException;

	private CtMethod javassistMethod;
	
	CtMethod getJavassistMethod() {
		return javassistMethod;
	}
	
	static CtMethod getJavassistMethod(JMethod jMethod) {
		if(jMethod instanceof MethodImpl) {
			return ((MethodImpl)jMethod).getJavassistMethod();
		} else {
			throw new MixedImplementationsException(jMethod);
		} 
	}
	
	MethodImpl(CtMethod javassistMethod) {
		super(javassistMethod);
		this.javassistMethod=javassistMethod;
	}


	public JClass getType() {
		try {
			return JavassistFactory.getInstance().buildClass(javassistMethod.getReturnType());
		} catch (NotFoundException e) {
			throw new InternalModelException(e);
		}
	}

	public JType getGenericReturnType() {
		throw new NotSupportedFeatureException();
	}

	public JObject invoke(JObject object, JArray<? extends JObject> arguments) {
		throw new NotSupportedFeatureException();
	}

	public boolean isBridge() {
		throw new NotSupportedFeatureException();
	}

	public JObject getDefaultValue() {
		throw new NotSupportedFeatureException();
	}
}