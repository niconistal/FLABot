package org.isistan.flabot.executionstatemapping.commands.executioncondition;

import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;

public class ManagePersistentTreeElementCommand extends CompoundManageCommand {
	
	private TreeStructuredElement treeParentElement;
	
	private TreeStructuredElement treeChildElement;
	
	public ManagePersistentTreeElementCommand (TreeStructuredElement treeParentElement, TreeStructuredElement treeChildElement, boolean addCommand)
	{
		super(addCommand);
		this.treeParentElement = treeParentElement;		
		this.treeChildElement = treeChildElement;
		if (addCommand)
		{
			setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.executioncondition.ManagePersistentTreeElementCommand.commandAddName")); //$NON-NLS-1$
		}
		else
		{
			setLabel(Messages.getString("org.isistan.flabot.executionmapping.commands.executioncondition.ManagePersistentTreeElementCommand.commandDeleteName")); //$NON-NLS-1$
		}
	}
	
	public TreeStructuredElement getNewTreeStructuredElement()
	{
		return treeChildElement;
	}

	
	@Override
	public void add()
	{
		wasExecuted = treeParentElement.addPersistentTreeStructuredElement(treeChildElement);
		wasExecuted &= treeParentElement.addTreeStructuredElement(treeChildElement);
				
	}
	
	@Override
	public void remove()
	{
		treeParentElement.removeTreeStructuredElement(treeChildElement);
		wasExecuted = treeParentElement.removePersistentTreeStructuredElement(treeChildElement);		
	}
}