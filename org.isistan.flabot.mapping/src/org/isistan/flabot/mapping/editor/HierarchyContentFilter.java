package org.isistan.flabot.mapping.editor;

import java.util.HashSet;
import java.util.Set;

import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider.ContentFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.util.TriState;

public class HierarchyContentFilter implements ContentFilter {
	private Mapping[] mappings;
	
	public HierarchyContentFilter(Mapping[] mappings) {
		this.mappings=mappings;
	}
	
	public boolean accept(JWorkspaceClass jClass, boolean hasShowableChildren) {
		if(hasShowableChildren) {
			return true;
		}
		if(accept(jClass, new HashSet<JWorkspaceClass>()))
			return true;
		return false;
	}

	public boolean accept(JWorkspaceClass jClass, Set<JWorkspaceClass> visited) {
		if(visited.contains(jClass)) {
			return false;
		}
		visited.add(jClass);
		for (Mapping mapping : mappings) {
			TriState packagePasses=mapping.passes(jClass.getPackage());
			if(packagePasses==TriState.TRUE || (packagePasses==TriState.UNDEFINED &&
					TriState.toBoolean(mapping.passes(jClass), true))) {
				return true;
			} else {
				JClass superJClass=jClass.getSuperclass();
				if(superJClass!=null) {
					if(accept((JWorkspaceClass)superJClass, visited)) {
						return true;
					}
				}
				for (JClass jInterface : jClass.getInterfaces()) {
					if(accept((JWorkspaceClass)jInterface, visited)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public boolean accept(JBehavior jBehavior, boolean hasShowableChildren) {
		return true;
	}

}
