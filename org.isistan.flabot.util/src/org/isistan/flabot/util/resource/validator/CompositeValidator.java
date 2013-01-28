package org.isistan.flabot.util.resource.validator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

/**
 * A Composite validator
 * @author da Costa Cambio
 *
 */
public class CompositeValidator implements ISelectionStatusValidator {
	private ISelectionStatusValidator[] validators;
	private ISelectionStatusValidator validator;
	
	public CompositeValidator(ISelectionStatusValidator validator, ISelectionStatusValidator... validators) {
		if(validator==null) throw new IllegalArgumentException("Must specify validator.");
		if(validators==null) validators=new ISelectionStatusValidator[0];
		this.validator=validator;
		this.validators=validators;
	}
	public IStatus validate(Object[] selection) {
		IStatus status=validator.validate(selection);
		for(ISelectionStatusValidator validator:validators) {
			IStatus newStatus=validator.validate(selection);
			if(newStatus.getSeverity()>status.getSeverity()) {
				status=newStatus;
			}
		}
		return status;
	}			
};
