package org.isistan.flabot.launcher.tabs;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;


/**
 * A ILaunchConfigurationTab that delegates everithing to an internal tab, so it can
 * be changed even when the tab group was already created.
 * @author usuario
 *
 */
public class DelegatingConfigurationTab implements ILaunchConfigurationTab {

	/**
	 * The internal tab to which everithing is delegated 
	 */
	private ILaunchConfigurationTab tab;
	
	/**
	 * The launch configuration on with this tab is working
	 */
	private ILaunchConfiguration configuration;

	/**
	 * The name of the tab (cannot change this even if the internal tab is changed)
	 */
	private String name;
	
	/**
	 * The image of the tab (cannot change this even if the internal tab is changed)
	 */
	private Image image;
	
	/**
	 * Container of this tab controls (that is, the persistentContainer)
	 */
	private Composite parent=null;
	
	/**
	 * The container of the internal tab controls (changes when internal tab is changed)
	 */
	private Composite container=null;
	
	/**
	 * The container for this tab controls (that is, the changing internal tab's container)
	 */
	private Composite persistentContainer=null;

	/**
	 * The dialog where this tab is contained
	 */
	private ILaunchConfigurationDialog dialog;

	
	/**
	 * Creates a new DelegatingConfigurationTab, initially showing the given tab.
	 * @param name
	 * @param image
	 * @param tab
	 */
	public DelegatingConfigurationTab(String name, Image image, ILaunchConfigurationTab tab) {
		this.name=name;
		this.image=image;
		this.tab=tab;
	}
	
	/**
	 * Initializes a composite
	 * @param parentContainer
	 * @return
	 */
	private static Composite initializeContainer(Composite parentContainer) {
		Composite newContainer = new Composite(parentContainer, SWT.NONE);
		newContainer.setLayout(new GridLayout());
		newContainer.setLayoutData(new GridData(GridData.FILL_BOTH));
		newContainer.setVisible(true);
		
		return newContainer;
	}
	
	/**
	 * Changes the internal tab
	 * @param tab
	 */
	public void setTab(ILaunchConfigurationTab tab) {
		if(tab==this.tab) {
			return;
		}
		assert dialog !=null;
		assert persistentContainer !=null;

		this.tab.dispose();
		this.tab=tab;
		container.dispose();
		container = initializeContainer(persistentContainer);
		
		setLaunchConfigurationDialog(dialog);
		
		tab.createControl(container);
		parent.layout();
		container.layout();
		persistentContainer.layout();
		if(configuration!=null)
			tab.initializeFrom(configuration);
	}

	/**
	 * Returns the current internal tab
	 * @return
	 */
	public ILaunchConfigurationTab getTab() {
		return tab;
	}

	public void createControl(Composite parent) {
		assert container==null;
		assert this.parent==null;
		
		this.parent=parent;
		persistentContainer = initializeContainer(parent);
		container = initializeContainer(persistentContainer);
		
		tab.createControl(container);
		container.setSize(container.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		parent.layout();
		container.layout();
		persistentContainer.layout();

	}

	public Control getControl() {
		return persistentContainer;
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		tab.setDefaults(configuration);
	}

	public void initializeFrom(ILaunchConfiguration configuration) {
		assert this.configuration==null;
		this.configuration=configuration;
		tab.initializeFrom(configuration);
	}

	public void dispose() {
		tab.dispose();
		if(container!=null)
			container.dispose();
		if(persistentContainer!=null)
			persistentContainer.dispose();
	}

	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		tab.performApply(configuration);		
	}

	public String getErrorMessage() {
		return tab.getErrorMessage();
	}

	public String getMessage() {
		return tab.getMessage();
	}

	public boolean isValid(ILaunchConfiguration configuration) {
		return tab.isValid(configuration);
	}

	public boolean canSave() {
		return tab.canSave();
	}
	
	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {
		assert dialog==null;
		
		this.dialog=dialog;
		
		tab.setLaunchConfigurationDialog(dialog);
		
	}

	@Deprecated
	public void launched(ILaunch launch) {
		tab.launched(launch);		
	}

	/**
	 * Returns always the name given to the construcor, does not delegate to the internal tab
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns always the image given to the construcor, does not delegate to the internal tab
	 */
	public Image getImage() {
		return image;
	}

	public void activated(ILaunchConfigurationWorkingCopy configuration) {
		tab.activated(configuration);
	}

	public void deactivated(ILaunchConfigurationWorkingCopy configuration) {
		tab.deactivated(configuration);
		
	}

}
