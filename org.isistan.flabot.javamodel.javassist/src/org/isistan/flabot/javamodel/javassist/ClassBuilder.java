/**

import javassist.CtClass;

	public boolean accepts(Object object) {
		return object instanceof CtClass;
	}
	
	public JClass build(Object object) {
		return new ClassImpl((CtClass)object);
	}

}