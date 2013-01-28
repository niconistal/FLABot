/**
 * <copyright>
 * </copyright>
 *
 * $Id: ComponentModelImpl.java,v 1.19 2006/03/28 03:15:43 dacostae Exp $
 */
package org.isistan.flabot.coremodel.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.FeatureModel;
import org.isistan.flabot.coremodel.NamedElementModel;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.NoteElementModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StereotypedElementModel;
import org.isistan.flabot.util.EObjectIdGenerator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl#getOwnedPorts <em>Owned Ports</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.ComponentModelImpl#getCoreModel <em>Core Model</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComponentModelImpl extends ExtensibleElementImpl implements ComponentModel {
	
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
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EList properties;

	/**
	 * The cached value of the '{@link #getStereotype() <em>Stereotype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStereotype()
	 * @generated
	 * @ordered
	 */
	protected Stereotype stereotype;

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
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList features;

	/**
	 * The cached value of the '{@link #getOwnedPorts() <em>Owned Ports</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedPorts()
	 * @generated
	 * @ordered
	 */
	protected EList ownedPorts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.COMPONENT_MODEL;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_MODEL__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getFeatures() {
		if (features == null) {
			features = new EObjectWithInverseResolvingEList.ManyInverse(FeatureModel.class, this, CoremodelPackage.COMPONENT_MODEL__FEATURES, CoremodelPackage.FEATURE_MODEL__COMPONENTS);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getOwnedPorts() {
		if (ownedPorts == null) {
			ownedPorts = new EObjectContainmentWithInverseEList(PortModel.class, this, CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS, CoremodelPackage.PORT_MODEL__COMPONENT);
		}
		return ownedPorts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreModel getCoreModel() {
		if (eContainerFeatureID() != CoremodelPackage.COMPONENT_MODEL__CORE_MODEL) return null;
		return (CoreModel)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCoreModel(CoreModel newCoreModel, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCoreModel, CoremodelPackage.COMPONENT_MODEL__CORE_MODEL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCoreModel(CoreModel newCoreModel) {
		if (newCoreModel != eInternalContainer() || (eContainerFeatureID() != CoremodelPackage.COMPONENT_MODEL__CORE_MODEL && newCoreModel != null)) {
			if (EcoreUtil.isAncestor(this, newCoreModel))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCoreModel != null)
				msgs = ((InternalEObject)newCoreModel).eInverseAdd(this, CoremodelPackage.CORE_MODEL__COMPONENTS, CoreModel.class, msgs);
			msgs = basicSetCoreModel(newCoreModel, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_MODEL__CORE_MODEL, newCoreModel, newCoreModel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.COMPONENT_MODEL__FEATURES:
				return ((InternalEList)getFeatures()).basicAdd(otherEnd, msgs);
			case CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS:
				return ((InternalEList)getOwnedPorts()).basicAdd(otherEnd, msgs);
			case CoremodelPackage.COMPONENT_MODEL__CORE_MODEL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCoreModel((CoreModel)otherEnd, msgs);
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
			case CoremodelPackage.COMPONENT_MODEL__PROPERTIES:
				return ((InternalEList)getProperties()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.COMPONENT_MODEL__FEATURES:
				return ((InternalEList)getFeatures()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS:
				return ((InternalEList)getOwnedPorts()).basicRemove(otherEnd, msgs);
			case CoremodelPackage.COMPONENT_MODEL__CORE_MODEL:
				return basicSetCoreModel(null, msgs);
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
			case CoremodelPackage.COMPONENT_MODEL__CORE_MODEL:
				return eInternalContainer().eInverseRemove(this, CoremodelPackage.CORE_MODEL__COMPONENTS, CoreModel.class, msgs);
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
			case CoremodelPackage.COMPONENT_MODEL__NAME:
				return getName();
			case CoremodelPackage.COMPONENT_MODEL__PROPERTIES:
				return getProperties();
			case CoremodelPackage.COMPONENT_MODEL__STEREOTYPE:
				if (resolve) return getStereotype();
				return basicGetStereotype();
			case CoremodelPackage.COMPONENT_MODEL__NOTES:
				return getNotes();
			case CoremodelPackage.COMPONENT_MODEL__FEATURES:
				return getFeatures();
			case CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS:
				return getOwnedPorts();
			case CoremodelPackage.COMPONENT_MODEL__CORE_MODEL:
				return getCoreModel();
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
			case CoremodelPackage.COMPONENT_MODEL__NAME:
				setName((String)newValue);
				return;
			case CoremodelPackage.COMPONENT_MODEL__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case CoremodelPackage.COMPONENT_MODEL__STEREOTYPE:
				setStereotype((Stereotype)newValue);
				return;
			case CoremodelPackage.COMPONENT_MODEL__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection)newValue);
				return;
			case CoremodelPackage.COMPONENT_MODEL__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection)newValue);
				return;
			case CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS:
				getOwnedPorts().clear();
				getOwnedPorts().addAll((Collection)newValue);
				return;
			case CoremodelPackage.COMPONENT_MODEL__CORE_MODEL:
				setCoreModel((CoreModel)newValue);
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
			case CoremodelPackage.COMPONENT_MODEL__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CoremodelPackage.COMPONENT_MODEL__PROPERTIES:
				getProperties().clear();
				return;
			case CoremodelPackage.COMPONENT_MODEL__STEREOTYPE:
				setStereotype((Stereotype)null);
				return;
			case CoremodelPackage.COMPONENT_MODEL__NOTES:
				getNotes().clear();
				return;
			case CoremodelPackage.COMPONENT_MODEL__FEATURES:
				getFeatures().clear();
				return;
			case CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS:
				getOwnedPorts().clear();
				return;
			case CoremodelPackage.COMPONENT_MODEL__CORE_MODEL:
				setCoreModel((CoreModel)null);
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
			case CoremodelPackage.COMPONENT_MODEL__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CoremodelPackage.COMPONENT_MODEL__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case CoremodelPackage.COMPONENT_MODEL__STEREOTYPE:
				return stereotype != null;
			case CoremodelPackage.COMPONENT_MODEL__NOTES:
				return notes != null && !notes.isEmpty();
			case CoremodelPackage.COMPONENT_MODEL__FEATURES:
				return features != null && !features.isEmpty();
			case CoremodelPackage.COMPONENT_MODEL__OWNED_PORTS:
				return ownedPorts != null && !ownedPorts.isEmpty();
			case CoremodelPackage.COMPONENT_MODEL__CORE_MODEL:
				return getCoreModel() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList(Property.class, this, CoremodelPackage.COMPONENT_MODEL__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype getStereotype() {
		if (stereotype != null && stereotype.eIsProxy()) {
			InternalEObject oldStereotype = (InternalEObject)stereotype;
			stereotype = (Stereotype)eResolveProxy(oldStereotype);
			if (stereotype != oldStereotype) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.COMPONENT_MODEL__STEREOTYPE, oldStereotype, stereotype));
			}
		}
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Stereotype basicGetStereotype() {
		return stereotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStereotypeGen(Stereotype newStereotype) {
		Stereotype oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.COMPONENT_MODEL__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setStereotype(Stereotype newStereotype) {		
		EObject oldStereotype = stereotype;
		setStereotypeGen(newStereotype);
		if (oldStereotype != null)
			oldStereotype.eAdapters().remove(this);
		if (newStereotype != null)
			newStereotype.eAdapters().add(this);			
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNotes() {
		if (notes == null) {
			notes = new EObjectResolvingEList(Note.class, this, CoremodelPackage.COMPONENT_MODEL__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == NamedElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.COMPONENT_MODEL__NAME: return CoremodelPackage.NAMED_ELEMENT_MODEL__NAME;
				default: return -1;
			}
		}
		if (baseClass == PropertyElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.COMPONENT_MODEL__PROPERTIES: return CoremodelPackage.PROPERTY_ELEMENT_MODEL__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == StereotypedElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.COMPONENT_MODEL__STEREOTYPE: return CoremodelPackage.STEREOTYPED_ELEMENT_MODEL__STEREOTYPE;
				default: return -1;
			}
		}
		if (baseClass == NoteElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.COMPONENT_MODEL__NOTES: return CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES;
				default: return -1;
			}
		}
		if (baseClass == Adapter.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class baseClass) {
		if (baseClass == NamedElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.NAMED_ELEMENT_MODEL__NAME: return CoremodelPackage.COMPONENT_MODEL__NAME;
				default: return -1;
			}
		}
		if (baseClass == PropertyElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.PROPERTY_ELEMENT_MODEL__PROPERTIES: return CoremodelPackage.COMPONENT_MODEL__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == StereotypedElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.STEREOTYPED_ELEMENT_MODEL__STEREOTYPE: return CoremodelPackage.COMPONENT_MODEL__STEREOTYPE;
				default: return -1;
			}
		}
		if (baseClass == NoteElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES: return CoremodelPackage.COMPONENT_MODEL__NOTES;
				default: return -1;
			}
		}
		if (baseClass == Adapter.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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

	/**
	 * Adapter implementation
	 */

	public void notifyChanged(Notification notification) {
		if (eNotificationRequired())
			eNotify(notification);
	}

	public Notifier getTarget() {
		return this;
	}

	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	public boolean isAdapterForType(Object type) {
		return Notifier.class.isAssignableFrom((Class)type);
	}
	
	public String getID() {
		return EObjectIdGenerator.getGeneratedEMFID(this);
	}

	public ComponentModel[] getSuperComponents() {
		return getRelatedComponents(this, false, false);
	}
	
	public ComponentModel[] getSubComponents() {
		return getRelatedComponents(this, true, false);
	}
	
	public ComponentModel[] getAllSuperComponents() {
		return getRelatedComponents(this, false, true);
	}
	
	public ComponentModel[] getAllSubComponents() {
		return getRelatedComponents(this, true, true);
	}
	
	private static ComponentModel[] getRelatedComponents(ComponentModel component, boolean findSubcomponents, boolean recursive) {
		Set<ComponentModel> components=new HashSet<ComponentModel>();
		getRelatedComponents(component, components, findSubcomponents, recursive);
		return components.toArray(new ComponentModel[components.size()]);
	}

	private static void getRelatedComponents(ComponentModel component, Set<ComponentModel> components, boolean findSubcomponents, boolean recursive) {
		for (Object familyObject : component.getCoreModel().getFamilies()) {
			Family family=(Family) familyObject;
			for (Object familyElementObject: family.getFamilyElement()) {
				FamilyElement familyElement=(FamilyElement) familyElementObject;
				ComponentModel subComponent=familyElement.getFunctionalComponent().getComponent();
				ComponentModel superComponent=familyElement.getArchitecturalComponent().getComponent();
				if(findSubcomponents) {
					if(superComponent==component) {
						if(components.add(subComponent)) {
							if(recursive) {
								getRelatedComponents(subComponent, components, true, true);
							}
						}
					}
				} else {
					if(subComponent==component) {
						if(components.add(superComponent)) {
							if(recursive) {
								getRelatedComponents(superComponent, components, false, true);
							}
						}
					}
				}
			}
		}
	}
} //ComponentModelImpl
