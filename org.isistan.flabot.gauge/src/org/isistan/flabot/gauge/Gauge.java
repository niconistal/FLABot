/** * $Id: Gauge.java,v 1.4 2006/03/24 00:34:00 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge;

import java.util.Map;import org.isistan.flabot.util.enums.Enum;/**
 * Class representing gauge inserted in the code
 * @author $Author: dacostae $
 *
 */
public abstract class Gauge {
	/**
	 * Gauge types
	 * @author $Author: dacostae $
	 *
	 */
	public static class Type extends Enum {
		public static final Type ON_BEHAVIOR_ENTRY=new Type("ON_BEHAVIOR_ENTRY");
		public static final Type ON_BEHAVIOR_EXIT=new Type("ON_BEHAVIOR_EXIT");
		public static final Type ON_BEHAVIOR_ERROR=new Type("ON_BEHAVIOR_ERROR");
		public static final Type BEFORE_CAST=new Type("BEFORE_CAST");
		public static final Type AFTER_CAST=new Type("AFTER_CAST");
		public static final Type ON_CAST_ERROR=new Type("ON_CAST_ERROR");
		public static final Type BEFORE_CONSTRUCTOR_CALL=new Type("BEFORE_CONSTRUCTOR_CALL");
		public static final Type AFTER_CONSTRUCTOR_CALL=new Type("AFTER_CONSTRUCTOR_CALL");
		public static final Type ON_FIELD_READ=new Type("ON_FIELD_READ");
		public static final Type ON_FIELD_WRITE=new Type("ON_FIELD_WRITE");
		public static final Type ON_CATCH=new Type("ON_CATCH");
		public static final Type ON_INSTANCEOF_CHECK=new Type("ON_INSTANCEOF_CHECK");
		public static final Type BEFORE_METHOD_CALL=new Type("BEFORE_METHOD_CALL");
		public static final Type AFTER_METHOD_CALL=new Type("AFTER_METHOD_CALL");
		public static final Type ON_METHOD_CALL_ERROR=new Type("ON_METHOD_CALL_ERROR");
		public static final Type BEFORE_ARRAY_CREATION=new Type("BEFORE_ARRAY_CREATION");
		public static final Type AFTER_ARRAY_CREATION=new Type("AFTER_ARRAY_CREATION");
		public static final Type ON_ARRAY_CREATION_ERROR=new Type("ON_ARRAY_CREATION_ERROR");
		public static final Type BEFORE_CREATION=new Type("BEFORE_CREATION");
		public static final Type AFTER_CREATION=new Type("AFTER_CREATION");
		public static final Type ON_CREATION_ERROR=new Type("ON_CREATION_ERROR");
		
		private Type(String type) {
			super(type);
		}
	}
	
	/**
	 * Gauge attributes map keys
	 * @author $Author: dacostae $
	 *
	 */
	public static class AttributeName extends Enum {
		public static final AttributeName BEHAVIOR=new AttributeName("BEHAVIOR");
		public static final AttributeName TARGET_CLASS=new AttributeName("TARGET_CLASS");
		public static final AttributeName TARGET_BEHAVIOR=new AttributeName("TARGET_BEHAVIOR");
		public static final AttributeName TARGET_FIELD=new AttributeName("TARGET_FIELD");
		public static final AttributeName TARGET_INSTANCE=new AttributeName("TARGET_INSTANCE");
				private AttributeName(String attributeName) {
			super(attributeName);
		}
	}
	
	/**
	 * Gauge type
	 */
	private Type type=null;
	
	/**
	 * Gauge's unique id
	 */
	private long id;
	
	/**
	 * Next id to be assigned 
	 */
	private static long nextId=0;
	
	
	/**
	 * Constructs a Gauge with an associated gauge prototype 
	 * @param type
	 * @param prototypeAttributes
	 */
	public Gauge(Type type) {
		this.id=nextId++;
		this.type=type;
	}
	
	/**
	 * Returns the gauge's unique id 
	 * @return
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Returns the type of the gauge 
	 * @return
	 */
	public Type getType() {
		return type;
	}
	/**
	 * Returns the attribute value for the given attribute name
	 * @param name
	 * @return
	 */
	public abstract Object getAttribute(AttributeName name);
	/**	 * Returns if an attribute value is set for the given attribute name	 * @param name	 * @return	 */	public abstract boolean hasAttribute(AttributeName name);	
	/**
	 * Returns a copy of the attributes map
	 * @return
	 */
	public abstract Map<AttributeName, Object> getAttributes();
}
