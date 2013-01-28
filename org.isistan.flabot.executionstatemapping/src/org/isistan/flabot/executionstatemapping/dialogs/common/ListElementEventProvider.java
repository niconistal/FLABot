package org.isistan.flabot.executionstatemapping.dialogs.common;

public interface ListElementEventProvider<T> {

	public T onAddElement();
	
	public T onEditElement(T element);
	
	public void onRemoveElement(T element);
}
