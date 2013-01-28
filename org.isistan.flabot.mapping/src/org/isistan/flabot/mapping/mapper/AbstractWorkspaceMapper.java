package org.isistan.flabot.mapping.mapper;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.JavaCore;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JavaMetaModelException;
import org.isistan.flabot.javamodel.jdt.JDTFactory;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;
import org.isistan.flabot.javamodel.jdt.workspace.JProject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspace;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.messages.Messages;
import org.isistan.flabot.util.TriState;
import org.isistan.flabot.util.UtilPlugin;
import org.isistan.flabot.util.problems.DefaultMessage;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.MessageSeverity;

/**
 * Abstract useful workspace mapper
 * @author da Costa Cambio
 *
 */
public abstract class AbstractWorkspaceMapper implements WorkspaceMapper {

	/**
	 * Hiden constructor
	 *
	 */
	protected AbstractWorkspaceMapper() {
	}


	public JBehavior[] findBehaviors(Mapping mappingElement, MessageAccumulator messageAccumulator) {
		JObject[] jElements=find(MappingType.BEHAVIORS, mappingElement,
				true /*doesn't matter*/, messageAccumulator);
		JBehavior[] jBehaviors=new JBehavior[jElements.length];
		for (int i = 0; i < jBehaviors.length; i++) {
			jBehaviors[i]=(JBehavior) jElements[i];
		}
		return jBehaviors;
	}
	 

	public JClass[] findClasses(Mapping mappingElement, boolean considerUndefinedAsTrue, MessageAccumulator messageAccumulator) {
		JObject[] jElements=find(MappingType.CLASSES, mappingElement, considerUndefinedAsTrue, messageAccumulator);
		JClass[] jClasses=new JClass[jElements.length];
		for (int i = 0; i < jClasses.length; i++) {
			jClasses[i]=(JClass) jElements[i];
		}
		return jClasses;
	}
	
	public JWorkspacePackage[] findPackages(Mapping mappingElement, boolean considerUndefinedAsTrue, MessageAccumulator messageAccumulator) {
		JObject[] jElements=find(MappingType.CLASSES, mappingElement, considerUndefinedAsTrue, messageAccumulator);
		JWorkspacePackage[] jPackage=new JWorkspacePackage[jElements.length];
		for (int i = 0; i < jPackage.length; i++) {
			jPackage[i]=(JWorkspacePackage) jElements[i];
		}
		return jPackage;
	}
	

	public JObject[] find(Mapping mappingElement, MessageAccumulator messageAccumulator) {
		return find(MappingType.ANYTHING, mappingElement, true /*doesn't matter*/, messageAccumulator);
	}

	public JObject[] find(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, MessageAccumulator messageAccumulator) {
		JWorkspace jWorkspace=JDTFactory.getInstance().buildWorkspace(
				JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
		List<JObject> jElements=new LinkedList<JObject>();
		find(type, considerUndefinedAsTrue, jWorkspace, mappingElement, jElements, messageAccumulator);
		handleResult(jElements, mappingElement, messageAccumulator);
		return jElements.toArray(new JObject[jElements.size()]);
	}
	


	private void handleResult(List<JObject> jElements, Mapping mappingElement, MessageAccumulator messageAccumulator) {
		if(jElements.size()==0) {
			messageAccumulator.addMessage(
					new DefaultMessage(
							UtilPlugin.getDefault(),
							UtilPlugin.SYMBOLIC_NAME,
							MessageSeverity.WARNING,
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.impossibleToFindMappedElements"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.noMappedBehaviorsFound")) //$NON-NLS-1$
					);
					
		}
	}

	private void find(MappingType type, boolean considerUndefinedAsTrue, JWorkspace jWorkspace, Mapping mappingElement, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		if(!visit(type, mappingElement, considerUndefinedAsTrue, jWorkspace)) {
			return;
		}
		JArray<? extends JProject> jProjects;
		Set<String> visitedPackageRoots=new HashSet<String>();
		try {
			jProjects = jWorkspace.getProjects();
			for (JProject jProject : jProjects) {
				find(type, considerUndefinedAsTrue, jProject, mappingElement, jElements, messageAccumulator, visitedPackageRoots);
			}	
		} catch (JavaMetaModelException e) {
			addProblem(messageAccumulator,
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.workspace"), //$NON-NLS-1$
					jWorkspace.getName(),
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.projects"), //$NON-NLS-1$
					e
				);
		}
	}

	private void find(MappingType type, boolean considerUndefinedAsTrue, JProject jProject, Mapping mappingElement, List<JObject> jElements, MessageAccumulator messageAccumulator, Set<String> visitedPackageRoots) {
		if(!visit(type, mappingElement, considerUndefinedAsTrue, jProject)) {
			return;
		}
		JArray<? extends JPackageRoot> jPackageRoots;
		try {
			jPackageRoots = jProject.getAllPackageRoots();
			for (JPackageRoot packageRoot : jPackageRoots) {
				String packageRootPath=packageRoot.getPath();
				if(!visitedPackageRoots.contains(packageRootPath)) {
					visitedPackageRoots.add(packageRootPath);
					find(type, considerUndefinedAsTrue, packageRoot, mappingElement, jElements, messageAccumulator);
				}
			}
		} catch (JavaMetaModelException e) {
			addProblem(messageAccumulator,
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.project"), //$NON-NLS-1$
					jProject.getName(),
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.packageRoots"), //$NON-NLS-1$
					e
				);
		}
	}
	

	private void find(MappingType type, boolean considerUndefinedAsTrue, JPackageRoot jPackageRoot, Mapping mappingElement, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		if(!visit(type, mappingElement, considerUndefinedAsTrue, jPackageRoot)) {
			return;
		}
		JArray<? extends JWorkspacePackage> jWorkspacePackages;
		try {
			jWorkspacePackages = jPackageRoot.getAllPackages();
			for (JWorkspacePackage jWorkspacePackage : jWorkspacePackages) {
				find(type, considerUndefinedAsTrue, jWorkspacePackage, mappingElement, jElements, messageAccumulator);
			}
		} catch (JavaMetaModelException e) {
			addProblem(messageAccumulator,
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.packageRoot"), //$NON-NLS-1$
					jPackageRoot.getName(),
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.packages"), //$NON-NLS-1$
					e
				);

		}
	}
	
	private void find(MappingType type, boolean considerUndefinedAsTrue, JWorkspacePackage jWorkspacePackage, Mapping mappingElement, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		if(!visit(type, mappingElement, considerUndefinedAsTrue, jWorkspacePackage)) {
			return;
		}
		TriState matches=matches(jWorkspacePackage, mappingElement, messageAccumulator);
		if(matches==TriState.FALSE){
			return;
		} else if(type.isPackages()) {
			if(matches==TriState.TRUE ||
					(matches==TriState.UNDEFINED && type==MappingType.PACKAGES && matches==TriState.UNDEFINED && considerUndefinedAsTrue)) {
				jElements.add(jWorkspacePackage);
				return;			
			}
		}

		JArray<? extends JJavaFile> jJavaFiles;
		try {
			jJavaFiles = jWorkspacePackage.getJavaFiles();
			for (JJavaFile jJavaFile : jJavaFiles) {
				find(type, considerUndefinedAsTrue, jJavaFile, mappingElement, matches==TriState.TRUE, jElements, messageAccumulator);
			}
		} catch (JavaMetaModelException e) {
			addProblem(messageAccumulator,
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.package"), //$NON-NLS-1$
					jWorkspacePackage.getName(),
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.javaFiles"), //$NON-NLS-1$
					e
				);
		}
	}

	private TriState matches(JClass jClass, Mapping mappingElement, MessageAccumulator messageAccumulator) {
		try {
			return mappingElement.passes(jClass);
		} catch(JavaMetaModelException e) {
			Throwable exception=e;
			if(e instanceof InternalModelException && e.getCause()!=null) {
				exception=e.getCause();
			}
			messageAccumulator.addMessage(
					new DefaultMessage(
							UtilPlugin.getDefault(),
							UtilPlugin.SYMBOLIC_NAME,
							MessageSeverity.ERROR,
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.errorSearchingForMappedBehaviors"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.classMatchingError", //$NON-NLS-1$
									jClass.getName(),
									exception.getClass().getName(),
									exception
								),
							exception)
					);
			return TriState.FALSE;
		}
	}
	
	private TriState matches(JWorkspacePackage jWorkspacePackage, Mapping mappingElement, MessageAccumulator messageAccumulator) {
		try {
			return mappingElement.passes(jWorkspacePackage);
		} catch(JavaMetaModelException e) {
			Throwable exception=e;
			if(e instanceof InternalModelException && e.getCause()!=null) {
				exception=e.getCause();
			}
			messageAccumulator.addMessage(
					new DefaultMessage(
							UtilPlugin.getDefault(),
							UtilPlugin.SYMBOLIC_NAME,
							MessageSeverity.ERROR,
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.errorSearchingForMappedBehaviors"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.packageMatchingError", //$NON-NLS-1$
									jWorkspacePackage.getName(),
									exception.getClass().getName(),
									exception
								),
							exception)
					);
			return TriState.FALSE;
		}
	}

	private void find(MappingType type, boolean considerUndefinedAsTrue, JJavaFile jJavaFile, Mapping mappingElement, boolean accepted, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		if(!visit(type, mappingElement, considerUndefinedAsTrue, jJavaFile)) {
			return;
		}
		JArray<? extends JClass> jClasses;
		try {
			jClasses = jJavaFile.getClasses();
			for (JClass jClass : jClasses) {
				find(type, considerUndefinedAsTrue, jClass, mappingElement, accepted, jElements, messageAccumulator);
			}
		} catch (JavaMetaModelException e) {
			addProblem(messageAccumulator,
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.javaFile"), //$NON-NLS-1$
					jJavaFile.getName(),
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.classes"), //$NON-NLS-1$
					e
				);
		}
	}
	
	private void find(MappingType type, boolean considerUndefinedAsTrue, JClass jClass, Mapping mappingElement, boolean accepted, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		findInClass(type, considerUndefinedAsTrue, jClass, mappingElement, accepted, jElements, messageAccumulator);
		findInNestedClasses(type, considerUndefinedAsTrue, jClass, mappingElement, accepted, jElements, messageAccumulator);
		
	}
	
	
	private void findInNestedClasses(MappingType type, boolean considerUndefinedAsTrue, JClass jClass, Mapping mappingElement, boolean accepted, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		if(!visitNestedClasseses(type, mappingElement, considerUndefinedAsTrue, jClass)) {
			return;
		}
		JArray<? extends JClass> jDeclaredClasses;
		try {
			jDeclaredClasses = jClass.getDeclaredClasses();
			for (JClass jDeclaredClass : jDeclaredClasses) {
				find(type, considerUndefinedAsTrue, jDeclaredClass, mappingElement, accepted, jElements, messageAccumulator);
			}
		} catch (JavaMetaModelException e) {
			addProblem(messageAccumulator,
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.class"), //$NON-NLS-1$
					jClass.getName(),
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.nestedClasses"), //$NON-NLS-1$
					e
				);
		}
	}


	private void findInClass(MappingType type, boolean considerUndefinedAsTrue, JClass jClass, Mapping mappingElement, boolean accepted, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		if(!visit(type, mappingElement, considerUndefinedAsTrue, jClass)) {
			return;
		}
		TriState matches;
		if(accepted) {
			matches=TriState.TRUE;
		} else {
			matches=matches(jClass, mappingElement, messageAccumulator);
			if(matches==TriState.FALSE)
				return;
		}
		if(matches==TriState.FALSE){
			return;
		} else if(type.isClasses()) {
			if(matches==TriState.TRUE ||
					(matches==TriState.UNDEFINED && !type.isBehaviors() && matches==TriState.UNDEFINED && considerUndefinedAsTrue)) {
				jElements.add(jClass);
				return;			
			}
		}
		JArray<? extends JBehavior> jDeclaredBehaviors;
		try {
			jDeclaredBehaviors = jClass.getDeclaredBehaviors();
			for (JBehavior jDeclaredBehavior : jDeclaredBehaviors) {
				find(type, considerUndefinedAsTrue, jDeclaredBehavior, mappingElement, matches==TriState.TRUE, jElements, messageAccumulator);
			}
		} catch (JavaMetaModelException e) {
			addProblem(messageAccumulator,
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.class"), //$NON-NLS-1$
					jClass.getName(),
					Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.behaviors"), //$NON-NLS-1$
					e
				);
		}
	}
	
	
	private void find(MappingType type, boolean considerUndefinedAsTrue, JBehavior jBehavior, Mapping mappingElement, boolean accepted, List<JObject> jElements, MessageAccumulator messageAccumulator) {
		if(!visit(type, mappingElement, considerUndefinedAsTrue, jBehavior)) {
			return;
		}
		if(accepted || matches(jBehavior, mappingElement, messageAccumulator)) {
			jElements.add(jBehavior);
		}
	}

	private boolean matches(JBehavior jBehavior, Mapping mappingElement, MessageAccumulator messageAccumulator) {
		try {
			return mappingElement.passes(jBehavior);
		} catch(JavaMetaModelException e) {
			Throwable exception=e;
			if(e instanceof InternalModelException && e.getCause()!=null) {
				exception=e.getCause();
			}
			messageAccumulator.addMessage(
					new DefaultMessage(
							UtilPlugin.getDefault(),
							UtilPlugin.SYMBOLIC_NAME,
							MessageSeverity.ERROR,
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.errorSearchingForMappedBehaviors"), //$NON-NLS-1$
							Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.behaviorMatchingError", //$NON-NLS-1$
									jBehavior.getDescriptor(),
									exception.getClass().getName(),
									exception
								),
							exception)
					);
			return false;
		}
	}


	private void addProblem(MessageAccumulator messageAccumulator, String whereKind, String where, String what, Throwable exception) {
		if(exception instanceof InternalModelException && exception.getCause()!=null) {
			exception=exception.getCause();
		}
		messageAccumulator.addMessage(
				new DefaultMessage(
						org.isistan.flabot.util.UtilPlugin.getDefault(),
						UtilPlugin.SYMBOLIC_NAME,
						MessageSeverity.ERROR,
						Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.errorSearchingForMappedBehaviors"), //$NON-NLS-1$
						Messages.getString("org.isistan.flabot.mapping.mapper.WorkspaceMapper.couldNotLookIntoChildren", //$NON-NLS-1$
								whereKind, where,
								what,
								exception.getClass().getName(),
								exception),
						exception)
				);
	}
	
	protected abstract boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JWorkspace jWorkspace);

	protected abstract boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JProject jProject);
	
	protected abstract boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JPackageRoot jPackageRoot);
	
	protected abstract boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JWorkspacePackage jWorkspacePackage);
	
	protected abstract boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JJavaFile jJavaFile);
	
	protected abstract boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JClass jClass);
	
	protected abstract boolean visitNestedClasseses(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JClass jClass);
	
	protected abstract boolean visit(MappingType type, Mapping mappingElement, boolean considerUndefinedAsTrue, JBehavior jBehavior);
}
