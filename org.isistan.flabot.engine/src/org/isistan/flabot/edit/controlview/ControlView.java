/**
 * $Id: ControlView.java,v 1.15 2006/03/22 03:28:54 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.controlview;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuCreator;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.part.MessagePage;
import org.eclipse.ui.part.PageBook;
import org.eclipse.ui.part.PageBookView;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.InterfacePluginEngine;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.executionmodel.ExecutionStep;

/**
 * @author $Author: franco $
 *
 */
public class ControlView extends PageBookView {
	
	FlabotMultiPageEditor actualEditor;	  
    
    /**
     * Destroys a page in the pagebook for a particular part.
     */
    @Override
	protected void doDestroyPage(IWorkbenchPart part, PageRec rec) {
    	ControlViewPage page = (ControlViewPage) rec.page;
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
    	ControlViewPage page = new ControlViewPage(actualEditor.getModel(), InterfacePluginEngine.getExecutionInfoManager(actualEditor));
    	initPage(page);    	
    	page.createControl(getPageBook());
    	createActions(page, page.getSite().getActionBars().getToolBarManager());
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
        page.setMessage(Messages.getString("org.isistan.flabot.engine.SequenceView.controlViewNotAvailable")); //$NON-NLS-1$ 
        page.getControl().setBackground(ColorConstants.white);
        return page;
    }
    
    public void createActions(final ControlViewPage page, IToolBarManager manager) {
    	Action  actionRR = new Action(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionRewind"), IAction.AS_DROP_DOWN_MENU) {         //$NON-NLS-1$
    		@Override
			public void run() { 
    			page.rrStep();
    		}
        };
        actionRR.setMenuCreator(new MenuCreator(page));
        actionRR.setToolTipText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionRewindTooltipText")); //$NON-NLS-1$
        actionRR.setImageDescriptor(ImageDescriptor.createFromFile(EnginePlugin.class, "icons/rr.gif")); //$NON-NLS-1$
                
        final Action  actionFF = new Action(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionFF")) {         //$NON-NLS-1$
    		@Override
			public void run() { 
    			page.ffStep();
    		}
        };
        actionFF.setToolTipText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionFFTooltipText")); //$NON-NLS-1$
        actionFF.setEnabled(false);
        actionFF.setImageDescriptor(ImageDescriptor.createFromFile(EnginePlugin.class, "icons/ff.gif"));      //$NON-NLS-1$
        
        final Action  actionPause = new Action(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionPause"), IAction.AS_CHECK_BOX) {         //$NON-NLS-1$
    		@Override
			public void run() { 
    			if (isChecked()) {
    				actionFF.setEnabled(true);
    				setToolTipText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionPauseTooltipTextFFEnabled")); //$NON-NLS-1$
    			} else {
    				actionFF.setEnabled(false);
    				setToolTipText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionPauseTooltipTextFFDisabled")); //$NON-NLS-1$
    			}
    			page.pauseStep(isChecked());
    		}
        };
        actionPause.setToolTipText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionPauseTooltipText")); //$NON-NLS-1$
        actionPause.setImageDescriptor(ImageDescriptor.createFromFile(EnginePlugin.class, "icons/pause.gif"));      //$NON-NLS-1$
        
        final Action  actionPlay = new Action(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionPlay")) {         //$NON-NLS-1$
    		@Override
			public void run() { 
    			actionPause.setChecked(false);
    			actionFF.setEnabled(false);
    			page.playStep();
    		}
        };
        actionPlay.setToolTipText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionPlayTooltipText")); //$NON-NLS-1$
        actionPlay.setImageDescriptor(ImageDescriptor.createFromFile(EnginePlugin.class, "icons/play.gif")); //$NON-NLS-1$
        
        Action  actionStop = new Action(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionStop")) {         //$NON-NLS-1$
    		@Override
			public void run() {
    			actionPause.setChecked(false);
    			//actionPause.setEnabled(false);
    			actionFF.setEnabled(false);
    			page.stopStep();
    		}
        };
        actionStop.setToolTipText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.actionStopTooltipText")); //$NON-NLS-1$
        actionStop.setImageDescriptor(ImageDescriptor.createFromFile(EnginePlugin.class, "icons/stop.gif")); //$NON-NLS-1$
        
        //Adds the action buttons to the tool bar manager
        manager.add(new Separator());
        manager.add(actionRR);
        manager.add(new Separator());
        manager.add(actionPlay);        
        manager.add(new Separator());
        manager.add(actionPause);
        manager.add(new Separator());
        manager.add(actionFF);
        manager.add(new Separator());
        manager.add(actionStop);
        manager.add(new Separator());
    }
       
    class MenuCreator implements IMenuCreator {
    	
    	ControlViewPage controlViewPage;
    	
    	Menu activeMenu;
    	
    	public MenuCreator(ControlViewPage controlViewPage) {
    		this.controlViewPage = controlViewPage;
    	}
    	
    	/**
         * Disposes the menu returned by <code>getMenu</code>. Does nothing
         * if there is no menu.  This method will be executed only when the
         * parent of the menu is disposed.  
         */
        public void dispose() {
        	if (activeMenu != null)
        		activeMenu.dispose();
        }

        /**
         * Returns the SWT menu, created as a pop up menu parented by the
         * given control.  In most cases, this menu can be created once, cached and reused
         * when the pop-up/drop-down action occurs.  If the menu must be dynamically
         * created (i.e., each time it is popped up or dropped down), the old menu
         * should be disposed of before replacing it with the new menu.
         *
         * @param parent the parent control
         * @return the menu, or <code>null</code> if the menu could not
         *  be created
         */
        public Menu getMenu(Control parent) {
        	dispose();        	
        	activeMenu = createMenu(parent, controlViewPage.getActiveSteps());
        	return activeMenu;
        }
        
        private Menu createMenu(Control parent, List<ExecutionStep> steps) {
        	Menu menu = new Menu(parent);
        	for(Iterator iter=steps.iterator(); iter.hasNext();) {
        		final ExecutionStep step = (ExecutionStep) iter.next();
        		MenuItem item = new MenuItem(menu, SWT.NONE);
        		item.setText(Messages.getString("org.isistan.flabot.edit.controlview.ControlView.step") + step.getSource().getName() + " -> " + step.getTarget().getName());  //$NON-NLS-1$ //$NON-NLS-2$
        		item.addListener(SWT.Selection, new Listener() {
        			public void handleEvent(Event e) {
        				controlViewPage.rrToStep(step);	
        			}
        		});
        	}
        	return menu;
        }

        /**
         * Returns an SWT menu created as a drop down menu parented by the
         * given menu.  In most cases, this menu can be created once, cached and reused
         * when the pop-up/drop-down action occurs.  If the menu must be dynamically
         * created (i.e., each time it is popped up or dropped down), the old menu
         * should be disposed of before replacing it with the new menu.
         *
         * @param parent the parent menu
         * @return the menu, or <code>null</code> if the menu could not
         *  be created
         */
        public Menu getMenu(Menu parent) {        	
        	return null;
        }
    	
    }
}