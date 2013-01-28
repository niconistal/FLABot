/** * $Id: NotSupportedFeatureException.java,v 1.2 2006/02/03 21:03:05 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public class NotSupportedFeatureException extends JavaMetaModelException {

	private static final long serialVersionUID = 1L;

	@Override	public String toString() {
		return "The operation is not supported by the underlying model.";
	}
	
}
