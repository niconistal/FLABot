/**
 * $Id: ComponentDropFactory.java,v 1.1 2005/12/21 00:29:37 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.multipage.dnd;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.requests.CreationFactory;
import org.isistan.flabot.coremodel.ComponentModel;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.InterfaceModel;
import org.isistan.flabot.coremodel.PortModel;
import org.isistan.flabot.edit.componenteditor.figures.ComponentFigure;
import org.isistan.flabot.edit.componenteditor.figures.InterfaceFigure;
import org.isistan.flabot.edit.componenteditor.figures.PortFigure;
import org.isistan.flabot.edit.editormodel.EditormodelFactory;
import org.isistan.flabot.edit.editormodel.FlabotFileModel;
import org.isistan.flabot.edit.editormodel.NodeVisualModel;
import org.isistan.flabot.edit.editormodel.Util;
import org.isistan.flabot.edit.editormodel.VisualModel;

/**
 * @author $Author: franco $
 *
 */
public class ComponentDropFactory implements CreationFactory {

	   private String id;
	   private FlabotFileModel file;

	   public ComponentDropFactory(FlabotFileModel file) {
		   this.file = file;
	   }
	   
	   public void setID(String id) {
		   this.id = id;
	   }
	   
	   public Object getNewObject() {	      
		   ComponentModel c = (ComponentModel)getSemanticModel();
		   if (c != null) {
			   NodeVisualModel visual = EditormodelFactory.eINSTANCE.createNodeVisualModel();		   			   	
			   visual.setSemanticModel(c);
			   addPorts(visual, c);
			   return visual;
		   }	
		   return null;
	   }

	   public Object getObjectType() {
	      return ComponentModel.class;
	   }
	   
	   protected EObject getSemanticModel() {
		   return getCorrectComponent();
	   }
	   
	   protected ComponentModel getCorrectComponent() {
			return getCorrectComponent(id, file);
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
	   
	   private void addPorts(VisualModel visual, ComponentModel component) {
		   visual.setSize(Util.getDimension(ComponentFigure.defaultsize));
		   
		   int height = 5;
		   for (Iterator iterPorts=component.getOwnedPorts().iterator(); iterPorts.hasNext();) {
			   PortModel port = (PortModel) iterPorts.next();
			   VisualModel v = EditormodelFactory.eINSTANCE.createVisualModel();
			   v.setSemanticModel(port);
			   addInterfaces(v, port, port.getProvideds());
			   addInterfaces(v, port, port.getRequireds());
			   int total = port.getProvideds().size() + port.getRequireds().size();
			   if (total == 0) total = 1;
			   v.setSize(Util.getDimension(PortFigure.defaultsize.width, (total * PortFigure.defaultsize.height)));
			   v.setLocation(Util.getPoint(0, height));
			   visual.getChildren().add(v);
			   
			   height += v.getSize().getHeight() + 5;
			   int dif = visual.getSize().getHeight() - height;
			   if (dif < 0)
				   visual.getSize().setHeight(visual.getSize().getHeight() - dif);
		   }		   		   
	   }
	   
	   private void addInterfaces(VisualModel visual, PortModel port, List interfaces) {		   
		   for (Iterator iterInterfaces=interfaces.iterator(); iterInterfaces.hasNext();) {
			   InterfaceModel inter = (InterfaceModel) iterInterfaces.next();
			   NodeVisualModel v = EditormodelFactory.eINSTANCE.createNodeVisualModel();
			   v.setSize(EditormodelFactory.eINSTANCE.createDimension(InterfaceFigure.defaultsize.width, InterfaceFigure.defaultsize.height));
			   v.setLocation(Util.getPoint(2, 2 + 25 *  visual.getChildren().size()));
			   v.setSemanticModel(inter);
			   visual.getChildren().add(v);
		   }	   
	   }	   
}