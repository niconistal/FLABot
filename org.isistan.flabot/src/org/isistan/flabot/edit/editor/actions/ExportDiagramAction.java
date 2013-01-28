/**
 * $Id: ExportDiagramAction.java,v 1.6 2006/03/21 02:34:07 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.editor.actions;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.actions.SelectionAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorPart;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.ImageSaveUtil;

/**
 * This action is used to export diagram to bitmap.
 * 
 * @author $Author: franco $
 *
 */
public class ExportDiagramAction extends SelectionAction {

	/**
	 * Action id
	 */
	public static final String 
		EXPORT_DIAGRAM = "Export.Diagram";  //$NON-NLS-1$
	
	private GraphicalViewer viewer;
	
	private IEditorPart editorPart;

	/**
	 * Creates a new ExportDiagramAction in the given viewer
	 * @param viewer
	 * @param editorPart the editor that contains the diagram to export
	 */
	public ExportDiagramAction(GraphicalViewer viewer,
			IEditorPart editorPart) {
		super(editorPart);
		
		this.viewer = viewer;
		this.editorPart = editorPart;
		
		setText(Messages.getString("org.isistan.flabot.edit.editor.actions.ExportDiagramAction.text")); //$NON-NLS-1$
		setToolTipText(Messages.getString("org.isistan.flabot.edit.editor.actions.ExportDiagramAction.toolTipText")); //$NON-NLS-1$
		setId(EXPORT_DIAGRAM);
		setImageDescriptor(ImageDescriptor.createFromFile(FlabotPlugin.class, "icons/export.gif")); //$NON-NLS-1$
		setEnabled(false);
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true
	 */
	@Override
	protected boolean calculateEnabled() {
		return canPerformAction();
	}

	/**
	 * Determines whether the action should be enabled or not.
	 * @return true
	 */
	private boolean canPerformAction() {	
		return true;
	}
	
	/**
	 * Exports the diagram that contains the activeEditor.
	 * ImageSaveUtil is used to export.
	 * 
	 * @see ImageSaveUtil.save()
	 */
	public void run() {
		ImageSaveUtil.save(editorPart, viewer);
	}
}