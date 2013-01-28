package org.isistan.flabot.javamodel;

import org.isistan.flabot.javamodel.JObject;

public interface JPrimitive extends JObject {
	/**
	 * Should return the value returned by the java primitive wrapper type toString()
	 * 
	 * @return
	 */
	String getString();

	/**
	 * Should return the value returned by the java primitive wrapper type toString()
	 * @return
	 **/
	String objectToString(); 
}
