/**

import javassist.CtConstructor;

	public boolean accepts(Object object) {
		return object instanceof CtConstructor;
	}
	public JConstructor build(Object object) {
		return new ConstructorImpl((CtConstructor)object);
	}



}