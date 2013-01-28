package org.isistan.flabot.util.edition;


/**
 * Represents the status of an edition tab
 * 
 * @author da Costa Cambio
 *
 */
public class CompositeEditionItemStatus extends EditionItemStatus {
	
	private EditionItemStatus worst;
	private EditionItemStatus[] statuses;
	
	/**
	 * Creates a new status
	 * @param type
	 */
	public CompositeEditionItemStatus(EditionItemStatus... statuses) {
		this.statuses=statuses;
		this.worst=EditionItemStatus.getWorstOfAll(statuses);
	}
	
	public Type getType() {
		return worst.getType();
	}
	
	
	public String getDescription() {
		return worst.getDescription();
	}

	public EditionItemStatus[] getSubStatuses() {
		return statuses;
	}
}
