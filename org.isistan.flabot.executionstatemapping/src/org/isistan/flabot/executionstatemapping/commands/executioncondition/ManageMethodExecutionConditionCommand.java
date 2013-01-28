package org.isistan.flabot.executionstatemapping.commands.executioncondition;

import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

public class ManageMethodExecutionConditionCommand extends ManageTreeStructure
{	
	private TreeStructuredElement packageRootType;	
		
	public ManageMethodExecutionConditionCommand(
			MappedTreeStructuredElement executionConditionContainer,
			String[] keyParents, TreeType[] levelOrder,
			ExecutionCondition executionCondition)
	{		
		super(executionConditionContainer, executionCondition, true);
		this.keyParents = keyParents;
		this.levelOrder = levelOrder;
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.executioncondition.ManageMethodExecutionConditionCommand.commandAddName")); //$NON-NLS-1$
	}

	public ManageMethodExecutionConditionCommand(
			MappedTreeStructuredElement executionConditionContainer,			
			ExecutionCondition executionCondition)
	{
		super(executionConditionContainer, executionCondition, false);
		packageRootType = executionCondition.getAntecesor(TreeType.PACKAGE_ROOT_TYPE);
		this.keyParents = new String[] {"", "", "", "" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
		this.levelOrder = new TreeType[] {TreeType.PROJECT_TYPE, TreeType.PACKAGE_ROOT_TYPE, TreeType.PACKAGE_TYPE, TreeType.CLASS_TYPE };
		setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.executioncondition.ManageMethodExecutionConditionCommand.commandDeleteName")); //$NON-NLS-1$
	}
	
	public TreeStructuredElement getNewTreeStructuredElement()
	{
		return elementTree;
	}
			
	@Override
	protected void add()
	{
		super.add();
		if (packageRootType == null)
		{
			packageRootType = elementTree.getAntecesor(TreeType.PACKAGE_ROOT_TYPE);
		}
		if (packageRootType != null)
		{
			wasExecuted &= packageRootType.addPersistentTreeStructuredElement(elementTree);
		}

	}

	@Override
	protected void remove()
	{
		super.remove();		
		if (packageRootType != null)
		{
			wasExecuted &= packageRootType.removePersistentTreeStructuredElement(elementTree);
		}
	}
}