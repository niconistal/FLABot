/**
 * $Id: DimensionPropertySource.java,v 1.7 2006/03/21 01:51:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.properties;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * DimensionPropertySource
 * -	Uses for showing the properties of a visual model
 * -	The properties shown are width and height. It also verifies when the size changed that it is not greater than the minimum size, if so the size is set as the minimum.
 * 
 * @author $Author: franco $
 *
 */
public class DimensionPropertySource extends AbstractPropertySource {

	
	private static final String ID_WIDTH = "Width"; //$NON-NLS-1$
	private static final String WIDTH_NAME = Messages.getString("org.isistan.flabot.edit.editor.properties.DimensionPropertySource.width"); //$NON-NLS-1$
	
	private static final String ID_HEIGHT = "Components"; //$NON-NLS-1$
	private static final String HEIGHT_NAME = Messages.getString("org.isistan.flabot.edit.editor.properties.DimensionPropertySource.height"); //$NON-NLS-1$
	
	private Dimension minDimension;
		
	/**
	 * Instantiates an instance of DimensionPropertySource.
	 * @param model the visual model to show properties
	 * @param minDimension the minimum dimension of the visual model
	 */
	public DimensionPropertySource(VisualModel model, Dimension minDimension) {
		super(model);
		this.minDimension = minDimension;
	}
	
	/**
	 * @return the visual model to show properties
	 */
	private VisualModel getVisualModel() {
		return (VisualModel) getModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new TextPropertyDescriptor(ID_WIDTH, WIDTH_NAME));
		descriptors.add(new TextPropertyDescriptor(ID_HEIGHT, HEIGHT_NAME));
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
		if(id == ID_WIDTH) {
			return Integer.toString(getVisualModel().getSize().getWidth());
		}
		if(id == ID_HEIGHT) {
			return Integer.toString(getVisualModel().getSize().getHeight());
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
		if (id == ID_WIDTH) {
			org.isistan.flabot.edit.editormodel.Dimension d = Util.getDimension(parseInt(value.toString(),getVisualModel().getSize().getWidth()),getVisualModel().getSize().getHeight());
			if (d.getWidth() < minDimension.width)
				d.setWidth(minDimension.width);
			getVisualModel().setSize(d);
		} else if(id == ID_HEIGHT) {
			org.isistan.flabot.edit.editormodel.Dimension d =  Util.getDimension(getVisualModel().getSize().getWidth(),parseInt(value.toString(),getVisualModel().getSize().getHeight()));			
			if (d.getHeight() < minDimension.height)
				d.setHeight(minDimension.height);
			getVisualModel().setSize(Util.getDimension(getVisualModel().getSize().getWidth(),parseInt(value.toString(),getVisualModel().getSize().getHeight())));
		}
	}
	
	private int parseInt(String value, int oldValue) {
		try { 
			int v = Integer.parseInt(value.toString()); 
			if (v > 0)
				oldValue = v;
		} catch (NumberFormatException e) {} 
		
		return oldValue;
	}
	
	public String toString() {
		return new String("("+getVisualModel().getSize().getWidth()+","+getVisualModel().getSize().getHeight()+")"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
}