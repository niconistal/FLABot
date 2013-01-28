package org.isistan.flabot.executionstatemapping.editor.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.ui.views.properties.ComboBoxPropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;
import org.isistan.flabot.edit.editor.properties.AbstractPropertySource;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionStateValue;
import org.isistan.flabot.executionstatemapping.model.semantic.StateContainer;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

public class StateDiagramProperty extends AbstractPropertySource {
	
	private static final String ID_NAME = "Diagram Name"; //$NON-NLS-1$
	private static final String NAME_NAME = Messages.getString("org.isistan.flabot.executionstatemapping.editor.properties.StateDiagramProperty.diagramName"); //$NON-NLS-1$
	
	public static final String ID_STATE_DEFAULT = "STATE_DEFAULT"; //$NON-NLS-1$
	public static final String NAME_STATE_DEFAULT = org.isistan.flabot.executionstatemapping.messages.Messages.getString("org.isistan.flabot.executionmapping.editor.properties.StateDiagramProperty.notVerified"); //$NON-NLS-1$
	
	public static final String ID_STATE_EXCEPTION = "STATE_EXCEPTION"; //$NON-NLS-1$
	public static final String NAME_STATE_EXCEPTION = org.isistan.flabot.executionstatemapping.messages.Messages.getString("org.isistan.flabot.executionmapping.editor.properties.StateDiagramProperty.ifException"); //$NON-NLS-1$
	
	public static final String NAME_NONE = org.isistan.flabot.executionstatemapping.messages.Messages.getString("org.isistan.flabot.executionmapping.editor.properties.StateDiagramProperty.none"); //$NON-NLS-1$
	public static final String NAME_NOTEXECUTED = org.isistan.flabot.executionstatemapping.messages.Messages.getString("org.isistan.flabot.executionmapping.editor.properties.StateDiagramProperty.notExecuted"); //$NON-NLS-1$
	public static final String NAME_EXECUTED = org.isistan.flabot.executionstatemapping.messages.Messages.getString("org.isistan.flabot.executionmapping.editor.properties.StateDiagramProperty.executed"); //$NON-NLS-1$
	public static final String NAME_FAULTY = org.isistan.flabot.executionstatemapping.messages.Messages.getString("org.isistan.flabot.executionmapping.editor.properties.StateDiagramProperty.faulty"); //$NON-NLS-1$
	
	
	private List<ExecutionStateValue> types = new ArrayList<ExecutionStateValue>();
	private String[] availableLabels = new String[4];
			
	/**
	 * Instantiates an instance of ComponentDiagramProperty.
	 * @param model the component diagram to show properties
	 */
	public StateDiagramProperty(StateDiagram model) {
		super(model);		

		types.add(ExecutionStateValue.NONE); availableLabels[0] = NAME_NONE;
		types.add(ExecutionStateValue.NOT_EXECUTED); availableLabels[1] = NAME_NOTEXECUTED;
		types.add(ExecutionStateValue.EXECUTED); availableLabels[2] = NAME_EXECUTED;
		types.add(ExecutionStateValue.FAULTY); availableLabels[3] = NAME_FAULTY;		
	}
	
	/**
	 * @return the component diagram to show properties
	 */
	private StateDiagram getDiagram() {
		return (StateDiagram) getModel();
	}

	private StateContainer getCastedSemanticModel() {
		return (StateContainer) getDiagram().getSemanticModel();
	}

	
	@Override
	public void createPropertyDescriptors(List descriptors) {
		descriptors.add(new TextPropertyDescriptor(ID_NAME, NAME_NAME));
		descriptors.add(new ComboBoxPropertyDescriptor(ID_STATE_DEFAULT, NAME_STATE_DEFAULT, availableLabels));
		descriptors.add(new ComboBoxPropertyDescriptor(ID_STATE_EXCEPTION, NAME_STATE_EXCEPTION, availableLabels));
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
			if (getDiagram() != null)
				name = new String(getDiagram().getName());
			return name;
		}
		
		if(id == ID_STATE_DEFAULT) {
			int index = types.indexOf(getCastedSemanticModel().getDefaultState());
			if (index < 0) index = 0;
			return index;
		}
		
		if(id == ID_STATE_EXCEPTION) {
			int index = types.indexOf(getCastedSemanticModel().getExceptionState());
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
		if (id == ID_NAME)
		{
			getDiagram().setName(value.toString());
			((StateContainer)getDiagram().getSemanticModel()).setName(value.toString());
		}
		
		if (id == ID_STATE_DEFAULT) {
			int index = ((Integer)value).intValue();
			ExecutionStateValue state = ExecutionStateValue.NONE;
			if (index > 0 && index <= types.size())
			{
				state = types.get(index);
			}
			getCastedSemanticModel().setDefaultState(state);
		}
		
		if (id == ID_STATE_EXCEPTION) {
			int index = ((Integer)value).intValue();
			ExecutionStateValue state = ExecutionStateValue.NONE;
			if (index > 0 && index <= types.size())
			{
				state = types.get(index);
			}
			getCastedSemanticModel().setExceptionState(state);
		}
	}
}