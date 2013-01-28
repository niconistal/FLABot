/** * $Id: PatternMapping.java,v 1.5 2006/03/24 00:34:01 dacostae Exp $ * $Author: dacostae $ */package org.isistan.flabot.mapping.mappingmodel;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;import org.isistan.flabot.util.TriState;
/** * This mapping is based on regular expressions
 * @model
 */
public interface PatternMapping extends Mapping{		public static final String ALL_MARK= "@"; 	
	/**	 * Get the pattern used to map to behaviors	 * @return	 * @model	 */	String getBehaviorPattern();		/**
	 * Sets the value of the '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getBehaviorPattern <em>Behavior Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Pattern</em>' attribute.
	 * @see #getBehaviorPattern()
	 * @generated
	 */
	void setBehaviorPattern(String value);

	/**	 * Get the java file pattern used to reduce the search 	 * @return	 * @model	 */	String getJavaFilePattern();	
	/**
	 * Sets the value of the '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getJavaFilePattern <em>Java File Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java File Pattern</em>' attribute.
	 * @see #getJavaFilePattern()
	 * @generated
	 */
	void setJavaFilePattern(String value);

	/**	 * Get the class pattern used to reduce the search 	 * @return	 * @model	 */	String getClassPattern();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getClassPattern <em>Class Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Pattern</em>' attribute.
	 * @see #getClassPattern()
	 * @generated
	 */
	void setClassPattern(String value);

	/**
	 * Get the package pattern used to reduce the search 
	 * @return
	 * @model
	 */
	String getPackagePattern();
	/**
	 * Sets the value of the '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getPackagePattern <em>Package Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Pattern</em>' attribute.
	 * @see #getPackagePattern()
	 * @generated
	 */
	void setPackagePattern(String value);
		/**	 * Returns true if the java file passed is mapped	 * @param jJavaFile	 * @return	 */	TriState passes(JJavaFile jJavaFile);
}
