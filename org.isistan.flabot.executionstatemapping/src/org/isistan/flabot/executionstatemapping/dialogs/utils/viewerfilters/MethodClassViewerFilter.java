package org.isistan.flabot.executionstatemapping.dialogs.utils.viewerfilters;

import org.eclipse.jdt.core.Flags;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;

public class MethodClassViewerFilter extends ViewerFilter
{
	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element)
	{
		IJavaElement elementType = (IJavaElement) element;

		try
		{
			return (elementType.getElementType() == IJavaElement.JAVA_PROJECT)
					|| (elementType.getElementType() == IJavaElement.PACKAGE_FRAGMENT_ROOT)
					|| (elementType.getElementType() == IJavaElement.CLASS_FILE)
					|| (elementType.getElementType() == IJavaElement.PACKAGE_FRAGMENT)
					|| (elementType.getElementType() == IJavaElement.COMPILATION_UNIT)
					|| (elementType.getElementType() == IJavaElement.METHOD && !Flags
							.isAbstract(((IMethod) elementType).getFlags()))
					|| (elementType.getElementType() == IJavaElement.TYPE && ((IType) elementType)
							.isClass());
		} catch (JavaModelException e)
		{
			ExecutionConditionPlugin.getDefault().getLogger().error(
					"Error processing model: " + elementType, e); //$NON-NLS-1$
			
		}
		return false;
	}
}