/**

import javassist.CtMethod;

	public boolean accepts(Object object) {
		return object instanceof CtMethod;
	}

	public JMethod build(Object object) {
		return new MethodImpl((CtMethod)object);
	}


}