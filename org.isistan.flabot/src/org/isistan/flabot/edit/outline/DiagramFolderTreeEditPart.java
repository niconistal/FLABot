/**
 * $Id: DiagramFolderTreeEditPart.java,v 1.7 2006/03/30 00:59:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.isistan.flabot.edit.editor.commands.AddDiagramToFolderCommand;
import org.isistan.flabot.edit.editor.commands.DeleteFolderCommand;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.multipage.dnd.DiagramDropListener;
import org.isistan.flabot.edit.multipage.dnd.NativeDropRequest;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DiagramFolderTreeEditPart extends FlabotModelTreeEditPart {

	private DiagramDropListener dropListener;
	private Image image;
	
	/**
	 * construct a new flabot file tree edit part for the given
	 * folder model
	 * @param model
	 */
	public DiagramFolderTreeEditPart(Folder model) {
		super(model);
	}
	
	private DiagramDropListener getDropListener() {
		if (dropListener == null)
			dropListener = new DiagramDropListener(getViewer());
		return dropListener;				
	}
	
	public void activate() {
		if (!isActive()) {
			super.activate();
			getViewer().addDropTargetListener(getDropListener());
		}			
	}
	
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			getViewer().removeDropTargetListener(getDropListener());
		}
	}
	
	private Folder getCastedModel() {
		return (Folder) getModel();
	}
	
	protected Image getImage() {
		if (image == null) {
			ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
			image = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER).createImage();
		}
		return image;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractTreeEditPart#createEditPolicies()
	 */
	protected void createEditPolicies() {
		// If this editpart is the root content of the viewer, then disallow removal
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new ComponentEditPolicy() {
			public Command getCommand(Request request) {
				if (NativeDropRequest.ID.equals(request.getType())) {
					NativeDropRequest r = (NativeDropRequest) request;
					return new AddDiagramToFolderCommand(getCorrectDiagram((String)r.getNewObject()), getCastedModel());
				}
			    return super.getCommand(request);
			}
			
			public EditPart getTargetEditPart(Request request) {
				if (NativeDropRequest.ID.equals(request.getType()))
					return getHost();
				return super.getTargetEditPart(request);
			}
			
			protected Command createDeleteCommand(GroupRequest deleteRequest) {
				return new DeleteFolderCommand(getCastedModel());
			}
		});
	}

	private FlabotFileModel getFlabotModel() {
		EditPart parts = getParent();
		while (parts.getParent().getModel() != null)
			parts = (FlabotModelTreeEditPart) parts.getParent();
		
		if (parts != null)
			return (FlabotFileModel)parts.getModel();
		
		return null;
	}
	
	private Diagram getCorrectDiagram(String id) {
		FlabotFileModel model = getFlabotModel();
		if (model != null) {
			List diagrams = model.getDiagrams();
			for (Iterator iter=diagrams.iterator(); iter.hasNext();) {
				Diagram d = (Diagram) iter.next();
				if (d.getID().equals(id))
					return d;
			}				
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.editparts.AbstractEditPart#getModelChildren()
	 */
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	protected List getModelChildren() {
		List modelChildren = new ArrayList();
		modelChildren.addAll(getCastedModel().getDiagrams());
		modelChildren.addAll(getCastedModel().getFolders());
		return modelChildren;
	}
	
	/**
	 * Adapter implementation
	 */
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
			// if the folder is double-clicked, open its dialog for editing its name
			InputDialog dlg = new InputDialog(
					Display.getCurrent().getActiveShell(),
		            Messages.getString("org.isistan.flabot.edit.outline.DiagramFolderTreeEditPart.dialogName"), //$NON-NLS-1$
		            Messages.getString("org.isistan.flabot.edit.outline.DiagramFolderTreeEditPart.dialogDescription"), //$NON-NLS-1$
		            getCastedModel().getName(),
		            null); //This is an optional validation class
		    dlg.open();

		    if(dlg.getReturnCode()==Window.OK)
		    	getCastedModel().setName(dlg.getValue());		
		}
		super.performRequest(req);
	}
	
	@Override
	protected String getText() {
		return getCastedModel().getName().toString();
	}
}