package org.isistan.flabot.executionstatemapping.model.prolog.impl;

import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;

public class GeneralLogFilterTagProvider implements TagProvider {

	public String getPreFilterInitialTag() {
		return "generalPreFilter.";
	}

	public String getPreFilterCommonTag() {
		return "generalPreFilterAccepts(Tag)";
	}

	public String getExecutionStateCommonTag(ExecutionStateValue executionState) {
		throw new UnsupportedOperationException();
	}
}