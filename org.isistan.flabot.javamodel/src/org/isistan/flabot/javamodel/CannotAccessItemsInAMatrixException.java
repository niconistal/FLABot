/** * $Id: CannotAccessItemsInAMatrixException.java,v 1.2 2006/02/03 21:03:05 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public class CannotAccessItemsInAMatrixException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;

	
	private JArray array;

	public CannotAccessItemsInAMatrixException(JArray array) {
		this.array=array;
	}
	
	public JArray getArray() {
		return array;
	}
	
	@Override	public String toString() {
		return "Cannot invoke the at() method in an array that represents a matrix, use subArrayAt() instead. Array: " + array;
	}
	
	
}
