package org.isistan.flabot.mapping.editor;

import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibility.ResponsibilityEditionItem;
import org.isistan.flabot.mapping.MappingManager;
import org.isistan.flabot.mapping.MappingType;
import org.isistan.flabot.mapping.builder.PatternMappingBuilder;
import org.isistan.flabot.mapping.editor.WorkspaceViewerContentProvider.ContentFilter;
import org.isistan.flabot.mapping.mappingmodel.Mapping;

public class ResponsibilityMappingEditionItem extends MappingEditionItem<Responsibility>
		implements ResponsibilityEditionItem {

	public ResponsibilityMappingEditionItem() {
		super("Mapping", "", "Responsibility Mapping Edition",
				MappingType.BEHAVIORS, PatternMappingBuilder.getInstance(),
				true, false);
	}

	@Override
	protected ContentFilter getContentFilter(Responsibility responsibility) {
		return null;
	}

	@Override
	protected Mapping[] getScopeMappings(Responsibility responsibility) {
		return null;
	}

	public boolean accepts(Responsibility responsibility) {
		return true;
	}

	@Override
	public void assignMapping(Responsibility responsibility, Mapping mapping) {
		MappingManager.setMapping(responsibility, mapping);
		
	}

	@Override
	public Mapping obtainMapping(Responsibility responsibility) {
		return MappingManager.getMapping(responsibility);
	}
}
