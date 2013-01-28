/**
 * $Id: NoteEditPart.java,v 1.16 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.editparts;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.ConnectionEditPolicy;
import org.eclipse.gef.editpolicies.ContainerEditPolicy;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.tools.DirectEditManager;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.edit.editor.commands.AddNoteConnectionCommand;
import org.isistan.flabot.edit.editor.commands.DeleteNoteCommand;
import org.isistan.flabot.edit.editor.commands.EditNoteCommand;
import org.isistan.flabot.edit.editor.commands.paste.AddNotePasteCommand;
import org.isistan.flabot.edit.editor.figures.NoteFigure;
import org.isistan.flabot.edit.editor.properties.VisualPropertySource;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * NoteEditPart:
 * -	Edit part for semantic model class Note and model class VisualModel.
 * -	Hooks into VisualModel to receive events related with visual properties .
 * -	Creates the figure that represents the note using NoteFigure.
 * -	Provides an adapter for IPropertySource class instantiating the general purpose VisualPropertySource.
 * 
 * @author $Author: franco $
 *
 */
public class NoteEditPart extends ConnectedEditPart {
				
	private DirectEditManager manager;

	protected void createEditPolicies(){
		
		installEditPolicy(EditPolicy.CONTAINER_ROLE, new ContainerEditPolicy() {
			public Command getCloneCommand(ChangeBoundsRequest request) {																						
				NodeVisualModel copyVisualModel  = (NodeVisualModel)getHost().getModel();
				AddNotePasteCommand command = new AddNotePasteCommand(copyVisualModel,
						new Rectangle(
								copyVisualModel.getLocation().getX() + 10,
								copyVisualModel.getLocation().getY() + 10,
								copyVisualModel.getSize().getWidth(),
								copyVisualModel.getSize().getHeight())
								)
						;				
				return command;
			}
			
			public Command getCreateCommand(CreateRequest request) {
				return null;
			}
		});
		
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, null);	
		
		// Allows the removal of the connection model element
		installEditPolicy(EditPolicy.CONNECTION_ROLE, new ConnectionEditPolicy() {
			protected Command getDeleteCommand(GroupRequest request) {
				AbstractGraphicalEditPart c = (AbstractGraphicalEditPart) getHost();
				CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.editor.editparts.NoteEditPart.deleteVisualNodeCommandLabel")); //$NON-NLS-1$
				commands.add(getConnectionsDeleteCommand(c.getSourceConnections()));
				commands.add(new DeleteNoteCommand((Diagram) getHost().getParent().getModel(), (NodeVisualModel) getHost().getModel()));
				return commands;
			}
		});
		
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new DirectEditPolicy() {

			/**
			 * @see DirectEditPolicy#getDirectEditCommand(DirectEditRequest)
			 */
			protected Command getDirectEditCommand(DirectEditRequest edit) {
				String labelText = (String)edit.getCellEditor().getValue();
				NoteEditPart label = (NoteEditPart)getHost();
				EditNoteCommand command = new EditNoteCommand(label.getCastedSemanticModel(),labelText);
				return command;
			}

			/**
			 * @see DirectEditPolicy#showCurrentEditValue(DirectEditRequest)
			 */
			protected void showCurrentEditValue(DirectEditRequest request) {
				String value = (String)request.getCellEditor().getValue();
				((NoteFigure)getHostFigure()).setText(value);
				//hack to prevent async layout from placing the cell editor twice.
				getHostFigure().getUpdateManager().performUpdate();
				
			}
			
		});		
		
		// allow the creation of connections and 
		// and the reconnection of connections between Shape instances
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new GraphicalNodeEditPolicy() {
		
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCompleteCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
				return null;
			}
			/* (non-Javadoc)
			 * @see org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy#getConnectionCreateCommand(org.eclipse.gef.requests.CreateConnectionRequest)
			 */
			protected Command getConnectionCreateCommand(CreateConnectionRequest request) {
				if (request.getNewObjectType().equals(NoteConnectionEditPart.NOTE_CONNECTION)) {
					NodeVisualModel source = (NodeVisualModel) getHost().getModel();										
					
					AddNoteConnectionCommand cmd = 
						new AddNoteConnectionCommand(source, (ConnectionVisualModel)request.getNewObject());
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
	}

	protected IFigure createFigure() {
		NoteFigure label = new NoteFigure();
		label.setText(getCastedSemanticModel().getNote());
		return label;
	}

	private Note getCastedSemanticModel(){
		return (Note)getCastedVisualModel().getSemanticModel();
	}

	private void performDirectEdit(){
		if(manager == null)
			manager = new NoteEditManager(
					this, new NoteCellEditorLocator((NoteFigure)getFigure()));
		manager.show();
	}

	public void performRequest(Request request){
		if (request.getType() == RequestConstants.REQ_OPEN)
			performDirectEdit();
	}
	
	
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), getMinBounds());
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
		if (notification.getNotifier() instanceof Note) {
			int type = notification.getEventType();
			int featureId = notification.getFeatureID(CoremodelPackage.class);
			switch(type) {
				case Notification.SET:
					switch(featureId) {
						case CoremodelPackage.NOTE__NOTE:
							((NoteFigure)getFigure()).setText(getCastedSemanticModel().getNote());
							break;
					}
			}				
		} else
			super.notifyChanged(notification);
	}
	
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return null;
	}
	
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new VisualPropertySource(getCastedVisualModel(), getMinBounds().getSize());		
		return super.getAdapter(key);
	}
}