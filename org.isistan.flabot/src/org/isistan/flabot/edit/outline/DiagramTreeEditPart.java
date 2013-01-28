/**
 * $Id: DiagramTreeEditPart.java,v 1.13 2006/03/30 00:59:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.IEditorPart;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editor.commands.DeleteDiagramCommand;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.edit.multipage.dnd.DiagramDragListener;

/**
 * Tree edit part for diagrams in the outline view
 * @author $Author: franco $
 *
 */
public class DiagramTreeEditPart extends FlabotModelTreeEditPart {
	
	private DiagramDragListener dragListener;
	private Image image;
	/**
	 * create an instance of this edit part for the given diagram
	 * @param diagram
	 */
	public DiagramTreeEditPart(Diagram diagram) {
		super(diagram);		
	}
	
	private DiagramDragListener getDragListener() {
		if (dragListener == null)
			dragListener = new DiagramDragListener(getViewer());
		return dragListener;				
	}
	
	public void activate() {
		if (!isActive()) {
			super.activate();
			getViewer().addDragSourceListener(getDragListener());
		}			
	}
	
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			getViewer().removeDragSourceListener(getDragListener());
		}
	}
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#createEditPolicies()
	 */
	@Override
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return new DeleteDiagramCommand(getCastedModel().getCoreModel().getFile(), getCastedModel());
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}
	
	private Diagram getCastedModel() {
		return (Diagram) getModel();
	}
	
	protected Image getImage() {
		if (image == null) {
			if (getCastedModel() instanceof ComponentDiagram)
				image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/cd.gif").createImage(); //$NON-NLS-1$
			else
				image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/ucm.gif").createImage();	 //$NON-NLS-1$
		}
		return image;
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		switch (notification.getEventType()) {
		case Notification.ADD:
		case Notification.ADD_MANY:
		case Notification.REMOVE:
		case Notification.REMOVE_MANY:
		case Notification.MOVE:
			getParent().refresh();
			refreshChildren();
			break;
		case Notification.SET:
		case Notification.UNSET:
			getParent().refresh();
			refreshVisuals();
			break;
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#performRequest(org.eclipse.gef.Request)
	 */
	@Override
	public void performRequest(Request req) {
		if (req.getType() == RequestConstants.REQ_OPEN) {
			// if the component is double-clicked, open its respective editor
			IEditorPart editor = ((DefaultEditDomain)getViewer().getEditDomain()).getEditorPart();
			if (editor instanceof FlabotMultiPageEditor) {
				FlabotMultiPageEditor mpEditor = (FlabotMultiPageEditor) editor;
				mpEditor.openDiagram(getCastedModel());
			}
		}
		super.performRequest(req);
	}
}