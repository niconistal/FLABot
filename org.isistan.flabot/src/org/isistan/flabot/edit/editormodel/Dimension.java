/**


import org.eclipse.emf.ecore.EObject;
 * Dimension storing an integer witdh and height
 * @author $Author: mblech $
 * @model
 */
public interface Dimension extends EObject{
	
	/**
	 * The width of this dimension
	 * @model
	 */
	int getWidth();
	
	/**
	 * <!-- end-user-doc -->
	void setWidth(int value);

	/**
	 * The height of this dimension
	 * @model
	 */
	int getHeight();
	/**
	 * <!-- end-user-doc -->
	void setHeight(int value);

	public Dimension clone();

}