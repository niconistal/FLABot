/**

import org.isistan.flabot.javamodel.JBehavior;
 * Filter for gauges to be installed as TraceBasedStateDeterminationStrategy needs
 */
public interface GaugeFilter{

	/**
	
	/**
	
	/**
	 * Determines if a particular package is interesting
	 * @param jPackage
	 * @return
	 */
	TriState passes(JPackage jPackage);
}