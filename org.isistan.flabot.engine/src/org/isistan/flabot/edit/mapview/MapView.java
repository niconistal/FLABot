/**
 * $Id: MapView.java,v 1.10 2006/03/29 19:27:28 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.commands.CommandStack;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.engine.InterfacePluginEngine;
import org.isistan.flabot.engine.messages.Messages;

/**
 * The Map View is used to show the route followed by the Fault Locator Engine.
 * This route is shown uding the same UCM diagrams done by the user, but the path followed by the engine is added to it.
 * Also the responsibilities have the color of its state. 
 * 
 * @author $Author: franco $
 *
 */
public class MapView extends PageBookView {

	FlabotMultiPageEditor actualEditor;
	CommandStack commandStack;
       
    /**
     * Destroys a page in the pagebook for a particular part.
     */
    @Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec rec) {
    	MapViewPage page = (MapViewPage) rec.page;
    	page.dispose();
    	rec.dispose();
    }
    
    /**
     * Creates and returns a new SequenceViewPage for the particular FlabotFileModel.
     * This page will be made visible whenever the FlabotMultiPageEditor corresponding to this model is active.
     * 
     * @return the new SequenceViewPage
     */
    @Override
	protected PageRec doCreatePage(IWorkbenchPart part) {
    	MapViewPage page = new MapViewPage(actualEditor.getModel(), InterfacePluginEngine.getExecutionInfoManager(actualEditor), actualEditor);
    	initPage(page);
        page.createControl(getPageBook());
        return new PageRec(part, page);
    }
        
    /**
     * The Sequence View is available only when a FlabotMultiPageEditor is open.
     * In the case that the actual FlabotFileModel is not the equal to the selected FlabotMultiPageEditor, the SequenceView must be updated.
     * 
     * @return true if the Sequence View must be updated
     */
    @Override
	protected boolean isImportant(IWorkbenchPart part) {
    	if (part instanceof FlabotMultiPageEditor) {
    		FlabotMultiPageEditor editor = (FlabotMultiPageEditor) part;
        	commandStack = editor.getCommandStack();
        	if (editor != actualEditor) {
        		actualEditor = editor;
        		return true;
        	}
        }    	    	
    	return false;
    }
    
    /**
     * Returns the active, important workbench part for this view. 
     * 
     * @return the active important part, or <code>null</code> if none
     */
    @Override
	protected IWorkbenchPart getBootstrapPart() {
        IWorkbenchPage page = getSite().getPage();
        if (page != null) {
            //bootstrapSelection = page.getSelection();
            return page.getActivePart();
        } 
        return null;
    }
    
    /**
     * Creates and returns the default page for this view.
     * When the Sequence View is not available.
     * 
     * @return the default page
     */
    @Override
	protected IPage createDefaultPage(PageBook book) {
    	MessagePage page = new MessagePage();
        initPage(page);
        page.createControl(book);
        page.setMessage(Messages.getString("org.isistan.flabot.engine.MapView.mapViewNotAvailable")); //$NON-NLS-1$
        page.getControl().setBackground(ColorConstants.white);
        return page;
    }
}