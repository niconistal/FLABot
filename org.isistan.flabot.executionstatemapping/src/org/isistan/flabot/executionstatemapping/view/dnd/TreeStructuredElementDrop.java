package org.isistan.flabot.executionstatemapping.view.dnd;

import org.eclipse.gef.commands.CommandStack;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jface.util.TransferDropTargetListener;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.TreeItem;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManagePersistentTreeElementCommand;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

public class TreeStructuredElementDrop implements TransferDropTargetListener {
	
	private Transfer transfer;
	
	private TreeStructuredElement target;
	
	private CommandStack commandStack;
	
	public TreeStructuredElementDrop(CommandStack commandStack) {
		this.commandStack = commandStack;
		this.transfer = TextTransfer.getInstance();
	}
	
	public void dragEnter(DropTargetEvent event) {
	}
	
	public boolean isEnabled(DropTargetEvent event) {
		return false;
	}

	public Transfer getTransfer() {
		return transfer;
	}

	public void dragLeave(DropTargetEvent event) {
	}

	public void dragOperationChanged(DropTargetEvent event) {
	}

	public void dragOver(DropTargetEvent event) {
	}

	public void drop(DropTargetEvent event) {
		if (event.item != null && event.item instanceof TreeItem)
		{
			target = (TreeStructuredElement) event.item.getData();
			TreeStructuredElement source = DragTransfer.getTreeStructuredElement();
			if ( source != null && source != target && !isChild(source, target) &&
				((source.getType() == TreeType.FOLDER_STATE_DIAGRAM_TYPE && target.getType() == TreeType.FOLDER_STATE_DIAGRAM_TYPE) ||
				(source.getType() == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE && target.getType() == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE) ||
				(source.getType() == TreeType.STATE_DIAGRAM_TYPE && target.getType() == TreeType.FOLDER_STATE_DIAGRAM_TYPE) ||
				(source.getType() == TreeType.EXECUTION_CONDITION_TYPE && target.getType() == TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE)))
			{
				CompoundCommand commands = new CompoundCommand();
				commands.setLabel(Messages.getString("org.isistan.flabot.executionmapping.view.dnd.TreeStructuredElementDrop.reparentCommandName")); //$NON-NLS-1$
				commands.add(new ManagePersistentTreeElementCommand(source.getParent(), source, false));
				commands.add(new ManagePersistentTreeElementCommand(target, source, true));
				commandStack.execute(commands);
			}			
		}
	}
	
	private boolean isChild(TreeStructuredElement parent, TreeStructuredElement child)
	{
		boolean isChild = false;
		for(TreeStructuredElement treeElement : parent.uGetTreeStructuredElements())
		{
			if (child == treeElement)
			{
				isChild = true;
				break;
			}
			else
			{
				isChild = isChild(treeElement, child);
			}
		}
		return isChild;
	}

	public void dropAccept(DropTargetEvent event) {
	}
}