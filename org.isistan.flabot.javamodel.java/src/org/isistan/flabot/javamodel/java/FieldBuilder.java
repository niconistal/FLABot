/**

import java.lang.reflect.Field;

	public boolean accepts(Object object) {
		return object instanceof Field;
	}
	
	public JField build(Object object) {
		return new FieldImpl((Field)object);
	}
}