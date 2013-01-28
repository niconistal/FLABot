/** * $Id: ObjectClassOutOfBoundsException.java,v 1.2 2006/02/03 21:03:05 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public class ObjectClassOutOfBoundsException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;
	
	private Object object;
	
	public ObjectClassOutOfBoundsException(Object object) {
		this.object=object;
	}

	public Object getObject() {
		return object;
	}

	@Override	public String toString() {
		return "The object mirror could not be built. Object class: " + object.getClass();
	}
}
