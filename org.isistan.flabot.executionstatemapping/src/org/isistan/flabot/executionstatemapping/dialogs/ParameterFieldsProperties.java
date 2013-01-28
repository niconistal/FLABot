package org.isistan.flabot.executionstatemapping.dialogs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IType;
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
import org.eclipse.swt.widgets.Shell;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.FieldBehavior;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.GeneralFieldComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.ITypeFieldsComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.ItemErrorProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.Validator;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;

public class ParameterFieldsProperties implements Validator {
	
	private Shell sShell = null; // @jve:decl-index=0:visual-constraint="41,12"
	
	private IType containerClass;
	
	private Composite compositeTabs=null;

	private Composite compositeButtons = null;

	private Button buttonOK = null;

	private Button buttonCancel = null;
	
	private FieldBehavior fieldsComposite=null;
	
	private List<FieldEvaluationCondition> fieldsList=null;
	
	
	public ParameterFieldsProperties(IType containerClass) {
		this.containerClass=containerClass;
		createSShell();
	}
	
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		List<String> aux=((Validator)fieldsComposite).getErrors();
		if(aux.size()>0)
		{
			errors.add(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ParameterFieldsProperties.fieldsErrors")); //$NON-NLS-1$
			errors.add(""); //$NON-NLS-1$
			errors.addAll(aux);
			errors.add(""); //$NON-NLS-1$
		}
		return errors;
	}
	
	
	public List<FieldEvaluationCondition> showDialog(List<FieldEvaluationCondition> parametersFields) {
		try {
			fieldsList=parametersFields;
			if(parametersFields==null)
				parametersFields=new ArrayList<FieldEvaluationCondition>();
			
			fieldsComposite.fillTable(parametersFields);
			fieldsComposite.activate();
			
			sShell.setMinimumSize(new Point(200, 400));
			sShell.pack();

			// Centra la pantalla
			Display display = sShell.getDisplay();
			Rectangle r = display.getClientArea();
			int centerX = r.width / 2 - sShell.getSize().x / 2;
			int centerY = r.height / 2 - sShell.getSize().y / 2;
			sShell.setLocation(centerX, centerY);
			sShell.open();
			while (!sShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}

		} catch (Exception e) {
			ExecutionConditionPlugin.getDefault().getLogger().error(
					e.getMessage() + e.getStackTrace());
		}
		return fieldsList;
	}
	
	/**
	 * This method initializes sShell
	 */
	private void createSShell() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.makeColumnsEqualWidth = true;
		sShell = new Shell(Display.getCurrent(), SWT.CLOSE|SWT.APPLICATION_MODAL|SWT.TITLE|SWT.MAX);
		sShell.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ParameterFieldsProperties.parametersProperties")); //$NON-NLS-1$
		sShell.setImage(ImageDescriptor.createFromFile(ExecutionConditionPlugin.class, "icons/eclipse32.png").createImage()); //$NON-NLS-1$
		sShell.setLayout(gridLayout);
		sShell.setSize(new Point(527, 352));
		createFieldsComposite();
		createCompositeButtons();
	}
	
	
	/**
	 * This method initializes composite
	 * 
	 */
	private void createFieldsComposite() {
		GridLayout gridLayout31 = new GridLayout();
		gridLayout31.numColumns = 1;
		GridData gridData2 = new GridData();
		gridData2.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.grabExcessVerticalSpace = true;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData2.grabExcessHorizontalSpace = true;
		compositeTabs = new Composite(sShell, SWT.BORDER);
		compositeTabs.setLayout(gridLayout31);
		compositeTabs.setLayoutData(gridData2);
		
		GridLayout gridLayout51 = new GridLayout();
		gridLayout51.numColumns = 1;
		GridData gridData61 = new GridData();
		gridData61.horizontalAlignment = GridData.FILL;
		gridData61.grabExcessHorizontalSpace = true;
		gridData61.grabExcessVerticalSpace = true;
		gridData61.verticalAlignment = GridData.FILL;
		if (containerClass!=null)
		{
			ITypeFieldsComposite iTtypeFieldsComposite=new ITypeFieldsComposite(compositeTabs,SWT.NONE);
			iTtypeFieldsComposite.setContainerClass(containerClass);
			fieldsComposite=iTtypeFieldsComposite;
		}
		else
		{
			fieldsComposite=new GeneralFieldComposite(compositeTabs,SWT.NONE);
		}
		
		((Composite)fieldsComposite).setLayoutData(gridData61);
		((Composite)fieldsComposite).setLayout(gridLayout51);
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
		compositeButtons = new Composite(sShell, SWT.NONE);
		compositeButtons.setLayoutData(gridData1);
		compositeButtons.setLayout(gridLayout2);
		buttonOK = new Button(compositeButtons, SWT.NONE);
		buttonOK.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ParameterFieldsProperties.okButton")); //$NON-NLS-1$
		buttonOK.setLayoutData(gridData3);
		buttonOK.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				List<String> errors=getErrors();
				if(errors.size()!=0)
				{
					ScrollableItemDialog errorDialog=new ScrollableItemDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ParameterFieldsProperties.errors"),Messages.getString("org.isistan.flabot.executionmapping.dialogs.ParameterFieldsProperties.checkErrors")); //$NON-NLS-1$ //$NON-NLS-2$
					errorDialog.showDialog(errors,new ItemErrorProvider());
				}
				else
				{
					fieldsList=fieldsComposite.getFieldsEvaluationConditions();
					sShell.dispose();
				}
			}
		});
		buttonCancel = new Button(compositeButtons, SWT.NONE);
		buttonCancel.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.ParameterFieldsProperties.cancelButton")); //$NON-NLS-1$
		buttonCancel.setLayoutData(gridData4);
		buttonCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sShell.dispose();
			}
		});
	}
}
