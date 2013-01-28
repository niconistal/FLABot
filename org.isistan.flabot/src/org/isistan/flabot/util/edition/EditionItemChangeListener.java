package org.isistan.flabot.util.edition;


/**
 * Listener for changes in edition items
 * @author $Author: franco $
 *
 */
public interface EditionItemChangeListener<T> {
	
	void changed(EditionItem<T> notifier, EditionItem<T> originator);
}
