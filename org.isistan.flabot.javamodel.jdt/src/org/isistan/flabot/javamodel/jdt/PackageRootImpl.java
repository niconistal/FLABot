package org.isistan.flabot.javamodel.jdt;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.isistan.flabot.javamodel.InternalModelException;
import org.isistan.flabot.javamodel.JArray;
import org.isistan.flabot.javamodel.MixedImplementationsException;
import org.isistan.flabot.javamodel.Util;
import org.isistan.flabot.javamodel.jdt.workspace.JPackageRoot;
import org.isistan.flabot.javamodel.jdt.workspace.JProject;
import org.isistan.flabot.javamodel.jdt.workspace.JWorkspacePackage;

/**
 * Represents a package root (as IPackageFragmentRoot)
 * @author $Author: dacostae $
 *
 */
public class PackageRootImpl extends ObjectImpl implements JPackageRoot, JNotificableElement {
	private static final int PACKAGE_ROOT_CHILDREN_CHANGE_FLAG=0;

	private IPackageFragmentRoot jdtPackageRoot;
	
	IPackageFragmentRoot getJDTPackageRoot() {
		return jdtPackageRoot;
	}
	
	static IPackageFragmentRoot getJDTPackageRoot(JPackageRoot JPackageRoot) {
		if(JPackageRoot instanceof PackageRootImpl) {
			return ((PackageRootImpl)JPackageRoot).getJDTPackageRoot();
		} else {
			throw new MixedImplementationsException(JPackageRoot);
		} 
	}
	
	PackageRootImpl(IPackageFragmentRoot jdtPackageRoot) {
		super(jdtPackageRoot);
		this.jdtPackageRoot=jdtPackageRoot;
		JavaModelListener.getInstance().add(this, PACKAGE_ROOT_CHILDREN_CHANGE_FLAG, jdtPackageRoot,
				IJavaElementDelta.F_CHILDREN);
	}
	

	public void changed(int flag, IJavaElement javaElement, int eventFlags, ElementChangedEvent event) {
		if(flag==PACKAGE_ROOT_CHILDREN_CHANGE_FLAG) {
			allPackages=null;
			packages=null;
		}
	}


	public JProject getProject() {
		return JDTFactory.getInstance().buildProject(jdtPackageRoot.getParent());
	}
	
	private JArray<? extends JWorkspacePackage> allPackages=null;
	public JArray<? extends JWorkspacePackage> getAllPackages() {
		if(allPackages==null) {
			try {
				IJavaElement[] children = jdtPackageRoot.getChildren();
				List<IPackageFragment> packagesList=new LinkedList<IPackageFragment>();
				for (IJavaElement child : children) {
					if(JavaModelJDTUtil.elementExists(child)
							&& child instanceof IPackageFragment) {
						packagesList.add((IPackageFragment)child);
					}
				}
				IPackageFragment[] packagesArray=packagesList.toArray(new IPackageFragment[packagesList.size()]);
				allPackages=JDTFactory.getInstance().buildArray(packagesArray,
						JDTFactory.getInstance().getPackageBuilder());
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return allPackages;
	}
	
	public JWorkspacePackage getPackage(String packageName) {
		return JDTFactory.getInstance().buildPackage(jdtPackageRoot.getPackageFragment(packageName));
	}
	
	private JArray<? extends JWorkspacePackage> packages=null;
	public JArray<? extends JWorkspacePackage> getPackages() {
		if(packages==null) {
			try {
				IJavaElement[] children = jdtPackageRoot.getChildren();
				List<IPackageFragment> packagesList=new LinkedList<IPackageFragment>();
				for (IJavaElement child : children) {
					if(JavaModelJDTUtil.elementExists(child)
							&& child instanceof IPackageFragment &&
							!child.getElementName().contains(
									String.valueOf(Util.PACKAGE_DELIMITER))) {
						packagesList.add((IPackageFragment)child);
					}
				}
				IPackageFragment[] packagesArray=packagesList.toArray(new IPackageFragment[packagesList.size()]);
				packages=JDTFactory.getInstance().buildArray(packagesArray,
						JDTFactory.getInstance().getPackageBuilder());
			} catch (JavaModelException e) {
				throw new InternalModelException(e);
			}
		}
		return packages;
	}
	
	public String getName() {
		return jdtPackageRoot.getElementName();
	}
	
	public String getPath() {
		return jdtPackageRoot.getPath().toPortableString();
	}

}
