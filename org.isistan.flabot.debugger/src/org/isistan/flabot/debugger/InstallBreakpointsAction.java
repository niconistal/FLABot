/**
 * $Id: InstallBreakpointsAction.java,v 1.20 2006/04/06 05:01:47 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.debugger;


import java.lang.reflect.Modifier;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.debug.core.IJavaMethodBreakpoint;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.debugger.messages.Messages;
import org.isistan.flabot.engine.failurelocatedaction.FailureLocatedAction;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JavaMetaModelException;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.mappingmodel.ScopeAwareMappingCreator;
import org.isistan.flabot.util.ObjectBoolean;
import org.isistan.flabot.util.problems.DefaultMessage;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.MessageSeverity;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

/**
 * 
 * Installs breakpoints in the mapped method of the selected responsibility node.
 * @author da Costa Cambio
 *
 */
public class InstallBreakpointsAction implements FailureLocatedAction {

	/**
	 * Installs breakpoints in the behaviors mapped from the given responsibility
	 * node.
	 */
	public void execute(ResponsibilityNode responsibilityNode, ComponentRole role, MessageAccumulator messageAccumulator) {
		Responsibility responsibility= responsibilityNode.getResponsibility();
		Mapping mapping=MappingManager.getMapping(responsibility);
		if(mapping==null) {
			messageAccumulator.addMessage(
					new DefaultMessage(
							DebuggerPlugin.getDefault(),
							DebuggerPlugin.SYMBOLIC_NAME,
							MessageSeverity.ERROR,
							Messages.getString("org.isistan.flabot.debugger.InstallBreakpointsAction.impossibleToInstallBreakpoint"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.debugger.InstallBreakpointsAction.noMappingDefined", //$NON-NLS-1$
									responsibility.getName())
							)
					);
			return;
		}
		ComponentModel[] components;
		if(role==null) {
			EList componentsList=responsibility.getComponents();
			components=
				(ComponentModel[])componentsList.toArray(
						new ComponentModel[componentsList.size()]);
		} else {
			components=new ComponentModel[] {role.getComponent()};
		}
		Mapping[] scopes=ScopeAwareMappingCreator.getScopes(components);
		ObjectBoolean elementsOutsideScope=new ObjectBoolean();
		mapping=ScopeAwareMappingCreator.create(scopes, mapping, elementsOutsideScope);
		JBehavior[] behaviors=map(mapping, messageAccumulator);
		
		install(responsibility, behaviors, elementsOutsideScope.value, scopes, messageAccumulator);
		
	}
	
	private void install(Responsibility responsibility, JBehavior[] behaviors, boolean elementsOutsideScope, Mapping[] scopes, MessageAccumulator messageAccumulator) {
		BreakpointsInstaller breakpointsInstaller=new BreakpointsInstaller();
		String classNames=null;
		for (JBehavior behavior : behaviors) {
			try {
				IJavaMethodBreakpoint breakpoint=breakpointsInstaller.install(behavior, false);
				String condition="";
				if(elementsOutsideScope && scopes!=null) {
					int modifiers=behavior.getModifiers();
					if(!Modifier.isStatic(modifiers)) {
						if(classNames==null) {
							classNames=getClassNamesList(scopes, messageAccumulator);
						}
						condition="\"" + classNames + "\".contains(new StringBuffer(\";\").append(this.getClass().getName()).append(';').toString())";
						breakpoint.setCondition(condition);
						breakpoint.setConditionEnabled(true);
					}
				}
				if(exists(breakpointsInstaller, behavior, condition)) {
					breakpointsInstaller.remove(breakpoint);
				} else {
					breakpointsInstaller.register(breakpoint);
				}
			} catch (JavaModelException e) {
				addProblem(messageAccumulator, responsibility, behavior, e);
			} catch (CoreException e) {
				addProblem(messageAccumulator, responsibility, behavior, e);
			} catch (JavaMetaModelException e) {
				addProblem(messageAccumulator, responsibility, behavior, e);
			}
		}
	}
	
	public boolean exists(BreakpointsInstaller breakpointsInstaller, JBehavior behavior, String condition) throws CoreException {
		IJavaMethodBreakpoint[] breakpoints = breakpointsInstaller.get(behavior);
		for (IJavaMethodBreakpoint breakpoint : breakpoints) {
			if(breakpoint.getHitCount()==-1) {
				String brCondition=breakpoint.getCondition();
				if(brCondition==null) {
					brCondition="";
				}
				if(brCondition.equals(condition)) {
					if(breakpoint.isConditionSuspendOnTrue()) {
						if(!breakpoint.isConditionEnabled() && condition.length()>0) {
							return false;
						}
						return true;
					}
				}
			}
		}
		return false;
	}

	private String getClassNamesList(Mapping[] scopes, MessageAccumulator messageAccumulator) {
		StringBuffer buffer=new StringBuffer();
		buffer.append(';');
		for (Mapping scope : scopes) {
			JClass[] jClasses=scope.getWorkspaceMapper().findClasses(scope, true, messageAccumulator);
			for (JClass jClass : jClasses) {
				buffer.append(jClass.getName()).append(';');
			}
		}
		return buffer.toString(); 
	}

	private JBehavior[] map(Mapping mapping, MessageAccumulator messageAccumulator) {
		if(mapping==null) {
			return new JBehavior[0];
		}
		return mapping.getWorkspaceMapper().findBehaviors(mapping, messageAccumulator);
	}
	
	
	private void addProblem(MessageAccumulator messageAccumulator, Responsibility responsibility, JBehavior behavior, Throwable exception) {
		messageAccumulator.addMessage(
				new DefaultMessage(
						DebuggerPlugin.getDefault(),
						DebuggerPlugin.SYMBOLIC_NAME,
						MessageSeverity.ERROR,
						Messages.getString("org.isistan.flabot.debugger.InstallBreakpointsAction.impossibleToInstallBreakpoint"), //$NON-NLS-1$
						Messages.getString("org.isistan.flabot.debugger.InstallBreakpointsAction.errorOcurredWhileInstallinBreakpoint", //$NON-NLS-1$
								responsibility.getName(), behavior.getDescriptor(),
								exception.getClass().getName(), exception)
						, exception)
				);
	}
}
