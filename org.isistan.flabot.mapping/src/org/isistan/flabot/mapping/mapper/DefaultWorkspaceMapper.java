package org.isistan.flabot.mapping.mapper;


import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;
import org.isistan.flabot.javamodel.jdt.workspace.JProject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.util.problems.MessageAccumulator;

/**
 * Default implementation of WorkspaceMapper, this implementation works with
 * any Mapping implementation that conforms its contracts, but on the other hand
 * the eficiency of this mapping can be low as workspace gets bigger.
 * @author da Costa Cambio
 *
 */
public class DefaultWorkspaceMapper extends AbstractWorkspaceMapper {

	/**
	 * Singleton instance
	 */
	private static DefaultWorkspaceMapper instance=new DefaultWorkspaceMapper();
	
	/**
	 * Returns the singleton instance
	 * @return
	 */
	public static DefaultWorkspaceMapper getInstance() {
		return instance;
	}
	
	/**
	 * Hiden constructor
	 *
	 */
	private DefaultWorkspaceMapper() {
	}

	@Override
	protected boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JWorkspace jWorkspace) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JProject jProject) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JPackageRoot jPackageRoot) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JWorkspacePackage jWorkspacePackage) {
		return true;
	}

	@Override
	protected boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JJavaFile jJavaFile) {
		return true;
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
