package org.isistan.flabot.util.resource.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

/**
 * Validator that accepts anything
 * @author da Costa Cambio
 *
 */
public class OkValidator implements ISelectionStatusValidator {
	private String pluginId;

	public OkValidator(String pluginId) {
		this.pluginId=pluginId;
	}
	
	public IStatus validate(Object[] selection) {
		return new Status(IStatus.OK, pluginId, 0, "", null);
	}	
}