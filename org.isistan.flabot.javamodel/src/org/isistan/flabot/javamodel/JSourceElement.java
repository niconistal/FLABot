package org.isistan.flabot.javamodel;


/**
 * A JSourceElement contains information about source code declaring
 * the element.
 * 
 * @author da Costa Cambio
 *
 */
public interface JSourceElement extends JObject {
	
	/**
	 * Obtains information about the declaration source code
	 * @return
	 */
	public JSourceLocation getSourceLocation();
}
