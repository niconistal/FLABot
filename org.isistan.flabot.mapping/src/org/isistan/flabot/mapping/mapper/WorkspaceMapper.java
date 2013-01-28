package org.isistan.flabot.mapping.mapper;

import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.util.problems.MessageAccumulator;

/**
 * This interface is intended to be implemented for implementors of Mapping
 * in an efficient way.
 *
 * @author da Costa Cambio
 *
 */
public interface WorkspaceMapper {
	
	/**
	 * Find all the elements of the given type in the current workspace that match the given mapping,
	 * considerUndefinedAsTrue argument defines if mappings returning undefined for
	 * passes(...) is considered as true or false
	 * @param mapping
	 * @param messageAccumulator
	 * @return
	 */
	public JObject[] find(MappingType type, Mapping mapping, boolean considerUndefinedAsTrue, MessageAccumulator messageAccumulator);

	/**
	 * Find all the elements of any type in the current workspace that match the given mapping.
	 * @param mapping
	 * @param messageAccumulator
	 * @return
	 */
	public JObject[] find(Mapping mapping, MessageAccumulator messageAccumulator);

	/**
	 * Find all the behaviors in the current workspace that match the given mapping
	 * @param mapping
	 * @param messageAccumulator
	 * @return
	 */
	public JBehavior[] findBehaviors(Mapping mapping, MessageAccumulator messageAccumulator);

	/**
	 * Find all the classes in the current workspace that match the given mapping,
	 * considerUndefinedAsTrue argument defines if mappings returning undefined for
	 * passes(JClass) is considered as true or false
	 * @param mapping
	 * @param considerUndefinedAsTrue
	 * @param messageAccumulator
	 * @return
	 */
	public JClass[] findClasses(Mapping mapping, boolean considerUndefinedAsTrue, MessageAccumulator messageAccumulator);

	/**
	 * Find all the packages in the current workspace that match the given mapping,
	 * considerUndefinedAsTrue argument defines if mappings returning undefined for
	 * passes(JPackage) is considered as true or false
	 * @param mapping
	 * @param considerUndefinedAsTrue
	 * @param messageAccumulator
	 * @return
	 */
	public JWorkspacePackage[] findPackages(Mapping mapping, boolean considerUndefinedAsTrue, MessageAccumulator messageAccumulator);
}
