/**

import java.util.Map;
	 * �vent attributes map keys
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

	/**
	/**
	 * The gauge this event is associated with 
	 */
	private Gauge gauge;
	
	 * Constructs a Gauge with an associated gauge prototype 
	 * @param type
	 * @param prototypeAttributes
	 */
	public Event(long timeStamp, long executionId, Gauge gauge) {
		this.gauge=gauge;
	}
	
	/**
	 * Returns the gauge this event is associated with
	 * @return
	 */
	public Gauge getGague() {
		return gauge;
	}

	/**
	
	/**
	 * Returns a copy of the attributes map
	 * @return
	 */
	public abstract Map<AttributeName, Object> getAttributes();
}