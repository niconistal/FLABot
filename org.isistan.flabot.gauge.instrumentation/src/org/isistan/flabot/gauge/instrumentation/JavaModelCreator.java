package org.isistan.flabot.gauge.instrumentation;

import org.isistan.flabot.javamodel.JBooleanPrimitive;
import org.isistan.flabot.javamodel.JIntPrimitive;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JPrimitive;
import org.isistan.flabot.javamodel.JThrowable;
import org.isistan.flabot.javamodel.java.JavaFactory;

public class JavaModelCreator {
	/**
	 * Creates a JObject for the given Object
	 * @param value
	 * @return
	 */
	public static JObject createObject(Object value) {
		return JavaFactory.getInstance().buildObject(value);
	}

	/**
	 * Creates a JThrowable for the given Throwable
	 * @param value
	 * @return
	 */
	public static JThrowable createThrowable(Throwable value) {
		return JavaFactory.getInstance().buildThrowable(value);
	}

	/**
	 * Creates an array of JObject where primitive wrappers are converted to JPrimitives
	 * and the rest are converted to JObjects
	 * This method applies create(boolean,Object) to every pair in the given elements.
	 * @param types
	 * @param array
	 * @return
	 */
	public static JObject[] createArray(boolean[] arePrimitiveTypes, Object[] elements) {
		JObject[] jArray=new JObject[elements.length];
		for (int i = 0; i < jArray.length; i++) {
			if(arePrimitiveTypes[i]) {
				jArray[i]=createPrimitive(elements[i]);
			} else {
				jArray[i]=createObject(elements[i]);
			}
		}
		return jArray;
	}

	/**
	 * Checks if an object is a primitive type wrapper
	 * @param element
	 * @return
	 */
	public static boolean isPrimitiveWrapper(Object element) {
		return element instanceof Boolean ||
				element instanceof Byte ||
				element instanceof Character ||
				element instanceof Double ||
				element instanceof Float ||
				element instanceof Integer ||
				element instanceof Long ||
				element instanceof Short;	
	}

	/**
	 * Converts the Primitive Wrapper type into a JPrimitive if isPrimitiveType is true,
	 * returns an JObject if isPrimitiveType is false.
	 * @param isPrimitiveValueType
	 * @param element
	 * @return
	 */
	public static JObject create(boolean isPrimitiveType, Object element) {
		if(isPrimitiveType) {
			return createPrimitive(element);
		}
		return createObject(element);
	}

	/**
	 * Converts the Primitive Wrapper type (Boolean, Integer, ...) into a
	 * JPrimitive (JBooleanPrimitive, JIntPrimitive, ...)
	 * 
	 * @param element
	 * @return
	 */
	public static JPrimitive createPrimitive(Object element) {
		if(element instanceof Boolean) {
			return JavaFactory.getInstance().buildBooleanPrimitive(element);
		} else if(element instanceof Byte) {
			return JavaFactory.getInstance().buildBytePrimitive(element);
		} else if(element instanceof Character) {
			return JavaFactory.getInstance().buildCharPrimitive(element);
		} else if(element instanceof Double) {
			return JavaFactory.getInstance().buildDoublePrimitive(element);
		} else if(element instanceof Float) {
			return JavaFactory.getInstance().buildFloatPrimitive(element);
		} else if(element instanceof Integer) {
			return JavaFactory.getInstance().buildIntPrimitive(element);
		} else if(element instanceof Long) {
			return JavaFactory.getInstance().buildLongPrimitive(element);
		} else if(element instanceof Short) {
			return JavaFactory.getInstance().buildShortPrimitive(element);
		} else if(element==null) {
			return JavaFactory.getInstance().buildVoidPrimitive();
		} else {
			throw new IllegalArgumentException("element is not a instance of a primitive wrapper type. element class=" + element.getClass().getName());
		}
	}

	/**
	 * Converts the passed Integer array into a JIntPrimitive array
	 * (used to obtain array creation arguments)
	 * @param arguments
	 * @return
	 */
	public static JIntPrimitive[] createArrayArguments(Object[] arguments) {
		JIntPrimitive[] jArguments=new JIntPrimitive[arguments.length];
		for (int i = 0; i < jArguments.length; i++) {
			jArguments[i]=JavaFactory.getInstance().buildIntPrimitive(arguments[i]);
		}
		return jArguments;
	}

	/**
	 * Converts a boolean into a JBooleanPrimitive
	 * @param value
	 * @return
	 */
	public static JBooleanPrimitive create(boolean value) {
		return JavaFactory.getInstance().buildBooleanPrimitive(value);
	}
}
