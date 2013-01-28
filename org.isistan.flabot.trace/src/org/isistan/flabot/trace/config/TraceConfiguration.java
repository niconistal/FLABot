/**
 * $Id: TraceConfiguration.java,v 1.3 2006/03/29 21:21:28 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.trace.config;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * Configuration file model for the trace launcher
 * @author $Author: dacostae $
 * @model
 */
public interface TraceConfiguration extends EObject{

	/**
	 * Get the contained contexts for this configuration file
	 * @return
	 * @model type="Context" containment="true" opposite="traceConfiguration"
	 */
	EList getContexts();
	
	/**
	 * Get the output file's name
	 * @return the output file's name
	 * @model default="traceOutput.tracelog"
	 */
	String getOutputFileName();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.config.TraceConfiguration#getOutputFileName <em>Output File Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output File Name</em>' attribute.
	 * @see #getOutputFileName()
	 * @generated
	 */
	void setOutputFileName(String value);

	/**
	 * Determines if the collection should be enabled from the begining
	 * @model
	 */
	Boolean getStartCollecting();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.config.TraceConfiguration#getStartCollecting <em>Start Collecting</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Collecting</em>' attribute.
	 * @see #getStartCollecting()
	 * @generated
	 */
	void setStartCollecting(Boolean value);

}
