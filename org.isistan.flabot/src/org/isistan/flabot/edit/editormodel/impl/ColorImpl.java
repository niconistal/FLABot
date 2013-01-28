/**
 * <copyright>
 * </copyright>
 *
 * $Id: ColorImpl.java,v 1.2 2005/12/02 19:14:48 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Color</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ColorImpl#getRed <em>Red</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ColorImpl#getGreen <em>Green</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.ColorImpl#getBlue <em>Blue</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ColorImpl extends EObjectImpl implements Color {
	/**
	 * The default value of the '{@link #getRed() <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRed()
	 * @generated
	 * @ordered
	 */
	protected static final int RED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRed() <em>Red</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRed()
	 * @generated
	 * @ordered
	 */
	protected int red = RED_EDEFAULT;

	/**
	 * The default value of the '{@link #getGreen() <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGreen()
	 * @generated
	 * @ordered
	 */
	protected static final int GREEN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getGreen() <em>Green</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGreen()
	 * @generated
	 * @ordered
	 */
	protected int green = GREEN_EDEFAULT;

	/**
	 * The default value of the '{@link #getBlue() <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlue()
	 * @generated
	 * @ordered
	 */
	protected static final int BLUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBlue() <em>Blue</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBlue()
	 * @generated
	 * @ordered
	 */
	protected int blue = BLUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ColorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getColor();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRed() {
		return red;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRed(int newRed) {
		int oldRed = red;
		red = newRed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.COLOR__RED, oldRed, red));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getGreen() {
		return green;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGreen(int newGreen) {
		int oldGreen = green;
		green = newGreen;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.COLOR__GREEN, oldGreen, green));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBlue() {
		return blue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBlue(int newBlue) {
		int oldBlue = blue;
		blue = newBlue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.COLOR__BLUE, oldBlue, blue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case EditormodelPackage.COLOR__RED:
				return new Integer(getRed());
			case EditormodelPackage.COLOR__GREEN:
				return new Integer(getGreen());
			case EditormodelPackage.COLOR__BLUE:
				return new Integer(getBlue());
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
			case EditormodelPackage.COLOR__RED:
				setRed(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.COLOR__GREEN:
				setGreen(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.COLOR__BLUE:
				setBlue(((Integer)newValue).intValue());
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
			case EditormodelPackage.COLOR__RED:
				setRed(RED_EDEFAULT);
				return;
			case EditormodelPackage.COLOR__GREEN:
				setGreen(GREEN_EDEFAULT);
				return;
			case EditormodelPackage.COLOR__BLUE:
				setBlue(BLUE_EDEFAULT);
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
			case EditormodelPackage.COLOR__RED:
				return red != RED_EDEFAULT;
			case EditormodelPackage.COLOR__GREEN:
				return green != GREEN_EDEFAULT;
			case EditormodelPackage.COLOR__BLUE:
				return blue != BLUE_EDEFAULT;
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
		result.append(" (red: ");
		result.append(red);
		result.append(", green: ");
		result.append(green);
		result.append(", blue: ");
		result.append(blue);
		result.append(')');
		return result.toString();
	}

	public Color clone() {
		Color newColor = EditormodelFactory.eINSTANCE.createColor();
		newColor.setBlue(getBlue());
		newColor.setGreen(getGreen());
		newColor.setRed(getRed());
		return newColor;
	}
	
} //ColorImpl
