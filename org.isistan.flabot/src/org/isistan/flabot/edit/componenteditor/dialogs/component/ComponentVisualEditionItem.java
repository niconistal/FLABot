package org.isistan.flabot.edit.componenteditor.dialogs.component;

import org.eclipse.gef.GraphicalEditPart;
import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;

/**
 * Abstract edition item for components visual properties
 * @author $Author: dacostae $
 *
 */
public interface ComponentVisualEditionItem extends EditionTabItem<GraphicalEditPart> {
	public static final EditionTabItemLoader<ComponentVisualEditionItem> LOADER=
		new EditionTabItemLoader<ComponentVisualEditionItem>(
				ExtensionPointConstants.COMPONENT_VISUAL_EDITION_TAB_ITEM,
				ExtensionPointConstants.COMPONENT_VISUAL_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.COMPONENT_VISUAL_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.COMPONENT_VISUAL_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
