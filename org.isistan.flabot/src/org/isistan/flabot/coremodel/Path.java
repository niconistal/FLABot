/**

import org.eclipse.emf.common.util.EList;
 * Path
 * -	Represents a flow of data between components.
 * -	Contains a sequence of PathNodes, 
 * -	Holds two lists of start and end nodes. Lists are used because there may be forks and joins in the path.
 * 
 * @model
 */
public interface Path extends NamedElementModel {
	static final String DEFAULT_NAME = Messages.getString("org.isistan.flabot.coremodel.Path.defaultName"); //$NON-NLS-1$

	/**
	 * @model type="PathNode" containment="true" opposite="path"
	 */
	EList getNodes();
	
	/**
	 * @model type="PathNode"
	 */
	EList getStartNodes();
	
	/**
	 * @model type="PathNode"
	 */
	EList getEndNodes();

}