/**
 * $Id: ComponentCreationTool.java,v 1.10 2006/04/01 03:44:03 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor;

import org.eclipse.gef.tools.CreationTool;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.edit.editor.dialogs.ComponentRoleSelectionDialog;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.ucmeditor.commands.visual.InsertComponentRoleCommand;
import org.isistan.flabot.edit.ucmeditor.editparts.UCMDiagramEditPart;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class ComponentCreationTool extends CreationTool {
		
	/**
	 * Executes the current command and selects the newly created object.  The button that was
	 * released to cause this creation is passed in, but since {@link #handleButtonDown(int)}
	 * goes into the invalid state if the button pressed is not button 1, this will always be 
	 * button 1.  
	 * 
	 * @param button the button that was pressed
	 */
	protected void performCreation(int button) {
		if (getTargetEditPart() instanceof UCMDiagramEditPart) {
			UCMDiagramEditPart edit = (UCMDiagramEditPart)getTargetEditPart();
			CoreModel core = ((Diagram)edit.getModel()).getCoreModel();
//			if (core.getComponents().size() == 0) {
//				MessageDialog dlg = new MessageDialog(
//					Display.getCurrent().getActiveShell(),
//		            Messages.getString("org.isistan.flabot.edit.ucmeditor.ComponentCreationTool.createRoleMessageTitle"), //$NON-NLS-1$
//		            null,
//		            Messages.getString("org.isistan.flabot.edit.ucmeditor.ComponentCreationTool.createRoleMessageDescription"), //$NON-NLS-1$
//		            MessageDialog.QUESTION,
//		            new String[]{Messages.getString("org.isistan.flabot.edit.editor.okButton")}, //$NON-NLS-1$	            
//		            0);
//				dlg.open();
//				deactivate();
//				setState(STATE_TERMINAL);		
//			} else {
				InsertComponentRoleCommand command = (InsertComponentRoleCommand) getCommand();
				ComponentRole role = command.getRole();
				
//				ComponentRoleSelectionDialog dialog = ComponentRoleSelectionDialog.getDefault();
				ComponentRoleSelectionDialog dialog = new ComponentRoleSelectionDialog(Display.getCurrent().getActiveShell());
				ComponentModel model = dialog.openSingleWithAddNew(
						Display.getCurrent().getActiveShell(),
						Messages.getString("org.isistan.flabot.edit.ucmeditor.ComponentCreationTool.assignComponentTitle"), //$NON-NLS-1$
						Messages.getString("org.isistan.flabot.edit.ucmeditor.ComponentCreationTool.assignComponentDescription"), //$NON-NLS-1$
						core.getComponents(),
						null,
						(UCMDiagram)edit.getModel()); 
				
				if (model != null) {
					role.setComponent(model);
					super.performCreation(button);
				} else {
					deactivate();
					setState(STATE_TERMINAL);
				}				
//			}
		} else
			super.performCreation(button);
	}
}