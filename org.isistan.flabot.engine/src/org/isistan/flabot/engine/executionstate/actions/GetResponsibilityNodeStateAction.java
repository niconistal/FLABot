/**
 * $Id: GetResponsibilityNodeStateAction.java,v 1.7 2006/03/22 01:13:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine.executionstate.actions;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;

/**
 * Show the state of a responsibility node
 * @author $Author: franco $
 *
 */
public class GetResponsibilityNodeStateAction extends SelectionAction {

	public static final String GET_RESPONSIBILITYNODESTATE =
		"Get_ResponsibilityNodeState";

	public GetResponsibilityNodeStateAction(IWorkbenchPart part) {
		super(part);
		setText("Get responsibility node state");
		setId(GET_RESPONSIBILITYNODESTATE);
	}

	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}
	
	/**
	 * the selection must be a responsibility node and its responsibility
	 * must not be null
	 * @return whether the action can be performed or not
	 */
	private boolean canPerformAction() {
		
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if (!(o instanceof PathNodeEditPart))
			return false;
		
		PathNodeEditPart part = (PathNodeEditPart)o;
		if (!(part.getCastedModel().getSemanticModel() instanceof ResponsibilityNode))
			return false;
		
		ResponsibilityNode node = (ResponsibilityNode) part.getCastedModel().getSemanticModel();
		if (node.getResponsibility() == null)
			return false;
		
		return true;
	}

	@Override
	public void run() {
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);
		
		ResponsibilityNode responsibilityNode = (ResponsibilityNode) part.getCastedModel().getSemanticModel();
		Diagnostic diagnostic = ExecutionStateManager.getState(
				responsibilityNode,
				Collections.emptyMap(), null);
		
		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), "Execution state diagnostic",
				"Execution state diagnostic for responsibility \"" +
				responsibilityNode.getResponsibility() +
				"\":\n" + diagnostic);
	}
}