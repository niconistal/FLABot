/**

import java.util.List;
 * This action cuts elements from the component diagram
 * @author $Author: franco $
 *
 */
public class CutAction extends CopyAction {

	/**
	 * Creates a new CutAction in the given workbench part
	 * @param part
	 */
	public CutAction(IWorkbenchPart part) {
		super(part);
		
		setId(ActionFactory.CUT.getId());
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.CutAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.CutAction.toolTipText")); //$NON-NLS-1$
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages(); 
		setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_UP));
		setDisabledImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_CUT_DISABLED));
		setEnabled(false);							
	}
	
	/**
	 * Creates a command that performs the cutting
	 * @return The created command
	 */
	private Command getCommand() {
		List selection = getSelectedObjects();
				
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.editor.actions.CutAction.text")); //$NON-NLS-1$
		for (int i=0; i<selection.size(); i++) {
			EditPart selectionEditPart = (EditPart) selection.get(i);
			GroupRequest r = new GroupRequest();
			r.setEditParts(selectionEditPart);
			r.setType(RequestConstants.REQ_DELETE);
			commands.add(selectionEditPart.getCommand(r));
		}
		return commands;	
	}
	
	/**
	 * Executes the cutting (using a command)
	 */
	@Override
	public void run() {
		Clipboard.getDefault().setContents(getCopyCommandsList());
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
	}
}