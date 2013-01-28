package org.isistan.flabot.launcher.tabs.basic;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.isistan.flabot.launcher.tabs.AbstractConfigurationTab;

public class MessageLaunchConfigurationTab extends AbstractConfigurationTab {

	private Image image;
	
	private String message;
	

	public MessageLaunchConfigurationTab() {
		this("");
	}
	
	public MessageLaunchConfigurationTab(String message) {
		this.message=message;
		//TODO: set image
		//image = PDEPluginImages.DESC_MAIN_TAB.createImage();
	}

	@Override
	public void dispose() {
		super.dispose();
		//TODO: set image
		//image.dispose();
	}

	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		createMessageSection(composite);
		
		setControl(composite);
	}
	
	protected void createMessageSection(Composite composite) {
		Label label = new Label(composite, SWT.CENTER);
		
		label.setText(message);
	}
	
	

	public void initializeFrom(ILaunchConfiguration config) {
	}
	
	
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
	}
	

	public void performApply(ILaunchConfigurationWorkingCopy config) {
	}

	public final String getName() {
		return "Configuration";
	}
	
	@Override
	public Image getImage() {
		return image;
	}		
}
