package org.isistan.flabot.engine.executionstate.contextprovider;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.isistan.flabot.engine.EnginePlugin;
import org.isistan.flabot.launcher.tabs.AbstractConfigurationTab;
import org.isistan.flabot.util.resource.ResourceSelectionDialog;
import org.isistan.flabot.util.resource.filter.FilePatternFilter;
import org.isistan.flabot.util.resource.validator.CompositeValidator;
import org.isistan.flabot.util.resource.validator.FileValidator;
import org.isistan.flabot.util.resource.validator.SelectionSizeValidator;


/**
 * Configuration tab for the context provider selection
 * @author usuario
 *
 */
public class FlabotFileContextProviderConfigurationTab extends AbstractConfigurationTab {

	
	/**
	 * Text for the flabot file
	 */
	private Text flabotFileText;
	
	/**
	 * Tab's image 
	 */
	private Image image;

	/**
	 * Status for flabot file selection 
	 */
	private IStatus flabotFileSelectionStatus;
	
	/**
	 * Blocks changes
	 */
	private boolean blockChanges = false;

	private Composite parent;

	/**
	 * Creates a new FlabotFileContextProviderConfigurationTab
	 *
	 */
	public FlabotFileContextProviderConfigurationTab() {
		flabotFileSelectionStatus = createStatus(IStatus.OK, ""); //$NON-NLS-1$
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
		this.parent=parent;
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout());
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		
		createFlabotFileSection(composite);
		
		setControl(composite);
		
		//TODO: INFO See how help is added
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.LAUNCHER_BASIC);
	}
	
	/**
	 * Creates the flabot file section
	 * @param composite
	 */
	protected void createFlabotFileSection(Composite composite) {
		Group group = new Group(composite, SWT.NONE);
		group.setText("Flabot File Selection");
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(group, SWT.NULL);
		label.setText("Flabot File");
		


		flabotFileText = new Text(group, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		flabotFileText.setLayoutData(gd);

		
		flabotFileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				flabotFileSelectionStatus = validateFlabotFileSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		flabotFileText.setEditable(false);

		Button button= new Button(group, SWT.NULL);
		button.setText("...");
		
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				browseFlabot();			
			}
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
			
		});
	}

	private void browseFlabot() {
		ISelectionStatusValidator validator=new CompositeValidator(
				new SelectionSizeValidator(EnginePlugin.SYMBOLIC_NAME, 1,1),
				new FileValidator(EnginePlugin.SYMBOLIC_NAME));
		
		Object[] files=ResourceSelectionDialog.getInstance().open(parent.getShell(),
				"Flabot File Selection", "Select a flabot file.",
				new FilePatternFilter(parent.getDisplay(), ".*\\.flabot"),
				validator, false);
		if(files!=null) {
			flabotFileText.setText(((IFile)files[0]).getFullPath().toPortableString());
		}
	}
	
	public void initializeFrom(ILaunchConfiguration config) {
		try {
			blockChanges = true;			
			initializeFlabotFileSection(config);
			flabotFileSelectionStatus = validateFlabotFileSelection();
			updateStatus();
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
		} finally {
			blockChanges = false;
		}
	}
	
	/**
	 * Initilizes the flabot file section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeFlabotFileSection(ILaunchConfiguration config)
			throws CoreException {
		
		String flabotFile=config.getAttribute(
				LaunchConfigurationConstants.FLABOT_FILE, "");
		flabotFileText.setText(flabotFile);
	}
	
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(LaunchConfigurationConstants.FLABOT_FILE, ""); //$NON-NLS-1$
	}
	
	/**
	 * Updates the tab status
	 *
	 */
	private void updateStatus() {
		updateStatus(flabotFileSelectionStatus);
	}

	public void performApply(ILaunchConfigurationWorkingCopy config) {
		try {
			saveFlabotFileDataSection(config);
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
		}
	}

	/**
	 * Saves the flabot file data
	 * @param config
	 * @throws CoreException
	 */
	protected void saveFlabotFileDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.FLABOT_FILE,
				flabotFileText.getText());
	}

	/**
	 * Validates the flabot file selection
	 * @return
	 */
	private IStatus validateFlabotFileSelection() {
		String flabotFile = flabotFileText.getText();
		if (flabotFile.trim().length()==0) {
			return createStatus(
				IStatus.ERROR,
				"Flabot file not selected.");
		}

		// TODO: check if file is valid
		if (false) {
			return createStatus(
				IStatus.ERROR,
				"Invalid flabotFile.");
		}

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}
	
	
	public String getName() {
		return "Main";
	}
	
	@Override
	public Image getImage() {
		return image;
	}
	
	/**
	 * Creates a new Status
	 * @param severity
	 * @param message
	 * @return
	 */
	private static IStatus createStatus(int severity, String message) {
		return AbstractConfigurationTab.createStatus(
				EnginePlugin.SYMBOLIC_NAME, severity, message);
	}	
}
