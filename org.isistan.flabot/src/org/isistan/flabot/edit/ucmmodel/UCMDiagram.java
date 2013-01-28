/**

import org.eclipse.emf.common.notify.Adapter;
 * UCMDiagram:
 * -	Extends from Diagram, represents a use case map diagram shown by the use case map diagram editor.
 * 
 * @model
 */
public interface UCMDiagram extends Diagram, Adapter{
	
	/**
	 * @model
	 */
	UseCaseMap getMap();

	/**
	 * <!-- end-user-doc -->
	void setMap(UseCaseMap value);

}