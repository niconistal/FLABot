/**
 * $Id: CurveDiagramLayer.java,v 1.33 2006/03/30 00:59:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.figures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.ConnectionLayer;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.coremodel.ForkNode;
import org.isistan.flabot.coremodel.JoinNode;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.edit.editor.figures.FixedConnectionAnchor;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;

import com.graphbuilder.curve.ControlPath;
import com.graphbuilder.curve.GroupIterator;
import com.graphbuilder.curve.MultiPath;
import com.graphbuilder.curve.NaturalCubicSpline;

/**
 * @author $Author: franco $
 *
 */
public class CurveDiagramLayer extends ConnectionLayer {
	
	float[] maxPoint = new float[2];
	float[] minPoint = new float[2];
	float[] bounds = new float[4];
	
	private Path pathAux = new Path(Display.getCurrent());
	private HashMap table = new HashMap();	
	private List initialVisuals = new ArrayList();	
	private List joinsVisited = new ArrayList();	
	private HashMap lastFigures = new HashMap();
	
	public CurveDiagramLayer() {		
		if (!SWT.getPlatform().startsWith("gtk")) // workaround for bug 0000648 //$NON-NLS-1$
			setAntialias(SWT.ON);
	}
	
	public Color getBackgroundColor() {
		return ColorConstants.black;
	}
	
	public Color getForegroundColor() {
		return ColorConstants.black;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		outlineShape(g);
	}
	
	private void collectStartEnds(List parts, List startsSematics, List endSemantics) {
		for (Iterator iter = parts.iterator(); iter.hasNext();) {
			AbstractGraphicalEditPart part = (AbstractGraphicalEditPart) iter.next();
			collectStartEnds(part.getChildren(), startsSematics, endSemantics);
			VisualModel visual = (VisualModel) part.getModel();
			if (startsSematics.contains(visual.getSemanticModel()))				
				initialVisuals.add(visual);
			else {
				if (endSemantics.contains(visual.getSemanticModel()))
					lastFigures.put(visual, part.getFigure());
				
			}
		}
	}
	
	protected void outlineShape(Graphics g) {
		drawPaths(g);
	}
	
	public void updateInicial(List parts, List startsSematics, List endSemantics) {
		updateInicialPath(parts, startsSematics, endSemantics);
		updateBounds();
		repaint();
	}
	
	private void updateBounds() {
		minPoint[0] = 0; minPoint[1] = 0;
		maxPoint[0] = 0; maxPoint[1] = 0;
		
		float[] bounds = new float[4];
		for (Iterator inicials = table.keySet().iterator(); inicials.hasNext(); ){
			NodeVisualModel visual = (NodeVisualModel) inicials.next();
			List list = (List)table.get(visual);
			if (list != null) {
				for (Iterator path = list.iterator(); path.hasNext(); ) {
					Path multipath = (Path) path.next();
					multipath.getBounds(bounds);
					
					minPoint[0] = Math.min(minPoint[0], bounds[0]);
					minPoint[1] = Math.min(minPoint[1], bounds[1]);
					
					maxPoint[0] = Math.max(maxPoint[0], bounds[0] + bounds[2]);
					maxPoint[1] = Math.max(maxPoint[1], bounds[1] + bounds[3]);
				}
			}
		}
	}
	
	protected void updateInicialPath(List parts, List startsSematics, List endSemantics) {	
		lastFigures.clear();
		initialVisuals.clear();
		joinsVisited.clear();
		collectStartEnds(parts, startsSematics, endSemantics);		
		
		for (int i=0; i<initialVisuals.size(); i++) {		
			NodeVisualModel visual = (NodeVisualModel)initialVisuals.get(i);
			
			ControlPath cp = new ControlPath(); 
			cp.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+visual.getSize().getWidth()/2,visual.getAbsoluteLocation().getY()+visual.getSize().getHeight()/2));		
			
			if (table.containsKey(visual)) {
				List list = (List)table.get(visual);
				if (list != null) {
					for (Iterator path = list.iterator(); path.hasNext(); ){
						Path p = (Path) path.next();
						p.dispose();
					}
					list = new ArrayList();
				}
			}
			
			if (visual.getSourceConnections().size() > 0) {
				ConnectionVisualModel connection = (ConnectionVisualModel)visual.getSourceConnections().get(0);
				table.put(visual, updatePath(connection, cp));
			} else
				table.remove(visual);		
		}
	}
	
	protected ConnectionVisualModel getTargetConnectionVisualModelForModel(List connections, Object model) {
		for(Iterator iter=connections.iterator(); iter.hasNext();) {
			ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
			if (c.getTarget() != null 
					&& c.getTarget().getSemanticModel() == model)
				return c;
		}
		return null;
	}
	
	protected List updateForkPaths(NodeVisualModel visual) {
		List list = new ArrayList();		
		PathNode pathNode = (PathNode) visual.getSemanticModel();
		if (pathNode.uGetNext().size() > 1) {
			for (int i=0; i < pathNode.uGetNext().size(); i++)
			{
				ResponsibilityNode node = (ResponsibilityNode) pathNode;
				ConnectionVisualModel connection = getTargetConnectionVisualModelForModel(visual.getSourceConnections(), pathNode.uGetNext().get(i));
				if (connection != null) {
					FixedConnectionAnchor anchor = ThreeConnectionFigure.getAnchor(visual.getRotation(), connection.getSourceTerminal(), node.getOutputsCount()); 
					ControlPath cp= new ControlPath();
					cp.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+anchor.offsetH,visual.getAbsoluteLocation().getY()+anchor.offsetV));		
					list.addAll(updatePath(connection, cp));
				}
			}
			
//			ConnectionVisualModel connection1 = getTargetConnectionVisualModelForModel(visual.getSourceConnections(), pathNode.uGetNext().get(0));
//			if (connection1 != null) {
//				FixedConnectionAnchor anchor1 = ThreeConnectionFigure.getAnchor(visual.getRotation(), connection1.getSourceTerminal()); 
//				ControlPath cp1= new ControlPath();
//				cp1.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+anchor1.offsetH,visual.getAbsoluteLocation().getY()+anchor1.offsetV));		
//				list.addAll(updatePath(connection1, cp1));
//			}
//			
//			ConnectionVisualModel connection2 = getTargetConnectionVisualModelForModel(visual.getSourceConnections(), pathNode.uGetNext().get(1));
//			if (connection2 != null) {				
//				FixedConnectionAnchor anchor2 = ThreeConnectionFigure.getAnchor(visual.getRotation(), connection2.getSourceTerminal());			
//				ControlPath cp2= new ControlPath();
//				cp2.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+anchor2.offsetH,visual.getAbsoluteLocation().getY()+anchor2.offsetV));
//				list.addAll(updatePath(connection2, cp2));
//			}
		}
		return list;
	}
	
	protected List updateJoinPaths(NodeVisualModel visual) {
		List list = new ArrayList();				
		PathNode pathNode = (PathNode) visual.getSemanticModel();
		if (pathNode.uGetNext().size() == 1) {
			joinsVisited.add(visual);
			ConnectionVisualModel connection = getTargetConnectionVisualModelForModel(visual.getSourceConnections(), pathNode.uGetNext().get(0));
			if (connection != null) {
				JoinNode joinNode = (JoinNode) pathNode;
				if (connection.getSourceTerminal() != "")
				{
					FixedConnectionAnchor anchor = ThreeConnectionFigure.getAnchor(visual.getRotation(), connection.getSourceTerminal(), joinNode.getInputsCount()); 
					ControlPath cp1= new ControlPath();
					cp1.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+anchor.offsetH,visual.getAbsoluteLocation().getY()+anchor.offsetV));		
					list.addAll(updatePath(connection, cp1));
				}
			}
		}
		return list;
	}
	
	protected PathPointFigure getCorrectLastFigure(NodeVisualModel lastNode) {		
		return (PathPointFigure)lastFigures.get(lastNode);
	}
		
	private boolean isForkNode(NodeVisualModel visual) {
		PathNode p = (PathNode) visual.getSemanticModel();
		if (p != null)
			return (p.uGetNext().size() > 1);
		return false;
	}
	
	private boolean isJoinNode(NodeVisualModel visual) {
		PathNode p = (PathNode) visual.getSemanticModel();
		if (p != null)
			return (p.uGetPrevious().size() > 1);
		return false;		
	}
	
	protected List updatePath(ConnectionVisualModel conn, ControlPath cp) {
		List list = new ArrayList();
		
		NodeVisualModel visual = null;
		while (conn != null && conn.getTarget() != null) {
			visual = conn.getTarget();
			if (isForkNode(visual)) {
				ResponsibilityNode node = (ResponsibilityNode) visual.getSemanticModel();
				FixedConnectionAnchor anchor = ThreeConnectionFigure.getAnchor(visual.getRotation(), conn.getTargetTerminal(), node.getOutputsCount());
				if (anchor != null) {
					cp.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+anchor.offsetH,visual.getAbsoluteLocation().getY()+anchor.offsetV));
					list.addAll(updateForkPaths(visual));
				}
				break;
			}
			
			if (isJoinNode(visual)) {
				JoinNode joinNode = (JoinNode) visual.getSemanticModel();
				FixedConnectionAnchor anchor = ThreeConnectionFigure.getAnchor(visual.getRotation(), conn.getTargetTerminal(), joinNode.getInputsCount());
				if (anchor != null) {
					cp.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+anchor.offsetH,visual.getAbsoluteLocation().getY()+anchor.offsetV));
					if (!joinsVisited.contains(visual))
						list.addAll(updateJoinPaths(visual));
				}
				break;
			}				
			
			cp.addPoint(PointFactory.createPoint(visual.getAbsoluteLocation().getX()+(visual.getSize().getWidth()/2),visual.getAbsoluteLocation().getY()+(visual.getSize().getHeight()/2)));
			
			List connections = visual.getSourceConnections();
			if (connections != null && connections.size() > 0)
				conn = (ConnectionVisualModel)connections.get(0);
			else
				conn = null;
		}
		
		if (visual != null) {
			SimplePathNode spn = (SimplePathNode)visual.getSemanticModel();
			if (spn != null && spn.isEnd()) {
				if (visual.getTargetConnections().size() > 0) {
					ConnectionVisualModel connection = getCorrectEndConnection(visual.getTargetConnections(), spn);
					NodeVisualModel previous = connection.getSource();
					NodeVisualModel last = connection.getTarget();
					if (previous!= null && last != null) {
						double denom =  (previous.getAbsoluteLocation().getY() - last.getAbsoluteLocation().getY());
						PathPointFigure lastFigure  = getCorrectLastFigure(last);
						if (lastFigure != null) {
							double pendiente = lastFigure.getSize().height / 2;
							if (denom != 0 )
								pendiente = - ((previous.getAbsoluteLocation().getX() - last.getAbsoluteLocation().getX())) / denom; 
							lastFigure.setSlope(pendiente);
						}
					}
				}
			}					
		}
		
		GroupIterator gi = new GroupIterator("0:n-1", cp.numPoints()); //$NON-NLS-1$
		NaturalCubicSpline nat = new NaturalCubicSpline(cp,gi);
		cp.addCurve(nat);
	
		MultiPath multiPath = new MultiPath(2); 
		nat.appendTo(multiPath);
		
		Path drawPath = new Path(Display.getCurrent());
		for (int i=0; i<multiPath.getNumPoints(); i++) {
			double[] d = multiPath.get(i);
			if (multiPath.getType(i) == MultiPath.MOVE_TO) {
				drawPath.moveTo((float)d[0], (float)d[1]);
			} else {
				drawPath.lineTo((float)d[0], (float)d[1]);
			}
		}
		
		list.add(drawPath);
		return list;		
	}
	
	private ConnectionVisualModel getCorrectEndConnection(List connections, SimplePathNode spn) {
		for (Iterator iter = connections.iterator(); iter.hasNext(); ) {
			ConnectionVisualModel visual = (ConnectionVisualModel) iter.next();
			if (visual.getTarget().getSemanticModel() == spn)
				return visual;
		}
		return null;
	}
	
	public Rectangle getFreeformExtent() {
		return super.getFreeformExtent().union((int)maxPoint[0] + 15, (int)maxPoint[1] + 15).union((int)minPoint[0] - 15, (int)minPoint[1] - 15);
	}
		
	protected void drawPaths(Graphics g) {
		drawAux(g);
		for (Iterator inicials = table.keySet().iterator(); inicials.hasNext(); ) {
			NodeVisualModel visual = (NodeVisualModel) inicials.next();
			List list = (List)table.get(visual);
			if (list != null) {
				for (Iterator path = list.iterator(); path.hasNext(); ) {
					Path multipath = (Path) path.next();
					if (!multipath.isDisposed()) {
						g.setForegroundColor(Util.getSWRColor(Display.getCurrent(), visual.getForegroundColor()));
						g.setLineWidth(visual.getLineWidth());
						g.setLineStyle(visual.getLineStyle());												
						g.drawPath(multipath);
					}
				}
			}
		}
		drawAux(g);
	}
	
	private void drawAux(Graphics g) {
		g.setForegroundColor(ColorConstants.black);
		g.setLineWidth(1);
		g.setLineStyle(SWT.LINE_CUSTOM);												
		g.drawPath(pathAux);
	}
}