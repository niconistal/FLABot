/**
 * <copyright>
 * </copyright>
 *
 * $Id: FamilyImpl.java,v 1.12 2006/04/11 23:31:50 franco Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Family</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyImpl#getFamilyElement <em>Family Element</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyImpl#getAssociatedResponsibilities <em>Associated Responsibilities</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyImpl#getArchitecturalUseCaseMaps <em>Architectural Use Case Maps</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyImpl#getFunctionalUseCaseMaps <em>Functional Use Case Maps</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.FamilyImpl#getEvents <em>Events</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FamilyImpl extends NamedElementModelImpl implements Family {
	/**
	 * The cached value of the '{@link #getFamilyElement() <em>Family Element</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamilyElement()
	 * @generated
	 * @ordered
	 */
	protected EList familyElement;

	/**
	 * The cached value of the '{@link #getAssociatedResponsibilities() <em>Associated Responsibilities</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssociatedResponsibilities()
	 * @generated
	 * @ordered
	 */
	protected EList associatedResponsibilities;

	/**
	 * The cached value of the '{@link #getArchitecturalUseCaseMaps() <em>Architectural Use Case Maps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArchitecturalUseCaseMaps()
	 * @generated
	 * @ordered
	 */
	protected EList architecturalUseCaseMaps;

	/**
	 * The cached value of the '{@link #getFunctionalUseCaseMaps() <em>Functional Use Case Maps</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionalUseCaseMaps()
	 * @generated
	 * @ordered
	 */
	protected EList functionalUseCaseMaps;

	/**
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EMap events;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FamilyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.FAMILY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFamilyElement() {
		if (familyElement == null) {
			familyElement = new EObjectContainmentEList(FamilyElement.class, this, CoremodelPackage.FAMILY__FAMILY_ELEMENT);
		}
		return familyElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAssociatedResponsibilities() {
		if (associatedResponsibilities == null) {
			associatedResponsibilities = new EObjectResolvingEList(SimplePathNode.class, this, CoremodelPackage.FAMILY__ASSOCIATED_RESPONSIBILITIES);
		}
		return associatedResponsibilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getArchitecturalUseCaseMaps() {
		if (architecturalUseCaseMaps == null) {
			architecturalUseCaseMaps = new EObjectResolvingEList(UseCaseMap.class, this, CoremodelPackage.FAMILY__ARCHITECTURAL_USE_CASE_MAPS);
		}
		return architecturalUseCaseMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFunctionalUseCaseMaps() {
		if (functionalUseCaseMaps == null) {
			functionalUseCaseMaps = new EObjectResolvingEList(UseCaseMap.class, this, CoremodelPackage.FAMILY__FUNCTIONAL_USE_CASE_MAPS);
		}
		return functionalUseCaseMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getEvents() {
		if (events == null) {
			events = new EcoreEMap(CoremodelPackage.Literals.CONDITION_EVENT_TO_CONDITION_EVENT_MAP_ENTRY, ConditionEventToConditionEventMapEntryImpl.class, this, CoremodelPackage.FAMILY__EVENTS);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.FAMILY__FAMILY_ELEMENT:
				return ((InternalEList)getFamilyElement()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.FAMILY__EVENTS:
				return ((InternalEList)getEvents()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.FAMILY__FAMILY_ELEMENT:
				return getFamilyElement();
			case CoremodelPackage.FAMILY__ASSOCIATED_RESPONSIBILITIES:
				return getAssociatedResponsibilities();
			case CoremodelPackage.FAMILY__ARCHITECTURAL_USE_CASE_MAPS:
				return getArchitecturalUseCaseMaps();
			case CoremodelPackage.FAMILY__FUNCTIONAL_USE_CASE_MAPS:
				return getFunctionalUseCaseMaps();
			case CoremodelPackage.FAMILY__EVENTS:
				if (coreType) return getEvents();
				else return getEvents().map();
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
			case CoremodelPackage.FAMILY__FAMILY_ELEMENT:
				getFamilyElement().clear();
				getFamilyElement().addAll((Collection)newValue);
				return;
			case CoremodelPackage.FAMILY__ASSOCIATED_RESPONSIBILITIES:
				getAssociatedResponsibilities().clear();
				getAssociatedResponsibilities().addAll((Collection)newValue);
				return;
			case CoremodelPackage.FAMILY__ARCHITECTURAL_USE_CASE_MAPS:
				getArchitecturalUseCaseMaps().clear();
				getArchitecturalUseCaseMaps().addAll((Collection)newValue);
				return;
			case CoremodelPackage.FAMILY__FUNCTIONAL_USE_CASE_MAPS:
				getFunctionalUseCaseMaps().clear();
				getFunctionalUseCaseMaps().addAll((Collection)newValue);
				return;
			case CoremodelPackage.FAMILY__EVENTS:
				((EStructuralFeature.Setting)getEvents()).set(newValue);
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
			case CoremodelPackage.FAMILY__FAMILY_ELEMENT:
				getFamilyElement().clear();
				return;
			case CoremodelPackage.FAMILY__ASSOCIATED_RESPONSIBILITIES:
				getAssociatedResponsibilities().clear();
				return;
			case CoremodelPackage.FAMILY__ARCHITECTURAL_USE_CASE_MAPS:
				getArchitecturalUseCaseMaps().clear();
				return;
			case CoremodelPackage.FAMILY__FUNCTIONAL_USE_CASE_MAPS:
				getFunctionalUseCaseMaps().clear();
				return;
			case CoremodelPackage.FAMILY__EVENTS:
				getEvents().clear();
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
			case CoremodelPackage.FAMILY__FAMILY_ELEMENT:
				return familyElement != null && !familyElement.isEmpty();
			case CoremodelPackage.FAMILY__ASSOCIATED_RESPONSIBILITIES:
				return associatedResponsibilities != null && !associatedResponsibilities.isEmpty();
			case CoremodelPackage.FAMILY__ARCHITECTURAL_USE_CASE_MAPS:
				return architecturalUseCaseMaps != null && !architecturalUseCaseMaps.isEmpty();
			case CoremodelPackage.FAMILY__FUNCTIONAL_USE_CASE_MAPS:
				return functionalUseCaseMaps != null && !functionalUseCaseMaps.isEmpty();
			case CoremodelPackage.FAMILY__EVENTS:
				return events != null && !events.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FamilyImpl
