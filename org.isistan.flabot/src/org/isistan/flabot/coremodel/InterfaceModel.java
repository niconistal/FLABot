/**

import org.isistan.flabot.messages.Messages;
 * InterfaceModel
 * -	Represents a component’s provided or required interface.
 * 
 * @model
 */
public interface InterfaceModel extends NamedElementModel{
	static final String DEFAULT_NAME = Messages.getString("org.isistan.flabot.coremodel.InterfaceModel.defaultName"); //$NON-NLS-1$
	/**
	 * @model
	 */
	PortModel getPort();
	/**
	 * <!-- end-user-doc -->
	void setPort(PortModel value);

}