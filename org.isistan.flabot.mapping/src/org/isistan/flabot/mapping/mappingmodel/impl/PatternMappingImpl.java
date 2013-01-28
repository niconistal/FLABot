/**
 * <copyright>
 * </copyright>
 *
 * $Id: PatternMappingImpl.java,v 1.8 2006/04/06 20:52:49 dacostae Exp $
 */
package org.isistan.flabot.mapping.mappingmodel.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.isistan.flabot.javamodel.JBehavior;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.mapping.builder.MappingBuilder;
import org.isistan.flabot.mapping.builder.PatternMappingBuilder;
import org.isistan.flabot.mapping.mapper.PatternWorkspaceMapper;
import org.isistan.flabot.mapping.mapper.WorkspaceMapper;
import org.isistan.flabot.mapping.mappingmodel.MappingmodelPackage;
import org.isistan.flabot.mapping.mappingmodel.PatternMapping;
import org.isistan.flabot.util.TriState;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pattern Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.isistan.flabot.mapping.mappingmodel.impl.PatternMappingImpl#getPackagePattern <em>Package Pattern</em>}</li>
 *   <li>{@link org.isistan.flabot.mapping.mappingmodel.impl.PatternMappingImpl#getBehaviorPattern <em>Behavior Pattern</em>}</li>
 *   <li>{@link org.isistan.flabot.mapping.mappingmodel.impl.PatternMappingImpl#getClassPattern <em>Class Pattern</em>}</li>
 *   <li>{@link org.isistan.flabot.mapping.mappingmodel.impl.PatternMappingImpl#getJavaFilePattern <em>Java File Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PatternMappingImpl extends EObjectImpl implements PatternMapping {
	/**
	 * The default value of the '{@link #getPackagePattern() <em>Package Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackagePattern() <em>Package Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagePattern()
	 * @generated
	 * @ordered
	 */
	protected String packagePattern = PACKAGE_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getBehaviorPattern() <em>Behavior Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String BEHAVIOR_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBehaviorPattern() <em>Behavior Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBehaviorPattern()
	 * @generated
	 * @ordered
	 */
	protected String behaviorPattern = BEHAVIOR_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassPattern() <em>Class Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassPattern()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassPattern() <em>Class Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassPattern()
	 * @generated
	 * @ordered
	 */
	protected String classPattern = CLASS_PATTERN_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaFilePattern() <em>Java File Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaFilePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVA_FILE_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavaFilePattern() <em>Java File Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaFilePattern()
	 * @generated
	 * @ordered
	 */
	protected String javaFilePattern = JAVA_FILE_PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PatternMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MappingmodelPackage.eINSTANCE.getPatternMapping();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPackagePattern() {
		return packagePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPackagePattern(String newPackagePattern) {
		String oldPackagePattern = packagePattern;
		packagePattern = newPackagePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingmodelPackage.PATTERN_MAPPING__PACKAGE_PATTERN, oldPackagePattern, packagePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBehaviorPattern() {
		return behaviorPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBehaviorPattern(String newBehaviorPattern) {
		String oldBehaviorPattern = behaviorPattern;
		behaviorPattern = newBehaviorPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingmodelPackage.PATTERN_MAPPING__BEHAVIOR_PATTERN, oldBehaviorPattern, behaviorPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getClassPattern() {
		return classPattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClassPattern(String newClassPattern) {
		String oldClassPattern = classPattern;
		classPattern = newClassPattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingmodelPackage.PATTERN_MAPPING__CLASS_PATTERN, oldClassPattern, classPattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getJavaFilePattern() {
		return javaFilePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setJavaFilePattern(String newJavaFilePattern) {
		String oldJavaFilePattern = javaFilePattern;
		javaFilePattern = newJavaFilePattern;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MappingmodelPackage.PATTERN_MAPPING__JAVA_FILE_PATTERN, oldJavaFilePattern, javaFilePattern));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MappingmodelPackage.PATTERN_MAPPING__PACKAGE_PATTERN:
				return getPackagePattern();
			case MappingmodelPackage.PATTERN_MAPPING__BEHAVIOR_PATTERN:
				return getBehaviorPattern();
			case MappingmodelPackage.PATTERN_MAPPING__CLASS_PATTERN:
				return getClassPattern();
			case MappingmodelPackage.PATTERN_MAPPING__JAVA_FILE_PATTERN:
				return getJavaFilePattern();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MappingmodelPackage.PATTERN_MAPPING__PACKAGE_PATTERN:
				setPackagePattern((String)newValue);
				return;
			case MappingmodelPackage.PATTERN_MAPPING__BEHAVIOR_PATTERN:
				setBehaviorPattern((String)newValue);
				return;
			case MappingmodelPackage.PATTERN_MAPPING__CLASS_PATTERN:
				setClassPattern((String)newValue);
				return;
			case MappingmodelPackage.PATTERN_MAPPING__JAVA_FILE_PATTERN:
				setJavaFilePattern((String)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MappingmodelPackage.PATTERN_MAPPING__PACKAGE_PATTERN:
				setPackagePattern(PACKAGE_PATTERN_EDEFAULT);
				return;
			case MappingmodelPackage.PATTERN_MAPPING__BEHAVIOR_PATTERN:
				setBehaviorPattern(BEHAVIOR_PATTERN_EDEFAULT);
				return;
			case MappingmodelPackage.PATTERN_MAPPING__CLASS_PATTERN:
				setClassPattern(CLASS_PATTERN_EDEFAULT);
				return;
			case MappingmodelPackage.PATTERN_MAPPING__JAVA_FILE_PATTERN:
				setJavaFilePattern(JAVA_FILE_PATTERN_EDEFAULT);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case MappingmodelPackage.PATTERN_MAPPING__PACKAGE_PATTERN:
				return PACKAGE_PATTERN_EDEFAULT == null ? packagePattern != null : !PACKAGE_PATTERN_EDEFAULT.equals(packagePattern);
			case MappingmodelPackage.PATTERN_MAPPING__BEHAVIOR_PATTERN:
				return BEHAVIOR_PATTERN_EDEFAULT == null ? behaviorPattern != null : !BEHAVIOR_PATTERN_EDEFAULT.equals(behaviorPattern);
			case MappingmodelPackage.PATTERN_MAPPING__CLASS_PATTERN:
				return CLASS_PATTERN_EDEFAULT == null ? classPattern != null : !CLASS_PATTERN_EDEFAULT.equals(classPattern);
			case MappingmodelPackage.PATTERN_MAPPING__JAVA_FILE_PATTERN:
				return JAVA_FILE_PATTERN_EDEFAULT == null ? javaFilePattern != null : !JAVA_FILE_PATTERN_EDEFAULT.equals(javaFilePattern);
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (packagePattern: ");
		result.append(packagePattern);
		result.append(", behaviorPattern: ");
		result.append(behaviorPattern);
		result.append(", classPattern: ");
		result.append(classPattern);
		result.append(", javaFilePattern: ");
		result.append(javaFilePattern);
		result.append(')');
		return result.toString();
	}

	public boolean passes(JBehavior jBehavior) {
		Pattern pattern=getCompiledBehaviorPattern();
		if(pattern==null) {
			return false;
		} else {
			String behaviorDescriptor=jBehavior.getDescriptor();
			return pattern.matcher(behaviorDescriptor).matches();
		}
	}
	
	public TriState passes(JClass jClass) {
		Pattern pattern=getCompiledClassPattern();
		if(pattern==null) {
			return TriState.FALSE;
		} else {
			String className=jClass.getName();
			if(pattern.matcher(ALL_MARK+className).matches()) {
				return TriState.TRUE;
			} else if(pattern.matcher(className).matches()) {
				return TriState.UNDEFINED;
			} else {
				return TriState.FALSE;
			}
		}

	}

	public TriState passes(JPackage jPackage) {
		Pattern pattern=getCompiledPackagePattern();
		if(pattern==null) {
			return TriState.FALSE;
		} else {
			String packageName=jPackage.getName();
			if(pattern.matcher(ALL_MARK+packageName).matches()) {
				return TriState.TRUE;
			} else if(pattern.matcher(packageName).matches()) {
				return TriState.UNDEFINED;
			} else {
				return TriState.FALSE;
			}
		}
	}


	public TriState passes(JJavaFile jJavaFile) {
		Pattern pattern=getCompiledJavaFilePattern();
		if(pattern==null) {
			return TriState.TRUE;
		} else {
			String fileDescriptor=jJavaFile.getDescriptor();
			if(pattern.matcher(fileDescriptor).matches()) {
				return TriState.UNDEFINED;
			} else {
				return TriState.FALSE;
			}
		}
	}

	private Pattern compiledJavaFilePattern;
	private boolean compiledJavaFilePatternCalculated=false;
	private Pattern getCompiledJavaFilePattern() {
		if(!compiledJavaFilePatternCalculated) {
			String pattern=getJavaFilePattern();
			if(pattern==null || pattern.length()==0) {
				compiledJavaFilePattern=null;
			} else {
				compiledJavaFilePattern=Pattern.compile(pattern);
			}
			compiledJavaFilePatternCalculated=true;
		}
		return compiledJavaFilePattern;
	}
	
	private Pattern compiledPackagePattern;
	private boolean compiledPackagePatternCalculated=false;
	private Pattern getCompiledPackagePattern() {
		if(!compiledPackagePatternCalculated) {
			String pattern=getPackagePattern();
			if(pattern==null || pattern.length()==0) {
				compiledPackagePattern=null;
			} else {
				compiledPackagePattern=Pattern.compile(pattern);
			}
			compiledPackagePatternCalculated=true;
		}
		return compiledPackagePattern;
	}
	
	private Pattern compiledClassPattern;
	private boolean compiledClassPatternCalculated=false;
	private Pattern getCompiledClassPattern() {
		if(!compiledClassPatternCalculated) {
			String pattern=getClassPattern();
			if(pattern==null || pattern.length()==0) {
				compiledClassPattern=null;
			} else {
				compiledClassPattern=Pattern.compile(pattern);
			}
			compiledClassPatternCalculated=true;
		}
		return compiledClassPattern;
	}
	
	private Pattern compiledBehaviorPattern;
	private boolean compiledBehaviorPatternCalculated=false;
	private Pattern getCompiledBehaviorPattern() {
		if(!compiledBehaviorPatternCalculated) {
			String pattern=getBehaviorPattern();
			if(pattern==null || pattern.length()==0) {
				compiledBehaviorPattern=null;
			} else {
				compiledBehaviorPattern=Pattern.compile(pattern);
			}
			compiledBehaviorPatternCalculated=true;
		}
		return compiledBehaviorPattern;
	}
	
	public WorkspaceMapper getWorkspaceMapper() {
		return PatternWorkspaceMapper.getInstance();
	}
	
	public MappingBuilder getBuilder() {
		return PatternMappingBuilder.getInstance();
	}

} //PatternMappingImpl
