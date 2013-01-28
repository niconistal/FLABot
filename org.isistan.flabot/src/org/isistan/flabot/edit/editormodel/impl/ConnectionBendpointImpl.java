/**
 * <copyright>
 * </copyright>
 *
 * $Id: ConnectionBendpointImpl.java,v 1.8 2005/12/16 04:03:29 dacostae Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.edit.editormodel.ConnectionBendpoint;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Connection Bendpoint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionBendpointImpl#getFirstRelativeDimension <em>First Relative Dimension</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionBendpointImpl#getSecondRelativeDimension <em>Second Relative Dimension</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ConnectionBendpointImpl#getWeight <em>Weight</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConnectionBendpointImpl extends EObjectImpl implements ConnectionBendpoint {
	/**
	 * The cached value of the '{@link #getFirstRelativeDimension() <em>First Relative Dimension</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFirstRelativeDimension()
	 * @generated NOT
	 * @ordered
	 */
	protected Dimension firstRelativeDimension = EditormodelFactory.eINSTANCE.createDimension();
	{
		firstRelativeDimension.setWidth(0);
		firstRelativeDimension.setHeight(0);
	}

	/**
	 * The cached value of the '{@link #getSecondRelativeDimension() <em>Second Relative Dimension</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSecondRelativeDimension()
	 * @generated NOT
	 * @ordered
	 */
	protected Dimension secondRelativeDimension = EditormodelFactory.eINSTANCE.createDimension();
	{
		secondRelativeDimension.setWidth(0);
		secondRelativeDimension.setHeight(0);
	}
	
	/**
	 * The default value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected static final float WEIGHT_EDEFAULT = 0.5F;

	/**
	 * The cached value of the '{@link #getWeight() <em>Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWeight()
	 * @generated
	 * @ordered
	 */
	protected float weight = WEIGHT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConnectionBendpointImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getConnectionBendpoint();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getFirstRelativeDimension() {
		return firstRelativeDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFirstRelativeDimension(Dimension newFirstRelativeDimension, NotificationChain msgs) {
		Dimension oldFirstRelativeDimension = firstRelativeDimension;
		firstRelativeDimension = newFirstRelativeDimension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION, oldFirstRelativeDimension, newFirstRelativeDimension);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFirstRelativeDimension(Dimension newFirstRelativeDimension) {
		if (newFirstRelativeDimension != firstRelativeDimension) {
			NotificationChain msgs = null;
			if (firstRelativeDimension != null)
				msgs = ((InternalEObject)firstRelativeDimension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION, null, msgs);
			if (newFirstRelativeDimension != null)
				msgs = ((InternalEObject)newFirstRelativeDimension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION, null, msgs);
			msgs = basicSetFirstRelativeDimension(newFirstRelativeDimension, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION, newFirstRelativeDimension, newFirstRelativeDimension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getSecondRelativeDimension() {
		return secondRelativeDimension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSecondRelativeDimension(Dimension newSecondRelativeDimension, NotificationChain msgs) {
		Dimension oldSecondRelativeDimension = secondRelativeDimension;
		secondRelativeDimension = newSecondRelativeDimension;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION, oldSecondRelativeDimension, newSecondRelativeDimension);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSecondRelativeDimension(Dimension newSecondRelativeDimension) {
		if (newSecondRelativeDimension != secondRelativeDimension) {
			NotificationChain msgs = null;
			if (secondRelativeDimension != null)
				msgs = ((InternalEObject)secondRelativeDimension).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION, null, msgs);
			if (newSecondRelativeDimension != null)
				msgs = ((InternalEObject)newSecondRelativeDimension).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION, null, msgs);
			msgs = basicSetSecondRelativeDimension(newSecondRelativeDimension, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION, newSecondRelativeDimension, newSecondRelativeDimension));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setWeight(float newWeight) {
		float oldWeight = weight;
		weight = newWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.CONNECTION_BENDPOINT__WEIGHT, oldWeight, weight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION:
					return basicSetFirstRelativeDimension(null, msgs);
				case EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION:
					return basicSetSecondRelativeDimension(null, msgs);
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
			case EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION:
				return getFirstRelativeDimension();
			case EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION:
				return getSecondRelativeDimension();
			case EditormodelPackage.CONNECTION_BENDPOINT__WEIGHT:
				return new Float(getWeight());
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
			case EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION:
				setFirstRelativeDimension((Dimension)newValue);
				return;
			case EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION:
				setSecondRelativeDimension((Dimension)newValue);
				return;
			case EditormodelPackage.CONNECTION_BENDPOINT__WEIGHT:
				setWeight(((Float)newValue).floatValue());
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
			case EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION:
				setFirstRelativeDimension((Dimension)null);
				return;
			case EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION:
				setSecondRelativeDimension((Dimension)null);
				return;
			case EditormodelPackage.CONNECTION_BENDPOINT__WEIGHT:
				setWeight(WEIGHT_EDEFAULT);
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
			case EditormodelPackage.CONNECTION_BENDPOINT__FIRST_RELATIVE_DIMENSION:
				return firstRelativeDimension != null;
			case EditormodelPackage.CONNECTION_BENDPOINT__SECOND_RELATIVE_DIMENSION:
				return secondRelativeDimension != null;
			case EditormodelPackage.CONNECTION_BENDPOINT__WEIGHT:
				return weight != WEIGHT_EDEFAULT;
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
		result.append(" (weight: ");
		result.append(weight);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public ConnectionBendpoint clone() {
		ConnectionBendpoint newConnectionBendpoint = EditormodelFactory.eINSTANCE.createConnectionBendpoint();		
		newConnectionBendpoint.setFirstRelativeDimension(getFirstRelativeDimension().clone());
		newConnectionBendpoint.setSecondRelativeDimension(getSecondRelativeDimension().clone());
		newConnectionBendpoint.setWeight(getWeight());
		return newConnectionBendpoint;
	}

} //ConnectionBendpointImpl
