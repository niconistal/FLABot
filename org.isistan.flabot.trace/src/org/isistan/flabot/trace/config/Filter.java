/**

import org.eclipse.emf.common.util.EList;

/**
 * Filter for gauges to be installed as TraceBasedStateDeterminationStrategy needs
 * @model interface="true"
 */
public interface Filter extends EObject, GaugeFilter {
	
	/**
	 * @model opposite="filter"
	 * @return
	 */
	Context getContext();
	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.trace.config.Filter#getContext <em>Context</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' container reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(Context value);

}