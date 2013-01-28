/**

import java.lang.reflect.Type;

	private Type javaType;
	
	Type getJavaType() {
		return javaType;
	}
	
	static Type getJavaType(JType jType) {
		if(jType instanceof TypeImpl) {
			return ((TypeImpl)jType).getJavaType();
		} else {
			throw new MixedImplementationsException(jType);
		} 
	}
	
	TypeImpl(Type javaType) {
		super(javaType);
		this.javaType=javaType;
	}

}