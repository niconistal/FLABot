/**
 * $Id: ClientViewerContentProvider.java,v 1.4 2006/03/15 04:10:21 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.mapping.editor;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;

/**
 * @author $Author: dacostae $
 *
 */
public class ClientViewerContentProvider implements ITreeContentProvider {
	private boolean showClassParents;
	private boolean showBehaviorParents;

	private Map<Object, List<Object>> children;
	private Map<Object, Object> parents;
	private Map<Object, Container> containers;
	private List<Object> root;
	
	public ClientViewerContentProvider(boolean showClassParents, boolean showBehaviorParents) {
		this.showClassParents=showClassParents;
		this.showBehaviorParents=showBehaviorParents;
	}
	
	private List<Object> getChildrenList(Object parentElement) {
		List<Object> children=this.children.get(parentElement);
		if(children==null) {
			children=new LinkedList<Object>();
			this.children.put(parentElement, children);
		}
		return children;
	}

	public Object[] getChildren(Object parentElement) {
		return getChildrenList(parentElement).toArray();
	}
	

	public Object[] getElements(Object inputElement) {
		return root.toArray();
	}

	public Object getParent(Object element) {
		return parents.get(element);
	}

	public Object initializeElementParent(Object element) {
		Object parent=null;
		Object realElement=element;
		if(element instanceof Container) {
			realElement=((Container)element).getUnderlayingObject();
		}
		if(realElement instanceof JBehavior) {
			if(!showBehaviorParents) {
				parent = null;
			} else {
				parent = ((JBehavior)realElement).getDeclaringClass();
			}
		} else if(realElement instanceof JClass) {
			JClass jClass=(JClass)realElement;
			JBehavior enclosingBehavior=jClass.getEnclosingBehavior();
			if(enclosingBehavior!=null) {
				parent = enclosingBehavior;
			} else {
				JClass enclosingClass=jClass.getDeclaringClass();
				if(enclosingClass!=null) {
					parent = enclosingClass;
				} else {
					if(showClassParents) {
						parent = jClass.getPackage();
					}
				}
			}
		}
		if(parent==null) {
			if(!root.contains(element)) {
				root.add(element);
			}
			return null;
		}
		Container container=containers.get(parent);
		if(container==null) {
			container=new Container(parent);
			containers.put(parent, container);
		}
		parent=container;

		List<Object> children=getChildrenList(parent);
		if(!children.contains(element)) {
			children.add(element);
		}
		this.parents.put(element, parent);
		
		return parent;
	}

	private void initialize(Object[] elements) {
		if(elements==null) {
			return;
		}
		for (Object element : elements) {
			Object parent=element;
			while(parent!=null) {
				parent=initializeElementParent(parent);
			}
		}
	}

	public boolean hasChildren(Object element) {
		return getChildren(element).length!=0;
	}

	public void dispose() {
	
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		children=new HashMap<Object, List<Object>>();
		parents=new HashMap<Object, Object>();
		containers=new HashMap<Object, Container>();
		root=new LinkedList<Object>();
		initialize((Object[])newInput);
	}
}