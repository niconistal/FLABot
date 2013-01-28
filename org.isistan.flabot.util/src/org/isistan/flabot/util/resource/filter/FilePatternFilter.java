package org.isistan.flabot.util.resource.filter;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Display;

/**
 * A Filter that shows files matching a given pattern
 * @author da Costa Cambio
 *
 */
public class FilePatternFilter extends ViewerFilter {
	
	/**
	 * Collection of archives and containers to display
	 */
	private Set<Object> files;
	
	/**
	 * Collection of already existing archives
	 */
	private Set<Object> exclude;

	private Display display;

	private String pattern;

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		return files.contains(element) && !exclude.contains(element);
	}

	/**
	 * Constructs a new filter to display files and their containers,
	 * excluding the resources in the given array.
	 * 
	 * @param objects resources to exclude
	 */
	public FilePatternFilter(Display display, String pattern, Object[] exclude) {
		this.exclude = new HashSet<Object>();
		for (Object object : exclude) {
			this.exclude.add(object);
		}
		this.display=display;
		this.pattern=pattern;
		init();
	}
	
	/**
	 * Constructs a new filter to display files and their containers.
	 * 
	 * @param objects resources to exclude
	 */
	public FilePatternFilter(Display display, String pattern) {
		this(display, pattern, new Object[0]);
	}
	
	/**
	 * Search for all archives in the workspace.
	 */
	private void init() {
		BusyIndicator.showWhile(display, new Runnable() {
			public void run() {
				files = new HashSet<Object>();
				traverse(ResourcesPlugin.getWorkspace().getRoot(), files);
			}
		});
	}

	/**
	 * Traverse the given container, adding archives to the given set.
	 * Returns whether any files were added
	 * 
	 * @param root
	 */
	private boolean traverse(IContainer container, Set<Object> set) {
		boolean added = false;
		try {	
			IResource[] resources = container.members();
			for (int i = 0; i < resources.length; i++) {
				IResource resource = resources[i];
				if (resource instanceof IFile) {
					IFile file = (IFile)resource;
					String name = file.getName();
					if (name.matches(pattern)) {
						set.add(file);
						added = true;
					}
				} else if (resource instanceof IContainer) {
					if (traverse((IContainer)resource, set)) {
						set.add(resource);	
						added = true;
					}
				}
			}
		} catch (CoreException e) {
		}
		return added;
	}
}