/** * $Id: MappingBasedFilter.java,v 1.5 2006/03/27 23:53:01 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.engine.executionstate;

import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;import org.isistan.flabot.mapping.mappingmodel.Mapping;import org.isistan.flabot.trace.config.Filter;/**
 * Filter for gauges that used a responsibility Mapping
 * @model abstract="true"
 */
public interface MappingBasedFilter extends Filter{
	/**
	 * The mapping on which this filter is based
	 * @model containment="true"
	 * @return
	 */
	Mapping getMapping();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.MappingBasedFilter#getMapping <em>Mapping</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapping</em>' containment reference.
	 * @see #getMapping()
	 * @generated
	 */
	void setMapping(Mapping value);

	/**	 * The log filter used to filter gauges	 * @model containment="true"	 * @param logFilter	 */	public LogFilter getLogFilter();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.engine.executionstate.MappingBasedFilter#getLogFilter <em>Log Filter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Log Filter</em>' containment reference.
	 * @see #getLogFilter()
	 * @generated
	 */
	void setLogFilter(LogFilter value);

}
