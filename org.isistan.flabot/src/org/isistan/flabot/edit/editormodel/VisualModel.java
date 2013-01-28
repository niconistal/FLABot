/**

import org.eclipse.emf.common.notify.Adapter;
 * VisualModel:
 * -	Abstract model for all Visual Models in flabot to extend from.
 * -	Holds children visual models by contention.
 * -	Contains visual properties such as color, dimension, location, line style, etc.
 * 
 * @author $Author: mblech $
 * @model
 */
public interface VisualModel  extends EObject, Adapter{

	public static final int LOW_DETAIL = 0;
	public static final int MEDIUM_DETAIL = 1;
	public static final int HIGH_DETAIL = 2;
	
	/**
	 * If this visual model isn't contained directly by the diagram,
	 * this method returns the parent's diagram (recursively)
	 * 
	 * @model opposite="children"
	 */
	Diagram getDiagram();
	
	/**
	 * <!-- end-user-doc -->
	void setDiagram(Diagram value);

	/**
	 * @model type="VisualModel" containment="true" opposite="parent"
	 */
	EList getChildren();
	
	/**
	 * @model opposite="children"
	 */
	VisualModel getParent();
	
	/**
	 * <!-- end-user-doc -->
	void setParent(VisualModel value);

	/**
	 * @model type="EObject"
	 */
	EObject getSemanticModel();
	
	/**
	 * <!-- end-user-doc -->
	void setSemanticModel(EObject value);

	/**
	 * @model containment="true"
	 */
	Point getLocation();
	
	/**
	 * <!-- end-user-doc -->
	void setLocation(Point value);

	/**
	 * @model containment="true"
	 */
	Dimension getSize();

	/**
	 * <!-- end-user-doc -->
	void setSize(Dimension value);

	/**
	 * @model containment="true"
	 */
	Color getBackgroundColor();
	
	/**
	 * <!-- end-user-doc -->
	void setBackgroundColor(Color value);

	/**
	 * @model containment="true"
	 */
	Color getForegroundColor();
	
	/**
	 * <!-- end-user-doc -->
	void setForegroundColor(Color value);

	/**
	 * @model default="org.eclipse.draw2d.Graphics.LINE_SOLID"
	 */
	int getLineStyle();

	/**
	 * <!-- end-user-doc -->
	void setLineStyle(int value);

	/**
	 * @model default="1"
	 */
	int getLineWidth();

	/**
	 * <!-- end-user-doc -->
	void setLineWidth(int value);

	/**
	 * @model default="0"
	 */
	int getDetailLevel();

	/**
	 * <!-- end-user-doc -->
	void setDetailLevel(int value);

}