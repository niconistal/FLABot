/**
 * $Id: LocationPropertySource.java,v 1.3 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.properties;

import java.util.List;

import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * LocationPropertySource
 * -	Uses for showing the properties of a visual model
 * -	The properties shown are x and y location in the diagram.
 * 
 * @author $Author: franco $
 *
 */
public class LocationPropertySource extends AbstractPropertySource {

	private static final String ID_X = "X"; //$NON-NLS-1$
	private static final String X_NAME = Messages.getString("org.isistan.flabot.edit.editor.properties.LocationPropertySource.x"); //$NON-NLS-1$
	
	private static final String ID_Y = "Y"; //$NON-NLS-1$
	private static final String Y_NAME = Messages.getString("org.isistan.flabot.edit.editor.properties.LocationPropertySource.y"); //$NON-NLS-1$
		
	/**
	 * Instantiates an instance of LocationPropertySource.
	 * @param model the visual model to show properties
	 */
	public LocationPropertySource(VisualModel model) {
		super(model);
	}
	
	/**
	 * @return the visual model to show properties
	 */
	private VisualModel getVisualModel() {
		return (VisualModel) getModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new TextPropertyDescriptor(ID_X, X_NAME));
		descriptors.add(new TextPropertyDescriptor(ID_Y, Y_NAME));
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
		if(id == ID_X) {
			return Integer.toString(getVisualModel().getLocation().getX());
		}
		if(id == ID_Y) {
			return Integer.toString(getVisualModel().getLocation().getY());
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
		if (id == ID_X) 
			getVisualModel().setLocation(Util.getPoint(parseInt(value.toString(), getVisualModel().getLocation().getX()), getVisualModel().getLocation().getY()));
		else if (id == ID_Y) 
			getVisualModel().setLocation(Util.getPoint(getVisualModel().getLocation().getX(), parseInt(value.toString(), getVisualModel().getLocation().getY())));		
	}
	
	private int parseInt(String value, int oldValue) {
		try { 
			return Integer.parseInt(value.toString());
		} catch (NumberFormatException e) {
			return oldValue;
		}
	}
	
	public String toString() {
		return new String("("+getVisualModel().getLocation().getX()+","+getVisualModel().getLocation().getY()+")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}