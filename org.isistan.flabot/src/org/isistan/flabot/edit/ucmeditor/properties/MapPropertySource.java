/**
 * $Id: MapPropertySource.java,v 1.14 2006/03/21 02:34:08 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

public class MapPropertySource extends AbstractPropertySource {

	private static final String ID_MAP = "Map Name"; //$NON-NLS-1$
	private static final String MAP_NAME = Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.MapPropertySource.mapName"); //$NON-NLS-1$
	
	private static final String ID_DESCRIPTION = "Description"; //$NON-NLS-1$
	private static final String DESCRIPTION_NAME = Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.MapPropertySource.description"); //$NON-NLS-1$
	
	private static final String ID_PATHS = "Paths"; //$NON-NLS-1$
	private static final String PATHS_NAME = Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.MapPropertySource.paths"); //$NON-NLS-1$
	
	private static final String ID_LEVEL = "Level"; //$NON-NLS-1$
	private static final String LEVEL_NAME = Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.Level"); //$NON-NLS-1$
	
	private List types = new ArrayList();
	private String[] availableLabels = new String[2];	
	
	/**
	 * Instantiates an instance of MapPropertySource.
	 * @param model the ucm diagram to show properties
	 */
	public MapPropertySource(UCMDiagram model) {
		super(model);
		types.add(UseCaseMap.architecturalLevel); availableLabels[0] = Messages.getString("org.isistan.flabot.coremodel.UseCaseMap.architecturalLevel"); //$NON-NLS-1$
		types.add(UseCaseMap.functionalLevel); availableLabels[1] = Messages.getString("org.isistan.flabot.coremodel.UseCaseMap.functionalLevel");		 //$NON-NLS-1$
	}
	
	/**
	 * @return the ucm diagram to show properties
	 */
	private UseCaseMap getMapModel() {
		return getVisualModel().getMap();
	}
	
	private UCMDiagram getVisualModel() {
		return (UCMDiagram) getModel();
	}
	
	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new TextPropertyDescriptor(ID_MAP, MAP_NAME));
		descriptors.add(new TextPropertyDescriptor(ID_DESCRIPTION, DESCRIPTION_NAME));
		descriptors.add(new TextPropertyDescriptor(ID_PATHS, PATHS_NAME));
		descriptors.add(new ComboBoxPropertyDescriptor(ID_LEVEL, LEVEL_NAME, availableLabels));
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
		if(id == ID_MAP)
			return new String(getVisualModel().getName());
			
		if(id == ID_DESCRIPTION) {
			UseCaseMap map = getMapModel();
			String description = new String();
			if (map != null)
				description = new String(map.getDescription());
			return description;
		}
		
		if(id == ID_PATHS) {
			String s = new String("0"); //$NON-NLS-1$
			UseCaseMap map = getMapModel();
			if (map != null) {
				List list = map.getPaths(); 		
				int size = 0;
				if (list != null) size = list.size();	
				s = Integer.toString(size);
			}
			return s;			
		}
		
		if(id == ID_LEVEL) {
			int index = 0;
			UseCaseMap map = getMapModel();
			if (map != null) {
				index = types.indexOf(getMapModel().getLevelInfo());
				if (index < 0) index = 0;
			}
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
		if(id == ID_MAP)
			getVisualModel().setName(value.toString());

		if(id == ID_DESCRIPTION)
			getMapModel().setDescription(value.toString());
		
		if (id == ID_LEVEL) {
			int index = Integer.parseInt(value.toString());
			if (index < 0 || index >= types.size())
				index = 0;
			getMapModel().setLevelInfo((String)types.get(index));
		}
	}
}