/**

import java.lang.reflect.Method;

	public boolean accepts(Object object) {
		return object instanceof Method;
	}

	public JMethod build(Object object) {
		return new MethodImpl((Method)object);
	}


}