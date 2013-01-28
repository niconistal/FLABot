package org.isistan.flabot.executionstatemapping.dialogs.utils.filter;

public abstract class ViewFilterProviderAdapter implements ViewFilterProvider {

	public abstract String getTextName();
	
	public abstract  void filterChanged(UpdatableFilteredView updatableView);
	
	public Object[] validateResult(Object[] returnValue)
	{
		return returnValue;
	}
	
}
