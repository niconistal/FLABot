/**
 * $Id: NamedElementPropertySource.java,v 1.5 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.properties;

import java.util.List;

import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.messages.Messages;

/**
 * NamedElementPropertySource
 * -	Uses for showing the properties of a NamedElementModel
 * -	The property shown is the name.
 * 
 * @author $Author: franco $
 *
 */
public class NamedElementPropertySource extends AbstractPropertySource {
	
	protected static final String ID_NAME = "ID_Name"; //$NON-NLS-1$
	
	protected String description = Messages.getString("org.isistan.flabot.edit.editor.properties.NamedElementPropertySource.name"); //$NON-NLS-1$
	
	/**
	 * Instantiates an instance of NamedElementPropertySource.
	 * @param model the NamedElementModel to show properties
	 */
	public NamedElementPropertySource(String description, NamedElementModel model) {
		super(model);
		this.description = description;
	}
	
	/**
	 * @return the NamedElementModel to show properties
	 */
	private NamedElementModel getSemanticModel() {
		return (NamedElementModel) getModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new TextPropertyDescriptor(ID_NAME, description));
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
		if(id == ID_NAME) {
			String name = ""; //$NON-NLS-1$
			if (getSemanticModel() != null)
				name = getSemanticModel().getName();
			return new String(name);
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
		if (id == ID_NAME) {
			if (getSemanticModel() != null)
				getSemanticModel().setName(value.toString());
		}
	}
}