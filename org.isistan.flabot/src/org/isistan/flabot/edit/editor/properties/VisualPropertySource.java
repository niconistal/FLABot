/**
 * $Id: VisualPropertySource.java,v 1.4 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.properties;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * VisualPropertySource
 * -	Uses for showing the properties of a visual model.
 * -	The properties shown are size and location.
 * 
 * @author $Author: franco $
 *
 */
public class VisualPropertySource extends AbstractPropertySource {
	
	protected static final String ID_LOCATION = "Location"; //$NON-NLS-1$
	protected static final String LOCATION_NAME = Messages.getString("org.isistan.flabot.edit.editor.properties.VisualPropertySource.location"); //$NON-NLS-1$
	
	protected static final String ID_DIMENSION = "Dimension"; //$NON-NLS-1$
	protected static final String DIMENSION_NAME = Messages.getString("org.isistan.flabot.edit.editor.properties.VisualPropertySource.dimension"); //$NON-NLS-1$
	
	private Dimension minDimension;
	
	/**
	 * Instantiates an instance of VisualPropertySource.
	 * @param model the visual model to show properties
	 * @param minDimension the minimum dimension of the visual model
	 */
	public VisualPropertySource(VisualModel model, Dimension minDimension) {
		super(model);
		this.minDimension = minDimension;
	}
	
	/**
	 * @return the visual model to show properties
	 */
	protected VisualModel getCastedVisualModel(){
		return (VisualModel) getModel();
	}

	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new PropertyDescriptor(ID_LOCATION, LOCATION_NAME));
		descriptors.add(new PropertyDescriptor(ID_DIMENSION, DIMENSION_NAME));
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
		if(id == ID_DIMENSION) {
			return new DimensionPropertySource(getCastedVisualModel(), minDimension);
		} 
		if(id == ID_LOCATION) {
			return new LocationPropertySource(getCastedVisualModel());
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
		//Do nothing	
	}
}