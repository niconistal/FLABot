/**
 * $Id: WorkspaceViewerLabelProvider.java,v 1.5 2006/03/18 00:25:03 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.mapping.editor;

import org.eclipse.jdt.core.dom.AbstractTypeDeclaration;
import org.eclipse.jdt.core.dom.AnonymousClassDeclaration;
import org.eclipse.jdt.core.dom.IBinding;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.javamodel.jdt.ObjectImpl;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider.InvalidElement;

/**
 * @author $Author: dacostae $
 *
 */
public class WorkspaceViewerLabelProvider implements ILabelProvider {
	
	private JavaElementLabelProvider provider;
	
	public WorkspaceViewerLabelProvider(int flags) {
		provider=new JavaElementLabelProvider(flags);
	}
	public void addListener(ILabelProviderListener listener) {
		provider.addListener(listener);
	}

	public void dispose() {
		provider.dispose();
	}

	public boolean isLabelProperty(Object element, String property) {
		return isLabelProperty(getOriginalElement(element), property);
	}
	
	protected Object getOriginalElement(Object element) {
		Object original;
		if(element instanceof Container) {
			original= ((Container)element).getUnderlayingObject();
		}
		if(element instanceof ObjectImpl) {
			original= JavaModelJDTUtil.getJavaElement((ObjectImpl)element);
			if(original!=null) {
				element=original;
			}
		}
		if(element instanceof AnonymousClassDeclaration) {
			original=((AnonymousClassDeclaration)element).resolveBinding();
			if(original!=null) {
				element=original;
			}
		}
		if(element instanceof AbstractTypeDeclaration) {
			original=((AbstractTypeDeclaration)element).resolveBinding();
			if(original!=null) {
				element=original;
			}
		}
		if(element instanceof MethodDeclaration) {
			original=((MethodDeclaration)element).resolveBinding();
			if(original!=null) {
				element=original;
			}
		}

		if(element instanceof IBinding) {
			original=((IBinding)element).getJavaElement();
			if(original!=null) {
				element=original;
			}
		}
		return element;
	}

	public void removeListener(ILabelProviderListener listener) {
		provider.removeListener(listener);
	}

	public Image getImage(Object element) {
		return provider.getImage(getOriginalElement(element));
	}

	public String getText(Object element) {
		if(element instanceof JBehavior) {
			JBehavior jBehavior=((JBehavior)element);
			return jBehavior.getName() + jBehavior.getSignature().replaceAll(",", ", ").replaceAll(":", " : ");
		}
		boolean isClass=element instanceof JClass;
		element=getOriginalElement(element);
		if(element instanceof InvalidElement) {
			return element.toString();
		}
		String string=provider.getText(element);
		if(string.trim().length()==0) {
			string=element.toString();
		}
		if(isClass) {
			string=string.replaceAll("(.*)<[^>]*>(.*)", "$1$2");
		}
		
		return string;
	}
	
}
