/**

import org.eclipse.emf.common.util.EList;
 * ConnectionVisualModel
 * -	Abstract model for all Connection Visual Models in flabot to extend from.
 * -	Extends NodeVisualModel.
 * -	Represents a connection between NodeVisualModels.
 * -	Contains the Connection Bendpoints used to render the line.
 * 
 * @author $Author: mblech $
 * @model
 */
public interface ConnectionVisualModel extends NodeVisualModel {

	/**
	 * @model default=""
	 */
	String getSourceTerminal();
	
	/**
	 * <!-- end-user-doc -->
	void setSourceTerminal(String value);

	/**
	 * @model default=""
	 */
	String getTargetTerminal();
	
	/**
	 * <!-- end-user-doc -->
	void setTargetTerminal(String value);

	/**
	 * @model opposite="sourceConnections"
	 */
	NodeVisualModel getSource();
	
	/**
	 * <!-- end-user-doc -->
	void setSource(NodeVisualModel value);

	/**
	 * @model opposite="targetConnections"
	 */
	NodeVisualModel getTarget();
	
	/**
	 * <!-- end-user-doc -->
	void setTarget(NodeVisualModel value);

	/**
	 * @model type="ConnectionBendpoint" containment="true"
	 */
	EList getBendpoints();
}