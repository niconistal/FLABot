/**
 * $Id: LogContext.java,v 1.1 2006/01/27 19:46:05 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.trace.log;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * Represents a context in a log file
 * @author $Author: dacostae $
 * @model
 */
public interface LogContext extends EObject{
	/**
	 * The name of this context
	 * @return
	 * @model
	 */
	String getName();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.log.LogContext#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * The tags that correspond to this context
	 * @return
	 * @model type="Tag"
	 */
	EList getTags();
	
	/**
	 * Get the log that contains this log context
	 * @return the containing log
	 * @model opposite="contexts"
	 */
	TraceLog getLog();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.log.LogContext#getLog <em>Log</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log</em>' container reference.
	 * @see #getLog()
	 * @generated
	 */
	void setLog(TraceLog value);

}
