package org.isistan.flabot.util.edition.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TabFolder;
import org.isistan.flabot.util.edition.AbstractCompositeEditionItem;
import org.isistan.flabot.util.edition.EditionItem;

/**
 * Implementation of EditionItem that in which each edition item is represented
 * by a tab and compositeEditionItems are represented as tab folders.
 * @author da Costa Cambio
 *
 */
public class CompositeEditionTabItem<T> extends AbstractCompositeEditionItem<T> {
	
	private String commandName;
	
	public CompositeEditionTabItem(String commandName) {
		this.commandName=commandName;
	}
	
	private TabFolder tabFolder;
	@Override
	protected void internalInitialize(Composite container, T element) {
		tabFolder = new TabFolder(container, SWT.NONE);
		tabFolder.setLayoutData(new GridData(
					GridData.HORIZONTAL_ALIGN_CENTER |
					GridData.FILL_VERTICAL |
					GridData.VERTICAL_ALIGN_BEGINNING |
					GridData.FILL_HORIZONTAL));
	}
	
	
	@Override
	protected void postChildInitialization(EditionItem<T>[] editionItems) {
		tabFolder.addSelectionListener(childrenActivator=new ChildrenActivator(editionItems));
	}
	
	public Composite getChildContainer() {
		return tabFolder;
	}

	@Override
	protected String getCommandName() {
		return commandName;
	}

	public void activate() {
		childrenActivator.selected(0);
	}
	
	private ChildrenActivator childrenActivator;
	private class ChildrenActivator implements SelectionListener {
		private boolean[] childActivated;
		private int childActivatedCount=0;
		private EditionItem<T>[] editionItems;
		
		public ChildrenActivator(EditionItem<T>[] editionItems) {
			this.editionItems=editionItems;
			childActivated=new boolean[editionItems.length];
		}
		
		public void selected(int index) {
			if(editionItems.length==0) {
				tabFolder.removeSelectionListener(this);
			}
			if(!childActivated[index]) {
				childActivatedCount++;
				editionItems[index].activate();
				childActivated[index]=true;
				if(childActivatedCount==editionItems.length) {
					tabFolder.removeSelectionListener(this);
				}
			}
		}
		public void widgetSelected(SelectionEvent e) {
			int index=tabFolder.getSelectionIndex();
			selected(index);

		}

		public void widgetDefaultSelected(SelectionEvent e) {
			
		}
		
	};
}
