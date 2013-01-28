package org.isistan.flabot.executionstatemapping.model.semantic;

import org.eclipse.emf.common.util.EMap;

/**
 * @model
 */
public interface MappedTreeStructuredElement extends TreeStructuredElement
{	
	/**
     * @model keyType="String" valueType="TreeStructuredElement"
     * @deprecated 
     */
    @Deprecated
	EMap<String, TreeStructuredElement> getTreeStructuredElementMap();
    
    TreeStructuredElement getTreeStructuredElement(String name); 
    
    boolean isLoaded();
    
    public void setLoaded();
}
