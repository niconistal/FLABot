/**
 * $Id: PortDropFactory.java,v 1.4 2006/03/21 01:51:57 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.figures.InterfaceFigure;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * @author $Author: franco $
 *
 */
public class PortDropFactory implements CreationFactory {

	   private String componentID = ""; //$NON-NLS-1$
	   private String portID = ""; //$NON-NLS-1$
	   private FlabotFileModel file;

	   public PortDropFactory(FlabotFileModel file) {
		   this.file = file;
	   }
	   
	   public void setID(String id) {
		   if (id != null) {
			   StringTokenizer st = new StringTokenizer(id, " ");  //$NON-NLS-1$
			   if (st.countTokens() == 2) {
				   componentID = st.nextToken();		   
				   portID = st.nextToken();
			   } else {
				   componentID = "";		    //$NON-NLS-1$
				   portID = ""; //$NON-NLS-1$
			   }
				   
		   }
	   }	  
	   
	   public Object getNewObject() {	      
		   	VisualModel visual = EditormodelFactory.eINSTANCE.createVisualModel();		   			   	
		   	PortModel model =(PortModel)getSemanticModel();
		   	visual.setSemanticModel(model);
		   	addInterfaces(visual, model, model.getRequireds());
		   	addInterfaces(visual, model, model.getProvideds());
			return visual;
	   }
	   
	   public Object getObjectType() {
		   return PortModel.class;
	   }	   
	   
	   public String getComponentID() {
		   return componentID;
	   }
	   
	   protected EObject getSemanticModel() {
		   return getCorrectPort();
	   }
	   
	   protected void addInterfaces(VisualModel visual, PortModel port, List interfaces) {		   
		   for (Iterator iterInterfaces=interfaces.iterator(); iterInterfaces.hasNext();) {
			   InterfaceModel inter = (InterfaceModel) iterInterfaces.next();
			   NodeVisualModel v = EditormodelFactory.eINSTANCE.createNodeVisualModel();
			   v.setSize(EditormodelFactory.eINSTANCE.createDimension(InterfaceFigure.defaultsize.width, InterfaceFigure.defaultsize.height));
			   v.setLocation(Util.getPoint(2, 2 + 25 *  visual.getChildren().size()));
			   v.setSemanticModel(inter);
			   visual.getChildren().add(v);
		   }	   
	   }
	   
	   protected PortModel getCorrectPort() {
		   ComponentModel component = getCorrectComponent(componentID, file);    
		   return getCorrectPort(portID, component);
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