package org.isistan.flabot.launcher.tabs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.isistan.flabot.launcher.ExtensionPointConstants;
import org.isistan.flabot.launcher.LaunchConfigurationConstants;
import org.isistan.flabot.launcher.LauncherPlugin;
import org.isistan.flabot.launcher.collection.CollectionLauncherLoader;
import org.isistan.flabot.launcher.context.ContextProviderLoader;
import org.isistan.flabot.launcher.tabs.basic.MessageLaunchConfigurationTab;


/**
 * This is the Flabot main configuration tab
 * @author usuario
 *
 */
public class MainConfigurationTab extends AbstractConfigurationTab {

	/**
	 * The tab where the CollectionLauncher is configured
	 */
	private DelegatingConfigurationTab collectionLauncherConfigurationTab;
	
	/**
	 * The tab where the ContextProvider is configured
	 */
	private DelegatingConfigurationTab contextProviderConfigurationTab;
	
	
	/**
	 * Combo to select the target launch configuration
	 */
	private Combo launchConfigurationCombo;
	
	/**
	 * Combo to select the CollectionLauncher
	 */
	private Combo collectionLauncherCombo;
	
	/**
	 * Combo to select the ContextProvider
	 */
	private Combo contextProviderCombo;
	
	/**
	 * Text to select the output file
	 */
	private Text outputFileText;
	
	/**
	 * Tab image
	 */
	private Image image;

	/**
	 * Launch configuration selection status
	 */
	private IStatus launchConfigurationSelectionStatus;
	
	/**
	 * CollectionLauncher selection status
	 */
	private IStatus collectionLauncherSelectionStatus;
	
	/**
	 * ContextProvider selection status
	 */
	private IStatus contextProviderSelectionStatus;
	
	/**
	 * Output file selection status
	 */
	private IStatus outputFileSelectionStatus;
	
	
	/**
	 * Value indicating if changes can be done
	 */
	private boolean blockChanges = false;

	/**
	 * The available CollectionLaunchers 
	 */
	
	private IConfigurationElement[] collectionLaunchers;
	/**
	 * The available ContextProviders
	 */
	private IConfigurationElement[] contextProviders;

	private Composite parent;

	private Button startCollectingButton;


	/**
	 * Builds a new MainConfigurationTab
	 * @param collectionLauncherConfigurationTab
	 * @param contextProviderConfigurationTab
	 */
	public MainConfigurationTab(DelegatingConfigurationTab collectionLauncherConfigurationTab,
			DelegatingConfigurationTab contextProviderConfigurationTab) {
		this.collectionLauncherConfigurationTab=collectionLauncherConfigurationTab;
		this.contextProviderConfigurationTab=contextProviderConfigurationTab;

		launchConfigurationSelectionStatus = createStatus(IStatus.OK, ""); //$NON-NLS-1$
		collectionLauncherSelectionStatus = createStatus(IStatus.OK, ""); //$NON-NLS-1$
		contextProviderSelectionStatus = createStatus(IStatus.OK, ""); //$NON-NLS-1$
		outputFileSelectionStatus = createStatus(IStatus.OK, ""); //$NON-NLS-1$
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
		
		createLaunchConfigurationSection(composite);
		createCollectionLauncherSection(composite);
		createContextProviderSection(composite);
		createOutputFileSection(composite);
		createStartCollectingSection(composite);
		
		setControl(composite);
		
		//TODO: INFO See how help is added
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(composite, IHelpContextIds.LAUNCHER_BASIC);
	}
	
	/**
	 * Creates the launch configuration selection section
	 * @param composite
	 */
	protected void createLaunchConfigurationSection(Composite composite) {
		Group group = new Group(composite, SWT.NONE);
		group.setText("Launch Configuration Selection");
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(group, SWT.NULL);
		label.setText("Launch Configuration");

		launchConfigurationCombo = new Combo(group, SWT.DROP_DOWN);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		launchConfigurationCombo.setLayoutData(gd);
		launchConfigurationCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				launchConfigurationSelectionStatus = validateLaunchConfigurationSelection();
				if (!blockChanges) 
					updateStatus();
			}
		});
		launchConfigurationCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				launchConfigurationSelectionStatus = validateLaunchConfigurationSelection();				
				if (!blockChanges)
					updateStatus();
			}
		});
	}
	
	/**
	 * Creates the CollectionLauncher selection section
	 * @param composite
	 */
	protected void createCollectionLauncherSection(Composite composite) {
		Group group = new Group(composite, SWT.NONE);
		group.setText("Collection Launcher Selection");
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(group, SWT.NULL);
		label.setText("Collection Launcher");

		collectionLauncherCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		collectionLauncherCombo.setLayoutData(gd);
		collectionLauncherCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				collectionLauncherSelectionStatus = validateCollectionLauncherSelection();
				updateCollectionLauncherTabs();
				if (!blockChanges) 
					updateStatus();
			}
		});
		collectionLauncherCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				collectionLauncherSelectionStatus = validateCollectionLauncherSelection();
				updateCollectionLauncherTabs();
				if (!blockChanges)
					updateStatus();
			}
		});
	}
	
	/**
	 * Updates CollectionLauncher configuration tab
	 *
	 */
	private void updateCollectionLauncherTabs() {
		if(!collectionLauncherSelectionStatus.isOK()) {
			collectionLauncherConfigurationTab.setTab(new MessageLaunchConfigurationTab("No valid collection launcher selected."));
		} else if(collectionLauncherSelectionStatus.isOK()) {
			ILaunchConfigurationTab tab;
			try {
				tab = CollectionLauncherLoader.loadTab(
						collectionLaunchers[collectionLauncherCombo.getSelectionIndex()]);
			} catch (Exception e) {
				//TODO: send to log
				e.printStackTrace();
				return;
			}
			if(tab==null)
				tab=new MessageLaunchConfigurationTab("No configuration required for selected collection launcher.");
			collectionLauncherConfigurationTab.setTab(tab);
		}
	}
	
	/**
	 * Creates the ContextProvider selection section
	 * @param composite
	 */
	protected void createContextProviderSection(Composite composite) {
		Group group = new Group(composite, SWT.NONE);
		group.setText("Context Provider Selection");
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(group, SWT.NULL);
		label.setText("Context Provider");

		contextProviderCombo = new Combo(group, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		contextProviderCombo.setLayoutData(gd);
		contextProviderCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				contextProviderSelectionStatus = validateContextProviderSelection();
				updateContextProviderTabs();
				if (!blockChanges) 
					updateStatus();
			}
		});
		contextProviderCombo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				contextProviderSelectionStatus = validateContextProviderSelection();
				updateContextProviderTabs();
				if (!blockChanges)
					updateStatus();
			}
		});
	}
	
	/**
	 * Updates ContextProvider configuration tab
	 *
	 */
	private void updateContextProviderTabs() {
		if(!contextProviderSelectionStatus.isOK()) {
			contextProviderConfigurationTab.setTab(new MessageLaunchConfigurationTab("No valid context provider selected."));
		} else if(contextProviderSelectionStatus.isOK()) {
			ILaunchConfigurationTab tab;
			try {
				tab = ContextProviderLoader.loadTab(
						contextProviders[contextProviderCombo.getSelectionIndex()]);
			} catch (Exception e) {
				//TODO: send to log
				e.printStackTrace();
				return;
			}
			if(tab==null)
				tab=new MessageLaunchConfigurationTab("No configuration required for selected context provider.");
			contextProviderConfigurationTab.setTab(tab);
		}
	}

	/**
	 * Creates the output file selection section
	 * @param composite
	 */
	protected void createOutputFileSection(Composite composite) {
		Group group = new Group(composite, SWT.NONE);
		group.setText("Output File Selection");
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		group.setLayout(layout);
		group.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label label = new Label(group, SWT.NULL);
		label.setText("Output File");

		outputFileText = new Text(group, SWT.BORDER);
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		outputFileText.setLayoutData(gd);

		outputFileText.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				outputFileSelectionStatus = validateOutputFileSelection();
				if (!blockChanges)
					updateStatus();
			}
		});
		
		outputFileText.setEditable(false);
		
		Button button= new Button(group, SWT.NULL);
		button.setText("...");
		
		button.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				browseOutputFile();			
			}
			public void widgetDefaultSelected(SelectionEvent e) {				
			}
			
		});
	}
	private void browseOutputFile() {
		SaveAsDialog dialog= new SaveAsDialog(parent.getShell());
	
		String fileName=outputFileText.getText().trim();
		if (fileName.length()==0)
			dialog.setOriginalName(fileName);
		dialog.setTitle("Trace Log File Selection");
		//dialog.setMessage("Select where the trace log should be saved.");
		dialog.create();
		if (dialog.open() == Window.OK) {
			IPath path=dialog.getResult();
			if(path==null)
				return;
			String extension=path.getFileExtension();
			String file=path.toPortableString();
			if(extension==null || extension.length()==0) {
				file=file+".tracelog";
			}

			outputFileText.setText(file);
		}
		
		
	}
	
	/**
	 * Creates the start logging selection section
	 * @param composite
	 */
	protected void createStartCollectingSection(Composite composite) {
		startCollectingButton=new Button(composite, SWT.CHECK);
		startCollectingButton.setText("Start Collecting");
		startCollectingButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				if (!blockChanges) 
					updateStatus();
			}

			public void widgetDefaultSelected(SelectionEvent e) {
			}
			
		});
	}

	
	public void initializeFrom(ILaunchConfiguration config) {
		try {
			blockChanges = true;			
			initializeLaunchConfigurationSection(config);
			initializeCollectionLauncherSection(config);
			initializeContextProviderSection(config);
			initializeOutputFileSection(config);
			initializeStartCollectingSection(config);
			launchConfigurationSelectionStatus = validateLaunchConfigurationSelection();
			collectionLauncherSelectionStatus = validateCollectionLauncherSelection();
			contextProviderSelectionStatus = validateContextProviderSelection();
			outputFileSelectionStatus = validateOutputFileSelection();
			updateStatus();
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
		} finally {
			blockChanges = false;
		}
	}
	
	/**
	 * Initializes the launch configuration section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeLaunchConfigurationSection(ILaunchConfiguration config)
				throws CoreException {
		ILaunchConfiguration[] launchConfigurations=DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurations();
		
		List<String> launchConfigurationNames=new ArrayList<String>(launchConfigurations.length);
		for (int i = 0; i < launchConfigurations.length; i++) {
			ILaunchConfiguration launchConfiguration = launchConfigurations[i];
			String launchConfigurationName=launchConfiguration.getName();
			launchConfigurationNames.add(launchConfigurationName);
		}
		
		launchConfigurationCombo.setItems(launchConfigurationNames.toArray(new String[launchConfigurationNames.size()]));
		if (launchConfigurationCombo.getItemCount() > 0) {
			String selectedLaunchConfiguration=config.getAttribute(LaunchConfigurationConstants.TARGET_LAUNCH_CONFIGURATION, "");
			launchConfigurationCombo.setText(selectedLaunchConfiguration);
		}
	}
	
	/**
	 * Checks if the launch configuration is valid
	 * @param launchConfigurationName
	 * @return
	 */
	private boolean isValidLaunchConfiguration(String launchConfigurationName)  {
		ILaunchConfiguration[] configurationTypes;
		try {
			configurationTypes = DebugPlugin.getDefault().getLaunchManager().getLaunchConfigurations();
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
			return false;
		}
		for (ILaunchConfiguration configuration : configurationTypes) {
			if(configuration.getName().equals(launchConfigurationName)) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Initializes the CollectionLauncher section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeCollectionLauncherSection(ILaunchConfiguration config)
				throws CoreException {
		collectionLaunchers=
			CollectionLauncherLoader.getAllCollectionLauncherConfigurationElements();
		
		List<String> collectionLauncherNames=new ArrayList<String>(collectionLaunchers.length);
		for (int i = 0; i < collectionLaunchers.length; i++) {
			IConfigurationElement collectionLauncher = collectionLaunchers[i];
			String launchConfigurationName=getTextualRepresentation(collectionLauncher,
					ExtensionPointConstants.COLLECTION_LAUNCHER__NAME_ATTRIBUTE,
					ExtensionPointConstants.COLLECTION_LAUNCHER__ID_ATTRIBUTE);
			collectionLauncherNames.add(launchConfigurationName);
		}
		
		collectionLauncherCombo.setItems(collectionLauncherNames.toArray(new String[collectionLauncherNames.size()]));
		if (collectionLauncherCombo.getItemCount() > 0) {
			String selectedCollectionLauncherId=config.getAttribute(LaunchConfigurationConstants.COLLECTION_LAUNCHER_ID, "");
			int selection=idToIndex(collectionLaunchers, selectedCollectionLauncherId,
					ExtensionPointConstants.COLLECTION_LAUNCHER__ID_ATTRIBUTE);
			collectionLauncherCombo.select(selection);
		}
	}
	
	/**
	 * Returns a textual representation of the given element
	 * @param element
	 * @param nameAttribute
	 * @param idAttribute
	 * @return
	 */
	private String getTextualRepresentation(IConfigurationElement element,
			String nameAttribute, String idAttribute) {
		return element.getAttribute(nameAttribute);
	}
	
	/**
	 * Returns the index of the Configuration in the array using the id as key (attribute identified as the giver idAttribute)
	 * @param elements
	 * @param id
	 * @param idAttribute
	 * @return the index, -1 if not found
	 * @throws CoreException
	 */
	private int idToIndex(IConfigurationElement[] elements,
			String id, String idAttribute) throws CoreException {
		if(id.trim().length()==0)
			return -1;
		for (int i = 0; i < elements.length; i++) {
			IConfigurationElement collectionLauncher = elements[i];
			if(collectionLauncher.getAttribute(idAttribute)
					.equals(id)) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Obtains the id of the ConfigurationElement (attribute identified as the giver idAttribute) in the given index of the given array.
	 * @param elements
	 * @param index
	 * @param idAttribute
	 * @return the id, an empty string ("") if index is -1
	 * @throws CoreException
	 */
	private String indexToId(IConfigurationElement[] elements,
			int index, String idAttribute) throws CoreException {
		if(index==-1)
			return "";
		return elements[index].getAttribute(idAttribute);
	}
	
	/**
	 * Initializes the context provider section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeContextProviderSection(ILaunchConfiguration config)
				throws CoreException {
		contextProviders=
			ContextProviderLoader.getAllContextProviderConfigurationElements();
		
		List<String> contextProviderNames=new ArrayList<String>(contextProviders.length);
		for (int i = 0; i < contextProviders.length; i++) {
			IConfigurationElement contextProvider = contextProviders[i];
			String contextProviderName=getTextualRepresentation(contextProvider,
					ExtensionPointConstants.CONTEXT_PROVIDER__NAME_ATTRIBUTE,
					ExtensionPointConstants.CONTEXT_PROVIDER__ID_ATTRIBUTE);
			contextProviderNames.add(contextProviderName);
		}
		
		contextProviderCombo.setItems(contextProviderNames.toArray(new String[contextProviderNames.size()]));
		if (contextProviderCombo.getItemCount() > 0) {
			String selectedContextProviderId=config.getAttribute(LaunchConfigurationConstants.CONTEXT_PROVIDER_ID, "");
			int selection=idToIndex(contextProviders, selectedContextProviderId,
					ExtensionPointConstants.CONTEXT_PROVIDER__ID_ATTRIBUTE);
			contextProviderCombo.select(selection);
		}
	}
	
	/**
	 * Initializes the output file section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeOutputFileSection(ILaunchConfiguration config)
			throws CoreException {
		
		String outputFile=config.getAttribute(
				LaunchConfigurationConstants.OUTPUT_FILE, "");
		outputFileText.setText(outputFile);
	}
	
	/**
	 * Initializes the start tracing section
	 * @param config
	 * @throws CoreException
	 */
	protected void initializeStartCollectingSection(ILaunchConfiguration config)
			throws CoreException {
		
		String startCollecting=config.getAttribute(
				LaunchConfigurationConstants.START_COLLECTING, Boolean.FALSE.toString());
		if(startCollecting.trim().length()==0) {
			startCollecting=Boolean.FALSE.toString();
		}
		startCollectingButton.setSelection(Boolean.parseBoolean(startCollecting));
	}
	
	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(LaunchConfigurationConstants.TARGET_LAUNCH_CONFIGURATION, ""); //$NON-NLS-1$
		config.setAttribute(LaunchConfigurationConstants.COLLECTION_LAUNCHER_ID, ""); //$NON-NLS-1$
		config.setAttribute(LaunchConfigurationConstants.CONTEXT_PROVIDER_ID, ""); //$NON-NLS-1$
		config.setAttribute(LaunchConfigurationConstants.OUTPUT_FILE, ""); //$NON-NLS-1$
		config.setAttribute(LaunchConfigurationConstants.START_COLLECTING, Boolean.FALSE.toString()); //$NON-NLS-1$
	}
	
	/**
	 * Updates the the tab status with the worst status of all sections 
	 *
	 */
	private void updateStatus() {
		updateStatus(getMoreSevere(
				launchConfigurationSelectionStatus,
				collectionLauncherSelectionStatus,
				contextProviderSelectionStatus,
				outputFileSelectionStatus
			));
	}

	public void performApply(ILaunchConfigurationWorkingCopy config) {
		try {
			saveLaunchConfigurationDataSection(config);
			saveCollectionLauncherDataSection(config);
			saveContextProviderDataSection(config);
			saveOutputFileDataSection(config);
			saveStartCollectingDataSection(config);
		} catch (CoreException e) {
			//TODO: send to log
			e.printStackTrace();
		}
	}

	/**
	 * Returns the selected collectionLauncherId
	 * @return
	 * @throws CoreException
	 */
	private String getSelectedCollectionLauncherId() throws CoreException {
		return indexToId(collectionLaunchers, collectionLauncherCombo.getSelectionIndex(),
				ExtensionPointConstants.COLLECTION_LAUNCHER__ID_ATTRIBUTE);
	}

	/**
	 * Returns the selected contextProviderId
	 * @return
	 * @throws CoreException
	 */
	private String getSelectedContextProviderId() throws CoreException {
		return indexToId(contextProviders, contextProviderCombo.getSelectionIndex(),
				ExtensionPointConstants.CONTEXT_PROVIDER__ID_ATTRIBUTE);
	}

	/**
	 * Saves the target launch configuration section data 
	 * @param config
	 * @throws CoreException
	 */
	protected void saveLaunchConfigurationDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.TARGET_LAUNCH_CONFIGURATION, 
				launchConfigurationCombo.getText());
	}
	
	/**
	 * Saves the collection launcher data
	 * @param config
	 * @throws CoreException
	 */
	protected void saveCollectionLauncherDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.COLLECTION_LAUNCHER_ID,
				getSelectedCollectionLauncherId());
	}

	/**
	 * Saves the context provider data
	 * @param config
	 * @throws CoreException
	 */
	protected void saveContextProviderDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.CONTEXT_PROVIDER_ID,
				getSelectedContextProviderId());
	}
	
	
	/**
	 * Saves the output file data
	 * @param config
	 * @throws CoreException
	 */
	protected void saveOutputFileDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.OUTPUT_FILE,
				outputFileText.getText());
	}

	/**
	 * Saves the start collecting data
	 * @param config
	 * @throws CoreException
	 */
	protected void saveStartCollectingDataSection(ILaunchConfigurationWorkingCopy config)
			throws CoreException {
		config.setAttribute(LaunchConfigurationConstants.START_COLLECTING,
				Boolean.toString(startCollectingButton.getSelection()));
	}

	/**
	 * Validates the launch configuration selection
	 * @return
	 */
	private IStatus validateLaunchConfigurationSelection() {
		String launchConfiguration = launchConfigurationCombo.getText().trim();
		if (launchConfiguration.length()==0) {
			return createStatus(
				IStatus.ERROR,
				"Launch configuration not selected.");
		}

		if (!isValidLaunchConfiguration(launchConfiguration)) {
			return createStatus(
				IStatus.ERROR,
				"Invalid launch configuration.");
		}
		

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}
	
	/**
	 * Validates the collection launcher selection
	 * @return
	 */
	private IStatus validateCollectionLauncherSelection() {
		int collectionLauncher = collectionLauncherCombo.getSelectionIndex();
		if (collectionLauncher==-1) {
			return createStatus(
				IStatus.ERROR,
				"Collection launcher not selected.");
		}

		try {
			if (CollectionLauncherLoader.getCollectionLauncherConfigurationElement(
					getSelectedCollectionLauncherId())==null) {
				return createStatus(
					IStatus.ERROR,
					"Invalid collection launcher.");
			}
		} catch (CoreException e) {
			// TODO send to log
			e.printStackTrace();
		}
		

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}

	/**
	 * Validates the context provider selection
	 * @return
	 */
	private IStatus validateContextProviderSelection() {
		int contextProvider = contextProviderCombo.getSelectionIndex();
		if (contextProvider==-1) {
			return createStatus(
				IStatus.ERROR,
				"Context provider not selected.");
		}

		try {
			if (ContextProviderLoader.getContextProviderConfigurationElement(
					getSelectedContextProviderId())==null) {
				return createStatus(
					IStatus.ERROR,
					"Invalid context provider.");
			}
		} catch (CoreException e) {
			// TODO send to log
			e.printStackTrace();
		}
		

		return createStatus(IStatus.OK, ""); //$NON-NLS-1$
	}

	/**
	 * Validates the output file selection
	 * @return
	 */
	private IStatus validateOutputFileSelection() {
		String outputFile = outputFileText.getText();
		if (outputFile.trim().length()==0) {
			return createStatus(
				IStatus.ERROR,
				"Output file not selected.");
		}

		// TODO: check if file is valid
		if (false) {
			return createStatus(
				IStatus.ERROR,
				"Invalid output file.");
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
	 * Creates a status
	 * @param severity
	 * @param message
	 * @return
	 */
	private static IStatus createStatus(int severity, String message) {
		return AbstractConfigurationTab.createStatus(
				LauncherPlugin.SYMBOLIC_NAME, severity, message);
	}	
}
