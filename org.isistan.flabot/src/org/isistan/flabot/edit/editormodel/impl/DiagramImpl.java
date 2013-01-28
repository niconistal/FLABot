/**
 * <copyright>
 * </copyright>
 *
 * $Id: DiagramImpl.java,v 1.10 2005/12/06 20:53:43 franco Exp $
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.impl.NamedElementModelImpl;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.Folder;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagram</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.DiagramImpl#getCoreModel <em>Core Model</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.DiagramImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.DiagramImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.DiagramImpl#getFolder <em>Folder</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.DiagramImpl#getGridEnabled <em>Grid Enabled</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.DiagramImpl#getSnapToGeometryEnabled <em>Snap To Geometry Enabled</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class DiagramImpl extends NamedElementModelImpl implements Diagram {
	/**
	 * The cached value of the '{@link #getCoreModel() <em>Core Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCoreModel()
	 * @generated
	 * @ordered
	 */
	protected CoreModel coreModel = null;

	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected EList notes = null;

	/**
	 * The cached value of the '{@link #getChildren() <em>Children</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChildren()
	 * @generated
	 * @ordered
	 */
	protected EList children = null;

	/**
	 * The cached value of the '{@link #getFolder() <em>Folder</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFolder()
	 * @generated
	 * @ordered
	 */
	protected Folder folder = null;

	/**
	 * The default value of the '{@link #getGridEnabled() <em>Grid Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGridEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean GRID_ENABLED_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getGridEnabled() <em>Grid Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGridEnabled()
	 * @generated
	 * @ordered
	 */
	protected Boolean gridEnabled = GRID_ENABLED_EDEFAULT;

	/**
	 * The default value of the '{@link #getSnapToGeometryEnabled() <em>Snap To Geometry Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapToGeometryEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean SNAP_TO_GEOMETRY_ENABLED_EDEFAULT = Boolean.FALSE;

	/**
	 * The cached value of the '{@link #getSnapToGeometryEnabled() <em>Snap To Geometry Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapToGeometryEnabled()
	 * @generated
	 * @ordered
	 */
	protected Boolean snapToGeometryEnabled = SNAP_TO_GEOMETRY_ENABLED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getDiagram();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreModel getCoreModel() {
		if (coreModel != null && coreModel.eIsProxy()) {
			CoreModel oldCoreModel = coreModel;
			coreModel = (CoreModel)eResolveProxy((InternalEObject)coreModel);
			if (coreModel != oldCoreModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.DIAGRAM__CORE_MODEL, oldCoreModel, coreModel));
			}
		}
		return coreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreModel basicGetCoreModel() {
		return coreModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreModel(CoreModel newCoreModel) {
		CoreModel oldCoreModel = coreModel;
		coreModel = newCoreModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.DIAGRAM__CORE_MODEL, oldCoreModel, coreModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNotes() {
		if (notes == null) {
			notes = new EObjectContainmentEList(Note.class, this, EditormodelPackage.DIAGRAM__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList(VisualModel.class, this, EditormodelPackage.DIAGRAM__CHILDREN, EditormodelPackage.VISUAL_MODEL__DIAGRAM);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder getFolder() {
		if (folder != null && folder.eIsProxy()) {
			Folder oldFolder = folder;
			folder = (Folder)eResolveProxy((InternalEObject)folder);
			if (folder != oldFolder) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.DIAGRAM__FOLDER, oldFolder, folder));
			}
		}
		return folder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Folder basicGetFolder() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.DIAGRAM__FOLDER, oldFolder, newFolder);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFolder(Folder newFolder) {
		if (newFolder != folder) {
			NotificationChain msgs = null;
			if (folder != null)
				msgs = ((InternalEObject)folder).eInverseRemove(this, EditormodelPackage.FOLDER__DIAGRAMS, Folder.class, msgs);
			if (newFolder != null)
				msgs = ((InternalEObject)newFolder).eInverseAdd(this, EditormodelPackage.FOLDER__DIAGRAMS, Folder.class, msgs);
			msgs = basicSetFolder(newFolder, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.DIAGRAM__FOLDER, newFolder, newFolder));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getGridEnabled() {
		return gridEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGridEnabled(Boolean newGridEnabled) {
		Boolean oldGridEnabled = gridEnabled;
		gridEnabled = newGridEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.DIAGRAM__GRID_ENABLED, oldGridEnabled, gridEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getSnapToGeometryEnabled() {
		return snapToGeometryEnabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSnapToGeometryEnabled(Boolean newSnapToGeometryEnabled) {
		Boolean oldSnapToGeometryEnabled = snapToGeometryEnabled;
		snapToGeometryEnabled = newSnapToGeometryEnabled;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED, oldSnapToGeometryEnabled, snapToGeometryEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.DIAGRAM__CHILDREN:
					return ((InternalEList)getChildren()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.DIAGRAM__FOLDER:
					if (folder != null)
						msgs = ((InternalEObject)folder).eInverseRemove(this, EditormodelPackage.FOLDER__DIAGRAMS, Folder.class, msgs);
					return basicSetFolder((Folder)otherEnd, msgs);
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
				case EditormodelPackage.DIAGRAM__NOTES:
					return ((InternalEList)getNotes()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.DIAGRAM__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.DIAGRAM__FOLDER:
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
			case EditormodelPackage.DIAGRAM__NAME:
				return getName();
			case EditormodelPackage.DIAGRAM__CORE_MODEL:
				if (resolve) return getCoreModel();
				return basicGetCoreModel();
			case EditormodelPackage.DIAGRAM__NOTES:
				return getNotes();
			case EditormodelPackage.DIAGRAM__CHILDREN:
				return getChildren();
			case EditormodelPackage.DIAGRAM__FOLDER:
				if (resolve) return getFolder();
				return basicGetFolder();
			case EditormodelPackage.DIAGRAM__GRID_ENABLED:
				return getGridEnabled();
			case EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				return getSnapToGeometryEnabled();
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
			case EditormodelPackage.DIAGRAM__NAME:
				setName((String)newValue);
				return;
			case EditormodelPackage.DIAGRAM__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
				return;
			case EditormodelPackage.DIAGRAM__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection)newValue);
				return;
			case EditormodelPackage.DIAGRAM__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case EditormodelPackage.DIAGRAM__FOLDER:
				setFolder((Folder)newValue);
				return;
			case EditormodelPackage.DIAGRAM__GRID_ENABLED:
				setGridEnabled((Boolean)newValue);
				return;
			case EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				setSnapToGeometryEnabled((Boolean)newValue);
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
			case EditormodelPackage.DIAGRAM__NAME:
				setName(NAME_EDEFAULT);
				return;
			case EditormodelPackage.DIAGRAM__CORE_MODEL:
				setCoreModel((CoreModel)null);
				return;
			case EditormodelPackage.DIAGRAM__NOTES:
				getNotes().clear();
				return;
			case EditormodelPackage.DIAGRAM__CHILDREN:
				getChildren().clear();
				return;
			case EditormodelPackage.DIAGRAM__FOLDER:
				setFolder((Folder)null);
				return;
			case EditormodelPackage.DIAGRAM__GRID_ENABLED:
				setGridEnabled(GRID_ENABLED_EDEFAULT);
				return;
			case EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				setSnapToGeometryEnabled(SNAP_TO_GEOMETRY_ENABLED_EDEFAULT);
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
			case EditormodelPackage.DIAGRAM__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case EditormodelPackage.DIAGRAM__CORE_MODEL:
				return coreModel != null;
			case EditormodelPackage.DIAGRAM__NOTES:
				return notes != null && !notes.isEmpty();
			case EditormodelPackage.DIAGRAM__CHILDREN:
				return children != null && !children.isEmpty();
			case EditormodelPackage.DIAGRAM__FOLDER:
				return folder != null;
			case EditormodelPackage.DIAGRAM__GRID_ENABLED:
				return GRID_ENABLED_EDEFAULT == null ? gridEnabled != null : !GRID_ENABLED_EDEFAULT.equals(gridEnabled);
			case EditormodelPackage.DIAGRAM__SNAP_TO_GEOMETRY_ENABLED:
				return SNAP_TO_GEOMETRY_ENABLED_EDEFAULT == null ? snapToGeometryEnabled != null : !SNAP_TO_GEOMETRY_ENABLED_EDEFAULT.equals(snapToGeometryEnabled);
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
		result.append(" (gridEnabled: ");
		result.append(gridEnabled);
		result.append(", snapToGeometryEnabled: ");
		result.append(snapToGeometryEnabled);
		result.append(')');
		return result.toString();
	}

} //DiagramImpl
