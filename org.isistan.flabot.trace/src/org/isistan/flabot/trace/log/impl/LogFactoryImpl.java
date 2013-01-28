/**
 * <copyright>
 * </copyright>
 *
 * $Id: LogFactoryImpl.java,v 1.3 2006/02/24 00:45:58 dacostae Exp $
 */
package org.isistan.flabot.trace.log.impl;

import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.isistan.flabot.trace.log.*;

import org.isistan.flabot.trace.log.LogContext;
import org.isistan.flabot.trace.log.LogFactory;
import org.isistan.flabot.trace.log.LogPackage;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.TraceLog;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LogFactoryImpl extends EFactoryImpl implements LogFactory {
	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LogPackage.LOG_CONTEXT: return createLogContext();
			case LogPackage.TAG: return createTag();
			case LogPackage.TRACE_LOG: return createTraceLog();
			case LogPackage.ESTRING_TO_TAG_MAP_ENTRY: return (EObject)createEStringToTagMapEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogContext createLogContext() {
		LogContextImpl logContext = new LogContextImpl();
		return logContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Tag createTag() {
		TagImpl tag = new TagImpl();
		return tag;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceLog createTraceLog() {
		TraceLogImpl traceLog = new TraceLogImpl();
		return traceLog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry createEStringToTagMapEntry() {
		EStringToTagMapEntryImpl eStringToTagMapEntry = new EStringToTagMapEntryImpl();
		return eStringToTagMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogPackage getLogPackage() {
		return (LogPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LogPackage getPackage() {
		return LogPackage.eINSTANCE;
	}

} //LogFactoryImpl
