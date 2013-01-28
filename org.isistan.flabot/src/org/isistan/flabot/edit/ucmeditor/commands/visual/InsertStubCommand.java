/**
 * $Id: InsertStubCommand.java,v 1.2 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.StubFigure;
import org.isistan.flabot.messages.Messages;

/**
 * Command that inserts a stub node in a path
 * 
 * InsertStubCommand
 * -	Extends InsertPathNodeCommand.
 * -	Inserts a stub node into an existing path.
 * 
 * @author $Author: franco $
 *
 */
public class InsertStubCommand extends InsertPathNodeCommand {

	/**
	 * Create an instance of this command that will insert a stub
	 * on the selected visual node
	 * @param visualNode the selected node in which the stub will be inserted
	 * @param stubNode the new StubNode semantic model
	 */
	public InsertStubCommand(NodeVisualModel visualNode, StubNode stubNode) {		
		super(visualNode, stubNode, StubFigure.defaultsize);
		newVisualNode.setForegroundColor(visualNode.getForegroundColor().clone());
		newVisualNode.setBackgroundColor(visualNode.getForegroundColor().clone());
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertStubCommand.label")); //$NON-NLS-1$
	}
	
	protected void doInsertPathNode() {	
		super.doInsertPathNode();
		((StubNode)newNode).getMap().getCoreModel().getStubs().add(newNode);
		
		if (((StubNode)newNode).getFamily() != null)
			((StubNode)newNode).getFamily().getAssociatedResponsibilities().add(newNode);
		
	}
	
	protected void undoInsertPathNode() {			
		super.undoInsertPathNode();
		((StubNode)newNode).getMap().getCoreModel().getStubs().remove(newNode);
		
		if (((StubNode)newNode).getFamily() != null)
			((StubNode)newNode).getFamily().getAssociatedResponsibilities().remove(newNode);
	}
	
}