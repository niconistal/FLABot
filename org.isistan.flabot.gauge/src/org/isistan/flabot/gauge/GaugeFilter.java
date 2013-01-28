/** * $Id: GaugeFilter.java,v 1.1 2006/03/24 03:35:03 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge;

import org.isistan.flabot.javamodel.JBehavior;import org.isistan.flabot.javamodel.JClass;import org.isistan.flabot.javamodel.JPackage;import org.isistan.flabot.util.TriState;/**
 * Filter for gauges to be installed as TraceBasedStateDeterminationStrategy needs
 */
public interface GaugeFilter{

	/**	 * Determines if a particular gauge is interesting	 * @param gauge	 * @return	 */	boolean passes(Gauge gauge);
	
	/**	 * Determines if a particular behavior is interesting	 * @param jBehavior	 * @return	 */	boolean passes(JBehavior jBehavior);		/**	 * Determines if a particular class is interesting	 * @param jBehavior	 * @return	 */	TriState passes(JClass jClass);
	
	/**
	 * Determines if a particular package is interesting
	 * @param jPackage
	 * @return
	 */
	TriState passes(JPackage jPackage);
}
