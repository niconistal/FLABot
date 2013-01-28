package org.isistan.flabot.javamodel.java;

import org.isistan.flabot.javamodel.JThrowable;
import org.isistan.flabot.javamodel.MixedImplementationsException;

public class ThrowableImpl extends ObjectImpl implements JThrowable {

	private Throwable javaThrowable;
	
	Throwable getJavaThrowable() {
		return javaThrowable;
	}
	
	static Throwable getJavaThrowable(JThrowable jThrowable) {
		if(jThrowable instanceof ThrowableImpl) {
			return ((ThrowableImpl)jThrowable).getJavaThrowable();
		} else {
			throw new MixedImplementationsException(jThrowable);
		} 
	}
	
	ThrowableImpl(Throwable javaThrowable) {
		super(javaThrowable);
		this.javaThrowable=javaThrowable;
	}
	
	public String getMessage() {
		return javaThrowable.getMessage();
	}

	public JThrowable getCause() {
		return JavaFactory.getInstance().buildThrowable(javaThrowable.getCause());
	}

}
