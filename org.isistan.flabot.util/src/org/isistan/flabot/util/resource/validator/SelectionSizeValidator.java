package org.isistan.flabot.util.resource.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

/**
 * Validator that checks for the size of the selection
 * @author da Costa Cambio
 *
 */
public class SelectionSizeValidator implements ISelectionStatusValidator {
	private int min;
	private int max;
	private String pluginId;
	
	public SelectionSizeValidator(String pluginId, int min, int max) {
		if(min<0) throw new IllegalArgumentException("Parameter min must be non-negative.");
		if(min>max) throw new IllegalArgumentException("Parameter min must be lower than max.");
		this.pluginId=pluginId;
		this.min=min;
		this.max=max;
	}
	public SelectionSizeValidator(String pluginId, int min) {
		if(min<0) throw new IllegalArgumentException("Parameter min must be non-negative.");
		this.pluginId=pluginId;
		this.min=min;
		this.max=-1;
	}
	public IStatus validate(Object[] selection) {
		if (selection.length < min) {
			String msg;
			if(max==-1) {
				msg="Must select at least " + min + " files.";
			} else if(min==max) {
				msg="Must select " + min + " files.";
			}else {
				msg="Must select between" + min + " and " + max + " files.";
			}
			return new Status(IStatus.ERROR, pluginId, 0, msg, null);
		}
		if (max!=-1 && selection.length > max) {
			String msg;
			if(min==max) {
				msg="Must select " + min + " files.";
			}else {
				msg="Must select between" + min + " and " + max + " files.";
			}
			return new Status(IStatus.ERROR, pluginId, 0, msg, null);
		}
		return new Status(IStatus.OK, pluginId, 0, "", null);
	}			
};
