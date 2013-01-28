/**

import org.eclipse.emf.common.util.EList;
 * PortModel
 * -	Represents a container for a group of component’s interfaces.
 * -	Holds interfaces in two lists: provided and required.
 * 
 * @model
 */
public interface PortModel extends NamedElementModel, PropertyElementModel{
	static final String DEFAULT_NAME = Messages.getString("org.isistan.flabot.coremodel.PortModel.defaultName"); //$NON-NLS-1$

	/**
	 * @model type="InterfaceModel" containment="true"
	 */
	EList getProvideds();
	
	/**
	 * @model type="InterfaceModel" containment="true"
	 */
	EList getRequireds();

	/**
	 * @model opposite="ownedPorts"
	 */
	ComponentModel getComponent();
	/**
	 * <!-- end-user-doc -->
	void setComponent(ComponentModel value);

}