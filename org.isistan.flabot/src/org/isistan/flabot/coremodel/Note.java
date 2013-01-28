/**

import org.eclipse.emf.common.util.EList;
 * @model
 */
public interface Note extends EObject{
	
	/**
	 * @model default=""
	 */
	String getNote();
	
	/**
	 * <!-- end-user-doc -->
	void setNote(String value);

	/**
	 * @model type="NoteElementModel"
	 */
	EList getTargets();
}