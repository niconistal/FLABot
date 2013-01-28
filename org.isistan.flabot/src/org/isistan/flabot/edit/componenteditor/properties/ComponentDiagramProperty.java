/**
 * $Id: ComponentDiagramProperty.java,v 1.11 2006/02/03 21:03:03 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.componenteditor.properties;

import java.util.List;

import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.edit.componentmodel.ComponentDiagram;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.messages.Messages;

/**
 * ComponentDiagramProperty
 * -	Uses for showing the properties of the component diagram.
 * -	The properties shown are name and number of components.
 * 
 * @author $Author: dacostae $
 *
 */
public class ComponentDiagramProperty extends AbstractPropertySource {
	
	private static final String ID_NAME = "Diagram Name"; //$NON-NLS-1$
	private static final String NAME_NAME = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.ComponentDiagramProperty.diagramName"); //$NON-NLS-1$
	
	private static final String ID_COMPONENTS = "Components"; //$NON-NLS-1$
	private static final String NAME_COMPONENTS = Messages.getString("org.isistan.flabot.edit.componenteditor.properties.ComponentDiagramProperty.components"); //$NON-NLS-1$
		
	/**
	 * Instantiates an instance of ComponentDiagramProperty.
	 * @param model the component diagram to show properties
	 */
	public ComponentDiagramProperty(ComponentDiagram model) {
		super(model);
	}
	
	/**
	 * @return the component diagram to show properties
	 */
	private ComponentDiagram getComponentDiagram() {
		return (ComponentDiagram) getModel();
	}

	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new TextPropertyDescriptor(ID_NAME, NAME_NAME));
		descriptors.add(new TextPropertyDescriptor(ID_COMPONENTS, NAME_COMPONENTS));
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
			String name = new String();
			if (getComponentDiagram() != null)
				name = new String(getComponentDiagram().getName());
			return name;
		}
		
		if(id == ID_COMPONENTS) {
			String s = new String("0"); //$NON-NLS-1$
			if (getComponentDiagram() != null) {
				int size = getComponentDiagram().getChildren().size() - getComponentDiagram().getNotes().size(); 		
				if (size < 0) size = 0;	
				s = Integer.toString(size);
			}
			return s;
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
		if (id == ID_NAME)
			getComponentDiagram().setName(value.toString());
	}
}