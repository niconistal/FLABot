/**
 * $Id: EnginePerspectiveFactory.java,v 1.3 2006/03/22 22:13:05 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.engine;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

/**
 * Eclipse perspective that can be used when executing the Fault Locator Engine.
 * 
 * @author usuario
 *
 */
public class EnginePerspectiveFactory implements IPerspectiveFactory {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IPerspectiveFactory#createInitialLayout(org.eclipse.ui.IPageLayout)
	 */
	public void createInitialLayout(IPageLayout layout) {		
		layout.createPlaceholderFolder("org.isistan.flabot.engine.perspective.topPlaceholderFolder", IPageLayout.TOP, 0.55f, IPageLayout.ID_EDITOR_AREA); //$NON-NLS-1$
		
		IFolderLayout mapView = layout.createFolder("org.isistan.flabot.engine.perspective.topPlaceholderFolder.left", IPageLayout.LEFT, 0.50f, "org.isistan.flabot.engine.perspective.topPlaceholderFolder"); //$NON-NLS-1$ //$NON-NLS-2$
		IFolderLayout sequenceView = layout.createFolder("org.isistan.flabot.engine.perspective.topPlaceholderFolder.right", IPageLayout.RIGHT, 0.50f, "org.isistan.flabot.engine.perspective.topPlaceholderFolder"); //$NON-NLS-1$ //$NON-NLS-2$
		mapView.addView("org.isistan.flabot.engine.mapview"); //$NON-NLS-1$
		sequenceView.addView("org.isistan.flabot.engine.sequenceview"); //$NON-NLS-1$
		
		layout.addView("org.isistan.flabot.engine.controlview", IPageLayout.RIGHT, 0.50f, IPageLayout.ID_EDITOR_AREA); //$NON-NLS-1$
		
		layout.addShowViewShortcut("org.isistan.flabot.engine.controlview"); //$NON-NLS-1$
		layout.addShowViewShortcut("org.isistan.flabot.engine.mapview"); //$NON-NLS-1$
		layout.addShowViewShortcut("org.isistan.flabot.engine.sequenceview"); //$NON-NLS-1$
		layout.addShowViewShortcut("org.eclipse.pde.runtime.LogView"); //$NON-NLS-1$
		layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);

		layout.addPerspectiveShortcut("org.isistan.flabot.editor.perspective"); //$NON-NLS-1$
		layout.addPerspectiveShortcut("org.eclipse.jdt.ui.JavaPerspective"); //$NON-NLS-1$
		layout.addPerspectiveShortcut("org.eclipse.debug.ui.DebugPerspective"); //$NON-NLS-1$
	}

}
