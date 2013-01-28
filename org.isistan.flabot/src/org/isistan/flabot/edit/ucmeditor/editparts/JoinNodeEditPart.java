/**
 * $Id: JoinNodeEditPart.java,v 1.29 2006/05/08 23:23:46 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editor.commands.SetDetailLevelCommand;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteResponsibilityNodeAssociationsCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteJoinCommand;
import org.isistan.flabot.edit.ucmeditor.figures.AndJoinFigure;
import org.isistan.flabot.edit.ucmeditor.figures.OrJoinFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class JoinNodeEditPart extends ResponsibilityNodeEditPart {

	@Override
	protected void createEditPolicies() {
		super.createEditPolicies();
		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			/** 
			 * create a delete command for this path node
			 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
			 */
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return getDeletePathNodeCommand();
			}						
		});			
	}
	
	protected Command getDeletePathNodeCommand() {
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.JoinNodeEditPart.deleteVisualCommandLabel")); //$NON-NLS-1$
		commands.add(new SetDetailLevelCommand(getCastedModel(), VisualModel.LOW_DETAIL));
		commands.add(getConnectionsDeleteCommand(getTargetConnections()));
		if (verifySelection()) {
			commands.add(new DeleteResponsibilityNodeAssociationsCommand(getCastedModel().getDiagram().getCoreModel(), (ResponsibilityNode)getCastedModel().getSemanticModel()));
			commands.add(new DeleteJoinCommand(getCastedModel()));
			return commands;
		}
		if (commands.size() <= 0) commands= null;
		return commands;
	}
	
	private boolean verifySelection() {
		List editParts = getViewer().getSelectedEditParts();
		List deleteList = new BasicEList();
		for (int i=0; i < editParts.size(); i++){
			if ((editParts.get(i) instanceof PathNodeEditPart && ((PathNodeEditPart)editParts.get(i)).getSemanticModel().isStart())){
				List tempList = new BasicEList();
				generateListToDelete(((PathNodeEditPart)editParts.get(i)).getSemanticModel(), tempList);
				deleteList.addAll(tempList);
			}
		}
		if (deleteList.contains(this.getSemanticModel()))
			return false;
		return true;
	}
	
	private void generateListToDelete(PathNode node, List temp){
		if (node instanceof JoinNode || node instanceof ForkNode){
			temp.add(node);
		}
		else{
			for (int i=0; i < node.uGetNext().size(); i++){
				temp.add((PathNode)node.uGetNext().get(i));
				generateListToDelete ((PathNode)node.uGetNext().get(i),temp);
			}
		}
	}

		
	@Override
	protected IFigure createFigure() {
		ThreeConnectionFigure f = null;
		JoinNode joinNode = (JoinNode)getCastedModel().getSemanticModel();
		if (joinNode.getJoinType() == JoinNode.AND_JOIN_TYPE)
		  f = new AndJoinFigure(
				  getCastedModel().getRotation(), 
				  Util.getSWTRGB(getCastedModel().getForegroundColor()),
				  getCorrectParent().getFigure(),
				  joinNode.getInputsCount()
				  );
		else if (joinNode.getJoinType() == JoinNode.OR_JOIN_TYPE)
		  f = new OrJoinFigure(
				  getCastedModel().getRotation(), 
				  Util.getSWTRGB(getCastedModel().getForegroundColor()),
				  getCorrectParent().getFigure(),
				  joinNode.getInputsCount()
				  );
		f.setNamePoint(((JoinNode)getCastedVisualModel().getSemanticModel()).getName());
		
		return f;
	}
		
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent container 
		// (the Figure of the DiagramEditPart), will not know the bounds of this figure
		// and will not draw it correctly.
		Rectangle bounds = Util.getDraw2DRectangle(
				getCastedModel().getLocation(),
				getCastedModel().getSize()
				);
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
	}
	
	private ThreeConnectionFigure getCastedFigure() {
		return (ThreeConnectionFigure) getFigure();
	}	
		
	/**
	 * change notification received
	 */
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		switch (notification.getEventType()) {
			case Notification.SET:
			case Notification.UNSET:
				switch(notification.getFeatureID(EditormodelPackage.class)) {
					case EditormodelPackage.NODE_VISUAL_MODEL__ROTATION:
						getCastedFigure().setRotation(getCastedModel().getRotation());
						refreshVisuals();
						break;
				}
		}
	}
}