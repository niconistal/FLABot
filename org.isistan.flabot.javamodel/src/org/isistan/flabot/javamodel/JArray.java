/** * $Id: JArray.java,v 1.2 2006/02/14 04:34:54 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.javamodel;


public interface JArray<T extends JObject> extends
			JObject, Iterable<T> {
	public int length();
	public boolean isMatrix();
	public T at(int index);
	public JArray<? extends T> subArrayAt(int index);
}
