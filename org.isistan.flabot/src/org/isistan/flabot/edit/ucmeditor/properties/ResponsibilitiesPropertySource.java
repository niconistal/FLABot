/**
 * $Id: ResponsibilitiesPropertySource.java,v 1.9 2006/03/29 01:35:44 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.edit.ucmeditor.properties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: mblech $
 *
 */
public class ResponsibilitiesPropertySource extends AbstractPropertySource {
	
	private final static String ID_RESPONSIBILITIES = "Responsibilities"; //$NON-NLS-1$
	private final static String RESPONSIBILITIES_NAME = Messages.getString("org.isistan.flabot.edit.ucmeditor.properties.ResponsibilitiesPropertySource.responsibilities"); //$NON-NLS-1$
	
	private List availableResponsibilities;

	/**
	 * Instantiates an instance of ResponsibilitiesPropertySource.
	 * @param model the visual model of the responsibility node to show properties
	 */
	public ResponsibilitiesPropertySource(NodeVisualModel model) {
		super(model);
	}
	
	/**
	 * @return the visual model to show properties
	 */
	private NodeVisualModel getCastedModel() {
		return (NodeVisualModel) getModel();
	}
	
	/**
	 * @return the responsibility node to show properties
	 */
	private ResponsibilityNode getSemanticModel() {
		return (ResponsibilityNode) getCastedModel().getSemanticModel();
	}

	private List getResponsibilities() {
		ResponsibilityNode rn = getSemanticModel();
		if (getSemanticModel() != null) {
			if (rn.getRole() == null && getCastedModel().getDiagram() != null)				
				return getCastedModel().getDiagram().getCoreModel().getResponsibilities();
			else if (rn.getRole() != null)
				return rn.getRole().getComponent().getFeatures();
		}
		return Collections.emptyList();
	}
		
	/* (non-Javadoc)
	 * @see org.isistan.flabot.edit.componenteditor.properties.AbstractPropertySource#createPropertyDescriptors(java.util.List)
	 */
	@Override
	public void createPropertyDescriptors(List descriptors) {
		
		availableResponsibilities = new ArrayList();
		
		availableResponsibilities = getResponsibilities();
		String[] availableLabels = new String[availableResponsibilities.size()];
		int i = 0;
		for (Iterator iter = availableResponsibilities.iterator(); iter.hasNext();) {
			Responsibility responsibility = (Responsibility) iter.next();
			availableLabels[i++] = responsibility.getName();
		}
	
		descriptors.add(new ComboBoxPropertyDescriptor(ID_RESPONSIBILITIES, RESPONSIBILITIES_NAME,
				availableLabels
		));
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
		if (ID_RESPONSIBILITIES.equals(id)) {
			if (getSemanticModel() != null) {
				Responsibility responsibility = getSemanticModel().getResponsibility();
				return availableResponsibilities.indexOf(responsibility);
			}
			return 0;
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
		if (ID_RESPONSIBILITIES.equals(id)) {
			int index = Integer.parseInt(value.toString());						
			if (index < 0 || index >= availableResponsibilities.size())
				index = 0;
			
			if (getSemanticModel() != null)
				getSemanticModel().setResponsibility((Responsibility) availableResponsibilities.get(index));
		}
	}

}