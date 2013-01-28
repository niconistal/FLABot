package org.isistan.flabot.executionstatemapping.dialogs.logicalexpressionbuilder;

import java.util.Observer;

import org.eclipse.swt.widgets.Composite;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.AbstractExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.AndExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.BlockExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.OrExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.SingleExpression;
import org.isistan.flabot.executionstatemapping.model.semantic.VisitorExpression;

public class ExpressionGUIBuilder implements VisitorExpression {
	
	private Composite parentComposite;
	
	private LogicalExpressionGUI parentExpression;
	
	private LogicalExpressionGUI rootExpression;
	
	private Observer guiObserver;
	
	private ViewFilterProvider[] selectExecutionConditionFilters = null;
	
	private ViewFilterProvider[] newExecutionConditionFilters = null;
	
	public ExpressionGUIBuilder(Composite parentComposite, Observer guiObserver)
	{
		this.parentComposite=parentComposite;
		this.parentExpression=null;
		this.guiObserver=guiObserver;
	}
	
	public void setSelectExecutionConditionFilters(ViewFilterProvider[] selectExecutionConditionFilters)
	{
		this.selectExecutionConditionFilters = selectExecutionConditionFilters;
	}
	
	public void setNewExecutionConditionFilters(ViewFilterProvider[] newExecutionConditionFilters)
	{
		this.newExecutionConditionFilters = newExecutionConditionFilters;
	}	
	
	public LogicalExpressionGUI makeGUIExpression(AbstractExpression root)
	{
		root.accept(this);
		parentComposite.pack();
		parentComposite.layout();
		return rootExpression;
	}
	
	public void visit(AndExpression andExpression)
	{
		processBlockExpression(LogicalExpressionGUI.andConector,andExpression);
	}
	
	public void visit(OrExpression orExpression)
	{
		processBlockExpression(LogicalExpressionGUI.orConector,orExpression);
	}
	
	private void processBlockExpression(String logicalConnector,BlockExpression blockEvent)
	{
		BlockExpressionGUI blockExpression=new BlockExpressionGUI(parentExpression,parentComposite,selectExecutionConditionFilters,newExecutionConditionFilters);
		blockExpression.setObserver(guiObserver);
		blockExpression.setNegated(blockEvent.isIsNot());
		if (parentExpression!=null)
			((BlockExpressionGUI)parentExpression).getLogicalExpressionGUIList().add(blockExpression);
		if (rootExpression==null)
			rootExpression=blockExpression;
		
		Composite compositeAux=parentComposite;
		LogicalExpressionGUI expressionAux=parentExpression;
		
		for(AbstractExpression expression:blockEvent.getExpressionList())
		{
			parentExpression=blockExpression;
			parentComposite=blockExpression.getExpressionComposite();
			expression.accept(this);
		}
		parentExpression=expressionAux;
		parentComposite=compositeAux;
		blockExpression.setInternalConnector(logicalConnector);
		blockExpression.setChildsConnector();
		blockExpression.showAttributesText();
	}
	
	
	
	public void visit(SingleExpression singleExpr)
	{
		SingleExpressionGUI singleExpression=new SingleExpressionGUI(parentExpression,parentComposite,selectExecutionConditionFilters,newExecutionConditionFilters);
		singleExpression.setObserver(guiObserver);
		if (rootExpression==null)
			rootExpression=singleExpression;
		if (parentExpression!=null)
			((BlockExpressionGUI)parentExpression).getLogicalExpressionGUIList().add(singleExpression);
		singleExpression.setNegated(singleExpr.isIsNot());
		singleExpression.addElement(singleExpr.getExecutionCondition());
		singleExpression.showAttributesText();
	}
}
