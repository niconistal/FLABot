/**

import java.lang.reflect.TypeVariable;

	public boolean accepts(Object object) {
		return object instanceof TypeVariable;
	}

	public JTypeVariable build(Object object) {
		return new TypeVariableImpl((TypeVariable)object);
	}



}