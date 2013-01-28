package org.isistan.flabot.executionstatemapping.dialogs.common;

import org.eclipse.swt.events.SelectionListener;

public class MenuSubItem {

	private String textName;
	
	private SelectionListener selectionListener;
	
	public MenuSubItem(String textName, SelectionListener selectionListener)
	{
		this.textName = textName;
		this.selectionListener = selectionListener;
	}
	
	public String getTextName()
	{
		return textName;
	}
	
	public SelectionListener getSelectionListener()
	{
		return selectionListener;
	}
}