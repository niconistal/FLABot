/** * $Id: InternalModelException.java,v 1.2 2006/02/03 21:03:05 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public class InternalModelException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;

	public InternalModelException(Throwable e) {
		super(e);
	}
	
	@Override	public String toString() {
		return "Exception caused by the particular underlying model [" + getCause().getClass().getName() + "]: " + getCause().toString();
	}

}
