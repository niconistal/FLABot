/**

import org.eclipse.emf.common.util.EList;
 * NodeVisualModel
 * -	Abstract model for all Node Visual Models in flabot to extend from.
 * -	Extends VisualModel.
 * -	Represents a visual model that can have connections to other visual models thought ConnectionVisualModels.
 * 
 * @author $Author: franco $
 * @model
 */
public interface NodeVisualModel extends VisualModel {
	/**
	 * @model default=""
	 */
	String getRotation();
	
	/**
	 * <!-- end-user-doc -->
	void setRotation(String value);

	/**
	 * @model type="ConnectionVisualModel" opposite="source" containment="true"
	 */
	EList getSourceConnections();
	
	/**
	 * @model type="ConnectionVisualModel" opposite="target"
	 */
	EList getTargetConnections();
	 * Get this visual model's absolute location, that is the sum of its
	 * parent's absolute location and its relative location
	 * @return
	 */
	Point getAbsoluteLocation();
}