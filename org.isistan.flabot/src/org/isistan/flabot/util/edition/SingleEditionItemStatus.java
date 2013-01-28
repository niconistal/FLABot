package org.isistan.flabot.util.edition;

import org.isistan.flabot.messages.Messages;


/**
 * Represents the status of an edition tab
 * 
 * @author da Costa Cambio
 *
 */
public class SingleEditionItemStatus extends EditionItemStatus {
	/**
	 * The type of this status
	 */
	
	private Type type;

	private String description;
	
	/**
	 * Creates a new status
	 * @param type
	 */
	public SingleEditionItemStatus(Type type, String description) {
		if(type==Type.DEFAULT_OK) {
			throw new IllegalArgumentException(Messages.getString("org.isistan.flabot.util.edition.SingleEditionItemStatus.cannotCreateEditionItemStatus")); //$NON-NLS-1$
		}
		this.type=type;
		this.description=description;
	}
	
	public Type getType() {
		return type;
	}
	
	
	public String getDescription() {
		return description;
	}

	@Override
	public EditionItemStatus[] getSubStatuses() {
		return EditionItemStatus.NO_SUB_STATUSES;
	}
	
}
