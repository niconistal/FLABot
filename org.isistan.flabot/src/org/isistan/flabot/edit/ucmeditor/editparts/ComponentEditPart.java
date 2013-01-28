/**
 * $Id: ComponentEditPart.java,v 1.40 2006/03/23 20:25:51 franco Exp $
 * $Header: /var/cvsroot/org.isistan.flabot/src/org/isistan/flabot/edit/ucmeditor/editparts/ComponentEditPart.java,v 1.40 2006/03/23 20:25:51 franco Exp $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.edit.editor.commands.AddNoteConnectionCommand;
import org.isistan.flabot.edit.editor.commands.NoteSetConstraintCommand;
import org.isistan.flabot.edit.editor.commands.paste.AddRoleComponentPasteCommand;
import org.isistan.flabot.edit.editor.editparts.ConnectedEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editor.figures.ComponentFigure;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteComponentRoleCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.ComponentSetConstraintCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteVisualComponentRoleCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeCreateCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeReparentCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.PathNodeSetConstraintCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.ResponsibilityNodeReparentCommand;
import org.isistan.flabot.edit.ucmeditor.figures.ActorFigure;
import org.isistan.flabot.edit.ucmeditor.figures.AgentFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ObjectFigure;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ProcessFigure;
import org.isistan.flabot.edit.ucmeditor.properties.RolePropertySource;
import org.isistan.flabot.messages.Messages;

/**
 * The edit part for components in the use case map editor
 * 
 * ComponentEditPart:
 * -	Edit part for semantic model class ComponentRole, and visual model class NodeVisualModel.
 * -	Hooks into VisualModel events and gets notified of. When necessary, if changes occur, they are applied to the ComponentFigure, some events received via the VisualModel come from the semantic model (ComponentRole and ComponentModel) and are used to deal with responsibility changes. All event received are rippled to its children edit parts.
 * -	Creates the figure that represents the component using ComponentFigure.
 * -	Provides an adapter for IPropertySource class instantiating RolePropertySource.
 * 
 * @author $Author: franco $
 *
 */
public class ComponentEditPart extends ConnectedEditPart {
	
	@Override
	public void activate() {
		if (!isActive()) {
			super.activate();		
			hookIntoModel(((ComponentRole)getCastedModel().getSemanticModel()).getComponent());
		}
	}
	
	@Override
	public void deactivate() {
		if (isActive()) {
			super.deactivate();			
			unhookFromModel(((ComponentRole)getCastedModel().getSemanticModel()).getComponent());
		}
	}	
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	@Override
	protected IFigure createFigure() {
		
		ComponentFigure figure = null;
		switch (((ComponentRole)getCastedModel().getSemanticModel()).getComponentType())
		{
			case ComponentRole.COMPONENT_TYPE:
			{
				figure = new ComponentFigure(
						Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
						Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
						getCastedVisualModel().getLineStyle());
				return figure;
			}
			case ComponentRole.PROCESS_TYPE:
			{
				figure = new ProcessFigure(
						Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
						Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
						getCastedVisualModel().getLineStyle());
				return figure;
			}
			case ComponentRole.AGENT_TYPE:
			{
				figure = new AgentFigure(
						Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
						Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
						getCastedVisualModel().getLineStyle());
				return figure;
			}
			case ComponentRole.OBJECT_TYPE:
			{
				figure = new ObjectFigure(
						Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
						Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
						getCastedVisualModel().getLineStyle());
				return figure;
			}
			case ComponentRole.ACTOR_TYPE:
			{
				figure = new ActorFigure(
						Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
						Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
						getCastedVisualModel().getLineStyle());
				return figure;
			}
		}
		return figure;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent container 
		// (the Figure of the DiagramEditPart), will not know the bounds of this figure
		// and will not draw it correctly.
		ComponentFigure figure = (ComponentFigure) getFigure();
		figure.setText(getSemanticModel().getFullName());
						
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), getMinBounds());	
		refreshPoints();
	}	
	
	public Dimension getMinDimension() {
		int x = getCastedVisualModel().getLocation().getX();
		int y = getCastedVisualModel().getLocation().getY();
		
		int width = getCastedVisualModel().getSize().getWidth();
		int height = getCastedVisualModel().getSize().getHeight();
		List children = getCastedVisualModel().getChildren();
		for (Iterator iter = children.iterator(); iter.hasNext();) {
			NodeVisualModel visual = (NodeVisualModel) iter.next();
			if (visual.getParent() != null) {
				width = Math.max(visual.getAbsoluteLocation().getX() - x + visual.getSize().getWidth(), width);
				height = Math.max(visual.getAbsoluteLocation().getY() - y  + visual.getSize().getHeight(), height);
			}
		}
		return new Dimension(width, height);
	}
	
	protected void refreshChildren() {
		super.refreshChildren();
		refreshVisuals();
	}
	
	private Rectangle getMinBounds() {
		Dimension size = new Dimension(
				getCastedVisualModel().getSize().getWidth(), 
				getCastedVisualModel().getSize().getHeight()
				);
		Point location = new Point(
				getCastedVisualModel().getLocation().getX(),
				getCastedVisualModel().getLocation().getY()
				);
		
		Rectangle bounds = new Rectangle(location, size)
			.union(getFigure().getMinimumSize()).union(getMinDimension());
		
		if (bounds.getSize() != size) {
			getCastedVisualModel().getSize().setWidth(bounds.width);
			getCastedVisualModel().getSize().setHeight(bounds.height);			
		}		
		return bounds;
	}
	
	protected void refreshPoints() {
		List children = getChildren();
		for (Iterator child = children.iterator(); child.hasNext();) {
			Object object = child.next();
			if (object instanceof PathNodeEditPart) {
			PathNodeEditPart part = (PathNodeEditPart) object;
			Rectangle bounds = Util.getDraw2DRectangle(part.getCastedModel().getLocation(),
					part.getCastedModel().getSize());
			((GraphicalEditPart) getParent()).setLayoutConstraint(part, part.getFigure(), bounds);
			}
		}			
	}

	/**
	 * @see GraphicalEditPart#setLayoutConstraint(EditPart, IFigure, Object)
	 */
	public void setLayoutConstraint(EditPart child, IFigure childFigure, Object constraint) {
		super.setLayoutConstraint(child, childFigure, constraint);
		if (childFigure instanceof PathPointFigure)
			((GraphicalEditPart) getParent()).setLayoutConstraint(child, childFigure, constraint);
	}
	
	
	
	private ComponentRole getSemanticModel() {
		return (ComponentRole) getCastedModel().getSemanticModel();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			public Command getCloneCommand(ChangeBoundsRequest request) {																									
				NodeVisualModel copyVisualModel  = (NodeVisualModel)getHost().getModel();
				AddRoleComponentPasteCommand command = new AddRoleComponentPasteCommand(copyVisualModel,
						new Rectangle(
								copyVisualModel.getLocation().getX() + 10,
								copyVisualModel.getLocation().getY() + 10,
								copyVisualModel.getSize().getWidth(),
								copyVisualModel.getSize().getHeight())
						);			
				return command;
			}
			
			public Command getCreateCommand(CreateRequest request) {
				return null;
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
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE,  new ComponentXYLayoutEditPolicy());
		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			/** 
			 * create a delete command for this path node
			 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
			 */
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return getVisualDeleteCommand().chain(new DeleteComponentRoleCommand(getCastedModel().getDiagram().getCoreModel(), (ComponentRole)getCastedModel().getSemanticModel()));
			}	
		});
	}
		
	private Command getVisualDeleteCommand() {
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.ComponentEditPart.deleteVisualCommandLabel")); //$NON-NLS-1$
		if (getTargetConnections().size() > 0)
			commands.add(getConnectionsDeleteCommand(getTargetConnections()));
		commands.add(new DeleteVisualComponentRoleCommand(getCastedModel()));
		return commands;
	}
	
	/**
	 * @return
	 */
	private NodeVisualModel getCastedModel() {
		return (NodeVisualModel)getModel();
	}
	
	public void notifyChanged(Notification notification) {		
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(CoremodelPackage.class);			

		if (notification.getNotifier() instanceof ComponentRole) {
			if ((type == Notification.SET && featureId == CoremodelPackage.COMPONENT_ROLE__MAP)) {
				if (notification.getNewValue() == null && getCastedModel().getDiagram() != null)
					forceDeleteComponent();
				return;	
			}			
			
			if ((type == Notification.SET && featureId == CoremodelPackage.COMPONENT_ROLE__NAME)) {
				if (getCastedModel().getDiagram() != null)
					refreshVisuals();		
				return;
			}
			
			return;
		}
			
		if (notification.getNotifier() instanceof ComponentModel) {
			if ((type == Notification.REMOVE && featureId == CoremodelPackage.COMPONENT_MODEL__FEATURES)){				
				notifyChildren(notification);
				return;
			}
			
			if ((type == Notification.SET && featureId == CoremodelPackage.COMPONENT_MODEL__NAME)) {
				if (getCastedModel().getDiagram() != null)
					refreshVisuals();	
				return;
			}			
			return;
		}
		
		super.notifyChanged(notification);
	}
	
	private void notifyChildren(Notification notification) {
		for(int i = 0; i < getChildren().size(); i++) {
			Adapter a = (Adapter) getChildren().get(i);
			a.notifyChanged(notification);
		}
	}
	
	private void forceDeleteComponent() {
		appendToLastAndExecuteCommand(getVisualDeleteCommand());
	}
	
/**
 * The component's xy layout policy that allows its children to be moved
 * but not resized
 * @author $Author: franco $
 *
 */
	private class ComponentXYLayoutEditPolicy extends XYLayoutEditPolicy {

		/**
		 * returns a non resizable edit policy, so children can't be resized
		 */
		@Override
		protected EditPolicy createChildEditPolicy(EditPart child) {
			return new NonResizableEditPolicy();
		}
		
		/**
		 * Allows elements to be reparented
		 */
		@Override
		protected Command createAddCommand(EditPart child, Object constraint) {
			if (child.getModel() instanceof NodeVisualModel && constraint instanceof Rectangle) {
				NodeVisualModel visual = (NodeVisualModel) child.getModel();
				
				NodeVisualModel host = (NodeVisualModel) getHost().getModel();
				Rectangle rectangle = ((Rectangle) constraint).getCopy();
				rectangle.x += host.getLocation().getX();
				rectangle.y += host.getLocation().getY();
				
				if (visual.getSemanticModel() instanceof StubNode)
					return null;
				
				if (visual.getSemanticModel() instanceof ResponsibilityNode)
					return new ResponsibilityNodeReparentCommand(getCastedModel(), visual,(Rectangle) constraint);
				
				if (visual.getSemanticModel() instanceof PathNode)
					return new PathNodeReparentCommand(host, (NodeVisualModel)child.getModel(), (Rectangle) constraint);				
												
				if (child instanceof ComponentEditPart)						
					return new ComponentSetConstraintCommand((NodeVisualModel)child.getModel(), rectangle);
								
				if (child instanceof NoteEditPart)										
					return new NoteSetConstraintCommand((NodeVisualModel)child.getModel(), rectangle);
				
			}
			return null;
		}
	
		/**
		 * Allow children to be moved
		 */
		@Override
		protected Command createChangeConstraintCommand(EditPart child, Object constraint) {
			if (child instanceof PathNodeEditPart && constraint instanceof Rectangle) {
				// return a command that can move a path inside a Component
				return new PathNodeSetConstraintCommand(
						(NodeVisualModel)child.getModel(), (Rectangle)constraint);
			}
			return null;
		}

		/**
		 * Allow children to be created
		 */
		@Override
		protected Command getCreateCommand(CreateRequest request) {
			Object childClass = request.getNewObjectType();
			if (childClass == PathNode.class) {
				// find the currently selected node
				NodeVisualModel selectedNode = null;
				List selectedEditParts = getHost().getViewer().getSelectedEditParts();
				if (selectedEditParts.size()>0) {
					EditPart editPart = (EditPart) selectedEditParts.get(selectedEditParts.size()-1);
					if (editPart instanceof PathNodeEditPart)
						selectedNode = (NodeVisualModel) editPart.getModel();
				}
				//
				return new PathNodeCreateCommand((NodeVisualModel)request.getNewObject(),
						(Rectangle)getConstraintFor(request),
						selectedNode, getCastedModel());
			}
			return null;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipse.gef.editpolicies.LayoutEditPolicy#getDeleteDependantCommand(org.eclipse.gef.Request)
		 */
		@Override
		protected Command getDeleteDependantCommand(Request request) {
			// do nothing for now
			return null;
		}

	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#getAdapter(java.lang.Class)
	 */
	@Override
	public Object getAdapter(Class key) {
		if (IPropertySource.class.isAssignableFrom(key)) {
			return new RolePropertySource((VisualModel)getModel(), getMinBounds().getSize());
		}
		return super.getAdapter(key);
	}
}