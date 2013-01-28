/**

import org.eclipse.draw2d.ConnectionAnchor;
 * InterfaceEditPart
 * -	Edit part for semantic model class InterfaceModel and visual class VisualModel.
 * -	It doesn�t Hook into the InterfaceModel, receives events from the parent edit part (PortEditPart) that ripples events to its children, but it hooks into VisualModel to receive visual changes (Location, Dimension, etc.) and those produced in the InterfaceModel via the VisualModel.
 * -	Creates the figure that represents the inferface using ComponentFigure.
 * -	Provides an adapter for IPropertySource class instantiating the general purpose NamedElementPropertySource.
 * @author $Author: franco $
 *
 */
abstract public class InterfaceEditPart extends ConnectedEditPart {
	
	protected ConnectionAnchor getConnectionAnchor() {			
		return getCastedFigure().getConnectionAnchor();
	}
		
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int type = notification.getEventType();
		int featureId;
		switch(type) {
		case Notification.SET:
			featureId = notification.getFeatureID(EditormodelPackage.class);
			if (featureId == EditormodelPackage.NODE_VISUAL_MODEL__LOCATION) {
				refreshLocation(getCastedFigure());
				break;
			}			
		
		case Notification.REMOVE:
			featureId = notification.getFeatureID(CoremodelPackage.class);
			if (featureId == CoremodelPackage.PORT_MODEL__PROVIDEDS ||
				featureId == CoremodelPackage.PORT_MODEL__REQUIREDS) {
				if (getCastedVisualModel().getParent() != null && notification.getOldValue() == getCastedSemanticModel())
					appendToLastAndExecuteCommand(getVisualDeleteCommand());
		}	
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			public Command getCloneCommand(ChangeBoundsRequest request) {

				NodeVisualModel copyVisualModel = (NodeVisualModel) getHost().getModel();				
				InterfaceModel copyInterfaceModel = (InterfaceModel) copyVisualModel.getSemanticModel(); 															
				
				AddInterfacePasteCommand command = null;
				PortModel parent =  (PortModel) copyVisualModel.getParent().getSemanticModel();
				if (parent.getProvideds().contains(copyInterfaceModel))
					command = new AddInterfacePasteCommand(copyVisualModel, ProvidedInterfaceEditPart.PROVIDED_INTERFACE);
				else if (parent.getRequireds().contains(copyInterfaceModel))
					command = new AddInterfacePasteCommand(copyVisualModel, RequiredInterfaceEditPart.REQUIRED_INTERFACE);
				
				return command;
			}
			
			public Command getCreateCommand(CreateRequest request) {
				return null;
			}

		});
		
		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {						
			/** 
			 * create a delete command for this path node
			 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
			 */
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return getVisualDeleteCommand();
			}						
		});
	}
	
	private Command getVisualDeleteCommand() {
		return new DeleteVisualInterfaceCommand(getCastedVisualModel().getParent(), (NodeVisualModel)getCastedVisualModel());
	}
	
	protected void refreshLocation(InterfaceFigure figure) {
		Point localL = Util.getDraw2DPoint(((VisualModel)getParent().getModel()).getLocation());			
		if (localL.x > 0)
			figure.setSide(PortFigure.RIGHT_SIDE);
		else
			figure.setSide(PortFigure.LEFT_SIDE);
		figure.repaint();
	}
	
	protected InterfaceFigure getCastedFigure() {
		return (InterfaceFigure) getFigure();
	}	
	
	private InterfaceModel getCastedSemanticModel() {
		return (InterfaceModel)getCastedVisualModel().getSemanticModel();
	}
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new NamedElementPropertySource(Messages.getString("org.isistan.flabot.edit.componenteditor.editparts.InterfaceEditPart.propertyViewName"), getCastedSemanticModel()); //$NON-NLS-1$
		return super.getAdapter(key);
	}
}