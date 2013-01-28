/**
 * $Id: Context.java,v 1.1 2006/01/27 19:46:04 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.trace.config;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EObject;

/**
 * Represents a context in the configuration file
 * @author $Author: dacostae $
 * @model
 */
public interface Context extends EObject{
	
	/**
	 * 
	 * @model opposite="contexts"
	 */
	TraceConfiguration getTraceConfiguration();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.config.Context#getTraceConfiguration <em>Trace Configuration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Trace Configuration</em>' container reference.
	 * @see #getTraceConfiguration()
	 * @generated
	 */
	void setTraceConfiguration(TraceConfiguration value);

	/**
	 * Get the context's name
	 * @return the context's name
	 * @model
	 */
	String getName();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.config.Context#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * The filter used to collect information
	 * @model containment="true" opposite="context"
	 * @return
	 */
	Filter getFilter();
	


	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.config.Context#getFilter <em>Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' containment reference.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(Filter value);

	/**
	 * Get the context's paramenters
	 * @return the context's paramenters
	 * @model keyType="String" valueType="String"
	 */
	EMap getParameters();
	
	/**
	 * Get the value of the parameter that has the given name
	 * @param parameterName the name of the parameter
	 * @return the value of the parameter
	 */
	String getParameter(String parameterName);
	
	/**
	 * Set the value of the parameter with the given name
	 * @param name the name of the parameter
	 * @param value the new value of the parameter
	 * @return the old value of the parameter (if the parameter had no
	 * previous value, returns null)
	 */
	String setParameter(String name, String value);

}
