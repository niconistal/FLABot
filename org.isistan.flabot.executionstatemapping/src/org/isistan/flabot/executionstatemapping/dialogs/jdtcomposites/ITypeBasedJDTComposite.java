package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.Signature;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.ParameterFieldsProperties;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.FieldComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ValueComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.FieldEvaluationCondition;
import org.isistan.flabot.executionstatemapping.utils.jdt.BinaryClassSearchRequestor;

public abstract class ITypeBasedJDTComposite extends JDTComposite
{
	protected int cantSelected=0;
	
	private IType[] hierarchyTypes;
	
	protected abstract IMember getIMember();
	
	public ITypeBasedJDTComposite(Composite parentComposite, int style)
	{
		super(parentComposite,style);
	}
	
	@Override
	protected void fillComposite()
	{
		createTable();
		createColumns();
	}
	
	protected void createTable()
	{
		jdtTable = new Table(this, SWT.BORDER);
		jdtTable.setHeaderVisible(true);
		jdtTable.setLinesVisible(true);
		jdtTable.setLayoutData(new GridData(GridData.FILL_BOTH));
	}
	
	protected Label createLabelName(TableItem tableItem)
	{
		TableEditor labelNameEditor = new TableEditor(jdtTable); // @jve
		Label labelName = new Label(jdtTable, SWT.None); // @jve
		labelName.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		labelNameEditor.grabHorizontal = true;
		labelName.setAlignment(SWT.CENTER);
		labelNameEditor.setEditor(labelName, tableItem, LABEL_NAME_POS);
		tableItem.setData(LABEL_NAME,labelName);
		return labelName;
	}
		
	@Override
	public void checkButtonAction(TableItem tableItem,Button checkButton)
	{
		if(!checkButton.getSelection())
		{
			cantSelected--;
		}
		setItemSelected(tableItem,checkButton.getSelection());
	}
	
	@Override
	public void fieldClickAction(TableItem tableItem, FieldComposite fieldComposite)
	{
		ParameterFieldsProperties dialog=new ParameterFieldsProperties(getType(tableItem));
		List<FieldEvaluationCondition> parametersFields=dialog.showDialog(fieldComposite.getEvaluationConditions());	
		fieldComposite.setEvaluationConditions(parametersFields);
	}		
	
	protected IType getType(TableItem tableItem)
	{		
		IType iType = (IType) tableItem.getData(ITYPE);		
		if (iType == null)
		{
			IMember imember = getIMember();
			String typeName = Signature.toString(((String) tableItem.getData(TYPE_DATA_KEY)));
			if(!imember.isBinary())
			{
				try {
					String[][] resolvedName = ((IType)imember).resolveType(typeName);
					if (resolvedName.length > 0)
					{
						typeName =  resolvedName[0][0] + "." + resolvedName[0][1];  //$NON-NLS-1$
					}
				} catch (JavaModelException e) {
					e.printStackTrace();
				}
			}
			BinaryClassSearchRequestor searcher = new BinaryClassSearchRequestor();
			searcher.search(typeName);
			iType = searcher.getFoundJavaElemet();
			tableItem.setData(ITYPE, iType);									
		}
		return iType;
	}
	
	@Override
	public void classOfAction(final TableItem tableItem,ValueComposite valueComposite,boolean fromHierarchy)
	{
		IType selectedIType=null;
		if(fromHierarchy)
		{
			final IType type = getType(tableItem);				
			
			IRunnableWithProgress process = new IRunnableWithProgress()
			{
				public void run(IProgressMonitor monitor)
				{		
					try
					{	
						ITypeHierarchy typeHierarchy = type.newTypeHierarchy(monitor);
						hierarchyTypes = typeHierarchy.getSubtypes(type);									
					}
					catch(JavaModelException ex)
					{	
						ExecutionConditionPlugin.getDefault().getLogger().error(
								ex.getMessage() + ex.getStackTrace());
					}
				}
			};
			
			//Shows a progress monitor while searching
			ProgressMonitorDialog dialog = new ProgressMonitorDialog(Display.getCurrent().getActiveShell());
			try
			{
				dialog.run(true, true, process);
			}
			catch(InvocationTargetException e)
			{
				ExecutionConditionPlugin.getDefault().getLogger().error(
						e.getMessage() + e.getStackTrace());
			}
			catch(InterruptedException e)
			{
				hierarchyTypes = null;
			}
					
			if (hierarchyTypes != null)
			{
				IType[] completeHierarchyTypes=new IType[hierarchyTypes.length+1];
				for(int i=0;i<hierarchyTypes.length;i++)
					completeHierarchyTypes[i]=hierarchyTypes[i];
				completeHierarchyTypes[hierarchyTypes.length]=type;
				selectedIType= DialogUtils.getSelectedListElement(Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeBasedJDTComposite.classSelection"), Messages.getString("org.isistan.flabot.executionmapping.dialogs.jdtcomposites.ITypeBasedJDTComposite.selectClass"), new JavaElementLabelProvider(), completeHierarchyTypes); //$NON-NLS-1$ //$NON-NLS-2$
			}
			
		}
		else
		{
			selectedIType=DialogUtils.showSelectClassFromWorkspaceDialog();
		}
		
		if (selectedIType != null)
		{
			valueComposite.setText(selectedIType.getFullyQualifiedName());
		}
	}
	
	protected void setItemSelected(TableItem item, boolean enabled)
	{	
		if (enabled)
		{
			cantSelected++;
		}
		
		((Control)item.getData(LABEL_NAME)).setEnabled(enabled);
		((Control)item.getData(COMBO_ROLE)).setEnabled(enabled);
		((ValueComposite)item.getData(COMPOSITE_VALUE)).setEnabled(enabled);
				
		FieldComposite fieldComposite=(FieldComposite)item.getData(COMPOSITE_FIELDS);
		if (fieldComposite!=null)
		{
			fieldComposite.setEnabled(enabled);
		}
	}
	
	protected void clearAllTable()
	{
		TableItem item; Control fieldComposite;
		for(int i=0; i<jdtTable.getItemCount(); i++)
		{
			item = jdtTable.getItem(i);
			if(item.getData(CHECK_BUTTON)!=null)
			{
				((Control)item.getData(CHECK_BUTTON)).dispose();
				((Control)item.getData(LABEL_NAME)).dispose();
				((Control)item.getData(COMPOSITE_VALUE)).dispose();
				((Control)item.getData(COMBO_ROLE)).getParent().dispose();
				((Control)item.getData(COMBO_ROLE)).dispose();
				fieldComposite = (Control)item.getData(COMPOSITE_FIELDS);
				if(fieldComposite != null)
				{
					fieldComposite.dispose();
				}
			}
		}
		jdtTable.removeAll();
		jdtTable.pack();
		jdtTable.getParent().layout();
	}
}