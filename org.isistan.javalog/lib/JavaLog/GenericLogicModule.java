/*
 *  $Basename: GenericLogicModuleI.java $ $Revision: 1.1 $ $ProjectDate: Fri, 17 May 2002 $
 *
 *  Copyright (c) 1998,1999
 *  <A HREF="http://www.exa.unicen.edu.ar/">
 *  Departamento de Computación y Sistemas</A>,
 *  Universidad Nacional del Centro de la Provincia de Buenos Aires
 *  All rights reserved.<p>
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You can obtain the GNU General Public License at
 *  http://www.gnu.org/copyleft/gpl.html or by writing to the Free
 *  Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 *  02111-1307, USA.
 *
 *  This software is bound by the terms and conditions listed in the
 *  attached <a href="../LICENSE">LICENSE file</A>.
 */

package JavaLog.persistent;

import com.objectspace.jgl.*;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Hashtable;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.*;
import java.io.*;
import JavaLog.extension.DataBase;
import JavaLog.mobility.*;
import JavaLog.*;

/**
 * GenericLogicModule - A abstract logic module
 * @author Mario Cañete - Gomez Mariano - UNICEN
 * @version $Revision: 1.1 $ $ProjectDate:Fri 17 May 2002 $
 */
public abstract class GenericLogicModule
    implements PrologDatabase, java.io.Serializable, Observable { 
	
    protected Vector observerList = new Vector();
    protected boolean active;
  
    /**
     * Maximum arity supported.
     */
    public static final short MaxArity = 20;
		
    /**
     * Returns the state of the logic module
     * @return <code>true</code> if enabled, <code>false</code> if disabled.
     */
    protected boolean enable(boolean b) {
        return true;
    }
		
    /**
     * Enable a logic module.
     */
    public void enable() {
        active = true;
    }
		
    /**
     * Disable a logic module.
     */
    public void disable() {
        active = false;
    }
		
    /**
     * Returns the state of the logic module.
     * @return <code>true</code> if enabled, <code>false</code> if disabled.
     */
    public boolean active() {
        return active;
    }
		
    /**
     * Connects with a remote logic module. If <code>service</code> is an
     * exported logic module, it is added (remote reference) into this
     * logic module.
     * @param service URL of an exported logic module.
     * @return <code>true</code> if connect finds <code>service</code>.
     */
    public boolean connect(String service) {
        return connect(service.substring(2, service.indexOf('/', 2)), service);
    }
		
    /**
     * Connects with a remote logic module. If <code>service</code> is an
     * exported logic module, it is added (remote reference) into this
     * logic module.
     * @param service name of an exported logic module.
     * @param name host name of the host in which logic module
     * <code>name</code> lives.
     * @return <code>true</code> if connect finds <code>service</code> at host <code>name</code>.
     */
    public boolean connect(String name, String service) {
        try {
            Registry registry = LocateRegistry.getRegistry(name, Registry.REGISTRY_PORT);
        } catch (Exception e) {
            System.out.println("connect exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        return true;
    }
		
    /**
     * NOT IMPLEMENTED
     */
    public int connect(String userName, String password, String hostname) {
        this.connect(userName, hostname);
        return 0;
    }
		
    /**
     * NOT IMPLEMENTED
     */
    public boolean disconnect(int handle) {
        return true;
    }
		
    /**
     * Adds a clause into this logic module.
     * @param plc A clause.
     */
    abstract public void add(PlStruct plc);
		
    abstract public void addFront(PlStruct plc);
		
    /**
     * Borra las clausulas de igual functor y aridad que el parametro plc.
     * @param plc - A clause.
     * @see PlClause
     * Cristian
     */
    abstract public void removeEquals(PlClause plc);
		
    abstract public GenericLogicModule unFreeze(PlVarTable varTable);
		
    /**
     * Adds a logic module into this logic module.
     * @param module A logic module.
     */
    abstract public void add(PlLogicModule module);
		
    /**
     * Delete a logic module into this logic module.
     * @param moduleName The name´s logic module.
     */
    abstract public void deleteLogicModule(String moduleName);
		
    /**
     * Cristian.
     * Removes a clause.
     * @param enum Reference to a clause.
     */ 
    abstract public void delete(Enumeration enum);
		
    /**
     * Encuentra las clausulas que coinciden con
     * la pasada por parametro
     *
     * @param pls una clausula
     * @return un enumeration con las clausulas encontradas.
     */
    abstract public Enumeration find(PlStruct pls);
		
    /**
     * Devuelve todas las clausulas que estan dentro del modulo
     * logico sin considerar las de los modulos logicos contenidos
     * @return un enumeration con todas las clausulas.
     */
    abstract public Enumeration findClauses();
		
    /**
     * Finds clauses with head <code>functor/arity</code>.
     * @param functor Functor of clause head.
     * @param arity Arity of clause head.
     * @return An enumeration with matched clauses.
     */
    abstract public Enumeration find(String functor, int arity);
		
    /**
     * Finds logic modules.
     * @return An enumeration with modules.
     */
    abstract public Enumeration findModules();
		
    /**
     * Searches for the first occurence of the given argument, testing for
     * equality using the name of the logic module.
     * @param moduleName logic module name
     * @return <code>true</code> if it exists; <code>false</code> if the logic module is
     * not found.
     */
    abstract public PrologDatabase findModule(String moduleName);
		
    /**
     * Metodo agregado por M.Cañete y M.Gomez
     */
    abstract public String acceptPV(PersistentVisitor pv, String name);
		
    /**
     * Returns a string representation of a logic module.
     */
    public String toString_() {
        return toString();
    }
		
    /**
     * Returns a string representation of a logic module.
     */
    abstract public String toString();
		
    /**
     * Returns a string representation of the logic modules.
     */
    abstract public String toStringModules();
		
    /**
     * Returns a string representation of clauses with head functor equals
     * to the argument.
     * @param functor functor name.
     */
    public String toString(String functor) {
        StringBuffer sb = new StringBuffer();
        for (int arity = 0; arity < MaxArity; arity++)
            for (Enumeration e = find(functor, arity); e.hasMoreElements();) {
                String tmp = e.nextElement().toString();
                if (tmp != null) {
                    sb.append(tmp);
                    sb.append("\n");
                }
            }
        return sb.toString();
    }
		
    /**
     * Destructor.
     */
    protected void finalize() throws Throwable {
        super.finalize();
    }	 
		
    /**
     * Publish a logic module. A published logic module can be accessed by
     * others interpreters by using
     * <tt>connect('//host/JavaLog/<em>shareName</em>')</tt>.
     * @param shareName identifier of the published logic module.
     */
    public boolean publish(String shareName) {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(Registry.REGISTRY_PORT);
            registry.list();
        } catch (RemoteException e) {
            registry = null;
        }
        try {
            String localHostName =
                java.net.InetAddress.getLocalHost().getHostName();
            if (registry == null) {
                registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            }
            registry.rebind("//" + localHostName + "/JavaLog/" + shareName, null);
            return true;
        } catch (Exception e) {
            System.out.println("PrologServer err: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
		
    public boolean consult(String s, PlParser parser) {
        try {
            Reader r = new FileReader(s);
            return readFrom(r, parser);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }   
		
    public boolean readFrom(Reader reader, PlParser parser) {
        PlStruct plo = null;
        while (true) {
            try {
                if (plo == null)
                    plo = parser.clause(reader);
                else
                    plo = parser.clause();
            } catch (PlException e) {
                e.printStackTrace();
                plo = PlList.empty();
                parser.recover();
            } finally {
                if (plo != null && plo instanceof PlClause)
                    add(DataBase.mkClause(plo));
                else
                    break;
            }
        }
        try {
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
		
    /*
     * Cristian
     * Agrega una cláusula a la base de datos que un cliente ve como
     * distribuída a lo largo de una red. Por defecto llama al add definido
     * mas arriba (base de datos centralizada)
     */
    public void addShared(PlStruct plc) {
        add(plc);
    }
		
    public void addShared(PlLogicModule module) {
        add(module);
    }
		
    public void addPrivate(PlStruct plc) {
        add(plc);
    }
		
    public void addPrivate(PlLogicModule module) {
        add(module);
    }
		
    public void addObserver(Observer observer) {
        synchronized (observerList) {
            observerList.addElement(observer);
        }
    }
		
    public Observer[] observers() {
        synchronized (observerList) {
            Observer[] obs = new Observer[observerList.size()];
            for (int i = 0; i < obs.length; i++)
                obs[i] = (Observer) observerList.elementAt(i);
            return obs;
        } 
    }
		
    public void deleteObservers() {
        observerList.clear();
    }
		
    public void deleteObserver(Observer observer) {
        synchronized (observerList) {
            observerList.remove(observer);
        }
    }
		
    public void notifyObservers() {}
		
    public void notifyObservers(Object arg) {
        Enumeration e = observerList.elements();
        while (e.hasMoreElements()) {
            Observer observer = (Observer) e.nextElement();
            observer.update((Observable) this, arg);
        }
    }
}
