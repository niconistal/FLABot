/**

import javassist.CtField;

	public boolean accepts(Object object) {
		return object instanceof CtField;
	}
	
	public JField build(Object object) {
		return new FieldImpl((CtField)object);
	}
}