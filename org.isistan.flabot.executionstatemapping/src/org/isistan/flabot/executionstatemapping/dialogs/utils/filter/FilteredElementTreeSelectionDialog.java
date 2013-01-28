package org.isistan.flabot.executionstatemapping.dialogs.utils.filter;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.isistan.flabot.executionstatemapping.messages.Messages;

public class FilteredElementTreeSelectionDialog extends ElementTreeSelectionDialog implements UpdatableFilteredView {
	
	private CCombo combo;
	
	protected ViewFilterProvider[] viewFilterProviders;
	
	private int selectedIndex;
	
	public FilteredElementTreeSelectionDialog(Shell parent,
            ILabelProvider labelProvider, ITreeContentProvider contentProvider) {
        super(parent, labelProvider, contentProvider);

    }
	
	public void setFilterItems(ViewFilterProvider[] viewFilterProviders)
	{
		this.viewFilterProviders = viewFilterProviders;
	}
			
	@Override
    protected Control createDialogArea(Composite parent) {
       	Composite composite = (Composite) super.createDialogArea(parent);
    	createComboFilter(composite);    	
    	return composite;
    }
    
    protected void createComboFilter(Composite composite) {
		if (viewFilterProviders != null && viewFilterProviders.length > 1)
		{    	
			Composite compositeFilter = new Composite(composite, SWT.NONE);
			compositeFilter.setLayout(new GridLayout(2, false));
			compositeFilter.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
			
	    	Label label = new Label(compositeFilter, SWT.NONE);
			label.setText(Messages.getString("org.isistan.flabot.executionmapping.dialogs.utils.filter.FilteredElementTreeSelectionDialog.filterView")); //$NON-NLS-1$
			label.setFont(composite.getFont());    	
			
	    	combo = new CCombo(compositeFilter,  SWT.BORDER);
	    	combo.setEditable(false);	    	
	    	combo.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
	    	for(int i=0; i<viewFilterProviders.length; i++)
	    	{
	    		combo.setData(String.valueOf(combo.getItemCount()), viewFilterProviders[i]);
	    		combo.add(viewFilterProviders[i].getTextName());    		
	    	}	    	
	    	
	    	combo.addSelectionListener( new SelectionAdapter() 
	    	{
	    		@Override
				public void widgetSelected(SelectionEvent e) 
	    		{
	    			updateSelectedIndex();		
	    		}
	    	});
	    	
	    	combo.select(0);	    	
		}
		updateSelectedIndex();
	}
    
    private void updateSelectedIndex()
    {
    	if (combo != null)
    	{
    		selectedIndex = combo.getSelectionIndex();
    		if (selectedIndex >= 0 && selectedIndex < viewFilterProviders.length)
    		{
    			viewFilterProviders[selectedIndex].filterChanged(FilteredElementTreeSelectionDialog.this);
    		}
    	}
    	else if (viewFilterProviders != null && viewFilterProviders.length == 1)
    	{
    		viewFilterProviders[selectedIndex].filterChanged(FilteredElementTreeSelectionDialog.this);
    	}
    }
    
    public void updateFilter(ViewerFilter viewFilter)
    {
    	TreeViewer treeViewer = getTreeViewer();
    	ViewerFilter[] filters = treeViewer.getFilters();
    	    	
    	if (filters.length > 0 && filters[0] == viewFilter) return;
    	
    	treeViewer.collapseAll();
    	if (viewFilter != null)
    	{
    		treeViewer.setFilters(new ViewerFilter[] {viewFilter});
    	}
    	else
    	{
    		treeViewer.setFilters(new ViewerFilter[] {});
    	}
    	treeViewer.refresh();
    }
    
    public void updateContent(ViewerComparator viewerComparator, ILabelProvider labelProvider, ITreeContentProvider contentProvider, Object input)
    {
    	TreeViewer treeViewer = getTreeViewer();
    	
    	this.setResult(null);
    	treeViewer.getTree().clearAll(false);
    	try
    	{
    		treeViewer.setInput(null);
    	}
    	catch(Exception e)
    	{
    		
    	}
    	if (viewerComparator != null)
    	{
    		treeViewer.setComparator(viewerComparator);
    	}
    	
    	treeViewer.setFilters(new ViewerFilter[] {});
    	treeViewer.setLabelProvider(labelProvider);
    	treeViewer.setContentProvider(contentProvider);
    	treeViewer.setInput(input);
    	treeViewer.refresh();
    }
    
    @Override
    public Object[] getResult() {
    	Object[] result = super.getResult();    	
    	if (viewFilterProviders !=null && selectedIndex >= 0 && selectedIndex < viewFilterProviders.length)
		{
    		result = viewFilterProviders[selectedIndex].validateResult(result);
		} 	
    	return result;
	}
}
