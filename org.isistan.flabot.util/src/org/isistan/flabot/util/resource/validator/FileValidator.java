package org.isistan.flabot.util.resource.validator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.isistan.flabot.util.UtilPlugin;

/**
 * A validator that require the selection to be only IFiles
 * @author usuario
 *
 */
public class FileValidator implements ISelectionStatusValidator {
	private String pluginId;

	public FileValidator(String pluginId) {
		this.pluginId=pluginId;
	}
	
	public IStatus validate(Object[] selection) {
		for (Object object : selection) {
			if(!(object instanceof IFile)) {
				return new Status(IStatus.ERROR, pluginId, 0, "Only files can be selected", null);
			}
		}
		return new Status(IStatus.OK, pluginId, 0, "", null);
	}	
}