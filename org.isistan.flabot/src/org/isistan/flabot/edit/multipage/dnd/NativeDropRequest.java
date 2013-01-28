/**
 * $Id: NativeDropRequest.java,v 1.2 2005/12/05 21:18:59 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import org.eclipse.gef.requests.CreateRequest;

/**
 * @author $Author: franco $
 *
 */
public class NativeDropRequest extends CreateRequest {
	
	private String dropID;

	public static final String ID = "$Native Drop Request";//$NON-NLS-1$

	public NativeDropRequest() {
		super(ID);
	}
	
	public void setDropID(String dropID) {
		this.dropID = dropID;
	}

	public String getDropID() {
		return dropID;
	}
}