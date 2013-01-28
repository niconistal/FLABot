/**
 * $Id: AbstractPropertySource.java,v 1.2 2005/12/22 23:15:20 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;

/**
 * AbstractPropertySource
 * -	This is a common class used for showing properties of objects which are capable of supplying properties for display
 * 		by the standard property sheet page implementation (<code>PropertySheetPage</code>).
 * 
 * @author $Author: franco $
 * 
 */
abstract public class AbstractPropertySource implements IPropertySource2 {

	private Object model;
	protected IPropertyDescriptor[] descriptors;
	
	/**
	 * @param model the model from which properties will be shown
	 */
	public AbstractPropertySource(Object model) {
		this.model = model;
	}
	
	public abstract void createPropertyDescriptors(List descriptors);
	
	/**
	 * @return the model from which properties are shown
	 */
	public Object getModel() {
		return model;
	}	

	public Object getEditableValue() {
		return this;
	}

	public IPropertyDescriptor[] getPropertyDescriptors() {
		List list = new ArrayList();
		createPropertyDescriptors(list);
		descriptors = new IPropertyDescriptor[list.size()];
		list.toArray(descriptors);
		return descriptors;
	}
	
	public boolean isPropertySet(Object id) {
		return false;
	}
		
	public boolean isPropertyResettable(Object id) {
		return false;
	}
	
	public void resetPropertyValue(Object id) {
		//Do nothing
	}
}