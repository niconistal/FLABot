/**

import org.eclipse.jdt.core.IPackageFragmentRoot;

	public boolean accepts(Object object) {
		return object instanceof IPackageFragmentRoot;
	}

	public JPackageRoot build(Object object) {
		return new PackageRootImpl((IPackageFragmentRoot) object);
	}

}