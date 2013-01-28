package org.isistan.flabot.launcher.tabs;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;


/**
 * Abstract configuration tab with a couple of status handling methods
 * @author usuario
 *
 */
public abstract class AbstractConfigurationTab extends AbstractLaunchConfigurationTab {
	
	/**
	 * Creates the starting space
	 * @param parent
	 * @param span
	 */
	protected void createStartingSpace(Composite parent, int span) {
		Label label = new Label(parent, SWT.NULL);
		GridData data = new GridData();
		data.horizontalSpan = span;
		label.setLayoutData(data);
	}

	@Override
	public boolean isValid(ILaunchConfiguration config) {
		return getErrorMessage() == null;
	}
	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
	}
	
	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
	}

	/**
	 * Updates the status line and the ok button depending on the status.
	 * @param status
	 */
	protected void updateStatus(IStatus status) {
		applyToStatusLine(this, status);
	}

	/**
	 * Applies the status to a dialog page.
	 * @param tab
	 * @param status
	 */
	public static void applyToStatusLine(AbstractConfigurationTab tab, IStatus status) {
		String errorMessage= null;
		String warningMessage= null;
		String statusMessage= status.getMessage();
		if (statusMessage.length() > 0) {
			if (status.matches(IStatus.ERROR)) {
				errorMessage= statusMessage;
			} else if (!status.isOK()) {
				warningMessage= statusMessage;
			}
		}
		tab.setErrorMessage(errorMessage);
		tab.setMessage(warningMessage);
		tab.updateLaunchConfigurationDialog();
	}
	
	/**
	 * Selects the most severe status among all pased status.
	 * @param status1
	 * @param status2
	 * @param moreStatus
	 * @return
	 */
	public static IStatus getMoreSevere(IStatus status1, IStatus status2, IStatus... moreStatus) {
		IStatus worst=(status1.getSeverity() >= status2.getSeverity()) ? status1 : status2;
		if(moreStatus!=null) {
			for (IStatus status : moreStatus) {
				worst=(worst.getSeverity() >= status.getSeverity()) ? worst : status;
			}
		}
		return worst;
	}	
	
	/**
	 * Creates a status with the given parameters.
	 * @param pluginId
	 * @param severity
	 * @param message
	 * @return
	 */
	public static IStatus createStatus(String pluginId, int severity, String message) {
		return new Status(severity, pluginId, severity, message, null);
	}
	
	@Override
	protected void updateLaunchConfigurationDialog() {
		super.updateLaunchConfigurationDialog();
	}
}
