/**
 * $Id: Loader.java,v 1.19 2006/04/13 01:56:53 apersson Exp $
 */
package org.isistan.flabot.engine;

import java.io.IOException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.eclipse.emf.common.util.EList;
import org.isistan.flabot.FlabotPlugin;
import org.isistan.flabot.coremodel.ComponentRole;
import org.isistan.flabot.coremodel.Condition;
import org.isistan.flabot.coremodel.ConditionEvent;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.Family;
import org.isistan.flabot.coremodel.FamilyElement;
import org.isistan.flabot.coremodel.Path;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.coremodel.ResponsibilityNode;
import org.isistan.flabot.coremodel.SimplePathNode;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;
import org.isistan.flabot.coremodel.impl.ConditionEventToConditionEventMapEntryImpl;
import org.isistan.flabot.engine.executionstate.ExecutionStateManager;
import org.isistan.flabot.engine.executionstate.GeneralLogFilterStrategy;
import org.isistan.flabot.engine.executionstate.PrologProviderStrategy;
import org.isistan.flabot.engine.executionstate.TraceLogManager;
import org.isistan.flabot.engine.executionstate.TraceLogManagerException;
import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngine;
import org.isistan.flabot.engine.executionstate.javalogtrace.TraceInferenceJavalogEngineLocator;
import org.isistan.flabot.trace.log.TraceLog;
import org.isistan.flabot.util.javalog.JavalogUtil;
import org.isistan.flabot.util.locator.ComponentLocatorException;

import JavaLog.PlException;

/**
* @author $Author: apersson $
*/

public class Loader {
	
	protected Hashtable diagnosticByIDResponsibilityID = new Hashtable();
	protected Hashtable responsibilitiesNodeById = new Hashtable();
	protected Hashtable componentsByID = new Hashtable();
	protected Hashtable eventsByID = new Hashtable();
	private Hashtable responsabilities = new Hashtable();
	
	private JavaLogEngine javaLogEngine;
	
	TraceLog traceLog = null;
	
	public Loader(JavaLogEngine javaLogEngine) {
		this.javaLogEngine = javaLogEngine;
	}
		
	public void initJavaLogEngine(JavaLogEngine javaLogEngine) {
		this.javaLogEngine = javaLogEngine;
	}
	
	public void generatePrologCode(ResponsibilityNode responsibilityNode, CoreModel Model) throws PlException, IOException{
		loadResponsabilities(Model);
		loadComponents(Model);
		loadFamilies(Model);
		loadIntances(Model);
		loadTraceLog();
		loadGeneralLogFilter(Model);
		loadEvents(Model);
	}

	private void loadComponents(CoreModel model) {
		for (int i=0; i<model.getUseCaseMaps().size();i++){
			UseCaseMap useCaseMap = (UseCaseMap) model.getUseCaseMaps().get(i);
			for (int j=0; j<useCaseMap.getComponentRoles().size();j++){
				if (!componentsByID.containsKey(((ComponentRole)useCaseMap.getComponentRoles().get(j)).getID())){
					componentsByID.put(((ComponentRole)useCaseMap.getComponentRoles().get(j)).getID(),((ComponentRole)useCaseMap.getComponentRoles().get(j)));
				}
			}
		}
		
	}

	private void loadTraceLog() {
		traceLog = TraceLogManager.getDefault().loadLog();
	}
	
	private void loadGeneralLogFilter(CoreModel Model)
	{
		try {
			GeneralLogFilterStrategy generalLogFilterStrategy = ExecutionStateManager.getGeneralLogFilterStrategy(Model.getFile());
			TraceInferenceJavalogEngine engine = getTraceInferenceEngine();				
			List<String> rules = JavalogUtil.INSTANCE.splitClauses(generalLogFilterStrategy.getPrologCode());				
			for (String rule: rules) 
			{
				engine.assertString(rule.substring(0, rule.length()-1));
			}
		} catch (TraceLogManagerException e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error trying to obtain the current log.", e);
		} catch (ComponentLocatorException e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error locating the trace inference engine.", e);
		} catch (PlException e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error asserting general log filter prolog code.", e);
		}
	}
	
	public Hashtable getResponsibilitiesNodeByID(){
		return responsibilitiesNodeById;
	}
	
	public Hashtable getComponentsByID(){
		return componentsByID;
	}
	
	public Hashtable getEventsByID(){
		return eventsByID;
	}
	
	public Hashtable getDiagnosticByResponsibility(){
		return diagnosticByIDResponsibilityID;
	}

	private void loadResponsabilities (CoreModel Model) throws PlException, IOException{
		for (int i=0; i < Model.getUseCaseMaps().size(); i++){
			UseCaseMap UCM = (UseCaseMap) Model.getUseCaseMaps().get(i);
			for (int j=0; j < UCM.getPaths().size(); j++){
				responsabilities = new Hashtable();
				Path path = (Path) UCM.getPaths().get(j);
				for (int k=0; k < path.getEndNodes().size(); k++){
					generateResponsabilities((SimplePathNode)path.getEndNodes().get(k), UCM.getID());
				}
			}
		}
	}
	
	/**
	 * Generate the prolog code for each responsibility in the path
	 * @param node
	 * @param nameUCM
	 * @throws PlException
	 * @throws IOException
	 */
	private void generateResponsabilities (SimplePathNode node, String nameUCM) throws PlException, IOException{
		SimplePathNode intialNode = getPrevious (node);
		responsabilities.put(intialNode,intialNode);
		putPrologCode(intialNode.getPrologCode(responsabilities));
		Object key;
		SimplePathNode value;
		for (Enumeration e=responsabilities.keys(); e.hasMoreElements();) {
			key = e.nextElement();
            value = (SimplePathNode)responsabilities.get(key);
            storeInHashMap(value);
		}
	}
	
	public static SimplePathNode getPrevious (SimplePathNode node){
		if (node instanceof ResponsibilityNode || node instanceof StubNode){
			return (node);
		}	
		else
			if (node.uGetPrevious().size() > 0){
				return getPrevious ((SimplePathNode)node.uGetPrevious().get(0));
			}
			else {
				return null;
			}
	}
	
	public static SimplePathNode getNext (SimplePathNode node){
		if (node instanceof ResponsibilityNode || node instanceof StubNode){
			return (node);
		}	
		else
			if (node.uGetNext().size() > 0){
				return getNext ((SimplePathNode)node.uGetNext().get(0));
			}
			else {
				return null;
			}
	}
	
	/**
	 * Add the prolog code to Engine Prolog 
	 * @param code
	 * @throws PlException
	 * @throws IOException
	 */
	private void putPrologCode (String code) throws PlException, IOException{
		javaLogEngine.queryGoals(code);
	}
	
	private void putPrologCode (Vector code) throws PlException, IOException{
		for (int i=0; i < code.size(); i++){
			javaLogEngine.queryGoals((String)code.get(i));
		}
	}
	
	private void storeInHashMap(SimplePathNode node){
		if (node instanceof ResponsibilityNode){
			Responsibility responsibility = ((ResponsibilityNode)node).getResponsibility();
			if (((ResponsibilityNode)node).getRole()!=null){
				componentsByID.put(((ResponsibilityNode)node).getRole().getID(),((ResponsibilityNode)node).getRole());
			}
		}
		responsibilitiesNodeById.put(node.getID(),node);
	}
	
	/**
	 * Reset the Loader
	 * @param responsibilityNode
	 * @param Model
	 * @throws IOException
	 * @throws PlException
	 */
	public void reset (CoreModel Model) throws IOException, PlException{
		responsibilitiesNodeById.clear();
		componentsByID.clear();
		
		PrologProviderStrategy strategy;
		Iterator<ConditionEvent> iterator = eventsByID.values().iterator();
		while (iterator.hasNext())
		{
			strategy = ExecutionStateManager.getPrologProviderStrategy(iterator.next());
			strategy.resetProlog();
		}				
		eventsByID.clear();
		
		GeneralLogFilterStrategy generalLogFilterStrategy = ExecutionStateManager.getGeneralLogFilterStrategy(Model.getFile());
		if (generalLogFilterStrategy != null)
		{
			generalLogFilterStrategy.resetProlog();
		}
		
		diagnosticByIDResponsibilityID.clear();
		loadResponsabilities(Model);
		traceLog = null;
		// free immediately the tracelog memory
		System.gc();
	}
	
	/**
	 * Load the Families to Depedency Mappinps
	 * @param model
	 * @throws PlException
	 * @throws IOException
	 */
	private void loadFamilies(CoreModel model) throws PlException, IOException{
		EList list = model.getFamilies();
		for (int i=0; i < list.size(); i++){
			Family family = (Family)list.get(i);
			EList familyElements = family.getFamilyElement();
			for (int j=0; j < familyElements.size(); j++){
				FamilyElement felement = (FamilyElement)familyElements.get(j);
				String sentence = "assert(family("+family.getID()+","+felement.getFunctionalComponent().getID()+","+felement.getArchitecturalComponent().getID()+","+felement.getUseCaseMap().getID()+")).";
				putPrologCode(sentence);
			}
			ConditionEventToConditionEventMapEntryImpl key;
			for (Iterator e=family.getEvents().iterator(); e.hasNext();) {
				 key = (ConditionEventToConditionEventMapEntryImpl)e.next();
				 String sentence = "assert(familyEvent("+family.getID()+","+((ConditionEvent)key.getKey()).getID()+","+((ConditionEvent)key.getValue()).getID()+")).";
				 putPrologCode(sentence);
			}
			EList respAssociated = family.getAssociatedResponsibilities();
			for (int k=0; k < respAssociated.size(); k++){
				String id = ((SimplePathNode)respAssociated.get(k)).getID();
				SimplePathNode node = ((SimplePathNode)respAssociated.get(k));
				if (node instanceof ResponsibilityNode){
					List preconditions = ((ResponsibilityNode)node).getResponsibility().getPreconditions();
					for (int j = 0; j < preconditions.size(); j++) {
						Condition condition = (Condition)preconditions.get(j);
						if (condition.getType().equals(Condition.mappingCondition)&&condition.getFamily().equals(family)){
							String sentence = "assert(responsibilityFamily("+id+","+condition.getDependencyResponsibility().getID()+","+family.getID()+")).";
							putPrologCode(sentence);
						}
					}
				}
				if (node instanceof StubNode){
					String sentence = "assert(responsibilityFamily("+id+","+((StubNode)node).getEndPointReference().getID()+","+family.getID()+")).";
					putPrologCode(sentence);
				}
				
			}
		}
	}
	
	/**
	 * Load the intances for each Families
	 * @param model
	 * @throws PlException
	 * @throws IOException
	 */
	
	private void loadIntances(CoreModel model) throws PlException, IOException {
		for (Enumeration e=componentsByID.keys(); e.hasMoreElements();) {
             String name = (String)e.nextElement();
             ComponentRole value = (ComponentRole)componentsByID.get(name);
             if (value.getMap().getLevelInfo().equals(UseCaseMap.functionalLevel)){
            	 String query = "assert(instance("+value.getID()+","+value.getID()+","+value.getMap().getID()+")).";
            	 putPrologCode(query);            	 
             }
		}  
	}
	
	private void loadEvents(CoreModel model) {
		PrologProviderStrategy strategy;
		for (int i=0; i < model.getEvents().size(); i++){
			ConditionEvent event = (ConditionEvent)model.getConditionEvents().get(i);
			eventsByID.put(event.getID(),model.getConditionEvents().get(i));
			if (getTraceLog() != null) {
				strategy = ExecutionStateManager.getPrologProviderStrategy(event);				
				assertTraceInferenceCode(strategy.getPrologCode(event));
				//String condition = event.getConditionEvent();
				//assertTraceInferenceCode(condition);
			}
		}		
	}

	private void assertTraceInferenceCode(String condition) {
		try {
			TraceInferenceJavalogEngine engine = getTraceInferenceEngine();
			List<String> rules = JavalogUtil.INSTANCE.splitClauses(condition);
			for (String rule: rules) {
				engine.assertString(rule.substring(0, rule.length()-1));
			}
		} catch (TraceLogManagerException e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error trying to obtain the current log.", e);
		} catch (ComponentLocatorException e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error locating the trace inference engine.", e);
		} catch (PlException e) {
			EnginePlugin.getDefault().getLogger().error(
					"Error asserting event prolog code.", e);
		}
	}

	private TraceInferenceJavalogEngine getTraceInferenceEngine() throws TraceLogManagerException, ComponentLocatorException {
		TraceInferenceJavalogEngine engine = (TraceInferenceJavalogEngine)
		FlabotPlugin.getDefault().getComponentLocatorManager().getComponent(
				TraceInferenceJavalogEngineLocator.LOCATOR_ID,
				Collections.singletonMap(
						TraceInferenceJavalogEngineLocator.PARAMETER_TRACE_LOG,
						traceLog
						)
				);
		return engine;
	}

	/**
	 * @return Returns the traceLog.
	 */
	public TraceLog getTraceLog() {
		return traceLog;
	}
	

}