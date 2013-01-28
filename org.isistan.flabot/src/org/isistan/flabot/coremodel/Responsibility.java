/**

import org.eclipse.emf.common.util.EList;
 * Responsibility
 * -	A responsibility is a kind of behavioural feature.
 * -	Contains a description and a set of pre and post conditions.
 * 
 * @model
 */
public interface Responsibility extends BehavioralFeatureModel{
	/**
	 * @model default=""
	 */	
	String getDescription();
	/**
	 * <!-- end-user-doc -->
	void setDescription(String value);

	/**
	 * @model type="Condition" containment="true"
	 */
	EList getPreconditions();
	
	/**
	 * @model type="Condition" containment="true"
	 */
	EList getPostconditions();

	/**
	 * <!-- end-user-doc -->
	void setCoreModel(CoreModel value);

}