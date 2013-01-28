/**
 * $Id: InterfaceLinkMappedToPathGeneralConstraint.java,v 1.9 2006/03/29 20:38:47 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.coremodel.constraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.PathNode;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.consistency.Constraint;

/**
 * Constraint entity for checking in all the UCM diagrams if exists a path segment between two component.
 * In addition, these components have an interface relationship.
 * 
 * @author $Author: franco $
 *
 */
public class InterfaceLinkMappedToPathGeneralConstraint implements Constraint {
	
	public static final String CONSTRAINT_KEY = "CoreModel_InterfaceLinkMappedToPathGeneral"; //$NON-NLS-1$

	boolean fault = false;
	HashMap links;
	DiagnosticChain diagnostics;
	
	private class ListNode {
		ComponentModel cm = null;
		boolean valid = false;
		boolean inverted = false;
		
		public ListNode(ComponentModel cm, boolean inverted) {
			this.cm = cm;
			this.inverted = inverted;
		}		
	}
	
	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.Constraint#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		FlabotFileModel ffm = (FlabotFileModel) model;
		fault = false;
		this.diagnostics = diagnostics;
		if (diagnostics != null) {
			List interfacesLinks = ffm.getCoreModel().getInterfaceLinks();
			List importedFiles = ffm.getAllImportedFiles();
			for (Iterator modelsIter = importedFiles.iterator(); modelsIter.hasNext();) {
				FlabotFileModel f = (FlabotFileModel) modelsIter.next();
				interfacesLinks.addAll(f.getCoreModel().getInterfaceLinks());
			}		
			links = getHashMap(interfacesLinks);				
			
			checkMap(ffm.getCoreModel().getUseCaseMaps());
			for (Iterator modelsIter = importedFiles.iterator(); modelsIter.hasNext();) {
				FlabotFileModel f = (FlabotFileModel) modelsIter.next();
				checkMap(f.getCoreModel().getUseCaseMaps());
			}
			checkFinalLinks();
		}
		return fault;
	}
	
	private void checkMap(List maps) {
		for (Iterator iterMaps=maps.iterator(); iterMaps.hasNext();) {
			UseCaseMap map = (UseCaseMap) iterMaps.next();
			List paths = map.getPaths();
			for (Iterator iterPaths=paths.iterator(); iterPaths.hasNext();) {
				Path path = (Path) iterPaths.next();
				visitPath(path);
			}
		}
	}
	
	private void visitPath(Path path) {
		List starts = path.getStartNodes();
		for (Iterator iterStarts = starts.iterator(); iterStarts.hasNext();)
			checkPath((PathNode) iterStarts.next(), null);
	}
	
	private void checkPath(PathNode node, ResponsibilityNode rn)  {
		if (node instanceof ResponsibilityNode) {				
			ResponsibilityNode s = (ResponsibilityNode) node;
			//Ignore ResponsibilityNodes that are not in a ComponentRole
			if (s.getRole() != null) {
				if (rn == null)
					rn = s;
				else {
					if (rn.getRole() != null && rn.getRole().getComponent() != null) {
						ComponentModel source = rn.getRole().getComponent();
						ResponsibilityNode r = (ResponsibilityNode) node;
						if (r.getRole() != null) {
							ComponentModel target = r.getRole().getComponent();
							if (source != null && source != target)
								checkLink(source, target, rn.getResponsibility(), r.getResponsibility(), rn.getMap());
						}
						rn = r;
					}
				}
			}
		}
		for (Iterator iterNexts = node.uGetNext().iterator(); iterNexts.hasNext();)
			checkPath((PathNode)iterNexts.next(), rn);
	}
	
	protected boolean checkComponent(ComponentModel source, ComponentModel target) {
		List targets = (List)links.get(source);
		boolean found = false;
		if (targets != null) {
			for (Iterator iter=targets.iterator(); iter.hasNext()/* && !found*/;) {
				ListNode ln = (ListNode) iter.next();
				if (ln.cm == target) {
					ln.valid = true;
					found = true;
				}
			}
		}
		return found;
	}
	
	protected void checkLink(ComponentModel source, ComponentModel target, Responsibility rnSource, Responsibility rnTarget, UseCaseMap map) {
		boolean found1 = checkComponent(source, target);
		//Need to be executed.
		boolean found2 = checkComponent(target, source);		
		if (!found1 && !found2) {
			diagnostics.add
			(new BasicDiagnostic
				(Diagnostic.WARNING,
				 "org.isistan.flabot.coremodel", //$NON-NLS-1$
				 0,
				 Messages.getString("org.isistan.flabot.coremodel.constraint.InterfaceLinkMappedToPathGeneralConstraint.inferfaceLinkNotFoundBetweenComponents", source.getName(), target.getName(), rnSource.getName(), rnTarget.getName(), map.getName()), //$NON-NLS-1$
				 new Object[] { source }));
			fault = true;
		}
	}	
	
	private void checkFinalLinks() {
		for (Iterator keys=links.keySet().iterator(); keys.hasNext();) {
			ComponentModel source = (ComponentModel)keys.next();
			List list = (List) links.get(source);
			for (Iterator values=list.iterator(); values.hasNext();) {
				ListNode ln = (ListNode) values.next();
				if (!ln.valid && !ln.inverted) {
					diagnostics.add
						(new BasicDiagnostic
								(Diagnostic.WARNING,
								 "org.isistan.flabot.coremodel", //$NON-NLS-1$
								  0,
								  Messages.getString("org.isistan.flabot.coremodel.constraint.InterfaceLinkMappedToPathGeneralConstraint.pathNotFoundBetweenComponents", source.getName(), ln.cm.getName(), source.getName(), ln.cm.getName()), //$NON-NLS-1$
								  new Object[] { source }));
					fault = true;
				}
			}
		}
	}
	
	private HashMap getHashMap(List list) {
		HashMap hash = new HashMap();
		for(Iterator iter=list.iterator(); iter.hasNext();) {
			InterfaceLink link = (InterfaceLink) iter.next();
			ComponentModel source = link.getSource().getPort().getComponent();
			ComponentModel target = link.getTarget().getPort().getComponent();
			hash.put(source, getList((List) hash.get(source), target, false));
			hash.put(target, getList((List) hash.get(target), source, true));			
		}
		return hash;
	}
	
	private List getList(List list, ComponentModel c, boolean inverted) {
		if (list == null)
			list = new ArrayList();
		list.add(new ListNode(c, inverted));
		return list;
	}
}