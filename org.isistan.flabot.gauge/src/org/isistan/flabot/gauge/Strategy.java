/**

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