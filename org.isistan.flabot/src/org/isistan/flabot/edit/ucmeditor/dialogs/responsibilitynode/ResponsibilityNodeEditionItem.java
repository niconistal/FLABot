package org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode;

import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;

/**
 * Abstract edition item for responsibility nodes semantic properties
 * @author $Author: dacostae $
 *
 */
public interface ResponsibilityNodeEditionItem extends EditionTabItem<ResponsibilityNode> {
	public static final EditionTabItemLoader<ResponsibilityNodeEditionItem> LOADER=
		new EditionTabItemLoader<ResponsibilityNodeEditionItem>(
				ExtensionPointConstants.RESPONSIBILITY_NODE_EDITION_TAB_ITEM,
				ExtensionPointConstants.RESPONSIBILITY_NODE_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.RESPONSIBILITY_NODE_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.RESPONSIBILITY_NODE_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
