/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.semantic.impl;

import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mapped Tree Structured Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.semantic.impl.MappedTreeStructuredElementImpl#getTreeStructuredElementMap <em>Tree Structured Element Map</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MappedTreeStructuredElementImpl extends TreeStructuredElementImpl implements MappedTreeStructuredElement
{
	/**
	 * The cached value of the '{@link #getTreeStructuredElementMap() <em>Tree Structured Element Map</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTreeStructuredElementMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, TreeStructuredElement> treeStructuredElementMap;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedTreeStructuredElementImpl()
	{
		super();
	}

	protected MappedTreeStructuredElementImpl(TreeType treeType)
	{
		super(treeType);		
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return SemanticPackage.Literals.MAPPED_TREE_STRUCTURED_ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EMap<String, TreeStructuredElement> getTreeStructuredElementMap()
	{
		if (treeStructuredElementMap == null) {
			treeStructuredElementMap = new EcoreEMap<String,TreeStructuredElement>(SemanticPackage.Literals.ESTRING_TO_TREE_STRUCTURED_ELEMENT, EStringToTreeStructuredElementImpl.class, this, SemanticPackage.MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP);
		}
		return treeStructuredElementMap;
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
			case SemanticPackage.MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP:
				if (coreType) return getTreeStructuredElementMap();
				else return getTreeStructuredElementMap().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case SemanticPackage.MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP:
				((EStructuralFeature.Setting)getTreeStructuredElementMap()).set(newValue);
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
			case SemanticPackage.MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP:
				getTreeStructuredElementMap().clear();
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
			case SemanticPackage.MAPPED_TREE_STRUCTURED_ELEMENT__TREE_STRUCTURED_ELEMENT_MAP:
				return treeStructuredElementMap != null && !treeStructuredElementMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public boolean addTreeStructuredElement(TreeStructuredElement treeStructuredElement)
	{
		boolean added = super.addTreeStructuredElement(treeStructuredElement);
		if (added)
		{
			getTreeStructuredElementMap().put(treeStructuredElement.getName(), treeStructuredElement);
		}
		return added;		
	}

	@Override
	public boolean removeTreeStructuredElement(TreeStructuredElement treeStructuredElement)
    {
		boolean removed = super.removeTreeStructuredElement(treeStructuredElement);
		if (removed)
		{
			getTreeStructuredElementMap().remove(treeStructuredElement.getName());
		}
		return removed;    	
    }
	
	public TreeStructuredElement getTreeStructuredElement(String name)
	{
		return getTreeStructuredElementMap().get(name);
	}
	
	private boolean loaded = false;
	
	public boolean isLoaded()
	{
		return loaded;
	}
	
	public void setLoaded()
	{
		loaded = true;
	}

} //MappedTreeStructuredElementImpl
