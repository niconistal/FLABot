/** * $Id: PortEditPart.java,v 1.39 2006/04/01 02:45:00 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.componenteditor.editparts;

import java.util.Iterator;import java.util.List;import org.eclipse.draw2d.IFigure;import org.eclipse.emf.common.notify.Adapter;import org.eclipse.emf.common.notify.Notification;import org.eclipse.gef.DragTracker;import org.eclipse.gef.EditPart;import org.eclipse.gef.EditPolicy;import org.eclipse.gef.Request;import org.eclipse.gef.RequestConstants;import org.eclipse.gef.commands.Command;import org.eclipse.gef.commands.CompoundCommand;import org.eclipse.gef.editpolicies.ComponentEditPolicy;import org.eclipse.gef.editpolicies.ContainerEditPolicy;import org.eclipse.gef.editpolicies.NonResizableEditPolicy;import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;import org.eclipse.gef.requests.ChangeBoundsRequest;import org.eclipse.gef.requests.CreateRequest;import org.eclipse.gef.requests.GroupRequest;import org.eclipse.gef.tools.DragEditPartsTracker;import org.eclipse.ui.views.properties.IPropertySource;import org.isistan.flabot.coremodel.CoremodelPackage;import org.isistan.flabot.coremodel.PortModel;import org.isistan.flabot.edit.componenteditor.commands.visual.AddInterfaceCommand;import org.isistan.flabot.edit.componenteditor.commands.visual.DeleteVisualPortCommand;import org.isistan.flabot.edit.componenteditor.figures.PortFigure;import org.isistan.flabot.edit.editor.commands.paste.AddPortPasteCommand;import org.isistan.flabot.edit.editor.editparts.ContainerEditPart;import org.isistan.flabot.edit.editor.properties.NamedElementPropertySource;import org.isistan.flabot.edit.editormodel.EditormodelPackage;import org.isistan.flabot.edit.editormodel.NodeVisualModel;import org.isistan.flabot.edit.editormodel.Point;import org.isistan.flabot.edit.editormodel.Util;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.edit.multipage.dnd.InterfaceDropFactory;import org.isistan.flabot.edit.multipage.dnd.InterfaceDropListener;import org.isistan.flabot.edit.multipage.dnd.NativeDropRequest;import org.isistan.flabot.messages.Messages;/**
 * PortEditPart
 * -	Edit part for semantic model class PortModel and visual class VisualModel.
 * -	It doesn’t Hook into the InterfaceModel, receives events from the parent edit part (PortEditPart) that ripples events to its children, but it hooks into VisualModel to receive visual changes (Location, Dimension, etc.) and those produced in the InterfaceModel via the VisualModel. Notifies all changes to its children edit parts.
 * -	Creates the figure that represents the port using ProvidedInterfaceFigure or RequiredInterfaceFigure.
 * -	Provides an adapter for IPropertySource class instantiating the general purpose NamedElementPropertySource.
 * 
 * @author $Author: franco $
 *
 */
public class PortEditPart extends ContainerEditPart {
		
	private InterfaceDropListener dropListener;
	
	private InterfaceDropListener getDropListener() {
		if (dropListener == null)
			dropListener = new InterfaceDropListener(getViewer(), new InterfaceDropFactory(getCastedVisualModel().getDiagram().getCoreModel().getFile()));
		return dropListener;
	}
		public DragTracker getDragTracker(Request request) {		if (request.getType() == RequestConstants.REQ_SELECTION)			return new ComponentDragEditPartsTracker(this);				return super.getDragTracker(request);	}	
	public void activate() {
		if (!isActive()) {			
			getViewer().addDropTargetListener(getDropListener());
			super.activate();						
		}
	}
	
	public void deactivate() {
		if (isActive()) {
			getViewer().removeDropTargetListener(getDropListener());									
			super.deactivate();
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			public Command getCloneCommand(ChangeBoundsRequest request) {
				CompoundCommand dependantCommands = new CompoundCommand();
				List interfaces = getHost().getChildren();
				for (int i=0; i<interfaces.size(); i++)			
					dependantCommands.add(((EditPart)interfaces.get(i)).getCommand(request));
								
				VisualModel copyVisualModel = (VisualModel)getHost().getModel();											
				AddPortPasteCommand command = new AddPortPasteCommand(
						copyVisualModel,
						Util.getDraw2DPoint(copyVisualModel.getLocation()),
						dependantCommands);
							
				return command;			
			}
			
			public Command getCreateCommand(CreateRequest request) {
				return null;
			}

		});
		
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			public Command getCommand(Request request) {
				if (NativeDropRequest.ID.equals(request.getType())) {
					NativeDropRequest r = (NativeDropRequest) request;
					if (r.getDropID().equals(getCastedSemanticModel().getID()))
						return new AddInterfaceCommand((VisualModel) getHost().getModel(), (NodeVisualModel)r.getNewObject(), (String)r.getNewObjectType());
				}
				return super.getCommand(request);
			}

			public EditPart getTargetEditPart(Request request) {
				if (NativeDropRequest.ID.equals(request.getType()))
					return getHost();
				return super.getTargetEditPart(request);
			}
			
			/** 
			 * create a delete command for this path node
			 * @see org.eclipse.gef.editpolicies.ComponentEditPolicy#createDeleteCommand(org.eclipse.gef.requests.GroupRequest)
			 */
			@Override
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return getVisualDeleteCommand();
			}	
		});
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			
			protected EditPolicy createChildEditPolicy(EditPart child){
				return new NonResizableEditPolicy();		
			}
			
			protected Command createAddCommand(EditPart child, Object constraint) {
				return null;
			}
					
			protected Command createChangeConstraintCommand(ChangeBoundsRequest request,
					EditPart child, Object constraint) {
				return null;
			}
			
			protected Command createChangeConstraintCommand(EditPart child,
					Object constraint) {
				return null;
			}
			
			protected Command getCreateCommand(CreateRequest request) {
				if (request.getNewObjectType().equals(RequiredInterfaceEditPart.REQUIRED_INTERFACE) || request.getNewObjectType().equals(ProvidedInterfaceEditPart.PROVIDED_INTERFACE))
					return new AddInterfaceCommand((VisualModel) getHost().getModel(), (NodeVisualModel)request.getNewObject(), (String)request.getNewObjectType());
				return null;
			}
			
			protected Command getDeleteDependantCommand(Request request) {
				return null;
			}		
		});		
	}
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new NamedElementPropertySource(Messages.getString("org.isistan.flabot.edit.componenteditor.editparts.PortEditPart.propertyViewName"), getCastedSemanticModel()); //$NON-NLS-1$
		return super.getAdapter(key);
	}
	
	/*(non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {
		PortFigure f = new PortFigure();
		refreshLocation(f);
		return f;
	}

	private Command getVisualDeleteCommand() {
		return new DeleteVisualPortCommand(getCastedVisualModel().getParent(), getCastedVisualModel());
	}
	
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(EditormodelPackage.class);			
		switch(type) {
		case Notification.SET:
			switch(featureId) {
				case EditormodelPackage.VISUAL_MODEL__LOCATION: {				
					Point newPoint = (Point) notification.getNewValue();
					Point oldPoint = (Point) notification.getOldValue();
					if (newPoint.getX() != oldPoint.getX() || newPoint.getY()!= oldPoint.getY()) {
						refreshLocation(getCastedFigure());
						refreshChildren();
						getParent().refresh();
						break;
					} 
				}
			}
		
		case Notification.ADD:
		case Notification.REMOVE:
			switch(featureId) {
			case EditormodelPackage.VISUAL_MODEL__CHILDREN:
				getParent().refresh();
				updateInterfaces();
				break;
			case EditormodelPackage.VISUAL_MODEL:
				getParent().refresh();				
				break;
		
			}	
		}
		
		featureId = notification.getFeatureID(CoremodelPackage.class);
		if (type == Notification.REMOVE) {
			featureId = notification.getFeatureID(CoremodelPackage.class);
			switch(featureId) {
			case CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS:
				if (getCastedVisualModel().getParent() != null && getCastedSemanticModel() == notification.getOldValue())					appendToLastAndExecuteCommand(getVisualDeleteCommand());								break;
				
			case CoremodelPackage.PORT_MODEL__PROVIDEDS:
			case CoremodelPackage.PORT_MODEL__REQUIREDS:
				notifyChildren(notification);
			}
		}
	}
	
	private void notifyChildren(Notification notification) {
		for(int i = 0; i < getChildren().size(); i++) {
			Adapter a = (Adapter) getChildren().get(i);
			a.notifyChanged(notification);
		}
	}
	
	protected void refreshLocation(PortFigure figure) {		
		Point localL = getCastedVisualModel().getLocation();		
		if (localL.getX() > 0) {
			figure.setSide(PortFigure.RIGHT_SIDE);
		} else
			figure.setSide(PortFigure.LEFT_SIDE);
		figure.repaint();
	}
	
	protected void updateInterfaces() {
		List children = getCastedVisualModel().getChildren();
		int interfaces = 0;
		for (Iterator iter=children.iterator(); iter.hasNext();) {
			VisualModel visual = (VisualModel) iter.next();
			visual.setLocation(Util.getPoint(2, 2 + 25 *  interfaces));
			interfaces++;			
		}
	}
	
	protected PortFigure getCastedFigure() {
		return (PortFigure) getFigure();		
	}	
	
	private PortModel getCastedSemanticModel() {
		return (PortModel)getCastedVisualModel().getSemanticModel();		
	}		class ComponentDragEditPartsTracker extends DragEditPartsTracker {		public ComponentDragEditPartsTracker(EditPart sourceEditPart) {			super(sourceEditPart);		}				public boolean handleButtonDown(int button) {			if (getCastedFigure().wasValidClick()) {				return super.handleButtonDown(button);			}					if (getViewer() != null && getParent() != null && getParent().getParent() != null) {				if (!getViewer().getSelectedEditParts().contains(getParent().getParent())) {					getViewer().deselectAll();					getViewer().select(getParent().getParent());				}			}			return true;		}			}
}