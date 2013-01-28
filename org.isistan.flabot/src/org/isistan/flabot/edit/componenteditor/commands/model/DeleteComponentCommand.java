/**
 * $Id: DeleteComponentCommand.java,v 1.3 2006/03/28 04:47:15 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.componenteditor.commands.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.FeatureModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteComponentRoleCommand;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class DeleteComponentCommand extends CompoundCommand {
	
	private ComponentModel component;
	private CoreModel coreModel;
	private List<FeatureModel> features = new ArrayList<FeatureModel>();
	
	
	/**
	 * Create a command that will remove the Component from its parent.
	 * @param parent the ComponentDiagram containing the child
	 * @param child    the Component to remove
	 * @throws IllegalArgumentException if any parameter is null
	 */
	public DeleteComponentCommand(CoreModel coreModel, ComponentModel component) {
		this.component = component;
		this.coreModel = coreModel;
		setLabel(Messages.getString("org.isistan.flabot.edit.componenteditor.commands.model.DeleteComponentCommand.label")); //$NON-NLS-1$
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	public boolean canUndo() {
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#canUndo()
	 */
	public boolean canExecute() {
		return (component != null && coreModel != null);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	public void execute() {	    	    
		for (Iterator iterMaps =coreModel.getUseCaseMaps().iterator(); iterMaps.hasNext(); ) {
			UseCaseMap ucm = (UseCaseMap) iterMaps.next();
			for (Iterator iterRoles = ucm.getComponentRoles().iterator(); iterRoles.hasNext(); ) {
				ComponentRole role = (ComponentRole) iterRoles.next();
				if (role.getComponent() == component)
					add(new DeleteComponentRoleCommand(coreModel, role));
	    	}
	    }
		for (Iterator iterPorts =component.getOwnedPorts().iterator(); iterPorts.hasNext(); ) {
			PortModel port = (PortModel) iterPorts.next();
			add(new DeletePortCommand(component, port));
		}
		for (Iterator iter=component.getFeatures().iterator(); iter.hasNext();)
			features.add((FeatureModel)iter.next());
		
		super.execute();			
	    redo();
	}
	
	private void doDeleteComponent() {	
		for (FeatureModel featureModel: features)
			featureModel.getComponents().remove(component);
		
		coreModel.getComponents().remove(component);
	}
	
	private void undoDeleteComponent() {
		coreModel.getComponents().add(component);
		for (FeatureModel featureModel: features)
			featureModel.getComponents().add(component);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	public void redo() {
		super.redo();
		doDeleteComponent();
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	public void undo() {
		undoDeleteComponent();
		super.undo();
	}
}