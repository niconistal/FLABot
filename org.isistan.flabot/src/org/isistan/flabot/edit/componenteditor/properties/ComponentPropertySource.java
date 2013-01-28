/**
 * $Id: ComponentPropertySource.java,v 1.14 2006/02/07 21:19:46 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.properties;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editor.properties.VisualPropertySource;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * ComponentPropertySource
 * -	Uses for showing the properties of the components in a component diagram.
 * -	The properties shown are name, size, location, sterotype and number of responsibilities.
 * 
 * @author $Author: franco $
 *
 */
public class ComponentPropertySource extends VisualPropertySource {
	
	private static final String ID_NAME = "NAME"; //$NON-NLS-1$
	private static final String NAME_NAME = Messages.getString("org.isistan.flabot.edit.componenteditor.propertie.ComponentPropertySource.name"); //$NON-NLS-1$
	
	private static final String ID_RESPONSIBILITIES = "RESPONSIBILITIES"; //$NON-NLS-1$
	private static final String NAME_RESPONSIBILITIES = Messages.getString("org.isistan.flabot.edit.componenteditor.propertie.ComponentPropertySource.responsibilities"); //$NON-NLS-1$
	
	private final static String ID_STEREOTYPE = "STEREOTYPE"; //$NON-NLS-1$
	private final static String NAME_STEREOTYPE = Messages.getString("org.isistan.flabot.edit.componenteditor.propertie.ComponentPropertySource.stereotype"); //$NON-NLS-1$
	
	private ComponentDiagram componentDiagram;
	
	/**
	 * Instantiates an instance of  ComponentPropertySource.
	 * @param model the visual model of the component to show properties
	 * @param componentDiagram the component diagram where the component is
	 * @param minDimension the minimum dimension of the component
	 */
	public ComponentPropertySource(VisualModel model, ComponentDiagram componentDiagram, Dimension minDimension) {
		super(model, minDimension);
		this.componentDiagram = componentDiagram;
	}
	
	/**
	 * @return the component model to show properties
	 */
	private ComponentModel getCastedSemanticModel() {
		return (ComponentModel) getCastedVisualModel().getSemanticModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		super.createPropertyDescriptors(descriptors);
		descriptors.add(new TextPropertyDescriptor(ID_NAME, NAME_NAME));
		descriptors.add(new PropertyDescriptor(ID_RESPONSIBILITIES, NAME_RESPONSIBILITIES));		
		descriptors.add(new PropertyDescriptor(ID_STEREOTYPE, NAME_STEREOTYPE));
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
		if(id == ID_NAME)
			return new String(getCastedSemanticModel().getName());
 
		if(id == ID_RESPONSIBILITIES)
			return new ResponsibilityPropertySource(getCastedSemanticModel().getFeatures());

		if (ID_STEREOTYPE.equals(id))
			return new StereotypedPropertySource(getCastedSemanticModel(), componentDiagram.getCoreModel().getStereotypes());

		return super.getPropertyValue(id);
	}
	
	/**
	 * Sets the property with the given id if possible. Does nothing if the
	 * property's value cannot be changed or if this source does not have the
	 * specified property.
	 * @param id the id of the property
	 * @param value the value of the property
	 */
	public void setPropertyValue(Object id, Object value) {
		if (id == ID_NAME)
			getCastedSemanticModel().setName(value.toString());
		super.setPropertyValue(id, value);
	}
}