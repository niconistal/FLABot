/**
 * $Id: EditLineVisualizationAction.java,v 1.4 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.actions;

import java.util.List;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPart;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.edit.editor.CommandExecutor;
import org.isistan.flabot.edit.editor.dialogs.StandardEditionDialog;
import org.isistan.flabot.edit.editor.dialogs.editionitem.EditVisualizationTabItem;
import org.isistan.flabot.edit.editor.figures.LineConnection;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.editparts.PathNodeEditPart;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.tab.EditionTabItem;

/**
 * @author $Author: franco $
 *
 */
public class EditLineVisualizationAction extends SelectionAction
{
	public static final String
		EDIT_LINE_VISUALIZATION = "Edit.Line.Visualization";  //$NON-NLS-1$
	
	private AbstractGraphicalEditPart part;
	
	public EditLineVisualizationAction(IWorkbenchPart part) {
		super(part);
		
		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditLineVisualizationAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditLineVisualizationAction.toolTipText")); //$NON-NLS-1$
		setId(EDIT_LINE_VISUALIZATION);
		setEnabled(false);			
	}

	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	private boolean canPerformAction() {	
		List selection = getSelectedObjects();
		if (selection == null ||
				selection.isEmpty()) return false;
			
		if (selection.size() > 1) return false;
		
		Object o = selection.get(0);
		if (o instanceof PathNodeEditPart) {
			PathNodeEditPart part = (PathNodeEditPart)o;
			VisualModel visual = (VisualModel) part.getModel();
			if (((PathNode)visual.getSemanticModel()).isStart())
				return true;
		}
	
		return false;
	}
	
	protected Command getCommand() {
		part = (AbstractGraphicalEditPart)getSelectedObjects().get(0);		
		
		EditVisualizationTabItem tabItem = new EditVisualizationTabItem(
				 EditVisualizationTabItem.FOREGROUND_COLOR_PROPERTY |
				 EditVisualizationTabItem.LINE_STYLE_PROPERTY |
				 EditVisualizationTabItem.LINE_WIDTH_PROPERTY |
				 EditVisualizationTabItem.IS_PATH);
		
		
		StandardEditionDialog<GraphicalEditPart> dialog =
			new StandardEditionDialog<GraphicalEditPart>(
					Display.getCurrent().getActiveShell(),
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditLineVisualizationAction.dialogName"), //$NON-NLS-1$
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.EditLineVisualizationAction.dialogDescription"), //$NON-NLS-1$
					new EditionTabItem[] {
						tabItem});
		
		NodeVisualModel visual = (NodeVisualModel) part.getModel();
		LineConnection line = new LineConnection(
				visual.getLineStyle(), 
				visual.getLineWidth(), 
				Util.getSWRColor(Display.getCurrent(), visual.getForegroundColor())
				);
		line.setForegroundColor(
				Util.getSWRColor(Display.getCurrent(), visual.getForegroundColor())
				);
		tabItem.setFigure(line);		
		return dialog.open(part);
	}
	
	public void run() {
		CommandExecutor commandExecutor = (CommandExecutor)getWorkbenchPart().getAdapter(CommandExecutor.class);
		commandExecutor.executeCommand(getCommand(), false);
		part.getParent().refresh();
	}		
}