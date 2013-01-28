/**
 * $Id: VisualizationComponentEditionItem.java,v 1.2 2006/03/16 02:55:28 dacostae Exp $
 * $Author: dacostae $
 */
package org.isistan.flabot.edit.componenteditor.dialogs.component.editionitem;

import org.eclipse.gef.GraphicalEditPart;
import org.isistan.flabot.edit.componenteditor.dialogs.component.ComponentVisualEditionItem;
import org.isistan.flabot.edit.editor.dialogs.editionitem.EditVisualizationTabItem;

/**
 * @author $Author: dacostae $
 *
 */
public class VisualizationComponentEditionItem extends EditVisualizationTabItem<GraphicalEditPart> implements ComponentVisualEditionItem {

	public VisualizationComponentEditionItem() {
		super(	EditVisualizationTabItem.BACKGROUND_COLOR_PROPERTY |
				EditVisualizationTabItem.FOREGROUND_COLOR_PROPERTY  |
				EditVisualizationTabItem.LINE_STYLE_PROPERTY |
				EditVisualizationTabItem.SIZE_PROPERTY);
	}	
}