/**
 * $Id: PathNodeEditPart.java,v 1.44 2006/03/21 02:34:08 franco Exp $
 * $Header: /var/cvsroot/org.isistan.flabot/src/org/isistan/flabot/edit/ucmeditor/editparts/PathNodeEditPart.java,v 1.44 2006/03/21 02:34:08 franco Exp $
 */

package org.isistan.flabot.edit.ucmeditor.editparts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.DirectionArrowNode;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editor.commands.AddNoteConnectionCommand;
import org.isistan.flabot.edit.editor.editparts.ConnectedEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editor.properties.NamedElementPropertySource;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteEndPointCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeletePathCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeletePathNodeCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertDirectionArrowCommand;
import org.isistan.flabot.edit.ucmeditor.figures.DirectionArrowFigure;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.messages.Messages;

/**
 * PathNodeEditPart:
 * -	Edit part for semantic model class PathNode, and visual model class NodeVisualModel.
 * -	Hooks into UseCaseMap and into Path (if the node is the first in the path) events and gets notified of path removal or node changes. When necessary, if changes occur, they are applied to the PathPointFigure.
 * -	Creates the figure that represents the node using PathPointFigure.
 * -	Provides an adapter for IPropertySource class instantiating PathPropertySource.
 * 
 * EditPart for path nodes
 * @author $Author: franco $
 *
 */
public class PathNodeEditPart extends ConnectedEditPart {

	private ConnectionAnchor anchor;

	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	public void activate() {
		if (!isActive()) {
			if (getSemanticModel().isStart())
				hookIntoModel(getSemanticModel().getPath());
			super.activate();
		}
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {	
			if (getSemanticModel().isStart())
				unhookFromModel(getSemanticModel().getPath());
			super.deactivate();
		}
	}
	
	@Override
	protected void createEditPolicies() {
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
			
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				if (request.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION)) {
					AddNoteConnectionCommand cmd = (AddNoteConnectionCommand) request.getStartCommand();
					cmd.setTarget((NodeVisualModel) getHost().getModel());
					return cmd;
				}				
				return null;			
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
				return null;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectSourceCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			protected Command getReconnectSourceCommand(ReconnectRequest request) {				
				return null;
			}
			
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getReconnectTargetCommand(org.eclipse.gef.requests.ReconnectRequest)
			 */
			protected Command getReconnectTargetCommand(ReconnectRequest request) {
				return null;
			}
		});
	}
	
	protected Command getDeletePathNodeCommand()  {
		PathNode semanticModel = (PathNode)getCastedModel().getSemanticModel();
		if (semanticModel.isStart() && semanticModel.uGetPrevious().size() == 0) {																												
				CompoundCommand c = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart.deleteVisualPathLabel")); //$NON-NLS-1$
				c.add(new DeletePathCommand(getCastedModel()));
				return c;
		}
		if (semanticModel.isEnd() && semanticModel.uGetNext().size() == 0) {
			if (getViewer().getSelectedEditParts().size() <= 1) {
				CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart.deleteVisualEndPathNodeLabel")); //$NON-NLS-1$
				commands.add(getConnectionsDeleteCommand(getTargetConnections()));
				commands.add(new DeleteEndPointCommand(getCastedModel()));
				return commands;
			}
			return null;
		}
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart.deleteVisualPathNodeLabel")); //$NON-NLS-1$
		commands.add(getConnectionsDeleteCommand(getTargetConnections()));
		commands.add(new DeletePathNodeCommand(getCastedModel()));
		return commands;
	}
		
	@Override
	protected IFigure createFigure() {
		AbstractGraphicalEditPart part = (AbstractGraphicalEditPart) getParent();
		if (getCastedModel().getParent() != null)
			part = (AbstractGraphicalEditPart)part.getParent();
		PathPointFigure f = new PathPointFigure(
				Util.getSWTRGB(getCastedModel().getForegroundColor())
				);
		
		f.setNamePoint(((SimplePathNode)getSemanticModel()).getName());
		f.setLocalParent(part.getFigure());
		return f;
	}
	
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent container 
		// (the Figure of the DiagramEditPart), will not know the bounds of this figure
		// and will not draw it correctly.
		PathPointFigure figure = (PathPointFigure) getFigure();
		if (getSemanticModel() != null) {
			figure.setStartPoint(getSemanticModel().isStart());
			figure.setEndPoint(getSemanticModel().isEnd());
		}
	
		Rectangle bounds = Util.getDraw2DRectangle(
				getCastedModel().getLocation(),
				getCastedModel().getSize()
				);
		
		if (getParent() != null)
			((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
	}
	
	/**
	 * Implementation of the Adapter interface
	 */

	/**
	 * change notification received
	 */
	public void notifyChanged(Notification notification) {
		
		if (notification.getNotifier() instanceof SimplePathNode) {
			int featureID = notification.getFeatureID(CoremodelPackage.class);
			if (notification.getEventType() == Notification.SET && featureID == CoremodelPackage.SIMPLE_PATH_NODE__NAME) {
				getCastedFigure().setNamePoint( notification.getNewStringValue());
			}
			
			if (notification.getEventType() == Notification.SET && featureID == CoremodelPackage.SIMPLE_PATH_NODE__NEXT)
				if (notification.getNewValue() == null)
					refreshVisuals();
			return;
		}
				
		if (notification.getNotifier() instanceof NodeVisualModel)
		{
			if (notification.getEventType() == Notification.REMOVING_ADAPTER) 
				getCastedFigure().clear();
			
			NodeVisualModel nodeVisualModel = (NodeVisualModel)notification.getNotifier();
			if ((notification.getEventType() == Notification.SET) || (notification.getEventType() == Notification.REMOVE))
			{
				if (nodeVisualModel.getTargetConnections().size() > 0)
				{
					NodeVisualModel previous = ((ConnectionVisualModel)nodeVisualModel.getTargetConnections().get(0)).getSource();
					if (previous.getSemanticModel() instanceof DirectionArrowNode)
					{
						if (notification.getFeatureID(EditormodelPackage.class) != EditormodelPackage.NODE_VISUAL_MODEL__ROTATION) {
							InsertDirectionArrowCommand command = new InsertDirectionArrowCommand(
								previous, (DirectionArrowNode) previous.getSemanticModel());
							String rotation = command.getDirectionArrowRotation();
							previous.setRotation(rotation);
						}
					}
				}
				if (nodeVisualModel.getSourceConnections().size() > 0)
				{
					NodeVisualModel next = ((ConnectionVisualModel)nodeVisualModel.getSourceConnections().get(0)).getTarget();
					if (next.getSemanticModel() instanceof DirectionArrowNode)
					{
						if (notification.getFeatureID(EditormodelPackage.class) != EditormodelPackage.NODE_VISUAL_MODEL__ROTATION) {
							InsertDirectionArrowCommand command = new InsertDirectionArrowCommand(
									next, (DirectionArrowNode) next.getSemanticModel());
							String rotation = command.getDirectionArrowRotation();
							next.setRotation(rotation);
						}
					}
				}
			}
//			if (notification.getEventType() == Notification.ADD)
//			{
//				if (nodeVisualModel.getTargetConnections().size() > 0)
//				{
//					NodeVisualModel previous = ((ConnectionVisualModel)nodeVisualModel.getTargetConnections().get(0)).getSource();
//					if (previous.getSemanticModel() instanceof DirectionArrowNode)
//					{
//						if (notification.getFeatureID(EditormodelPackage.class) != EditormodelPackage.NODE_VISUAL_MODEL__ROTATION) {
//							InsertDirectionArrowCommand command = new InsertDirectionArrowCommand(
//									previous, (DirectionArrowNode) previous.getSemanticModel());
//							String rotation = command.getDirectionArrowRotation();
//							nodeVisualModel.setRotation(rotation);
//						}
//					}
//				}				
//			}
			
		}
					
		super.notifyChanged(notification);
		switch (notification.getEventType()) {
			case Notification.ADD:
			case Notification.ADD_MANY:
			case Notification.REMOVE:
			case Notification.REMOVE_MANY:
			case Notification.MOVE: {			
				switch(notification.getFeatureID(EditormodelPackage.class)){			
					case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
						refreshVisuals();
						break;
					case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
						refreshVisuals();
						break;				
				}
			}
			super.notifyChanged(notification);
		}
	}

	/**
	 * get the casted model (NodeVisualModel)
	 * @return
	 */
	public NodeVisualModel getCastedModel() {
		return (NodeVisualModel)getModel();
	}
	
	/**
	 * get the visual model's semantic model
	 * @return
	 */
	public PathNode getSemanticModel() {
		return (PathNode) getCastedModel().getSemanticModel();
	}
	
	protected ConnectionAnchor getConnectionAnchor() {
		if (anchor == null)
			anchor = new EllipseAnchor(getFigure());
		return anchor;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class key) {
		if (IPropertySource.class.isAssignableFrom(key) && (getSemanticModel().isStart() || getSemanticModel().isEnd())) {
			String description = ""; //$NON-NLS-1$
			if (getSemanticModel().isStart())
				description = Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart.startNodePropertyView"); //$NON-NLS-1$
			else
				description = Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart.endNodePropertyView"); //$NON-NLS-1$
			return new NamedElementPropertySource(description, (NamedElementModel) getSemanticModel());
		}
		return super.getAdapter(key);
	}
	
	private PathPointFigure getCastedFigure() {
		return (PathPointFigure) getFigure();
	}
}