package org.isistan.flabot.executionstatemapping.dialogs;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.common.AggregableElement;
import org.isistan.flabot.executionstatemapping.dialogs.common.PreFilterManagerComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;

public class ExecutionConditionFilterDialog implements AggregableElement<ExecutionCondition> {

	private Shell shell;
	
	private ViewFilterProvider[] addMenuSubItems;
	
	private ViewFilterProvider[] newMenuSubItems;
		
	private PreFilterManagerComposite preFilterManagerDialog;
	
	private List<ExecutionCondition> selectedFilters;
	
	private ExecutionStateMappingFileModel executionStateMappingFileModel;
	
	public void build(String title, ExecutionStateMappingFileModel executionStateMappingFileModel, ViewFilterProvider[] addMenuSubItems, ViewFilterProvider[] newMenuSubItems)
	{
		this.executionStateMappingFileModel = executionStateMappingFileModel;
		this.addMenuSubItems = addMenuSubItems;
		this.newMenuSubItems = newMenuSubItems;
		createSShell(title);
	}

	public List<ExecutionCondition> showDialog(List<ExecutionCondition> inicialElements) 
	{		
		try 
		{
			shell.setMinimumSize(new Point(200, 400));
			shell.pack();
			
			preFilterManagerDialog.setElements(inicialElements);
			
			// Centra la pantalla
			Display display = shell.getDisplay();
			Rectangle r = display.getClientArea();
			int centerX = r.width / 2 - shell.getSize().x / 2;
			int centerY = r.height / 2 - shell.getSize().y / 2;
			shell.setLocation(centerX, centerY);
			shell.open();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

		} catch (Exception e) {
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}
		
		return selectedFilters;
	}

	/**
	 * This method initializes sShell
	 */
	private void createSShell(String title) {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.makeColumnsEqualWidth = true;
		shell = new Shell(Display.getCurrent(), SWT.CLOSE
				| SWT.APPLICATION_MODAL | SWT.TITLE | SWT.MAX);
		shell.setText(title);
		shell.setImage(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/eclipse32.png") //$NON-NLS-1$
				.createImage());
		shell.setLayout(gridLayout);
		shell.setSize(new Point(527, 352));
		createMainComposite();
		createCompositeButtons();
	}

	private void createMainComposite() {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.horizontalSpacing = 50;
		gridLayout1.numColumns = 1;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.horizontalIndent = -1;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		Group composite = new Group(shell, SWT.NONE);
		composite.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ExecutionConditionFilterDialog.1")); //$NON-NLS-1$
		composite.setLayout(gridLayout1);
		composite.setLayoutData(gridData);
		createFilterComposite(composite);
	}
	
	public void addElement(ExecutionCondition element)
	{
		preFilterManagerDialog.addElement(element);
	}
	
	private void createFilterComposite(Composite composite) 
	{		
		preFilterManagerDialog = new PreFilterManagerComposite(composite, SWT.NONE, executionStateMappingFileModel, addMenuSubItems, newMenuSubItems);		
	}	
	
	/**
	 * This method initializes composite1
	 * 
	 */
	private void createCompositeButtons() {
		GridData gridData4 = new GridData();
		gridData4.widthHint = 60;
		GridData gridData3 = new GridData();
		gridData3.widthHint = 60;
		GridLayout gridLayout2 = new GridLayout();
		gridLayout2.numColumns = 2;
		gridLayout2.marginHeight = 5;
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;
		gridData1.horizontalIndent = 0;
		gridData1.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		Composite compositeButtons = new Composite(shell, SWT.NONE);
		compositeButtons.setLayoutData(gridData1);
		compositeButtons.setLayout(gridLayout2);
		
		Button buttonOK = new Button(compositeButtons, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ExecutionConditionFilterDialog.okButton")); //$NON-NLS-1$
		buttonOK.setLayoutData(gridData3);
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedFilters = preFilterManagerDialog.getElements();
				shell.dispose();
			}
		});
		
		Button buttonCancel = new Button(compositeButtons, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ExecutionConditionFilterDialog.cancelButton")); //$NON-NLS-1$
		buttonCancel.setLayoutData(gridData4);
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedFilters = null;
				shell.dispose();
			}
		});
	}
}