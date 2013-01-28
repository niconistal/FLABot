/**

import org.eclipse.emf.common.util.EList;
 * UseCaseMap
 * -	Represents a use case map.
 * -	Holds by contention all Paths and ComponentRoles present in the map.
 * -	Has some other properties like description.
 * 
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UseCaseMapGeneral'"
 */
public interface UseCaseMap extends NamedElementModel{
	
	public static final String architecturalLevel = "Architectural"; //$NON-NLS-1$
	public static final String functionalLevel = "Functional"; //$NON-NLS-1$
	
	/**
	 * @model type="Path" containment="true"
	 */
	EList getPaths();
	
	/**
	 * @model type="ComponentRole" containment="true" opposite="map"
	 */
	EList getComponentRoles();
	
	/**
	 * @model opposite="useCaseMaps"
	 */
	CoreModel getCoreModel();

	/**
	 * <!-- end-user-doc -->
	void setCoreModel(CoreModel value);

	/**
	 * @model default=""
	 */
	String getDescription();

	/**
	 * <!-- end-user-doc -->
	void setDescription(String value);

	/**
	 * @model
	 */
	String getLevelInfo();

	/**
	 * <!-- end-user-doc -->
	void setLevelInfo(String value);

}