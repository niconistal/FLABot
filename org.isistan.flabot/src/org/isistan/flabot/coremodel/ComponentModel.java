/**

import org.eclipse.emf.common.notify.Adapter;
/**
 * ComponentModel
 * -	Represents a component.
 * -	Contains a set of features, such as responsibilities, and a set of owned ports containing interfaces.
 * 
 * @model
 */
public interface ComponentModel extends ExtensibleElement, NamedElementModel, PropertyElementModel, StereotypedElementModel, NoteElementModel, Adapter{


	/**
	 * @model type="FeatureModel" opposite="components"
	 */
	EList getFeatures();
		
	/**
	 * @model type="PortModel" containment="true"
	 */
	EList getOwnedPorts();

	/**
	 * <!-- end-user-doc -->
	void setCoreModel(CoreModel value);

	/**
}