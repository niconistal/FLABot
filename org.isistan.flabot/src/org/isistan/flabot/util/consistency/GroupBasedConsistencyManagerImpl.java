/**
 * $Id: GroupBasedConsistencyManagerImpl.java,v 1.11 2006/04/11 23:31:51 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.util.consistency;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.isistan.flabot.coremodel.constraint.ComponentUniqueNameConstraint;
import org.isistan.flabot.coremodel.constraint.ConditionEventGeneralConstraint;
import org.isistan.flabot.coremodel.constraint.ConditionMappingHasCorrectFamilyConstraint;
import org.isistan.flabot.coremodel.constraint.FamilyHasAllComponentConstraint;
import org.isistan.flabot.coremodel.constraint.InterfaceLinkMappedToPathGeneralConstraint;
import org.isistan.flabot.coremodel.constraint.InterfacesMustHaveSameNameConstraint;
import org.isistan.flabot.coremodel.constraint.ResponsibilityGeneralConstraint;
import org.isistan.flabot.coremodel.constraint.ResponsibilityNodeGeneralConstraint;
import org.isistan.flabot.coremodel.constraint.StubMustHaveFamilyConstraint;
import org.isistan.flabot.coremodel.constraint.UseCaseMapGeneralConstraint;
import org.isistan.flabot.messages.Messages;

/**
 * Default implementation of consistency manager. Manages groups of constraints.
 * @author $Author: franco $
 *
 */
public class GroupBasedConsistencyManagerImpl implements ConsistencyManager {
	
	public static final Object GROUP_KEY_DIAGNOSTIC_CHECK_CONSISTENCE_FAULTLOCATOR = "diagnostic 0"; //$NON-NLS-1$
	public static final Object GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL = "diagnostic 1"; //$NON-NLS-1$
	
	// private constructor so only the singleton instance can be used
	private GroupBasedConsistencyManagerImpl(){}
	
	public static final Object CONTEXT_KEY_GROUP = "groupKey"; //$NON-NLS-1$
	private Map groupRegistry = new HashMap();
	private Map defaultGroup = new HashMap();

	private static GroupBasedConsistencyManagerImpl implementationInstance = null;

	/* (non-Javadoc)
	 * @see org.isistan.flabot.util.consistency.ConsistencyManager#validate(java.lang.Object, java.lang.Object, org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 */
	public boolean validate(Object constraintKey, Object model,
			DiagnosticChain diagnostics, Map context) {
		Object groupKey = context.get(CONTEXT_KEY_GROUP);
		Constraint constraint = getConstraint(groupKey, constraintKey);
		if (constraint != null)
			return constraint.validate(constraintKey, model,
					diagnostics, context);
		else
			return true;
	}
	
	/**
	 * get the default instance of this consistency manager implementation
	 * @return
	 */
	public static ConsistencyManager getInstance() {
		if (implementationInstance == null) {
			implementationInstance  = new GroupBasedConsistencyManagerImpl();
			//TODO register here all the constraints
			//register in the default group only
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					FamilyHasAllComponentConstraint.CONSTRAINT_KEY,
					new FamilyHasAllComponentConstraint());
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					ResponsibilityNodeGeneralConstraint.CONSTRAINT_KEY,
					new ResponsibilityNodeGeneralConstraint());
						
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					UseCaseMapGeneralConstraint.CONSTRAINT_KEY,
					new UseCaseMapGeneralConstraint());			
			
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					InterfacesMustHaveSameNameConstraint.CONSTRAINT_KEY,
					new InterfacesMustHaveSameNameConstraint());			
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					InterfaceLinkMappedToPathGeneralConstraint.CONSTRAINT_KEY,
					new InterfaceLinkMappedToPathGeneralConstraint());
			
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					ResponsibilityGeneralConstraint.CONSTRAINT_KEY,
					new ResponsibilityGeneralConstraint());
			
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					ComponentUniqueNameConstraint.CONSTRAINT_KEY,
					new ComponentUniqueNameConstraint());
			
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					StubMustHaveFamilyConstraint.CONSTRAINT_KEY,
					new StubMustHaveFamilyConstraint());
			
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					ConditionMappingHasCorrectFamilyConstraint.CONSTRAINT_KEY,
					new ConditionMappingHasCorrectFamilyConstraint());
			
			implementationInstance.registerConstraint(GROUP_KEY_DIAGNOSTIC_CONSISTENCE_GENERAL,
					ConditionEventGeneralConstraint.CONSTRAINT_KEY,
					new ConditionEventGeneralConstraint());
		}
		return implementationInstance;
	}
	
	/**
	 * get the group for the given key
	 * @param groupKey
	 * @return
	 */
	private Map getGroup(Object groupKey) {
		return (Map)groupRegistry.get(groupKey);
	}
	
	/**
	 * get the list of registered constraints for the given group and
	 * constraint key
	 * @param groupKey the key of the group (null means default group)
	 * @param constraintKey the key of the constraint
	 * @return
	 */
	private Constraint getConstraint(Object groupKey, Object constraintKey) {
		Map group;
		if (groupKey != null) {
			group = getGroup(groupKey);
			if (group == null)
				throw new IllegalArgumentException(
						Messages.getString("org.isistan.flabot.util.consistency.GroupBasedConsistencyManagerImpl.noGroupWithTheGivenKey")); //$NON-NLS-1$
		}
		else
			group = defaultGroup;
		return (Constraint) group.get(constraintKey);
	}
	
	/**
	 * Register the given constraint on the given group and with the given
	 * key
	 * @param groupKey The key of the group. If the group doesn't exist, a new
	 * one is created. If the key is null, the constraint is only registered
	 * in the default group.
	 * @param constraintKey The key for the constraint.
	 * @param constraint The constraint.
	 */
	public void registerConstraint(Object groupKey, Object constraintKey,
			Constraint constraint) {
		if (groupKey != null) {
			Map group = getGroup(groupKey);
			if (group == null) {
				group = new HashMap();
				groupRegistry.put(groupKey, group);
			}
			group.put(constraintKey, constraint);
		}
		defaultGroup.put(constraintKey, constraint);
	}

}
