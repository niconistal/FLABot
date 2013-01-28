package org.isistan.flabot.executionstatemapping.dialogs.common;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class ListElementsComposite<T> extends Composite implements ActivatedElement,AggregableElement<T> {

	private ListElementEventProvider<T> eventProvider;
	
	private ILabelProvider labelProvider;
	
	private java.util.List<T> elements = new ArrayList<T>(); 
		
	private Table table;
		
	private Button addButton;
	
	private Button editButton;
	
	private Button removeButton;
	
	private boolean activated = false;
	
	public ListElementsComposite(Composite parentComposite, int style, ILabelProvider labelProvider, ListElementEventProvider<T> eventProvider)
	{
		super(parentComposite,style);
		this.labelProvider = labelProvider;
		this.eventProvider = eventProvider;		
		createTable();
		createButtons();

		GridLayout gridLayout51 = new GridLayout();
		gridLayout51.numColumns = 2;
		GridData gridData61 = new GridData();
		gridData61.horizontalAlignment = GridData.FILL;
		gridData61.grabExcessHorizontalSpace = true;
		gridData61.grabExcessVerticalSpace = true;
		gridData61.verticalAlignment = GridData.FILL;
		this.setLayoutData(gridData61);
		this.setLayout(gridLayout51);
	}
	
	public void resetElements()
	{
		table.clearAll();
		activated = false;
	}
	
	public void setElements(java.util.List<T> elements)
	{
		this.elements = elements;
	}
	
	@Override
	public void setEnabled(boolean enabled)
	{
		table.setEnabled(enabled);		
		addButton.setEnabled(enabled);		
		selectionChangedEvent();
	}
	
	public void activate()
	{
		if (!activated)
		{
			if (elements == null)
			{
				elements = new ArrayList<T>();
			}
			else
			{				
				int index;
				for(T executionCondition: elements)
				{		
					index = table.getItemCount();
					TableItem tableItem = new TableItem(table, SWT.NONE);
					setElementAtIndex(index, executionCondition);
				}
			}
			activated = true;
		}
	}
	
	private void createTable()
	{
		GridData gridData = new GridData(GridData.FILL_BOTH);
		gridData.verticalSpan = 3;
		gridData.widthHint = 300;
			
		table = new Table(this, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL | SWT.H_SCROLL);		
		table.setLayoutData(gridData);
		table.addSelectionListener( new  SelectionAdapter()
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				selectionChangedEvent();
			}
		});
		
		table.addListener(SWT.MouseDoubleClick, new Listener()
		{
			public void handleEvent(Event event) 
			{
				editButtonAction();
			}
		});
	}
	
	private void createButtons()
	{
		Composite c = new Composite(this, SWT.None);
		c.setLayout(new GridLayout());
		
		addButton = new Button(c, SWT.None);
		addButton.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ListElementsComposite.buttonAddName")); //$NON-NLS-1$
		addButton.setLayoutData(new GridData(GridData.FILL_BOTH));
		addButton.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				if (addButton.getMenu() == null)
				{
					addButtonAction();
				}
			}
		});	
		
		editButton = new Button(c, SWT.None);
		editButton.setEnabled(false);
		editButton.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ListElementsComposite.buttonEditName")); //$NON-NLS-1$
		editButton.setLayoutData(new GridData(GridData.FILL_BOTH));
		editButton.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				editButtonAction();
			}
		});	
		
		removeButton = new Button(c, SWT.None);
		removeButton.setEnabled(false);
		removeButton.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ListElementsComposite.buttonRemoveName")); //$NON-NLS-1$
		removeButton.setLayoutData(new GridData(GridData.FILL_BOTH));
		removeButton.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				removeButtonAction();
			}
		});	
	}
	
	public void addElement(T newElement)
	{
		if (newElement != null)
		{
			int index = table.getItemCount();
			TableItem tableItem = new TableItem(table, SWT.NONE);
			setElementAtIndex(index, newElement);
		}
	}
		
	public T getSelectedElement()
	{		
		int index = table.getSelectionIndex();
		return (T) table.getItem(index).getData();
	}
	
	private void addButtonAction()
	{		
		addElement(eventProvider.onAddElement());
		if (!activated && table.getItemCount() > 0)
		{
			activated = true;
		}
	}
		
	private void editButtonAction()
	{
		BusyIndicator.showWhile(Display.getCurrent(), new Runnable() {
			public void run() {
				T element = getSelectedElement();
				if (element != null)
				{		
					element = eventProvider.onEditElement(element);
					if (element != null)
					{
						setElementAtIndex(table.getSelectionIndex(), element);
					}
				}
			}
		});
	}
	
	private void setElementAtIndex(int index, T element)
	{
		TableItem tableItem = table.getItem(index);
		tableItem.setText(labelProvider.getText(element));
		tableItem.setImage(labelProvider.getImage(element));
		tableItem.setData(element);
	}
	
	private void removeButtonAction()
	{
		int index = table.getSelectionIndex();
		T element = (T) table.getItem(index).getData();
		if (element != null)
		{		
			eventProvider.onRemoveElement(element);
		}		
		table.remove(index);		
		selectionChangedEvent();
	}
	
	private void selectionChangedEvent()
	{
		enabledControls(table.getEnabled() && table.getSelectionCount() > 0);
	}
	
	private void enabledControls(boolean enabled)
	{
		editButton.setEnabled(enabled);
		removeButton.setEnabled(enabled);
	}
	
	public java.util.List<T> getElements()
	{
		if(!activated) return elements;
		
		java.util.List<T> elements = new ArrayList<T>();
		for(int i =0; i<table.getItemCount(); i++)
		{
			elements.add((T) table.getItem(i).getData());
		}
		return elements;
	}
	
	public Button getAddButton()
	{
		return addButton;
	}
}