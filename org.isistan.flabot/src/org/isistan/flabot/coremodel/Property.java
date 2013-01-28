/**

import org.eclipse.emf.ecore.EObject;
 * Property
 * -	Represents a key-value pair of string semantically relevant.
 * -	Currently a property can be added only to ComponentModels.
 * 
 * @model
 */
public interface Property extends EObject{

	/**
	 * @model default=""
	 */
	String getName();

	/**
	 * <!-- end-user-doc -->
	void setName(String value);

	/**
	 * @model default=""
	 */
	String getValue();

	/**
	 * <!-- end-user-doc -->
	void setValue(String value);

}