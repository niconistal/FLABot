/**

import java.lang.reflect.AccessibleObject;
	public boolean accepts(Object object) {
		return object instanceof AccessibleObject;
	}

	public JAccessibleObject build(Object object) {
		return new AccessibleObjectImpl((AccessibleObject)object);
	}

}