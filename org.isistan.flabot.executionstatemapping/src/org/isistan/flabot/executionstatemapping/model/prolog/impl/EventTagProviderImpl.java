package org.isistan.flabot.executionstatemapping.model.prolog.impl;

import org.isistan.flabot.executionstatemapping.model.prolog.TagProvider;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;

public class EventTagProviderImpl implements TagProvider {
	
	private String preFilterInitialTag;
	
	private String preFilterCommonTag;
	
	private String executionStateCommonTag;
	
	public EventTagProviderImpl(String eventConditionName)
	{
		preFilterInitialTag = "eventPreFilter(" + eventConditionName + ").";
		preFilterCommonTag = "eventPreFilterAccepts(" + eventConditionName + ",Tag)";
		executionStateCommonTag = "eventState(" + eventConditionName; 
	}
	
	public String getPreFilterInitialTag() {
		return preFilterInitialTag;
	}

	public String getPreFilterCommonTag() {
		return preFilterCommonTag;
	}

	public String getExecutionStateCommonTag(ExecutionStateValue executionState) {
		return executionStateCommonTag.concat(",'").concat(executionState.toString()).concat("')");
	}

}