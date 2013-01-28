package org.isistan.flabot.launcher.filter.filtermodel;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.gauge.Gauge;

/**
 * This stores information about what information should be logged
 * 
 * @model
 * @author da Costa Cambio
 */
public interface LogFilter extends EObject{

	/**
	 * Contains information about what
	 * @model
	 */
	int getGaugeTypes();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.launcher.filter.filtermodel.LogFilter#getGaugeTypes <em>Gauge Types</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Gauge Types</em>' attribute.
	 * @see #getGaugeTypes()
	 * @generated
	 */
	void setGaugeTypes(int value);

	/**
	 * Returns true if the event type should be logged
	 * @param eventType
	 * @return
	 */
	boolean isGaugeType(Gauge.Type gaugeType);

	/**
	 * Set to true fot the event type to be logged
	 * @param eventType
	 */
	void setGaugeType(Gauge.Type gaugeType, boolean log);
}
