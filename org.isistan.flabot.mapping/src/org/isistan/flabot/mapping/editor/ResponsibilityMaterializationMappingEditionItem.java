package org.isistan.flabot.mapping.editor;

import org.isistan.flabot.edit.componenteditor.dialogs.responsibilitymaterialization.ResponsibilityMaterialization;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibilitymaterialization.ResponsibilityMaterializationEditionItem;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspaceClass;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.builder.PatternMappingBuilder;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider.ContentFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;
import org.isistan.flabot.util.TriState;

public class ResponsibilityMaterializationMappingEditionItem extends MappingEditionItem<ResponsibilityMaterialization>
		implements ResponsibilityMaterializationEditionItem {

	public ResponsibilityMaterializationMappingEditionItem() {
		super("Mapping", "Component Scope",
				"Responsibility Materialization Mapping Edition",
				MappingType.BEHAVIORS, PatternMappingBuilder.getInstance(),
				false, false);
	}

	@Override
	protected ContentFilter getContentFilter(ResponsibilityMaterialization responsibilityMaterialization) {
		final Mapping[] mappings=getScopeMappings(responsibilityMaterialization);
		if(mappings==null) {
			return null;
		}
		return new ContentFilter() {

			public boolean accept(JWorkspaceClass jClass, boolean hasShowableChildren) {
				if(hasShowableChildren) {
					return true;
				}
				return accept(jClass);
			}

			public boolean accept(JWorkspaceClass jClass) {
				for (Mapping mapping : mappings) {
					TriState packagePasses=mapping.passes(jClass.getPackage());
					if(packagePasses==TriState.TRUE || (packagePasses==TriState.UNDEFINED &&
							TriState.toBoolean(mapping.passes(jClass), true))) {
						return true;
					}
				}
				return false;
			}

			public boolean accept(JBehavior jBehavior, boolean hasShowableChildren) {
				return hasShowableChildren || accept((JWorkspaceClass)jBehavior.getDeclaringClass());
			}
			
		};
	}

	private Mapping[] mappings=null;
	@Override
	protected Mapping[] getScopeMappings(ResponsibilityMaterialization responsibilityMaterialization) {
		if(mappings==null) {
			Mapping mapping=MappingManager.getMapping(responsibilityMaterialization.getComponent());
			if(mapping==null) {
				mappings=new Mapping[0];
			} else {
				mappings=new Mapping[] {mapping};
			}
		}
		return mappings;
	}

	public boolean accepts(ResponsibilityMaterialization responsibilityMaterialization) {
		return true;
	}

	@Override
	public void assignMapping(ResponsibilityMaterialization responsibilityMaterialization, Mapping mapping) {
		MappingManager.setMapping(responsibilityMaterialization.getResponsibility(), mapping);
		
	}

	@Override
	public Mapping obtainMapping(ResponsibilityMaterialization responsibilityMaterialization) {
		return MappingManager.getMapping(responsibilityMaterialization.getResponsibility());
	}
}
