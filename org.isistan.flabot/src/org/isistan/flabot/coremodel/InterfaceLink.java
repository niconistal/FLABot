/**

/**
 * InterfaceLink
 * -	Represents a directed connection between a pair of interfaces (Source and Target).
 * 
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='InterfacesMustHaveSameName'"
 */
public interface InterfaceLink extends NamedElementModel, NoteElementModel {
	
	/**
	 * @model
	 */
	InterfaceModel getSource();
	
	/**
	 * <!-- end-user-doc -->
	void setSource(InterfaceModel value);

	/**
	 * @model
	 */
	InterfaceModel getTarget();
	
	/**
	 * <!-- end-user-doc -->
	void setTarget(InterfaceModel value);

}