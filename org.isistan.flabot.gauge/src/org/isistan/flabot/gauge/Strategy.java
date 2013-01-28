/** * $Id: Strategy.java,v 1.1 2006/01/27 22:58:40 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge;

/**
 * Strategy definition
 * @author $Author: dacostae $
 *
 */
public class Strategy {

	/**
	 * Associated gauge consumers
	 */
	private GaugeConsumer[] gaugeConsumers;
	
	/**
	 * Constructs a strategy associated with the given gauge consumers and filters
	 * @param gaugeConsumers
	 * @param filters
	 */
	public Strategy(GaugeConsumer[] gaugeConsumers) {
		this.gaugeConsumers=gaugeConsumers;
	}
	
	/**
	 * returns the gauge consumers associated with this strategy
	 * @return
	 */
	public GaugeConsumer[] getGaugeConsumers() {
		return gaugeConsumers;
	}

}
