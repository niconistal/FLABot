/**
 * $Id: UseCaseMapTreeEditPart.java,v 1.12 2006/03/30 00:59:56 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ComponentEditPolicy;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteMapCommand;

/**
 * Tree edit part for use case maps
 * @author $Author: franco $
 *
 */
public class UseCaseMapTreeEditPart extends FlabotModelTreeEditPart {

	private Image image;

	/**
	 * construct a new tree edit part for the given use case map
	 * @param map
	 */
	public UseCaseMapTreeEditPart(UseCaseMap map) {
		super(map);
	}
	
	public void activate(){
		if (!isActive()) {
			super.activate();
			activatePaths();
		}
	}
	
	private void activatePaths() {
		for (int i=0; i < getCastedModel().getPaths().size(); i++){
			((Path)getCastedModel().getPaths().get(i)).eAdapters().add(this);	
		}		
	}
	
	private void deactivatePaths() {
		for (int i=0; i < getCastedModel().getPaths().size(); i++){
			((Path)getCastedModel().getPaths().get(i)).eAdapters().remove(this);	
		}		
	}
	
	public void deactivate(){
		if (isActive()) {
			super.deactivate();
			deactivatePaths();
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
				return new DeleteMapCommand(getCastedModel().getCoreModel(), getCastedModel());
			}
		});
	}
	
	protected Image getImage() {
		if (image == null) {
			image = ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/map.gif").createImage(); //$NON-NLS-1$
		}
		return image;
	}
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#getText()
	 */
	@Override
	protected String getText() {
		return getCastedModel().getName();
	}
	
	private UseCaseMap getCastedModel() {
		return (UseCaseMap) getModel();
	}

	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.outline.FlabotModelTreeEditPart#notifyChanged(org.eclipse.emf.common.notify.Notification)
	 */
	@Override
	public void notifyChanged(Notification notification) {
		switch (notification.getEventType()) {
		case Notification.ADD:{
			int featureID = notification.getFeatureID(CoremodelPackage.class);
			if (featureID == CoremodelPackage.USE_CASE_MAP__PATHS) 
				if (notification.getNewValue() instanceof Path)
					((Path) notification.getNewValue()).eAdapters().add(this);
			refreshChildren();
			break;
		}
		case Notification.ADD_MANY:
			refreshChildren();
			break;
		case Notification.REMOVE:		
			int featureID = notification.getFeatureID(CoremodelPackage.class);
			if (featureID == CoremodelPackage.USE_CASE_MAP__PATHS) 
				if (notification.getNewValue() instanceof Path)
					((Path) notification.getNewValue()).eAdapters().remove(this);
		case Notification.REMOVE_MANY:
		case Notification.MOVE:
			refreshChildren();
			break;
		case Notification.SET:
		case Notification.UNSET:
			refreshVisuals();
			break;
		}
	}
	
	@SuppressWarnings("unchecked") //$NON-NLS-1$
	protected List getModelChildren() {
		List modelChildren = new ArrayList();
		for (int i=0; i < getCastedModel().getPaths().size(); i++){
			modelChildren.addAll(((Path)getCastedModel().getPaths().get(i)).getStartNodes());
		}
		modelChildren.addAll(getCastedModel().getComponentRoles());
		return modelChildren;
	}
	
	protected void refreshChildren() {
		if (getParent() != null)
			super.refreshChildren();
	}

}
