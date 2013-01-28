/**
 * $Id: ComponentDropListener.java,v 1.7 2005/12/21 00:29:37 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.isistan.flabot.edit.componenteditor.editparts.ComponentDiagramEditPart;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;


/**
 * @author $Author: franco $
 *
 */
public class ComponentDropListener extends AbstractTransferDropTargetListener {
	
	ComponentDropFactory factory;
	List exclusion = new ArrayList();
		
	public ComponentDropListener(EditPartViewer viewer, ComponentDropFactory factory) {
		super(viewer, TextTransfer.getInstance());
		this.factory = factory;
		setExclusionSet();
	}
	
	protected Request createTargetRequest() {
		return new CreateRequest();
	}
	
	protected CreateRequest getCreateRequest() {
		return (CreateRequest)getTargetRequest();
	}
	
	protected void updateTargetRequest(){
		super.updateTargetEditPart();
		factory.setID((String)getCurrentEvent().data);
		getCreateRequest().setFactory(factory);
		getCreateRequest().setLocation(getDropLocation());
	}
	
	public boolean isEnabled(DropTargetEvent event) {
		return (super.isEnabled(event) && (getTargetEditPart() instanceof ComponentDiagramEditPart || getTargetEditPart() instanceof UCMDiagramEditPart));
	}
	
	protected Collection getExclusionSet() {
		return exclusion;
	}
	
	private void setExclusionSet() {
		if (exclusion == null)
			exclusion = new ArrayList();
		exclusion.add(getViewer().getRootEditPart().getContents());
	}
}