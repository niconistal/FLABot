/**

import org.eclipse.emf.ecore.EObject;
 * @model
 */
public interface NamedElementModel extends EObject {
	/**
	 * @model default=""
	 */
	String getName();
	
	/**
	 * 
	 */
	String getID();

	/**
	 * <!-- end-user-doc -->
	void setName(String value);

}