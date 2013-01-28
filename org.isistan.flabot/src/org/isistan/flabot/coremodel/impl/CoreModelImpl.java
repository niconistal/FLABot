/**
 * <copyright>
 * </copyright>
 *
 * $Id: CoreModelImpl.java,v 1.17 2006/03/09 21:17:23 dacostae Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.ConditionedStub;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelFactory;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.DynamicStubNode;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.InterfaceLink;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.TimerNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Core Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getResponsibilities <em>Responsibilities</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getUseCaseMaps <em>Use Case Maps</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getInterfaceLinks <em>Interface Links</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getRelationships <em>Relationships</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getStereotypes <em>Stereotypes</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getFile <em>File</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getFamilies <em>Families</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getArchitecturalUseCaseMaps <em>Architectural Use Case Maps</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getFunctionalUseCaseMaps <em>Functional Use Case Maps</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getEvents <em>Events</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getStubs <em>Stubs</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getDynamicStubs <em>Dynamic Stubs</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.CoreModelImpl#getConditionedStubs <em>Conditioned Stubs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CoreModelImpl extends EObjectImpl implements CoreModel {
	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList components;

	/**
	 * The cached value of the '{@link #getResponsibilities() <em>Responsibilities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResponsibilities()
	 * @generated
	 * @ordered
	 */
	protected EList responsibilities;

	/**
	 * The cached value of the '{@link #getUseCaseMaps() <em>Use Case Maps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUseCaseMaps()
	 * @generated
	 * @ordered
	 */
	protected EList useCaseMaps;

	/**
	 * The cached value of the '{@link #getInterfaceLinks() <em>Interface Links</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInterfaceLinks()
	 * @generated
	 * @ordered
	 */
	protected EList interfaceLinks;

	/**
	 * The cached value of the '{@link #getRelationships() <em>Relationships</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationships()
	 * @generated
	 * @ordered
	 */
	protected EList relationships;

	/**
	 * The cached value of the '{@link #getStereotypes() <em>Stereotypes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotypes()
	 * @generated
	 * @ordered
	 */
	protected EList stereotypes;

	/**
	 * The cached value of the '{@link #getFamilies() <em>Families</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFamilies()
	 * @generated
	 * @ordered
	 */
	protected EList families;

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
	 * The cached value of the '{@link #getEvents() <em>Events</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEvents()
	 * @generated
	 * @ordered
	 */
	protected EList events;

	/**
	 * The cached value of the '{@link #getStubs() <em>Stubs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStubs()
	 * @generated
	 * @ordered
	 */
	protected EList stubs;
	
	/**
	 * The cached value of the '{@link #getDynamicStubs() <em>Dynamic Stubs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDynamicStubs()
	 * @generated
	 * @ordered
	 */
	protected EList dynamicStubs;

	/**
	 * The cached value of the '{@link #getConditionedStubs() <em>Conditioned Stubs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConditionedStubs()
	 * @generated
	 * @ordered
	 */
	protected EList conditionedStubs;

	/**
	 * The cached value of the '{@link #getTimers() <em>Timers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimers()
	 */
	protected EList timers = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CoreModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.CORE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getComponents() {
		if (components == null) {
			components = new EObjectContainmentWithInverseEList(ComponentModel.class, this, CoremodelPackage.CORE_MODEL__COMPONENTS, CoremodelPackage.COMPONENT_MODEL__CORE_MODEL);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResponsibilities() {
		if (responsibilities == null) {
			responsibilities = new EObjectContainmentWithInverseEList(Responsibility.class, this, CoremodelPackage.CORE_MODEL__RESPONSIBILITIES, CoremodelPackage.RESPONSIBILITY__CORE_MODEL);
		}
		return responsibilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUseCaseMaps() {
		if (useCaseMaps == null) {
			useCaseMaps = new EObjectContainmentWithInverseEList(UseCaseMap.class, this, CoremodelPackage.CORE_MODEL__USE_CASE_MAPS, CoremodelPackage.USE_CASE_MAP__CORE_MODEL);
		}
		return useCaseMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getInterfaceLinks() {
		if (interfaceLinks == null) {
			interfaceLinks = new EObjectContainmentEList(InterfaceLink.class, this, CoremodelPackage.CORE_MODEL__INTERFACE_LINKS);
		}
		return interfaceLinks;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getRelationships() {
		if (relationships == null) {
			relationships = new EObjectContainmentEList(Relationship.class, this, CoremodelPackage.CORE_MODEL__RELATIONSHIPS);
		}
		return relationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getStereotypes() {
		if (stereotypes == null) {
			stereotypes = new EObjectContainmentEList(Stereotype.class, this, CoremodelPackage.CORE_MODEL__STEREOTYPES);
		}
		return stereotypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FlabotFileModel getFile() {
		if (eContainerFeatureID() != CoremodelPackage.CORE_MODEL__FILE) return null;
		return (FlabotFileModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFile(FlabotFileModel newFile, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFile, CoremodelPackage.CORE_MODEL__FILE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFile(FlabotFileModel newFile) {
		if (newFile != eInternalContainer() || (eContainerFeatureID() != CoremodelPackage.CORE_MODEL__FILE && newFile != null)) {
			if (EcoreUtil.isAncestor(this, newFile))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFile != null)
				msgs = ((InternalEObject)newFile).eInverseAdd(this, EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL, FlabotFileModel.class, msgs);
			msgs = basicSetFile(newFile, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.CORE_MODEL__FILE, newFile, newFile));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFamilies() {
		if (families == null) {
			families = new EObjectContainmentEList(Family.class, this, CoremodelPackage.CORE_MODEL__FAMILIES);
		}
		return families;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getArchitecturalUseCaseMaps() {
		if (architecturalUseCaseMaps == null) {
			architecturalUseCaseMaps = new EObjectResolvingEList(UseCaseMap.class, this, CoremodelPackage.CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS);
		}
		else architecturalUseCaseMaps.clear();
		for (int i=0; i< useCaseMaps.size(); i++){
			if (((UseCaseMap)useCaseMaps.get(i)).getLevelInfo().equals(UseCaseMap.architecturalLevel)){
				architecturalUseCaseMaps.add(useCaseMaps.get(i));
			}
		}
		return architecturalUseCaseMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public EList getFunctionalUseCaseMaps() {
		if (functionalUseCaseMaps == null) {
			functionalUseCaseMaps = new EObjectResolvingEList(UseCaseMap.class, this, CoremodelPackage.CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS);
		}
		else functionalUseCaseMaps.clear();
		for (int i=0; i< useCaseMaps.size(); i++){
			if (((UseCaseMap)useCaseMaps.get(i)).getLevelInfo().equals(UseCaseMap.functionalLevel)){
				functionalUseCaseMaps.add(useCaseMaps.get(i));
			}
		}
		return functionalUseCaseMaps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * @deprecated
	 */
	public EList getEvents() {
		if (events == null) {
			events = new EObjectContainmentEList(ConditionEvent.class, this, CoremodelPackage.CORE_MODEL__EVENTS);
		}
		return events;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 * 
	 */
	
	public EList getConditionEvents(){
		if (events == null) {
			events = new EObjectContainmentEList(ConditionEvent.class, this, CoremodelPackage.CORE_MODEL__EVENTS);
		}
		int i=0;
		for (i=0; i < events.size(); i++){
			if (((ConditionEvent)events.get(i)).getName().equals("none"))
				break;
		}
		if (i==events.size()){
			ConditionEvent event = CoremodelFactory.eINSTANCE.createConditionEvent();
			event.setName("none");
			events.add(event);
		}
		return events;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getStubs() {
		if (stubs == null) {
			stubs = new EObjectResolvingEList(StubNode.class, this, CoremodelPackage.CORE_MODEL__STUBS);
		}
		return stubs;
	}
	
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDynamicStubs() {
		if (dynamicStubs == null) {
			dynamicStubs = new EObjectResolvingEList(DynamicStubNode.class, this, CoremodelPackage.CORE_MODEL__DYNAMIC_STUBS);
		}
		return dynamicStubs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getConditionedStubs() {
		if (conditionedStubs == null) {
			conditionedStubs = new EObjectContainmentEList(ConditionedStub.class, this, CoremodelPackage.CORE_MODEL__CONDITIONED_STUBS);
		}
		return conditionedStubs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.CORE_MODEL__COMPONENTS:
				return ((InternalEList)getComponents()).basicAdd(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__RESPONSIBILITIES:
				return ((InternalEList)getResponsibilities()).basicAdd(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__USE_CASE_MAPS:
				return ((InternalEList)getUseCaseMaps()).basicAdd(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__FILE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFile((FlabotFileModel)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.CORE_MODEL__COMPONENTS:
				return ((InternalEList)getComponents()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__RESPONSIBILITIES:
				return ((InternalEList)getResponsibilities()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__USE_CASE_MAPS:
				return ((InternalEList)getUseCaseMaps()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__INTERFACE_LINKS:
				return ((InternalEList)getInterfaceLinks()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__RELATIONSHIPS:
				return ((InternalEList)getRelationships()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__STEREOTYPES:
				return ((InternalEList)getStereotypes()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__FILE:
				return basicSetFile(null, msgs);
			case CoremodelPackage.CORE_MODEL__FAMILIES:
				return ((InternalEList)getFamilies()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__EVENTS:
				return ((InternalEList)getEvents()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.CORE_MODEL__CONDITIONED_STUBS:
				return ((InternalEList)getConditionedStubs()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CoremodelPackage.CORE_MODEL__FILE:
				return eInternalContainer().eInverseRemove(this, EditormodelPackage.FLABOT_FILE_MODEL__CORE_MODEL, FlabotFileModel.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CoremodelPackage.CORE_MODEL__COMPONENTS:
				return getComponents();
			case CoremodelPackage.CORE_MODEL__RESPONSIBILITIES:
				return getResponsibilities();
			case CoremodelPackage.CORE_MODEL__USE_CASE_MAPS:
				return getUseCaseMaps();
			case CoremodelPackage.CORE_MODEL__INTERFACE_LINKS:
				return getInterfaceLinks();
			case CoremodelPackage.CORE_MODEL__RELATIONSHIPS:
				return getRelationships();
			case CoremodelPackage.CORE_MODEL__STEREOTYPES:
				return getStereotypes();
			case CoremodelPackage.CORE_MODEL__FILE:
				return getFile();
			case CoremodelPackage.CORE_MODEL__FAMILIES:
				return getFamilies();
			case CoremodelPackage.CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS:
				return getArchitecturalUseCaseMaps();
			case CoremodelPackage.CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS:
				return getFunctionalUseCaseMaps();
			case CoremodelPackage.CORE_MODEL__EVENTS:
				return getEvents();
			case CoremodelPackage.CORE_MODEL__STUBS:
				return getStubs();
			case CoremodelPackage.CORE_MODEL__DYNAMIC_STUBS:
				return getDynamicStubs();
			case CoremodelPackage.CORE_MODEL__CONDITIONED_STUBS:
				return getConditionedStubs();
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
			case CoremodelPackage.CORE_MODEL__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__RESPONSIBILITIES:
				getResponsibilities().clear();
				getResponsibilities().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__USE_CASE_MAPS:
				getUseCaseMaps().clear();
				getUseCaseMaps().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__INTERFACE_LINKS:
				getInterfaceLinks().clear();
				getInterfaceLinks().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__RELATIONSHIPS:
				getRelationships().clear();
				getRelationships().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__STEREOTYPES:
				getStereotypes().clear();
				getStereotypes().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__FILE:
				setFile((FlabotFileModel)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__FAMILIES:
				getFamilies().clear();
				getFamilies().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS:
				getArchitecturalUseCaseMaps().clear();
				getArchitecturalUseCaseMaps().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS:
				getFunctionalUseCaseMaps().clear();
				getFunctionalUseCaseMaps().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__EVENTS:
				getEvents().clear();
				getEvents().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__STUBS:
				getStubs().clear();
				getStubs().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__DYNAMIC_STUBS:
				getDynamicStubs().clear();
				getDynamicStubs().addAll((Collection)newValue);
				return;
			case CoremodelPackage.CORE_MODEL__CONDITIONED_STUBS:
				getConditionedStubs().clear();
				getConditionedStubs().addAll((Collection)newValue);
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
			case CoremodelPackage.CORE_MODEL__COMPONENTS:
				getComponents().clear();
				return;
			case CoremodelPackage.CORE_MODEL__RESPONSIBILITIES:
				getResponsibilities().clear();
				return;
			case CoremodelPackage.CORE_MODEL__USE_CASE_MAPS:
				getUseCaseMaps().clear();
				return;
			case CoremodelPackage.CORE_MODEL__INTERFACE_LINKS:
				getInterfaceLinks().clear();
				return;
			case CoremodelPackage.CORE_MODEL__RELATIONSHIPS:
				getRelationships().clear();
				return;
			case CoremodelPackage.CORE_MODEL__STEREOTYPES:
				getStereotypes().clear();
				return;
			case CoremodelPackage.CORE_MODEL__FILE:
				setFile((FlabotFileModel)null);
				return;
			case CoremodelPackage.CORE_MODEL__FAMILIES:
				getFamilies().clear();
				return;
			case CoremodelPackage.CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS:
				getArchitecturalUseCaseMaps().clear();
				return;
			case CoremodelPackage.CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS:
				getFunctionalUseCaseMaps().clear();
				return;
			case CoremodelPackage.CORE_MODEL__EVENTS:
				getEvents().clear();
				return;
			case CoremodelPackage.CORE_MODEL__STUBS:
				getStubs().clear();
				return;
			case CoremodelPackage.CORE_MODEL__DYNAMIC_STUBS:
				getDynamicStubs().clear();
				return;
			case CoremodelPackage.CORE_MODEL__CONDITIONED_STUBS:
				getConditionedStubs().clear();
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
			case CoremodelPackage.CORE_MODEL__COMPONENTS:
				return components != null && !components.isEmpty();
			case CoremodelPackage.CORE_MODEL__RESPONSIBILITIES:
				return responsibilities != null && !responsibilities.isEmpty();
			case CoremodelPackage.CORE_MODEL__USE_CASE_MAPS:
				return useCaseMaps != null && !useCaseMaps.isEmpty();
			case CoremodelPackage.CORE_MODEL__INTERFACE_LINKS:
				return interfaceLinks != null && !interfaceLinks.isEmpty();
			case CoremodelPackage.CORE_MODEL__RELATIONSHIPS:
				return relationships != null && !relationships.isEmpty();
			case CoremodelPackage.CORE_MODEL__STEREOTYPES:
				return stereotypes != null && !stereotypes.isEmpty();
			case CoremodelPackage.CORE_MODEL__FILE:
				return getFile() != null;
			case CoremodelPackage.CORE_MODEL__FAMILIES:
				return families != null && !families.isEmpty();
			case CoremodelPackage.CORE_MODEL__ARCHITECTURAL_USE_CASE_MAPS:
				return architecturalUseCaseMaps != null && !architecturalUseCaseMaps.isEmpty();
			case CoremodelPackage.CORE_MODEL__FUNCTIONAL_USE_CASE_MAPS:
				return functionalUseCaseMaps != null && !functionalUseCaseMaps.isEmpty();
			case CoremodelPackage.CORE_MODEL__EVENTS:
				return events != null && !events.isEmpty();
			case CoremodelPackage.CORE_MODEL__STUBS:
				return stubs != null && !stubs.isEmpty();
			case CoremodelPackage.CORE_MODEL__DYNAMIC_STUBS:
				return dynamicStubs != null && !dynamicStubs.isEmpty();
			case CoremodelPackage.CORE_MODEL__CONDITIONED_STUBS:
				return conditionedStubs != null && !conditionedStubs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	public EList getTimers() {
		if (timers == null) {
			timers = new EObjectResolvingEList(TimerNode.class, this, CoremodelPackage.CORE_MODEL__TIMERS);
		}
		return timers;
	}

} //CoreModelImpl
