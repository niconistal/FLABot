package org.isistan.flabot.util.edition.tab;

import java.util.Collection;

import org.isistan.flabot.util.edition.DataAdapter;

/**
 * This edition item shows subtabs with all tabs passed in the
 * contructor
 * @author $Author: dacostae $
 *
 */
public class EditionTabItemContainerImpl<F, T> extends EditionTabItemContainer<F, T> {

	public EditionTabItemContainerImpl(String text, String commandName, DataAdapter<F, T> dataAdapter, Collection<? extends EditionTabItem<T>> editionItems) {
		super(text, commandName, dataAdapter, editionItems);
	}

	public boolean accepts(F element) {
		return true;
	}

}
