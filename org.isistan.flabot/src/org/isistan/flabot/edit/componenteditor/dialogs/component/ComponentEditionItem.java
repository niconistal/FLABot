package org.isistan.flabot.edit.componenteditor.dialogs.component;

import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;

/**
 * Abstract edition item for components semantic properties
 * @author $Author: dacostae $
 *
 */
public interface ComponentEditionItem extends EditionTabItem<ComponentModel> {
	public static final EditionTabItemLoader<ComponentEditionItem> LOADER=
		new EditionTabItemLoader<ComponentEditionItem>(
				ExtensionPointConstants.COMPONENT_EDITION_TAB_ITEM,
				ExtensionPointConstants.COMPONENT_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.COMPONENT_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.COMPONENT_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
