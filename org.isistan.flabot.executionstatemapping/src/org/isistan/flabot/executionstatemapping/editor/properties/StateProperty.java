package org.isistan.flabot.executionstatemapping.editor.properties;

import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.edit.editor.properties.VisualPropertySource;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.State;

public class StateProperty extends VisualPropertySource {
	
	private static final String ID_NAME = "NAME"; //$NON-NLS-1$
	
	private static final String NAME_NAME = Messages.getString("org.isistan.flabot.executionstatemapping.editor.properties.StateProperty.name"); //$NON-NLS-1$
	
	/**
	 * Instantiates an instance of  StateProperty.
	 * @param model the visual model of the component to show properties
	 * @param minDimension the minimum dimension of the component
	 */
	public StateProperty(VisualModel model, Dimension minDimension) {
		super(model, minDimension);
	}
	
	/**
	 * @return the component model to show properties
	 */
	private State getCastedSemanticModel() {
		return (State) getCastedVisualModel().getSemanticModel();
	}
	
	@Override
	public void createPropertyDescriptors(List descriptors) {
		super.createPropertyDescriptors(descriptors);
		descriptors.add(new TextPropertyDescriptor(ID_NAME, NAME_NAME));
	}
	
	/**
	 * Returns the value of the property with the given id if it has one.
	 * Returns <code>null</code> if the property's value is <code>null</code>
	 * value or if this source does not have the specified property.
	 * 
	 * @param id the id of the property being set
	 * @return the value of the property, or <code>null</code>
	 */
	@Override
	public Object getPropertyValue(Object id) {
		if(id == ID_NAME)
			return new String(getCastedSemanticModel().getName());
 
		return super.getPropertyValue(id);
	}
	
	/**
	 * Sets the property with the given id if possible. Does nothing if the
	 * property's value cannot be changed or if this source does not have the
	 * specified property.
	 * @param id the id of the property
	 * @param value the value of the property
	 */
	@Override
	public void setPropertyValue(Object id, Object value) {
		if (id == ID_NAME)
			getCastedSemanticModel().setName(value.toString());
		super.setPropertyValue(id, value);
	}
}
