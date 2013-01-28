/** * $Id: InstrumentationUtils.java,v 1.2 2006/02/03 04:42:31 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.instrumentation;


import java.util.HashMap;import java.util.Map;public class InstrumentationUtils {

	
	public static String prepareCode(String code) {
		return prepareCode(code, null);
	}

	/**
	 * Adds try catch to the code to be inserted so, nobody can detect (and ignore) introduced exceptions
	 * @param code
	 * @return
	 */
	public static String prepareCode(String code, String info) {
		return "{" + code + "}";		/*
		return 
				"{" +				"	try {" +
				"		" + code + 
				"	} catch (Throwable uniqueID123456789) {" +
				"		String message=uniqueID123456789.getClass().getName() + \": Code introduced by instrumentation caused an exception: \" + uniqueID123456789.getMessage()" + (info==null? ";": " + \" [Additional information: " + info + "\";") +
				"		System.out.println(message);" +
				"		uniqueID123456789.printStackTrace();" +
				"	}" +				"}";*/
	}
	
	
	/**
	 * Map of primitive types
	 */
	private static Map<String, Class> primitiveTypes=new HashMap<String, Class>();
	static {
		primitiveTypes.put(boolean.class.getName(), boolean.class);
		primitiveTypes.put(char.class.getName(), char.class);
		primitiveTypes.put(byte.class.getName(), byte.class);
		primitiveTypes.put(short.class.getName(), short.class);
		primitiveTypes.put(int.class.getName(), int.class);
		primitiveTypes.put(long.class.getName(), long.class);
		primitiveTypes.put(float.class.getName(), float.class);
		primitiveTypes.put(double.class.getName(), double.class);
		primitiveTypes.put(void.class.getName(), void.class);
	}	
	
	/**
	 * Map of primitive type names
	 */
	private static Map<String, String> primitiveTypeNames=new HashMap<String, String>();
	static {
		primitiveTypeNames.put(boolean.class.getName(), new boolean[0].getClass().getName().substring(1));
		primitiveTypeNames.put(char.class.getName(), new char[0].getClass().getName().substring(1));
		primitiveTypeNames.put(byte.class.getName(), new byte[0].getClass().getName().substring(1));
		primitiveTypeNames.put(short.class.getName(), new short[0].getClass().getName().substring(1));
		primitiveTypeNames.put(int.class.getName(), new int[0].getClass().getName().substring(1));
		primitiveTypeNames.put(long.class.getName(), new long[0].getClass().getName().substring(1));
		primitiveTypeNames.put(float.class.getName(), new float[0].getClass().getName().substring(1));
		primitiveTypeNames.put(double.class.getName(), new double[0].getClass().getName().substring(1));
		primitiveTypeNames.put(void.class.getName(), "V");
	}
	
	public static Class getPrimitiveType(String name) {
		return primitiveTypes.get(name);
	}
	
	
	public static String getPrimitiveTypeName(String name) {
		return primitiveTypeNames.get(name);
	}

	public static boolean isPrimitiveType(String name) {
		return primitiveTypes.containsKey(name);
	}
}