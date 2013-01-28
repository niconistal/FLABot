package org.isistan.flabot.util.edition.tab;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.util.edition.EditionItem;

/**
 * Implementation of EditionItem that in which each edition item is represented
 * by a tab and compositeEditionItems are represented as tab folders.
 * @author da Costa Cambio
 *
 * @param <T>
 */
public abstract interface EditionTabItem<T> extends EditionItem<T> {

	/**
	 * initializes the edition item
	 * @param tabFolder
	 * @param tabItem
	 * @param element
	 */
	void initialize(TabFolder tabFolder, TabItem tabItem, T element);
	
	/**
	 * Returns the control contained in the tab
	 * @return
	 */
	Control getControl();
}
