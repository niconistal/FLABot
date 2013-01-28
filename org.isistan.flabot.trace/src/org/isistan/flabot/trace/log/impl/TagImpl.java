/**
 * <copyright>
 * </copyright>
 *
 * $Id: TagImpl.java,v 1.2 2006/02/03 21:03:04 dacostae Exp $
 */
package org.isistan.flabot.trace.log.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.impl.EStringToStringMapEntryImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.trace.log.LogPackage;
import org.isistan.flabot.trace.log.Tag;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tag</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.trace.log.impl.TagImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.log.impl.TagImpl#getContainedTags <em>Contained Tags</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.log.impl.TagImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.isistan.flabot.trace.log.impl.TagImpl#getTags <em>Tags</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TagImpl extends EObjectImpl implements Tag {
	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected EMap properties = null;

	/**
	 * The cached value of the '{@link #getContainedTags() <em>Contained Tags</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContainedTags()
	 * @generated
	 * @ordered
	 */
	protected EList containedTags = null;

	/**
	 * The cached value of the '{@link #getTags() <em>Tags</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTags()
	 * @generated
	 * @ordered
	 */
	protected EMap tags = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TagImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return LogPackage.eINSTANCE.getTag();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getProperties() {
		if (properties == null) {
			properties = new EcoreEMap(EcorePackage.eINSTANCE.getEStringToStringMapEntry(), EStringToStringMapEntryImpl.class, this, LogPackage.TAG__PROPERTIES);
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getContainedTags() {
		if (containedTags == null) {
			containedTags = new EObjectContainmentWithInverseEList(Tag.class, this, LogPackage.TAG__CONTAINED_TAGS, LogPackage.TAG__PARENT);
		}
		return containedTags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag getParent() {
		if (eContainerFeatureID != LogPackage.TAG__PARENT) return null;
		return (Tag)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(Tag newParent) {
		if (newParent != eContainer || (eContainerFeatureID != LogPackage.TAG__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, LogPackage.TAG__CONTAINED_TAGS, Tag.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newParent, LogPackage.TAG__PARENT, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LogPackage.TAG__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap getTags() {
		if (tags == null) {
			tags = new EcoreEMap(LogPackage.eINSTANCE.getEStringToTagMapEntry(), EStringToTagMapEntryImpl.class, this, LogPackage.TAG__TAGS);
		}
		return tags;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case LogPackage.TAG__CONTAINED_TAGS:
					return ((InternalEList)getContainedTags()).basicAdd(otherEnd, msgs);
				case LogPackage.TAG__PARENT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, LogPackage.TAG__PARENT, msgs);
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case LogPackage.TAG__PROPERTIES:
					return ((InternalEList)getProperties()).basicRemove(otherEnd, msgs);
				case LogPackage.TAG__CONTAINED_TAGS:
					return ((InternalEList)getContainedTags()).basicRemove(otherEnd, msgs);
				case LogPackage.TAG__PARENT:
					return eBasicSetContainer(null, LogPackage.TAG__PARENT, msgs);
				case LogPackage.TAG__TAGS:
					return ((InternalEList)getTags()).basicRemove(otherEnd, msgs);
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
	@Override
	public NotificationChain eBasicRemoveFromContainer(NotificationChain msgs) {
		if (eContainerFeatureID >= 0) {
			switch (eContainerFeatureID) {
				case LogPackage.TAG__PARENT:
					return eContainer.eInverseRemove(this, LogPackage.TAG__CONTAINED_TAGS, Tag.class, msgs);
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
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case LogPackage.TAG__PROPERTIES:
				return getProperties();
			case LogPackage.TAG__CONTAINED_TAGS:
				return getContainedTags();
			case LogPackage.TAG__PARENT:
				return getParent();
			case LogPackage.TAG__TAGS:
				return getTags();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case LogPackage.TAG__PROPERTIES:
				getProperties().clear();
				getProperties().addAll((Collection)newValue);
				return;
			case LogPackage.TAG__CONTAINED_TAGS:
				getContainedTags().clear();
				getContainedTags().addAll((Collection)newValue);
				return;
			case LogPackage.TAG__PARENT:
				setParent((Tag)newValue);
				return;
			case LogPackage.TAG__TAGS:
				getTags().clear();
				getTags().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case LogPackage.TAG__PROPERTIES:
				getProperties().clear();
				return;
			case LogPackage.TAG__CONTAINED_TAGS:
				getContainedTags().clear();
				return;
			case LogPackage.TAG__PARENT:
				setParent((Tag)null);
				return;
			case LogPackage.TAG__TAGS:
				getTags().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case LogPackage.TAG__PROPERTIES:
				return properties != null && !properties.isEmpty();
			case LogPackage.TAG__CONTAINED_TAGS:
				return containedTags != null && !containedTags.isEmpty();
			case LogPackage.TAG__PARENT:
				return getParent() != null;
			case LogPackage.TAG__TAGS:
				return tags != null && !tags.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * finds the property with the given name and returns its value. if
	 * no property with the given name is found, returns null
	 */
	public String getProperty(String propertyName) {
		return (String) getProperties().get(propertyName);
	}
	
	/**
	 * set the value for the property with the given name
	 * if the property doesn't exist, a new one is created
	 */
	public String setProperty(String propertyName, String newValue) {
		return (String) getProperties().put(propertyName, newValue);
	}

	public void setParent(String key, Tag value) {
		setParent(value);
		value.getTags().put(key, this);
	}

	
	private Map runtimeObjects=new HashMap();
	public Object getRuntimeObject(Object key) {
		return runtimeObjects.get(key);
	}

	public void setRuntimeObject(Object key, Object value) {
		runtimeObjects.put(key, value);
	}
} //TagImpl
