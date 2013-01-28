package org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode;

import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;

/**
 * Abstract edition item for responsibility nodes visual properties
 * @author $Author: dacostae $
 *
 */
public interface ResponsibilityNodeVisualEditionItem extends EditionTabItem<NodeVisualModel> {
	public static final EditionTabItemLoader<ResponsibilityNodeVisualEditionItem> LOADER=
		new EditionTabItemLoader<ResponsibilityNodeVisualEditionItem>(
				ExtensionPointConstants.RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM,
				ExtensionPointConstants.RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.RESPONSIBILITY_NODE_VISUAL_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
