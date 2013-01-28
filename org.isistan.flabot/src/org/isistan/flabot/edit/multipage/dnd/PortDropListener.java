/**
 * $Id: PortDropListener.java,v 1.2 2005/12/07 22:41:24 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.Request;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.isistan.flabot.edit.componenteditor.editparts.ComponentEditPart;

/**
 * @author $Author: franco $
 *
 */
public class PortDropListener extends AbstractTransferDropTargetListener {
	
	PortDropFactory factory;
	List exclusion = new ArrayList();
	
	public PortDropListener(EditPartViewer viewer, PortDropFactory factory) {
		super(viewer, TextTransfer.getInstance());
		this.factory = factory;
		setExclusionSet();
	}
	
	protected Request createTargetRequest() {
		return new NativeDropRequest();
	}
	
	protected NativeDropRequest getCreateRequest() {
		return (NativeDropRequest)getTargetRequest();
	}
	
	protected void updateTargetRequest(){
		super.updateTargetEditPart();
		factory.setID((String)getCurrentEvent().data);
		getCreateRequest().setFactory(factory);
		getCreateRequest().setDropID(factory.getComponentID());
		getCreateRequest().setLocation(getDropLocation());
	}
	
	public boolean isEnabled(DropTargetEvent event) {
		return (super.isEnabled(event) && getTargetEditPart() instanceof ComponentEditPart);
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