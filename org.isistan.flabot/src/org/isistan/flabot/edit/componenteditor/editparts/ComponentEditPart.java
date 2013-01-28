/**
 * $Id: ComponentEditPart.java,v 1.55 2006/04/01 02:45:00 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.editparts;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DragTracker;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.gef.tools.DragEditPartsTracker;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.edit.componenteditor.commands.model.ModifyNamedElementCommand;
import org.isistan.flabot.edit.componenteditor.commands.visual.AddPortCommand;
import org.isistan.flabot.edit.componenteditor.commands.visual.AddRelationshipConnectionCommand;
import org.isistan.flabot.edit.componenteditor.commands.visual.ComponentSetConstraintCommand;
import org.isistan.flabot.edit.componenteditor.commands.visual.DeleteVisualComponentCommand;
import org.isistan.flabot.edit.componenteditor.commands.visual.PortSetConstraintCommand;
import org.isistan.flabot.edit.componenteditor.figures.ComponentBoxAnchor;
import org.isistan.flabot.edit.componenteditor.figures.ComponentCellEditorLocator;
import org.isistan.flabot.edit.componenteditor.figures.ComponentFigure;
import org.isistan.flabot.edit.componenteditor.properties.ComponentPropertySource;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editor.FlabotCommandStack;
import org.isistan.flabot.edit.editor.commands.AddNoteConnectionCommand;
import org.isistan.flabot.edit.editor.commands.NoteSetConstraintCommand;
import org.isistan.flabot.edit.editor.commands.SetDetailLevelCommand;
import org.isistan.flabot.edit.editor.commands.paste.AddComponentPasteCommand;
import org.isistan.flabot.edit.editor.editparts.ConnectedEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteConnectionEditPart;
import org.isistan.flabot.edit.editor.editparts.NoteEditPart;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.multipage.dnd.NativeDropRequest;
import org.isistan.flabot.edit.multipage.dnd.PortDropFactory;
import org.isistan.flabot.edit.multipage.dnd.PortDropListener;

/**
 * ComponentEditPart
 * -	Edit part for semantic model class ComponentModel, and visual model class VisualModel.
 * -	Hooks into VisualModel, CodeModel and Responsibility events (for all component’s responsibilities) and gets notified of component or stereotype removal, component, responsibilites or stereotype changes. When necessary, if changes occur, they are applied to the ComponentFigure. All event received are rippled to its children edit parts.
 * -	Creates the figure that represents the component using ComponentFigure.
 * -	Provides an adapter for IPropertySource class instantiating ComponentPropertySource.
 *
 * @author $Author: franco $
 *
 */
public class ComponentEditPart extends ConnectedEditPart implements PropertyChangeListener {

	private CoreModel coreModel;
	private DirectEditManager manager;
	private PortDropListener dropListener;
	
	public DragTracker getDragTracker(Request request) {
		if (request.getType() == RequestConstants.REQ_SELECTION)
			return new ComponentDragEditPartsTracker(this);
		
		return super.getDragTracker(request);
	}
	
	private PortDropListener getDropListener() {
		if (dropListener == null)
			dropListener = new PortDropListener(getViewer(), new PortDropFactory(getCastedVisualModel().getDiagram().getCoreModel().getFile()));
		return dropListener;
	}	
	
	private void performDirectEdit(){				
		if(manager == null)
			manager = new ComponentEditManager(
					this, new ComponentCellEditorLocator((HandleBounds)getFigure()));		
		
		if (getCastedFigure().wasValidClick())
			manager.show();
	}

	public void activate() {
		if (!isActive()) {			
			coreModel = getCastedVisualModel().getDiagram().getCoreModel();
			hookIntoModel(coreModel);			
			activateResponsibilities(getCastedSemanticModel().getFeatures());
			
			getCastedFigure().addPropertyChangeListener(this);
			getViewer().addDropTargetListener(getDropListener());
			super.activate();						
		}
	}
	
	private void activateResponsibilities(List resps) {
		for (Iterator iter=resps.iterator(); iter.hasNext();) {
			Responsibility r = (Responsibility) iter.next();
			hookIntoModel(r);
		}
	}
	
	private void desactivateResponsibilities(List resps) {
		for (Iterator iter=resps.iterator(); iter.hasNext();) {
			Responsibility r = (Responsibility) iter.next();
			unhookFromModel(r);
		}
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	public void deactivate() {
		if (isActive()) {
			unhookFromModel(coreModel);		
			unhookFromModel(getCastedSemanticModel().getStereotype());
			desactivateResponsibilities(getCastedSemanticModel().getFeatures());
			
			getCastedFigure().removePropertyChangeListener(this);
			getViewer().removeDropTargetListener(getDropListener());									
			super.deactivate();
		}
	}
	
	public void propertyChange(PropertyChangeEvent event) {
		if (ComponentFigure.SHOW_RESPONSIBILITIES_PROPERTY.equals(event.getPropertyName())) {
			Command c = new SetDetailLevelCommand(getCastedVisualModel(), ((Integer)event.getNewValue()).intValue());
			FlabotCommandStack commandStack = (FlabotCommandStack)
				getViewer().getEditDomain().getCommandStack();
			commandStack.execute(c);
		}
	}
	
	public void performRequest(Request request){
		if (request.getType() == RequestConstants.REQ_OPEN)
			performDirectEdit();
	}
	
	protected void createEditPolicies() {

		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			public Command getCloneCommand(ChangeBoundsRequest request) {														
				List children = getHost().getChildren();
				CompoundCommand dependantCommands = new CompoundCommand();
				for (int i=0; i<children.size(); i++)
					dependantCommands.add(((EditPart)getHost().getChildren().get(i)).getCommand(request));
								
				NodeVisualModel copyVisualModel  = (NodeVisualModel)getHost().getModel();
				AddComponentPasteCommand command = new AddComponentPasteCommand(copyVisualModel, 
															 new Rectangle ( 
																	 copyVisualModel.getLocation().getX() + 10, 
																	 copyVisualModel.getLocation().getY() + 10,
																	 copyVisualModel.getSize().getWidth(),
																	 copyVisualModel.getSize().getHeight()
															 ),
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
						return new AddPortCommand( (VisualModel) r.getNewObject(),
								   (VisualModel) getHost().getModel(), 
								   r.getLocation());
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
				return getDeleteComponentCommand();
			}												
		});
		
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new XYLayoutEditPolicy() {
			
			protected EditPolicy createChildEditPolicy(EditPart child){
				return new NonResizableEditPolicy();		
			}
			
			protected Command createAddCommand(EditPart child, Object constraint) {								
				if (child.getModel() instanceof NodeVisualModel && constraint instanceof Rectangle) {
					
					NodeVisualModel host = (NodeVisualModel) getHost().getModel();
					Rectangle rectangle = ((Rectangle) constraint).getCopy();
					rectangle.x += host.getLocation().getX();
					rectangle.y += host.getLocation().getY();
					
					if (child instanceof ComponentEditPart)						
						return new ComponentSetConstraintCommand((NodeVisualModel)child.getModel(), rectangle);
								
					if (child instanceof NoteEditPart)										
						return new NoteSetConstraintCommand((NodeVisualModel)child.getModel(), rectangle);
				}				
				return null;				
			}
					
			protected Command createChangeConstraintCommand(ChangeBoundsRequest request,
					EditPart child, Object constraint) {
				if (child instanceof PortEditPart && constraint instanceof Rectangle) {
					// return a command that can move and/or resize a Shape
					return new PortSetConstraintCommand(
							(VisualModel) child.getModel(), request, (Rectangle)getConstraintFor(request, (GraphicalEditPart)child), (Rectangle) constraint);
				}
				return super.createChangeConstraintCommand(request, child, constraint);
			}
			
			protected Command createChangeConstraintCommand(EditPart child,
					Object constraint) {
				return null;
			}
			
			protected Command getCreateCommand(CreateRequest request) {
				if (request.getNewObjectType() == PortModel.class) {
					return new AddPortCommand(  (VisualModel) request.getNewObject(), 
												(VisualModel) getHost().getModel(), 
											    request.getLocation());
				}
				return null;
			}
			
			protected Command getDeleteDependantCommand(Request request) {
				return null;
			}			
		});
						
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				Object type = request.getNewObjectType();
				if (type == Relationship.class) {
					AddRelationshipConnectionCommand cmd 
					= (AddRelationshipConnectionCommand) request.getStartCommand();
					cmd.setTarget((NodeVisualModel) getHost().getModel());
					return cmd;
				} else if (request.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION)) {
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
				if (request.getNewObjectType() == Relationship.class) {
					NodeVisualModel source = (NodeVisualModel) getHost().getModel();
					ComponentDiagramEditPart diagram = (ComponentDiagramEditPart)getHost().getParent();
					AddRelationshipConnectionCommand cmd = 
						new AddRelationshipConnectionCommand((ComponentDiagram)diagram.getModel(), source, (ConnectionVisualModel)request.getNewObject());
					request.setStartCommand(cmd);
					return cmd;
				}
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
				
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DirectEditPolicy() {

			/**
			 * @see DirectEditPolicy#getDirectEditCommand(DirectEditRequest)
			 */
			protected Command getDirectEditCommand(DirectEditRequest edit) {
				String labelText = (String)edit.getCellEditor().getValue();
				labelText = labelText.replace('\n', ' ');
				labelText = labelText.replace('\r', ' ');
				NodeVisualModel model = (NodeVisualModel)getHost().getModel();
				ModifyNamedElementCommand command = new ModifyNamedElementCommand((NamedElementModel)model.getSemanticModel(), labelText);
				return command;
			}

			/**
			 * @see DirectEditPolicy#showCurrentEditValue(DirectEditRequest)
			 */
			protected void showCurrentEditValue(DirectEditRequest request) {
				//hack to prevent async layout from placing the cell editor twice.
				getHostFigure().getUpdateManager().performUpdate();				
			}
			
		});		
	}
	
	private Command getDeleteComponentCommand() {
		CompoundCommand commands = new CompoundCommand();
		if (getSourceConnections().size() > 0)
			commands.add(getConnectionsDeleteCommand(getSourceConnections()));
		if (getTargetConnections().size() > 0)
			commands.add(getConnectionsDeleteCommand(getTargetConnections()));
		if (getParent() != null)
			commands.add(new DeleteVisualComponentCommand((ComponentDiagram) getParent().getModel(), (NodeVisualModel)getModel()));
		return commands;
	}
	
	/*(non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractGraphicalEditPart#createFigure()
	 */
	protected IFigure createFigure() {		
		ComponentFigure figure = new ComponentFigure(
				Util.getSWTRGB(getCastedVisualModel().getBackgroundColor()), 
				Util.getSWTRGB(getCastedVisualModel().getForegroundColor()),
				getCastedVisualModel().getLineStyle());
		figure.setText(getCastedSemanticModel().getName());
		
		if (getCastedVisualModel().getDetailLevel() == VisualModel.HIGH_DETAIL)
			figure.showResponsibilites(true);
		
		updateStereotypeName(figure);
		updateResponsibilities(figure);
		return figure;		
	}
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new ComponentPropertySource((VisualModel)getModel(), (ComponentDiagram)getParent().getModel(), getMinBounds().getSize());
		return super.getAdapter(key);
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
			.union(getFigure().getMinimumSize());
		
		if (bounds.getSize() != size) {
			getCastedVisualModel().getSize().setWidth(bounds.width);
			getCastedVisualModel().getSize().setHeight(bounds.height);						
		}		
		return bounds;
	}
			
	public void notifyChanged(Notification notification) {		
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(CoremodelPackage.class);					
		
		if (notification.getNotifier() instanceof CoreModel) {
			if (type == Notification.REMOVE)
				switch(featureId) {
					case CoremodelPackage.CORE_MODEL__COMPONENTS:
						if (getCastedVisualModel().getDiagram() != null && notification.getOldValue() == getCastedSemanticModel())							
							appendToLastAndExecuteCommand(getDeleteComponentCommand());
						
					case CoremodelPackage.CORE_MODEL__STEREOTYPES:
						if (notification.getOldValue() == getCastedSemanticModel().getStereotype()){
							updateStereotypeName(getCastedFigure());
							refreshVisuals();
					}				
				}
			return;
		}
				
		if (notification.getNotifier() instanceof Stereotype) {
			if (type == Notification.SET && featureId == CoremodelPackage.STEREOTYPE__NAME) {
					updateStereotypeName(getCastedFigure());
					refreshVisuals();
			}
			return;
		}
		
		if (notification.getNotifier() instanceof Responsibility) {					
			if (type == Notification.SET && featureId == CoremodelPackage.RESPONSIBILITY__NAME) {
				updateResponsibilities(getCastedFigure());
				refreshVisuals();					
			}
			return;
		}
		
		if (notification.getNotifier() instanceof ComponentModel) {
			switch(type) {
			case Notification.ADD:			
				if ( featureId == CoremodelPackage.COMPONENT_MODEL__FEATURES) {
					((Responsibility)notification.getNewValue()).eAdapters().add(this);
					updateResponsibilities(getCastedFigure());
					refreshVisuals();
				}
				break;
			case Notification.REMOVE:
				if ( featureId == CoremodelPackage.COMPONENT_MODEL__FEATURES) {
					((Responsibility)notification.getOldValue()).eAdapters().remove(this);
					updateResponsibilities(getCastedFigure());
					refreshVisuals();
				}
				if ( featureId == CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS)
					notifyChildren(notification);
				break;
				
			case Notification.SET:
				switch(featureId) {
				case CoremodelPackage.COMPONENT_MODEL__NAME:
					getCastedFigure().setText(getCastedSemanticModel().getName());
					refreshVisuals();
					break;
				case CoremodelPackage.COMPONENT_MODEL__STEREOTYPE:
					updateStereotypeName(getCastedFigure());
					refreshVisuals();
					break;
				}			
			}
			return;
		}
		
		//VisualModel
		featureId = notification.getFeatureID(EditormodelPackage.class);				
		switch(type) {
			case Notification.ADD:
			case Notification.REMOVE:
				if (featureId == EditormodelPackage.VISUAL_MODEL__CHILDREN)
					refreshVisuals();
				break;
			case Notification.SET:
				if (featureId == EditormodelPackage.VISUAL_MODEL__DETAIL_LEVEL) {
					getCastedFigure().showResponsibilites(notification.getNewIntValue() == VisualModel.HIGH_DETAIL);
					refreshVisuals();
				}
				break;
		}
		super.notifyChanged(notification);
	}
	
	private void notifyChildren(Notification notification) {
		for(int i = 0; i < getChildren().size(); i++) {
			Adapter a = (Adapter) getChildren().get(i);
			a.notifyChanged(notification);
		}
	}
	
	private void updateStereotypeName(ComponentFigure figure) {
		Stereotype stereotype = getCastedSemanticModel().getStereotype();
		String newName = ""; //$NON-NLS-1$
		if (stereotype != null) 
			newName = stereotype.getName();
		
		figure.setStereotype(newName);
	}
	
	private ComponentModel getCastedSemanticModel() {
		return (ComponentModel) getCastedVisualModel().getSemanticModel();
	}
	
	private ComponentFigure getCastedFigure() {
		return (ComponentFigure) getFigure();
	}
	
	protected ConnectionAnchor getConnectionAnchor() {			
		if (anchor == null)
			anchor = new ComponentBoxAnchor((HandleBounds)getFigure());
		return anchor;
	}
	
	private void updateResponsibilities(ComponentFigure figure) {
		List resps = getCastedSemanticModel().getFeatures();
		
		String[] names = new String[resps.size()];
		int i=0;
		for (Iterator iter=resps.iterator(); iter.hasNext();)
			names[i++] = ((Responsibility) iter.next()).getName();
		
		figure.addResponsibilities(names);
	}
	
	private void updateSizePortLocation(Rectangle newBounds) {		
		Dimension size = newBounds.getSize();
		int newRightXOffset = size.width - 40;
		int height = 0; 
		
		int maxYPort = 0;
		List children = getCastedVisualModel().getChildren();					
		for (int i=0; i<children.size(); i++) {
			VisualModel port = (VisualModel)children.get(i);			
			height = 25;
			
			if (port.getChildren().size() > 0)
				height = 25 *  port.getChildren().size();
			port.setSize(Util.getDimension(40, height));
			
			if (port.getLocation().getX() > 0)
				port.setLocation(Util.getPoint(newRightXOffset, port.getLocation().getY()));
						
			maxYPort = Math.max(maxYPort, port.getLocation().getY() + port.getSize().getHeight());
		}		
		
		int dif = size.height - maxYPort; 
		if (dif < 0)
			getCastedVisualModel().setSize(Util.getDimension(size.width, size.height - dif + 10));					
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#refreshVisuals()
	 */
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent container 
		// (the Figure of the DiagramEditPart), will not know the bounds of this figure
		// and will not draw it correctly.				
		Rectangle min = getMinBounds();
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), min);
		updateSizePortLocation(min);
	}
	

	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		CreateConnectionRequest r = (CreateConnectionRequest) request;
		if (r.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION) || r.getNewObjectType() == Relationship.class)
			return getConnectionAnchor();
		return null;
	}	
	
	class ComponentDragEditPartsTracker extends DragEditPartsTracker {

		public ComponentDragEditPartsTracker(EditPart sourceEditPart) {
			super(sourceEditPart);
		}
		
		public boolean handleButtonDown(int button) {
			if (getCastedFigure().wasValidClick()) {
				return super.handleButtonDown(button);
			}		
			if (getViewer() != null && getParent() != null) {
				if (!getViewer().getSelectedEditParts().contains(getParent())) {
					getViewer().deselectAll();
					getViewer().select(getParent());
				}
			}
			return true;
		}		
	}
}