/**

import java.lang.reflect.InvocationTargetException;
	private IMethod jdtMethod;
	
	IMethod getJDTMethod() {
		return jdtMethod;
	}
	
	static IMethod getJDTMethod(JMethod jMethod) {
		if(jMethod instanceof MethodImpl) {
			return ((MethodImpl)jMethod).getJDTMethod();
		} else {
			throw new MixedImplementationsException(jMethod);
		} 
	}
	
	MethodImpl(IMethod jdtMethod) {
		super(jdtMethod);
		this.jdtMethod=jdtMethod;
	}
	@Override
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