/**
 * <copyright>
 * </copyright>
 *
 * $Id: VisualModelImpl.java,v 1.72 2006/04/11 23:31:51 franco Exp $
 */
package org.isistan.flabot.edit.editormodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.edit.editormodel.Color;
import org.isistan.flabot.edit.editormodel.Diagram;
import org.isistan.flabot.edit.editormodel.Dimension;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.EditormodelPackage;
import org.isistan.flabot.edit.editormodel.Point;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Visual Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualModelImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualModelImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualModelImpl#getSemanticModel <em>Semantic Model</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualModelImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualModelImpl#getSize <em>Size</em>}</li>
 *   <li>{@link org.isistan.flabot.edit.editormodel.impl.VisualModelImpl#getDiagram <em>Diagram</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VisualModelImpl extends EObjectImpl implements VisualModel {
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
	 * The cached value of the '{@link #getSemanticModel() <em>Semantic Model</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSemanticModel()
	 * @generated
	 * @ordered
	 */
	protected EObject semanticModel = null;

/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated NOT
	 * @ordered
	 */
	protected Point location = EditormodelFactory.eINSTANCE.createPoint();
	{
		location.setX(0);
		location.setY(0);
	}

/**
	 * The cached value of the '{@link #getSize() <em>Size</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated NOT
	 * @ordered
	 */
	protected Dimension size = EditormodelFactory.eINSTANCE.createDimension();
	{
		size.setWidth(-1);
		size.setHeight(-1);
	}

/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated NOT
	 * @ordered
	 */
	protected Color backgroundColor = EditormodelFactory.eINSTANCE.createColor();
	{
		backgroundColor.setRed(255);
		backgroundColor.setGreen(255);
		backgroundColor.setBlue(255);
	}

/**
	 * The cached value of the '{@link #getForegroundColor() <em>Foreground Color</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForegroundColor()
	 * @generated NOT
	 * @ordered
	 */
	protected Color foregroundColor = EditormodelFactory.eINSTANCE.createColor();
	{
		foregroundColor.setRed(0);
		foregroundColor.setGreen(0);
		foregroundColor.setBlue(0);
	}
	
	/**
	 * The default value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineStyle()
	 * @generated NOT
	 * @ordered
	 */
	protected static final int LINE_STYLE_EDEFAULT = org.eclipse.draw2d.Graphics.LINE_SOLID;

/**
	 * The cached value of the '{@link #getLineStyle() <em>Line Style</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineStyle()
	 * @generated
	 * @ordered
	 */
	protected int lineStyle = LINE_STYLE_EDEFAULT;

/**
	 * The default value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int LINE_WIDTH_EDEFAULT = 1;

/**
	 * The cached value of the '{@link #getLineWidth() <em>Line Width</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLineWidth()
	 * @generated
	 * @ordered
	 */
	protected int lineWidth = LINE_WIDTH_EDEFAULT;

/**
	 * The default value of the '{@link #getDetailLevel() <em>Detail Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailLevel()
	 * @generated
	 * @ordered
	 */
	protected static final int DETAIL_LEVEL_EDEFAULT = 0;

/**
	 * The cached value of the '{@link #getDetailLevel() <em>Detail Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDetailLevel()
	 * @generated
	 * @ordered
	 */
	protected int detailLevel = DETAIL_LEVEL_EDEFAULT;

/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VisualModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return EditormodelPackage.eINSTANCE.getVisualModel();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getChildren() {
		if (children == null) {
			children = new EObjectContainmentWithInverseEList(VisualModel.class, this, EditormodelPackage.VISUAL_MODEL__CHILDREN, EditormodelPackage.VISUAL_MODEL__PARENT);
		}
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VisualModel getParent() {
		if (eContainerFeatureID != EditormodelPackage.VISUAL_MODEL__PARENT) return null;
		return (VisualModel)eContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(VisualModel newParent) {
		if (newParent != eContainer || (eContainerFeatureID != EditormodelPackage.VISUAL_MODEL__PARENT && newParent != null)) {
			if (EcoreUtil.isAncestor(this, newParent))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, EditormodelPackage.VISUAL_MODEL__CHILDREN, VisualModel.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newParent, EditormodelPackage.VISUAL_MODEL__PARENT, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getSemanticModel() {
		if (semanticModel != null && semanticModel.eIsProxy()) {
			EObject oldSemanticModel = semanticModel;
			semanticModel = (EObject)eResolveProxy((InternalEObject)semanticModel);
			if (semanticModel != oldSemanticModel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, EditormodelPackage.VISUAL_MODEL__SEMANTIC_MODEL, oldSemanticModel, semanticModel));
			}
		}
		return semanticModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetSemanticModel() {
		return semanticModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSemanticModelGen(EObject newSemanticModel) {
		EObject oldSemanticModel = semanticModel;
		semanticModel = newSemanticModel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__SEMANTIC_MODEL, oldSemanticModel, semanticModel));
	}

														/*
	 * when a new semantic model is set, the visual model must be removed
	 * form the old one's adapter list and added to the new one's
	 */
	public void setSemanticModel(EObject newSemanticModel) {
		EObject oldSemanticModel = semanticModel;
		setSemanticModelGen(newSemanticModel);
		if (oldSemanticModel != null)
			oldSemanticModel.eAdapters().remove(this);
		if (newSemanticModel != null)
			newSemanticModel.eAdapters().add(this);
	}
	
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Point getLocation() {
		return location;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLocation(Point newLocation, NotificationChain msgs) {
		Point oldLocation = location;
		location = newLocation;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__LOCATION, oldLocation, newLocation);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(Point newLocation) {
		if (newLocation != location) {
			NotificationChain msgs = null;
			if (location != null)
				msgs = ((InternalEObject)location).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__LOCATION, null, msgs);
			if (newLocation != null)
				msgs = ((InternalEObject)newLocation).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__LOCATION, null, msgs);
			msgs = basicSetLocation(newLocation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__LOCATION, newLocation, newLocation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Dimension getSize() {
		return size;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSize(Dimension newSize, NotificationChain msgs) {
		Dimension oldSize = size;
		size = newSize;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__SIZE, oldSize, newSize);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSize(Dimension newSize) {
		if (newSize != size) {
			NotificationChain msgs = null;
			if (size != null)
				msgs = ((InternalEObject)size).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__SIZE, null, msgs);
			if (newSize != null)
				msgs = ((InternalEObject)newSize).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__SIZE, null, msgs);
			msgs = basicSetSize(newSize, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__SIZE, newSize, newSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Diagram getDiagramGen() {
		if (eContainerFeatureID != EditormodelPackage.VISUAL_MODEL__DIAGRAM) return null;
		return (Diagram)eContainer;
	}

														public Diagram getDiagram() {
		Diagram diagram = getDiagramGen();
		if (diagram == null) {
			VisualModel parent = getParent();
			if (parent != null)
				diagram = parent.getDiagram();
		}
		return diagram;
	}
	
/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDiagram(Diagram newDiagram) {
		if (newDiagram != eContainer || (eContainerFeatureID != EditormodelPackage.VISUAL_MODEL__DIAGRAM && newDiagram != null)) {
			if (EcoreUtil.isAncestor(this, newDiagram))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eContainer != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newDiagram != null)
				msgs = ((InternalEObject)newDiagram).eInverseAdd(this, EditormodelPackage.DIAGRAM__CHILDREN, Diagram.class, msgs);
			msgs = eBasicSetContainer((InternalEObject)newDiagram, EditormodelPackage.VISUAL_MODEL__DIAGRAM, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__DIAGRAM, newDiagram, newDiagram));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBackgroundColor(Color newBackgroundColor, NotificationChain msgs) {
		Color oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR, oldBackgroundColor, newBackgroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(Color newBackgroundColor) {
		if (newBackgroundColor != backgroundColor) {
			NotificationChain msgs = null;
			if (backgroundColor != null)
				msgs = ((InternalEObject)backgroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR, null, msgs);
			if (newBackgroundColor != null)
				msgs = ((InternalEObject)newBackgroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR, null, msgs);
			msgs = basicSetBackgroundColor(newBackgroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR, newBackgroundColor, newBackgroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Color getForegroundColor() {
		return foregroundColor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetForegroundColor(Color newForegroundColor, NotificationChain msgs) {
		Color oldForegroundColor = foregroundColor;
		foregroundColor = newForegroundColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR, oldForegroundColor, newForegroundColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForegroundColor(Color newForegroundColor) {
		if (newForegroundColor != foregroundColor) {
			NotificationChain msgs = null;
			if (foregroundColor != null)
				msgs = ((InternalEObject)foregroundColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR, null, msgs);
			if (newForegroundColor != null)
				msgs = ((InternalEObject)newForegroundColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR, null, msgs);
			msgs = basicSetForegroundColor(newForegroundColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR, newForegroundColor, newForegroundColor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineStyle() {
		return lineStyle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineStyle(int newLineStyle) {
		int oldLineStyle = lineStyle;
		lineStyle = newLineStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__LINE_STYLE, oldLineStyle, lineStyle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getLineWidth() {
		return lineWidth;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLineWidth(int newLineWidth) {
		int oldLineWidth = lineWidth;
		lineWidth = newLineWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__LINE_WIDTH, oldLineWidth, lineWidth));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDetailLevel() {
		return detailLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDetailLevel(int newDetailLevel) {
		int oldDetailLevel = detailLevel;
		detailLevel = newDetailLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, EditormodelPackage.VISUAL_MODEL__DETAIL_LEVEL, oldDetailLevel, detailLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case EditormodelPackage.VISUAL_MODEL__CHILDREN:
					return ((InternalEList)getChildren()).basicAdd(otherEnd, msgs);
				case EditormodelPackage.VISUAL_MODEL__PARENT:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.VISUAL_MODEL__PARENT, msgs);
				case EditormodelPackage.VISUAL_MODEL__DIAGRAM:
					if (eContainer != null)
						msgs = eBasicRemoveFromContainer(msgs);
					return eBasicSetContainer(otherEnd, EditormodelPackage.VISUAL_MODEL__DIAGRAM, msgs);
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
				case EditormodelPackage.VISUAL_MODEL__CHILDREN:
					return ((InternalEList)getChildren()).basicRemove(otherEnd, msgs);
				case EditormodelPackage.VISUAL_MODEL__PARENT:
					return eBasicSetContainer(null, EditormodelPackage.VISUAL_MODEL__PARENT, msgs);
				case EditormodelPackage.VISUAL_MODEL__LOCATION:
					return basicSetLocation(null, msgs);
				case EditormodelPackage.VISUAL_MODEL__SIZE:
					return basicSetSize(null, msgs);
				case EditormodelPackage.VISUAL_MODEL__DIAGRAM:
					return eBasicSetContainer(null, EditormodelPackage.VISUAL_MODEL__DIAGRAM, msgs);
				case EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR:
					return basicSetBackgroundColor(null, msgs);
				case EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR:
					return basicSetForegroundColor(null, msgs);
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
				case EditormodelPackage.VISUAL_MODEL__PARENT:
					return eContainer.eInverseRemove(this, EditormodelPackage.VISUAL_MODEL__CHILDREN, VisualModel.class, msgs);
				case EditormodelPackage.VISUAL_MODEL__DIAGRAM:
					return eContainer.eInverseRemove(this, EditormodelPackage.DIAGRAM__CHILDREN, Diagram.class, msgs);
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
			case EditormodelPackage.VISUAL_MODEL__CHILDREN:
				return getChildren();
			case EditormodelPackage.VISUAL_MODEL__PARENT:
				return getParent();
			case EditormodelPackage.VISUAL_MODEL__SEMANTIC_MODEL:
				if (resolve) return getSemanticModel();
				return basicGetSemanticModel();
			case EditormodelPackage.VISUAL_MODEL__LOCATION:
				return getLocation();
			case EditormodelPackage.VISUAL_MODEL__SIZE:
				return getSize();
			case EditormodelPackage.VISUAL_MODEL__DIAGRAM:
				return getDiagram();
			case EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR:
				return getBackgroundColor();
			case EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR:
				return getForegroundColor();
			case EditormodelPackage.VISUAL_MODEL__LINE_STYLE:
				return new Integer(getLineStyle());
			case EditormodelPackage.VISUAL_MODEL__LINE_WIDTH:
				return new Integer(getLineWidth());
			case EditormodelPackage.VISUAL_MODEL__DETAIL_LEVEL:
				return new Integer(getDetailLevel());
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
			case EditormodelPackage.VISUAL_MODEL__CHILDREN:
				getChildren().clear();
				getChildren().addAll((Collection)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__PARENT:
				setParent((VisualModel)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__SEMANTIC_MODEL:
				setSemanticModel((EObject)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__LOCATION:
				setLocation((Point)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__SIZE:
				setSize((Dimension)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__DIAGRAM:
				setDiagram((Diagram)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR:
				setBackgroundColor((Color)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR:
				setForegroundColor((Color)newValue);
				return;
			case EditormodelPackage.VISUAL_MODEL__LINE_STYLE:
				setLineStyle(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.VISUAL_MODEL__LINE_WIDTH:
				setLineWidth(((Integer)newValue).intValue());
				return;
			case EditormodelPackage.VISUAL_MODEL__DETAIL_LEVEL:
				setDetailLevel(((Integer)newValue).intValue());
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
			case EditormodelPackage.VISUAL_MODEL__CHILDREN:
				getChildren().clear();
				return;
			case EditormodelPackage.VISUAL_MODEL__PARENT:
				setParent((VisualModel)null);
				return;
			case EditormodelPackage.VISUAL_MODEL__SEMANTIC_MODEL:
				setSemanticModel((EObject)null);
				return;
			case EditormodelPackage.VISUAL_MODEL__LOCATION:
				setLocation((Point)null);
				return;
			case EditormodelPackage.VISUAL_MODEL__SIZE:
				setSize((Dimension)null);
				return;
			case EditormodelPackage.VISUAL_MODEL__DIAGRAM:
				setDiagram((Diagram)null);
				return;
			case EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR:
				setBackgroundColor((Color)null);
				return;
			case EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR:
				setForegroundColor((Color)null);
				return;
			case EditormodelPackage.VISUAL_MODEL__LINE_STYLE:
				setLineStyle(LINE_STYLE_EDEFAULT);
				return;
			case EditormodelPackage.VISUAL_MODEL__LINE_WIDTH:
				setLineWidth(LINE_WIDTH_EDEFAULT);
				return;
			case EditormodelPackage.VISUAL_MODEL__DETAIL_LEVEL:
				setDetailLevel(DETAIL_LEVEL_EDEFAULT);
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
			case EditormodelPackage.VISUAL_MODEL__CHILDREN:
				return children != null && !children.isEmpty();
			case EditormodelPackage.VISUAL_MODEL__PARENT:
				return getParent() != null;
			case EditormodelPackage.VISUAL_MODEL__SEMANTIC_MODEL:
				return semanticModel != null;
			case EditormodelPackage.VISUAL_MODEL__LOCATION:
				return location != null;
			case EditormodelPackage.VISUAL_MODEL__SIZE:
				return size != null;
			case EditormodelPackage.VISUAL_MODEL__DIAGRAM:
				return getDiagram() != null;
			case EditormodelPackage.VISUAL_MODEL__BACKGROUND_COLOR:
				return backgroundColor != null;
			case EditormodelPackage.VISUAL_MODEL__FOREGROUND_COLOR:
				return foregroundColor != null;
			case EditormodelPackage.VISUAL_MODEL__LINE_STYLE:
				return lineStyle != LINE_STYLE_EDEFAULT;
			case EditormodelPackage.VISUAL_MODEL__LINE_WIDTH:
				return lineWidth != LINE_WIDTH_EDEFAULT;
			case EditormodelPackage.VISUAL_MODEL__DETAIL_LEVEL:
				return detailLevel != DETAIL_LEVEL_EDEFAULT;
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
		result.append(" (lineStyle: ");
		result.append(lineStyle);
		result.append(", lineWidth: ");
		result.append(lineWidth);
		result.append(", detailLevel: ");
		result.append(detailLevel);
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
		return getSemanticModel();
	}

	public void setTarget(Notifier newTarget) {
		// do nothing
	}

	public boolean isAdapterForType(Object type) {
		return Notifier.class.isAssignableFrom((Class)type);
	}

} //VisualModelImpl
