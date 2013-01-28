/**
 * $Id: DropComponentRoleFactory.java,v 1.4 2005/12/21 00:29:37 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import org.eclipse.emf.ecore.EObject;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * @author $Author: franco $
 *
 */
public class DropComponentRoleFactory extends ComponentDropFactory {
	
	 public DropComponentRoleFactory(FlabotFileModel file) {
		   super(file);
	 }
	 
	 protected EObject getSemanticModel() {
		 ComponentModel component = (ComponentModel) getCorrectComponent();
		 if (component != null) {
			 ComponentRole role = CoremodelFactory.eINSTANCE.createComponentRole();
			 role.setComponent(getCorrectComponent());
			 return role;
		 }
		 return null;
	 }
	 
	 public Object getObjectType() {
	      return ComponentRole.class;
	 }
	 
	 public Object getNewObject() {	      
		 ComponentRole role = (ComponentRole) getSemanticModel();
		 if (role != null) {
			 NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();		   			   	
			 visual.setSemanticModel(getSemanticModel());
			 return visual;
		 }
		 return null;
	 }
}