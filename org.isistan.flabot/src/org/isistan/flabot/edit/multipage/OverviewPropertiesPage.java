/**
 * $Id: OverviewPropertiesPage.java,v 1.17 2006/04/06 00:15:38 mblech Exp $
 * $Author: mblech $
 */
package org.isistan.flabot.edit.multipage;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.events.ExpansionAdapter;
import org.eclipse.ui.forms.events.ExpansionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.forms.widgets.TableWrapData;
import org.eclipse.ui.forms.widgets.TableWrapLayout;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.componentmodel.ComponentmodelPackage;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.ucmmodel.UcmmodelPackage;
import org.isistan.flabot.messages.Messages;
import org.isistan.flabot.util.emf.WorkaroundURIConverter;
import org.isistan.flabot.util.resource.ResourceSelectionDialog;
import org.isistan.flabot.util.resource.filter.FilePatternFilter;
import org.isistan.flabot.util.resource.validator.CompositeValidator;
import org.isistan.flabot.util.resource.validator.FileValidator;
import org.isistan.flabot.util.resource.validator.SelectionSizeValidator;

/**
 * @author $Author: mblech $
 *
 */
public class OverviewPropertiesPage extends FlabotFormPage {

	private static final String PAGE_TITLE = Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.overiviewTabName"); //$NON-NLS-1$
	private static final String PAGE_ID = "org.isistan.flabot.edit.multipage.OverviewPropertiesPage"; //$NON-NLS-1$
	private FormToolkit toolkit;
	private SectionPart spart;
	private IManagedForm managedForm;

	public OverviewPropertiesPage(FormEditor editor, FlabotFileModel model) {
		super(editor, PAGE_ID, PAGE_TITLE, model);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.forms.editor.FormPage#createFormContent(org.eclipse.ui.forms.IManagedForm)
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		final ScrolledForm form = managedForm.getForm();
		this.managedForm = managedForm;
		toolkit = managedForm.getToolkit();
		form.setText(Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.overviewTabText")); //$NON-NLS-1$
		
		GridLayout layout = new GridLayout();
		form.getBody().setLayout(layout);
		
		layout.numColumns = 2;
		Label label;
		GridData gd;
		
		// first section: General information
		Section section = toolkit.createSection(form.getBody(), 
				Section.DESCRIPTION|Section.EXPANDED);
		gd = new GridData(GridData.VERTICAL_ALIGN_BEGINNING);
		gd.widthHint = 200;
		section.setLayoutData(gd);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		section.setText(Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.generalInformationSectionName")); //$NON-NLS-1$
		toolkit.createCompositeSeparator(section);
		section.setDescription(Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.generalInformationSectionDescription")); //$NON-NLS-1$
		Composite sectionClient = toolkit.createComposite(section);
		TableWrapLayout clientLayout = new TableWrapLayout();
		clientLayout.numColumns = 2;
		sectionClient.setLayout(clientLayout);
		spart = new SectionPart(section);
		managedForm.addPart(spart);
		label = toolkit.createLabel(sectionClient, Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.version")); //$NON-NLS-1$
		TableWrapData td = new TableWrapData(TableWrapData.LEFT);
		label.setLayoutData(td);
		Text text = toolkit.createText(sectionClient, getModel().getVersion());
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String value = ((Text)e.getSource()).getText();
				getModel().setVersion(value);
				spart.markDirty();
			}			
		});
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		text.setLayoutData(td);
		label = toolkit.createLabel(sectionClient, Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.name")); //$NON-NLS-1$
		td = new TableWrapData(TableWrapData.LEFT);
		label.setLayoutData(td);
		text = toolkit.createText(sectionClient, getModel().getName());
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String value = ((Text)e.getSource()).getText();
				getModel().setName(value);
				spart.markDirty();
			}			
		});
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		text.setLayoutData(td);
		label = toolkit.createLabel(sectionClient, Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.provider")); //$NON-NLS-1$
		td = new TableWrapData(TableWrapData.LEFT);
		label.setLayoutData(td);
		text = toolkit.createText(sectionClient, getModel().getProvider());
		text.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String value = ((Text)e.getSource()).getText();
				getModel().setProvider(value);
				spart.markDirty();
			}			
		});
		td = new TableWrapData(TableWrapData.FILL_GRAB);
		text.setLayoutData(td);
		toolkit.paintBordersFor(sectionClient);
		section.setClient(sectionClient);
	
		// second section: file content
		section = toolkit.createSection(form.getBody(), 
				Section.DESCRIPTION|Section.EXPANDED);
		gd = new GridData(GridData.FILL_BOTH);
		section.setLayoutData(gd);
		section.addExpansionListener(new ExpansionAdapter() {
			public void expansionStateChanged(ExpansionEvent e) {
				form.reflow(true);
			}
		});
		section.setText(Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.importExternalFileSectionName")); //$NON-NLS-1$
		toolkit.createCompositeSeparator(section);
		section.setDescription(Messages.getString("org.isistan.flabot.edit.multipage.OverviewPropertiesPage.importExternalFileSectionDescription")); //$NON-NLS-1$
		sectionClient = toolkit.createComposite(section);
		clientLayout = new TableWrapLayout();
		clientLayout.numColumns = 2;
		sectionClient.setLayout(clientLayout);
		Button button = toolkit.createButton(sectionClient, "Import...", SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				importFlabotFile();
			}
		});
		section.setClient(sectionClient);
		toolkit.paintBordersFor(sectionClient);
	}

	protected void importFlabotFile() {
		ISelectionStatusValidator validator=new CompositeValidator(
				new SelectionSizeValidator(FlabotPlugin.SYMBOLIC_NAME, 1,1),
				new FileValidator(FlabotPlugin.SYMBOLIC_NAME));
		
		Object[] files=ResourceSelectionDialog.getInstance().open(managedForm.getForm().getShell(),
				"Select flabot file to import",
				"The selected file's models and diagrams will be imported to the current flabot file",
				new FilePatternFilter(managedForm.getForm().getDisplay(), ".*\\.flabot"),
				validator, false);
		if(files!=null) {
			String filePath = ((IFile)files[0]).getFullPath().toPortableString();
			FlabotFileModel importedFileModel = loadFlabotFile(filePath);
			FlabotFileModel targetFileModel = getModel();
			if (targetFileModel.getName().equals(importedFileModel.getName()))
				MessageDialog.openError(managedForm.getForm().getShell(), "Error importing file", 
						"Can't import the file '" + filePath + "' because it has the same unique name " +
								"as the current file ('" + targetFileModel.getName() + "').");
			else
				doImport(targetFileModel, importedFileModel);
		}
	}

	private void doImport(FlabotFileModel targetFileModel, FlabotFileModel importedFileModel) {
		// import core model
		CoreModel targetCoreModel = targetFileModel.getCoreModel();
		CoreModel importedCoreModel = importedFileModel.getCoreModel();
		List<UseCaseMap> ucmList = new ArrayList<UseCaseMap>(importedCoreModel.getUseCaseMaps());
		for (UseCaseMap ucm: ucmList) {
			fixUCMName(targetCoreModel, ucm);
			targetCoreModel.getUseCaseMaps().add(ucm);
			ucm.setCoreModel(targetCoreModel);
		}
		List<ComponentModel> componentList = new ArrayList<ComponentModel>(importedCoreModel.getComponents());
		for (ComponentModel component: componentList) {
			fixComponentName(targetCoreModel, component);
			targetCoreModel.getComponents().add(component);
			component.setCoreModel(targetCoreModel);
		}
		List<Responsibility> responsibilityList = new ArrayList<Responsibility>(importedCoreModel.getResponsibilities());
		for (Responsibility responsibility: responsibilityList) {
			fixResponsibilityName(targetCoreModel, responsibility);
			targetCoreModel.getResponsibilities().add(responsibility);
			responsibility.setCoreModel(targetCoreModel);
		}
		List<InterfaceLink> interfaceLinkList = new ArrayList<InterfaceLink>(importedCoreModel.getInterfaceLinks());
		for (InterfaceLink interfaceLink: interfaceLinkList) {
			fixInterfaceLinkName(targetCoreModel, interfaceLink);
			targetCoreModel.getInterfaceLinks().add(interfaceLink);
		}
		List<Relationship> relationshipList = new ArrayList<Relationship>(importedCoreModel.getRelationships());
		for (Relationship relationship: relationshipList) {
			fixRelationshipName(targetCoreModel, relationship);
			targetCoreModel.getRelationships().add(relationship);
		}
		List<Stereotype> stereotypeList = new ArrayList<Stereotype>(importedCoreModel.getStereotypes());
		for (Stereotype stereotype: stereotypeList) {
			fixStereotypeName(targetCoreModel, stereotype);
			targetCoreModel.getStereotypes().add(stereotype);
		}
		List<Family> familyList = new ArrayList<Family>(importedCoreModel.getFamilies());
		for (Family family: familyList) {
			fixFamilyName(targetCoreModel, family);
			targetCoreModel.getFamilies().add(family);
		}
		targetCoreModel.getArchitecturalUseCaseMaps().addAll(importedCoreModel.getArchitecturalUseCaseMaps());
		targetCoreModel.getFunctionalUseCaseMaps().addAll(importedCoreModel.getFunctionalUseCaseMaps());
		List<ConditionEvent> eventList = new ArrayList<ConditionEvent>(importedCoreModel.getEvents());
		for (ConditionEvent event: eventList) {
			fixEventName(targetCoreModel, event);
			targetCoreModel.getEvents().add(event);
		}
		List<StubNode> stubList = new ArrayList<StubNode>(importedCoreModel.getStubs());
		for (StubNode stub: stubList) {
			fixStubName(targetCoreModel, stub);
		}
		
		// import diagrams
		Folder importedFolder = EditormodelFactory.eINSTANCE.createFolder("Imported from: '" + importedFileModel.getName() + "'");
		importedFolder.setParent(targetFileModel.getFolder());
		targetFileModel.getFolder().getFolders().add(importedFolder);
		List<Diagram> diagramList = new ArrayList<Diagram>(importedFileModel.getDiagrams());
		for (Diagram diagram: diagramList) {
			fixDiagramName(targetFileModel, diagram);
			targetFileModel.getDiagrams().add(diagram);
			diagram.setCoreModel(targetCoreModel);
			diagram.setFolder(importedFolder);
		}
	}

	private void fixDiagramName(FlabotFileModel targetFileModel, Diagram diagram) {
		// TODO Auto-generated method stub
		
	}

	private void fixStubName(CoreModel targetCoreModel, StubNode stub) {
		// TODO Auto-generated method stub
		
	}

	private void fixEventName(CoreModel targetCoreModel, ConditionEvent event) {
		// TODO Auto-generated method stub
		
	}

	private void fixFamilyName(CoreModel coreModel, Family family) {
		// TODO Auto-generated method stub
		
	}

	private void fixStereotypeName(CoreModel coreModel, Stereotype stereotype) {
		// TODO Auto-generated method stub
		
	}

	private void fixRelationshipName(CoreModel coreModel, Relationship relationship) {
		// TODO Auto-generated method stub
		
	}

	private void fixInterfaceLinkName(CoreModel coreModel, InterfaceLink interfaceLink) {
		// TODO Auto-generated method stub
		
	}

	private void fixResponsibilityName(CoreModel coreModel, Responsibility responsibility) {
		// TODO Auto-generated method stub
		
	}

	private void fixComponentName(CoreModel coreModel, ComponentModel component) {
		// TODO Auto-generated method stub
		
	}

	private void fixUCMName(CoreModel coreModel, UseCaseMap ucm) {
		// TODO Auto-generated method stub
		
	}

	private FlabotFileModel loadFlabotFile(String filePath) {// initialize packages so their factories are registered and the model
		URI uri = URI.createPlatformResourceURI(filePath);
		// is loaded correctly
		ComponentmodelPackage cmp = ComponentmodelPackage.eINSTANCE;
		UcmmodelPackage ucmmp = UcmmodelPackage.eINSTANCE;
		
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource;
		
		// modify the load options so that files are loaded even without
		// the required EMF packages
		resourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE,
				Boolean.TRUE);
		
		// Workaround for a bug in sun.net.spi.DefaultProxySelector
		// or sun.net.www.protocol.http.HttpURLConnection
		resourceSet.setURIConverter(new WorkaroundURIConverter());
		
		resource = resourceSet.getResource(uri, true);
        if (resource != null) {
        	return (FlabotFileModel) resource.getContents().get(0);
        }
        return null;
	}

	public void unsetDirty() {
		if (spart != null)
			spart.refresh();
		this.firePropertyChange(PROP_DIRTY);
	}
}