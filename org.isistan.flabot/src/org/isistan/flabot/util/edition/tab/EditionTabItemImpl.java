package org.isistan.flabot.util.edition.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.AbstractEditionItem;

/**
 * Implementation of EditionItem that in which each edition item is represented
 * by a tab and compositeEditionItems are represented as tab folders.
 * @author da Costa Cambio
 *
 * @param <T>
 */
public abstract class EditionTabItemImpl<T> extends AbstractEditionItem<T> implements
	EditionTabItem<T> {

	TabItem tabItem=null;
	public void initialize(Composite container, T element) {
		if(!(container instanceof TabFolder)) {
			throw new IllegalArgumentException(Messages.getString("org.isistan.flabot.util.edition.tab.EditionTabItemImpl.containerMustBeTabFolder")); //$NON-NLS-1$
		}
		TabFolder tabFolder=(TabFolder)container;
		tabItem = new TabItem(tabFolder, SWT.NONE);
		initialize(tabFolder, tabItem, element);
		tabItem.setControl(getControl());	
	}
	
	public TabItem getTabItem() {
		return tabItem;
	}

	/**
	 * initializes the edition item
	 * @param tabFolder
	 * @param tabItem
	 * @param element
	 */
	public abstract void initialize(TabFolder tabFolder, TabItem tabItem, T element);

	/**
	 * Returns the control contained in the tab
	 * @return
	 */
	public abstract Control getControl();
	
}
