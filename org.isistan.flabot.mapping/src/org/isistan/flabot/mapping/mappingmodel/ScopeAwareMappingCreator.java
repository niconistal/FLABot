package org.isistan.flabot.mapping.mappingmodel;

import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JConstructor;
import org.isistan.flabot.javamodel.JMethod;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.jdt.JavaModelJDTUtil;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.mapper.WorkspaceMapper;
import org.isistan.flabot.util.ObjectBoolean;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

public class ScopeAwareMappingCreator {
	
	public static Mapping create(Mapping[] scopes,
			Mapping mapping, ObjectBoolean elementsOutsideScope) {
		elementsOutsideScope.value=false;
		WorkspaceMapper mapper=mapping.getWorkspaceMapper();
		JObject[] elements=mapper.find(MappingType.CLASSES_AND_BEHAVIORS, mapping, false, new LoggerMessageAccumulator());
		List<JObject> newElements=new LinkedList<JObject>();
		for (JObject element : elements) {
			if(element instanceof JClass) {
				JClass jClass=(JClass)element;
				if(!JavaModelJDTUtil.contains(newElements, jClass)) {
					if(!elementsOutsideScope.value && !FilteredMappingCreator.accepted(scopes, jClass)) {
						elementsOutsideScope.value=true;
					}
					newElements.add(jClass);
					JArray<? extends JClass> jSubclasses=jClass.getSubclasses(false);
					for (JClass jSubclass : jSubclasses) {
						if(!JavaModelJDTUtil.contains(newElements, jSubclass)) {
							if(FilteredMappingCreator.accepted(scopes, jSubclass)) {
								newElements.add(jSubclass);
							}
						}
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
						boolean allredefinitions=true;
						if(jBehavior instanceof JMethod) {
							JArray<? extends JClass> jSubclasses=jClass.getSubclasses(false);
							if(!Modifier.isStatic(jBehavior.getModifiers())) {
								for (JClass jSubclass : jSubclasses) {
									if(!JavaModelJDTUtil.contains(newElements, jSubclass)) {
										JBehavior redefinition=RedefinitionAwareMappingCreator.getRedefinition(jBehavior, jSubclass);
										if(redefinition!=null) {
											if(!JavaModelJDTUtil.contains(newElements, redefinition)) {
												if(FilteredMappingCreator.accepted(scopes, jSubclass)) {
													newElements.add(redefinition);
												}
											}
										} else {
											if(FilteredMappingCreator.accepted(scopes, jSubclass)) {
												allredefinitions=false;
											}
										}
									}
								}
							}
						} else if(jBehavior instanceof JConstructor) {
							if(jClass.isInterface()) {
								JArray<? extends JClass> jSubclasses=jClass.getSubclasses(false);
								for (JClass jSubclass : jSubclasses) {
									if(!jSubclass.isInterface()) {
										JArray<? extends JConstructor> implementingClassesConstructors=
											jSubclass.getDeclaredConstructors();
										for (JConstructor constructor : implementingClassesConstructors) {
											if(!JavaModelJDTUtil.contains(newElements, constructor)) {
												if(FilteredMappingCreator.accepted(scopes, jSubclass)) {
													newElements.add(constructor);
												}
											}
										}
									}
								}
							} else {
								allredefinitions=false;
							}
						}
						if(FilteredMappingCreator.accepted(scopes, jBehavior)) {
							newElements.add(jBehavior);
						} else {
							if(!allredefinitions) {
								elementsOutsideScope.value=true;
								newElements.add(jBehavior);
							}
						}
					}
				}
			}
		}
		
		return mapping.getBuilder().buildMapping(newElements.toArray(new JObject[newElements.size()]));
	}
	
	public static Mapping[] getScopes(ComponentModel[] components) {
		if(components.length==0) {
			return null;
		}
		List<Mapping> mappingsList=new LinkedList<Mapping>();
		Set<ComponentModel> componentsSet=new HashSet<ComponentModel>();
		for (ComponentModel component : components) {
			if(componentsSet.add(component)) {
				Mapping mapping=MappingManager.getMapping(component);
				if(mapping!=null) {
					mappingsList.add(mapping);
				}
				ComponentModel[] subComponents=component.getAllSubComponents();
				for (ComponentModel subComponent : subComponents) {
					if(componentsSet.add(subComponent)) {
						mapping=MappingManager.getMapping(subComponent);
						if(mapping!=null) {
							mappingsList.add(mapping);
						}
					}
				}
			}
		}
		return mappingsList.toArray(new Mapping[mappingsList.size()]);
	}
}