package org.isistan.flabot.edit.componenteditor.dialogs.responsibilitymaterialization;

import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;

/**
 * Abstract responsibility edition tab
 * @author $Author: dacostae $
 *
 */
public interface ResponsibilityMaterializationEditionItem extends EditionTabItem<ResponsibilityMaterialization> {
	public static final EditionTabItemLoader<ResponsibilityMaterializationEditionItem> LOADER=
		new EditionTabItemLoader<ResponsibilityMaterializationEditionItem>(
				ExtensionPointConstants.RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM,
				ExtensionPointConstants.RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.RESPONSIBILITY_MATERIALIZATION_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
