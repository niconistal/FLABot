/** * $Id: GaugeManagerPool.java,v 1.1 2006/03/01 20:27:28 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.gauge.instrumentation.runtime;

import java.util.HashMap;import java.util.Map;import org.isistan.flabot.gauge.instrumentation.InstrumentationGaugeManager;
public class GaugeManagerPool {
	/**
	 * Gauge Managers indexed by Gague id
	 */
	private static Map<Long, InstrumentationGaugeManager> gaugeManagers=new HashMap<Long, InstrumentationGaugeManager>();
	
	/**
	 * Returns a new GaugeManager associated with the gauge that nofifies the gaugeConsumers
	 * @param gauge
	 * @param gaugeConsumers
	 * @return
	 */
	public synchronized static void addGaugeManager(InstrumentationGaugeManager gaugeManager) {
		gaugeManagers.put(Long.valueOf(gaugeManager.getGauge().getId()), gaugeManager);
	}
	
	public static InstrumentationGaugeManager getGaugeManager(long gaugeId) {
		return gaugeManagers.get(Long.valueOf(gaugeId));
	}

}
