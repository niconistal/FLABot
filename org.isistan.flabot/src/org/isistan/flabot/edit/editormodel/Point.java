/**

import org.eclipse.emf.ecore.EObject;
 * Point storing an integer X and Y
 * @author $Author: mblech $
 * @model
 */
public interface Point extends EObject{
	
	/**
	 * The X of this point
	 * @model
	 */
	int getX();
	
	/**
	 * <!-- end-user-doc -->
	void setX(int value);

	/**
	 * The Y of this point
	 * @model
	 */
	int getY();
	/**
	 * <!-- end-user-doc -->
	void setY(int value);

	Point clone();

}