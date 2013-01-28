package org.isistan.flabot.mapping.mapper;


import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;
import org.isistan.flabot.javamodel.jdt.workspace.JProject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;
import org.isistan.flabot.util.TriState;

/**
 * Default implementation of WorkspaceMapper, this implementation works with
 * any Mapping implementation that conforms its contracts, but on the other hand
 * the eficiency of this mapping can be low as workspace gets bigger.
 * @author da Costa Cambio
 *
 */
public class PatternWorkspaceMapper extends AbstractWorkspaceMapper {

	/**
	 * Singleton instance
	 */
	private static PatternWorkspaceMapper instance=new PatternWorkspaceMapper();
	
	/**
	 * Returns the singleton instance
	 * @return
	 */
	public static PatternWorkspaceMapper getInstance() {
		return instance;
	}
	
	/**
	 * Hiden constructor
	 *
	 */
	private PatternWorkspaceMapper() {
	}

	@Override
	protected boolean visit(MappingType type, Mapping mapping, boolean considerUndefinedAsTrue, JWorkspace jWorkspace) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mapping, boolean considerUndefinedAsTrue, JProject jProject) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mapping, boolean considerUndefinedAsTrue, JPackageRoot jPackageRoot) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mapping, boolean considerUndefinedAsTrue, JWorkspacePackage jWorkspacePackage) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mapping, boolean considerUndefinedAsTrue, JJavaFile jJavaFile) {
		PatternMapping patternMapping=(PatternMapping)mapping;
		return TriState.toBoolean(patternMapping.passes(jJavaFile), true);
	}

	@Override
	protected boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JClass jClass) {
		return true;
	}

	@Override
	protected boolean visitNestedClasseses(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JClass jClass) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JBehavior jBehavior) {
		return true;
	}


}
