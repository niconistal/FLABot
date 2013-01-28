/**

import java.util.LinkedList;
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

	@Override
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

	@Override
		ResponsibilityNode[] responsibilityNodes = getResponsibilityNodes();
		MessageAccumulator messageAccumulator=new LoggerMessageAccumulator();
		FailureLocatedAction[] actions=
		for (FailureLocatedAction action : actions) {
				action.execute(responsibilityNode, responsibilityNode.getRole(), messageAccumulator);
			}
	}
}