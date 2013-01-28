/**

/**
 * Represents a State of a family to be used in mapping dependencies
 * @author $Author: dacostae $
 * @model
 */
public interface FamilyElement extends NamedElementModel{
	
	/**
	 * The Secenario of the family
	 * @model
	 */
	UseCaseMap getUseCaseMap();
	
	/**
	 * <!-- end-user-doc -->
	void setUseCaseMap(UseCaseMap value);

	/**
	 * The Functional Component of the family
	 * @model
	 */
	ComponentRole getFunctionalComponent();
	
	/**
	 * <!-- end-user-doc -->
	void setFunctionalComponent(ComponentRole value);

	/**
	 * The Architectural Component of the family
	 * @model
	 */
	ComponentRole getArchitecturalComponent ();

	/**
	 * <!-- end-user-doc -->
	void setArchitecturalComponent(ComponentRole value);

}