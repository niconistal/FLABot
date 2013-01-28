/**

import java.lang.reflect.InvocationTargetException;

	private CtConstructor javassistConstructor;
	
	CtConstructor getJavassistConstructor() {
		return javassistConstructor;
	}
	
	static CtConstructor getJavassistConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ConstructorImpl) {
			return ((ConstructorImpl)jConstructor).getJavassistConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ConstructorImpl(CtConstructor javassistConstructor) {
		super(javassistConstructor);
		this.javassistConstructor=javassistConstructor;
	}
	
	@Override
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
		throw new NotSupportedFeatureException();
	}
}