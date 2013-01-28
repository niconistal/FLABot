/**
 * $Id: SequenceViewEditPart.java,v 1.1 2006/03/29 20:21:58 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.sequenceview.editparts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.gef.editpolicies.RootComponentEditPolicy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.sequenceview.figures.SequenceDiagram;
import org.isistan.flabot.edit.ucmeditor.editparts.DependencyToColorFactory;
import org.isistan.flabot.edit.ucmeditor.editparts.DependencyToLineStyleFactory;
import org.isistan.flabot.executionmodel.ExecutionContext;
import org.isistan.flabot.executionmodel.ExecutionInfo;
import org.isistan.flabot.executionmodel.ExecutionInfoManager;
import org.isistan.flabot.executionmodel.ExecutionStep;
import org.isistan.flabot.executionmodel.ExecutionmodelPackage;

/**
 * This edit part is used by the Sequence View. It receives the notifications from the Execution Info Manager and updates this view.
 * The notification includes the new steps done by the Fault Locator Engine.
 * 
 * @author $Author: franco $
 *
 */
public class SequenceViewEditPart extends AbstractGraphicalEditPart
	implements Adapter {
	
	private Map<String,SequenceViewHeader> nodeToHeader = new HashMap<String,SequenceViewHeader>();	
	
	private List<SequenceViewHeader> headerList = new ArrayList<SequenceViewHeader>();
	
	private List<SequenceViewFooter> footerList = new ArrayList<SequenceViewFooter>();
	
	private List<String> stepsList = new ArrayList<String>();
	
	private List<ExecutionStep> steps = new ArrayList<ExecutionStep>();
	
	//Buffers	
	private StringBuffer headerBuffer = new StringBuffer();
	
	private StringBuffer bodyBuffer = new StringBuffer();
		
	private StringBuffer footerBuffer = new StringBuffer();
			
	ExecutionInfoManager getCastedModel() {
		return (ExecutionInfoManager)getModel();
	}
		
	/**
	 * Upon activation, attach to the model element as a property change listener.
	 */
	@Override
	public void activate() {		
		if (!isActive()) {
			super.activate();
			getCastedModel().eAdapters().add(this);
		}
	}

	@Override
	protected IFigure createFigure() {
		SequenceDiagram f = new SequenceDiagram();
		f.setBorder(new MarginBorder(3));
		return f;
	}
	
	/**
	 * Upon deactivation, detach from the model element as a property change listener.
	 */
	@Override
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			getCastedModel().eAdapters().remove(this);
		}
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.COMPONENT_ROLE, new RootComponentEditPolicy());
	}
	
	private String getMapKey(SimplePathNode pathNode, ComponentRole instanceRole) {
		String key = ""; //$NON-NLS-1$
		if (pathNode instanceof ResponsibilityNode) {
			ResponsibilityNode responsibility = (ResponsibilityNode) pathNode;
			if (responsibility.getRole() != null) {
				key = responsibility.getRole().getID();
				if (instanceRole!=null && !responsibility.getRole().equals(instanceRole)) {
					key = instanceRole.getID()+responsibility.getRole().getID();
				}
				return key;
			}
		}
		return pathNode.getID();				
	}
	
	/**
	 * Returns the correct name for the given SimplePathNode
	 * 
	 * @param pathNode
	 * @param role 
	 * @return the correct name for the given SimplePathNode
	 */
	private String getCorrectName(SimplePathNode pathNode, ComponentRole instanceRole) {
		if (pathNode instanceof ResponsibilityNode) {
			ResponsibilityNode responsibility = (ResponsibilityNode) pathNode;
			if (responsibility.getRole() != null){
				String roleName = responsibility.getRole().getName() + "##:"+ responsibility.getRole().getComponent().getName(); //$NON-NLS-1$
				if (instanceRole!=null && !responsibility.getRole().equals(instanceRole)) {					
					roleName =  instanceRole.getFullName() + "##InstanceOf " + responsibility.getRole().getFullName(); //$NON-NLS-1$
				}
				return roleName;
			}
		}
		return pathNode.getName();
	}
	
	/**
	 * Returns the correct SequenceViewHeader for the given SimplePathNode
	 * 
	 * @param pathNode
	 * @return the correct SequenceViewHeader for the given SimplePathNode
	 */
	private SequenceViewHeader getHeader(SimplePathNode pathNode, ComponentRole instanceRole) {
		String key = getMapKey(pathNode, instanceRole);		
		if (nodeToHeader.containsKey(key))
			return nodeToHeader.get(key);
		
		return null;
	}
	
	/**
	 * Adds a new header for the given SimplePathNode, it can be a Role Component/Stub/Fork/Join
	 * It also updates the footer list if the UCM diagram chaged.
	 * 
	 * @param pathNode the simple path node
	 * @param role 
	 * @return the new SequenceViewHeader
	 */
	private SequenceViewHeader addNewHeader(SimplePathNode pathNode, ComponentRole instanceRole) {
		SequenceViewHeader svc = new SequenceViewHeader(nodeToHeader.size() + 1, 0, getCorrectName(pathNode, instanceRole)); 		
		//Object key = getMapKey(pathNode);
		String key = getMapKey(pathNode, instanceRole);
		nodeToHeader.put(key, svc);				
		headerList.add(svc);
		headerBuffer.append(getHeaderLine(svc));

		//Updates the division between different use case maps
		UseCaseMap actualMap = pathNode.getMap();
		UseCaseMap lastMap = getLastMap();
		if (lastMap == null  || lastMap != actualMap) {
			SequenceViewFooter svf = new SequenceViewFooter(svc.getNumber(), svc.getNumber(), actualMap);
			footerList.add(svf);
			footerBuffer.append(getFooterLine(svf));
		} else {						
			int lastcomponent = getLastComponent(); 
			if (footerList.size() > 0)
				footerList.remove(footerList.size() - 1);
			
			SequenceViewFooter svf = new SequenceViewFooter(lastcomponent, svc.getNumber(), actualMap);
			footerList.add(svf);	
			updateFooterBuffer();						
		}
		return svc;
	}
	
	/**
	 * Returns the last Use Case Map added to the footer
	 * 
	 * @return the last Use Case Map  added to the footer
	 */
	private UseCaseMap getLastMap() {
		if (footerList.size() > 0)
			return footerList.get(footerList.size() - 1).getUseCaseMap();
		return null;
	}
	
	/**
	 * Returns the number of the last component added to the footer
	 * 
	 * @return the number of the last component added to the footer
	 */
	private int getLastComponent() {
		if (footerList.size() > 0)
			return footerList.get(footerList.size() - 1).getSource();
		return 0;
	}
	
	/**
	 * Creates a string header line for a SequenceViewHeader
	 * 
	 * @param svf the SequenceViewHeader
	 * @return the string header line
	 */
	private String getHeaderLine(SequenceViewHeader svh) {
		return "_" + svh.getName() + "_|"; //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	/**
	 * Creates a string footer line for a SequenceViewFooter
	 * 
	 * @param svf the SequenceViewFooter
	 * @return the string footer line
	 */
	private String getFooterLine(SequenceViewFooter svf) {		
		return svf.getSource() + "==" + svf.getTarget() + ":" + svf.getName()+ "\n"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}
	
	/**
	 * Creates a string body line for a step
	 * 
	 * @param source the source component number
	 * @param target the target component number
	 * @param dependecyType the dependency type (for color and arrow type)
	 * @param name the name of the responsibility to showw in the arrow	 * 
	 * @return a string body line
	 */
	private String getBodyLine(int source, int target, String dependecyType, String name) {		
		Color color = DependencyToColorFactory.getColor(dependecyType);
		String arrowType = DependecyToArrowFactory.getArrow(
				Integer.valueOf(DependencyToLineStyleFactory.getLineStyle(dependecyType))
				);
		return source + arrowType + target + ":" + source + "," + target + ":" + name + "_" + color.getRed() + ":" + color.getGreen() + ":" + color.getBlue() +  "\n";  //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$
	}
	
	/**
	 * Changes the current ExecutionInfo.
	 * All the lists and the figure are resetted. 
	 */
	public void changeExecutionInfo() {
		steps.clear();
		nodeToHeader.clear();
		headerList.clear();
		stepsList.clear();
		footerList.clear();
		headerBuffer.delete(0, headerBuffer.capacity());
		bodyBuffer.delete(0, bodyBuffer.capacity());
		footerBuffer.delete(0, footerBuffer.capacity());
		
		updateStringBuffers();
	}
	
	/**
	 * Adds a new step to the Sequence View
	 * - Adds the step to the steps list.
	 * - Obtains the source and target SequenceViewHeader, if they do not exit, they are created.
	 * - Creates a new body line and adds it to the steps lines list and body buffer.
	 * - Updates the figure.
	 * 
	 * @param step the new step to add
	 */
	private void addNewStep(ExecutionStep step)  {
		if (step.getSource() != null && step.getTarget() != null) {
    		steps.add(step);
    		
			//steps start at 1
			SequenceViewHeader source = getSourceResponsibilityNumber(step.getSource(), Integer.parseInt(step.getExecutionContext().getCurrentStep()) - 1, step.getInstanceComponentToSource());
			if (source == null)
				source = addNewHeader(step.getSource(), step.getInstanceComponentToSource());
			source.incReferences();
			
			SequenceViewHeader target = getTargetResponsibilityNumber(step.getTarget(), step.getInstanceComponentToTarget());
			if (target == null)
				target = addNewHeader(step.getTarget(), step.getInstanceComponentToTarget());
			target.incReferences();
					
			//String line = getBodyLine(source.getNumber(), target.getNumber(), step.getDependency().getType(), step.getTarget().getName());
			String line = getBodyLine(target.getNumber(), source.getNumber(), step.getDependency().getType(), step.getSource().getName());
			stepsList.add(line);
			bodyBuffer.append(line);
			updateFigure();
		}
	}
	
	/**
	 * Updates the figure with the content of the string buffers (header, body and footer)
	 *
	 */
	private void updateFigure() {
		getCastedFigure().setText(headerBuffer.toString() + "\n" + bodyBuffer.toString() + footerBuffer); //$NON-NLS-1$
	}
	
	/**
	 * Return the casted SequenceDiagram figure.
	 * 
	 * @return the SequenceDiagram figure
	 */
	private SequenceDiagram getCastedFigure() {
		return (SequenceDiagram) getFigure();
	}
	
	/**
	 * Return the corresponding SequenceViewHeader for the source.
	 * In case the source is a StubNode, the source is the taget of the previous step.
	 * 
	 * @param source the source of the step
	 * @return the corresponding SequenceViewHeader for the source
	 */
	private SequenceViewHeader getSourceResponsibilityNumber(SimplePathNode source, int stepNumber, ComponentRole instanceRole) {
		SequenceViewHeader svh = null;
		if (source instanceof StubNode) {			
			//the target of the previus step
			int lastTargetNumber = getTargetNumber(steps.size() - 2) - 1;
			if (lastTargetNumber >= 0 && lastTargetNumber < headerList.size())
				svh = headerList.get(lastTargetNumber);		
		} else 
			svh = getHeader(source, instanceRole);
		return svh;
	}	
	
	/**
	 * Returns the target number for the given step number.
	 * 
	 * @param stepNumber
	 * @return the target number for the given step number
	 */
	private int getTargetNumber(int stepNumber) {
		if (stepNumber >= 0 && stepNumber < stepsList.size()) {
			String lastStep = stepsList.get(stepNumber);			
			int[] numbers = getStepNumbers(lastStep);
			if (numbers != null)
				return numbers[1];
		}
		return 0;
	}
	
	/**
	 * Returns the step numbers start and end (source, target) for a step line.
	 * 
	 * @param stepLine the step line
	 * @return the step numbers, start and end
	 */
	private int[] getStepNumbers(String stepLine) {
		int[] ret = null;
		
		// Finds the number of source and target
		int start = stepLine.indexOf(":") + 1; //$NON-NLS-1$
		int end = stepLine.indexOf(":", start); //$NON-NLS-1$
		String numbers = stepLine.substring(start, end);
		
		StringTokenizer st = new StringTokenizer(numbers, ","); //$NON-NLS-1$
		if (st.countTokens() == 2) {
			ret = new int[2];
			ret[0] = Integer.parseInt(st.nextToken());
			ret[1] = Integer.parseInt(st.nextToken());
		}
		
		return ret;
	}
	
	/**
	 * Return the corresponding SequenceViewHeader for the target.
	 * 
	 * @param target the target of the step
	 * @return the corresponding SequenceViewHeader for the target
	 */
	private SequenceViewHeader getTargetResponsibilityNumber(SimplePathNode target, ComponentRole instanceRole) {
		return getHeader(target, instanceRole);
	}
		
	/**
	 * Removes a step from the sequence view.
	 * First obtains the headers from the responsibilities source and target; gets the step line and removes it from the steps list; then removes the components and updates the buffers and figure. 
	 * 
	 * @param step the step to remove
	 */
	private void removeStep(ExecutionStep step) {
		steps.remove(step);
		
		//steps start at 1
		SequenceViewHeader source = getSourceResponsibilityNumber(step.getSource(), Integer.parseInt(step.getExecutionContext().getCurrentStep()) - 1, step.getInstanceComponentToSource());
		SequenceViewHeader target = getTargetResponsibilityNumber(step.getTarget(), step.getInstanceComponentToTarget());			
		if (source != null && target != null) {
			String line = getBodyLine(source.getNumber(), target.getNumber(), step.getDependency().getType(), step.getTarget().getName());			
			if (stepsList.remove(line)) {
				removeComponent(source.getNumber());
				removeComponent(target.getNumber());
				updateStringBuffers();
			}
		}
	}
	
	/**
	 * Updates the footer buffer with the footer list.
	 *
	 */
	private void updateFooterBuffer() {
		footerBuffer.delete(0, footerBuffer.capacity());
		for(Iterator iter=footerList.iterator(); iter.hasNext();)
			footerBuffer.append(getFooterLine((SequenceViewFooter) iter.next()));
	}
	
	/**
	 * Updates the header buffer with the header list.
	 *
	 */
	private void updateHeaderBuffer() {
		headerBuffer.delete(0, headerBuffer.capacity());
		for(Iterator iter=headerList.iterator(); iter.hasNext();)
			headerBuffer.append(getHeaderLine((SequenceViewHeader) iter.next()));
	}
	
	/**
	 * Updates the body buffer with the steps list.
	 *
	 */
	private void updateBodyBuffer() {
		bodyBuffer.delete(0, bodyBuffer.capacity());
		for(Iterator iter=stepsList.iterator(); iter.hasNext();)
			bodyBuffer.append((String) iter.next());		
	}
	
	/**
	 * Updates the string buffers and the figure.
	 *
	 */
	private void updateStringBuffers() {
		updateHeaderBuffer();
		updateBodyBuffer();
		updateFooterBuffer();		
		updateFigure();
	}
	
	/**
	 * Decremets the reference for the header, if the references are 0, this component is removed from the map, and the footer is updated.
	 * 
	 * @param number the component number
	 */
	private void removeComponent(int number) {
		int index = number - 1;
		if (index < 0  || index >= headerList.size())
			return;
		
		SequenceViewHeader svc = headerList.get(index);
		svc.decReferences();
		if (svc.getReferences() == 0) {
			removeFromMap(svc);
			headerList.remove(index);
			removeFooter(number);
		}
	}	
	
	/**
	 * 
	 * Removes the SequenceViewHeader from the map.
	 * 
	 * @param removedHeader the removed SequenceViewHeader
	 */
	private void removeFromMap(SequenceViewHeader removedHeader) {
		for(Iterator iter=nodeToHeader.keySet().iterator(); iter.hasNext();) {
			Object o = iter.next();
			SequenceViewHeader svh = nodeToHeader.get(o);
			if (svh == removedHeader) {
				nodeToHeader.remove(o);
				break;
			}
		}		
	}
	
	/**
	 * Updates the footer list extracting the componet number that was removed.
	 * 
	 * @param number the component number that was removed
	 */
	private void removeFooter(int number) {
		int index = 0;
		for(Iterator iter=footerList.iterator(); iter.hasNext();) {
			SequenceViewFooter svf = (SequenceViewFooter) iter.next();
			if (number >= svf.getSource() && number <= svf.getTarget()) {
				svf.setTarget(svf.getTarget() - 1);
				if (svf.getSource() > svf.getTarget())
					footerList.remove(index);
				break;
			}
			index++;
		}		
	}
	
	/**
	 * Goes back to a step. All the steps beetween the last step and the given are removed.
	 * The gives step is not removed.
	 * 
	 * @param step the step to go back to
	 */
    private void backToStep(ExecutionStep step) {
    	if (steps.size() <= 0)
    		return;
    	
    	ExecutionStep actualStep = steps.get(steps.size() - 1);
    	while(actualStep != step && steps.size() > 0) {    		
    		removeStep(actualStep);
    		actualStep = steps.get(steps.size() - 1);
    	}    	
    }
	
	/**
	 * Adapter implementation
	 */
	public void internalNotifyChanged(Notification notification) {
		if (notification.getNotifier() instanceof ExecutionInfo) {
			switch (notification.getFeatureID(ExecutionmodelPackage.class)) {
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
					if (newStep.getEnabled() == ExecutionContext.enabled_Step)
						addNewStep(newStep);
				}
				break;
				
			case ExecutionmodelPackage.EXECUTION_INFO__RESET:
				if (notification.getEventType() == Notification.SET) {
					changeExecutionInfo();
				}
				break;
			}
		} else
			if (notification.getEventType() == Notification.SET)
				switch (notification.getFeatureID(ExecutionmodelPackage.class)) {
					case ExecutionmodelPackage.EXECUTION_INFO_MANAGER__CURRENT_EXECUTION:
						changeExecutionInfo();
						break;
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

	public Notifier getTarget() {
		return getCastedModel();
	}

	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	public boolean isAdapterForType(Object type) {
		return ExecutionInfoManager.class.isAssignableFrom((Class)type);
	}
	
	/**
	 * Factory used to translate a line style in a string used to represent the line style in the SequenceDiagram figure.
	 * 
	 * @author usuario
	 *
	 */
	static class DependecyToArrowFactory {
		private static final Map<Integer, String> arrows = new HashMap<Integer, String>();
		
		static {
			arrows.put(new Integer(SWT.LINE_SOLID), "->"); //$NON-NLS-1$
			arrows.put(new Integer(SWT.LINE_DOT), "->>"); //$NON-NLS-1$
			arrows.put(new Integer(SWT.LINE_DASH), ".>>"); //$NON-NLS-1$
		}
		
		public static String getArrow(Integer lineStyle) {
			String arrow = arrows.get(lineStyle);
			if (arrow == null)
				arrow = "->"; //$NON-NLS-1$
			return arrow;
		}		
	}
	
	/**
	 * This class is used to represent a component in the SequenceView.
	 * It has its name, number (position in the sequence) and references (number of arrows leaving or entering this component) 
	 * 
	 * @author usuario
	 */
	class SequenceViewHeader {
		private int number;
		private int references;
		private String name;
		
		public SequenceViewHeader(int number, int references, String name) {
			this.number = number;
			this.references = references;
			this.name = name;
		}
		
		public int getNumber() {
			return number;
		}
		
		public int getReferences() {
			return references;
		}
		
		public void incReferences() {
			references++;
		}
		
		public void decReferences() {
			references--;
		}
		
		public String getName() {
			return name;
		}
	}
	
	/**
	 * This class is used to reprensent a group of component in a UCM diagram. 
	 * 
	 * @author usuario
	 */
	class SequenceViewFooter {
		private UseCaseMap map;
		private int source;
		private int target;
		
		public SequenceViewFooter(int source, int target, UseCaseMap map) {
			this.source = source;
			this.target = target;
			this.map = map;
		}
		
		public int getSource() {
			return  source;
		}
		
		public int getTarget() {
			return  target;
		}
		
		public void setSource(int source) {
			this.source = source;
		}
		
		public void setTarget(int target) {
			this.target = target;
		}
				
		public UseCaseMap getUseCaseMap() {
			return map;
		}
		
		public String getName() {
			if (map != null)
				return map.getName();
			return ""; //$NON-NLS-1$
		}
	}
}