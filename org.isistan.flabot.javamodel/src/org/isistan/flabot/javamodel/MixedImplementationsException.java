/** * $Id: MixedImplementationsException.java,v 1.2 2006/02/03 21:03:05 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public class MixedImplementationsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private JObject externalObject;
	
	public MixedImplementationsException(JObject externalObject) {
		this.externalObject=externalObject;
	}

	public JObject getExternalObject() {
		return externalObject;
	}

	@Override	public String toString() {
		return "The operation does not allow the use of object mirrors from other implementations. External object: " + externalObject;
	}
}
