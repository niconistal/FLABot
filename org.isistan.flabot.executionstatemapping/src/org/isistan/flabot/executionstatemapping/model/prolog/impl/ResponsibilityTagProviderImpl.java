package org.isistan.flabot.executionstatemapping.model.prolog.impl;

import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;

public class ResponsibilityTagProviderImpl implements TagProvider {

	public String getPreFilterInitialTag() {
		return "responsibilityPreFilter.";
	}

	public String getPreFilterCommonTag() {
		return "responsibilityPreFilterAccepts(Tag)";
	}

	public String getExecutionStateCommonTag(ExecutionStateValue executionState) {
		return "executionState('"+executionState+"')";
	}

}
