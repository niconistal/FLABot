package org.isistan.flabot.edit.ucmeditor.dialogs.event;

import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;

/**
 * Abstract condition event edition tab
 * @author $Author: franco $
 *
 */
public interface ConditionEventEditionItem extends EditionTabItem<ConditionEvent> {
	public static final EditionTabItemLoader<ConditionEventEditionItem> LOADER=
		new EditionTabItemLoader<ConditionEventEditionItem>(
				ExtensionPointConstants.CONDITION_EVENT_EDITION_TAB_ITEM,
				ExtensionPointConstants.CONDITION_EVENT_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.CONDITION_EVENT_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.CONDITION_EVENT_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
