/**

import java.lang.reflect.InvocationTargetException;
	private static Object[] EMPTY_ARRAY=new Object[0];
	private JDTImplicitConstructor jdtImplicitConstructor;
	
	JDTImplicitConstructor getJDTImplicitConstructor() {
		return jdtImplicitConstructor;
	}
	
	static JDTImplicitConstructor getJDTImplicitConstructor(JConstructor jConstructor) {
		if(jConstructor instanceof ImplicitConstructorImpl) {
			return ((ImplicitConstructorImpl)jConstructor).getJDTImplicitConstructor();
		} else {
			throw new MixedImplementationsException(jConstructor);
		} 
	}
	
	ImplicitConstructorImpl(JDTImplicitConstructor jdtImplicitConstructor) {
		super(jdtImplicitConstructor);
		this.jdtImplicitConstructor=jdtImplicitConstructor;
	}
	
		return JConstructor.BEHAVIOR_NAME;
	}
	
	public JObject newInstance(JArray<? extends JObject> arguments) {
		throw new NotSupportedFeatureException();
	}
}