/**
 * $Id: RelationshipConnectionProperty.java,v 1.9 2006/02/07 21:19:46 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.properties;

import java.util.List;

import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 * RelationshipConnectionProperty
 * -	Uses for showing the properties of a relationship.
 * -	The properties shown are name and direction of the relationship.
 * 
 * @author $Author: franco $
 *
 */
public class RelationshipConnectionProperty extends AbstractPropertySource {
	
	private final static String ID_DIRECTION = "DIRECTION"; //$NON-NLS-1$
	private final static String NAME_DIRECTION = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.RelationshipConnectionProperty.direction"); //$NON-NLS-1$
	private final static String ID_STEREOTYPE = "STEREOTYPE"; //$NON-NLS-1$
	private final static String NAME_STEREOTYPE = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.RelationshipConnectionProperty.stereotype"); //$NON-NLS-1$
	
	private ComponentDiagram componentDiagram;
		
	/**
	 * Instantiates an instance of RelationshipConnectionProperty.
	 * @param model the relationship to show properties
	 * @param componentDiagram the component diagram
	 */
	public RelationshipConnectionProperty(Relationship model, ComponentDiagram componentDiagram) {
		super(model);
		this.componentDiagram = componentDiagram;
	}
	
	/**
	 * @return the relationship to show properties
	 */
	private Relationship getCastedModel() {
		return (Relationship) getModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {	
		descriptors.add(new PropertyDescriptor(ID_DIRECTION, NAME_DIRECTION));
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
		if (ID_STEREOTYPE.equals(id)) {
			return new StereotypedPropertySource(getCastedModel(), componentDiagram.getCoreModel().getStereotypes());
		}
		if (ID_DIRECTION.equals(id)) {
			return new DirectionProperty(getCastedModel());
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
		// Do nothing
	}
}