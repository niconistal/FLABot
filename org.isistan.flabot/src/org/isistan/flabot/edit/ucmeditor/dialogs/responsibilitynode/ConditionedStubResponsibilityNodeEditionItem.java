package org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode;

import org.isistan.flabot.ExtensionPointConstants;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.util.edition.tab.EditionTabItem;
import org.isistan.flabot.util.edition.tab.EditionTabItemLoader;
import org.isistan.flabot.util.extension.PropertiesReader;

/**
 * Abstract edition item for responsibility semantic properties
 * @author $Author: Martin Villalba $
 *
 */
public interface ConditionedStubResponsibilityNodeEditionItem extends EditionTabItem<ResponsibilityNode> {

	public static final EditionTabItemLoader<ConditionedStubResponsibilityNodeEditionItem> LOADER=
		new EditionTabItemLoader<ConditionedStubResponsibilityNodeEditionItem>(
				ExtensionPointConstants.CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM,
				ExtensionPointConstants.CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM__TAB_TAG,
				ExtensionPointConstants.CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM__CLASS_ATTRIBUTE,
				ExtensionPointConstants.CONDITIONED_STUB_RESPONSIBILITY_NODE_EDITION_TAB_ITEM__ORDER_ATTRIBUTE,
				new PropertiesReader());
}
