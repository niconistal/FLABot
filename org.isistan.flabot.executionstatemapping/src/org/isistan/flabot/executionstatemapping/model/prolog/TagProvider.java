package org.isistan.flabot.executionstatemapping.model.prolog;

import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;

public interface TagProvider {

	String getPreFilterInitialTag();
	
	String getPreFilterCommonTag();
	
	String getExecutionStateCommonTag(ExecutionStateValue executionState);
	
}
