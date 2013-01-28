/**

/**
 * @model
 */
public interface PatternMapping extends Mapping{
	/**
	 * Sets the value of the '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getBehaviorPattern <em>Behavior Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Behavior Pattern</em>' attribute.
	 * @see #getBehaviorPattern()
	 * @generated
	 */
	void setBehaviorPattern(String value);

	/**
	/**
	 * Sets the value of the '{@link org.isistan.flabot.mapping.mappingmodel.PatternMapping#getJavaFilePattern <em>Java File Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java File Pattern</em>' attribute.
	 * @see #getJavaFilePattern()
	 * @generated
	 */
	void setJavaFilePattern(String value);

	/**

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

}