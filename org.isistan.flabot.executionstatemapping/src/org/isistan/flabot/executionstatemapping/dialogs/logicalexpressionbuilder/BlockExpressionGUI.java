package org.isistan.flabot.executionstatemapping.dialogs.logicalexpressionbuilder;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;


public class BlockExpressionGUI extends LogicalExpressionGUI {

	private List<LogicalExpressionGUI> logicalExpressionGUIList=new ArrayList<LogicalExpressionGUI>();
	
	private String internalConnector=LogicalExpressionGUI.defaultConnector;
	
	private boolean isMinimized=false;
	
	private Label labelMinimized;
	
	private Menu menu;
			
	public List<String> getErrors()
	{
		List<String> errors=new ArrayList<String>();
		for (LogicalExpressionGUI child:logicalExpressionGUIList)
			errors.addAll(child.getErrors());
		return errors;
	}
	
	public List<LogicalExpressionGUI> getLogicalExpressionGUIList()
	{
		return logicalExpressionGUIList;
	}
	
	public void setInternalConnector(String internalConnector)
	{
		this.internalConnector=internalConnector;
	}
	
	//Create partial Expression
	public BlockExpressionGUI(LogicalExpressionGUI parentExpression,Composite parentComposite, Composite  compositeAttributes, ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newExecutionConditionFilters)
	{	
		super(parentExpression,parentComposite,compositeAttributes, selectExecutionConditionFilters, newExecutionConditionFilters);
	}
	
	//Create complete Expression
	public BlockExpressionGUI(LogicalExpressionGUI parentExpression,Composite externalComposite, ViewFilterProvider[] selectExecutionConditionFilters, ViewFilterProvider[] newExecutionConditionFilters)
	{	
		super(parentExpression,externalComposite, selectExecutionConditionFilters, newExecutionConditionFilters);
	}
						
	@Override
	protected void createCompleteGUIExpression(Composite externalComposite)
	{
		createCompositeAttributes(externalComposite);
		
		GridData gridData3 = new GridData();
		gridData3.grabExcessHorizontalSpace=true;
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridLayout gridLayout = new GridLayout();
		gridLayout.marginHeight = 0;
		gridLayout.marginWidth = 0;
		parentComposite=new Composite(externalComposite, SWT.NONE);
		parentComposite.setLayout(gridLayout);
		parentComposite.setLayoutData(gridData3);
		createPartialGUIExpression();			
	}	
	
	@Override
	protected void createPartialGUIExpression() {
		GridData gridData2 = new GridData();
		gridData2.grabExcessHorizontalSpace = true;
		gridData2.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		GridLayout gridLayout2= new GridLayout();
		gridLayout2.numColumns = 2;
		gridLayout2.marginWidth=0;
		gridLayout2.marginHeight=0;
		gridLayout2.verticalSpacing=0;
		gridLayout2.horizontalSpacing=0;
		parentComposite.setLayout(gridLayout2);
		parentComposite.setLayoutData(gridData2);

		GridData gridData3 = new GridData();
		gridData3.grabExcessVerticalSpace = true;
		gridData3.horizontalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData3.verticalAlignment = org.eclipse.swt.layout.GridData.FILL;
		gridData3.widthHint = 15;
		Button button7 = new Button(parentComposite, SWT.NONE);
		button7.setLayoutData(gridData3);
		button7.addMouseListener(new MouseListener(){
			public void mouseDoubleClick(MouseEvent event){}
			public void mouseUp(MouseEvent event){}
			public void mouseDown(MouseEvent event)
			{
				if(isMinimized)
					maximizeBlock();
				else
					minimizeBlock();
			}
		});
		
		MouseListener museListener=new MouseListener(){
			public void mouseDoubleClick(MouseEvent event){}
			public void mouseUp(MouseEvent event){}
			public void mouseDown(MouseEvent event)
			{
				if(parentExpression!=null)
					parentExpression.notifyObservers();
			}
		};
					
		compositeAttributes.addMouseListener(museListener);		
		labelAttributes.addMouseListener(museListener);
		
		final Menu menuAttributes=createMenuAttributes();		
		buttonAttributes.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				Rectangle rect = buttonAttributes.getBounds();
				Point pt = new Point(rect.x, rect.y + rect.height);
			    pt = buttonAttributes.getParent().toDisplay(pt);
			    menu.setLocation(pt.x, pt.y);
			    menu.setVisible(true);
			}}
		);	
		buttonAttributes.setMenu(menu);
		this.menu=menuAttributes;		
				
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.grabExcessVerticalSpace = true;
		gridData4.verticalAlignment = GridData.FILL;
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.marginHeight = 10;
		gridLayout3.marginWidth = 10;
		gridLayout3.verticalSpacing=4;
		gridLayout3.horizontalSpacing=0;
	    expressionComposite = new Composite(parentComposite, SWT.BORDER|SWT.DOWN);
		expressionComposite.setLayout(gridLayout3);
		expressionComposite.setLayoutData(gridData4);
		expressionComposite.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WIDGET_BACKGROUND));
		expressionComposite.setBackgroundMode(SWT.INHERIT_DEFAULT);
		expressionComposite.addMouseListener(new MouseListener(){
			public void mouseDoubleClick(MouseEvent event){}
			public void mouseUp(MouseEvent event){}
			public void mouseDown(MouseEvent event)
			{
				notifyObservers();
			}
		});
		selectionableElement=expressionComposite;		
	}
		
	@Override
	public LogicalExpressionGUI addChild()
	{
		if(!isMinimized)
		{
			SingleExpressionGUI singleExpressionGUI=new SingleExpressionGUI(this,expressionComposite,selectExecutionConditionFilters,newExecutionConditionFilters);
			singleExpressionGUI.setObserver(guiObserver);
			singleExpressionGUI.setLogicalConnector(internalConnector);
			logicalExpressionGUIList.add(singleExpressionGUI);
		}
		return (parentExpression==null)?this:null;
	}
	
	@Override
	public AbstractExpression getExecutionConditionExpression()
	{
		BlockExpression blockExpression;
		if(internalConnector==LogicalExpressionGUI.andConector)
			blockExpression=SemanticFactory.eINSTANCE.createAndExpression();
		else
			blockExpression=SemanticFactory.eINSTANCE.createOrExpression();
		blockExpression.setIsNot(isNegated);
		for(LogicalExpressionGUI child:logicalExpressionGUIList)
		{
			AbstractExpression expressionChild=child.getExecutionConditionExpression();
			expressionChild.setParentExpression(blockExpression);
			blockExpression.getExpressionList().add(expressionChild);
		}
		return blockExpression;
	}

	private void createInfoMinimized()
	{
		GridData gridData4 = new GridData();
		gridData4.horizontalAlignment = GridData.FILL;
		gridData4.grabExcessHorizontalSpace = true;
		gridData4.grabExcessVerticalSpace = true;
		gridData4.verticalAlignment = GridData.FILL;
		GridLayout gridLayout3 = new GridLayout();
		gridLayout3.horizontalSpacing=0;
		labelMinimized= new Label(expressionComposite, SWT.NONE);
		
		String minimizedText=toString();
		if(isNegated)
			minimizedText=minimizedText.replaceFirst("NOT ",""); //$NON-NLS-1$ //$NON-NLS-2$
		
		labelMinimized.setText(minimizedText);
		labelMinimized.setFont(defaultFont);
		labelMinimized.addMouseListener(new MouseListener(){
			public void mouseDoubleClick(MouseEvent event){}
			public void mouseUp(MouseEvent event){}
			public void mouseDown(MouseEvent event)
			{
				notifyObservers();
			}
		});
		expressionComposite.setLayout(gridLayout3);
		expressionComposite.setLayoutData(gridData4);
	}
	@Override
	public void reDrawGUIExpression(Composite externalComposite)
	{
		this.externalComposite=externalComposite;
		createCompleteGUIExpression(externalComposite);
		if(!isMinimized)
		{
			for(LogicalExpressionGUI child: logicalExpressionGUIList)
				child.reDrawGUIExpression(expressionComposite);
			setChildsConnector();
		}
		else
			createInfoMinimized();
		if(isMinimized)
			menu.getItems()[1].setEnabled(false);
		showAttributesText();
	}
	
	
	public void minimizeBlock()
	{
		if(!isMinimized)
		{
			isMinimized=true;
			notifyObservers();
			for(LogicalExpressionGUI child: logicalExpressionGUIList)
				child.dispose();
			createInfoMinimized();
			menu.getItems()[1].setEnabled(false);
			notifyObservers();
		}
	}
	
	public void maximizeBlock()
	{
		if(isMinimized)
		{
			isMinimized=false;
			notifyObservers();
			labelMinimized.dispose();
			GridData gridData4 = new GridData();
			gridData4.horizontalAlignment = GridData.FILL;
			gridData4.grabExcessHorizontalSpace = true;
			gridData4.grabExcessVerticalSpace = true;
			gridData4.verticalAlignment = GridData.FILL;
			GridLayout gridLayout3 = new GridLayout();
			gridLayout3.marginHeight = 10;
			gridLayout3.marginWidth = 10;
			gridLayout3.verticalSpacing=4;
			gridLayout3.horizontalSpacing=0;
			expressionComposite.setLayout(gridLayout3);
			expressionComposite.setLayoutData(gridData4);
			for(LogicalExpressionGUI child: logicalExpressionGUIList)
				child.reDrawGUIExpression(expressionComposite);
			menu.getItems()[1].setEnabled(true);
			notifyObservers();
		}
	}
	

	@Override
	public String toString()
	{
		StringBuilder builder=new StringBuilder();
		builder.append((isNegated?"NOT ":"")); //$NON-NLS-1$ //$NON-NLS-2$
		builder.append("("); //$NON-NLS-1$
		for(LogicalExpressionGUI child: logicalExpressionGUIList)
		{
			builder.append(" "); //$NON-NLS-1$
			builder.append(child.toString());
			builder.append(" "); //$NON-NLS-1$
			builder.append(internalConnector);
		}
		builder.delete(builder.length()-internalConnector.length(), builder.length());
		builder.append(")"); //$NON-NLS-1$
		return builder.toString();
	}
	
	@Override
	public void changeChildsConnector()
	{
		internalConnector=(internalConnector==andConector?orConector:andConector);
		setChildsConnector();
	}
	
	protected void setChildsConnector()
	{
		for (int i=1; i<logicalExpressionGUIList.size();i++)
			logicalExpressionGUIList.get(i).setLogicalConnector(internalConnector);
		showAttributesText();
	}

	protected void updateChild(LogicalExpressionGUI oldChild,LogicalExpressionGUI newChild)
	{
		for (int i=0; i<logicalExpressionGUIList.size();i++)
			if (logicalExpressionGUIList.get(i).equals(oldChild))
			{
				logicalExpressionGUIList.set(i,newChild);
				return;
			}
	}
	
	@Override
	public void dispose()
	{
		compositeAttributes.dispose();
		parentComposite.dispose();
	}
	
	@Override
	public LogicalExpressionGUI delete()
	{
		if(isMinimized)
			maximizeBlock();
		if (parentExpression!=null)
			return ((BlockExpressionGUI)parentExpression).deleteChild(this);
		return null;
	}
	
	private int getChildPosition(LogicalExpressionGUI child)
	{
		for (int i=0; i<logicalExpressionGUIList.size();i++)
			if (logicalExpressionGUIList.get(i).equals(child))
				return i;
		return -1;
	}
	
	
	protected void replaceChild(LogicalExpressionGUI oldChild,LogicalExpressionGUI newChild)
	{
		notifyObservers();
		int pos=getChildPosition(oldChild);
		if(pos==0)
			newChild.setLogicalConnector(null);
		for (int i=pos; i<logicalExpressionGUIList.size();i++)
			logicalExpressionGUIList.get(i).dispose();
		logicalExpressionGUIList.set(pos,newChild);
		for (int i=pos; i<logicalExpressionGUIList.size();i++)
			logicalExpressionGUIList.get(i).reDrawGUIExpression(expressionComposite);
		newChild.notifyObservers();
	}
	
	
	protected LogicalExpressionGUI deleteChild(LogicalExpressionGUI child)
	{
		int pos=getChildPosition(child);
		if(pos!=-1)
		{
			if(logicalExpressionGUIList.size()>2)
			{
				//Notifica a la expression anterior para que se marque como seleccionada.
				logicalExpressionGUIList.get((pos==0)?1:pos-1).notifyObservers();
				child.dispose();
				logicalExpressionGUIList.remove(pos);
				if (pos==0)
					logicalExpressionGUIList.get(0).setLogicalConnector(null);
				return null;
			}
			else
			{
				LogicalExpressionGUI childQueda=logicalExpressionGUIList.get((pos==0)?1:0);
				childQueda.parentExpression=parentExpression;
				if (parentExpression!=null)
				{
					((BlockExpressionGUI)parentExpression).replaceChild(this,childQueda);
					return null;
				}
				else
				{
					childQueda.notifyObservers();
					this.dispose();
					childQueda.reDrawGUIExpression(externalComposite);
					childQueda.setLogicalConnector(null);
					childQueda.notifyObservers();
					return childQueda;
				}
			}
		}
		return null;
	}
	
    @Override
	public boolean permitLogicalConnector()
    {
    	return true;
    }
    
}
