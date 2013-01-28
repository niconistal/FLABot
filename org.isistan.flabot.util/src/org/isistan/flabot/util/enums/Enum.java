/** * $Id: Enum.java,v 1.4 2006/03/27 21:39:42 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.util.enums;

import java.lang.reflect.Field;import java.util.HashMap;import java.util.Map;/**
 * Represents an enumeration of options (similar to
 * Java 1.5 Enum class which is not supported by the
 * EMF parser)
 * 
 * Usage example:
 * 
 * 	public class Direction extends org.isistan.util.Enum {
 * 		// enumeration options
 * 		public static final Direction UP=new Direction("UP");
 * 		public static final Direction DOWN=new Direction("DOWN");
 * 		public static final Direction LEFT=new Direction("LEFT");
 * 		public static final Direction RIGHT=new Direction("RIGHT");
 * 
 * 		// constructor (private!)
 * 		private Direction(String direction) {
 * 			super(direction);
 * 		}
 * 	}
 * 
 * Note: keep the constructor private in order to ensure safety
 * 
 * @author $Author: dacostae $
 *
 */
public class Enum implements Comparable<Enum> {
	
	private static Map<Class, EnumInfo> enumInfos= new HashMap<Class, EnumInfo>();
	
	/**
	 *  the name of the option
	 */
	private String name;
	
	/**
	 * the ordinal of the option
	 */
	private int ordinal;
	
	
	private static EnumInfo getEnumStaticData(Class<? extends Enum> enumClass) {
		EnumInfo enumInfo=enumInfos.get(enumClass);
		if(enumInfo==null) {
			enumInfo=new EnumInfo();
			enumInfos.put(enumClass, enumInfo);						//ensure enum contants initialization			Field[] fields=enumClass.getFields();			for (Field field : fields) {				try {					field.setAccessible(true);					field.get(null);				} catch (IllegalArgumentException e) {				} catch (IllegalAccessException e) {				}			}		}
		return enumInfo;
	}
	
	/**
	 * Builds an enumeration option
	 * @param name
	 */
	protected Enum(String name) {
		this.name=name;
		EnumInfo enumInfo=getEnumStaticData(this.getClass());
		this.ordinal=enumInfo.addOption(this);
	}
	
	/**
	 * Returns the highest option for a given enum class
	 */
	public static <T extends Enum> T getMaximum(Class<T> enumClass) {
		EnumInfo enumInfo=getEnumStaticData(enumClass);
		return (T)enumInfo.getMaximum();
	}

	/**
	 * Returns the lowest option for a given enum class
	 */
	public static <T extends Enum> T getMinimum(Class<T> enumClass) {
		EnumInfo enumInfo=getEnumStaticData(enumClass);
		return (T)enumInfo.getMinimum();
	}

	/**	 * Returns the option with the given ordinal, null if not present	 * @param <T>	 * @param enumClass	 * @param ordinal	 * @return	 */	public static <T extends Enum> T getOption(Class<T> enumClass, int ordinal) {		EnumInfo enumInfo=getEnumStaticData(enumClass);		return (T)enumInfo.getOption(ordinal);	}		/**	 * Returns the option with the given name, null if not present	 * @param <T>	 * @param enumClass	 * @param name	 * @return	 */	public static <T extends Enum> T getOption(Class<T> enumClass, String name) {		EnumInfo enumInfo=getEnumStaticData(enumClass);		return (T)enumInfo.getOption(name);	}		/**	 * Returns all options for the given enum;	 * @param <T>	 * @param enumClass	 * @return	 */	public static <T extends Enum> Enum[] getOptions(Class<T> enumClass) {		EnumInfo enumInfo=getEnumStaticData(enumClass);		return enumInfo.getOptions();	}
	
	/**
	 * Returns the "fully qualified name" of the option
	 */
	@Override	public String toString() {
		return this.getClass().getName()+"."+name;
	}
	
	/**
	 * Returns the name of the option
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the ordinal of the option
	 */
	public int getOrdinal() {
		return ordinal;
	}
	
	public int compareTo(Enum o) {
		return ordinal-o.getOrdinal();
	}
	
	@Override	public final boolean equals(Object o) {
		return this==o;
	}
}
