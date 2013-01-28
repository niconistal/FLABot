/**

import org.eclipse.emf.common.util.EList;
 * Represents a family to be used in mapping dependencies
 * @author $Author: apersson $
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='FamilyHasAllComponent'"
 * @model
 */
public interface Family extends NamedElementModel{
	
	/**
	 * @model type="FamilyElement" containment="true"
	 */
	EList getFamilyElement();

	/**
	 * @model type="SimplePathNode"
	 */
	EList getAssociatedResponsibilities();

	/**
}