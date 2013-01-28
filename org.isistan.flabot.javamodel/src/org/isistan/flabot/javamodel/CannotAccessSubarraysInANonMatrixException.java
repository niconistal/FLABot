/** * $Id: CannotAccessSubarraysInANonMatrixException.java,v 1.1 2006/02/14 04:34:54 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;

public class CannotAccessSubarraysInANonMatrixException extends JavaMetaModelException {
	private static final long serialVersionUID = 1L;
	
	private JArray array;

	public CannotAccessSubarraysInANonMatrixException(JArray array) {
		this.array=array;
	}
	
	public JArray getArray() {
		return array;
	}
	
	@Override	public String toString() {
		return "Cannot invoke the subArrayAt() method in an array that does not represent a matrix, use at() instead. Array: " + array;
	}
}
