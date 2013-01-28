package org.isistan.flabot.executionstatemapping.dialogs.utils.errors;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.utils.contentproviders.ItemProvider;

public class ItemErrorProvider implements ItemProvider {

	private TableItem createLineWhitImage(Table errorsTable, String text)
	{
		TableItem item = new TableItem(errorsTable, SWT.NONE); // @jve
		TableEditor tableEditor = new TableEditor(errorsTable); // @jve
		
		Composite composite=new Composite(errorsTable,SWT.NONE);
		GridLayout gdl = new GridLayout();
		gdl.numColumns = 2;
		gdl.horizontalSpacing = 0;
		gdl.verticalSpacing = 0;
		gdl.marginWidth =0;
		gdl.marginHeight =0;
		composite.setLayout(gdl);		
		composite.setBackground(ColorConstants.white);
		
		Label label = new Label(composite, SWT.READ_ONLY);	
		label.setEnabled(true);
		label.setBackground(ColorConstants.white);
		label.setImage(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/error_obj.gif").createImage()); //$NON-NLS-1$
		
		GridData gridDataButton = new GridData();
		gridDataButton.grabExcessVerticalSpace = true;
		gridDataButton.verticalAlignment = SWT.FILL;
		label.setLayoutData(gridDataButton);
		
		Text valueText=new Text(composite, SWT.None);		
		valueText.setText(text);
		valueText.setEditable(false);
		valueText.setBackground(ColorConstants.white);						
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		valueText.setLayoutData(gd);
		
		tableEditor.grabHorizontal = true;
		tableEditor.setEditor(composite, item,0);
		return item;
	}
	
	private TableItem getTextLine(Table errorsTable,String text)
	{
		TableItem item = new TableItem(errorsTable, SWT.NONE); // @jve
		TableEditor tableEditor = new TableEditor(errorsTable); // @jve
		
		Label label = new Label(errorsTable, SWT.READ_ONLY);	
		label.setEnabled(true);
		label.setBackground(ColorConstants.white);
		label.setText(text);
		
		tableEditor.grabHorizontal = true;
		tableEditor.setEditor(label, item,0);
		return item;
	}
	
	public TableItem decorateError(Table errorsTable, String line)
	{
		if(line=="" || line.startsWith(">")) //$NON-NLS-1$ //$NON-NLS-2$
			return getTextLine(errorsTable,line);
		else
			return createLineWhitImage(errorsTable,line);
	}
}
