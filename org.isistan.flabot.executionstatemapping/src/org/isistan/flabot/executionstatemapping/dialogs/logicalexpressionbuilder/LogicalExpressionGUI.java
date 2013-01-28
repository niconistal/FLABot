package org.isistan.flabot.executionstatemapping.dialogs.logicalexpressionbuilder;

import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.utils.errors.Validator;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;

public abstract class LogicalExpressionGUI extends Observable implements Validator{
     
	protected static final String notConector	="NOT"; //$NON-NLS-1$
	protected static final String orConector	="OR"; //$NON-NLS-1$
	protected static final String andConector	="AND"; //$NON-NLS-1$
	protected static final String defaultConnector =orConector;
	protected static final Color selectedColor	  =Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND);
	protected static final Color notSelectedColor=Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND);
	protected static final Font defaultFont= new Font(Display.getDefault(), "Tahoma", 7, SWT.BOLD); //$NON-NLS-1$
	
	protected Control selectionableElement;	
	
	/**
	 * Parent Expression
	 */
	protected LogicalExpressionGUI parentExpression = null;
	
	/**
	 * This observer will be atached to new childs.
	 */
	protected Observer guiObserver=null;
	
	/**
	 * Is selected in the GUI dialog 
	 */
	protected boolean isSelected =false;
	
	/**
	 * Parent SWT Composite
	 */
	protected Composite parentComposite = null;
	
	/**
	 * Show the expression's attributes 
	 */
	protected Label labelAttributes = null; 
	
	/**
	 * True if the expression is negated
	 */
	protected boolean isNegated=false;
	
	/**
	 * Associated logicalConnector
	 */
	private String parentConnector =null;
	
	/**
	 * Main Expression Composite
	 */
	protected Composite expressionComposite;
	
	protected Composite externalComposite;
	
	protected Composite compositeAttributes;
	
	protected Button buttonAttributes;
	
	protected ViewFilterProvider[] selectExecutionConditionFilters;
	
	protected ViewFilterProvider[] newExecutionConditionFilters;
	
	/**
	 * Constructor
	 * @param parentExpression
	 * @param parentComposite
	 * @param labelConjunction
	 */
	public LogicalExpressionGUI(LogicalExpressionGUI parentExpression,Composite parentComposite,Composite compositeAttributes, ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newExecutionConditionFilters)
    {
		this.parentExpression=parentExpression;
    	this.parentComposite=parentComposite;
    	this.selectExecutionConditionFilters = selectExecutionConditionFilters;
    	this.newExecutionConditionFilters = newExecutionConditionFilters;
    	
    	this.compositeAttributes=compositeAttributes;
    	this.labelAttributes=(Label)compositeAttributes.getChildren()[0];
    	this.buttonAttributes=(Button)compositeAttributes.getChildren()[1];
    	this.externalComposite=parentComposite.getParent();
    	
    	createPartialGUIExpression();
    	showAttributesText();
    }
	
	protected void setNegated(boolean state)
	{
		isNegated=state;
	}
	
	public LogicalExpressionGUI(LogicalExpressionGUI parentExpression, Composite externalComposite, ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newExecutionConditionFilters)
    {
		this.parentExpression=parentExpression;
		this.externalComposite=externalComposite;
		this.selectExecutionConditionFilters = selectExecutionConditionFilters;
    	this.newExecutionConditionFilters = newExecutionConditionFilters;
		createCompleteGUIExpression(externalComposite);
		showAttributesText();
    }
	
	/**
	 * 
	 * @return parentExpression
	 */
	public LogicalExpressionGUI getParentExpression()
	{
		return parentExpression;
	}
	
	/**
	 * 
	 * @return parentComposite
	 */
	public Composite getExpressionComposite()
	{
		return expressionComposite;
	}
	
	/**
	 * 
	 * @return Label Attributes
	 */
	public Label getAtributtesLabel()
	{
		return labelAttributes;
	}
	
	/**
	 * Negate the expression
	 */
	public void negateExpression()
	{
		isNegated=(!isNegated);
		showAttributesText();
	}
	
	/**
	 * Fill the label Attributes
	 */
	protected void showAttributesText()
	{
		labelAttributes.setText(((parentConnector!=null)?parentConnector+" ":"")+(isNegated?notConector+" ":"")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		labelAttributes.pack();
	}
	
	/**
	 * Set the parent observer
	 * @param obs
	 */
	public void setObserver(Observer obs)
	{
		guiObserver=obs;
		super.addObserver(obs);
	}
	/***
	 * Notify Changes to the observers
	 */
	@Override
	public void notifyObservers() {
		setChanged();
		super.notifyObservers(this);
	}
	
	protected void setLogicalConnector(String logicalConnector)
	{
		this.parentConnector=logicalConnector;
		showAttributesText();
	}
	
	protected String getLogicalConnector()
	{
		return parentConnector;
	}

	public int getExpressionWidth()
	{
		return expressionComposite.getSize().x;
	}
	
	public int getExpressionHigth()
	{
		return expressionComposite.getSize().y+labelAttributes.getSize().y;
	}
	
	protected abstract void createPartialGUIExpression();
	protected abstract void reDrawGUIExpression(Composite externalComposite);
    protected abstract void createCompleteGUIExpression(Composite externalComposite);
    public abstract LogicalExpressionGUI addChild();
    protected abstract void changeChildsConnector();
	public void setSelected(boolean state)
	{
		 isSelected=state;
		 buttonAttributes.setVisible(state);
		 selectionableElement.setBackground(state?selectedColor:notSelectedColor);
	}
	
	public abstract AbstractExpression getExecutionConditionExpression();
	public abstract boolean permitLogicalConnector();
  
    @Override
	public abstract String toString();
	
    protected Menu createMenuAttributes()
    {
    	final Menu menu = new Menu(buttonAttributes);
    	
    	MenuItem menuItem = new MenuItem(menu, SWT.PUSH);
		menuItem.setText("NOT"); //$NON-NLS-1$
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				negateExpression();
			}
		});
		
		if(permitLogicalConnector())
		{
	    	menuItem = new MenuItem(menu, SWT.PUSH);
	    	menuItem.setText("AND/OR"); //$NON-NLS-1$
	    	menuItem.addSelectionListener(new SelectionAdapter() {
	    		@Override
				public void widgetSelected(SelectionEvent e) {
	    			changeChildsConnector();
	    	}
	    	});
		}
		return menu;
    }
    
    
    protected void createCompositeAttributes(Composite externalComposite)
    {
    	compositeAttributes=new Composite(externalComposite, SWT.NONE);
		GridLayout gridLayout1 = new GridLayout();
		gridLayout1.marginHeight = 0;
		gridLayout1.marginWidth = 0;
		gridLayout1.numColumns=2;
		gridLayout1.horizontalSpacing=0;
		
		GridData gridData = new GridData();
		gridData.grabExcessHorizontalSpace=true;
		gridData.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		
		compositeAttributes.setLayoutData(gridData);
		compositeAttributes.setLayout(gridLayout1);
		
		
		labelAttributes = new Label(compositeAttributes, SWT.NONE);
		labelAttributes.setFont(defaultFont);
		labelAttributes.setLayoutData(gridData);
		
		
		GridData gridData2 = new GridData();
		gridData2.heightHint=20;
		gridData2.horizontalSpan=0;
		gridData2.widthHint=20;
		gridData2.verticalAlignment=SWT.CENTER;
		buttonAttributes=new Button(compositeAttributes,SWT.CENTER);
		buttonAttributes.setImage(ImageDescriptor.createFromFile(
				ExecutionConditionPlugin.class, "icons/options.gif").createImage()); //$NON-NLS-1$
		buttonAttributes.setLayoutData(gridData2);
		buttonAttributes.setVisible(false);
		
    }
    
	
	public abstract LogicalExpressionGUI delete();
    public abstract void dispose();
}
