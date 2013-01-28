package org.isistan.flabot.executionstatemapping.dialogs;

import java.util.List;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.ItemErrorProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.Validator;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.impl.ExecutionConditionImpl;

public abstract class AbstractExecutionConditionDialog implements Validator {

	protected Shell sShell; // @jve:decl-index=0:visual-constraint="41,12"
	protected Composite compositeName;
	protected Label labelName;
	protected Text textName;
	protected Composite mainComposite;
	protected Button buttonOK;
	protected Button buttonCancel;
	protected Button buttonShowPrologCode;
	
	protected abstract void createAditionalComposites();
	protected abstract void createCompositeContent();
	protected abstract void processOkEvent();
	protected abstract void processCancelEvent();
	protected abstract String getPrologCode();
	
	
	protected void createSShell()
	{
		GridLayout gridLayout = new GridLayout();
		gridLayout.makeColumnsEqualWidth = true;
		sShell = new Shell(Display.getCurrent(), SWT.CLOSE|SWT.APPLICATION_MODAL|SWT.TITLE|SWT.MAX);
		sShell.setImage(ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/eclipse32.png").createImage()); //$NON-NLS-1$
		sShell.setLayout(gridLayout);
		sShell.setSize(new Point(527, 352));
		createNameComposite();
		createAditionalComposites();
		createMainComposite();
		createCompositeButtons();
	}
	
	/**
	 * This method initializes compositeName	
	 *
	 */
	private void createNameComposite() {
		GridData gridData14 = new GridData();
		gridData14.horizontalAlignment = GridData.FILL;
		gridData14.grabExcessHorizontalSpace = true;
		gridData14.verticalAlignment = GridData.CENTER;
		GridData gridData111 = new GridData();
		gridData111.horizontalAlignment = GridData.BEGINNING;
		gridData111.widthHint = 250;
		gridData111.grabExcessHorizontalSpace = true;
		GridData gridData121 = new GridData();
		gridData121.widthHint = 45;
		GridLayout gridLayout61 = new GridLayout();
		gridLayout61.numColumns = 2;
		compositeName = new Composite(sShell, SWT.NONE);
		compositeName.setLayout(gridLayout61);
		compositeName.setLayoutData(gridData14);
		labelName = new Label(compositeName, SWT.NONE);
		labelName.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.name")); //$NON-NLS-1$
		labelName.setLayoutData(gridData121);
		textName = new Text(compositeName, SWT.BORDER);
		textName.setLayoutData(gridData111);
	}
	
	/**
	 * This method initializes composite
	 * 
	 */
	private void createMainComposite() {
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.horizontalSpacing = 50;
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		gridData.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.horizontalIndent = -1;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData.grabExcessVerticalSpace = true;
		mainComposite = new Composite(sShell, SWT.NONE);
		mainComposite.setLayout(gridLayout1);
		mainComposite.setLayoutData(gridData);
		createCompositeContent();
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
		gridLayout2.makeColumnsEqualWidth=true;
		gridLayout2.marginHeight=1;
		gridLayout2.marginWidth=2;
		gridLayout2.verticalSpacing=0;
		
		GridData gridData1 = new GridData();
		gridData1.grabExcessHorizontalSpace = true;;
		gridData1.horizontalAlignment=SWT.FILL;
		
		Composite compositeButtons = new Composite(sShell,SWT.FILL);
		compositeButtons.setLayoutData(gridData1);
		compositeButtons.setLayout(gridLayout2);
		
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.marginHeight=0;
		gridLayout3.marginWidth=5;
		gridLayout3.verticalSpacing=0;
		
		Composite compositeButtonProlog=new Composite(compositeButtons,SWT.NONE);
		compositeButtonProlog.setLayoutData(gridData2);
		compositeButtonProlog.setLayout(gridLayout3);
		
		GridData gridData11 = new GridData();
		gridData11.grabExcessHorizontalSpace = true;
		gridData11.horizontalAlignment = org.eclipse.swt.layout.GridData.END;
		
		Composite compositeButtonsOkCancel=new Composite(compositeButtons,SWT.FILL);
		compositeButtonsOkCancel.setLayoutData(gridData11);
		compositeButtonsOkCancel.setLayout(gridLayout2);
		
		buttonShowPrologCode= new Button(compositeButtonProlog, SWT.NONE);
		buttonShowPrologCode.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.showProlog")); //$NON-NLS-1$
		buttonShowPrologCode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<String> errors=getErrors();
				if(errors.size()!=0)
				{
					ScrollableItemDialog errorDialog=new ScrollableItemDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.erros"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.checkErrors")); //$NON-NLS-1$ //$NON-NLS-2$
					errorDialog.showDialog(errors,new ItemErrorProvider());
				}
				else
				{		
					ExecutionConditionImpl.predicateExpressionNumber=0;
					
					String prologCode=getPrologCode();
					prologCode = prologCode.replace(":-", ":-\n\t"); //$NON-NLS-1$ //$NON-NLS-2$
					prologCode = prologCode.replace("),", "),\n\t"); //$NON-NLS-1$ //$NON-NLS-2$
					prologCode = prologCode.replace(").", ").\n"); //$NON-NLS-1$ //$NON-NLS-2$
					
					ShowPrologDialog prologCodeDialog=new ShowPrologDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.prologCode"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.prologVisualization")); //$NON-NLS-1$ //$NON-NLS-2$
					prologCodeDialog.showDialog(prologCode);
				}
			}
		});
		
		buttonOK = new Button(compositeButtonsOkCancel, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.okButton")); //$NON-NLS-1$
		buttonOK.setLayoutData(gridData3);
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<String> errors=getErrors();
				if(errors.size()!=0)
				{
					ScrollableItemDialog errorDialog=new ScrollableItemDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.errors"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.checkErrors")); //$NON-NLS-1$ //$NON-NLS-2$
					errorDialog.showDialog(errors,new ItemErrorProvider());
				}else
				{
					processOkEvent();
					sShell.dispose();
				}
			}
		});
		
		buttonCancel = new Button(compositeButtonsOkCancel, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.AbstractExecutionConditionDialog.cancelButton")); //$NON-NLS-1$
		buttonCancel.setLayoutData(gridData4);
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				processCancelEvent();
				
				sShell.dispose();
			}
		});
	
	}
}