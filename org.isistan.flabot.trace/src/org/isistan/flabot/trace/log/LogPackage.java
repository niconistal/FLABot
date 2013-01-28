/**
 * <copyright>
 * </copyright>
 *
 * $Id: LogPackage.java,v 1.1 2006/01/27 19:46:05 dacostae Exp $
 */
package org.isistan.flabot.trace.log;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.isistan.flabot.trace.log.LogFactory
 * @model kind="package"
 * @generated
 */
public interface LogPackage extends EPackage{
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "log";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///org/isistan/flabot/trace/log.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "org.isistan.flabot.trace.log";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LogPackage eINSTANCE = org.isistan.flabot.trace.log.impl.LogPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.log.impl.LogContextImpl <em>Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.log.impl.LogContextImpl
	 * @see org.isistan.flabot.trace.log.impl.LogPackageImpl#getLogContext()
	 * @generated
	 */
	int LOG_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CONTEXT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CONTEXT__TAGS = 1;

	/**
	 * The feature id for the '<em><b>Log</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CONTEXT__LOG = 2;

	/**
	 * The number of structural features of the the '<em>Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOG_CONTEXT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.log.impl.TagImpl <em>Tag</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.log.impl.TagImpl
	 * @see org.isistan.flabot.trace.log.impl.LogPackageImpl#getTag()
	 * @generated
	 */
	int TAG = 1;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__PROPERTIES = 0;

	/**
	 * The feature id for the '<em><b>Contained Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__CONTAINED_TAGS = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__PARENT = 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG__TAGS = 3;

	/**
	 * The number of structural features of the the '<em>Tag</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TAG_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.log.impl.TraceLogImpl <em>Trace Log</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.log.impl.TraceLogImpl
	 * @see org.isistan.flabot.trace.log.impl.LogPackageImpl#getTraceLog()
	 * @generated
	 */
	int TRACE_LOG = 2;

	/**
	 * The feature id for the '<em><b>Tags</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LOG__TAGS = 0;

	/**
	 * The feature id for the '<em><b>Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LOG__CONTEXTS = 1;

	/**
	 * The number of structural features of the the '<em>Trace Log</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACE_LOG_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link org.isistan.flabot.trace.log.impl.EStringToTagMapEntryImpl <em>EString To Tag Map Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.isistan.flabot.trace.log.impl.EStringToTagMapEntryImpl
	 * @see org.isistan.flabot.trace.log.impl.LogPackageImpl#getEStringToTagMapEntry()
	 * @generated
	 */
	int ESTRING_TO_TAG_MAP_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_TAG_MAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_TAG_MAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the the '<em>EString To Tag Map Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ESTRING_TO_TAG_MAP_ENTRY_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.log.LogContext <em>Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context</em>'.
	 * @see org.isistan.flabot.trace.log.LogContext
	 * @generated
	 */
	EClass getLogContext();

	/**
	 * Returns the meta object for the attribute '{@link org.isistan.flabot.trace.log.LogContext#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.isistan.flabot.trace.log.LogContext#getName()
	 * @see #getLogContext()
	 * @generated
	 */
	EAttribute getLogContext_Name();

	/**
	 * Returns the meta object for the reference list '{@link org.isistan.flabot.trace.log.LogContext#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Tags</em>'.
	 * @see org.isistan.flabot.trace.log.LogContext#getTags()
	 * @see #getLogContext()
	 * @generated
	 */
	EReference getLogContext_Tags();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.trace.log.LogContext#getLog <em>Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Log</em>'.
	 * @see org.isistan.flabot.trace.log.LogContext#getLog()
	 * @see #getLogContext()
	 * @generated
	 */
	EReference getLogContext_Log();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.log.Tag <em>Tag</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tag</em>'.
	 * @see org.isistan.flabot.trace.log.Tag
	 * @generated
	 */
	EClass getTag();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.trace.log.Tag#getProperties <em>Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Properties</em>'.
	 * @see org.isistan.flabot.trace.log.Tag#getProperties()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Properties();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.trace.log.Tag#getContainedTags <em>Contained Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contained Tags</em>'.
	 * @see org.isistan.flabot.trace.log.Tag#getContainedTags()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_ContainedTags();

	/**
	 * Returns the meta object for the container reference '{@link org.isistan.flabot.trace.log.Tag#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see org.isistan.flabot.trace.log.Tag#getParent()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Parent();

	/**
	 * Returns the meta object for the map '{@link org.isistan.flabot.trace.log.Tag#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>Tags</em>'.
	 * @see org.isistan.flabot.trace.log.Tag#getTags()
	 * @see #getTag()
	 * @generated
	 */
	EReference getTag_Tags();

	/**
	 * Returns the meta object for class '{@link org.isistan.flabot.trace.log.TraceLog <em>Trace Log</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trace Log</em>'.
	 * @see org.isistan.flabot.trace.log.TraceLog
	 * @generated
	 */
	EClass getTraceLog();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.trace.log.TraceLog#getTags <em>Tags</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tags</em>'.
	 * @see org.isistan.flabot.trace.log.TraceLog#getTags()
	 * @see #getTraceLog()
	 * @generated
	 */
	EReference getTraceLog_Tags();

	/**
	 * Returns the meta object for the containment reference list '{@link org.isistan.flabot.trace.log.TraceLog#getContexts <em>Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contexts</em>'.
	 * @see org.isistan.flabot.trace.log.TraceLog#getContexts()
	 * @see #getTraceLog()
	 * @generated
	 */
	EReference getTraceLog_Contexts();

	/**
	 * Returns the meta object for class '{@link java.util.Map.Entry <em>EString To Tag Map Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>EString To Tag Map Entry</em>'.
	 * @see java.util.Map.Entry
	 * @model keyType="java.lang.String"
	 *        valueType="org.isistan.flabot.trace.log.Tag"
	 * @generated
	 */
	EClass getEStringToTagMapEntry();

	/**
	 * Returns the meta object for the attribute '{@link java.util.Map.Entry <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToTagMapEntry()
	 * @generated
	 */
	EAttribute getEStringToTagMapEntry_Key();

	/**
	 * Returns the meta object for the reference '{@link java.util.Map.Entry <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Value</em>'.
	 * @see java.util.Map.Entry
	 * @see #getEStringToTagMapEntry()
	 * @generated
	 */
	EReference getEStringToTagMapEntry_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LogFactory getLogFactory();

} //LogPackage
