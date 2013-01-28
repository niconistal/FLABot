/**
 * $Id: RolePropertySource.java,v 1.8 2006/03/21 02:34:08 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editor.properties.VisualPropertySource;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * Property Sheet that shows the properties of a Component Role
 * 
 * @author $Author: franco $
 *
 */
public class RolePropertySource extends VisualPropertySource {
	
	private static final String ID_NAME = "Role"; //$NON-NLS-1$
	private static final String ROLE_NAME = Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.RolePropertySource.role"); //$NON-NLS-1$
	
	private static final String ID_ABSTRACT_INFO = "Abstract_Info";  //$NON-NLS-1$
	private static final String NAME_ABSTRACT_INFO = Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.RolePropertySource.Abstract_Info"); //$NON-NLS-1$

	private List types = new ArrayList();
	private String[] availableLabels = new String[2];	

	/**
	 * Instantiates an instance of RolePropertySource.
	 * @param model the visual model of component role to show properties
	 * @param minDimension the minimum dimension of the visual model 
	 */
	public RolePropertySource(VisualModel model, Dimension minDimension) {
		super(model, minDimension);
		types.add(ComponentRole.standardComponent); availableLabels[0] = Messages.getString("org.isistan.flabot.coremodel.ComponentRole.standardComponent");  //$NON-NLS-1$
		types.add(ComponentRole.redefinedComponent); availableLabels[1] = Messages.getString("org.isistan.flabot.coremodel.ComponentRole.redefinedComponent"); //$NON-NLS-1$
	}
	
	/**
	 * @return the component role node to show properties
	 */
	private ComponentRole getCastedSemanticModel() {
		return (ComponentRole) getCastedVisualModel().getSemanticModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new TextPropertyDescriptor(ID_NAME, ROLE_NAME));
		descriptors.add(new PropertyDescriptor(VisualPropertySource.ID_LOCATION, VisualPropertySource.LOCATION_NAME));
		descriptors.add(new PropertyDescriptor(VisualPropertySource.ID_DIMENSION, VisualPropertySource.DIMENSION_NAME));
		if (getCastedSemanticModel() != null && getCastedSemanticModel().getMap() != null && getCastedSemanticModel().getMap().getLevelInfo().equals(UseCaseMap.architecturalLevel)){
			descriptors.add(new ComboBoxPropertyDescriptor(ID_ABSTRACT_INFO, NAME_ABSTRACT_INFO, availableLabels));
		}
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
		
		if (getCastedSemanticModel().getMap() != null && getCastedSemanticModel().getMap().getLevelInfo().equals(UseCaseMap.architecturalLevel)){
			if(id == ID_ABSTRACT_INFO) {
				int index = 0;
				if (getCastedSemanticModel() != null) {
					index = types.indexOf(getCastedSemanticModel().getAbstractInfo());
					if (index < 0) index = 0;
				}
				return index;			
			}
		}
		
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
		
		if (getCastedSemanticModel().getMap().getLevelInfo().equals(UseCaseMap.architecturalLevel)){
			if (id == ID_ABSTRACT_INFO) {
				int index = Integer.parseInt(value.toString());
				if (index < 0 || index >= types.size())
					index = 0;
				getCastedSemanticModel().setAbstractInfo((String)types.get(index));
			}
		}
		
		super.setPropertyValue(id, value);
	}
}