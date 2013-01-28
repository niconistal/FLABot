package org.isistan.flabot.gauge.instrumentation;

import java.util.HashMap;
import java.util.Map;

import org.isistan.flabot.gauge.Event;
import org.isistan.flabot.gauge.Gauge;

public class InstrumentationEvent extends Event {

	/**
	 * Event attributes
	 */
	private Map<AttributeName, Object> attributes;
	
	InstrumentationEvent(long timeStamp, long executionId, Gauge gauge, Map<AttributeName, Object> attributes) {
		super(timeStamp, executionId, gauge);
		this.attributes=attributes;
	}

	@Override
	public Object getAttribute(AttributeName name) {
		return attributes.get(name);
	}
	

	@Override
	public boolean hasAttribute(AttributeName name) {
		return attributes.containsKey(name);
	}


	@Override
	public Map<AttributeName, Object> getAttributes() {
		Map<AttributeName, Object> attributes=new HashMap<AttributeName, Object>();
		attributes.putAll(this.attributes);
		return attributes;
	}
}
