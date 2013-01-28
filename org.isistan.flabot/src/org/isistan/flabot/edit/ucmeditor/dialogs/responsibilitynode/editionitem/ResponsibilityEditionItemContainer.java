package org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.editionitem;

import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibility.ResponsibilityEditionItem;
import org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.ResponsibilityNodeEditionItem;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.edition.DataAdapter;
import org.isistan.flabot.util.edition.tab.EditionTabItemContainer;
import org.isistan.flabot.util.problems.log.LoggerMessageAccumulator;

/**
 * This edition item wrappes all edition tabs contributed for
 * to responsibility node's edition extension point
 * @author $Author: franco $
 *
 */
public class ResponsibilityEditionItemContainer extends EditionTabItemContainer<ResponsibilityNode, Responsibility>
	implements ResponsibilityNodeEditionItem {
	
	private static DataAdapter<ResponsibilityNode, Responsibility> dataArapter=new DataAdapter<ResponsibilityNode, Responsibility>() {

		public Responsibility adapt(ResponsibilityNode data) {
			return data.getResponsibility();
		}
		
	};
	
	public ResponsibilityEditionItemContainer() {
		super(Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.editionitem.ResponsibilityEditionItemContainer.tabName"), Messages.getString("org.isistan.flabot.edit.ucmeditor.dialogs.responsibilitynode.editionitem.ResponsibilityEditionItemContainer.tabLabelCommand"), //$NON-NLS-1$ //$NON-NLS-2$
				dataArapter, ResponsibilityEditionItem.LOADER.getEditionItems(
						new LoggerMessageAccumulator()));
	}

	public boolean accepts(ResponsibilityNode element) {
		return true;
	}
}
