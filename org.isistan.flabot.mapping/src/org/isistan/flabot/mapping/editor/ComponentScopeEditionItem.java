package org.isistan.flabot.mapping.editor;

import java.util.LinkedList;
import java.util.List;

import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.edit.componenteditor.dialogs.component.ComponentEditionItem;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.builder.PatternMappingBuilder;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider.ContentFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;

public class ComponentScopeEditionItem extends MappingEditionItem<ComponentModel> 
		implements ComponentEditionItem {

	public ComponentScopeEditionItem() {
		super("Scope", "Parent Scopes",
				"Component Scope Edition", MappingType.CLASSES,
				PatternMappingBuilder.getInstance(), true, true);
	}

	private Mapping[] mappings=null;
	private boolean mappingsCalculated=false;
	@Override
	protected Mapping[] getScopeMappings(ComponentModel component) {
		if(!mappingsCalculated) {
			List<Mapping> mappingsList=new LinkedList<Mapping>();
			ComponentModel[] superComponents=component.getAllSuperComponents();
			if(superComponents.length>0) {
				for (ComponentModel superComponent : superComponents) {
					Mapping mapping=MappingManager.getMapping(superComponent);
					if(mapping!=null) {
						mappingsList.add(mapping);
					}
				}
				mappings=mappingsList.toArray(new Mapping[mappingsList.size()]);
			}
			mappingsCalculated=true;
		}
		return mappings;
	}
	@Override
	protected ContentFilter getContentFilter(ComponentModel component) {
		Mapping[] mappings=getScopeMappings(component);
		if(mappings==null) {
			return null;
		}
		return new HierarchyContentFilter(mappings);
	}

	public boolean accepts(ComponentModel component) {
		return true;
	}

	@Override
	public void assignMapping(ComponentModel component, Mapping mapping) {
		MappingManager.setMapping(component, mapping);
		
	}

	@Override
	public Mapping obtainMapping(ComponentModel component) {
		return MappingManager.getMapping(component);
	}
}
