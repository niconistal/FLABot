/**
 * $Id: EditorPerspectiveFactory.java,v 1.4 2006/03/22 22:13:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Eclipse perspective that can be used when editing the component and ucm diagrams. 
 * 
 * @author $Author: franco $
 *
 */
public class EditorPerspectiveFactory implements IPerspectiveFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {				
		IFolderLayout left = layout.createFolder("org.isistan.flabot.editor.perspective.left", IPageLayout.LEFT, 0.20f, IPageLayout.ID_EDITOR_AREA); //$NON-NLS-1$
		left.addView(IPageLayout.ID_RES_NAV);
		
		IFolderLayout bottom = layout.createFolder("org.isistan.flabot.editor.perspective.bottom", IPageLayout.BOTTOM, 0.80f, IPageLayout.ID_EDITOR_AREA); //$NON-NLS-1$
		bottom.addView(IPageLayout.ID_PROP_SHEET);		
		
		IFolderLayout right = layout.createFolder("org.isistan.flabot.editor.perspective.right", IPageLayout.RIGHT, 0.80f, IPageLayout.ID_EDITOR_AREA); //$NON-NLS-1$
		right.addView(IPageLayout.ID_OUTLINE);
		
		layout.addShowViewShortcut("org.isistan.flabot.engine.controlview"); //$NON-NLS-1$
		layout.addShowViewShortcut("org.isistan.flabot.engine.mapview"); //$NON-NLS-1$
		layout.addShowViewShortcut("org.isistan.flabot.engine.sequenceview"); //$NON-NLS-1$
		layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView"); //$NON-NLS-1$
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
		layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
		layout.addShowViewShortcut(IPageLayout.ID_RES_NAV);
		
		layout.addPerspectiveShortcut("org.isistan.flabot.engine.perspective"); //$NON-NLS-1$
		layout.addPerspectiveShortcut("org.eclipse.jdt.ui.JavaPerspective"); //$NON-NLS-1$
		layout.addPerspectiveShortcut("org.eclipse.debug.ui.DebugPerspective"); //$NON-NLS-1$
	}
}
