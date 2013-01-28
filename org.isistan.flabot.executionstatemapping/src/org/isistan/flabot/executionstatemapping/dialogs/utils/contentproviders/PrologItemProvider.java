package org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class PrologItemProvider implements ItemProvider {

	private TableItem getTextLine(Table table,String text)
	{
		TableItem item = new TableItem(table, SWT.NONE); // @jve
		TableEditor tableEditor = new TableEditor(table); // @jve
		
		Text valueText=new Text(table, SWT.None);		
		valueText.setText(text);
		valueText.setEditable(false);
		valueText.setBackground(ColorConstants.white);						
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		valueText.setLayoutData(gd);
		
		tableEditor.grabHorizontal = true;
		tableEditor.setEditor(valueText, item,0);
		return item;
	}
	
	public TableItem decorateError(Table table, String message) {
		return getTextLine(table,message);
	}

}
