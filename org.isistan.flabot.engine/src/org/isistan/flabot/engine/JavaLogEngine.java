/**
 * $Id: JavaLogEngine.java,v 1.17 2006/03/22 03:28:54 franco Exp $
 */

package org.isistan.flabot.engine;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.core.runtime.Platform;
import org.isistan.flabot.util.javalog.JavalogUtil;

import JavaLog.Brain;
import JavaLog.JMain;
import JavaLog.LogicKnowledge;
import JavaLog.LogicModule;
import JavaLog.PlClause;
import JavaLog.PlException;
import JavaLog.PlFVar;
import JavaLog.PlList;
import JavaLog.PlLocalLogicModule;
import JavaLog.PlObject;
import JavaLog.PlParser;
import JavaLog.PlStruct;
import JavaLog.PlStructArgs;
import JavaLog.PlUVar;

import com.objectspace.jgl.SList;


/**
 * @author $Author: franco $
 */

public class JavaLogEngine
{

    private Hashtable logicModules = new Hashtable();
    private LogicKnowledge actualLogicModule;
    private LogicKnowledge stateLogicModule;
    //private SystemFactory systemFactory;

    //-- Instance Variables
    private Brain engine;

    private JMain gui = null;

    //---- Constructor(s)
    public JavaLogEngine() throws IOException, PlException
    {	
    	URL relativeURL = Platform.getPlugin("org.isistan.javalog").getBundle().getEntry("/");
    	URL localURL = Platform.asLocalURL(relativeURL);
		String pathJavalog = localURL.getPath();
		System.setProperty( "java.class.path",System.getProperty("java.class.path")+File.pathSeparator+pathJavalog+File.separator+"lib"+File.separator+"JavaLog"+File.separator+"web"+File.separator+"WEB-INF"+File.separator+"classes"+File.separator);
        engine = new Brain();
        stateLogicModule = new LogicKnowledge(engine,"",0);
        stateLogicModule.active();
        stateLogicModule.enable();
    }
    
    public void loadLogicModule(String logicModuleFileName) throws IOException {
    	LogicKnowledge lk = new LogicKnowledge(engine, loadModule(logicModuleFileName));
    	engine.addKnowledge(lk);
    	logicModules.put(logicModuleFileName, lk);
    	lk.disable();
    }
    
    public void changeLogicModule (String logicModule){
    	if (actualLogicModule != null)
    		actualLogicModule.disable();
    	actualLogicModule = (LogicKnowledge) logicModules.get(logicModule);
    	if (actualLogicModule != null) {
	    	actualLogicModule.active();
	    	actualLogicModule.enable();
    	}
    }

    /**
     * Agrega al motor de prolog el código especificado en la variable <code>prologCode</code>
     * @param prologCode código prolog a agregar
     * @return <code>true </code>si pudo agregar el código prolog.
     *         <code>false</code> en caso contrario
     * @throws PlException 
     */
    public boolean assertString(String prologCode) throws PlException{
          engine.call("assert("+prologCode+").");
          return true;
       }

    public void runGUI(){
      this.gui.run();
    }

    //-- Instance Methods

    public JMain runInspectionGui(){
        gui.run();
        return (gui);
    }

    public boolean queryGoals(String query) throws PlException{
        boolean ok = engine.call(query);
        return (ok);
     }

    public void reset() throws IOException, PlException{
    	engine = new Brain();
    	logicModules = new Hashtable();
    	actualLogicModule = null;
        stateLogicModule = new LogicKnowledge(engine,"");
        stateLogicModule.disable();
        
    }

    public Vector getEventFor(String responsibilityID) throws PlException{
      String query = "getEvents("+responsibilityID+",Result).";
      Vector ret = null;

      if(this.queryGoals(query)){
        ret = new Vector();
        Hashtable result = this.engine.goal().state();
        PlList list =  (PlList)result.get("Result");
           System.out.println("El valor es "+list.toString());
        PlObject [] objects = list.toArray();
        if(objects!=null)
          for (int i = 0; i < objects.length; i++) {
            ret.addElement(((PlStructArgs)objects[i]).argument(0).toString());
          }
      }
      return ret;

    }


    public String formatJavalogList(PlList list)
    {
    	PlObject[] objects = list.toArray();
    	String temp = "";
    	String result = "";
    	if (objects == null)
    		return ("");
    	for (int i = 0; i < objects.length; i++)
    	{
    		if (objects[i] instanceof PlList)
    		{
    			temp = this.formatJavalogList((PlList)objects[i]);
    			result = result + temp;
    		}
    		else
    			result = result + objects[i].toString();
    		if (i < objects.length-1)
    			result = result + ",";
    	}
    	//System.out.println("FORMATING..   "+result);
    	return (result);
	}

    public LogicModule javalogDatabase()
    {
        return (engine.database());
    }

    public PlParser javalogParser()
    {
        return (engine.parser());
    }

    public PlClause parseClause(String s) throws PlException{
       return (this.javalogParser().clause(new StringReader(s)));
     }

    public void parseStruct(String struct) throws PlException{
      this.engine.builtIns()[0].builtIn("assert",new Object[]{engine.parser().clause("found("+struct+").")});
      }

    /**
     * Transforma una lista prolog en un vector que contiene los
     * elementos
     * @param prologList PlList lista prolog
     * @return Vector vector con los elementos
     */

    public static Vector getVectorFromList(PlList prologList){
    	if (prologList == null)
    		return null;
    	Vector ret = new Vector();
    	PlList tmp = prologList;
    	while(!tmp.equals(PlList.empty())){
    		ret.addElement(tmp.car());
    		tmp = (PlList)tmp.cdr();
    	}
    	return ret;
    }
    
    public Object executeQuery (String query, String parameter) throws PlException{
        if(this.queryGoals(query)){
          Hashtable result = this.engine.goal().state();
          return result.get(parameter);
        }
        return null;
    }
    
    /**
     * Execute the given query with the given java objects and then return the
     * resulting value for the specified parameter
     * @param query the prolog query
     * @param objects the java objects that parametrize the query
     * @param parameter the name of the parameter whose value must be returned
     * @return the resulting value of the specified parameter
     */
    public Object executeQuery(String query, Object[] objects, String parameter) {
    	stateLogicModule.enable();
    	if (engine.answerQuery(query, objects)) {
    		Map result = engine.answer();
    		return result.get(parameter);
    	}
    	stateLogicModule.disable();
    	return null;
    }
    
    public Hashtable executeQuery (String query) throws PlException{
        if(this.queryGoals(query)){
          return this.engine.goal().state();
        }
        return null;
    }
    


/**
 * Evalua el findAll y arma todos los valores que cumplan con la condicion expresada
 * en <code>condition</code> de forma (o con la estructura) que lo especifica el
 * parametro <code>structure</code>
 * @param structure estructura que relaciona los elementos a ser extraidos
 * @param condition condicion que tienen que cumplir las variables que sean retornadas
 * @return Vector contiene las estrucuturas que fueron armadas y cumplen con a condicion.
 * @throws PlException 
 */
    public Vector evaluateFindAll(String structure, String condition) throws PlException{

      String query = "findall("+structure+","  + condition +",List).";
      Vector ret = null;
      boolean okFindall = this.queryGoals(query);
      if(okFindall){
        ret = new Vector();
        System.out.println("el query fue: "+okFindall);
        Hashtable result = this.engine.goal().state();
        PlList list =  (PlList)result.get("List");
      	System.out.println("El valor es "+list.toString());
        PlObject [] objects = list.toArray();
        for (int i = 0; i < objects.length; i++) {
          ret.addElement(objects[i]);
        }
      }
      return ret;

    }
    
  private String loadModule(String file) throws IOException {
   File archivo = new File(file);
   String hechos = new String();
   DataInputStream in = new DataInputStream(new FileInputStream(archivo));
   BufferedReader buff = new BufferedReader( new InputStreamReader(in));
   String s = buff.readLine();
   while (s!=null) {
          s.trim();
          hechos = hechos + s + "\n";
          s=buff.readLine();
          }
   buff.close();
   return hechos;
  }
  
  public void sendObjectPostMessage() throws IOException, ClassNotFoundException {
	  FileOutputStream fos = new FileOutputStream("filename.lks");
	  DataOutputStream out = new DataOutputStream(fos);
      out.writeUTF(getRules(actualLogicModule));
      out.flush();
      out.close();
  }
  
  public void getObjectPostMessage() throws IOException  {
	  FileInputStream fis = new FileInputStream("filename.lks");
	  DataInputStream ois = new DataInputStream(fis);
      stateLogicModule = new LogicKnowledge (engine,ois.readUTF());
      engine.addKnowledge(stateLogicModule);
      stateLogicModule.active();
      stateLogicModule.enable();
  }
  
  public void assertRule (String rule){
	actualLogicModule.disable();
  	stateLogicModule.active();
  	stateLogicModule.enable();
  	rule += ".";
  	stateLogicModule.addPrivate(JavalogUtil.INSTANCE.mkClause(engine.parser().eQuery(rule)));
	//stateLogicModule.disable();
	actualLogicModule.active();
  	actualLogicModule.enable();
  }
  
  
  public void retractRule (String rule) {
	actualLogicModule.disable();
	stateLogicModule.active();
	stateLogicModule.enable();
	rule += "."; 
	removeEquals(JavalogUtil.INSTANCE.mkClause(engine.parser().eQuery(rule)));
	//stateLogicModule.disable();
	actualLogicModule.active();
	actualLogicModule.enable();
	}

  private String getRules(LogicModule state){
	  String rules = state.toString();
	  String temp="";
	  for (int i=0; i<rules.length();i++){
		  temp+=rules.charAt(i);
		  if (rules.charAt(i)==')' && rules.charAt(i+1)!=')' && rules.charAt(i+1)!='.'){
			  temp+=".";
		  }
	  }
	  return temp;
  }	

  private boolean unify(PlStruct clause, PlObject plo) {
	  if (plo instanceof PlStruct) {
	      PlStruct tmp = (PlStruct) plo;
          if (clause.functor().equals(tmp.functor()) && clause.arity() == tmp.arity()) {
              for (int i = 0; i < clause.arity(); i++)
                  if (unify((PlStruct)clause.arg(i),tmp.arg(i)) == false) {
                      return false;
                  }
              return true;
          } else {
              return false;
          }
      } else if (plo instanceof PlUVar) {
          return plo.unify(clause);
		}
      else if (plo instanceof PlFVar){
    	  return true;
      }
      return false;
  }
  
  private void removeEquals(PlStruct plc) {
      String functor = plc.head().functor();
      int arity = plc.head().arity();
      SList bucket = stateLogicModule.getBucket(arity,functor);
      if (bucket == null)
          return;
      synchronized (bucket) {
          if (bucket.size() > 0)// Borrar las que hacen match
          {
              SList auxb = bucket;
              Enumeration e = auxb.elements();
              PlClause clause = null;
              while (e.hasMoreElements()) {
                  clause = (PlClause) e.nextElement();
                  if (clause.head().functor().equals(functor) && unify(clause,plc))
                      bucket.remove(clause);
              }
          }
          }
      }
  
  public String getStateLogicModule(){
	  return stateLogicModule.toString();
  }
  
  public void setStateLogicModule(String module, boolean redefineState) throws PlException, IOException, ClassNotFoundException{
	  boolean existsModule = false;
	  String key="";
	  PlLocalLogicModule value=null;
	  for (Enumeration e=engine.database().getModules().keys(); e.hasMoreElements();) {
          key = (String)e.nextElement();
          value = (PlLocalLogicModule)engine.database().getModules().get(key);
          if (stateLogicModule.equals(value.module())){
        	  existsModule = true;
        	  break;
          }
         
	  }
	  if (redefineState){
		  stateLogicModule = new LogicKnowledge(engine,"",0);
	  }
	  stateLogicModule.disable();
	  List clauses = JavalogUtil.INSTANCE.splitClauses(module);
	  for (int i=0; i < clauses.size(); i++){
		  stateLogicModule.add(JavalogUtil.INSTANCE.mkClause(engine.parser().eQuery((String)clauses.get(i))));
	  }
	  if (!existsModule){
		  engine.addKnowledge(stateLogicModule);
	  }
	  else{
		  PlLocalLogicModule moduleToInsert = new PlLocalLogicModule(value.head(),stateLogicModule);
		  engine.database().getModules().put(key,moduleToInsert);
	  }	  
	  stateLogicModule.active();
      stateLogicModule.enable();
  }

  public Brain getBrain() {
		return engine;
  }
 }




 
