package org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode;

import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;


public interface ResponsibilityEditionItem extends EditionTabItem<Responsibility>{

	public static final EditionTabItemLoader<ResponsibilityEditionItem> LOADER=
		new EditionTabItemLoader<ResponsibilityEditionItem>(
				ExtensionPointConstants.RESPONSIBILITY_EDITION_TAB_ITEM,
				ExtensionPointConstants.RESPONSIBILITY_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.RESPONSIBILITY_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.RESPONSIBILITY_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
