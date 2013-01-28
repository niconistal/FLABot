/** * $Id: GaugeConsumer.java,v 1.4 2006/03/24 03:35:03 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge;

/**
 * This interface should be implemented by those interested in getting reported
 * when a gauge produces some information
 * 
 * @author $Author: dacostae $
 *
 */
public abstract class GaugeConsumer {
	
	/**
	 * Method called when the gauge produces data
	 * @param event
	 */
	public abstract void report(Event event);
	
	/**
	 * Return the filter for this gauge consumer interests
	 * @param gaugePrototype
	 * @return
	 */
	public abstract GaugeFilter getFilter();}
