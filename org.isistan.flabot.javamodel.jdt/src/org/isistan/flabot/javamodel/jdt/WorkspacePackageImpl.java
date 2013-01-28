package org.isistan.flabot.javamodel.jdt;
 
import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JAnnotation;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.JClass;
import org.isistan.flabot.javamodel.JObject;
import org.isistan.flabot.javamodel.JPackage;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.NotSupportedFeatureException;
import org.isistan.flabot.javamodel.Util;
import org.isistan.flabot.javamodel.jdt.workspace.JJavaFile;
import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;

/**
 * Represents a package (as IPackage)
 * @author $Author: dacostae $
 *
 */
public class WorkspacePackageImpl extends ObjectImpl implements JWorkspacePackage, JNotificableElement {
	private static final int PACKAGE_CHANGE_FLAG=0;
	private static final int PACKAGE_CHILDREN_CHANGE_FLAG=1;
	private static final int PROJECT_CHILDREN_CHANGE_FLAG=2;
	
	private IPackageFragment jdtWorkspacePackage;
	
	IPackageFragment getJDTWorkspacePackage() {
		return jdtWorkspacePackage;
	}
	
	static IPackageFragment getJDTWorkspacePackage(JPackage jPackage) {
		if(jPackage instanceof WorkspacePackageImpl) {
			return ((WorkspacePackageImpl)jPackage).getJDTWorkspacePackage();
		} else {
			throw new MixedImplementationsException(jPackage);
		} 
	}
	
	WorkspacePackageImpl(IPackageFragment jdtWorkspacePackage) {
		super(jdtWorkspacePackage);
		this.jdtWorkspacePackage=jdtWorkspacePackage;
		JavaModelListener.getInstance().add(this, PACKAGE_CHANGE_FLAG, jdtWorkspacePackage,
				IJavaElementDelta.CHANGED);
		JavaModelListener.getInstance().add(this, PACKAGE_CHILDREN_CHANGE_FLAG, jdtWorkspacePackage,
				IJavaElementDelta.F_CHILDREN);
		JavaModelListener.getInstance().add(this, PROJECT_CHILDREN_CHANGE_FLAG,
				jdtWorkspacePackage.getAncestor(IJavaElement.JAVA_PROJECT),
				IJavaElementDelta.F_CHILDREN);
	}
	
	public void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event) {
		if(flag==PACKAGE_CHANGE_FLAG) {
			if(parentPackage!=null && isInRoot()) {
				parentPackageCalculated=false;
			}
		} else if(flag==PACKAGE_CHILDREN_CHANGE_FLAG) {
			javaFiles=null;
		} else if(flag==PROJECT_CHILDREN_CHANGE_FLAG) {
			packages=null;
		}
	}
	
	public JPackageRoot getPackageRoot() {
		return JDTFactory.getInstance().buildPackageRoot(getJDTPackageRoot());
	}
	
	private IPackageFragmentRoot getJDTPackageRoot() {
		return (IPackageFragmentRoot)jdtWorkspacePackage.getParent();
	}
	
	
	private JWorkspacePackage parentPackage=null;
	private boolean parentPackageCalculated=false;
	public JWorkspacePackage getParentPackage() {
		if(!parentPackageCalculated) {
			if(!isInRoot()) {
				String name=jdtWorkspacePackage.getElementName();
				int dotIndex=name.lastIndexOf(Util.PACKAGE_DELIMITER);
				String parentPackageName=name.substring(0, dotIndex);
				IPackageFragment jdtParentPackage = getJDTPackageRoot().getPackageFragment(parentPackageName);
				parentPackage=JDTFactory.getInstance().buildPackage(jdtParentPackage);
			}
			parentPackageCalculated=true;
		}
		return parentPackage;
	}
	
	private JArray<? extends JWorkspacePackage> packages=null;
	public JArray<? extends JWorkspacePackage> getPackages() {
		if(packages==null) {
			try {
				if(isDefault()) {
					packages=JDTFactory.getInstance().buildArray(new IPackageFragment[0],
							JDTFactory.getInstance().getPackageBuilder());
				} else {
					IJavaElement[] children = getJDTPackageRoot().getChildren();
					List<IPackageFragment> packagesList=new LinkedList<IPackageFragment>();
					String packagePrefix=getName() + Util.PACKAGE_DELIMITER; 
					for (IJavaElement child : children) {
						if(JavaModelJDTUtil.elementExists(child) &&
								child instanceof IPackageFragment &&
								!child.getElementName().startsWith(packagePrefix) &&
								child.getElementName().lastIndexOf(Util.PACKAGE_DELIMITER)==packagePrefix.length()) {
							packagesList.add((IPackageFragment)child);
						}
					}
					IPackageFragment[] packagesArray=packagesList.toArray(new IPackageFragment[packagesList.size()]);
					packages=JDTFactory.getInstance().buildArray(packagesArray,
							JDTFactory.getInstance().getPackageBuilder());
				}
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return packages;
	}
	
	private JArray<? extends JJavaFile> javaFiles=null;
	public JArray<? extends JJavaFile> getJavaFiles() {
		if(javaFiles==null) {
			try {
				IJavaElement[] children = jdtWorkspacePackage.getChildren();
				List<IJavaElement> javaFilesList=new LinkedList<IJavaElement>();
				for (IJavaElement child : children) {
					if(JavaModelJDTUtil.elementExists(child) &&
							(child instanceof IClassFile ||
							child instanceof ICompilationUnit)) {
						javaFilesList.add(child);
					}
				}
				IJavaElement[] javaFilesArray=javaFilesList.toArray(new IJavaElement[javaFilesList.size()]);
				javaFiles=JDTFactory.getInstance().buildArray(javaFilesArray,
						JDTFactory.getInstance().getJavaFileBuilder());
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return javaFiles;
	}

	public String getName() {
		return jdtWorkspacePackage.getElementName();
	}
	
	public String getSimpleName() {
		if(isInRoot()) {
			return getName();
		} else {
			String name=getName();
			int lastDot=name.lastIndexOf(Util.PACKAGE_DELIMITER);
			return name.substring(lastDot+1, name.length());
		}
	}

	public String getSpecificationTitle() {
		throw new NotSupportedFeatureException();
	}

	public String getSpecificationVersion() {
		throw new NotSupportedFeatureException();
	}

	public String getSpecificationVendor() {
		throw new NotSupportedFeatureException();
	}

	public String getImplementationTitle() {
		throw new NotSupportedFeatureException();
	}

	public String getImplementationVersion() {
		throw new NotSupportedFeatureException();
	}

	public String getImplementationVendor() {
		throw new NotSupportedFeatureException();
	}

	public boolean isSealed() {
		throw new NotSupportedFeatureException();
	}

	public boolean isSealed(JObject url) {
		throw new NotSupportedFeatureException();
	}

	public boolean isCompatibleWith(String desired) throws NumberFormatException {
		throw new NotSupportedFeatureException();
	}

	public boolean isAnnotationPresent(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JAnnotation getAnnotation(JClass annotationType) {
		throw new NotSupportedFeatureException();
	}

	public JArray<JAnnotation> getAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public JArray<JAnnotation> getDeclaredAnnotations() {
		throw new NotSupportedFeatureException();
	}

	public boolean isDefault() {
		return jdtWorkspacePackage.isDefaultPackage();
	}
	

	public boolean isInRoot() {
		return getName().indexOf(Util.PACKAGE_DELIMITER)==-1;
	}
	
	public String getDescriptor() {
		return Util.getPackageDescriptor(this);
	}
}
