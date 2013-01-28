/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.executionstatemapping.model.impl;

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
import org.eclipse.emf.ecore.util.InternalEList;
import org.isistan.flabot.executionstatemapping.model.ExecutionStateMappingFileModel;
import org.isistan.flabot.executionstatemapping.model.ModelPackage;
import org.isistan.flabot.executionstatemapping.model.semantic.ExecutionCondition;
import org.isistan.flabot.executionstatemapping.model.semantic.MappedTreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.SemanticFactory;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeStructuredElement;
import org.isistan.flabot.executionstatemapping.model.semantic.TreeType;
import org.isistan.flabot.executionstatemapping.model.visual.StateDiagram;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution State Mapping File Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl#getStateContainersTree <em>State Containers Tree</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl#getMethodExecutionConditionsTree <em>Method Execution Conditions Tree</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl#getGeneralExecutionConditionsTree <em>General Execution Conditions Tree</em>}</li>
 *   <li>{@link org.isistan.flabot.executionstatemapping.model.impl.ExecutionStateMappingFileModelImpl#getStateDiagramsList <em>State Diagrams List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionStateMappingFileModelImpl extends EObjectImpl implements ExecutionStateMappingFileModel {
	/**
	 * The cached value of the '{@link #getStateContainersTree() <em>State Containers Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateContainersTree()
	 * @generated
	 * @ordered
	 */
	protected TreeStructuredElement stateContainersTree;

	/**
	 * The cached value of the '{@link #getMethodExecutionConditionsTree() <em>Method Execution Conditions Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethodExecutionConditionsTree()
	 * @generated
	 * @ordered
	 */
	protected MappedTreeStructuredElement methodExecutionConditionsTree;

	/**
	 * The cached value of the '{@link #getGeneralExecutionConditionsTree() <em>General Execution Conditions Tree</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGeneralExecutionConditionsTree()
	 * @generated
	 * @ordered
	 */
	protected TreeStructuredElement generalExecutionConditionsTree;

	/**
	 * The cached value of the '{@link #getStateDiagramsList() <em>State Diagrams List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateDiagramsList()
	 * @generated
	 * @ordered
	 */
	protected EList<StateDiagram> stateDiagramsList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionStateMappingFileModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.EXECUTION_STATE_MAPPING_FILE_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TreeStructuredElement getStateContainersTree() {
		if (stateContainersTree == null)
		{
			TreeStructuredElement newStateContainersTree;
			newStateContainersTree = SemanticFactory.eINSTANCE.createTreeStructuredElement(TreeType.FOLDER_STATE_DIAGRAM_TYPE);
			newStateContainersTree.setName("State Diagrams");
			setStateContainersTree(newStateContainersTree);
		}
		return stateContainersTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStateContainersTree(TreeStructuredElement newStateContainersTree, NotificationChain msgs) {
		TreeStructuredElement oldStateContainersTree = stateContainersTree;
		stateContainersTree = newStateContainersTree;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE, oldStateContainersTree, newStateContainersTree);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateContainersTree(TreeStructuredElement newStateContainersTree) {
		if (newStateContainersTree != stateContainersTree) {
			NotificationChain msgs = null;
			if (stateContainersTree != null)
				msgs = ((InternalEObject)stateContainersTree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE, null, msgs);
			if (newStateContainersTree != null)
				msgs = ((InternalEObject)newStateContainersTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE, null, msgs);
			msgs = basicSetStateContainersTree(newStateContainersTree, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE, newStateContainersTree, newStateContainersTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public MappedTreeStructuredElement getMethodExecutionConditionsTree() {
		
		if (methodExecutionConditionsTree==null)
		{
			MappedTreeStructuredElement newMethodExecutionConditionsTree;
			newMethodExecutionConditionsTree = SemanticFactory.eINSTANCE.createMappedTreeStructuredElement(TreeType.CONTAINER_TYPE);
			newMethodExecutionConditionsTree.setName("Method Execution Conditions");
			setMethodExecutionConditionsTree(newMethodExecutionConditionsTree);
		}
		if (!methodExecutionConditionsTree.isLoaded())
		{
			loadModel(methodExecutionConditionsTree);
			methodExecutionConditionsTree.setLoaded();
		}
		return methodExecutionConditionsTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMethodExecutionConditionsTree(MappedTreeStructuredElement newMethodExecutionConditionsTree, NotificationChain msgs) {
		MappedTreeStructuredElement oldMethodExecutionConditionsTree = methodExecutionConditionsTree;
		methodExecutionConditionsTree = newMethodExecutionConditionsTree;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE, oldMethodExecutionConditionsTree, newMethodExecutionConditionsTree);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMethodExecutionConditionsTree(MappedTreeStructuredElement newMethodExecutionConditionsTree) {
		if (newMethodExecutionConditionsTree != methodExecutionConditionsTree) {
			NotificationChain msgs = null;
			if (methodExecutionConditionsTree != null)
				msgs = ((InternalEObject)methodExecutionConditionsTree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE, null, msgs);
			if (newMethodExecutionConditionsTree != null)
				msgs = ((InternalEObject)newMethodExecutionConditionsTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE, null, msgs);
			msgs = basicSetMethodExecutionConditionsTree(newMethodExecutionConditionsTree, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE, newMethodExecutionConditionsTree, newMethodExecutionConditionsTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public TreeStructuredElement getGeneralExecutionConditionsTree() {
		if (generalExecutionConditionsTree == null)
		{
			TreeStructuredElement newGeneralExecutionConditionsTree;
			newGeneralExecutionConditionsTree = SemanticFactory.eINSTANCE.createTreeStructuredElement(TreeType.FOLDER_GENERAL_EXECUTION_CONDITION_TYPE);
			newGeneralExecutionConditionsTree.setName("General Execution Conditions");
			setGeneralExecutionConditionsTree(newGeneralExecutionConditionsTree);
		}		
		return generalExecutionConditionsTree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGeneralExecutionConditionsTree(TreeStructuredElement newGeneralExecutionConditionsTree, NotificationChain msgs) {
		TreeStructuredElement oldGeneralExecutionConditionsTree = generalExecutionConditionsTree;
		generalExecutionConditionsTree = newGeneralExecutionConditionsTree;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE, oldGeneralExecutionConditionsTree, newGeneralExecutionConditionsTree);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGeneralExecutionConditionsTree(TreeStructuredElement newGeneralExecutionConditionsTree) {
		if (newGeneralExecutionConditionsTree != generalExecutionConditionsTree) {
			NotificationChain msgs = null;
			if (generalExecutionConditionsTree != null)
				msgs = ((InternalEObject)generalExecutionConditionsTree).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE, null, msgs);
			if (newGeneralExecutionConditionsTree != null)
				msgs = ((InternalEObject)newGeneralExecutionConditionsTree).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE, null, msgs);
			msgs = basicSetGeneralExecutionConditionsTree(newGeneralExecutionConditionsTree, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE, newGeneralExecutionConditionsTree, newGeneralExecutionConditionsTree));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateDiagram> getStateDiagramsList() {
		if (stateDiagramsList == null) {
			stateDiagramsList = new EObjectContainmentEList<StateDiagram>(StateDiagram.class, this, ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST);
		}
		return stateDiagramsList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE:
				return basicSetStateContainersTree(null, msgs);
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE:
				return basicSetMethodExecutionConditionsTree(null, msgs);
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE:
				return basicSetGeneralExecutionConditionsTree(null, msgs);
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST:
				return ((InternalEList<?>)getStateDiagramsList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE:
				return getStateContainersTree();
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE:
				return getMethodExecutionConditionsTree();
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE:
				return getGeneralExecutionConditionsTree();
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST:
				return getStateDiagramsList();
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
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE:
				setStateContainersTree((TreeStructuredElement)newValue);
				return;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE:
				setMethodExecutionConditionsTree((MappedTreeStructuredElement)newValue);
				return;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE:
				setGeneralExecutionConditionsTree((TreeStructuredElement)newValue);
				return;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST:
				getStateDiagramsList().clear();
				getStateDiagramsList().addAll((Collection<? extends StateDiagram>)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE:
				setStateContainersTree((TreeStructuredElement)null);
				return;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE:
				setMethodExecutionConditionsTree((MappedTreeStructuredElement)null);
				return;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE:
				setGeneralExecutionConditionsTree((TreeStructuredElement)null);
				return;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST:
				getStateDiagramsList().clear();
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_CONTAINERS_TREE:
				return stateContainersTree != null;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__METHOD_EXECUTION_CONDITIONS_TREE:
				return methodExecutionConditionsTree != null;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__GENERAL_EXECUTION_CONDITIONS_TREE:
				return generalExecutionConditionsTree != null;
			case ModelPackage.EXECUTION_STATE_MAPPING_FILE_MODEL__STATE_DIAGRAMS_LIST:
				return stateDiagramsList != null && !stateDiagramsList.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	
	@Override
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		return eGet(eDerivedStructuralFeatureID(eFeature), resolve, true);
	}

	@Override
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		eSet(eDerivedStructuralFeatureID(eFeature), newValue);
	}

	@Override
	public void eUnset(EStructuralFeature eFeature) {
		eUnset(eDerivedStructuralFeatureID(eFeature));
	}

	@Override
	public boolean eIsSet(EStructuralFeature eFeature) {
		return eIsSet(eDerivedStructuralFeatureID(eFeature));
	}

	private static void loadModel(TreeStructuredElement executionConditionContainer) {
		//For each project
		MappedTreeStructuredElement projectMap;
		for (TreeStructuredElement projectTree : executionConditionContainer
				.getPersistentList()) 
		{
			projectMap = (MappedTreeStructuredElement) projectTree;
			//For each package root
			MappedTreeStructuredElement packageRootMap = null;						
			for (TreeStructuredElement packageRootTree : projectMap
					.getPersistentList()) 
			{
				packageRootMap = (MappedTreeStructuredElement) packageRootTree;
				executionConditionContainer
						.addTreeStructuredElement(packageRootMap);
				
				//For each Method Execution Condition
				ExecutionCondition executionCondition;
				for (TreeStructuredElement executionConditionElement : packageRootMap
						.getPersistentList()) 
				{
					
					executionCondition = (ExecutionCondition) executionConditionElement;					

					if (executionCondition.getPatternMapping() == null)
						continue;
					
					String packageName = executionCondition.getPatternMapping().getPackagePattern();

					MappedTreeStructuredElement packageMap = (MappedTreeStructuredElement) packageRootMap
							.getTreeStructuredElement(packageName);
					if (packageMap == null) 
					{
						packageMap = SemanticFactory.eINSTANCE
								.createMappedTreeStructuredElement(TreeType.PACKAGE_TYPE);
						packageMap.setName(packageName);
						packageRootMap.addTreeStructuredElement(packageMap);
					}

					String className = executionCondition.getPatternMapping().getClassPattern();
					
					TreeStructuredElement classTree = packageMap
							.getTreeStructuredElement(className);
					if (classTree == null) 
					{
						classTree = SemanticFactory.eINSTANCE
								.createMappedTreeStructuredElement(TreeType.CLASS_TYPE);
						classTree.setName(className);
						packageMap.addTreeStructuredElement(classTree);
					}
					classTree.addTreeStructuredElement(executionCondition);
				}
								
				projectMap.addTreeStructuredElement(packageRootMap);
			}						
			executionConditionContainer.addTreeStructuredElement(projectMap);
		}
	}
	
} //ExecutionStateMappingFileModelImpl
