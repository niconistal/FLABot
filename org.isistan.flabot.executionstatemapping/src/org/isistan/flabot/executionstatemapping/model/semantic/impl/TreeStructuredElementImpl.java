/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Tree Structured Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl#getTreeStructuredElements <em>Tree Structured Elements</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl#getParent <em>Parent</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.TreeStructuredElementImpl#getPersistentList <em>Persistent List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TreeStructuredElementImpl extends NamedElementImpl implements TreeStructuredElement
{
	/**
	 * The cached value of the '{@link #getTreeStructuredElements() <em>Tree Structured Elements</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTreeStructuredElements()
	 * @generated
	 * @ordered
	 */
	protected EList<TreeStructuredElement> treeStructuredElements;

	/**
	 * The cached value of the '{@link #getParent() <em>Parent</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParent()
	 * @generated
	 * @ordered
	 */
	protected TreeStructuredElement parent;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final TreeType TYPE_EDEFAULT = TreeType.CONTAINER_TYPE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected TreeType type = TYPE_EDEFAULT;
	

	/**
	 * The cached value of the '{@link #getPersistentList() <em>Persistent List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPersistentList()
	 * @generated
	 * @ordered
	 */
	protected EList<TreeStructuredElement> persistentList;


	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TreeStructuredElementImpl()
	{
		super();
	}

	protected TreeStructuredElementImpl(TreeType type)
	{
		super();
		setType(type);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return SemanticPackage.Literals.TREE_STRUCTURED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TreeStructuredElement> getTreeStructuredElements()
	{
		if (treeStructuredElements == null) {
			treeStructuredElements = new EObjectWithInverseResolvingEList<TreeStructuredElement>(TreeStructuredElement.class, this, SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS, SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT);
		}
		return treeStructuredElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeStructuredElement getParent()
	{
		if (parent != null && parent.eIsProxy()) {
			InternalEObject oldParent = (InternalEObject)parent;
			parent = (TreeStructuredElement)eResolveProxy(oldParent);
			if (parent != oldParent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT, oldParent, parent));
			}
		}
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeStructuredElement basicGetParent() {
		return parent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParent(TreeStructuredElement newParent, NotificationChain msgs)
	{
		TreeStructuredElement oldParent = parent;
		parent = newParent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT, oldParent, newParent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParent(TreeStructuredElement newParent)
	{
		if (newParent != parent) {
			NotificationChain msgs = null;
			if (parent != null)
				msgs = ((InternalEObject)parent).eInverseRemove(this, SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS, TreeStructuredElement.class, msgs);
			if (newParent != null)
				msgs = ((InternalEObject)newParent).eInverseAdd(this, SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS, TreeStructuredElement.class, msgs);
			msgs = basicSetParent(newParent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT, newParent, newParent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TreeType getType()
	{
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(TreeType newType)
	{
		TreeType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SemanticPackage.TREE_STRUCTURED_ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TreeStructuredElement> getPersistentList() {
		if (persistentList == null) {
			persistentList = new EObjectContainmentEList<TreeStructuredElement>(TreeStructuredElement.class, this, SemanticPackage.TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST);
		}
		return persistentList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getTreeStructuredElements()).basicAdd(otherEnd, msgs);
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT:
				if (parent != null)
					msgs = ((InternalEObject)parent).eInverseRemove(this, SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS, TreeStructuredElement.class, msgs);
				return basicSetParent((TreeStructuredElement)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS:
				return ((InternalEList<?>)getTreeStructuredElements()).basicRemove(otherEnd, msgs);
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT:
				return basicSetParent(null, msgs);
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST:
				return ((InternalEList<?>)getPersistentList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS:
				return getTreeStructuredElements();
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT:
				if (resolve) return getParent();
				return basicGetParent();
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TYPE:
				return getType();
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST:
				return getPersistentList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS:
				getTreeStructuredElements().clear();
				getTreeStructuredElements().addAll((Collection<? extends TreeStructuredElement>)newValue);
				return;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT:
				setParent((TreeStructuredElement)newValue);
				return;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TYPE:
				setType((TreeType)newValue);
				return;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST:
				getPersistentList().clear();
				getPersistentList().addAll((Collection<? extends TreeStructuredElement>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS:
				getTreeStructuredElements().clear();
				return;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT:
				setParent((TreeStructuredElement)null);
				return;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST:
				getPersistentList().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENTS:
				return treeStructuredElements != null && !treeStructuredElements.isEmpty();
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PARENT:
				return parent != null;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__TYPE:
				return type != TYPE_EDEFAULT;
			case SemanticPackage.TREE_STRUCTURED_ELEMENT__PERSISTENT_LIST:
				return persistentList != null && !persistentList.isEmpty();
		}
		return super.eIsSet(featureID);
	}
		
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

	public boolean addTreeStructuredElement(TreeStructuredElement treeStructuredElement)
	{
		boolean added = false;
		if (!getTreeStructuredElements().contains(treeStructuredElement))
		{
			added = getTreeStructuredElements().add(treeStructuredElement);
		}
		return added;		
	}

	public boolean removeTreeStructuredElement(TreeStructuredElement treeStructuredElement)
    {
		boolean removed = false;
		if (getTreeStructuredElements().contains(treeStructuredElement))
		{
			removed = getTreeStructuredElements().remove(treeStructuredElement);
		}
		return removed;    	
    }
	
	public boolean addPersistentTreeStructuredElement(TreeStructuredElement treeStructuredElement)
	{
		boolean added = false;
		if (!getPersistentList().contains(treeStructuredElement))
		{
			added = getPersistentList().add(treeStructuredElement);
		}
		return added;		
	}

	public boolean removePersistentTreeStructuredElement(TreeStructuredElement treeStructuredElement)
    {
		boolean removed = false;
		if (getPersistentList().contains(treeStructuredElement))
		{
			removed = getPersistentList().remove(treeStructuredElement);
		}
		return removed;    	
    }
    
    public List<TreeStructuredElement> uGetTreeStructuredElements()
    {
    	return ECollections.unmodifiableEList(getTreeStructuredElements());
    }
    
    public TreeStructuredElement getAntecesor(TreeType type)
    {
    	if (this.type == type)
    		return this;
    	
    	if (getParent() != null)
    		return getParent().getAntecesor(type);
    	
    	return null;
    }
 

} //TreeStructuredElementImpl
