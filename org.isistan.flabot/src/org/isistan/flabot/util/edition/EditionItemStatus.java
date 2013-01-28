package org.isistan.flabot.util.edition;

import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.enums.Enum;

/**
 * Represents the status of an edition tab
 * 
 * @author da Costa Cambio
 *
 */
public abstract class EditionItemStatus {
	protected static final EditionItemStatus[] NO_SUB_STATUSES=new EditionItemStatus[0];
	public static final EditionItemStatus DEFAULT_OK=
		new EditionItemStatus() {
			public Type getType() {
				return Type.DEFAULT_OK;
			}

			@Override
			public String getDescription() {
				return ""; //$NON-NLS-1$
			}

			@Override
			public EditionItemStatus[] getSubStatuses() {
				return NO_SUB_STATUSES;
			}
		
		};
	
	/**
	 * Represents the type of a status
	 */
	public static class Type extends Enum {
		public static final Type DEFAULT_OK=new Type("DEFAULT_OK"); //$NON-NLS-1$
		public static final Type OK=new Type("OK"); //$NON-NLS-1$
		public static final Type INFORMATION=new Type("INFORMATION"); //$NON-NLS-1$
		public static final Type WARNING=new Type("WARNING"); //$NON-NLS-1$
		public static final Type ERROR=new Type("ERROR"); //$NON-NLS-1$
		
		private Type(String name) {
			super(name);
		}
		
	}
	
	/**
	 * Creates a new status
	 * @param type
	 */
	public EditionItemStatus() {
		
	}
	
	/**
	 * Returns the type of this status
	 * @return
	 */
	public abstract Type getType();
	
	/**
	 * Returns the description of this status
	 * @return
	 */
	public abstract String getDescription();
	
	/**
	 * Returns the statuses contained in this editionItem
	 * @return
	 */
	public abstract EditionItemStatus[] getSubStatuses();
	
	
	/**
	 * Returns the worst status between this status and the given other.
	 * Returns this if the status are of same severity.
	 * @param other
	 * @return
	 */
	public EditionItemStatus getWorst(EditionItemStatus other) {
		int thisOrdinal=this.getType().getOrdinal();
		int otherOrdinal=other.getType().getOrdinal();
		if(thisOrdinal<otherOrdinal) {
			return other;
		} else if(thisOrdinal==otherOrdinal) {
			if(this==EditionItemStatus.DEFAULT_OK) {
				return other;
			} else {
				return this;
			}
		} else {
			return this;
		}
			
	}
	
	/**
	 * Returns the worst status between this among the given .
	 * @param other
	 * @return
	 */
	public static EditionItemStatus getWorstOfAll(EditionItemStatus... statuses) {
		if(statuses==null || statuses.length==0) {
			throw new IllegalArgumentException(Messages.getString("org.isistan.flabot.util.edition.EditionItemStatus.statusNull")); //$NON-NLS-1$
		}
		EditionItemStatus worst=statuses[0]; 
		for (EditionItemStatus status : statuses) {
			worst=worst.getWorst(status);
		}
		return worst;
			
	}
	
}
