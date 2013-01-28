package org.isistan.flabot.executionstatemapping.dialogs.common;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManageMethodExecutionConditionCommand;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ManagePersistentTreeElementCommand;
import org.isistan.flabot.executionstatemapping.commands.executioncondition.ModifyExecutionConditionCommand;
import org.isistan.flabot.executionstatemapping.dialogs.GeneralExecutionConditionDialog;
import org.isistan.flabot.executionstatemapping.dialogs.MethodExecutionConditionDialog;
import org.isistan.flabot.executionstatemapping.dialogs.utils.filter.ViewFilterProvider;
import org.isistan.flabot.executionstatemapping.messages.Messages;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.executionstatemapping.utils.ExecutionConditionUtils;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

public class ExecutionConditionEditorBuilder {
	
	public static ManageMethodExecutionConditionCommand showNewMethodExecutionConditionDialog(ViewFilterProvider[] viewProviders, ExecutionStateMappingFileModel executionStateMappingFileModel) {				
		return showNewMethodExecutionConditionDialog(null, viewProviders, executionStateMappingFileModel);
	}
	
	private static ManageMethodExecutionConditionCommand showNewMethodExecutionConditionDialog(ExecutionCondition executionCondition, ViewFilterProvider[] viewProviders, ExecutionStateMappingFileModel executionStateMappingFileModel) {				
		MethodExecutionConditionDialog properties = new MethodExecutionConditionDialog(
				null, Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.newMethodCondition")); //$NON-NLS-1$
		properties.setMethodSelectionFilters(viewProviders);
		ExecutionCondition newExecutionCondition = properties.showDialog(executionCondition);	
		if (newExecutionCondition != null) 
		{				
			return (ManageMethodExecutionConditionCommand) getAddCommand(properties.getIMethod(), executionStateMappingFileModel.getMethodExecutionConditionsTree(), newExecutionCondition, newExecutionCondition.getPatternMapping()); 
		}
		return null;
	}
	
	public static ManagePersistentTreeElementCommand showNewGeneralExecutionConditionDialog(ExecutionStateMappingFileModel executionStateMappingFileModel) 
	{	
		GeneralExecutionConditionDialog generalExecutionConditionDialog = new GeneralExecutionConditionDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.newGeneralCondition")); //$NON-NLS-1$
		ExecutionCondition newGeneralExecutionCondition =  generalExecutionConditionDialog.showDialog(null);
		if (newGeneralExecutionCondition != null)
		{
			return new ManagePersistentTreeElementCommand(executionStateMappingFileModel.getGeneralExecutionConditionsTree(), newGeneralExecutionCondition, true);
		}
		return null;
	}
	
	public static Command showEditExecutionConditionDialog(ExecutionCondition element, ExecutionStateMappingFileModel executionStateMappingFileModel)
	{
		if (element.isMethodExecutionCondition())
		{
			ExecutionCondition executionCondition = element;
			IMethod selectedMethod = ExecutionConditionUtils.getIMethod(executionCondition);
			if (selectedMethod != null) 
			{										
				MethodExecutionConditionDialog properties = new MethodExecutionConditionDialog(selectedMethod, Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.executionCondition")); //$NON-NLS-1$
				ExecutionCondition newExecutionCondition = properties.showDialog(executionCondition);
				if (newExecutionCondition != null)
				{
					if (!hasEqualPatterns(newExecutionCondition.getPatternMapping(), executionCondition.getPatternMapping()))
					{
						CompoundCommand commands = new CompoundCommand();
						MappedTreeStructuredElement executionConditionContainer = executionStateMappingFileModel.getMethodExecutionConditionsTree();
						commands.setLabel(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.remapCondition")); //$NON-NLS-1$
						commands.add(new ManageMethodExecutionConditionCommand(executionConditionContainer, executionCondition));
						commands.add(new ModifyExecutionConditionCommand(executionCondition, newExecutionCondition));
						commands.add(getAddCommand(properties.getIMethod(), executionConditionContainer, executionCondition, newExecutionCondition.getPatternMapping()));
						return commands;
					}					
					return new ModifyExecutionConditionCommand(executionCondition, newExecutionCondition);
				}
			}
			else
			{
				return handleMappingLost(executionCondition, executionStateMappingFileModel);
			}
		}
		else
		{
			return handleEditGeneralExecutionCondition(element);	
		}
		return null;
	}
	
	private static Command handleEditGeneralExecutionCondition(ExecutionCondition generalExecutionCondition)
	{
		GeneralExecutionConditionDialog eventD = new GeneralExecutionConditionDialog(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.executionCondition")); //$NON-NLS-1$
		ExecutionCondition newExecutionCondition = eventD.showDialog(generalExecutionCondition);
		if (newExecutionCondition != null)
		{
			return new ModifyExecutionConditionCommand(generalExecutionCondition, newExecutionCondition);
		}
		return null;
	}
	
	private static Command handleMappingLost(ExecutionCondition methodExecutionCondition, ExecutionStateMappingFileModel executionStateMappingFileModel)
	{
		String methodName = ""; //$NON-NLS-1$
		if (methodExecutionCondition.getPatternMapping() != null)
		{
			methodName = methodExecutionCondition.getPatternMapping().getBehaviorPattern();
			if (methodName != null)
			{
				methodName = ExecutionConditionUtils.getEscapedNameFromPattern(methodName);
			}
		}
		
		 MessageDialog dialog = new MessageDialog(Display.getCurrent().getActiveShell(), Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.error"), null, //$NON-NLS-1$
				 Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.mappingLost", methodName),  //$NON-NLS-1$
				 MessageDialog.ERROR, new String[] { Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.remap"), Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.transform"), IDialogConstants.CANCEL_LABEL }, 2); //$NON-NLS-1$ //$NON-NLS-2$
		 
		 int returnValue = dialog.open();
		 if (returnValue == 0)
		 {
			 ManageMethodExecutionConditionCommand addCommand = showNewMethodExecutionConditionDialog(methodExecutionCondition, null, executionStateMappingFileModel);
			 if (addCommand != null)
			 {
				 CompoundCommand commands = new CompoundCommand();
				 MappedTreeStructuredElement executionConditionContainer = executionStateMappingFileModel.getMethodExecutionConditionsTree();
				 commands.add(new ManageMethodExecutionConditionCommand(executionConditionContainer, methodExecutionCondition));
				 commands.setLabel(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.remapCondition")); //$NON-NLS-1$
				 commands.add(new ModifyExecutionConditionCommand(methodExecutionCondition, (ExecutionCondition) addCommand.getNewTreeStructuredElement()));
				 commands.add(addCommand);
				 return commands;
			 }
		 }
		 else if (returnValue == 1)
		 {			 
			 Command command = handleEditGeneralExecutionCondition(methodExecutionCondition);
			 if (command != null)
			 {
				 CompoundCommand commands = new CompoundCommand();
				 MappedTreeStructuredElement executionConditionContainer = executionStateMappingFileModel.getMethodExecutionConditionsTree();
				 commands.setLabel(Messages.getString("org.isistan.flabot.executionmapping.dialogs.common.ExecutionConditionEditorBuilder.transformToGeneral")); //$NON-NLS-1$
				 commands.add(new ManageMethodExecutionConditionCommand(executionConditionContainer, methodExecutionCondition));
				 commands.add(command);
				 commands.add(new ManagePersistentTreeElementCommand(executionStateMappingFileModel.getGeneralExecutionConditionsTree(), methodExecutionCondition, true));					
				 return commands;
			 }
		 }
		 return null;
	}
	
	private static boolean hasEqualPatterns(PatternMapping patternMapping1, PatternMapping patternMapping2)
	{
		if (patternMapping1 == null || patternMapping2 == null)
		{
			return false;
		}		
		return patternMapping1.getPackagePattern().equals(patternMapping2.getPackagePattern()) &&
			patternMapping1.getClassPattern().equals(patternMapping2.getClassPattern()) &&
			patternMapping1.getBehaviorPattern().equals(patternMapping2.getBehaviorPattern());
	}
	
	private static Command getAddCommand(IMethod imethod, MappedTreeStructuredElement executionConditionContainer, ExecutionCondition executionCondition, PatternMapping patternMapping)
	{
		IJavaProject javaProject = (IJavaProject) imethod.getAncestor(IJavaElement.JAVA_PROJECT);
		IPackageFragmentRoot packageFragmentRoot = (IPackageFragmentRoot) imethod.getAncestor(IJavaElement.PACKAGE_FRAGMENT_ROOT);
		
		String[] keyParents = new String[] { javaProject.getElementName(), packageFragmentRoot.getElementName(), patternMapping.getPackagePattern(), patternMapping.getClassPattern() };
		TreeType[] levelOrder = new TreeType[] {TreeType.PROJECT_TYPE, TreeType.PACKAGE_ROOT_TYPE, TreeType.PACKAGE_TYPE, TreeType.CLASS_TYPE };
				
		return new ManageMethodExecutionConditionCommand(executionConditionContainer, keyParents, levelOrder, executionCondition);
	}
}