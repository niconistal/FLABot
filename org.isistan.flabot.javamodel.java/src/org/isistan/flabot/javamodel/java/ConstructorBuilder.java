/**

import java.lang.reflect.Constructor;

	public boolean accepts(Object object) {
		return object instanceof Constructor;
	}
	public JConstructor build(Object object) {
		return new ConstructorImpl((Constructor)object);
	}



}