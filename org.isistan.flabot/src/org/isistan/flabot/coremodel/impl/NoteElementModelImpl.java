/**
 * <copyright>
 * </copyright>
 *
 * $Id: NoteElementModelImpl.java,v 1.1 2005/10/06 17:57:24 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.NoteElementModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Note Element Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.NoteElementModelImpl#getNotes <em>Notes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NoteElementModelImpl extends EObjectImpl implements NoteElementModel {
	/**
	 * The cached value of the '{@link #getNotes() <em>Notes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNotes()
	 * @generated
	 * @ordered
	 */
	protected EList notes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NoteElementModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.NOTE_ELEMENT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNotes() {
		if (notes == null) {
			notes = new EObjectResolvingEList(Note.class, this, CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES:
				return getNotes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES:
				getNotes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES:
				return notes != null && !notes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NoteElementModelImpl
