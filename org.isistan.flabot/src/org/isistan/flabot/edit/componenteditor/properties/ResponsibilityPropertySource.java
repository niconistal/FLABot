/**
 * $Id: ResponsibilityPropertySource.java,v 1.6 2006/02/03 23:50:15 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.properties;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.coremodel.FeatureModel;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.messages.Messages;

/**
 * ResponsibilityPropertySource
 * -	Uses for showing the properties of the responsibilities of a component.
 * -	The properties shown are the names of the responsibilities of a component.
 * 
 * @author $Author: franco $
 *
 */
public class ResponsibilityPropertySource extends AbstractPropertySource {
	
	private static final String ID_NAME = "NAME"; //$NON-NLS-1$
	private static final String NAME_NAME = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.ResponsibilityPropertySource.name"); //$NON-NLS-1$
	
	/**
	 * Instantiates an instance of RelationshipConnectionProperty.
	 * @param model the list of responsibilities to show properties
	 */
	public ResponsibilityPropertySource(EList model) {
		super(model);
	}
	
	/**
	 * @return the list of responsibilities to show properties
	 */
	private EList getCoreModel() {
		return (EList) getModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		List list = getCoreModel();
		for (int i=0; i<list.size(); i++)		
			descriptors.add(new TextPropertyDescriptor(ID_NAME + i, NAME_NAME));					
	}
	
	/**
	 * Returns the value of the property with the given id if it has one.
	 * Returns <code>null</code> if the property's value is <code>null</code>
	 * value or if this source does not have the specified property.
	 * 
	 * @param id the id of the property being set
	 * @return the value of the property, or <code>null</code>
	 */
	public Object getPropertyValue(Object id) {
		String idName = (String) id;
		String number = idName.substring(idName.indexOf(ID_NAME) + ID_NAME.length(), idName.length());
		int index = Integer.parseInt(number);
		if (getCoreModel().size() > index) {
			return new String(((FeatureModel)getCoreModel().get(index)).getName());
		}
		return null;
	}
	
	/**
	 * Sets the property with the given id if possible. Does nothing if the
	 * property's value cannot be changed or if this source does not have the
	 * specified property.
	 * @param id the id of the property
	 * @param value the value of the property
	 */
	public void setPropertyValue(Object id, Object value) {
		String idName = (String) id;
		String number = idName.substring(idName.indexOf(ID_NAME) + ID_NAME.length(), idName.length());
		int index = Integer.parseInt(number);
		if (getCoreModel().size() > index) {
			((FeatureModel)getCoreModel().get(index)).setName(value.toString());
		}
	}
	
	public String toString() {
		return Messages.getString("org.isistan.flabot.edit.componenteditor.properties.ResponsibilityPropertySource.numberOfResponsibilities", getCoreModel().size()); //$NON-NLS-1$
	}
}