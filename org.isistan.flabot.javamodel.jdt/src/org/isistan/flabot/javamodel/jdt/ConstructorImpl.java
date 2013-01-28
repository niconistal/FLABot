/**

import java.lang.reflect.InvocationTargetException;

	private IMethod jdtConstructor;
	
	IMethod getJDTConstructor() {
		return jdtConstructor;
	}
	
	static IMethod getJDTConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ConstructorImpl) {
			return ((ConstructorImpl)jConstructor).getJDTConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ConstructorImpl(IMethod jdtConstructor) {
		super(jdtConstructor);
		this.jdtConstructor=jdtConstructor;
	}
	
	@Override
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
	
		throw new NotSupportedFeatureException();
	}
}