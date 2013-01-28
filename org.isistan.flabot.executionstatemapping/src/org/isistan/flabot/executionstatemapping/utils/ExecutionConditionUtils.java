package org.isistan.flabot.executionstatemapping.utils;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.isistan.flabot.executionstatemapping.ExecutionConditionPlugin;
import org.isistan.flabot.executionstatemapping.dialogs.utils.DialogUtils;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.dialogs.utils.labelproviders.DecoratedWorkbenchLabelProvider;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

public class ExecutionConditionUtils {
	
	private static final Status STATUS_OK = new Status(IStatus.OK,
			ExecutionConditionPlugin.PLUGIN_ID, IStatus.OK, "", null); //$NON-NLS-1$

	private static final Status STATUS_ERROR = new Status(IStatus.ERROR,
			ExecutionConditionPlugin.PLUGIN_ID, IStatus.ERROR,
			Messages.getString("org.isistan.flabot.executionmapping.utils.ExecutionConditionUtils.mustSelectMethod"), null); //$NON-NLS-1$
	
	
	public static IJavaModel getJavaModelForWorkspace() {
		return JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
	}

	public static IJavaProject getJavaProjectFor(
			TreeStructuredElement treeStructeredElement) {
		String projectName = treeStructeredElement.getAntecesor(
				TreeType.PROJECT_TYPE).getName();
		return JavaCore.create(ResourcesPlugin.getWorkspace().getRoot())
				.getJavaProject(projectName);
	}
	
	public static IPackageFragmentRoot getPackageFragmentRootFor(
			TreeStructuredElement treeStructeredElement) {
		IJavaProject javaProject = getJavaProjectFor(treeStructeredElement);
		if (javaProject != null) {
			String packageRootName = treeStructeredElement.getAntecesor(
					TreeType.PACKAGE_ROOT_TYPE).getName();
			try {
				for (IPackageFragmentRoot p : javaProject
						.getAllPackageFragmentRoots()) {
					if (p.getElementName().equals(packageRootName)) {
						return p;
					}
				}
			} catch (JavaModelException e) {

			}
		}
		return null;
	}
	
	public static IPackageFragment getPackageFragmentFor(
			TreeStructuredElement treeStructeredElement) {
		IPackageFragmentRoot packageFragmentRoot = getPackageFragmentRootFor(treeStructeredElement);
		if (packageFragmentRoot != null) {
			String packageName = treeStructeredElement.getAntecesor(
					TreeType.PACKAGE_TYPE).getName();
			return packageFragmentRoot.getPackageFragment(packageName);
		}
		return null;
	}
	
	public static IType getClassFor(TreeStructuredElement treeStructeredElement) 
	{
		try 
		{			
			ExecutionCondition executionCondition = (ExecutionCondition) treeStructeredElement			
			.getAntecesor(TreeType.EXECUTION_CONDITION_TYPE);
			
			PatternMapping mapping = executionCondition.getPatternMapping();
			
			JObject[] jObjects = mapping.getWorkspaceMapper().find(MappingType.CLASSES, mapping, true, new LoggerMessageAccumulator());					
			if (jObjects.length > 0)
			{
				if (jObjects.length == 1)
				{
					return (IType)JavaModelJDTUtil.getJavaElement(jObjects[0]);
				}
				else
				{
					IPackageFragmentRoot iPackageRoot = getPackageFragmentRootFor(treeStructeredElement);
					IType classType;
					for(JObject jObject : jObjects)
					{
						classType = (IType) jObject;
						if (classType.getJavaProject() == iPackageRoot.getJavaProject())
						{
							return classType;
						}
					}
				}
			}
		}
		catch (Exception e) 
		{}
		return null;
	}
	
	public static IMethod getIMethod(ExecutionCondition executionCondition) {
		try 
		{
			PatternMapping mapping = executionCondition.getPatternMapping();
			
			MessageAccumulator messageAccumulator = new LoggerMessageAccumulator();
			JObject[] jObjects = mapping.getWorkspaceMapper().find(MappingType.BEHAVIORS, mapping, true, messageAccumulator);		
			if (jObjects.length > 0)
			{
				if (jObjects.length == 1)
				{
					return (IMethod)JavaModelJDTUtil.getJavaElement(jObjects[0]);
				}
				else
				{
					IPackageFragmentRoot iPackageRoot = getPackageFragmentRootFor(executionCondition);
					IMethod iMethod;
					for(JObject jObject : jObjects)
					{
						iMethod = (IMethod) jObject;
						if (iMethod.getJavaProject() == iPackageRoot.getJavaProject())
						{
							return iMethod;
						}
					}
				}
			}
		}
		catch (Exception e) 
		{}
		return null;
	}
	
	public static IMethod getSelectedMethod(IJavaElement scope, ViewFilterProvider[] viewProviders) {
		IMethod selectedMethod = null;
		try {
			selectedMethod = (IMethod) DialogUtils.getSelectedTreeElement(Messages.getString("org.isistan.flabot.executionmapping.utils.ExecutionConditionUtils.methodSelection"), Messages.getString("org.isistan.flabot.executionmapping.utils.ExecutionConditionUtils.selectMethod"),  //$NON-NLS-1$ //$NON-NLS-2$
					new DecoratedWorkbenchLabelProvider(), 
					new WorkbenchContentProvider(), scope, 
					new ISelectionStatusValidator() {
						public IStatus validate(Object[] selection) {
							if (selection != null && selection.length == 1) {
								if (selection[0] != null && ((IJavaElement) selection[0]).getElementType() == IJavaElement.METHOD)
								{
									return STATUS_OK;
								}		
							}
							return STATUS_ERROR;
						}
					},
					viewProviders, new ResourceComparator(ResourceComparator.NAME));
		} catch (Exception e) {
			ExecutionConditionPlugin
					.getDefault()
					.getLogger()
					.error(
							Messages.getString("org.isistan.flabot.executionmapping.utils.ExecutionConditionUtils.error"), //$NON-NLS-1$
							e);
		}
		return selectedMethod;
	}
	
	public static String getEscapedNameFromPattern(String pattern)
	{
		return pattern
		.replace("\\.", ".") //$NON-NLS-1$ //$NON-NLS-2$
		.replace("\\(", "(") //$NON-NLS-1$ //$NON-NLS-2$
		.replace("\\)", ")") //$NON-NLS-1$ //$NON-NLS-2$
		.replace("\\[", "[") //$NON-NLS-1$ //$NON-NLS-2$
		.replace("\\]", "]") //$NON-NLS-1$ //$NON-NLS-2$
		.replace("\\$", "$"); //$NON-NLS-1$ //$NON-NLS-2$
	}
	
	public static String getClassNameFromPattern(String pattern)
	{
		String name = getEscapedNameFromPattern(pattern);
		int index = name.lastIndexOf('.');
		if (index > 0)
		{		
			name = name.substring(index+1, name.length());	
		}
		return name;
	}
}