/**

import org.isistan.flabot.javamodel.JThrowable;

	public boolean accepts(Object object) {
		return object instanceof Throwable;
	}
	
	public JThrowable build(Object object) {
		return new ThrowableImpl((Throwable)object);
	}



}