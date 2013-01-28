/** * $Id: UnresolvedTypeException.java,v 1.2 2006/02/03 21:03:10 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel.jdt;


public class UnresolvedTypeException extends Exception {
	private String whereTypeName;
	private String unresolvedTypeName;

	public UnresolvedTypeException(String whereTypeName, String unresolvedTypeName) {
		this.whereTypeName=whereTypeName;
		this.unresolvedTypeName=unresolvedTypeName;
	}

	private static final long serialVersionUID = 1L;

	
	@Override	public String toString() {
		return "Type could not be resolved: " + unresolvedTypeName + " (referenced from " + whereTypeName + ")";
	}
}
