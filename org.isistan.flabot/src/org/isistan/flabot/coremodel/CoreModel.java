/**

import org.eclipse.emf.common.util.EList;
 * CoreModel
 * -	Is a container for all semantic elements: Components, UseCaseMaps, Relationships, Responsibilities, etc.
 * 
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='ResponsibilityGeneral ConditionEventGeneral'"
 */
public interface CoreModel extends EObject{
	/**
	 * @model opposite="coreModel"
	 */
	FlabotFileModel getFile();
	
	/**
	 * <!-- end-user-doc -->
	void setFile(FlabotFileModel value);

	/**
	 * 
	 * @model type="ComponentModel" containment="true" opposite="coreModel"
	 */
	EList getComponents();
	
	/**
	 * @model type="Responsibility" containment="true" opposite="coreModel"
	 */
	EList getResponsibilities();
	
	/**
	 * @model type="UseCaseMap" containment="true" opposite="coreModel"
	 */
	EList getUseCaseMaps();
	
	/**
	 * @model type="InterfaceLink" containment="true"
	 */
	EList getInterfaceLinks();
	
	/**
	 * @model type="Relationship" containment="true"
	 */
	EList getRelationships();
	
	/**
	 * @model type="Stereotype" containment="true"
	 */
	EList getStereotypes();
	
	/**
	 * @model type="Family" containment="true"
	 */
	EList getFamilies();
}