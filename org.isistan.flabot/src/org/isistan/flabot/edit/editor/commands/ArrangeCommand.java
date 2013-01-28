/** * $Id: ArrangeCommand.java,v 1.11 2006/03/21 01:51:56 franco Exp $ * $Author: franco $ */package org.isistan.flabot.edit.editor.commands;

import org.eclipse.emf.common.util.BasicEList;import org.eclipse.emf.common.util.EList;import org.eclipse.gef.commands.Command;import org.isistan.flabot.edit.editormodel.VisualModel;import org.isistan.flabot.messages.Messages;/** * ArrangeCommand * -	Arrange VisualModel to a  visual position. * -	The visual model is moved in the children's list of its diagram, according to the arrange side. *  * BRING_TO_FRONT * BRING_FORWARD * SEND_BACKWARD * SEND_TO_BACK *   * @author $Author: franco $ * */public class ArrangeCommand extends Command {
	
	public final static String BRING_TO_FRONT = "BRING_TO_FRONT"; //$NON-NLS-1$
	public final static String BRING_FORWARD = "BRING_FORWARD"; //$NON-NLS-1$
	public final static String SEND_BACKWARD = "SEND_BACKWARD"; //$NON-NLS-1$
	public final static String SEND_TO_BACK = "SEND_TO_BACK"; //$NON-NLS-1$
	
	private VisualModel nodeVisual;
	private EList oldList = new BasicEList();
		
	private String arrange;
		/**	 * Instantiates a command that can arrage a visual model.	 * @param visualModel the visualModel to arrange	 * @param arrange the arrange side  	 */
	public ArrangeCommand(VisualModel visualModel, String arrange) {
		this.nodeVisual = visualModel;
		this.arrange = arrange;
		copyList(visualModel.getDiagram().getChildren(),(EList)oldList);
		this.setLabel(Messages.getString("org.isistan.flabot.edit.editor.commands-ArrangeCommand.label")); //$NON-NLS-1$
		
	}
	
	private void copyList(EList children, EList list2) {
		for (int i=0; i<children.size();i++){
			list2.add(children.get(i));
		}		
	}
		/**	 * Verifies that the command can be executed.	 * The connection must not be duplicated (source -> target connection exists already) 	 * @return <code>true</code> if the command can be executed		 */
	public boolean canExecute() {
		return (nodeVisual != null);
	}
		/**	 * Executes the Command. This method should not be called if the Command is not	 * executable.	 * 	 * @see redo()	 */
	public void execute() {
		redo();
	}
		/**	 * Sends the visual model Backward.	 * Puts the visual model one index before its current position in the children's list of the its diagram.	 */
	protected void doSendBackward() {
		EList list = nodeVisual.getDiagram().getChildren();
		int index = list.indexOf(nodeVisual);
		list.remove(nodeVisual);
		if (index > 0)
			list.add(index-1,nodeVisual);
		else
			list.add(index,nodeVisual);
	}
		/**	 * Brings to front the visual model.	 * Puts the visual model at the end of the children's list of the its diagram.	 */
	protected void doBringToFront() {
		EList list = nodeVisual.getDiagram().getChildren();
		list.remove(nodeVisual);
		list.add(nodeVisual);
	}
		/**	 * Brings to back the visual model.	 * Puts the visual model at the beginningn of the children's list of the its diagram.	 */
	protected void doBringToBack() {
		EList list = nodeVisual.getDiagram().getChildren();
		list.remove(nodeVisual);
		list.add(0,nodeVisual);
	}
		/**	 * Sends the visual model Forward.	 * Puts the visual model one index after its current position in the children's list of the its diagram.	 */
	protected void doSendForward() {
		EList list = nodeVisual.getDiagram().getChildren();
		int index = list.indexOf(nodeVisual);
		list.remove(nodeVisual);	
		if (index < list.size())
			list.add(index+1,nodeVisual);
		else
			list.add(index,nodeVisual);	
	}
		/**	 * Arrages the visual model acordding to the arrange side.	 */
	public void redo() {
		if (BRING_FORWARD.equals(arrange))
			doSendForward();
		else if (BRING_TO_FRONT.equals(arrange))
			doBringToFront();
		else if (SEND_TO_BACK.equals(arrange))
			doBringToBack();
		else if (SEND_BACKWARD.equals(arrange))
			doSendBackward();
	}
		/**	 * Restores the old position of the visual model.	 */
	public void undo() {
		EList list = nodeVisual.getDiagram().getChildren();
		list.clear();
		copyList((EList)oldList,list);
	}	
}