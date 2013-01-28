/**

import org.eclipse.draw2d.geometry.Rectangle;
	private ResponsibilityNode responsibilityNode;
	
	public ResponsibilityNodeReparentCommand(NodeVisualModel newParent,
			NodeVisualModel visual, Rectangle bounds) {
		super(newParent, visual, bounds);
		this.responsibilityNode = (ResponsibilityNode)visual.getSemanticModel();		
	}
	
	public boolean canExecute() {
		if (!super.canExecute() || responsibilityNode == null)
			return false;
		if (newParent != null) {
			ComponentRole role = (ComponentRole) newParent.getSemanticModel();
			if (role.getComponent() == null)
				return false;
			return role.getComponent().getFeatures().contains(responsibilityNode.getResponsibility());
		}
		return true;
	}
	
	public void execute() {
		super.execute();
		redo();
	}
	
	public void redo() {
		super.redo();
		if (newParent == null)
			responsibilityNode.setRole(null);
		else
			responsibilityNode.setRole((ComponentRole) newParent.getSemanticModel());		
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		super.undo();
		if (oldParent == null)
			responsibilityNode.setRole(null);
		else
			responsibilityNode.setRole((ComponentRole) oldParent.getSemanticModel());	
	}
}