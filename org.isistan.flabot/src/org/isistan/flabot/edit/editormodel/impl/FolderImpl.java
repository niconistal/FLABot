/**
 * <copyright>
 * </copyright>
 *
 * $Id: FolderImpl.java,v 1.4 2005/11/30 18:23:17 dacostae Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.Folder;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Folder</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FolderImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FolderImpl#getFolders <em>Folders</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FolderImpl#getDiagrams <em>Diagrams</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FolderImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.FolderImpl#getFileModel <em>File Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FolderImpl extends EObjectImpl implements Folder {
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
	 * The cached value of the '{@link #getFolders() <em>Folders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolders()
	 * @generated
	 * @ordered
	 */
	protected EList folders = null;

	/**
	 * The cached value of the '{@link #getDiagrams() <em>Diagrams</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList diagrams = null;

	/**
	 * The cached value of the '{@link #getFileModel() <em>File Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFileModel()
	 * @generated
	 * @ordered
	 */
	protected FlabotFileModel fileModel = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FolderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getFolder();
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
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FOLDER__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFolders() {
		if (folders == null) {
			folders = new EObjectContainmentWithInverseEList(Folder.class, this, EditormodelPackage.FOLDER__FOLDERS, EditormodelPackage.FOLDER__PARENT);
		}
		return folders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDiagrams() {
		if (diagrams == null) {
			diagrams = new EObjectWithInverseResolvingEList(Diagram.class, this, EditormodelPackage.FOLDER__DIAGRAMS, EditormodelPackage.DIAGRAM__FOLDER);
		}
		return diagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder getParent() {
		if (eContainerFeatureID != EditormodelPackage.FOLDER__PARENT) return null;
		return (Folder)eContainer;
	}

	/**
	 * Set the fileModel to the same as the parent folder's
	 */
	public void setParent(Folder newParent) {
		if (newParent != null)
			this.setFileModel(newParent.getFileModel());
		else
			this.setFileModel(null);
		setParentGen(newParent);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentGen(Folder newParent) {
		if (newParent != eContainer || (eContainerFeatureID != EditormodelPackage.FOLDER__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, EditormodelPackage.FOLDER__FOLDERS, Folder.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newParent, EditormodelPackage.FOLDER__PARENT, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FOLDER__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlabotFileModel getFileModel() {
		if (fileModel != null && fileModel.eIsProxy()) {
			FlabotFileModel oldFileModel = fileModel;
			fileModel = (FlabotFileModel)eResolveProxy((InternalEObject)fileModel);
			if (fileModel != oldFileModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.FOLDER__FILE_MODEL, oldFileModel, fileModel));
			}
		}
		return fileModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlabotFileModel basicGetFileModel() {
		return fileModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFileModel(FlabotFileModel newFileModel) {
		FlabotFileModel oldFileModel = fileModel;
		fileModel = newFileModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.FOLDER__FILE_MODEL, oldFileModel, fileModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.FOLDER__FOLDERS:
					return ((InternalEList)getFolders()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.FOLDER__DIAGRAMS:
					return ((InternalEList)getDiagrams()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.FOLDER__PARENT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.FOLDER__PARENT, msgs);
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
				case EditormodelPackage.FOLDER__FOLDERS:
					return ((InternalEList)getFolders()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.FOLDER__DIAGRAMS:
					return ((InternalEList)getDiagrams()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.FOLDER__PARENT:
					return eBasicSetContainer(null, EditormodelPackage.FOLDER__PARENT, msgs);
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
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case EditormodelPackage.FOLDER__PARENT:
					return eContainer.eInverseRemove(this, EditormodelPackage.FOLDER__FOLDERS, Folder.class, msgs);
				default:
					return eDynamicBasicRemoveFromContainer(msgs);
			}
		}
		return eContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE - eContainerFeatureID, null, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.FOLDER__NAME:
				return getName();
			case EditormodelPackage.FOLDER__FOLDERS:
				return getFolders();
			case EditormodelPackage.FOLDER__DIAGRAMS:
				return getDiagrams();
			case EditormodelPackage.FOLDER__PARENT:
				return getParent();
			case EditormodelPackage.FOLDER__FILE_MODEL:
				if (resolve) return getFileModel();
				return basicGetFileModel();
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
			case EditormodelPackage.FOLDER__NAME:
				setName((String)newValue);
				return;
			case EditormodelPackage.FOLDER__FOLDERS:
				getFolders().clear();
				getFolders().addAll((Collection)newValue);
				return;
			case EditormodelPackage.FOLDER__DIAGRAMS:
				getDiagrams().clear();
				getDiagrams().addAll((Collection)newValue);
				return;
			case EditormodelPackage.FOLDER__PARENT:
				setParent((Folder)newValue);
				return;
			case EditormodelPackage.FOLDER__FILE_MODEL:
				setFileModel((FlabotFileModel)newValue);
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
			case EditormodelPackage.FOLDER__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EditormodelPackage.FOLDER__FOLDERS:
				getFolders().clear();
				return;
			case EditormodelPackage.FOLDER__DIAGRAMS:
				getDiagrams().clear();
				return;
			case EditormodelPackage.FOLDER__PARENT:
				setParent((Folder)null);
				return;
			case EditormodelPackage.FOLDER__FILE_MODEL:
				setFileModel((FlabotFileModel)null);
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
			case EditormodelPackage.FOLDER__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EditormodelPackage.FOLDER__FOLDERS:
				return folders != null && !folders.isEmpty();
			case EditormodelPackage.FOLDER__DIAGRAMS:
				return diagrams != null && !diagrams.isEmpty();
			case EditormodelPackage.FOLDER__PARENT:
				return getParent() != null;
			case EditormodelPackage.FOLDER__FILE_MODEL:
				return fileModel != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //FolderImpl
