/**
 * $Id: MoveResponsibilityOutComponent.java,v 1.3 2006/03/21 01:51:55 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;
import org.isistan.flabot.edit.ucmeditor.figures.ResponsibilityNodeFigure;
import org.isistan.flabot.messages.Messages;

/**
 * @author $Author: franco $
 *
 */
public class MoveResponsibilityOutComponent extends Command {
	private Diagram diagram;
	private VisualModel visual;
	private Point oldPoint;
	private Point newPoint;
	private List components;
	
	public MoveResponsibilityOutComponent(Diagram diagram, VisualModel visual, Point location) {
		this.diagram = diagram;
		this.visual = visual;
		this.oldPoint = Util.getDraw2DPoint(visual.getLocation());
		this.newPoint = location.getCopy();
		setLabel(Messages.getString("org.isistan.flabot.edit.ucmeditor.commands.visual.MoveResponsibilityOutComponent.label")); //$NON-NLS-1$
	}
	
	public boolean canExecute() {
		return (diagram != null && visual != null && oldPoint != null);
	}
	
	public void execute() {
		processLocation();
		redo();
	}
	
	private void processLocation() {
		while(!isValidLocation(newPoint))
			newPoint.y -= 30;
	}
	
	private boolean isValidLocation(Point location) {	
		List children = getComponents(); 
		for (Iterator iter=children.iterator(); iter.hasNext();) {
			VisualModel child = (VisualModel)iter.next();
			Rectangle r = new Rectangle(new Point(child.getLocation().getX(), child.getLocation().getY()),
					                    new Dimension(child.getSize().getWidth(), child.getSize().getHeight()));
			if (r.intersects(new Rectangle(location, ResponsibilityNodeFigure.defaultsize)))
				return false;
		}
		return true;
	}
	
	private List getComponents() {
		if (components == null)
			components = makeComponentList();
		return components;
	}
	
	private List makeComponentList() {
		components = new ArrayList();
		List children = visual.getDiagram().getChildren(); 
		for (Iterator iter=children.iterator(); iter.hasNext();) {
			VisualModel child = (VisualModel)iter.next();			
			if  (child.getSemanticModel() instanceof ComponentRole)				
				components.add(child);
		}
		return components;
	}

	public void redo() {
		org.isistan.flabot.edit.editormodel.Point p = EditormodelFactory.eINSTANCE.createPoint();
		p.setX(newPoint.x);
		p.setY(newPoint.y);
		visual.setLocation(p);
	}

	public void undo() {	
		org.isistan.flabot.edit.editormodel.Point p = EditormodelFactory.eINSTANCE.createPoint();
		p.setX(oldPoint.x);
		p.setY(oldPoint.y);
		visual.setLocation(p);
	}
}