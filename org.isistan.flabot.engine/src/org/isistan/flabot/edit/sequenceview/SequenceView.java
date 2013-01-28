/**
 * $Id: SequenceView.java,v 1.9 2006/03/22 03:28:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.sequenceview;

import org.eclipse.draw2d.ColorConstants;
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
 * The Sequence View shows the route followed by the Fault Locator Engine.
 * The arrows represents the interactions between two components (roles) done by a responsibility. 
 * 
 *  @author $Author: franco $
 *
 */
public class SequenceView extends PageBookView {

	FlabotMultiPageEditor actualEditor;	  
    
    /**
     * Destroys a page in the pagebook for a particular part.
     */
    @Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec rec) {
    	SequenceViewPage page = (SequenceViewPage) rec.page;
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
    	SequenceViewPage page = new SequenceViewPage(InterfacePluginEngine.getExecutionInfoManager(actualEditor));
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
        page.setMessage(Messages.getString("org.isistan.flabot.engine.SequenceView.sequenceViewNotAvailable")); //$NON-NLS-1$ 
        page.getControl().setBackground(ColorConstants.white);
        return page;
    }
}