package org.isistan.flabot.util.edition.tab;

import java.util.Collection;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.util.edition.DataAdapter;
import org.isistan.flabot.util.edition.EditionItem;
import org.isistan.flabot.util.edition.EditionItemChangeListener;
import org.isistan.flabot.util.edition.EditionItemStatus;

/**
 * This edition item shows subtabs with all tabs passed in the
 * contructor
 * @author $Author: dacostae $
 *
 */
public abstract class EditionTabItemContainer<F, T> extends EditionTabItemImpl<F> {

	private CompositeEditionTabItem<T> editionItem;
	private Composite control;
	private DataAdapter<F, T> dataAdapter;
	private Collection<? extends EditionTabItem<T>> editionItems;
	private String text;
	private String commandName;
	
	public EditionTabItemContainer(String text, String commandName, DataAdapter<F,T> dataAdapter, Collection<? extends EditionTabItem<T>> editionItems) {
		this.dataAdapter=dataAdapter;
		this.editionItems=editionItems;
		this.text=text;
		this.commandName=commandName;
		
	}
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem,
			F element) {
		T targetElement=dataAdapter.adapt(element);
		control=new Composite(tabFolder, SWT.NONE);
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 30;
		layout.horizontalSpacing = 12;
		control.setLayout(layout);
		tabItem.setText(text);
		
		if(editionItems.size()==0) {
			return;
		}
		
		editionItem=new CompositeEditionTabItem<T>(commandName);

		for (EditionTabItem<T> aEditionItem : editionItems) {
			editionItem.addEditionItem(aEditionItem);
		}
		
		editionItem.initialize(control, targetElement);
		editionItem.addListener(new EditionItemChangeListener<T>() {
			public void changed(EditionItem<T> notifier, EditionItem<T> originator) {
				EditionTabItemContainer.this.notifyChange(originator);
			}
		});

	}
	
	public void activate() {
		editionItem.activate();
	}

	public Control getControl() {
		return control;
	}

	public Command getCommand() {
		if(editionItem==null) {
			return null;
		}
		return editionItem.getCommand();
	}

	public boolean canCreateCommand() {
		if(editionItem==null) {
			return true;
		}
		return editionItem.canCreateCommand();
	}

	public EditionItemStatus getStatus() {
		if(editionItem==null) {
			return EditionItemStatus.DEFAULT_OK;
		}
		return editionItem.getStatus();
	}

}
