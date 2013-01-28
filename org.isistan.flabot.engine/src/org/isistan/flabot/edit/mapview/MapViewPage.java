/**
 * $Id: MapViewPage.java,v 1.47 2006/04/04 03:37:06 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.mapview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.LightweightSystem;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditDomain;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.jface.util.Assert;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.internal.Workbench;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualDiagramJump;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.mapview.editparts.MapViewFactory;
import org.isistan.flabot.edit.mapview.editparts.ScalableFreeformMapViewRootEditPart;
import org.isistan.flabot.edit.mapview.editparts.StateColorFactory;
import org.isistan.flabot.edit.multipage.FlabotMultiPageEditor;
import org.isistan.flabot.edit.ucmeditor.editparts.DependencyToColorFactory;
import org.isistan.flabot.edit.ucmeditor.editparts.DependencyToLineStyleFactory;
import org.isistan.flabot.edit.ucmeditor.figures.ResponsibilityNodeFigure;
import org.isistan.flabot.edit.ucmeditor.figures.VisualDiagramJumpFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.edit.ucmmodel.UcmmodelFactory;
import org.isistan.flabot.engine.executionstate.ExecutionState;
import org.isistan.flabot.engine.messages.Messages;
import org.isistan.flabot.executionmodel.EvaluationStep;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * The MapViewPage represents a sequence for an opened FlabotFileModel. 
 * It shows the route followed by the Fault Locator Engine.
 * 
 * @author $Author: franco $
 *
 */
public class MapViewPage implements IPageBookViewPage, Adapter {	
		
	private SashForm sashForm; 
	
	private CTabFolder container;
	
	private FlabotFileModel model;
	
	private ExecutionInfoManager manager;
	
	private IPageSite site;
	
	private Notifier target;
	
	private List<Diagram> diagramTabs = new ArrayList<Diagram>();
		
	private Map<String, Diagram> mapsToDiagrams = new HashMap<String, Diagram>();;
	
	private Map<Diagram, Map<SimplePathNode, CompoundVisualSimplePathNode>> diagramsToMapNodes = new HashMap<Diagram, Map<SimplePathNode, CompoundVisualSimplePathNode>>();
	
	private boolean isBarUp = false;
	
	private List<ExecutionStep> steps = new ArrayList<ExecutionStep>();
			
	private Map<String, String> nodesIDToFamilyID = new HashMap<String, String>();	

	private EditDomain editDomain;
	
	/**
	 * Instantiates the MapViewPage with and a FlabotFileModel and an ExecutionInfoManager.
     */
	public MapViewPage(FlabotFileModel model, ExecutionInfoManager manager, FlabotMultiPageEditor editor) {
		this.manager = manager;
		this.model = model;
		editDomain = new EditDomain();
		editDomain.setCommandStack( new NoExecutionFlabotCommandStack(editor));
		
		activate();
    }
		
	private org.eclipse.draw2d.geometry.Point getMinimun(VisualModel parent, NodeVisualModel child, int separationoffset, int paralleloffset) {		
		if (parent == null) 
			return new org.eclipse.draw2d.geometry.Point(child.getLocation().getX() + separationoffset, child.getLocation().getY() + paralleloffset);
			
		//horizontal left or right		
		int minHLeft = child.getLocation().getX();
		int minHRight = parent.getSize().getWidth() - child.getLocation().getX();
		
		org.eclipse.draw2d.geometry.Point retH; int minH;
		if (minHLeft < minHRight) {
			retH = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() - separationoffset, parent.getLocation().getY() + child.getLocation().getY() + paralleloffset);
			minH = minHLeft; 
		} else {
			retH = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() + parent.getSize().getWidth() + separationoffset, parent.getLocation().getY() + child.getLocation().getY() + paralleloffset);
			minH = minHRight;
		}
		
		//vertical up or down		
		int minVUp = child.getLocation().getY();
		int minVDown = parent.getSize().getHeight() - child.getLocation().getY();
		
		org.eclipse.draw2d.geometry.Point retV; int minV;
		if (minVUp < minVDown) {
			retV = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() + child.getLocation().getX() + paralleloffset, parent.getLocation().getY() - separationoffset);
			minV = minVUp; 
		} else {
			retV = new org.eclipse.draw2d.geometry.Point(parent.getLocation().getX() + child.getLocation().getX() + paralleloffset, parent.getLocation().getY() + parent.getSize().getHeight() + separationoffset);
			minV = minVDown;
		}
		
		//the minimun
		if (minH < minV)
			return retH;
		else
			return retV;
	}
	
	/**
	 * Returns the Execution Info Manager
	 * 
	 * @return the execution info manager
	 */
	private ExecutionInfoManager getExecutionInfoManager() {
		return manager;
	}
		
	private void updateNoSteps() {
		Label l = new Label(container, SWT.NONE);
		l.setBackground(ColorConstants.white);
		l.setText(Messages.getString("org.isistan.flabot.engine.mapview.MapViewPage.noExecutionStepsMapView")); //$NON-NLS-1$
		createItem(getContainer().getItemCount(), l, ""); //$NON-NLS-1$
		setActivePage(0);
	}
	
    /**
     * @see IWorkbenchPart#createPartControl(Composite)
     */
	public void createControl(Composite parent) {										
		sashForm = new SashForm(parent, SWT.VERTICAL);
		
		container = createContainer(sashForm);		
		createControlStatesBar(sashForm);
		
		if (getExecutionInfoManager().getCurrentExecution() == null || getExecutionInfoManager().getCurrentExecution().getStepsCount() <= 0) {
			updateNoSteps();
		}
		
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
	
	private int calculatePercentage(int nro) {
		int height = sashForm.getClientArea().height;
		if (height == 0) height = 100;
		return (100*nro) / height;
	}
	
	private CTabFolder getContainer() {
		return container;
	}
	
	private void updateDependencyBarState(boolean changeState) {
		if (changeState)
			isBarUp = !isBarUp;
		
		int p = 0;
		if (isBarUp)
			p = calculatePercentage(100);
		else
			p = calculatePercentage(30);					
		
		if (p<0 || p>100) p =0;
		sashForm.setWeights(new int[]{100-p,p});		
	}
	
	/**
	 * Adds a new diagram to the Map View. The different diagrams are shown in a container with tabs. 
	 * An edit domain is created for the diagram and a new item is added to the container.
	 * 
	 * @param diagram the diagram to add
	 */
	public void addNewDiagram(Diagram diagram) {
		GraphicalViewer newViewer = createNewViewer(getContainer(), diagram);
		newViewer.setEditDomain(editDomain);
		createItem(getContainer().getItemCount(), newViewer.getControl(), diagram.getName());		
		getContainer().setSelection(getContainer().getItemCount()-1);
		diagramTabs.add(diagram);
	}
	
	/**
	 * Creates a new viewer for a new diagram in the container.
	 * The content of the viewer is the diagram.
	 * 
	 * @param parent the tab container
	 * @param diagram the contents of the viewer
	 * @return the graphical viewer created
	 */
	protected GraphicalViewer createNewViewer(Composite parent, Diagram diagram) {
		ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(parent);
		viewer.getControl().setBackground(ColorConstants.white);
		viewer.setEditPartFactory(new MapViewFactory());
		
		ScalableFreeformMapViewRootEditPart rootEditPart = new ScalableFreeformMapViewRootEditPart(this);
		viewer.setRootEditPart(rootEditPart);
		
		viewer.setContents(diagram);		
		return viewer;
	}
	
	/**
	 * Returns a copy of a diagram. The Map View shows copies of the original diagrams.
	 * 
	 * @param d the diagram to be copied
	 * @return the copied diagram
	 */
	private Diagram getCopiedDiagram(Diagram d) {		
		Diagram copyDiagram = UcmmodelFactory.eINSTANCE.createUCMDiagram();
		copyDiagram.setCoreModel(d.getCoreModel());
		copyDiagram.setGridEnabled(new Boolean(d.getGridEnabled().booleanValue()));
		copyDiagram.setSnapToGeometryEnabled(new Boolean(d.getSnapToGeometryEnabled().booleanValue()));
		copyDiagram.setName(d.getName());
		copyDiagram.getChildren().addAll(EcoreUtil.copyAll(d.getChildren()));
		return copyDiagram;
	}
		
	/**
	 * Creates a new item for the tab container.
	 * 
	 * @param index the index in the tab container
	 * @param control the control
	 * @param text the name of the item to show
	 * @return the new tab item
	 */
	private CTabItem createItem(int index, Control control, String text) {
        CTabItem item = new CTabItem(getContainer(), SWT.NONE, index);
        item.setText(text);
        item.setControl(control);
        return item;
    }
	
	/**
	 * Creates a new tab container. Each tab of this container represents a diagram.
	 * 
	 * @param parent
	 * @return the new tab container
	 */
	private CTabFolder createContainer(Composite parent) {		
		// use SWT.FLAT style so that an extra 1 pixel border is not reserved
		// inside the folder
		final CTabFolder newContainer = new CTabFolder(parent, SWT.BOTTOM
				| SWT.FLAT);
		newContainer.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// int newPageIndex = newContainer.indexOf((CTabItem) e.item);
				//  pageChange(newPageIndex);
			}
		});
		return newContainer;
	}
	  
    /**
     * @see WorkbenchPart#setFocus()
     */
    public void setFocus() {
    	getControl().setFocus();
    }
    
    public Control getControl() {    	
    	return sashForm;
	}
    
    public IPageSite getSite(){
    	return site;
    } 
    
    public void init(IPageSite site) {
    	this.site = site;
    }  	    
        
    public void dispose() {
    	deactivate();
    }
    
    public void setActionBars(IActionBars actionBars) {
		//Do nothing
	}
    
    protected void activate() {
    	getExecutionInfoManager().eAdapters().add(this);
    }
    
    protected void activateStep(ExecutionStep step) {
    	if (step != null)
    		step.eAdapters().add(this);
    }
    
    protected void deactivateStep(ExecutionStep step) {
    	if (step != null)
    		step.eAdapters().remove(this);
    }
    
    protected void deactivate() {
    	getExecutionInfoManager().eAdapters().remove(this);
    }

    protected Diagram getActualDiagram() {
    	int index = getContainer().getSelectionIndex();
    	if ( index >= 0 && index < diagramTabs.size())
    		return diagramTabs.get(index);
    	
    	return null;
    }
    
    /**
     * Adds a new step. A new interaction between two responsibilities node.
     * The responsibilities are marked and a connection between them is added.
     * 
     * @param step the new step
     */
    protected void addNewStep(ExecutionStep step) {
    	if (step.getSource() != null && step.getTarget() != null) {
    		steps.add(step);
    		addNewStep(step.getSource(), step.getTarget(), step.getExecutionContext().getCurrentFamily(), ColorConstants.black, SWT.LINE_DASHDOTDOT, true);
    	}
    }
    
    /**
     * Adds a new step. A new interaction between two responsibilities node.
     * The responsibilities are marked and a connection between them is added.
     * 
     * @param step the new step
     */
    protected void addNewStep(EvaluationStep step) {
    	if (step.getSource() != null && step.getTarget() != null)
    		addNewStep(step.getSource(), step.getTarget(), step.getCurrentFamily(), DependencyToColorFactory.getColor(step.getCondition()), DependencyToLineStyleFactory.getLineStyle(step.getCondition()), false);
    }
    
    /**
     * Adds a new step. A new interaction between two responsibilities node.
     * The responsibilities are marked and a connection between them is added.
     * 
     * @param step the new step
     */
    protected void addNewStep(SimplePathNode source, SimplePathNode target, String currentFamilyID, org.eclipse.swt.graphics.Color lineColor, int lineStyle, boolean updateFamily) {
    	if (source != null && target != null) {
    		
    		//Gets the data for the source Responsibility: diagram and compound visual models
    		Diagram diagramSource = getUCMDiagram(source.getMap(), getSourceFamilyID(source.getID(), currentFamilyID, false));	    		    		
    		CompoundVisualSimplePathNode cvrSource = getCompoundVisualModelForResponsibilityNode(source, diagramSource);
    		NodeVisualModel markSource = markResponsibility(cvrSource);
    		
    		//If both responsibilities are the same
    		if (source == target) {
    			arrageViewerToPosition(cvrSource.getVisualResponsibility().getAbsoluteLocation().getX(), cvrSource.getVisualResponsibility().getAbsoluteLocation().getY());
    			return;
    		}
    		
        	//Gets the data for the target Responsibility: diagram and compound visual models	
        	Diagram diagramTarget = getUCMDiagram(target.getMap(), currentFamilyID);
        	
        	getSourceFamilyID(target.getID(), currentFamilyID, updateFamily);
        	
    		CompoundVisualSimplePathNode cvrTarget = getCompoundVisualModelForResponsibilityNode(target, diagramTarget);
    		NodeVisualModel markTarget = markResponsibility(cvrTarget);
        	
    		if (diagramTarget != getActualDiagram())
    			showDiagram(diagramTarget);
    			
    		if (diagramSource == diagramTarget) {
    			ConnectionVisualModel c = doConnection(markSource, markTarget, lineColor, lineStyle);
    			cvrSource.getConnections().add(c);
    		} else {
    			int sourceSize = cvrSource.getOtherMarks().size();
    			int targetSize = cvrTarget.getOtherMarks().size();
    			
    			NodeVisualModel jumpSource = getJumpMapVisualModel(cvrSource.getVisualResponsibility(), diagramSource, diagramTarget, cvrTarget.getVisualResponsibility(), true, sourceSize * 25);
    			diagramSource.getChildren().add(jumpSource);
    			ConnectionVisualModel c1 = doConnection(cvrSource.getVisualResponsibility(), jumpSource, lineColor, lineStyle);
    			cvrSource.getConnections().add(c1);
    			cvrTarget.getOtherMarks().add(jumpSource);
    				
    			NodeVisualModel jumpTarget = getJumpMapVisualModel(cvrTarget.getVisualResponsibility(), diagramTarget, diagramSource, cvrSource.getVisualResponsibility(), false, targetSize * 25);
    			diagramTarget.getChildren().add(jumpTarget);
    			ConnectionVisualModel c2 = doConnection(jumpTarget, cvrTarget.getVisualResponsibility(), lineColor, lineStyle);
    			cvrSource.getConnections().add(c2);
    			cvrSource.getOtherMarks().add(jumpTarget);
    		}
    		arrageViewerToPosition(cvrTarget.getVisualResponsibility().getAbsoluteLocation().getX(), cvrTarget.getVisualResponsibility().getAbsoluteLocation().getY());
    	}
    }
    
    private String getSourceFamilyID(String nodeID, String familyID, boolean updatedFamily) {
    	String savedFamilyID = nodesIDToFamilyID.get(nodeID);
    	if (savedFamilyID == null) {
    		savedFamilyID = familyID;
    		nodesIDToFamilyID.put(nodeID, savedFamilyID);
    	}
		if (updatedFamily)
			nodesIDToFamilyID.put(nodeID, familyID);
    	return savedFamilyID;    	
    }
    
    private void arrageViewerToPosition(int x, int y) {
		int index = getActivePage();
		if (index >= 0) {
			FigureCanvas control = (FigureCanvas)getItem(index).getControl();    		
			control.getViewport().setHorizontalLocation(x - control.getHorizontalBar().getThumb() / 2);
			control.getViewport().setVerticalLocation(y - control.getVerticalBar().getThumb() / 2);
		}
    }
    
    private NodeVisualModel getJumpMapVisualModel(NodeVisualModel sourceVisual, Diagram sourceDiagram, Diagram targetDiagram, NodeVisualModel targetRn, boolean isTo, int paralleloffset) {
    	VisualDiagramJump visualJump = EditormodelFactory.eINSTANCE.createVisualDiagramJump();
    	visualJump.setSourceDiagram(sourceDiagram);
    	visualJump.setTargetDiagram(targetDiagram);
    	visualJump.setTargetVisualNode(targetRn);
    	visualJump.setTo(Boolean.valueOf(isTo));
    	//Sets the size of the visual jump
    	visualJump.setSize(EditormodelFactory.eINSTANCE.createDimension(21,21));
    	//Sets the location of the visual jump
    	Point ps = EditormodelFactory.eINSTANCE.createPoint();
		org.eclipse.draw2d.geometry.Point point = getMinimun(sourceVisual.getParent(), sourceVisual, 40, paralleloffset);
		ps.setX(point.x);
		ps.setY(point.y);
		
		visualJump.setLocation(ps);
		visualJump.setLineStyle(1);
		visualJump.setLineWidth(2);
		visualJump.setForegroundColor(Util.getColor(ColorConstants.black));
		return visualJump;
    }
    
    /**
     * Does a connection between two visual mark responsibilities.
     * 
     * @param node1 the source
     * @param node2 the target
     */
    private ConnectionVisualModel doConnection(NodeVisualModel node1, NodeVisualModel node2, org.eclipse.swt.graphics.Color color, int lineStyle) {
    	ConnectionVisualModel c = EditormodelFactory.eINSTANCE.createConnectionVisualModel();		
    	c.setForegroundColor(Util.getColor(color));
    	c.setLineStyle(lineStyle);
    	c.setLineWidth(2);
    	c.setSource(node1);
    	c.setTarget(node2);    	
    	return c;
	}
       
    /**
     * Returns a CompoundVisualResponsibility with all the visual nodes corresponding to the responsibility node in the diagram.
     * 
     * @param rn the responsibility node
     * @param d the diagram where the node is
     * @return the list of visual nodes
     */
    private CompoundVisualSimplePathNode getCompoundVisualModelForResponsibilityNode(SimplePathNode node, Diagram d) {
    	CompoundVisualSimplePathNode models = null;
    	Map<SimplePathNode, CompoundVisualSimplePathNode> responsibilitesToVisual = diagramsToMapNodes.get(d);
    	if (responsibilitesToVisual != null)
    		models = responsibilitesToVisual.get(node);
    	return models;    		
    }
    
    /**
     * Returns a node visual model corresponding to the an ellipse for the visual responsibility.
     * 
     * @param visual the visual responsibility
     * @return the visual mark for the visual responsibility
     */
    protected NodeVisualModel getMarkResponsibility(VisualModel visual) {    	
    	NodeVisualModel visualMark = EditormodelFactory.eINSTANCE.createNodeVisualModel();				
    	
    	//Sets the size of the mark
    	visualMark.setSize(Util.getDimension(VisualDiagramJumpFigure.defaultsize));
		//Sets the location of the mark
    	Point p = EditormodelFactory.eINSTANCE.createPoint();
    	p.setX(visual.getLocation().getX() + visual.getSize().getWidth()/2 - visualMark.getSize().getWidth() / 2);
    	p.setY(visual.getLocation().getY() + visual.getSize().getHeight()/2 - visualMark.getSize().getHeight()/2);
		visualMark.setLocation(p);
		
		visualMark.setLineStyle(1);
		visualMark.setLineWidth(2);
		visualMark.setForegroundColor(Util.getColor(ColorConstants.black));
		return visualMark;
    }
    
    private NodeVisualModel markResponsibility(CompoundVisualSimplePathNode model) {
    	if (!model.isMarked()) {
    		NodeVisualModel resp = model.getVisualResponsibility();
    		NodeVisualModel mark = getMarkResponsibility(resp);
    		if (resp.getParent() != null)
    			resp.getParent().getChildren().add(0, mark);
    		else
    			resp.getDiagram().getChildren().add(0, mark);
    		model.setVisualMark(mark);
    		return mark;
    	} else
    		return model.getVisualMark();
    }
    
    /**
     * Searchs if the given UseCaseMap already exists in this view, if not it will generate a copy from the diagrams of the Flabot File Model. 
     * 
     * @param map
     * @return the ucm diagram 
     */
    private Diagram getUCMDiagram(UseCaseMap map, String familyID) {
    	Diagram d = mapsToDiagrams.get(map.getID() + familyID);
    	if (d == null) {
    		UCMDiagram modelDiagram = getUCMDiagramFromModel(map);
    		d = getCopiedDiagram(modelDiagram);
    		d.setName(d.getName() + " - " + getFamilyName(familyID, map.getCoreModel()));    		 //$NON-NLS-1$
    		addNewDiagram(d);
    		mapsToDiagrams.put(map.getID() + familyID, d);
    		diagramsToMapNodes.put(d, getResponsibilitiesToVisualMap(d));    		
    	} else {
    		if (!diagramTabs.contains(d))
    			addNewDiagram(d);
    	}
    	return d;
    }
    
    /**
     * Returns the UCM diagram corresponding to the given UseCaseMap.
     * 
     * @param map
     * @return the ucm diagram
     */
    private UCMDiagram getUCMDiagramFromModel(UseCaseMap map) {
    	List diagrams = getFlabotFileModel().getDiagrams();
    	for(Iterator iter=diagrams.iterator(); iter.hasNext();) {
    		Diagram d = (Diagram) iter.next();
    		if (d instanceof UCMDiagram) {
    			UCMDiagram ucmd = (UCMDiagram) d;
    			if (ucmd.getMap() == map)
    				return ucmd;
    		}
    	}    	
    	return null;
    }
    
    /**
     * Returns the gamily name corresponding to the given family ID.
     * 
     * @param familyID the family ID
     * @param coreModel the CoreModel
     * @return the family name
     */
    private String getFamilyName(String familyID, CoreModel coreModel) {
    	for(Iterator iter=coreModel.getFamilies().iterator(); iter.hasNext();) {
    		Family family = (Family) iter.next();
    		if (family.getID().equals(familyID))
    			return family.getName();
    	}
    	return ""; //$NON-NLS-1$
    }
    
    /**
     * Returns a hash table where the key is a responsibility node and the values is a list with all the visual respresentations of that node.

     * @param d the diagram
     * @return the hash table
     */
    private Map<SimplePathNode, CompoundVisualSimplePathNode> getResponsibilitiesToVisualMap(Diagram d) {				    
    	//All the visual nodes in the diagram
    	List<ConnectionVisualModel> connectionsToRemove = new ArrayList<ConnectionVisualModel>();
    	List<VisualDiagramJump> visualsToRemove = new ArrayList<VisualDiagramJump>();
    	
    	List<NodeVisualModel> visuals = new ArrayList<NodeVisualModel>();
		for (Iterator iter=d.getChildren().iterator(); iter.hasNext();) {
			NodeVisualModel visual = (NodeVisualModel)  iter.next();
			
			if (visual instanceof VisualDiagramJump) {
				visualsToRemove.add((VisualDiagramJump)visual);
				continue;
			}
			
			if (visual.getSemanticModel() instanceof ComponentRole) {
				//All the visual nodes in the component
				for (Iterator iter2=visual.getChildren().iterator(); iter2.hasNext();) {
					NodeVisualModel v = (NodeVisualModel)  iter2.next();
					if (v.getSemanticModel() instanceof ResponsibilityNode) {
						visuals.add(v);
						addConditionConnectionsToRemove(connectionsToRemove, v.getSourceConnections());
						addConditionConnectionsToRemove(connectionsToRemove, v.getTargetConnections());
					}
				}
				continue;
			}
			
			if (visual.getSemanticModel() instanceof ResponsibilityNode) {
				visuals.add(visual);
				addConditionConnectionsToRemove(connectionsToRemove, visual.getSourceConnections());
				addConditionConnectionsToRemove(connectionsToRemove, visual.getTargetConnections());
				continue;
			}
							
			if (visual.getSemanticModel() instanceof StubNode) {
				visuals.add(visual);
				continue;
			}
		}
		
    	Map<SimplePathNode, CompoundVisualSimplePathNode> semanticToVisual = new HashMap<SimplePathNode, CompoundVisualSimplePathNode>();
		for(int i=0; i<visuals.size(); i++) {
			NodeVisualModel node = visuals.get(i);
			node.setForegroundColor(Util.getColor(ColorConstants.black));
			node.setDetailLevel(VisualModel.LOW_DETAIL);
			CompoundVisualSimplePathNode cvr = new CompoundVisualSimplePathNode(); 
	    	cvr.setVisualSimplePathNode(node);
	    	
	    	semanticToVisual.put((SimplePathNode)node.getSemanticModel(), cvr);
	    }
		
		for(int i=0; i<visualsToRemove.size(); i++) {
			VisualDiagramJump visualJump = visualsToRemove.get(i);
			removeConnections(visualJump.getSourceConnections());
			removeConnections(visualJump.getTargetConnections());
			
			d.getChildren().remove(visualJump);
	    }				
		removeConnections(connectionsToRemove);
		return semanticToVisual;
	}

    private void removeConnections(List connections) {
    	int size = connections.size();
    	for(int i= size-1; i>=0; i--) {
    		ConnectionVisualModel c = (ConnectionVisualModel) connections.get(i);
    		c.setSource(null);
    		c.setTarget(null);
    	}    	
    }
    
    private void addConditionConnectionsToRemove(List<ConnectionVisualModel> removedList, List connections) {
    	for(Iterator iter=connections.iterator(); iter.hasNext();) {
    		ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
    		if (c.getSemanticModel() instanceof Condition)
    			removedList.add(c);
    	}
    }
    
    /**
     * Returns the Flabot File Model
     * 
     * @return the flabot file model
     */
    public FlabotFileModel getFlabotFileModel() {
    	return model;
    }
    
    /**
     * Shows the diagram d. This diagram must exist in the container, if not current diagram is shown. 
     * The scroll of the diagram's viewer is moved so the position x,y is centered.
     * 
     * @param d the diagram to show
     * @param x the x position to show center
     * @param y the y position to show center
     */
    public void showDiagram(Diagram d, int x, int y) {
    	showDiagram(d);
    	arrageViewerToPosition(x, y);   	
    }
    
    /**
     * Shows the diagram d. This diagram must exist in the container, if not current diagram is shown. 
     * The scroll of the diagram's viewer is moved so the position x,y is centered.
     * 
     * @param d the diagram to show
     * @param x the x position to show center
     * @param y the y position to show center
     */
    public void showDiagram(Diagram d) {
    	int index = diagramTabs.indexOf(d);
    	if (index != -1) {
    		setActivePage(index);
    	}    	
    }
    
    /**
     * Sets the currently active page.
     *
     * @param pageIndex the index of the page to be activated; the index must be valid
     */
    protected void setActivePage(int pageIndex) {
        Assert.isTrue(pageIndex >= 0 && pageIndex < getPageCount());
        getContainer().setSelection(pageIndex);
    }
    
    /**
     * Removes the page with the given index . The
     * controls for the page are disposed.
     */
    public void removePage(int pageIndex) {
        Assert.isTrue(pageIndex >= 0 && pageIndex < getPageCount());
        // dispose item 
        getItem(pageIndex).dispose();
    }
    
    
    /**
     * Returns the index of the currently active page,
     * or -1 if there is no active page.
     *
     * @return the index of the active page, or -1 if there is no active page
     */
    protected int getActivePage() {
        CTabFolder tabFolder = getContainer();
        if (tabFolder != null && !tabFolder.isDisposed())
            return tabFolder.getSelectionIndex();
        return -1;
    }
    
    /**
     * Returns the number of pages in this multi-page editor.
     *
     * @return the number of pages
     */
    protected int getPageCount() {
        CTabFolder folder = getContainer();
        // May not have been created yet, or may have been disposed.
        if (folder != null && !folder.isDisposed())
            return folder.getItemCount();
        return 0;
    }
    
    /**
     * Returns the control for the given page index, or <code>null</code>
     * if no control has been set for the page.
     * The page index must be valid.
     * <p>
     * 
     * @param pageIndex the index of the page
     * @return the control for the specified page, or <code>null</code> if none has been set
     */
    protected Control getControl(int pageIndex) {
        return getItem(pageIndex).getControl();
    }
    
    /**
     * Returns the tab item for the given page index (page index is 0-based).
     * The page index must be valid.
     *
     * @param pageIndex the index of the page
     * @return the tab item for the given page index
     */
    private CTabItem getItem(int pageIndex) {
        return getContainer().getItem(pageIndex);
    }
    
    private void backToStep(ExecutionStep step) {
    	if (steps.size() <= 0)
    		return;
    	
    	ExecutionStep actualStep = steps.get(steps.size() - 1);
    	while(actualStep != step && steps.size() > 0) {    		
    		removeStep(actualStep);
    		deactivateStep(actualStep);
    		actualStep = steps.get(steps.size() - 1);
    	}
    }
    
    /*
     * Adapter Implementation
     */    
	public Notifier getTarget() {
		return target;
	}
	
	public void setTarget(Notifier newTarget) {
		target = newTarget;
	}
	
	public boolean isAdapterForType(Object type) {
		return getExecutionInfoManager() == type;
	}
	
	public void setResponsibilitiesStates(ExecutionStep step) {
		Diagram diagram = getUCMDiagram(step.getTarget().getMap(), step.getExecutionContext().getCurrentFamily());	
				
		Color color = Util.getColor(StateColorFactory.getStateColor(step.getFinalState()));					
			
		CompoundVisualSimplePathNode cvr = getCompoundVisualModelForResponsibilityNode(step.getTarget(), diagram);
		if (cvr.isMarked())
			cvr.getVisualMark().setForegroundColor(color.clone());
		cvr.getVisualResponsibility().setForegroundColor(color.clone());
		List list = cvr.getOtherMarks();
		for (Iterator iter=list.iterator(); iter.hasNext();) {
			NodeVisualModel nvm = (NodeVisualModel) iter.next();
			nvm.setForegroundColor(color.clone());	
		}
	}
	
	private void changeExecutionInfo() {
		for(ExecutionStep step: steps)
			deactivateStep(step);
		
		steps.clear();
		diagramTabs.clear();
		mapsToDiagrams.clear();
		diagramsToMapNodes.clear();
		nodesIDToFamilyID.clear();
		for(int i=getContainer().getItemCount() - 1; i>=0; i--)
			removePage(i);
	}	
	
	private void resetView() {
		changeExecutionInfo();
		updateNoSteps();
	}
	
	private void removeStep(ExecutionStep step) {
		steps.remove(step);
		if (step.getSource() != null && step.getTarget() != null)
			removeStep(step.getSource(), step.getTarget(), step.getExecutionContext().getCurrentFamily());
	}
	
	private void removeStep(SimplePathNode source, SimplePathNode target, String currentFamilyID) {	
		if (source != null && target != null) {    		
			//Gets the data for the source Responsibility: diagram and compound visual models
    		Diagram diagramSource = getUCMDiagram(source.getMap(),getSourceFamilyID(source.getID(), currentFamilyID, false));	    		    		
    		CompoundVisualSimplePathNode cvrSource = getCompoundVisualModelForResponsibilityNode(source, diagramSource);
    		
    		//If both responsibilities are the same
    		if (source == target) {
    			finishCompoundVisualSimplePathNode(diagramSource, cvrSource);
    			return;
    		}
    		
        	//Gets the data for the target Responsibility: diagram and compound visual models	
        	Diagram diagramTarget = getUCMDiagram(target.getMap(), currentFamilyID);
    		CompoundVisualSimplePathNode cvrTarget = getCompoundVisualModelForResponsibilityNode(target, diagramTarget);
		
    		if (!removeConnection(cvrSource, cvrTarget.getVisualMark())) {
    			removeSourceFromOtherMarks(cvrSource, cvrTarget.getVisualResponsibility());
    			removeTargetFromOtherMarks(cvrTarget, cvrSource.getVisualResponsibility());
    		}
    		
    		finishCompoundVisualSimplePathNode(diagramSource, cvrSource);
    		finishCompoundVisualSimplePathNode(diagramTarget, cvrTarget);
    		
    		//checkRemoveMap(diagramTarget);    			
		}
	}
	
	private void checkRemoveMap(Diagram diagram) {
		Map<SimplePathNode, CompoundVisualSimplePathNode> maps = diagramsToMapNodes.get(diagram);
		
		boolean isEmpty = true;
		for(Iterator iter = maps.values().iterator(); iter.hasNext() && isEmpty;) {
			CompoundVisualSimplePathNode cv = (CompoundVisualSimplePathNode) iter.next();
			if (cv.isMarked() || cv.getOtherMarks().size() > 0) 
				isEmpty = false;
		}
		
		if (isEmpty) {
			int index = diagramTabs.indexOf(diagram); 
			if (index >= 0) {
				diagramTabs.remove(index);
				removePage(index);
			}    			
		}    	
	}
	
	private void removeStep(EvaluationStep step) {
		if (step.getSource() != null && step.getTarget() != null)    		
			removeStep(step.getSource(), step.getTarget(), step.getCurrentFamily());	
	}
	
	private void finishCompoundVisualSimplePathNode(Diagram diagram , CompoundVisualSimplePathNode cvr) {
		if (cvr.getOtherMarks().size() <= 0 && cvr.getVisualMark() != null &&
			cvr.getVisualMark().getTargetConnections().size() <= 0 && 
			cvr.getVisualMark().getSourceConnections().size() <= 0) {
				
				finishNodeVisualModel(cvr.getVisualMark());				
				cvr.getVisualResponsibility().setForegroundColor(Util.getColor(ColorConstants.black));
				cvr.setVisualMark(null);
		}
	}
		
	private boolean removeConnection(CompoundVisualSimplePathNode source, NodeVisualModel target) {				
		List connections = source.getConnections();
		for(int i = connections.size()-1; i >= 0; i--) {
			ConnectionVisualModel c = (ConnectionVisualModel) connections.get(i);
			if (c.getTarget() == target) {
				finishConnectionVisualModel(c);
				source.getConnections().remove(i);
				return true;
			}
		}
		return false;
	}
	
	private void finishConnectionVisualModel(ConnectionVisualModel c) {
		c.setSource(null);
		c.setTarget(null);
	}
	
	private void finishNodeVisualModel(NodeVisualModel node) {
		VisualModel parent = node.getParent();
		if (parent == null)
			node.getDiagram().getChildren().remove(node);
		else
			parent.getChildren().remove(node);
	}
	
	private void removeSourceFromOtherMarks(CompoundVisualSimplePathNode source, NodeVisualModel target) {
		for(Iterator iter=source.getOtherMarks().iterator(); iter.hasNext();) {
			VisualDiagramJump jump = (VisualDiagramJump) iter.next();
			if (jump.getTargetVisualNode() == source.getVisualResponsibility()) {
				if (jump.getSourceConnections().size() > 0)
					finishConnectionVisualModel((ConnectionVisualModel) jump.getSourceConnections().get(0));				
				finishNodeVisualModel(jump);
				source.getOtherMarks().remove(jump);
				break;
			}
		}
	}
	
	private void removeTargetFromOtherMarks(CompoundVisualSimplePathNode target, NodeVisualModel source) {
		for(Iterator iter=target.getOtherMarks().iterator(); iter.hasNext();) {
			VisualDiagramJump jump = (VisualDiagramJump) iter.next();
			if (jump.getTargetVisualNode() == target.getVisualResponsibility()) {
				if (jump.getTargetConnections().size() > 0)
					finishConnectionVisualModel((ConnectionVisualModel) jump.getTargetConnections().get(0));
				finishNodeVisualModel(jump);
				target.getOtherMarks().remove(jump);
				break;
			}
		}
	}
	
	public void internalNotifyChanged(Notification notification) {
		int featureID = notification.getFeatureID(ExecutionmodelPackage.class); 
		
		if (notification.getNotifier() instanceof ExecutionInfo) {
			switch (featureID) {
				case ExecutionmodelPackage.EXECUTION_INFO__BACK_TO_STEP:
					if (notification.getEventType() == Notification.SET) {
						ExecutionStep backStep = (ExecutionStep) notification.getNewValue();
						if (backStep.getEnabled() == ExecutionContext.enabled_Step)
							backToStep(backStep);
					}
					break;
				case ExecutionmodelPackage.EXECUTION_INFO__EXECUTION_STEPS:
					if (notification.getEventType() == Notification.ADD) {
						ExecutionStep newStep = (ExecutionStep)notification.getNewValue(); 
						if (newStep.getEnabled() == ExecutionContext.enabled_Step){
							addNewStep(newStep);
							activateStep(newStep);
						}
					}
					break;
				case ExecutionmodelPackage.EXECUTION_INFO__START_EVALUATING_NODE:
					if (notification.getEventType() == Notification.SET) {
						EvaluationStep newStep = (EvaluationStep)notification.getNewValue(); 
						addNewStep(newStep);
					}
					break;
					
				case ExecutionmodelPackage.EXECUTION_INFO__FINISH_EVALUATING_NODE:
					if (notification.getEventType() == Notification.SET) {
						EvaluationStep newStep = (EvaluationStep)notification.getOldValue(); 
						removeStep(newStep);
					}
					break;
				
				case ExecutionmodelPackage.EXECUTION_INFO__RESET:
					if (notification.getEventType() == Notification.SET) {
						resetView();
					}
					break;

			}
			return;
		}
		
		if (notification.getNotifier() instanceof ExecutionInfoManager) {
			if (notification.getEventType() == Notification.SET &&
					featureID == ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION)
				changeExecutionInfo();
			return;
		}
		
		if (notification.getNotifier() instanceof ExecutionStep) {
			if (notification.getEventType() == Notification.SET &&
					featureID == ExecutionmodelPackage.EXECUTION_STEP__FINAL_STATE) {
				ExecutionStep step = (ExecutionStep)notification.getNotifier();
				setResponsibilitiesStates(step);
			}
			return;
		}	
	}	
	
	public void notifyChanged(final Notification notification) {
		Workbench.getInstance().getDisplay().syncExec(
				new Runnable() {
					public void run(){
						internalNotifyChanged(notification);
					}
				}
		);		
	}
	
	
	protected Control createControlStatesBar(Composite parent) {	     				
		ScrollingGraphicalViewer viewer = new ScrollingGraphicalViewer();
		viewer.createControl(parent);		 
		viewer.getControl().setBackground(ColorConstants.white);
		Composite composite = (Composite)viewer.getControl();
		composite.setBackground(ColorConstants.white);      	
    	
    	GridLayout layout = new GridLayout(6, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;    	
    	layout.verticalSpacing = 5;
		layout.horizontalSpacing = 5;
		composite.setLayout(layout);		
		composite.setLayoutData(new GridData(GridData.FILL_BOTH | GridData.HORIZONTAL_ALIGN_CENTER));	
		
		Composite c = new Composite(composite, SWT.BORDER | SWT.BEGINNING);
		
		layout = new GridLayout(3, false);
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		c.setLayout(layout);		
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 6;
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
		label.setText(Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.states")); //$NON-NLS-1$
		gd = new GridData(GridData.HORIZONTAL_ALIGN_CENTER);
		label.setLayoutData(gd);		
		
		addResponsibilityFigure(composite, ExecutionState.FAULTY_LITERAL); 	    
	    addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.faulty")); //$NON-NLS-1$
		
	    addResponsibilityFigure(composite, ExecutionState.EXECUTED_LITERAL);
	    addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.executed")); //$NON-NLS-1$
		
	    addResponsibilityFigure(composite, ExecutionState.NOT_EXECUTED_LITERAL);
	    addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.notExecuted")); //$NON-NLS-1$
		
	    addResponsibilityFigure(composite, ExecutionState.FAULTY_PREVIOUS_LITERAL);
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.faultyPrevious")); //$NON-NLS-1$
		 		
		addResponsibilityFigure(composite, ExecutionState.FAULTY_NEXT_LEVELS_LITERAL); 	    
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.faultyNextLevel")); //$NON-NLS-1$
		
		addResponsibilityFigure(composite, ExecutionState.FAULTY_PRECONDITION_LITERAL);
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.faultyPrecondition")); //$NON-NLS-1$
		
		addResponsibilityFigure(composite, ExecutionState.FAULTY_CONSTRAIN_LITERAL);
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.faultyConstraint")); //$NON-NLS-1$
		
		addResponsibilityFigure(composite, ExecutionState.FAULTY_CONSTRAINT_START_LITERAL);
		addLabel(composite, Messages.getString("org.isistan.flabot.edit.mapview.MapViewPage.faultyStartConstraint")); //$NON-NLS-1$
		
		return composite;		
     }
     
	private void addLabel(Composite composite, String name) {
		Label label = new Label(composite, SWT.NONE);
		label.setText(name);
		GridData gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING |
 				GridData.HORIZONTAL_ALIGN_BEGINNING);
		gd.widthHint = 130;
		label.setLayoutData(gd);
		label.setBackground(ColorConstants.white);
	}
	
	private void addResponsibilityFigure(Composite composite, ExecutionState state) {
		ResponsibilityNodeFigure f = new ResponsibilityNodeFigure(null, StateColorFactory.getStateColor(state).getRGB());
 		Canvas c = new Canvas(composite, SWT.NULL);	    
 		c.setBackground(ColorConstants.white);
 		GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_END);
 		gd.widthHint = 15;
 		gd.heightHint = 15;
 	    c.setLayoutData(gd);	    
 	    LightweightSystem l = new LightweightSystem(c);
 	    l.setContents(f);
	}
	
	
	class CompoundVisualSimplePathNode {
		private NodeVisualModel visualSimplePathNode;
		
		private NodeVisualModel visualMark;
		
		private List otherMarks = new ArrayList();
		
		private List connections = new ArrayList();
		
		public void setVisualSimplePathNode(NodeVisualModel visualResponsibility) {
			this.visualSimplePathNode = visualResponsibility;			
		}
		
		public NodeVisualModel getVisualResponsibility() {
			return visualSimplePathNode;		
		}
		
		public void setVisualMark(NodeVisualModel visualMark) {
			this.visualMark = visualMark;			
		}
		
		public NodeVisualModel getVisualMark() {
			return visualMark;			
		}
		
		public List getOtherMarks() {
			return otherMarks;
		}
		
		public boolean isMarked() {
			return visualMark != null;
		}
		
		public List getConnections() {
			return connections;
		}
	}
}