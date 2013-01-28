/** * $Id: LogContextGenerator.java,v 1.7 2006/03/29 03:03:34 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.launcher.trace;

import org.isistan.flabot.gauge.Event;import org.isistan.flabot.gauge.GaugeFilter;import org.isistan.flabot.gauge.Gauge;import org.isistan.flabot.gauge.GaugeConsumer;import org.isistan.flabot.trace.log.LogContext;import org.isistan.flabot.trace.log.Tag;/**
 * This class is used to generate the context references to the trace
 * @author $Author: mblech $
 *
 */
public class LogContextGenerator extends GaugeConsumer {

	private GaugeFilter filter;
	private TraceGenerator traceGenerator;
	private LogContext context;
	
	public LogContextGenerator(LogContext context, GaugeFilter filter, TraceGenerator traceGenerator) {
		this.context=context;
		this.filter=filter;
		this.traceGenerator=traceGenerator;
	}
	
	@Override
	public GaugeFilter getFilter() {
		return filter;
	}

	@Override
	public synchronized void report(Event event) {		Tag tag=traceGenerator.report(event);
		
		if(event.getGague().getType()==Gauge.Type.ON_BEHAVIOR_ENTRY) {
			context.getTags().add(tag);
		}
	}	/**	 * Resets this gauge consumer collected information	 *	 */	public synchronized void reset() {		context.getTags().clear();		traceGenerator.reset();			}

}
