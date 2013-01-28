package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.JDTComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners.ClassOfListener;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class ClassOfComposite extends ValueComposite {

	private Text valueText;
	
	private Button button; 
	
	public ClassOfComposite(Composite parent,JDTComposite parentComposite,TableItem tableItem, int style,boolean showMenuOptions)
	{
		super(parent, style);
		addListeners(parentComposite,tableItem,showMenuOptions);
	}
	
	@Override
	protected void createComposite()
	{
		GridLayout gdl = new GridLayout();
		gdl.numColumns = 2;
		gdl.horizontalSpacing = 0;
		gdl.verticalSpacing = 0;
		gdl.marginWidth =0;
		gdl.marginHeight =0;
		this.setLayout(gdl);		
		valueText=new Text(this, SWT.None);		
		valueText.setText(""); //$NON-NLS-1$
		valueText.setBackground(ColorConstants.white);						
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.grabExcessHorizontalSpace = true;
		valueText.setLayoutData(gd);
		
		button = new Button(this, SWT.READ_ONLY);	
		button.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.ClassOfComposite.chooseButton")); //$NON-NLS-1$
		button.setEnabled(true);
		GridData gridDataButton = new GridData();
		gridDataButton.grabExcessVerticalSpace = true;
		gridDataButton.verticalAlignment = SWT.CENTER;
		button.setLayoutData(gridDataButton);
	}
	
	private void addListeners(JDTComposite parentComposite,TableItem tableItem,boolean showMenuOptions)
	{
		if(showMenuOptions)
		{
			final Menu menu = new Menu(button);
			
			button.addSelectionListener(new SelectionAdapter() 
			{
				@Override
				public void widgetSelected(SelectionEvent e) 
				{
					Rectangle rect = button.getBounds();
					Point pt = new Point(rect.x, rect.y + rect.height);
				    pt = button.getParent().toDisplay(pt);			    
				    menu.setLocation(pt.x, pt.y);
				    menu.setVisible(true);			    
				}
			});
			
			MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
			menuItem.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.ClassOfComposite.fromHierarchy"));  //$NON-NLS-1$
			menuItem.addSelectionListener(new ClassOfListener(parentComposite,tableItem,this,true));
			
			menuItem = new MenuItem(menu, SWT.PUSH);
			menuItem.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.ClassOfComposite.fromWorkspace"));  //$NON-NLS-1$
			menuItem.addSelectionListener(new ClassOfListener(parentComposite,tableItem,this,false));
		}
		else
		{
			button.addSelectionListener(new ClassOfListener(parentComposite,tableItem,this,false));
		}
	}
	
	@Override
	public void setText(String text)
	{
		valueText.setText(text);
	}
	
	@Override
	public String getText()
	{
		return valueText.getText();
	}
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		if (valueText.isEnabled() &&  getText().length()==0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.valuecomposites.ClassOfComposite.valueEmpty")); //$NON-NLS-1$
		}
		return errors;
	}
	
	@Override
	public void setEnabled(boolean state)
	{
		valueText.setEnabled(state);
		button.setEnabled(state);
	}
}