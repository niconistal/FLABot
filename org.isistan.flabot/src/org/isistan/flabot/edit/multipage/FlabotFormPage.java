/**
 * $Id: FlabotFormPage.java,v 1.3 2005/11/30 17:49:12 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage;

import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;

/**
 * Base class for all flabot form pages. Provides access to the flabot file model.
 * @author $Author: franco $
 *
 */
public abstract class FlabotFormPage extends FormPage
		implements UnsettableDirtyStateEditor {

	private FlabotFileModel model;

	public FlabotFormPage(FormEditor editor, String id, String title,
			FlabotFileModel model) {
		super(editor, id, title);
		this.model = model;
	}
	
	/**
	 * Provides access to the flabot file model
	 * @return
	 */	
	protected FlabotFileModel getModel() {
		return model;
	}

}
