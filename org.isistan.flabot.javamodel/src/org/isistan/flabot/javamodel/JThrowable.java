package org.isistan.flabot.javamodel;

/**
 * Model for throwable objects
 * @author usuario
 *
 */
public interface JThrowable extends JObject {
	
	String getMessage();
	
	JThrowable getCause();
}
