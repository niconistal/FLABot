/**

import java.lang.reflect.Type;

	public boolean accepts(Object object) {
		return object instanceof Type;
	}

	public JType build(Object object) {
		return new TypeImpl((Type)object);
	}

}