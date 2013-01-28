/**
 * $Id: ConnectedEditPart.java,v 1.5 2006/03/17 22:28:02 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.editparts;

import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * The common abtract edit part used for all edit parts that can have connections. (eg. components, interfaces, node paths, etc.)
 * 
 * ConnectedEditPart
 * 	The edit part can contain children.
 * -
 * @author $Author: franco $
 *
 */
public abstract class ConnectedEditPart extends ContainerEditPart 
	implements NodeEditPart {
	
	protected ConnectionAnchor anchor;
	
	/**
	 * Returns the list of source connections. They are taken from the visual model.
	 * 
	 * @return the list of source connections
	 */
	@Override
	protected List getModelSourceConnections() {
		return ((NodeVisualModel) getModel()).getSourceConnections();
	}
	
	/**
	 * Returns the list of target connections. They are taken from the visual model.
	 * 
	 * @return the list of target connections
	 */
	@Override
	protected List getModelTargetConnections() {
		return ((NodeVisualModel) getModel()).getTargetConnections();
	}
	
	/**
	 * Returns the ChopboxAnchor connection anchor according to the figure.
	 * 
	 * @return the ChopboxAnchor connection anchor 
	 */
	protected ConnectionAnchor getConnectionAnchor() {			
		if (anchor == null)
			anchor = new ChopboxAnchor(getFigure());
		return anchor;
	}

	/**
	 * Notifies that a change to some feature has occurred.
	 * Some common events are handle:
	 * - Changes in the list of source and target connections. (Connection add/remove)
	 * 
	 * @param notification a description of the change.
	 */
	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);
		int type = notification.getEventType();
		int featureId = notification.getFeatureID(EditormodelPackage.class);			
		switch(type) {
			case Notification.ADD:
			case Notification.REMOVE:
				switch(featureId) {
					case EditormodelPackage.NODE_VISUAL_MODEL__SOURCE_CONNECTIONS:
						refreshSourceConnections();
						break;
					case EditormodelPackage.NODE_VISUAL_MODEL__TARGET_CONNECTIONS:
						refreshTargetConnections();
						break;
				}	
		}
	}
	
	/*
	 * NodeEditPart implementation
	 */
	
	/**
	 * @see #getConnectionAnchor
	 * @see NodeEditPart#getSourceConnectionAnchor
	 */
	public ConnectionAnchor getSourceConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}

	/**
	 * @see #getConnectionAnchor
	 * @see NodeEditPart#getSourceConnectionAnchor
	 */
	public ConnectionAnchor getSourceConnectionAnchor(Request request) {
		return getConnectionAnchor();
	}

	/**
	 * @see #getConnectionAnchor
	 * @see NodeEditPart#getTargetConnectionAnchor
	 */
	public ConnectionAnchor getTargetConnectionAnchor(ConnectionEditPart connection) {
		return getConnectionAnchor();
	}
	
	/**
	 * @see #getConnectionAnchor
	 * @see NodeEditPart#getTargetConnectionAnchor
	 */
	public ConnectionAnchor getTargetConnectionAnchor(Request request) {
		return getConnectionAnchor();
	}
}