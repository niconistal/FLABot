package org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jdt.core.Signature;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboBooleanVarProvider;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboCharVarProvider;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboContentProvider;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboGeneralVarProvider;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboNumericVarProvider;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboObjectVarProvider;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.combocontentproviders.ComboStringVarProvider;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners.CheckBoxChangeListener;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.listeners.ComboChangeListener;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.BooleanComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ByteComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.CharComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ClassOfComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.DoubleComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.FieldComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.FloatComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.IntComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.LongComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ShortComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.StringComposite;
import org.isistan.flabot.executionstatemapping.dialogs.jdtcomposites.valuecomposites.ValueComposite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.Validator;
import org.isistan.flabot.executionstatemapping.model.semantic.ConditionValue;

public abstract class JDTComposite extends Composite implements Validator {
	
	protected static final Font defaultFont= new Font(Display.getDefault(), "Tahoma", 8, SWT.BOLD); //$NON-NLS-1$
	
	protected static final String TYPE_DATA_KEY = "TYPE_DATA_KEY"; //$NON-NLS-1$
	
	protected static final int CHECK_BUTTON_POS=0;
	protected static final int LABEL_NAME_POS=1;
	protected static final int COMBO_ROLE_POS=2;
	protected static final int COMPOSITE_VALUE_POS=3;
	protected static final int FIELDS_POS=4;
	
	protected static final String ITYPE = "ITYPE"; //$NON-NLS-1$
	
	protected static final String TABLE_ITEM="TABLE_ITEM"; //$NON-NLS-1$
	
	public static final String CHECK_BUTTON="CHECK_BUTTON"; //$NON-NLS-1$
	public static final String LABEL_NAME="LABEL_NAME"; //$NON-NLS-1$
	public static final String COMBO_ROLE="COMBO_ROLE"; //$NON-NLS-1$
	public static final String COMPOSITE_VALUE="COMPOSITE_VALUE"; //$NON-NLS-1$
	public static final String COMPOSITE_FIELDS ="COMPOSITE_FIELDS";	 //$NON-NLS-1$
	
	protected Table jdtTable;	
	
	public JDTComposite(Composite parentComposite, int style)
	{
		super(parentComposite,style);
		fillComposite();
	}
	
	protected abstract void fillComposite();
	
	protected abstract void createColumns(); 
	
	public abstract void checkButtonAction(TableItem tableItem,Button checkButton);
	
	public abstract void classOfAction(TableItem tableItem,ValueComposite valueComposite,boolean fromHierarchy);
	
	public abstract void fieldClickAction(TableItem tableItem, FieldComposite fieldComposite); 
	
	/**
	 * Create a CheckButton in a specific tableItem's position
	 * @param tableItem
	 * @param pos
	 * @return
	 */
	protected Button createCheckButton(TableItem tableItem)
	{
		TableEditor checkBoxEditor = new TableEditor(jdtTable); // @jve
		checkBoxEditor.grabHorizontal = true;
		checkBoxEditor.horizontalAlignment=SWT.CENTER;
		Button checkButton = new Button(jdtTable, SWT.CHECK); // @jve
		checkBoxEditor.setEditor(checkButton, tableItem, CHECK_BUTTON_POS);
		CheckBoxChangeListener listener=new CheckBoxChangeListener(this,tableItem,checkButton);
		checkButton.addSelectionListener(listener);	
		tableItem.setData(CHECK_BUTTON,checkButton);
		return checkButton;
	}	
	
	/**
	 * Create a Conditional ComboBox in a specific tableItem's position
	 * @param tableItem
	 * @param pos
	 * @return
	 */
	protected CCombo createComboBox(TableItem tableItem,ConditionValue selectedConditionValue,Composite compsiteValue) {
		
		String type=(String)tableItem.getData(TYPE_DATA_KEY);
		Composite composite=new Composite(jdtTable,SWT.NONE);
		
		GridLayout gdl = new GridLayout();
		gdl.horizontalSpacing = 0;
		gdl.verticalSpacing = 0;
		gdl.marginWidth =0;
		gdl.marginHeight =0;
		composite.setLayout(gdl);						
		GridData gd = new GridData(GridData.FILL_BOTH);
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace=true;
		
		CCombo comboRole = new CCombo(composite, SWT.READ_ONLY); // @jve
		comboRole.setBackground(ColorConstants.white);
		comboRole.setLayoutData(gd);
		
		ComboContentProvider comboProvider=null;
		if (type==null)
			comboProvider=new ComboGeneralVarProvider();
		else
		{
			if (Signature.getTypeSignatureKind(type) == Signature.BASE_TYPE_SIGNATURE) 
			{
				switch(type.charAt(0))
				{
					case Signature.C_BOOLEAN:comboProvider=new ComboBooleanVarProvider();break;
					case Signature.C_DOUBLE:
					case Signature.C_FLOAT:
					case Signature.C_INT:
					case Signature.C_LONG:
					case Signature.C_BYTE:
					case Signature.C_SHORT:comboProvider=new ComboNumericVarProvider();break;
					case Signature.C_CHAR:comboProvider=new ComboCharVarProvider();break;//TODO
				}
			}
			else if(Signature.getSignatureSimpleName(type).equals("String")) //$NON-NLS-1$
				comboProvider=new ComboStringVarProvider();
			else
				comboProvider=new ComboObjectVarProvider();			
		}
		comboProvider.fillCombo(comboRole,selectedConditionValue);
		
		TableEditor comboEditor = new TableEditor(jdtTable); // @jve
		comboEditor.grabHorizontal = true;
		
		SelectionListener comboChangeListener =new ComboChangeListener(this,comboRole);
		comboRole.addSelectionListener(comboChangeListener);
		
		comboEditor.setEditor(composite, tableItem, COMBO_ROLE_POS);
		tableItem.setData(COMBO_ROLE,comboRole);		
		comboRole.setData(COMPOSITE_VALUE,compsiteValue);
		return comboRole;
	}
	
	protected ValueComposite createCompositeValue(TableItem tableItem,ConditionValue conditionValue)
	{
		String type=(String)tableItem.getData(TYPE_DATA_KEY);
			
		ValueComposite valueComposite=null;

		if (conditionValue == ConditionValue.IS_CLASS ||conditionValue == ConditionValue.NOT_IS_CLASS)
		{
			valueComposite=new ClassOfComposite(jdtTable,this,tableItem,SWT.None,type!=null);
		}
		else
		{
			if (type!=null && Signature.getTypeSignatureKind(type) == Signature.BASE_TYPE_SIGNATURE) 
			{
				switch(type.charAt(0))
				{
					case Signature.C_BOOLEAN:valueComposite=new BooleanComposite(jdtTable, SWT.None);break;
					case Signature.C_DOUBLE:valueComposite=new DoubleComposite(jdtTable, SWT.None);break;
					case Signature.C_FLOAT:valueComposite=new FloatComposite(jdtTable, SWT.None);break;
					case Signature.C_INT: valueComposite=new IntComposite(jdtTable, SWT.None);break;
					case Signature.C_LONG:valueComposite=new LongComposite(jdtTable, SWT.None);break;
					case Signature.C_SHORT:valueComposite=new ShortComposite(jdtTable, SWT.None);break;
					case Signature.C_CHAR:valueComposite=new CharComposite(jdtTable, SWT.None);break;
					case Signature.C_BYTE:valueComposite=new ByteComposite(jdtTable, SWT.None);break;
				}
			}
			else
			{
				if(conditionValue==ConditionValue.GREATER||conditionValue==ConditionValue.GREATER_EQUAL||
				   conditionValue==ConditionValue.LOWER||conditionValue==ConditionValue.LOWER_EQUAL)
				{
					valueComposite=new DoubleComposite(jdtTable,SWT.NONE);
				}
				else
				{
					valueComposite=new StringComposite(jdtTable, SWT.None);
				}
			}	
		}
		
		TableEditor textValueEditor = new TableEditor(jdtTable); // @jve
		textValueEditor.grabHorizontal = true;	
		valueComposite.setData(TABLE_ITEM,tableItem);
		textValueEditor.setEditor(valueComposite, tableItem, COMPOSITE_VALUE_POS);
		tableItem.setData(COMPOSITE_VALUE,valueComposite);
		return valueComposite;
	}
	
	protected Composite createFieldComposite(TableItem tableItem)
	{
		TableEditor fieldsEditor = new TableEditor(jdtTable); // @jve
		fieldsEditor.grabHorizontal = true;
		fieldsEditor.horizontalAlignment = GridData.CENTER;
		
		FieldComposite fieldComposite=new FieldComposite(jdtTable,tableItem,this,SWT.None);
		
		GridLayout gdlCompositeFields = new GridLayout();
		gdlCompositeFields.horizontalSpacing = 0;
		gdlCompositeFields.verticalSpacing = 0;
		gdlCompositeFields.marginWidth =0;
		gdlCompositeFields.marginHeight =0;
		
		fieldComposite.setLayout(gdlCompositeFields);
		fieldComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		fieldComposite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		

		fieldsEditor.setEditor(fieldComposite, tableItem, FIELDS_POS);
		tableItem.setData(COMPOSITE_FIELDS,fieldComposite);
		return fieldComposite;
	}
	
	public ValueComposite updateCompositeValue(CCombo comboRole) 
	{

		ConditionValue conditionValue=(ConditionValue)comboRole.getData(String.valueOf(comboRole.getSelectionIndex()));
		ValueComposite composite=(ValueComposite)comboRole.getData(COMPOSITE_VALUE);
		String text=composite.getText();
		boolean enabled=comboRole.isEnabled();
		TableItem item=(TableItem)composite.getData(TABLE_ITEM);
		composite.dispose();
		composite=createCompositeValue(item,conditionValue);
		comboRole.setData(COMPOSITE_VALUE,composite);
		
		if ( conditionValue == ConditionValue.IS_NULL || conditionValue == ConditionValue.NOT_NULL )
		{
			composite.setEnabled(false);
			composite.setText(""); //$NON-NLS-1$
		}
		else   
		{
			composite.setText(text);
			composite.setEnabled(enabled);
		}
		return composite;
	}

	protected TableColumn createColumn(Table parent, String text, int aligment,int width) 
	{
		final TableColumn tc = new TableColumn(parent, aligment); // @jve
		tc.setText(text);
		tc.setWidth(width);
		return tc;
	}
}