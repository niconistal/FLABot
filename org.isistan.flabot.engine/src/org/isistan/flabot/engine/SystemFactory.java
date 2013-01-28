/**
 * $Id: SystemFactory.java,v 1.21 2006/03/30 02:42:26 apersson Exp $
 */

package org.isistan.flabot.engine;

import java.io.IOException;
import java.util.HashMap;

import javax.swing.JOptionPane;

import org.eclipse.ui.internal.Workbench;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.engine.executionstate.Diagnostic;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.executionmodel.EvaluationStep;
import org.isistan.flabot.executionmodel.ExecutionmodelFactory;
import org.isistan.flabot.executionmodel.impl.ExecutionContextImpl;

import JavaLog.PlException;

/**
 * @author $Author: apersson $
 */

public class SystemFactory {

  //private static SystemFactory instance = new SystemFactory();
  private static String CLAVE_VARIABLE="POP_";
  private JavaLogEngine javaLogEngine;
  private RuntimeManager runtimeManager;

  /**
   * Elimina las variables no congeladas dentro de un String
   * @param origen String
   * @return String
   */
  public String preprocessVariable(String origen){
    String salida = "";
    for( int i = 0; i < origen.length(); i++) {
        if ( ( (origen.charAt(i)==' ') ||
               (origen.charAt(i)=='(') ||
               (origen.charAt(i)==',') ||
               (origen.charAt(i)=='[') ) && ((i+1 < origen.length())&&(origen.charAt(i+1)=='_')) ) {
         salida = salida + origen.charAt(i) + CLAVE_VARIABLE;
        }
        else{
           salida = salida + origen.charAt(i);
           }
     }
     return salida;
  }

  public String preprocessGoal(String origen) throws PlException, IOException{
	  javaLogEngine.parseStruct(this.preprocessVariable(origen));
	  return "";
  }

  private Loader loader;

  public SystemFactory(Loader loader, JavaLogEngine javaLogEngine) {
	  this.loader = loader;
	  this.javaLogEngine = javaLogEngine;
  }
  
  public void initJavaLogEngine(JavaLogEngine javaLogEngine) { 
	  this.javaLogEngine = javaLogEngine;
  }

  public void setRuntimeManager(RuntimeManager runtimeManager) {
	  this.runtimeManager = runtimeManager;
  }
  
   /**
   * Método que retorna una instancia del manager de DOMs de manera de abstraer
   * las posibles diferentes implementaciones a utilizar
   * @return el manager de DOM's que corresponde
   */
   public String getExecutionInfo(String preResponsibilityId, String responsibilityId,String instanceId, String preInstanceId,String eventId, String condition, String currentFamily){
	final HashMap context = new HashMap();
	
	String currentFamilyID = ExecutionContextImpl.CURRENT_FAMILY_EDEFAULT;
	if (currentFamily.trim().length() > 0 && !currentFamily.trim().equals("null"))
		currentFamilyID = "'"+currentFamily+"'";
    
	final SimplePathNode preResponsibilityNode = (SimplePathNode) loader.getResponsibilitiesNodeByID().get("'"+preResponsibilityId+"'");
	if (loader.getEventsByID().containsKey("'"+eventId+"'"))
		context.put(InterfaceContextInfo.EVENT, ((ConditionEvent)loader.getEventsByID().get("'"+eventId+"'")).getName());
	else
		context.put(InterfaceContextInfo.EVENT,"none");
	context.put(InterfaceContextInfo.PRE_RESPONSIBILITY,preResponsibilityId);
	context.put(InterfaceContextInfo.PRE_RESPONSIBILITY_NODE,loader.getResponsibilitiesNodeByID().get("'"+preResponsibilityId+"'"));
	
	ComponentRole instanceRole = (ComponentRole)loader.getComponentsByID().get("'"+instanceId.toString()+"'");
	context.put(InterfaceContextInfo.INSTANCE, instanceRole);
	
	ComponentRole preInstanceRole = (ComponentRole)loader.getComponentsByID().get("'"+preInstanceId.toString()+"'");
	context.put(InterfaceContextInfo.PRE_INSTANCE, preInstanceRole);
	
	context.put(InterfaceContextInfo.CONDITION,condition);

	final ResponsibilityNode responsibilityNode = (ResponsibilityNode)loader.getResponsibilitiesNodeByID().get("'"+responsibilityId+"'");
	
	//Creates the evaluation step
	EvaluationStep evaluationStep = ExecutionmodelFactory.eINSTANCE.createEvaluationStep();
	evaluationStep.setSource(preResponsibilityNode);
	evaluationStep.setTarget(responsibilityNode);
	evaluationStep.setCondition(condition);
	evaluationStep.setCurrentFamily(currentFamilyID);
	
	//Notifies that the evaluation has started.
	runtimeManager.getCurrentExecutionInfo().startEvaluatingNode(evaluationStep);
	
	//Evaluation
	GetStateRunnable state= new GetStateRunnable(responsibilityNode,context);
	Workbench.getInstance().getDisplay().syncExec(state);
	loader.getDiagnosticByResponsibility().put("'"+preResponsibilityId+"'",state.getDiagnostic());
	
	//Notifies that the evaluation has ended.
	runtimeManager.getCurrentExecutionInfo().finishEvaluatingNode(evaluationStep);	
	
	return state.getState();
  }
   

   public String assertRule (String rule) throws IOException, PlException{
	   javaLogEngine.assertRule(rule);
	   return "_";
   }
   
   public String retractRule (String rule) throws IOException, PlException{
	   javaLogEngine.retractRule(rule);
	   return "_";
   }

  /**
   * Crea una ventana de diálogo informado la información de log expresada
   * @param <any> String
   * @return String
   */
  public String showLogInfo(String info){
    JOptionPane.showConfirmDialog(null,info,"Log information",JOptionPane.WARNING_MESSAGE);
    System.out.println("--------------------------------------------------------------------------------------------" );
    System.out.println("----------------------------------------Information-----------------------------------------" );
    System.out.println("--------------------------------------------------------------------------------------------" );
    System.out.println(info);
    System.out.println("--------------------------------------------------------------------------------------------" );
    System.out.println("--------------------------------------------------------------------------------------------" );
    System.out.println("--------------------------------------------------------------------------------------------" );
    return info;

  }
  
  private class GetStateRunnable implements Runnable {
		

		private ResponsibilityNode responsibilityNode;
		private HashMap context;
		private Diagnostic diagnostic;

		public GetStateRunnable(ResponsibilityNode node, HashMap context) {
			this.responsibilityNode = node;
			this.context = context;
		}

		public void run() {
			diagnostic = ExecutionStateManager.getState(responsibilityNode,context, loader);
		}
		
		public String getState(){
			return diagnostic.getState().getName();
		}
		
		public Diagnostic getDiagnostic(){
			return diagnostic;
		}
	}


}
