package org.isistan.flabot.mapping.builder;

import java.util.HashSet;
import java.util.Set;

import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelFactory;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;

public class PatternMappingBuilder implements MappingBuilder {
	
	/**
	 * Singleton instance
	 */
	private static PatternMappingBuilder instance=new PatternMappingBuilder();
	
	/**
	 * Returns the singleton instance
	 * @return
	 */
	public static PatternMappingBuilder getInstance() {
		return instance;
	}

	private PatternMappingBuilder() {
		
	}
	
	public Mapping buildMapping(JObject[] elements) {
		if (elements.length == 0)
			return null;
		
		StringBuffer behaviorPattern = new StringBuffer();		
		
		Set<String> classSet = new HashSet<String>();
		StringBuffer classPattern = new StringBuffer();

		Set<String> packageSet = new HashSet<String>();
		StringBuffer packagePattern = new StringBuffer();
		
		Set<String> javaFileSet = new HashSet<String>();
		StringBuffer javaFilePattern = new StringBuffer();
		
		for(JObject element: elements) {
			String behaviorPatternPart=null;
			String classPatternPart=null;
			String javaFilePatternPart=null;
			String packagePatternPart=null;
			if(element instanceof JBehavior) {
				JBehavior jBehavior=(JBehavior)element;
				JWorkspaceClass jClass=(JWorkspaceClass)jBehavior.getDeclaringClass();
				JJavaFile jJavaFile=jClass.getJavaFile();
				JPackage jPackage=jClass.getPackage();
				behaviorPatternPart=escape(jBehavior.getDescriptor());
				classPatternPart=escape(jClass.getName());
				javaFilePatternPart=escape(jJavaFile.getDescriptor());
				packagePatternPart=escape(jPackage.getName());
			} else if(element instanceof JClass) {
				JWorkspaceClass jClass=(JWorkspaceClass)element;
				JJavaFile jJavaFile=jClass.getJavaFile();
				JPackage jPackage=jClass.getPackage();
				classPatternPart=escape(PatternMapping.ALL_MARK + jClass.getName());
				javaFilePatternPart=escape(jJavaFile.getDescriptor());
				packagePatternPart=escape(jPackage.getName());
			} else if(element instanceof JPackage) {
				JPackage jPackage=(JPackage)element;
				packagePatternPart=escape(PatternMapping.ALL_MARK + jPackage.getName());
			}
			if(packagePatternPart!=null && packageSet.add(packagePatternPart)) {
				if(packagePattern.length()>0) {
					packagePattern.append('|');
				}
				packagePattern.append(packagePatternPart);
			}
			if(javaFilePatternPart!=null && javaFileSet.add(javaFilePatternPart)) {
				if(javaFilePattern.length()>0) {
					javaFilePattern.append('|');
				}
				javaFilePattern.append(javaFilePatternPart);
			}
			if(classPatternPart!=null && classSet.add(classPatternPart)) {
				if(classPattern.length()>0) {
					classPattern.append('|');
				}
				classPattern.append(classPatternPart);
			}
			if(behaviorPatternPart!=null) {
				if(behaviorPattern.length()>0) {
					behaviorPattern.append('|');
				}
				behaviorPattern.append(behaviorPatternPart);
			}
		}


		PatternMapping patternMapping=MappingmodelFactory.eINSTANCE.createPatternMapping();
		String behaviorPatternString=behaviorPattern.toString();
		String classPatternString=classPattern.toString();
		String packagePatternString=packagePattern.toString();
		String javaFilePatternString=javaFilePattern.toString();

		patternMapping.setBehaviorPattern(behaviorPatternString);
		patternMapping.setClassPattern(classPatternString);
		patternMapping.setPackagePattern(packagePatternString);
		patternMapping.setJavaFilePattern(javaFilePatternString);
		return patternMapping;		
	}
	
	private String escape(String string) {
		return string
			.replace(".", "\\.") //$NON-NLS-1$ //$NON-NLS-2$
			.replace("(", "\\(") //$NON-NLS-1$ //$NON-NLS-2$
			.replace(")", "\\)") //$NON-NLS-1$ //$NON-NLS-2$
			.replace("[", "\\[") //$NON-NLS-1$ //$NON-NLS-2$
			.replace("]", "\\]") //$NON-NLS-1$ //$NON-NLS-2$
			.replace("$", "\\$"); //$NON-NLS-1$ //$NON-NLS-2$
	}

}
