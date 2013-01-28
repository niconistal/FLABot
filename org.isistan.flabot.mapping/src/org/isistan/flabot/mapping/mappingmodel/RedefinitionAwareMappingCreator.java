package org.isistan.flabot.mapping.mappingmodel;

import java.lang.reflect.Modifier;
import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JConstructor;
import org.isistan.flabot.javamodel.JMethod;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JavaMetaModelException;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.mapping.MappingPlugin;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mapper.WorkspaceMapper;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

public class RedefinitionAwareMappingCreator {
	

	public static Mapping create(Mapping mapping) {
		WorkspaceMapper mapper=mapping.getWorkspaceMapper();
		JObject[] elements=mapper.find(MappingType.CLASSES_AND_BEHAVIORS, mapping, false, new LoggerMessageAccumulator());
		List<JObject> newElements=new LinkedList<JObject>();
		for (JObject element : elements) {
			if(element instanceof JClass) {
				JClass jClass=(JClass)element;
				if(!JavaModelJDTUtil.contains(newElements, jClass)) {
					newElements.add(element);
				}
				JArray<? extends JClass> jSubclasses=jClass.getSubclasses(false);
				for (JClass jSubclass : jSubclasses) {
					if(!JavaModelJDTUtil.contains(newElements, jSubclass)) {
						newElements.add(jSubclass);
					}
				}
			}
		}
		for (JObject element : elements) {
			if(element instanceof JBehavior) {
				JBehavior jBehavior=(JBehavior)element;
				JClass jClass=jBehavior.getDeclaringClass();
				if(!JavaModelJDTUtil.contains(newElements, jClass)) {
					if(!JavaModelJDTUtil.contains(newElements, jBehavior)) {
						newElements.add(jBehavior);
						if(jBehavior instanceof JMethod) {
							JArray<? extends JClass> jSubclasses=jClass.getSubclasses(false);
							if(!Modifier.isStatic(jBehavior.getModifiers())) {
								for (JClass jSubclass : jSubclasses) {
									if(!JavaModelJDTUtil.contains(newElements, jSubclass)) {
										JBehavior redefinition=getRedefinition(jBehavior, jSubclass);
										if(redefinition!=null) {
											if(!JavaModelJDTUtil.contains(newElements, redefinition)) {
												newElements.add(redefinition);
											}
										}
									}
								}
							}
						} else if(jClass.isInterface() && jBehavior instanceof JConstructor) {
							JArray<? extends JClass> jSubclasses=jClass.getSubclasses(false);
							for (JClass jSubclass : jSubclasses) {
								if(!jSubclass.isInterface()) {
									JArray<? extends JConstructor> implementingClassesConstructors=
										jSubclass.getDeclaredConstructors();
									for (JConstructor constructor : implementingClassesConstructors) {
										if(!JavaModelJDTUtil.contains(newElements, constructor)) {
											newElements.add(constructor);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		return mapping.getBuilder().buildMapping(newElements.toArray(new JObject[newElements.size()]));
	}
	
	static JBehavior getRedefinition(JBehavior behavior, JClass jClass) {
		try {
			JBehavior redefiningBehavior=jClass.getDeclaredMethod(behavior.getName(), behavior.getParameterTypes());
			return redefiningBehavior;
		} catch(JavaMetaModelException e) {
			MappingPlugin.getDefault().getLogger().error("Error searching for redefinitions: {}", e);
			return null;
		}
	}
}