/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.isistan.flabot.coremodel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timer Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.isistan.flabot.coremodel.TimerNode#getTimerName <em>Timer Name</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.TimerNode#getTimerDescription <em>Timer Description</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.TimerNode#getTimerType <em>Timer Type</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.TimerNode#getTimerTimeOut <em>Timer Time Out</em>}</li>
 *   <li>{@link org.isistan.flabot.coremodel.TimerNode#getTimerTimeOutUnity <em>Timer Time Out Unity</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.isistan.flabot.coremodel.CoremodelPackage#getTimerNode()
 * @model
 * @generated
 */
public interface TimerNode extends ResponsibilityNode, NamedElementModel {
	public static final int TIMER_TYPE = 0;
	public static final int WAITING_PLACE_TYPE = 1;
	
	/**
	 * Returns the value of the '<em><b>Timer Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer Name</em>' attribute.
	 * @see #setTimerName(String)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getTimerNode_TimerName()
	 * @model default=""
	 * @generated
	 */
	String getTimerName();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.TimerNode#getTimerName <em>Timer Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer Name</em>' attribute.
	 * @see #getTimerName()
	 * @generated
	 */
	void setTimerName(String value);

	/**
	 * Returns the value of the '<em><b>Timer Description</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer Description</em>' attribute.
	 * @see #setTimerDescription(String)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getTimerNode_TimerDescription()
	 * @model default=""
	 * @generated
	 */
	String getTimerDescription();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.TimerNode#getTimerDescription <em>Timer Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer Description</em>' attribute.
	 * @see #getTimerDescription()
	 * @generated
	 */
	void setTimerDescription(String value);

	/**
	 * Returns the value of the '<em><b>Timer Type</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer Type</em>' attribute.
	 * @see #setTimerType(int)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getTimerNode_TimerType()
	 * @model default="0"
	 * @generated
	 */
	int getTimerType();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.TimerNode#getTimerType <em>Timer Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer Type</em>' attribute.
	 * @see #getTimerType()
	 * @generated
	 */
	void setTimerType(int value);

	/**
	 * Returns the value of the '<em><b>Timer Time Out</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer Time Out</em>' attribute.
	 * @see #setTimerTimeOut(int)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getTimerNode_TimerTimeOut()
	 * @model default="0"
	 * @generated
	 */
	int getTimerTimeOut();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.TimerNode#getTimerTimeOut <em>Timer Time Out</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer Time Out</em>' attribute.
	 * @see #getTimerTimeOut()
	 * @generated
	 */
	void setTimerTimeOut(int value);

	/**
	 * Returns the value of the '<em><b>Timer Time Out Unity</b></em>' attribute.
	 * The default value is <code>"Hours"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timer Time Out Unity</em>' attribute.
	 * @see #setTimerTimeOutUnity(String)
	 * @see org.isistan.flabot.coremodel.CoremodelPackage#getTimerNode_TimerTimeOutUnity()
	 * @model default="Hours"
	 * @generated
	 */
	String getTimerTimeOutUnity();

	/**
	 * Sets the value of the '{@link org.isistan.flabot.coremodel.TimerNode#getTimerTimeOutUnity <em>Timer Time Out Unity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timer Time Out Unity</em>' attribute.
	 * @see #getTimerTimeOutUnity()
	 * @generated
	 */
	void setTimerTimeOutUnity(String value);

} // TimerNode
