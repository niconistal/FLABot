/** * $Id: ForkNodeEditPart.java,v 1.32 2006/05/08 23:23:46 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.Iterator;import java.util.List;import org.eclipse.draw2d.IFigure;import org.eclipse.draw2d.geometry.Rectangle;import org.eclipse.emf.common.notify.Notification;import org.eclipse.emf.common.util.BasicEList;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.GraphicalEditPart;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.editpolicies.ComponentEditPolicy;import org.eclipse.gef.requests.GroupRequest;import org.isistan.flabot.coremodel.CoremodelPackage;import org.isistan.flabot.coremodel.ForkCondition;import org.isistan.flabot.coremodel.ForkNode;import org.isistan.flabot.coremodel.JoinNode;import org.isistan.flabot.coremodel.PathNode;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.edit.editor.commands.SetDetailLevelCommand;import org.isistan.flabot.edit.editormodel.EditormodelPackage;import org.isistan.flabot.edit.editormodel.Util;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteResponsibilityNodeAssociationsCommand;import org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteForkCommand;import org.isistan.flabot.edit.ucmeditor.figures.AndForkFigure;import org.isistan.flabot.edit.ucmeditor.figures.OrForkFigure;import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;import org.isistan.flabot.messages.Messages;public class ForkNodeEditPart extends ResponsibilityNodeEditPart {		public void activate() {		if (!isActive()) {			super.activate();			ForkNode fork = (ForkNode) getCastedModel().getSemanticModel();			if (fork.getForkType() == ForkNode.OR_FORK_TYPE) {				for (Iterator iter=fork.getConditions().iterator(); iter.hasNext();)					hookIntoModel((ForkCondition) iter.next());							}		}				}	public void deactivate() {		if (isActive()) {			super.deactivate();			ForkNode fork = (ForkNode) getCastedModel().getSemanticModel();			if (fork.getForkType() == ForkNode.OR_FORK_TYPE) {				for (Iterator iter=fork.getConditions().iterator(); iter.hasNext();)					unhookFromModel((ForkCondition) iter.next());			}		}	}		
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
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.ForkNodeEditPart.deleteVisualCommandLabel")); //$NON-NLS-1$
		commands.add(new SetDetailLevelCommand(getCastedModel(), VisualModel.LOW_DETAIL));		commands.add(getConnectionsDeleteCommand(getTargetConnections()));				if (verifySelection()) {
			commands.add(new DeleteResponsibilityNodeAssociationsCommand(getCastedModel().getDiagram().getCoreModel(), (ResponsibilityNode)getCastedModel().getSemanticModel()));						commands.add(new DeleteForkCommand(getCastedModel()));
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
		if (deleteList.contains(getSemanticModel()))
			return false;
		return true;
	}
	
	private void generateListToDelete(PathNode node, List temp){
		if (node instanceof JoinNode || node instanceof ForkNode)
			temp.add(node);
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
				ForkNode forkNode = (ForkNode)getCastedModel().getSemanticModel();
		switch(forkNode.getForkType()) {			case ForkNode.AND_FORK_TYPE:
					f = createAndFork(); 					break;
			case ForkNode.OR_FORK_TYPE:
					f = createOrFork(); 					break;		}		f.setNamePoint(((ForkNode)getCastedVisualModel().getSemanticModel()).getName());				return f;
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
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);			}
	
	private ThreeConnectionFigure getCastedFigure() {
		return (ThreeConnectionFigure) getFigure();
	}	
		
	/**
	 * change notification received
	 */
	public void notifyChanged(Notification notification) {				super.notifyChanged(notification);
		switch (notification.getEventType()) {
			case Notification.SET:
			case Notification.UNSET:
				switch(notification.getFeatureID(EditormodelPackage.class)) {
				case EditormodelPackage.NODE_VISUAL_MODEL__ROTATION:
					getCastedFigure().setRotation(getCastedModel().getRotation());
					refreshVisuals();
					break;
				}
		}				ForkNode fork = (ForkNode) getCastedModel().getSemanticModel();		if (fork.getForkType() == ForkNode.OR_FORK_TYPE) {			if (notification.getNotifier() instanceof ForkCondition) {				if (notification.getEventType() == Notification.SET &&						notification.getFeatureID(CoremodelPackage.class) == CoremodelPackage.FORK_CONDITION__NAME)					changeConditionName((ForkCondition) notification.getNotifier());								}		}
	}		private void changeConditionName(ForkCondition condition) {		ForkNode fork = (ForkNode) getCastedModel().getSemanticModel();		int nro = 0;		for (Iterator iter=fork.getConditions().iterator(); iter.hasNext();) {			ForkCondition c = (ForkCondition) iter.next();			if (condition == c)				((OrForkFigure) getFigure()).setConditionText(nro, condition.getName());			nro++;		}			}		private ThreeConnectionFigure createAndFork() {		ForkNode fork = (ForkNode)getCastedModel().getSemanticModel();		  return new AndForkFigure(				  	getCastedModel().getRotation(), 				  	Util.getSWTRGB(getCastedModel().getForegroundColor()),				  	getCorrectParent().getFigure(),				  	fork.getOutputsCount()				  );		  	}		private ThreeConnectionFigure createOrFork() {		ForkNode forkNode = (ForkNode) getCastedModel().getSemanticModel();		OrForkFigure f = new OrForkFigure(			  getCastedModel().getRotation(), 			  Util.getSWTRGB(getCastedModel().getForegroundColor()),			  getCorrectParent().getFigure(),			  getCastedModel(),			  forkNode.getOutputsCount()			  );				ForkNode fork = (ForkNode) getCastedModel().getSemanticModel();		int nro = 0;		for (Iterator iter=fork.getConditions().iterator(); iter.hasNext();) {			ForkCondition condition = (ForkCondition) iter.next();			f.setConditionText(nro, condition.getName());			nro++;		}				return f;	}
}