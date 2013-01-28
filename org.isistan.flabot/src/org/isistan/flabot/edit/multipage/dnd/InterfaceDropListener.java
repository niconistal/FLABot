/**
 * $Id: InterfaceDropListener.java,v 1.1 2005/12/21 00:29:37 franco Exp $
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
import org.isistan.flabot.edit.componenteditor.editparts.PortEditPart;

/**
 * @author $Author: franco $
 *
 */
public class InterfaceDropListener extends AbstractTransferDropTargetListener {
	
	InterfaceDropFactory factory;
	List exclusion = new ArrayList();
	
	public InterfaceDropListener(EditPartViewer viewer, InterfaceDropFactory factory) {
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
		getCreateRequest().setDropID(factory.getPortID());
		getCreateRequest().setLocation(getDropLocation());
	}
	
	public boolean isEnabled(DropTargetEvent event) {
		return (super.isEnabled(event) && getTargetEditPart() instanceof PortEditPart);
	}
	
	protected Collection getExclusionSet() {
		return exclusion;
	}
	
	private void setExclusionSet() {
		if (exclusion == null)
			exclusion = new ArrayList();
		exclusion.add(getViewer().getRootEditPart().getContents());
		exclusion.addAll(getViewer().getRootEditPart().getContents().getChildren());		
	}
}
