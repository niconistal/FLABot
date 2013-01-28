/** * $Id: Event.java,v 1.4 2006/03/08 00:21:07 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge;

import java.util.Map;import org.isistan.flabot.util.enums.Enum;public abstract class Event {	/**
	 * Évent attributes map keys
	 * @author $Author: dacostae $
	 *
	 */
	public static class AttributeName extends Enum {
		public static final AttributeName INSTANCE=new AttributeName("INSTANCE");
		public static final AttributeName ARGUMENTS=new AttributeName("ARGUMENTS");
		public static final AttributeName THROWN=new AttributeName("THROWN");
		public static final AttributeName TARGET_INSTANCE=new AttributeName("TARGET_INSTANCE");
		public static final AttributeName VALUE=new AttributeName("VALUE");
		public static final AttributeName OLD_VALUE=new AttributeName("OLD_VALUE");
		
		private AttributeName(String attributeName) {
			super(attributeName);
		}
	}

	/**	 * Time stamp	 */	private long timeStamp;		/**	 * Excecution id	 */	private long executionId;	
	/**
	 * The gauge this event is associated with 
	 */
	private Gauge gauge;
		/**
	 * Constructs a Gauge with an associated gauge prototype 	 * @param executionId 	 * @param timeStamp 
	 * @param type
	 * @param prototypeAttributes
	 */
	public Event(long timeStamp, long executionId, Gauge gauge) {		this.timeStamp=timeStamp;		this.executionId=executionId;
		this.gauge=gauge;
	}
		/**	 * Returns this event's timeStamp	 * @return	 */	public long getTimeStamp() {		return timeStamp;	}	/**	 * Returns this event's execution id	 * @return	 */	public long getExecutionId() {		return executionId;	}
	/**
	 * Returns the gauge this event is associated with
	 * @return
	 */
	public Gauge getGague() {
		return gauge;
	}

	/**	 * Returns the attribute value for the given attribute name	 * @param name	 * @return	 */	public abstract Object getAttribute(AttributeName name);		/**	 * Returns if an attribute value is set for the given attribute name	 * @param name	 * @return	 */	public abstract boolean hasAttribute(AttributeName name);
	
	/**
	 * Returns a copy of the attributes map
	 * @return
	 */
	public abstract Map<AttributeName, Object> getAttributes();
}
