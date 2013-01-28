/**
 * $Id: FlabotTreeEditPartFactory.java,v 1.6 2005/12/16 17:06:38 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.outline;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;

/**
 * Edit part factory for the flabot outline view
 * @author $Author: franco $
 *
 */
public class FlabotTreeEditPartFactory implements EditPartFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.gef.EditPartFactory#createEditPart(org.eclipse.gef.EditPart, java.lang.Object)
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof FlabotFileModel) {
			return new FlabotFileTreeEditPart((FlabotFileModel) model);
		}
		if (model instanceof CoreModel) {
			return new CoreModelTreeEditPart((CoreModel) model); 
		}		
		if (model instanceof ComponentModel) {
			return new ComponentTreeEditPart((ComponentModel) model);
		}
		if (model instanceof Responsibility) {
			return new ResponsibilityTreeEditPart((Responsibility) model);
		}
		if (model instanceof InterfaceModel) {
			return new InterfaceTreeEditPart((InterfaceModel) model);
		}
		if (model instanceof Stereotype) {
			return new StereotypeTreeEditPart((Stereotype) model);
		}
		if (model instanceof InterfaceLink) {
			return new InterfaceLinkTreeEditPart((InterfaceLink) model);
		}
		if (model instanceof Relationship) {
			return new RelationshipTreeEditPart((Relationship) model);
		}
		if (model instanceof UseCaseMap) {
			return new UseCaseMapTreeEditPart((UseCaseMap) model);
		}
		if (model instanceof ComponentRole) {
			return new ComponentRoleTreeEditPart((ComponentRole) model);
		}
		if (model instanceof Diagram) {
			return new DiagramTreeEditPart((Diagram) model);
		}
		if (model instanceof PortModel) {
			return new PortTreeEditPart((PortModel) model);
		}		
		if (model instanceof Folder) {
			return new DiagramFolderTreeEditPart((Folder) model);
		}
		if (model instanceof SimplePathNode){
			return new StartPointEditPart((SimplePathNode) model);
		}
		return null;
	}

}
