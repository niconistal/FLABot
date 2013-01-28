package org.isistan.flabot.executionstatemapping.commands.executioncondition;

import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

public class ManageTreeStructure extends CompoundManageCommand {

	protected final TreeStructuredElement mappedTreeContainer;

	protected final TreeStructuredElement elementTree;
	
	protected TreeStructuredElement parentTree;

	protected String[] keyParents;
	
	protected TreeType[] levelOrder;

	public ManageTreeStructure(
			TreeStructuredElement mappedTreeContainer,
			TreeStructuredElement elementTree,
			String[] keyParents, TreeType[] levelOrder, boolean addCommand)
	{
		super(addCommand);
		this.mappedTreeContainer = mappedTreeContainer;
		this.elementTree = elementTree;
		this.keyParents = keyParents;
		this.levelOrder = levelOrder;
	}
	
	public ManageTreeStructure(
			MappedTreeStructuredElement mappedTreeContainer,
			TreeStructuredElement elementTree,
			boolean addCommand)
	{
		this(mappedTreeContainer, elementTree, null, null, addCommand);
	}

	private void checkPreviousLevel()
	{
		if (addCommand)
		{
			MappedTreeStructuredElement mappedTreeParent = (MappedTreeStructuredElement)mappedTreeContainer;
			for(String key : keyParents)
			{
				mappedTreeParent = (MappedTreeStructuredElement) mappedTreeParent.getTreeStructuredElement(key);
				if (mappedTreeParent == null)
				{
					parentTree = SemanticFactory.eINSTANCE.createMappedTreeStructuredElement(levelOrder[levelOrder.length - 1]);
					parentTree.setName(keyParents[keyParents.length - 1]);
					addPreviousLevelCommand(parentTree);
					break;
				}
				else
				{
					parentTree = mappedTreeParent;
				}
			}		
		}
		else
		{
			if (levelOrder != null && levelOrder.length > 0)
			{
				parentTree = elementTree.getAntecesor(levelOrder[levelOrder.length - 1]);
				if (parentTree.uGetTreeStructuredElements()
					.size() == 1)
				{
					addPreviousLevelCommand(parentTree);
				}
			}
		}
		
		if (parentTree == null)
		{
			parentTree = mappedTreeContainer;
		}
	}

	private void addPreviousLevelCommand(
			TreeStructuredElement newTreeElement)
	{
		String[] newKeyParents = new String[keyParents.length-1];
		TreeType[] newLevelOrder = new TreeType[levelOrder.length-1];
		for(int i=0; i<keyParents.length-1; i++)
		{
			newKeyParents[i] = keyParents[i];
			newLevelOrder[i] = levelOrder[i];
		}
		
		add(new ManageTreeStructure(
				mappedTreeContainer, newTreeElement,
				newKeyParents, newLevelOrder, addCommand));
	}
	
	@Override
	public void execute()
	{
		checkPreviousLevel();
		super.execute();
	}

	@Override
	protected void add()
	{
		wasExecuted = parentTree
				.addTreeStructuredElement(elementTree);
		
		if (usePersistentList())
		{
			wasExecuted &= parentTree.addPersistentTreeStructuredElement(elementTree);			
		}	
	}

	@Override
	protected void remove()
	{
		wasExecuted = parentTree
				.removeTreeStructuredElement(elementTree);
		
		if (usePersistentList())
		{
			wasExecuted &= parentTree.removePersistentTreeStructuredElement(elementTree);			
		}
	}
	
	private boolean usePersistentList()
	{
		return elementTree.getType() == TreeType.PROJECT_TYPE || elementTree.getType() == TreeType.PACKAGE_ROOT_TYPE || elementTree.getType() == TreeType.CONTAINER_TYPE;
	}
}