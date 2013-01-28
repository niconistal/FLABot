package org.isistan.flabot.util.extension;

public class NoMatchingConstructorFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	
	private Class<?> clazz;

	public NoMatchingConstructorFoundException(Class<?> clazz) {
		this.clazz=clazz;
	}
	
	@Override
	public String toString() {
		return "No matching constructor found for class " + clazz.getName();
	}

}
