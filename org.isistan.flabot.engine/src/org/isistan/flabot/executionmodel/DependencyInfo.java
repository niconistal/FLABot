/** * $Id: DependencyInfo.java,v 1.1 2006/01/27 00:10:12 mblech Exp $ * $Author: mblech $ */package org.isistan.flabot.executionmodel;

public interface DependencyInfo {
	
	public static final String DEPENDENCY_PREVIOUS = "previous";
	public static final String DEPENDENCY_MAPPING = "nextLevels";
	public static final String DEPENDENCY_CONSTRAINT = "constraint";
	public static final String DEPENDENCY_PRECONDITION = "precondition";
	
}
	
