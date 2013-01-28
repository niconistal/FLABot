/**
 * <copyright>
 * </copyright>
 *
 * $Id: FlabotFileModelImpl.java,v 1.26 2006/02/24 01:54:50 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.impl.ExtensibleElementImpl;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.util.EObjectIdGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Flabot File Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getCoreModel <em>Core Model</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getImportedFiles <em>Imported Files</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getFolder <em>Folder</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FlabotFileModelImpl#getOpenDiagrams <em>Open Diagrams</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FlabotFileModelImpl extends ExtensibleElementImpl implements FlabotFileModel {
	/**
	 * The cached value of the '{@link #getCoreModel() <em>Core Model</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreModel()
	 * @generated
	 * @ordered
	 */
	protected CoreModel coreModel = null;

	/**
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList diagrams = null;

	/**
	 * The cached value of the '{@link #getImportedFiles() <em>Imported Files</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportedFiles()
	 * @generated
	 * @ordered
	 */
	protected EList importedFiles = null;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "0.0.1";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected String provider = PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFolder() <em>Folder</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated NOT
	 * @ordered
	 */
	protected static final Folder FOLDER_DEFAULT = EditormodelFactory.eINSTANCE.createFolder("Diagrams");
	
	
	/**
	 * The cached value of the '{@link #getFolder() <em>Folder</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolder()
	 * @generated NOT
	 * @ordered
	 */
	protected Folder folder = FOLDER_DEFAULT;

	/**
	 * The cached value of the '{@link #getOpenDiagrams() <em>Open Diagrams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOpenDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList openDiagrams = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FlabotFileModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getFlabotFileModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreModel getCoreModel() {
		return coreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoreModel(CoreModel newCoreModel, NotificationChain msgs) {
		CoreModel oldCoreModel = coreModel;
		coreModel = newCoreModel;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL, oldCoreModel, newCoreModel);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreModel(CoreModel newCoreModel) {
		if (newCoreModel != coreModel) {
			NotificationChain msgs = null;
			if (coreModel != null)
				msgs = ((InternalEObject)coreModel).eInverseRemove(this, CoremodelPackage.CORE_MODEL__FILE, CoreModel.class, msgs);
			if (newCoreModel != null)
				msgs = ((InternalEObject)newCoreModel).eInverseAdd(this, CoremodelPackage.CORE_MODEL__FILE, CoreModel.class, msgs);
			msgs = basicSetCoreModel(newCoreModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL, newCoreModel, newCoreModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectContainmentEList(Diagram.class, this, EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getImportedFiles() {
		if (importedFiles == null) {
			importedFiles = new EObjectContainmentEList(FlabotFileModel.class, this, EditormodelPackage.FLABOT_FILE_MODEL__IMPORTED_FILES);
		}
		return importedFiles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getId() {
		return EObjectIdGenerator.getGeneratedEMFID(this);
	} 

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(String newProvider) {
		String oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__PROVIDER, oldProvider, provider));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder getFolder() {
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFolder(Folder newFolder, NotificationChain msgs) {
		Folder oldFolder = folder;
		folder = newFolder;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__FOLDER, oldFolder, newFolder);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * Set the folder's fileModel to this
	 */
	public void setFolder(Folder newFolder) {
		if (folder != null)
			folder.setFileModel(null);
		if (newFolder != null)
			newFolder.setFileModel(this);
		setFolderGen(newFolder);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFolderGen(Folder newFolder) {
		if (newFolder != folder) {
			NotificationChain msgs = null;
			if (folder != null)
				msgs = ((InternalEObject)folder).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.FLABOT_FILE_MODEL__FOLDER, null, msgs);
			if (newFolder != null)
				msgs = ((InternalEObject)newFolder).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.FLABOT_FILE_MODEL__FOLDER, null, msgs);
			msgs = basicSetFolder(newFolder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FLABOT_FILE_MODEL__FOLDER, newFolder, newFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOpenDiagrams() {
		if (openDiagrams == null) {
			openDiagrams = new EObjectResolvingEList(Diagram.class, this, EditormodelPackage.FLABOT_FILE_MODEL__OPEN_DIAGRAMS);
		}
		return openDiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL:
					if (coreModel != null)
						msgs = ((InternalEObject)coreModel).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL, null, msgs);
					return basicSetCoreModel((CoreModel)otherEnd, msgs);
				default:
					return eDynamicInverseAdd(otherEnd, featureID, baseClass, msgs);
			}
		}
		if (eContainer != null)
			msgs = eBasicRemoveFromContainer(msgs);
		return eBasicSetContainer(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.FLABOT_FILE_MODEL__EXTENDED_DATA:
					return ((InternalEList)getExtendedData()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL:
					return basicSetCoreModel(null, msgs);
				case EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS:
					return ((InternalEList)getDiagrams()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.FLABOT_FILE_MODEL__IMPORTED_FILES:
					return ((InternalEList)getImportedFiles()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.FLABOT_FILE_MODEL__FOLDER:
					return basicSetFolder(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.FLABOT_FILE_MODEL__EXTENDED_DATA:
				return getExtendedData();
			case EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL:
				return getCoreModel();
			case EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS:
				return getDiagrams();
			case EditormodelPackage.FLABOT_FILE_MODEL__IMPORTED_FILES:
				return getImportedFiles();
			case EditormodelPackage.FLABOT_FILE_MODEL__ID:
				return getId();
			case EditormodelPackage.FLABOT_FILE_MODEL__VERSION:
				return getVersion();
			case EditormodelPackage.FLABOT_FILE_MODEL__NAME:
				return getName();
			case EditormodelPackage.FLABOT_FILE_MODEL__PROVIDER:
				return getProvider();
			case EditormodelPackage.FLABOT_FILE_MODEL__FOLDER:
				return getFolder();
			case EditormodelPackage.FLABOT_FILE_MODEL__OPEN_DIAGRAMS:
				return getOpenDiagrams();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.FLABOT_FILE_MODEL__EXTENDED_DATA:
				getExtendedData().clear();
				getExtendedData().addAll((Collection)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__IMPORTED_FILES:
				getImportedFiles().clear();
				getImportedFiles().addAll((Collection)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__ID:
				setId((String)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__VERSION:
				setVersion((String)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__NAME:
				setName((String)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__PROVIDER:
				setProvider((String)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__FOLDER:
				setFolder((Folder)newValue);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__OPEN_DIAGRAMS:
				getOpenDiagrams().clear();
				getOpenDiagrams().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.FLABOT_FILE_MODEL__EXTENDED_DATA:
				getExtendedData().clear();
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL:
				setCoreModel((CoreModel)null);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS:
				getDiagrams().clear();
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__IMPORTED_FILES:
				getImportedFiles().clear();
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__ID:
				setId(ID_EDEFAULT);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__FOLDER:
				setFolder((Folder)null);
				return;
			case EditormodelPackage.FLABOT_FILE_MODEL__OPEN_DIAGRAMS:
				getOpenDiagrams().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.FLABOT_FILE_MODEL__EXTENDED_DATA:
				return extendedData != null && !extendedData.isEmpty();
			case EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL:
				return coreModel != null;
			case EditormodelPackage.FLABOT_FILE_MODEL__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case EditormodelPackage.FLABOT_FILE_MODEL__IMPORTED_FILES:
				return importedFiles != null && !importedFiles.isEmpty();
			case EditormodelPackage.FLABOT_FILE_MODEL__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case EditormodelPackage.FLABOT_FILE_MODEL__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case EditormodelPackage.FLABOT_FILE_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EditormodelPackage.FLABOT_FILE_MODEL__PROVIDER:
				return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
			case EditormodelPackage.FLABOT_FILE_MODEL__FOLDER:
				return folder != null;
			case EditormodelPackage.FLABOT_FILE_MODEL__OPEN_DIAGRAMS:
				return openDiagrams != null && !openDiagrams.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer();
		String name = getName();
		if (name == null || name.trim().equals(""))
			result.append("(anonymous flabot file)");
		else
			result.append(name);
		result.append(" - id: ");
		String id = getId();
		result.append(id);
		result.append(", version: ");
		String version = getVersion();
		result.append(version);
		result.append(", provider: ");
		String provider = getProvider();
		result.append(provider);
		return result.toString();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public List getAllImportedFiles() {
		List allImports = new ArrayList();
		allImports.addAll(getImportedFiles());
				
		List imported = getImportedFiles();
		for(Iterator iter =imported.iterator(); iter.hasNext();) {
			FlabotFileModel ffm = (FlabotFileModel) iter.next();
			allImports.addAll(ffm.getAllImportedFiles());
		}
		return allImports;
	}
} //FlabotFileModelImpl
