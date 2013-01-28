/**

import org.eclipse.emf.ecore.EObject;
 * Abstract model for all Connection Bendpoint in flabot to extend from.
 * 
 * ConnectionBendpoint
 * - Represents a bendpoint used to render the line of a Connection Visual Model.
 * 
 * @author $Author: mblech $
 * @model
 */
public interface ConnectionBendpoint extends EObject{
	/**
	 * @model containment="true"
	 */
	Dimension getFirstRelativeDimension();
	

	/**
	 * <!-- end-user-doc -->
	void setFirstRelativeDimension(Dimension value);

	/**
	 * @model containment="true"
	 */
	Dimension getSecondRelativeDimension();
	
	/**
	 * <!-- end-user-doc -->
	void setSecondRelativeDimension(Dimension value);

	/**
	 * @model default="0.5f" 	   
	 */
	float getWeight();	

	/**
	 * <!-- end-user-doc -->
	void setWeight(float value);

	ConnectionBendpoint clone();

}