/**
 * $Id: StereotypedPropertySource.java,v 1.8 2006/02/07 21:19:46 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.properties;

import java.util.Iterator;
import java.util.List;

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StereotypedElementModel;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.messages.Messages;

/**
 * StereotypedPropertySource
 * -	Uses for showing the properties of the stereotype of a component or relationship.
 * -	The property shown is the name of the sterotype. A combo box is provided so the stereotype can be changed.
 * 
 * @author $Author: franco $
 *
 */
public class StereotypedPropertySource  extends AbstractPropertySource {

	private static final String ID_STEREOTYPE_NAME = "NAME"; //$NON-NLS-1$
	private static final String NAME_STEREOTYPE_NAME = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.StereotypedPropertySource.name"); //$NON-NLS-1$
	
	private List stereotypes;
	
	/**
	 * Instantiates an instance of RelationshipConnectionProperty.
	 * @param model the stereotype to show properties
	 * @param componentDiagram the component diagram
	 */
	public StereotypedPropertySource(StereotypedElementModel model, List stereotypes) {
		super(model);
		this.stereotypes = stereotypes;
	}
	
	/**
	 * @return the stereotype to show properties
	 */
	private StereotypedElementModel getCastedModel() {
		return (StereotypedElementModel) getModel();
	}
	
	/**
	 * Returns the value of the property with the given id if it has one.
	 * Returns <code>null</code> if the property's value is <code>null</code>
	 * value or if this source does not have the specified property.
	 * 
	 * @param id the id of the property being set
	 * @return the value of the property, or <code>null</code>
	 */
	public void createPropertyDescriptors(List descriptors) {
		String[] availableLabels = new String[stereotypes.size()+1];
		int i = 0;
		for (Iterator componentIterator = stereotypes.iterator(); componentIterator.hasNext();) {
			Stereotype stereotype = (Stereotype) componentIterator.next();
			availableLabels[i++] = stereotype.getName();
		}
		availableLabels[i] = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.StereotypedPropertySource.noStereotype"); //$NON-NLS-1$
		
		descriptors.add(new ComboBoxPropertyDescriptor(ID_STEREOTYPE_NAME, NAME_STEREOTYPE_NAME,availableLabels));
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
		if (ID_STEREOTYPE_NAME.equals(id)) {
			Stereotype stereotype = getCastedModel().getStereotype();
			if (stereotype == null)
				return stereotypes.size();
			return stereotypes.indexOf(stereotype);
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
		if (ID_STEREOTYPE_NAME.equals(id)) {
			int index = Integer.parseInt(value.toString());
			Stereotype stereotype = null;
			if (index >=0 && index < stereotypes.size())
				stereotype = (Stereotype) stereotypes.get(index);
			getCastedModel().setStereotype(stereotype);
		}
	}
	
	public String toString() {
		return new String(""); //$NON-NLS-1$
	}
}