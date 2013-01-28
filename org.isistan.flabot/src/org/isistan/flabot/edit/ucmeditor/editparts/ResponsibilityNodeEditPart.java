/**
 * $Id: ResponsibilityNodeEditPart.java,v 1.44 2006/05/08 23:23:46 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editor.commands.SetDetailLevelCommand;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.model.DeleteResponsibilityNodeAssociationsCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.MoveResponsibilityOutComponent;
import org.isistan.flabot.edit.ucmeditor.commands.visual.ResponsibilityNodeReparentCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions.HideAllConditionsCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions.HideConditionCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions.ShowAllConditionsCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.visualconditions.ShowConditionCommand;
import org.isistan.flabot.edit.ucmeditor.figures.ResponsibilityNodeFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class ResponsibilityNodeEditPart extends PathNodeEditPart {
		
	private CoreModel coreModel;
	
	public void activate() {
		if (!isActive()) {
			super.activate();
			// Listen to responsibility state changes			
			if (getCastedModel().getDiagram() != null) {
				coreModel = getCastedModel().getDiagram().getCoreModel();
				hookIntoModel(coreModel);
			}
			hookCondition(((ResponsibilityNode) getSemanticModel()).getResponsibility().getPreconditions());
			hookCondition(((ResponsibilityNode) getSemanticModel()).getResponsibility().getPostconditions());
		}
	}
	
	private void hookCondition(List conditions) {
		for (Iterator iter=conditions.iterator(); iter.hasNext();)
			hookIntoModel((Condition) iter.next());
	}
	
	private void unhookCondition(List conditions) {
		for (Iterator iter=conditions.iterator(); iter.hasNext();)
			unhookFromModel((Condition) iter.next());
	}
	
	public void deactivate() {
		if (isActive()) {
			super.deactivate();
			
			unhookCondition(((ResponsibilityNode) getSemanticModel()).getResponsibility().getPreconditions());
			unhookCondition(((ResponsibilityNode) getSemanticModel()).getResponsibility().getPostconditions());
			unhookFromModel(coreModel);
		}
	}	
		
	protected AbstractGraphicalEditPart getCorrectParent() {
		AbstractGraphicalEditPart part = (AbstractGraphicalEditPart) getParent();
		if (getCastedModel().getParent() != null)
			part = (AbstractGraphicalEditPart)part.getParent();
		return part;
	}
	
	@Override
	protected IFigure createFigure() {		
		ResponsibilityNode rn = (ResponsibilityNode)getCastedModel().getSemanticModel();
		ResponsibilityNodeFigure f = new ResponsibilityNodeFigure(getCorrectParent().getFigure(), Util.getSWTRGB(getCastedModel().getForegroundColor()));
		f.setResponsibilityName(rn.getResponsibility().getName());
		return f;
	}
	
	protected Command getDeletePathNodeCommand()  {
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.ResponsibilityNodeEditPart.deleteVisualCommandLabel")); //$NON-NLS-1$
		commands.add(new SetDetailLevelCommand(getCastedModel(), VisualModel.LOW_DETAIL));
		commands.add(new DeleteResponsibilityNodeAssociationsCommand(coreModel, (ResponsibilityNode)getCastedModel().getSemanticModel()));
		commands.add(super.getDeletePathNodeCommand());
		return commands;
	}
	
	private ResponsibilityNodeFigure getCastedFigure() {
		return (ResponsibilityNodeFigure) getFigure();
	}
			
	protected void refreshVisuals() {
		// notify parent container of changed position & location
		// if this line is removed, the XYLayoutManager used by the parent container 
		// (the Figure of the DiagramEditPart), will not know the bounds of this figure
		// and will not draw it correctly.
		Rectangle bounds = new Rectangle(new Point(getCastedModel().getLocation().getX(), getCastedModel().getLocation().getY()),
				new Dimension(getCastedModel().getSize().getWidth(), getCastedModel().getSize().getHeight()));
		((GraphicalEditPart) getParent()).setLayoutConstraint(this, getFigure(), bounds);
	}
		
	private void updateDetailLevel(int level) {
		FlabotFileModel ffm = getCastedModel().getDiagram().getCoreModel().getFile();
		switch(level) {
			case VisualModel.LOW_DETAIL:
				new HideAllConditionsCommand(ffm, getCastedModel()).execute();
				break;
			case VisualModel.MEDIUM_DETAIL:
				new HideAllConditionsCommand(ffm, getCastedModel()).execute();
				break;
			case VisualModel.HIGH_DETAIL:
				new ShowAllConditionsCommand(ffm, getCastedModel()).execute();
				break;
		}
	}
	
	public void notifyChanged(Notification notification) {		
		int type = notification.getEventType();		
				
		int featureID = notification.getFeatureID(CoremodelPackage.class);
		
		if (notification.getNotifier() instanceof ComponentModel) {
			//If the responsibiliy was removed from a Component.
			if ((type == Notification.REMOVE && featureID == CoremodelPackage.COMPONENT_MODEL__FEATURES)) {				
				if (getCastedModel().getDiagram() != null && notification.getOldValue() == ((ResponsibilityNode)getCastedModel().getSemanticModel()).getResponsibility()) {
					Rectangle bounds = new Rectangle(getCastedModel().getAbsoluteLocation().getX(), getCastedModel().getParent().getLocation().getY() - 20, 0, 0);
					Command c = new ResponsibilityNodeReparentCommand(null, getCastedModel(), bounds);
					c = c.chain(new MoveResponsibilityOutComponent(getCastedModel().getParent().getDiagram(), getCastedModel(), bounds.getLocation()));
					appendToLastAndExecuteCommand(c);
				}				
			}
			return;
		}
		
		if (notification.getNotifier() instanceof CoreModel) {
			if (type == Notification.REMOVE && featureID == CoremodelPackage.CORE_MODEL__RESPONSIBILITIES) {
				if (getCastedModel().getDiagram() != null && getCastedModel().getSemanticModel() != null && notification.getOldValue() == ((ResponsibilityNode)getCastedModel().getSemanticModel()).getResponsibility()) {
					appendToLastAndExecuteCommand(getDeletePathNodeCommand());
				}
			}
			return;
			
		}
		
		if (notification.getNotifier() instanceof ResponsibilityNode) {		
			//If notifier is not VisualModel		
			if (type ==Notification.SET)
				switch (featureID){					
				case CoremodelPackage.RESPONSIBILITY_NODE__PATH:
					if (notification.getNewValue() == null)
						getCastedFigure().clear();
					break;						
				
				case CoremodelPackage.RESPONSIBILITY_NODE__RESPONSIBILITY:
					getCastedFigure().setResponsibilityName(((ResponsibilityNode)getCastedModel().getSemanticModel()).getResponsibility().getName());
					break;								
				}			
			return;
		}
		
		if (notification.getNotifier() instanceof Responsibility) {
			switch (featureID){	
			case CoremodelPackage.RESPONSIBILITY__PRECONDITIONS:
			case CoremodelPackage.RESPONSIBILITY__POSTCONDITIONS:
				if (type ==Notification.ADD) {
					Condition newCondition = (Condition) notification.getNewValue();
					updatedConditionAdded(newCondition, newCondition.getDependencyResponsibility());
					hookIntoModel(newCondition);
					break;
				}
				if (type ==Notification.REMOVE) {
					Condition oldCondition = (Condition) notification.getOldValue();
					updatedConditionRemoved(oldCondition, oldCondition.getDependencyResponsibility());
					unhookFromModel(oldCondition);
					break;
				}
			case CoremodelPackage.RESPONSIBILITY__NAME:
				getCastedFigure().setResponsibilityName(((ResponsibilityNode)getCastedModel().getSemanticModel()).getResponsibility().getName());
				break;
			}
			return;
		}
		
		if (notification.getNotifier() instanceof Condition) {
			switch (featureID){			
			case CoremodelPackage.CONDITION__USE_CASE_MAP:
			case CoremodelPackage.CONDITION__TYPE:
				if (type ==Notification.SET) {
					Condition c = (Condition) notification.getNotifier();
					updatedConditionRemoved(c, c.getDependencyResponsibility());
					updatedConditionAdded(c, c.getDependencyResponsibility());
					break;
				}

			case CoremodelPackage.CONDITION__DEPENDENCY_RESPONSIBILITY:			
				if (type ==Notification.SET) {
					Condition c = (Condition) notification.getNotifier();
					updatedConditionRemoved(c, (ResponsibilityNode) notification.getOldValue());
					updatedConditionAdded(c, (ResponsibilityNode) notification.getNewValue());
					break;
				}
			}
			return;
		}
		
		//VisualModel
		switch (type){
			case Notification.REMOVING_ADAPTER:
				getCastedFigure().clear();
				break;
			case Notification.SET: {
				if (notification.getFeatureID(EditormodelPackage.class) == EditormodelPackage.VISUAL_MODEL__DETAIL_LEVEL)					
					if (notification.getOldIntValue() != notification.getNewIntValue())
						updateDetailLevel(notification.getNewIntValue());
			}				
		}
		
		super.notifyChanged(notification);
	}

	/**
	 * Returns the correct UCM diagram that has associated the map in a flabot file model, otherwise returns null.
	 * 
	 * @param model the flabot file model
	 * @param map the use case map to look for
	 * @return the correct UCM diagram that has associated the map in the flabot file model, otherwise return null.
	 */
	protected Diagram getCorrectDiagram(FlabotFileModel model, UseCaseMap map) {
		for(Iterator iter=model.getDiagrams().iterator(); iter.hasNext();) {
			Diagram d = (Diagram) iter.next();
			if (d instanceof UCMDiagram) {
				if (((UCMDiagram)d).getMap() == map)
					return d;
			}
		}
		return null;
	}
	
	/**
	 * Resturns the visual model that has as its semantic model the parameter model.
	 * It is a recursive function that will look in all children's sons.
	 * 
	 * @param children the list of visual models
	 * @param model the model 
	 * @return the visual model that has as its semantic model the parameter model
	 */
	protected VisualModel getVisualForModel(List children, Object model) {
		VisualModel retVisual = null;
		for (Iterator iter=children.iterator(); iter.hasNext() && retVisual == null;) {
			VisualModel visual = (VisualModel) iter.next();
			if (visual.getSemanticModel() == model)
				retVisual = visual;
			else
				retVisual = getVisualForModel(visual.getChildren(), model);
		}		
		return retVisual;
	}
	
	private void updatedConditionAdded(Condition c, ResponsibilityNode target) {
		if (getCastedModel().getDetailLevel() ==  VisualModel.HIGH_DETAIL) {
			Diagram diagram = getCorrectDiagram(getCastedModel().getDiagram().getCoreModel().getFile(), target.getMap());
			if (diagram != null) {						
				NodeVisualModel targetVisualModel = (NodeVisualModel) getVisualForModel(diagram.getChildren(), target);
				new ShowConditionCommand(getCastedModel(), c, targetVisualModel).execute();
			}
		}
	}
	
	private void updatedConditionRemoved(Condition c, ResponsibilityNode target) {
		if (getCastedModel().getDetailLevel() ==  VisualModel.HIGH_DETAIL) {
			NodeVisualModel targetVisualModel = null;
			Diagram diagram = getCorrectDiagram(getCastedModel().getDiagram().getCoreModel().getFile(), target.getMap());
			if (diagram != null)						
				targetVisualModel = (NodeVisualModel) getVisualForModel(diagram.getChildren(), target);
			new HideConditionCommand(getCastedModel(), c, targetVisualModel).execute();
		}
	}
}