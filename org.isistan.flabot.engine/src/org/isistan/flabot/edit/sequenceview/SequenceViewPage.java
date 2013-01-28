/**
 * $Id: SequenceViewPage.java,v 1.13 2006/03/29 20:21:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.sequenceview;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.editparts.FreeformGraphicalRootEditPart;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.isistan.flabot.edit.sequenceview.editparts.SequenceViewFactory;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;

/**
 * The SequenceViewPage represents a sequence for an opened FlabotFileModel. 
 * It shows the route followed by the Fault Locator Engine.
 * 
 * @author $Author: franco $
 *
 */
public class SequenceViewPage implements IPageBookViewPage {
	
	private ExecutionInfoManager manager;	
	
	private GraphicalViewer viewer;
	
	private IPageSite site;
	
	private boolean isBarUp = false;
	
	SashForm sashForm;
	
	/**
     * Instantiates the SequenceViewPage with and an ExecutionInfoManager.
     */
	public SequenceViewPage(ExecutionInfoManager manager) {
		this.manager = manager;
	}
	
	protected GraphicalViewer getViewer() {
		if (viewer == null)
			viewer = new ScrollingGraphicalViewer();
		return viewer;
	}
	
	/**
     * Creates the SWT control for this page under the given parent 
     * control. Creates a viewer for the Sequence View, with a SequenceViewFactory.
     */
	public void createControl(Composite parent) {
		sashForm = new SashForm(parent, SWT.VERTICAL);	
		sashForm.setBackground(ColorConstants.white);		
		
		
		getViewer().createControl(sashForm);		 
		getViewer().getControl().setBackground(ColorConstants.white);
		
		getViewer().setEditPartFactory(new SequenceViewFactory());
		
		FreeformGraphicalRootEditPart rootEditPart = new FreeformGraphicalRootEditPart();
		getViewer().setRootEditPart(rootEditPart);
		getViewer().setContents(manager);
		
		createControlDependeciesBar(sashForm);
		
		sashForm.addControlListener( new ControlListener() {
			/**
			 * Sent when the location (x, y) of a control changes relative
			 * to its parent (or relative to the display, for <code>Shell</code>s).
			 *
			 * @param e an event containing information about the move
			 */
			public void controlMoved(ControlEvent e) {
				updateDependencyBarState(false);
			}

			/**
			 * Sent when the size (width, height) of a control changes.
			 *
			 * @param e an event containing information about the resize
			 */
			public void controlResized(ControlEvent e) {
				updateDependencyBarState(false);
			}
			
		});
	}
	
	protected Control createControlDependeciesBar(Composite parent) {
		ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(parent);		 
		viewer.getControl().setBackground(ColorConstants.red);
		
		Composite composite = (Composite)viewer.getControl();
		composite.setBackground(ColorConstants.white);
		
		GridLayout layout = new GridLayout(8, false);
		layout.horizontalSpacing = 5;
		layout.verticalSpacing = 0;	
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		composite.setLayout(layout);		
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));
		
		
		Composite c = new Composite(composite, SWT.BORDER | SWT.BEGINNING);
		
		layout = new GridLayout(2, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		c.setLayout(layout);		
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 8;
		gd.heightHint=25;
		c.setLayoutData(gd);								
		
		Button button = new Button(c, SWT.ARROW);
		button.setAlignment(SWT.UP);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 25;
		gd.heightHint = 25;
		button.setLayoutData(gd);		
		button.addSelectionListener(new SelectionAdapter() {			
			@Override
			public void widgetSelected(SelectionEvent e) {				
				updateDependencyBarState(true);
				
				Button b = (Button)e.getSource();
				if (isBarUp)
					b.setAlignment(SWT.DOWN);
				else
					b.setAlignment(SWT.UP);
			}
		});	
		
		Label label = new Label(c, SWT.NONE);
		label.setText(Messages.getString("org.isistan.flabot.edit.sequenceview.SequenceViewPage.dependencies")); //$NON-NLS-1$
		gd = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		label.setLayoutData(gd);		
		
		addIconImage(composite, ImageDescriptor.createFromFile(EnginePlugin.class, "icons/arrow_previous.gif").createImage()); 	     //$NON-NLS-1$
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.sequenceview.SequenceViewPage.previous")); //$NON-NLS-1$
		
		addIconImage(composite, ImageDescriptor.createFromFile(EnginePlugin.class, "icons/arrow_constraint.gif").createImage()); 	     //$NON-NLS-1$
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.sequenceview.SequenceViewPage.constraint")); //$NON-NLS-1$
		
		addIconImage(composite, ImageDescriptor.createFromFile(EnginePlugin.class, "icons/arrow_mapping.gif").createImage()); //$NON-NLS-1$
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.sequenceview.SequenceViewPage.mapping")); //$NON-NLS-1$
		
		addIconImage(composite, ImageDescriptor.createFromFile(EnginePlugin.class, "icons/arrow_precondition.gif").createImage()); //$NON-NLS-1$
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.sequenceview.SequenceViewPage.precondition"));		 //$NON-NLS-1$
		
		return composite;
	}

	private int calculatePorcentaje(int nro) {
		int height = sashForm.getClientArea().height;
		if (height == 0) height = 100;
		return (100*nro) / height;
	}
	
	private void addLabel(Composite composite, String name) {
		Label label = new Label(composite, SWT.NONE);
		label.setText(name);
		GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING |
 				GridData.HORIZONTAL_ALIGN_BEGINNING);		
		gd.widthHint = 70;
		label.setLayoutData(gd);		
		label.setBackground(ColorConstants.white);
	}
	
	private void addIconImage(Composite composite, Image image) {
		Label label = new Label(composite, SWT.NONE);
		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
		label.setLayoutData(gd);
		label.setBackground(ColorConstants.white);
		label.setImage(image);
	}
	 
	private void updateDependencyBarState(boolean changeState) {
		if (changeState)
			isBarUp = !isBarUp;
		
		int p = 0;
		if (isBarUp)
			p = calculatePorcentaje(50);
		else
			p = calculatePorcentaje(30);					
		
		if (p<0 || p>100) p =0;
		sashForm.setWeights(new int[]{100-p,p});		
	}
	
	/**
     * Disposes of this page.
     */
	public void dispose() {
		//Do nothing
	}
	
	 /**
     * Returns the SWT control for this page.
     *
     * @return the SWT control for this page, or <code>null</code> if this
     *   page does not have a control
     */
	public Control getControl() {
		return sashForm;
	} 

	public void setActionBars(IActionBars actionBars) {
		//Do nothing
	} 
	
	 /**
     * Asks this page to take focus within its pagebook view.
     */
	public void setFocus() {
		sashForm.setFocus();
	}
	
	public IPageSite getSite(){
		return site;
	} 	
 
	public void init(IPageSite site) {
		this.site = site;
	}  	      
}