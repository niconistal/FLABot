/**

import java.lang.reflect.Field;
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
			enumInfos.put(enumClass, enumInfo);
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

	/**
	
	/**
	 * Returns the "fully qualified name" of the option
	 */
	@Override
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
	
	@Override
		return this==o;
	}
}