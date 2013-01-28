/**

import java.util.Iterator;
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
		commands.add(new SetDetailLevelCommand(getCastedModel(), VisualModel.LOW_DETAIL));
			commands.add(new DeleteResponsibilityNodeAssociationsCommand(getCastedModel().getDiagram().getCoreModel(), (ResponsibilityNode)getCastedModel().getSemanticModel()));			
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
		
		switch(forkNode.getForkType()) {
					f = createAndFork(); 
			case ForkNode.OR_FORK_TYPE:
					f = createOrFork(); 
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
	
	private ThreeConnectionFigure getCastedFigure() {
		return (ThreeConnectionFigure) getFigure();
	}	
		
	/**
	 * change notification received
	 */
	public void notifyChanged(Notification notification) {		
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