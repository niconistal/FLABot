package org.isistan.flabot.edit.ucmeditor.editparts;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.DefaultEditDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.views.properties.IPropertySource;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editor.FlabotGraphicalEditor;
import org.isistan.flabot.edit.editor.properties.NamedElementPropertySource;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteTimerCommand;
import org.isistan.flabot.edit.ucmeditor.commands.visual.DeleteWaitingPlaceCommand;
import org.isistan.flabot.edit.ucmeditor.figures.PathPointFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ResponsibilityNodeFigure;
import org.isistan.flabot.edit.ucmeditor.figures.ThreeConnectionFigure;
import org.isistan.flabot.edit.ucmeditor.figures.TimerFigure;
import org.isistan.flabot.edit.ucmeditor.figures.WaitingPlaceFigure;
import org.isistan.flabot.edit.ucmmodel.UCMDiagram;
import org.isistan.flabot.messages.Messages;

/**
 * TimerNodeEditPart:
 * -	Edit part for Timer Nodes.
 * -	Creates the figure that represents the timer using TimerFigure.
 * 
 * @author $Author: Martin Villalba $
 *
 */
public class TimerNodeEditPart extends PathNodeEditPart {
	
	private int timerType = TimerNode.TIMER_TYPE;
	
	@Override
	protected IFigure createFigure() {		
		ThreeConnectionFigure f = null;
		
		TimerNode timerNode = (TimerNode)getCastedModel().getSemanticModel();
		switch(timerNode.getTimerType()) {
			case TimerNode.TIMER_TYPE:
					f = createTimer();
					break;
			case TimerNode.WAITING_PLACE_TYPE:
					f = createWaitingPlace(); 
					break;
		}
		this.timerType = timerNode.getTimerType();
		f.setNamePoint(((TimerNode)getCastedVisualModel().getSemanticModel()).getName());
		
		return f;
	}	
	
	//private ThreeConnectionFigure createTimer() {
	private ThreeConnectionFigure createTimer() {
		TimerFigure f = new TimerFigure(getCastedModel().getRotation(), getCorrectParent().getFigure(),
			  	Util.getSWTRGB(getCastedModel().getForegroundColor()));
		   return f;
	}
	
	private ThreeConnectionFigure createWaitingPlace() {		
		WaitingPlaceFigure f = new WaitingPlaceFigure(getCastedModel().getRotation(),getCorrectParent().getFigure(),
			  	Util.getSWTRGB(getCastedModel().getForegroundColor()));
		   return f;
	}
	
	private Diagram getCorrectDiagram(FlabotFileModel model, UseCaseMap map) {
		for(Iterator iter=model.getDiagrams().iterator(); iter.hasNext();) {
			Diagram d = (Diagram) iter.next();
			if (d instanceof UCMDiagram) {
				if (((UCMDiagram)d).getMap() == map)
					return d;
			}
		}
		return null;
	}
	
	private VisualModel getVisualForModel(List children, Object model) {
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
	
	/**
	 * change notification received
	 */
	public void notifyChanged(Notification notification) {
		
		int featureID = notification.getFeatureID(CoremodelPackage.class);
		
		super.notifyChanged(notification);
		
		switch (notification.getEventType()) {
		case Notification.SET:
		case Notification.UNSET:
			switch(notification.getFeatureID(EditormodelPackage.class)) {
			case EditormodelPackage.NODE_VISUAL_MODEL__ROTATION:
				getCastedFigure().setRotation(getCastedModel().getRotation());
				refreshVisuals();
				break;
			}
		}

		if (notification.getNotifier() instanceof SimplePathNode) {
			if (notification.getEventType() == Notification.SET && featureID == CoremodelPackage.SIMPLE_PATH_NODE__NAME) {
				TimerNode timer = (TimerNode) getCastedModel().getSemanticModel();
				getCastedFigure().setNamePoint(timer.getName());
			}
			return;
		}		
		
		if (notification.getNotifier() instanceof Responsibility) {
			if (featureID == CoremodelPackage.RESPONSIBILITY__NAME){
				TimerNode timer = (TimerNode) getCastedModel().getSemanticModel();
				getCastedFigure().setNamePoint(timer.getName());
			}
			return;
		}	
	}
		
	private void forceDeleteTimer() {
		//if the stub is still in a diagram
		if (getCastedModel().getDiagram() != null && getParent() != null)
			appendToLastAndExecuteCommand(getDeletePathNodeCommand());
	}
	
	protected Command getDeletePathNodeCommand()  {
		CompoundCommand commands = new CompoundCommand(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart.commandLabel"));		 //$NON-NLS-1$
		commands.add(getConnectionsDeleteCommand(getTargetConnections()));
		if (this.getTimerNodeType() == TimerNode.TIMER_TYPE)
			commands.add(new DeleteTimerCommand(getCastedModel()));
		else if (this.getTimerNodeType() == TimerNode.WAITING_PLACE_TYPE)
			commands.add(new DeleteWaitingPlaceCommand(getCastedModel()));
		return commands;
	}

	private ThreeConnectionFigure getCastedFigure() {
		return (ThreeConnectionFigure) getFigure();
	}
	
	private void registerNewNode(SimplePathNode oldNode, SimplePathNode newNode) {
		if (oldNode != newNode) {			
			unhookFromModel(oldNode);
			hookIntoModel(newNode);
			
			Path oldPath = null;
			if (oldNode != null) oldPath = oldNode.getPath();
			Path newPath = null;
			if (newNode != null) newPath = newNode.getPath();		
			
			if (oldPath != newPath){
				hookIntoModel(oldPath);
				unhookFromModel(newPath);				
			}
		}				
	}
	
	public Object getAdapter(Class key) {
		if (IPropertySource.class == key)
			return new NamedElementPropertySource(Messages.getString("org.isistan.flabot.edit.ucmeditor.editparts.TimerNodeEditPart.namePropertyView"), (TimerNode)getCastedModel().getSemanticModel()); //$NON-NLS-1$
		return super.getAdapter(key);
	}
	
	protected AbstractGraphicalEditPart getCorrectParent() {
		AbstractGraphicalEditPart part = (AbstractGraphicalEditPart) getParent();
		if (getCastedModel().getParent() != null)
			part = (AbstractGraphicalEditPart)part.getParent();
		return part;
	}
	
	public int getTimerNodeType()
	{
		return timerType;
	}
	
}