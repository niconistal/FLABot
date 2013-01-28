/**

/**
 * @model
 */
public interface Relationship extends NamedElementModel, PropertyElementModel, StereotypedElementModel, NoteElementModel{
	/**
	 * Direction of the relationship
	 * @model
	 * @return
	 */
	RelationshipDirection getDirection();
	
	
	/**
	 * <!-- end-user-doc -->
	void setDirection(RelationshipDirection value);

	/**
	 * @model
	 */
	ComponentModel getSource();
	
	/**
	 * <!-- end-user-doc -->
	void setSource(ComponentModel value);

	/**
	 * @model
	 */
	ComponentModel getTarget();
	/**
	 * <!-- end-user-doc -->
	void setTarget(ComponentModel value);

}