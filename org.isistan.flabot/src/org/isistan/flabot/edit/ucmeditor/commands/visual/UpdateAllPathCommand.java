/**
 * $Id: UpdateAllPathCommand.java,v 1.1 2006/03/09 21:37:21 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.visual;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.edit.editormodel.ConnectionVisualModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;

/**
 * 
 * @author $Author: franco $
 *
 */
public abstract class UpdateAllPathCommand extends Command {
	
	//Can have Note Connections
	private boolean isValid(EObject path, List list) {	
		for (Iterator iter=list.iterator(); iter.hasNext();) {
			EObject p = (EObject) iter.next();
			if (path == p)
				return true;
		}
		return false;
	}
	
	/**
	 * Changes the semantic path from oPath to nPath. The changes are applied to visual and semantic models of the original path.
	 * Starts from a visual node and moves to the previous one. 
	 * 
	 * @param visualNode the visual node to start
	 * @param oPath the old path
	 * @param nPath the new path
	 */
	protected void updatePrevious(NodeVisualModel visualNode, Path oPath, Path nPath, List visited) {
		visited.add(visualNode);
		
		List previous = visualNode.getTargetConnections();
		PathNode semanticNode = (PathNode) visualNode.getSemanticModel();
		
		if (previous.size() == 0 || semanticNode.uGetPrevious().size() == 0) {
			semanticNode.setPath(nPath);
			oPath.getStartNodes().remove(semanticNode);
			oPath.getNodes().remove(semanticNode);
			nPath.getStartNodes().add(semanticNode);
			nPath.getNodes().add(semanticNode);
		} else {
		
			for (Iterator iter=previous.iterator(); iter.hasNext();) {
				ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
				if (!visited.contains(c.getSource()) && isValid(c.getSource().getSemanticModel(), semanticNode.uGetPrevious())) {
					PathNode prev = (PathNode) c.getSource().getSemanticModel();
					prev.setPath(nPath);
					oPath.getNodes().remove(prev);
					nPath.getNodes().add(prev);						
					c.setSemanticModel(nPath);
				
					if (prev.uGetNext().size() > 1) {
						List nexts = c.getSource().getSourceConnections();
						for (Iterator iterNexts=nexts.iterator(); iterNexts.hasNext();) {
							ConnectionVisualModel cc = (ConnectionVisualModel) iterNexts.next();
							if (!visited.contains(cc.getTarget()) && semanticNode != cc.getTarget().getSemanticModel()) {
								PathNode nextSemantic = (PathNode) cc.getTarget().getSemanticModel();
								nextSemantic.setPath(nPath);
								cc.setSemanticModel(nPath);
								oPath.getNodes().remove(nextSemantic);
								nPath.getNodes().add(nextSemantic);		
								updateNexts(cc.getTarget(), oPath, nPath, visited);
							}
						}
					}
					updatePrevious(c.getSource(), oPath, nPath, visited);
				}
			}
		}
	}
	
	/**
	 * Changes the semantic path from oPath to nPath. The changes are applied to visual and semantic models of the original path.
	 * Starts from a visual node and moves to the next one. 
	 * 
	 * @param visualNode the visual node to start
	 * @param oPath the old path
	 * @param nPath the new path
	 */
	protected void updateNexts(NodeVisualModel visualNode, Path oPath, Path nPath, List visited) {
		visited.add(visualNode);
		
		List nexts = visualNode.getSourceConnections();
		PathNode semanticNode = (PathNode) visualNode.getSemanticModel();		
		
		if (nexts.size() == 0 || semanticNode.uGetNext().size() == 0) {
			semanticNode.setPath(nPath);
			oPath.getEndNodes().remove(semanticNode);
			oPath.getNodes().remove(semanticNode);
			nPath.getEndNodes().add(semanticNode);
			nPath.getNodes().add(semanticNode);
		} else {
		
			for (Iterator iter=nexts.iterator(); iter.hasNext();) {
				ConnectionVisualModel c = (ConnectionVisualModel) iter.next();
				if (!visited.contains(c.getTarget()) && isValid(c.getTarget().getSemanticModel(), semanticNode.uGetNext())) {
					PathNode next = (PathNode) c.getTarget().getSemanticModel();
					next.setPath(nPath);
					oPath.getNodes().remove(next);
					nPath.getNodes().add(next);			
					c.setSemanticModel(nPath);
				
					if (next.uGetPrevious().size() > 1) {
						List previous = c.getTarget().getTargetConnections();
						for (Iterator iterPrevious=previous.iterator(); iterPrevious.hasNext();) {
							ConnectionVisualModel cc = (ConnectionVisualModel) iterPrevious.next();						
							if (!visited.contains(cc.getSource()) && semanticNode != cc.getSource().getSemanticModel()) {
								PathNode previousSemantic = (PathNode) cc.getSource().getSemanticModel();
								cc.setSemanticModel(nPath);
								previousSemantic.setPath(nPath);
								oPath.getNodes().remove(previousSemantic);
								nPath.getNodes().add(previousSemantic);
								updatePrevious(cc.getSource(), oPath, nPath, visited);
							}
						}
					}			
					updateNexts(c.getTarget(), oPath, nPath, visited);
				}
			}	
		}
	}
}