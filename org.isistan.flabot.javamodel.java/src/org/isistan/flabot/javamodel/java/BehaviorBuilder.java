/**

import java.lang.reflect.Constructor;

	public boolean accepts(Object object) {
		return object instanceof Method ||
			object instanceof Constructor;
	}

	public JBehavior build(Object object) {
		return null;
	}

}