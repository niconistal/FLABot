package org.isistan.flabot.util.edition;

import java.util.LinkedList;
import java.util.List;

public abstract class AbstractEditionItem<T> implements EditionItem<T> {
	private List<EditionItemChangeListener<T>> listeners=new LinkedList<EditionItemChangeListener<T>>();

	public void dispose() {
		
	}
	
	protected void notifyChange() {
		notifyChange(this);
	}

	protected void notifyChange(EditionItem originator) {
		for (EditionItemChangeListener listener : getListeners()) {
			listener.changed(this, originator);
		}
	}
	
	public boolean addListener(EditionItemChangeListener<T> listener) {
		if(listeners.contains(listener))
			return false;
		listeners.add(listener);
		return true;
	}

	public boolean removeListener(EditionItemChangeListener<T> listener) {
		return listeners.remove(listener);
	}

	public EditionItemChangeListener<T>[] getListeners() {
		return listeners.toArray(new EditionItemChangeListener[listeners.size()]);
	}
}
