/**

import org.eclipse.emf.ecore.EObject;
 * Color storing Red Green and Blue
 * @author $Author: mblech $
 * @model
 */
public interface Color extends EObject{
	
	/**
	 * The red of this color
	 * @model
	 */
	int getRed();

	/**
	 * <!-- end-user-doc -->
	void setRed(int value);

	/**
	 * The green of this color
	 * @model
	 */
	int getGreen();

	/**
	 * <!-- end-user-doc -->
	void setGreen(int value);

	/**
	 * The blue of this color
	 * @model
	 */
	int getBlue();
	/**
	 * <!-- end-user-doc -->
	void setBlue(int value);

	Color clone();
}