/**
 * <copyright>
 * </copyright>
 *
 * $Id: RelationshipImpl.java,v 1.6 2005/12/16 04:03:28 dacostae Exp $
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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoremodelPackage;
import org.isistan.flabot.coremodel.Note;
import org.isistan.flabot.coremodel.NoteElementModel;
import org.isistan.flabot.coremodel.Property;
import org.isistan.flabot.coremodel.PropertyElementModel;
import org.isistan.flabot.coremodel.Relationship;
import org.isistan.flabot.coremodel.RelationshipDirection;
import org.isistan.flabot.coremodel.Stereotype;
import org.isistan.flabot.coremodel.StereotypedElementModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relationship</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.impl.RelationshipImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.RelationshipImpl#getStereotype <em>Stereotype</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.RelationshipImpl#getNotes <em>Notes</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.RelationshipImpl#getSource <em>Source</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.RelationshipImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.impl.RelationshipImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RelationshipImpl extends NamedElementModelImpl implements Relationship {
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
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected ComponentModel source;

	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected ComponentModel target;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final RelationshipDirection DIRECTION_EDEFAULT = RelationshipDirection.UNSPECIFIED_LITERAL;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected RelationshipDirection direction = DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationshipImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return CoremodelPackage.Literals.RELATIONSHIP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getProperties() {
		if (properties == null) {
			properties = new EObjectContainmentEList(Property.class, this, CoremodelPackage.RELATIONSHIP__PROPERTIES);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.RELATIONSHIP__STEREOTYPE, oldStereotype, stereotype));
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
	public void setStereotype(Stereotype newStereotype) {
		Stereotype oldStereotype = stereotype;
		stereotype = newStereotype;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RELATIONSHIP__STEREOTYPE, oldStereotype, stereotype));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getNotes() {
		if (notes == null) {
			notes = new EObjectResolvingEList(Note.class, this, CoremodelPackage.RELATIONSHIP__NOTES);
		}
		return notes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (ComponentModel)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.RELATIONSHIP__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(ComponentModel newSource) {
		ComponentModel oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RELATIONSHIP__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel getTarget() {
		if (target != null && target.eIsProxy()) {
			InternalEObject oldTarget = (InternalEObject)target;
			target = (ComponentModel)eResolveProxy(oldTarget);
			if (target != oldTarget) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CoremodelPackage.RELATIONSHIP__TARGET, oldTarget, target));
			}
		}
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentModel basicGetTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(ComponentModel newTarget) {
		ComponentModel oldTarget = target;
		target = newTarget;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RELATIONSHIP__TARGET, oldTarget, target));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationshipDirection getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(RelationshipDirection newDirection) {
		RelationshipDirection oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CoremodelPackage.RELATIONSHIP__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CoremodelPackage.RELATIONSHIP__PROPERTIES:
				return ((InternalEList)getProperties()).basicRemove(otherEnd, msgs);
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
			case CoremodelPackage.RELATIONSHIP__PROPERTIES:
				return getProperties();
			case CoremodelPackage.RELATIONSHIP__STEREOTYPE:
				if (resolve) return getStereotype();
				return basicGetStereotype();
			case CoremodelPackage.RELATIONSHIP__NOTES:
				return getNotes();
			case CoremodelPackage.RELATIONSHIP__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
			case CoremodelPackage.RELATIONSHIP__TARGET:
				if (resolve) return getTarget();
				return basicGetTarget();
			case CoremodelPackage.RELATIONSHIP__DIRECTION:
				return getDirection();
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
			case CoremodelPackage.RELATIONSHIP__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case CoremodelPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype((Stereotype)newValue);
				return;
			case CoremodelPackage.RELATIONSHIP__NOTES:
				getNotes().clear();
				getNotes().addAll((Collection)newValue);
				return;
			case CoremodelPackage.RELATIONSHIP__SOURCE:
				setSource((ComponentModel)newValue);
				return;
			case CoremodelPackage.RELATIONSHIP__TARGET:
				setTarget((ComponentModel)newValue);
				return;
			case CoremodelPackage.RELATIONSHIP__DIRECTION:
				setDirection((RelationshipDirection)newValue);
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
			case CoremodelPackage.RELATIONSHIP__PROPERTIES:
				getProperties().clear();
				return;
			case CoremodelPackage.RELATIONSHIP__STEREOTYPE:
				setStereotype((Stereotype)null);
				return;
			case CoremodelPackage.RELATIONSHIP__NOTES:
				getNotes().clear();
				return;
			case CoremodelPackage.RELATIONSHIP__SOURCE:
				setSource((ComponentModel)null);
				return;
			case CoremodelPackage.RELATIONSHIP__TARGET:
				setTarget((ComponentModel)null);
				return;
			case CoremodelPackage.RELATIONSHIP__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
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
			case CoremodelPackage.RELATIONSHIP__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case CoremodelPackage.RELATIONSHIP__STEREOTYPE:
				return stereotype != null;
			case CoremodelPackage.RELATIONSHIP__NOTES:
				return notes != null && !notes.isEmpty();
			case CoremodelPackage.RELATIONSHIP__SOURCE:
				return source != null;
			case CoremodelPackage.RELATIONSHIP__TARGET:
				return target != null;
			case CoremodelPackage.RELATIONSHIP__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class baseClass) {
		if (baseClass == PropertyElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.RELATIONSHIP__PROPERTIES: return CoremodelPackage.PROPERTY_ELEMENT_MODEL__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == StereotypedElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.RELATIONSHIP__STEREOTYPE: return CoremodelPackage.STEREOTYPED_ELEMENT_MODEL__STEREOTYPE;
				default: return -1;
			}
		}
		if (baseClass == NoteElementModel.class) {
			switch (derivedFeatureID) {
				case CoremodelPackage.RELATIONSHIP__NOTES: return CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES;
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
		if (baseClass == PropertyElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.PROPERTY_ELEMENT_MODEL__PROPERTIES: return CoremodelPackage.RELATIONSHIP__PROPERTIES;
				default: return -1;
			}
		}
		if (baseClass == StereotypedElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.STEREOTYPED_ELEMENT_MODEL__STEREOTYPE: return CoremodelPackage.RELATIONSHIP__STEREOTYPE;
				default: return -1;
			}
		}
		if (baseClass == NoteElementModel.class) {
			switch (baseFeatureID) {
				case CoremodelPackage.NOTE_ELEMENT_MODEL__NOTES: return CoremodelPackage.RELATIONSHIP__NOTES;
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
		result.append(" (direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //RelationshipImpl
