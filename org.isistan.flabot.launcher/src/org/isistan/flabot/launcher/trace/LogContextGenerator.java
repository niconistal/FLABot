/**

import org.isistan.flabot.gauge.Event;
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
	public synchronized void report(Event event) {
		
		if(event.getGague().getType()==Gauge.Type.ON_BEHAVIOR_ENTRY) {
			context.getTags().add(tag);
		}
	}

}