/**
 * $Id: BreakpointsInstaller.java,v 1.8 2006/04/05 22:03:24 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.debugger;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.model.IBreakpoint;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.debug.core.IJavaMethodBreakpoint;
import org.eclipse.jdt.debug.core.JDIDebugModel;
import org.eclipse.jdt.internal.debug.core.breakpoints.JavaMethodBreakpoint;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JSourceLocation;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;

/**
 * The breakpoints installer creates eclipse breakpoints
 * 
 * @author da Costa Cambio
 *
 */
public class BreakpointsInstaller {
	/**
	 * Creates an entry/exit behavior breakpoint in the given behavior.
	 * 
	 * @param behavior
	 * @return 
	 * @throws JavaModelException
	 * @throws CoreException
	 */
	public IJavaMethodBreakpoint install(JBehavior behavior, boolean register) throws JavaModelException, CoreException {
		IResource resource=JavaModelJDTUtil.getResource(behavior);
		String typeName=behavior.getDeclaringClass().getName();
		String behaviorName=behavior.getName();
		String signature=behavior.getJNISignature();
		
		JSourceLocation sourceLocation = behavior.getSourceLocation();
		int charStart=sourceLocation.getOffset();
		int charEnd=sourceLocation.getEndOffset();
		
		return JDIDebugModel.createMethodBreakpoint(resource, typeName, behaviorName, signature, true, true, false, -1, charStart, charEnd, 0, register, null);
		
	}
	
	public IJavaMethodBreakpoint[] get(JBehavior behavior) {
		IBreakpoint[] breakpoints = 
			DebugPlugin.getDefault().getBreakpointManager().getBreakpoints();
		String typeName=behavior.getDeclaringClass().getName();
		String behaviorName=behavior.getName();
		String behaviorSignature=behavior.getJNISignature();
		List<IJavaMethodBreakpoint> matchingBreakpoints=
			new LinkedList<IJavaMethodBreakpoint>();
		for (IBreakpoint breakpoint : breakpoints) {
			if(breakpoint instanceof IJavaMethodBreakpoint) {
				IJavaMethodBreakpoint jmbreakpoint =
					(IJavaMethodBreakpoint) breakpoint;
				try {
					String brTypeName=jmbreakpoint.getTypeName();
					String brBehaviorName=jmbreakpoint.getMethodName();
					String brBehaviorSignature=jmbreakpoint.getMethodSignature();
					if(typeName.equals(brTypeName)
							&& behaviorName.equals(brBehaviorName)
							&& behaviorSignature.equals(brBehaviorSignature)) {
						matchingBreakpoints.add(jmbreakpoint);
					}
				} catch (CoreException e) {
					DebuggerPlugin.getDefault().getLogger().error(
							"Error getting breakpoints: {}", e);
				}
			}
		}
		return matchingBreakpoints.toArray(
				new IJavaMethodBreakpoint[matchingBreakpoints.size()]);
	}
	

	public void register(IJavaMethodBreakpoint breakpoint) throws CoreException {
		DebugPlugin.getDefault().getBreakpointManager().addBreakpoint(breakpoint);
	}

	public void remove(IJavaMethodBreakpoint breakpoint) throws CoreException {
		breakpoint.delete();
	}
}
