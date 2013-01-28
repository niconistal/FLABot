package org.isistan.flabot.edit.ucmeditor.commands.visual;

import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.DynamicStubFigure;
import org.isistan.flabot.edit.ucmeditor.figures.StubFigure;
import org.isistan.flabot.messages.Messages;

public class InsertDynamicStubCommand extends InsertPathNodeCommand {

	private DynamicStubNode dynamicStubNode;
	/**
	 * Create an instance of this command that will insert a dynamic stub
	 * on the selected visual node
	 * @param visualNode the selected node in which the stub will be inserted
	 * @param dynamicStubNode the new DynamicStubNode semantic model
	 */
	public InsertDynamicStubCommand(NodeVisualModel visualNode, DynamicStubNode dynamicStubNode) {		
		super(visualNode, dynamicStubNode, DynamicStubFigure.defaultsize);
		newVisualNode.setForegroundColor(visualNode.getForegroundColor().clone());
		newVisualNode.setBackgroundColor(visualNode.getForegroundColor().clone());
		this.dynamicStubNode = dynamicStubNode;
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.InsertDynamicStubCommand.label")); //$NON-NLS-1$
	}
	
	protected void doInsertPathNode() {	
		super.doInsertPathNode();
		((DynamicStubNode)newNode).getMap().getCoreModel().getDynamicStubs().add(newNode);
		
		updateResponsibilityNode();
	}
	
	protected void undoInsertPathNode() {			
		super.undoInsertPathNode();		
		((DynamicStubNode)newNode).getMap().getCoreModel().getDynamicStubs().remove(newNode);
		
		undoUpdateResponsibilityNode();
	}
	
	private void updateResponsibilityNode()
	{
		for (int i=0; i < dynamicStubNode.getConditionedStubs().size(); i++)
		{
			ConditionedStub conditionedStub = (ConditionedStub)dynamicStubNode.getConditionedStubs().get(i);
			ResponsibilityNode responsibilityNode = conditionedStub.getResponsibilityNode();
			responsibilityNode.setMap(dynamicStubNode.getMap());
			//responsibilityNode.setPath(newNode.getPath());
			
//			updatePreviousNodes(responsibilityNode);
//			
//			updateNextNodes(responsibilityNode);
		}
	}
	
	private void updatePreviousNodes(ResponsibilityNode responsibilityNode)
	{
		for (int j=0; j < newNode.uGetPrevious().size(); j++)
		{
			PathNode node = (PathNode) newNode.uGetPrevious().get(j);
			responsibilityNode.addPrevious(node);
		}
	}
	
	private void updateNextNodes(ResponsibilityNode responsibilityNode)
	{
		for (int j=0; j < newNode.uGetNext().size(); j++)
		{
			PathNode node = (PathNode) newNode.uGetNext().get(j);
			responsibilityNode.addNext(node);
		}
	}
	
	private void undoUpdateResponsibilityNode()
	{
		for (int i=0; i < dynamicStubNode.getConditionedStubs().size(); i++)
		{
			ConditionedStub conditionedStub = (ConditionedStub)dynamicStubNode.getConditionedStubs().get(i);
			ResponsibilityNode responsibilityNode = conditionedStub.getResponsibilityNode();
			responsibilityNode.setMap(null);
			//responsibilityNode.setPath(null);
			
//			undoUpdatePreviousNodes(responsibilityNode);
//			
//			undoUpdateNextNodes(responsibilityNode);
		}
	}
	
	private void undoUpdatePreviousNodes(ResponsibilityNode responsibilityNode)
	{
		for (int j=0; j < newNode.uGetPrevious().size(); j++)
		{
			PathNode node = (PathNode) newNode.uGetPrevious().get(j);
			responsibilityNode.removePrevious(node);
		}
	}
	
	private void undoUpdateNextNodes(ResponsibilityNode responsibilityNode)
	{
		for (int j=0; j < newNode.uGetNext().size(); j++)
		{
			PathNode node = (PathNode) newNode.uGetNext().get(j);
			responsibilityNode.removeNext(node);
		}
	}
}
