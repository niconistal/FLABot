/** * $Id: JavaMetaModelException.java,v 1.2 2006/04/13 05:35:20 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;


public class JavaMetaModelException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public JavaMetaModelException() {
	
	}
	
	public JavaMetaModelException(Throwable e) {		super(e);	}		public JavaMetaModelException(String message) {		super(message);	}		public JavaMetaModelException(String message, Throwable cause) {		super(message, cause);	}		@Override	public String toString() {		String message=getMessage();		if(message==null) {			message="";		} else {			message=": " + message;		}		Throwable cause=getCause();		String causeString;		if(cause==null || cause==this) {			causeString="";		} else {			causeString=" [" + cause.toString() + "]";		}		return JavaMetaModelException.class.getName() + message + causeString;	}
}
