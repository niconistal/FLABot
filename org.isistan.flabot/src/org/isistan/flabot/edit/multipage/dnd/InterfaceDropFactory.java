/**
 * $Id: InterfaceDropFactory.java,v 1.2 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.Iterator;
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.editparts.ProvidedInterfaceEditPart;
import org.isistan.flabot.edit.componenteditor.editparts.RequiredInterfaceEditPart;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * @author $Author: franco $
 *
 */
public class InterfaceDropFactory implements CreationFactory {

	   private String componentID = ""; //$NON-NLS-1$
	   private String portID = ""; //$NON-NLS-1$
	   private String interfaceID = ""; //$NON-NLS-1$
	   private FlabotFileModel file;

	   public InterfaceDropFactory(FlabotFileModel file) {
		   this.file = file;
	   }
	   
	   public void setID(String id) {
		   if (id != null) {
			   StringTokenizer st = new StringTokenizer(id, " ");  //$NON-NLS-1$
			   if (st.countTokens() == 3) {
				   componentID = st.nextToken();		   
				   portID = st.nextToken();
				   interfaceID = st.nextToken();
			   } else {
				   componentID = "";		    //$NON-NLS-1$
				   portID = ""; //$NON-NLS-1$
				   interfaceID = ""; //$NON-NLS-1$
			   }
		   }
	   }	  
	   
	   public Object getNewObject() {	      
		   	VisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();		   			   	
		   	InterfaceModel model =(InterfaceModel)getSemanticModel();
		   	visual.setSemanticModel(model);
			return visual;
	   }
	   
	   public Object getObjectType() {
		   InterfaceModel inter = (InterfaceModel) ((VisualModel) getNewObject()).getSemanticModel();
		   if (inter.getPort().getProvideds().contains(inter))
			   return ProvidedInterfaceEditPart.PROVIDED_INTERFACE;
		   else
			   return RequiredInterfaceEditPart.REQUIRED_INTERFACE;
	   }
	   
	   public String getPortID() {
		   return portID;
	   }
	   
	   protected EObject getSemanticModel() {
		   return getCorrectInterface();
	   }
	   
	   protected InterfaceModel getCorrectInterface() {
		   ComponentModel component = getCorrectComponent(componentID, file);  		   
		   PortModel port = getCorrectPort(portID, component);;    
		   return  getCorrectInterface(interfaceID, port);
	   }
	   

	   private InterfaceModel getCorrectInterface(String id, PortModel port) {
		   for (Iterator iter=port.getProvideds().iterator(); iter.hasNext(); ) {
			   InterfaceModel inter = (InterfaceModel) iter.next();
			   if (inter.getID().equals(id))
				   return inter;
		   }
		   for (Iterator iter=port.getRequireds().iterator(); iter.hasNext(); ) {
			   InterfaceModel inter = (InterfaceModel) iter.next();
			   if (inter.getID().equals(id))
				   return inter;
		   }
		   return null;
	   }
	   
	   	   
	   private PortModel getCorrectPort(String id, ComponentModel component) {
		   for (Iterator iter=component.getOwnedPorts().iterator(); iter.hasNext(); ) {
			   PortModel port = (PortModel) iter.next();
			   if (port.getID().equals(id))
				   return port;
		   }
		   return null;
	   }
	   
	   private ComponentModel getCorrectComponent(String id, FlabotFileModel file) {
		   ComponentModel component = getCorrectComponent(id, file.getCoreModel());
		   for (Iterator iter=file.getAllImportedFiles().iterator(); component == null && iter.hasNext(); ) {
			   FlabotFileModel f = (FlabotFileModel) iter.next();
			   component = getCorrectComponent(id, f.getCoreModel());
		   }
		   return component;
	   }
		
	   private ComponentModel getCorrectComponent(String id, CoreModel coreModel) {
		   for (Iterator iter = coreModel.getComponents().iterator(); iter.hasNext(); ) {
			   ComponentModel component = (ComponentModel) iter.next();
			   if (component.getID().equals(id))
				   return component;
		   }
		   return null;
	   }
}