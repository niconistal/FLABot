package org.isistan.flabot.util.edition;

public class IdentityDataAdapter<T> implements DataAdapter<T, T> {

	public T adapt(T data) {
		return data;
	}

}
