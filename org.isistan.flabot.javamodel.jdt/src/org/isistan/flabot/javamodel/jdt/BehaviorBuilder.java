/**

import org.eclipse.jdt.core.IMethod;

	public boolean accepts(Object object) {
		return object instanceof IMethod || object instanceof JDTImplicitConstructor;
	}

	public JBehavior build(Object object) {
		//can't do anything behavior is ficticious for jdt, only method exists
		return null;
	}

}