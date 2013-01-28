/** * $Id: TreatFailureAction.java,v 1.4 2006/03/29 20:41:51 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.LinkedList;import java.util.List;import org.eclipse.gef.ui.actions.SelectionAction;import org.eclipse.swt.widgets.Display;import org.eclipse.ui.IWorkbenchPart;import org.isistan.flabot.coremodel.ResponsibilityNode;import org.isistan.flabot.edit.ucmeditor.editparts.ResponsibilityNodeEditPart;import org.isistan.flabot.engine.failurelocatedaction.FailureLocatedAction;import org.isistan.flabot.engine.failurelocatedaction.FailureLocatedActionLoader;import org.isistan.flabot.engine.messages.Messages;import org.isistan.flabot.util.problems.MessageAccumulator;import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;/**
 * @author $Author: dacostae $
 *
 */
public class TreatFailureAction extends SelectionAction {

	public static final String
		TREAT_FAILURE_ACTION = "TREAT_FAILURE_ACTION";   //$NON-NLS-1$

	public TreatFailureAction(IWorkbenchPart part) {
		super(part);
		setId(TREAT_FAILURE_ACTION);
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.TreatFailureAction.text")); //$NON-NLS-1$
	}

	@Override	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	private boolean canPerformAction() {		
		List parts = getSelectedObjects();		
		for (Object part : parts) {
			if(part instanceof ResponsibilityNodeEditPart) {
				return true;
			}
		}
		return false;
	}


	private ResponsibilityNode[] getResponsibilityNodes() {
		List parts = getSelectedObjects();
		List<ResponsibilityNode> responsibilityNodes=new LinkedList<ResponsibilityNode>();
		for (Object part : parts) {
			if(part instanceof ResponsibilityNodeEditPart) {
				ResponsibilityNodeEditPart responsibilityNodeEditPart=
					(ResponsibilityNodeEditPart)part;
				ResponsibilityNode responsibilityNode=
					(ResponsibilityNode)responsibilityNodeEditPart.getSemanticModel();
				responsibilityNodes.add(responsibilityNode);
			}
		}
		return responsibilityNodes.toArray(new ResponsibilityNode[responsibilityNodes.size()]);
	}

	@Override	public void run() {
		ResponsibilityNode[] responsibilityNodes = getResponsibilityNodes();
		MessageAccumulator messageAccumulator=new LoggerMessageAccumulator();
		FailureLocatedAction[] actions=			FailureLocatedActionLoader.getUserSelectedFailureLocatedActions(Display.getCurrent().getActiveShell(), messageAccumulator); 
		for (FailureLocatedAction action : actions) {			for (ResponsibilityNode responsibilityNode : responsibilityNodes) {
				action.execute(responsibilityNode, responsibilityNode.getRole(), messageAccumulator);
			}		}
	}
}