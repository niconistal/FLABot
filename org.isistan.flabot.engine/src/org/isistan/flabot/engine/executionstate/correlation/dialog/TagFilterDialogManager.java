/**
 * 
 */
package org.isistan.flabot.engine.executionstate.correlation.dialog;

import java.util.List;

import org.isistan.flabot.engine.executionstate.correlation.dialog.swt.TagFilterDialog;
import org.isistan.flabot.trace.log.Tag;

/**
 * Implementations of this class let the user select graphically a
 * subset of tags from a tag list
 * @author mblech
 *
 */
public interface TagFilterDialogManager {
	
	/**
	 * Reference to the instance of this interface's implementation
	 */
	public static final TagFilterDialogManager INSTANCE =
		new TagFilterDialog();
	
	/**
	 * Show a tag selection dialog to the user and return the list of
	 * selected tags
	 * @param tags the original tag list
	 * @return the tags that the user has selected
	 */
	public List<Tag> filterTags(String name, List<Tag> tags, List<Tag> selectedTags, boolean modal);

}
