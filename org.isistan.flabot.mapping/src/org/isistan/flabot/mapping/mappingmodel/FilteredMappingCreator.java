package org.isistan.flabot.mapping.mappingmodel;

import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mapper.WorkspaceMapper;
import org.isistan.flabot.util.TriState;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

public class FilteredMappingCreator {
	
	public static Mapping create(Mapping mapping, Mapping[] filters) {
		WorkspaceMapper mapper=mapping.getWorkspaceMapper();
		JObject[] elements=mapper.find(MappingType.ANYTHING, mapping, false, new LoggerMessageAccumulator());
		List<JObject> newElements=new LinkedList<JObject>();
		for (JObject element : elements) {
			if(!JavaModelJDTUtil.contains(newElements, element)) {
				if(element instanceof JPackage) {
					JPackage jPackage=(JPackage)element;
					if(accepted(filters, jPackage)) {
						newElements.add(element);
					}
				}
				if(element instanceof JClass) {
					JClass jClass=(JClass)element;
					if(accepted(filters, jClass)) {
						newElements.add(element);
					}
				}
				if(element instanceof JBehavior) {
					JBehavior jBehavior=(JBehavior)element;
					if(accepted(filters, jBehavior)) {
						newElements.add(element);
					}
				}
			}
		}
		return mapping.getBuilder().buildMapping(newElements.toArray(new JObject[newElements.size()]));
	}
	
	static boolean accepted(Mapping[] filters, JBehavior jBehavior) {
		if(filters==null)
			return true;
		for (Mapping filter : filters) {
			JClass jClass=jBehavior.getDeclaringClass();
			TriState packagePasses=filter.passes(jClass.getPackage());
			if(packagePasses==TriState.TRUE) {
				return true;
			} else if(packagePasses==TriState.UNDEFINED) {
				TriState classPasses=filter.passes(jClass);
				if(classPasses==TriState.TRUE) {
					return true;
				} else if(classPasses==TriState.UNDEFINED) {
					boolean behaviorPasses=filter.passes(jBehavior);
					if(behaviorPasses) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	static boolean accepted(Mapping[] filters, JClass jClass) {
		if(filters==null)
			return true;
		for (Mapping filter : filters) {
			TriState packagePasses=filter.passes(jClass.getPackage());
			if(packagePasses==TriState.TRUE) {
				return true;
			} else if(packagePasses==TriState.UNDEFINED) {
				TriState classPasses=filter.passes(jClass);
				if(classPasses==TriState.TRUE) {
					return true;
				}
			}
		}
		return false;
	}
	
	static boolean accepted(Mapping[] filters, JPackage jPackage) {
		if(filters==null)
			return true;
		for (Mapping filter : filters) {
			TriState packagePasses=filter.passes(jPackage);
			if(packagePasses==TriState.TRUE) {
				return true;
			}
		}
		return false;
	}	
}