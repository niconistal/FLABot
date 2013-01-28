/**
 * $Id: DirectionProperty.java,v 1.7 2006/03/28 18:56:40 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.coremodel.RelationshipDirection;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.messages.Messages;

/**
 * DirectionProperty
 * -	Uses for showing the direction (source, target or bidirectional) of a relationship between two components.
 *  
 * @author $Author: franco $
 *
 */
public class DirectionProperty extends AbstractPropertySource {
	
	public static final String ID_DIRECTION = "DIRECTION"; //$NON-NLS-1$
	public static final String NAME_DIRECTION = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.DirectionProperty.direction"); //$NON-NLS-1$;
	
	public static final String NAME_UNSPECIFIED = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.DirectionProperty.unspecified"); //$NON-NLS-1$;
	public static final String NAME_SOURCE = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.DirectionProperty.source"); //$NON-NLS-1$;
	public static final String NAME_TARGET = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.DirectionProperty.target"); //$NON-NLS-1$;
	public static final String NAME_BIDIRECTIONAL = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.DirectionProperty.bidirectional"); //$NON-NLS-1$;
	
	private List types = new ArrayList();
	private String[] availableLabels = new String[4];	

	/**
	 * Instantiates an instance of DirectionProperty.
	 * @param model the visual model of the relationship to show properties
	 */
	public DirectionProperty(Relationship model) {
		super(model);
		
		types.add(RelationshipDirection.UNSPECIFIED_LITERAL); availableLabels[0] = NAME_UNSPECIFIED;
		types.add(RelationshipDirection.SOURCE_LITERAL); availableLabels[1] = NAME_SOURCE;
		types.add(RelationshipDirection.TARGET_LITERAL); availableLabels[2] = NAME_TARGET;
		types.add(RelationshipDirection.BIDIRECTIONAL_LITERAL); availableLabels[3] = NAME_BIDIRECTIONAL;
	}

	/**
	 * @return the relationship model to show properties
	 */
	private Relationship getCastedSemanticModel() {
		return (Relationship) getModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new ComboBoxPropertyDescriptor(ID_DIRECTION, NAME_DIRECTION, availableLabels));
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
		if(id == ID_DIRECTION) {
			int index = types.indexOf(getCastedSemanticModel().getDirection());
			if (index < 0) index = 0;
			return index;
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
		if (id == ID_DIRECTION) {
			int index = ((Integer)value).intValue();
			if (index < 0 || index >= types.size())
				index = 0;
			getCastedSemanticModel().setDirection((RelationshipDirection)types.get(index));
		}
	}
	
	public String toString() {
		return ""; //$NON-NLS-1$
	}
}