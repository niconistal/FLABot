package org.isistan.flabot.executionstatemapping.dialogs.utils.filter;

public interface ViewFilterProvider {

	String getTextName();
	
	void filterChanged(UpdatableFilteredView updatableView);
	
	Object[] validateResult(Object[] result);
	
}
