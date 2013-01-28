/*
 * $Basename: PersistentLogicModule.java $ $Revision: 1.1 $ $ProjectDate: Fri,17 May  $
 *
 * Copyright (c) 1998,1999 
 * <A HREF="http://www.exa.unicen.edu.ar/">
 * Departamento de Computación y Sistemas</A>, 
 * Universidad Nacional del Centro de la Provincia de Buenos Aires
 * All rights reserved.<p>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You can obtain the GNU General Public License at
 * http://www.gnu.org/copyleft/gpl.html or by writing to the Free
 * Software Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA
 * 02111-1307, USA.
 *
 * This software is bound by the terms and conditions listed in the
 * attached <a href="../LICENSE">LICENSE file</A>.
 */

package JavaLog.persistent;

import java.sql.*;
import java.io.*;
import java.util.*;
import JavaLog.*;

/**
 * PersistentLogicModule - A logic module persistent
 * @author Mario Cañete - Gomez Mariano - UNICEN
 * @version $Revision: 1.1 $ $ProjectDate: 17 May 2002 17:11:12 -0300 $
 */
public class PersistentLogicModule extends GenericLogicModule implements Serializable, PrologDatabase {

    /**
     * Esta variable contiene una instancia de un objeto connection
     * para conectarnos con la base de datos
     */
    private Connection connection;
	
    /**
     * Esta variable contiene el nombre del modulo logico persistente.
     */
    private String namePLM;
	
    /**
     * Esta variable contiene el string que especifica el path del driver.
     */
    private String driver;
	
    /**
     * Esta variable contiene el string url para conectarnos con la base de datos.
     */
    private String url;
	
    private String user;
    private String password;
	
    /**
     * Esta variable contiene los nombres de los diferentes tipos de columnas 
     * que le dan las bases de datos a los tipos binarios de datos.
     */
    private static String Types = "LONGBLOB;LONGVARBINARY;LONGBINARY;VARBINARY";
  
    private boolean active;
	
    /**
     * Carga el driver de la base de datos pasado por parametro.
     *
     * @param el string con la ruta del driver.
     */
   
  
    private boolean loadDriver(String driver) {
        try {
            Class.forName(driver);
            return true;
        } catch (ClassNotFoundException e) {	
            System.out.println("ClassNotFoundException: No se pudo cargar el controlador");
            return false;
        }
    }

    /**
     * Crea una nueva conexion con la base de datos.
     *
     * @param URL: el string conteniendo el url.
     * @param User: el nombre del usuario
     * @param Password: el password de ese usuario.
     * @return un Connection.
     */
    private Connection createConnection(String URL, String User, String Password) {
        Connection con;
        try {
            con = DriverManager.getConnection(URL, User, Password);
            return con;
        } catch (SQLException e) {
            System.out.println("SQLException: No se pudo encontrar el driver");
            return null;
        }
    }

    /**
     * Crea los indices sobre las tablas de la base de datos.
     */
    private void createIndexes() {
        Statement st;
        try {
            st = connection.createStatement();
            try {
                st.executeUpdate("CREATE INDEX " + namePLM + "INDEX_FUNCTOR_ARITY ON " + namePLM + "STRUCTS (FUNCTOR,ARITY)");
            } catch (SQLException e) {}
            st = connection.createStatement();
            try {
                st.executeUpdate("CREATE INDEX " + namePLM + "INDEX_MODULE ON " + namePLM + "MODULES (MODULE)");   	 
            } catch (SQLException e) {}
        } catch (SQLException e) {}	
    }
	
    /**
     * Obtiene el nombre tipo de columna apropiado para crear la tabla.
     *
     * @return un string que contiene el tipo de columna.
     */
    private String getColumnType() {
        try {
            DatabaseMetaData dma = connection.getMetaData();
            ResultSet rst = dma.getTypeInfo();
            String typeBlob1;
            StringTokenizer sToken;
            while (rst.next()) { 
                typeBlob1 = rst.getString(1);
                sToken = new StringTokenizer(Types, ";");
                while (sToken.hasMoreTokens()) {
                    if (typeBlob1.equals(sToken.nextToken())) {
                        return typeBlob1;	      
                    }	 
                }
            }
        } catch (SQLException e) {            System.err.println(e);        }  	 
        return "";
    }
    
    /**
     * Crea las tablas de la base de datos.
     */
    private boolean createTables() {
        Statement st;
        String type = getColumnType();
        try {
            st = connection.createStatement();
            try {
                if (type == "") {
                    throw new SQLException("SQLException: La base de datos no soporta ningun tipo binario regitrado");
                }	
                st.executeUpdate("CREATE TABLE  " + namePLM + "STRUCTS(" +
                    "FUNCTOR CHAR(20)," +
                    "ARITY CHAR(2)," +
                    "PLSTRUCT " + type + ")"
                );
    	  
                st = connection.createStatement();
                st.executeUpdate("CREATE TABLE " + namePLM + "MODULES(" +
                    "MODULE CHAR(20), UNIQUE (MODULE))"
                );
            } catch (SQLException e) {
                if (type == "") {
                    System.out.println(e.getMessage());
                    return false;
                }  
            }  
        } catch (SQLException e) {
            return false;		
        }
        createIndexes();
        return true;
    }

    /**
     * Constructor:Crea un modulo logico persistente 
     *
     * @param name el nombre del modulo logico persistente.
     * @param driver el path del driver de la base de datos.
     * @param URL el url necesario para la conexion con la base de datos.
     * @param user el usuario de la base de datos.
     * @param password el password del usuario que se conecta.
     */
    public PersistentLogicModule(String name, String driver, String URL, String User, String Password) throws Exception {
        this.driver = driver;
        this.url = URL;
        this.user = User;
        this.password = Password;
        boolean ok;
        ok = loadDriver(driver);
        connection = createConnection(URL, user, password);
        ok = ok && (connection != null);
        namePLM = name;
        ok = ok && (createTables());
        if (!ok) 
            throw new Exception("No se pudo crear el modulo logico persistente");			
        super.active = true;
    }

    /**
     * Constructor:Crea un modulo logico persistente 
     *
     * @param name el nombre del modulo logico persistente.
     * @param driver el path del driver de la base de datos.
     * @param URL el url necesario para la conexion con la base de datos.
     */
    public PersistentLogicModule(String name, String driver, String URL) throws Exception {
        this.driver = driver;
        this.url = URL;
        this.user = "";
        this.password = "";

        boolean ok;
        ok = loadDriver(driver);
        connection = createConnection(URL, user, password);
        ok = ok && (connection != null);
        namePLM = name;
        ok = ok && (createTables());
        if (!ok) 
            throw new Exception("No se pudo crear el modulo logico persistente");
        super.active = true;
    }

    /**
     * Devuelve el nombre del modulo logico persistente
     * @return namePLM: el nombre del modulo
     */
    public String name() {
        return namePLM;	
    }		
	
    /**
     * Devuelve el driver utilizado por el modulo logico persistente
     * @return driver: el driver utilizado
     */
    public String driver() {
        return driver;	
    }	
	
    /**
     * Devuelve el url utilizado por el modulo logico persistente
     * @return url: el url utilizado
     */
    public String url() {
        return url;	
    }		
	
    /**
     * Devuelve el user utilizado por el modulo logico persistente
     * @return user: el user utilizado
     */
    public String user() {
        return user;	
    }		
	
    /**
     * Devuelve el password utilizado por el modulo logico persistente
     * @return password: el password utilizado
     */
    public String password() {
        return password;	
    }		
	
    private boolean existsInTable(PlStruct plo) {
        PreparedStatement pstmt;
        Seriate seriate = new Seriate();
        try {
            pstmt = connection.prepareStatement("SELECT * FROM " + namePLM + "STRUCTS WHERE PLSTRUCT = ?");
            ByteArrayOutputStream out1 = seriate.serialize(plo);	    
            ByteArrayInputStream in = new ByteArrayInputStream(out1.toByteArray());
            pstmt.setBinaryStream(1, in, (out1.toByteArray()).length);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
                return true;    	
        } catch (SQLException e) {            System.err.println(e);        } catch (Exception e) {            System.err.println(e);        } 
        return false;    
    }   

    /**
     * Agrega una clausula dentro de este modulo logico.
     * @param plo una clausula.
     * @see PlStruct
     */
    public void add(PlStruct plo) {
        PreparedStatement pstmt;
        Seriate seriate = new Seriate();
        try {
            if (!(existsInTable(plo))) {	
                ByteArrayOutputStream out1 = seriate.serialize(plo);
                ByteArrayInputStream in1 = new ByteArrayInputStream(out1.toByteArray());
	
                pstmt = connection.prepareStatement("INSERT INTO " + namePLM + "STRUCTS VALUES (?,?,?)");
                Integer arity = new Integer(plo.head().arity());
                pstmt.setString(1, plo.head().functor());
                pstmt.setString(2, arity.toString());
                pstmt.setBinaryStream(3, in1, (out1.toByteArray()).length);
                pstmt.executeUpdate();
                pstmt.close();
	      	      
                in1.close();
                out1.close();
            }
        } catch (SQLException e) {            System.err.println(e);        } catch (Exception e) {            System.err.println(e);        }
    }

    private void addModuleReference(String nameModule) {
        Statement st;
        try {
            st = connection.createStatement();
            st.executeUpdate("INSERT INTO " + namePLM + "MODULES VALUES ('" + nameModule + "')");     
            st.close();
        } catch (SQLException e) {            System.err.print(e);        }
    }
 
    /**
     * Agrega un modulo logico dentro de este modulo logico.
     * @param module un modulo logico.
     */
    public void add(PlLogicModule module) {
        GenericLogicModule  glm = ((PlLocalLogicModule) module).module();
        String nameModule = module.name();
        PersistentVisitor pv = new PersistentVisitor(driver, url, user, password);
        String prefix = glm.acceptPV(pv, nameModule);
        addModuleReference(prefix + nameModule);
	
    }
  
    /**
     * Busca una clausula con cabeza <code>functor/arity</code>.
     * @param functor es el Functor de la clausula.
     * @param arity es la Aridad de la clausula.
     * @return Un enumeration con las matched clauses.
     */
    public Enumeration find(String functor, int arity) {
        Statement st;
        ResultSetIterator rsi;
        PlStruct pls = null;
        if (!super.active())
            return new PersistentLogicModuleIterator(this, new ResultSetIterator(null), functor, arity); 
        try {
            st = connection.createStatement();
            Integer ari = new Integer(arity);
            ResultSet rs = st.executeQuery("SELECT PLSTRUCT FROM " + namePLM + "STRUCTS" +
                    " WHERE FUNCTOR = '" + functor + "'" +
                    " AND ARITY = '" + ari.toString() + "'");
            rsi = new ResultSetIterator(rs); 
        } catch (SQLException e) {
            rsi = new ResultSetIterator(null);
            System.err.println(e);
        }
        return new PersistentLogicModuleIterator(this, rsi, functor, arity); 
    }

    /**
     * Busca una estructura Prolog 
     * @param plo es la estructura Prolog que se busca.
     * @return Un enumeration con las estructuras encontradas.
     */
    public Enumeration find(PlStruct plo) {
        Statement st;
        ResultSetIterator rsi;
        String functor = plo.functor();
        Integer arity = new Integer(plo.arity());
        if (!super.active())
            return new PersistentLogicModuleIterator(this, new ResultSetIterator(null), plo); 
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT PLSTRUCT FROM " + namePLM + "STRUCTS" +
                    " WHERE FUNCTOR = '" + functor + "'" +
                    " AND ARITY = '" + arity.toString() + "'");
            rsi = new ResultSetIterator(rs); 
        } catch (SQLException e) {  		
            rsi = new ResultSetIterator(null);
            System.err.println(e);
        }		
        return new PersistentLogicModuleIterator(this, rsi, plo); 
    }   

    /**
     * Busca un modulo logico dentro de este.
     * @param name es el nombre del modulo logico buscado.
     * @return el modulo logico que coincide con el nombre dado.
     */
    public PrologDatabase findModule(String name) {
        Statement st;
        PersistentLogicModule plm = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT MODULE FROM " + namePLM + "MODULES" +
                    " WHERE MODULE = '" + name + "'");      
            if (rs.next()) 
                plm = new PersistentLogicModule(name, driver, url, user, password);       	
        } catch (SQLException e) {            System.err.println(e);        } catch (Exception e) {            System.err.println(e);        }
        return plm;
    }
	
    /**
     * Busca todos los modulos logicos dentro de este.
     *
     * @return un enumeration con todos los modulos encontrados.
     */
    public Enumeration findModules() {
        Statement st;
        Vector v = new Vector();
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT MODULE FROM " + namePLM + "MODULES");      
            String name;
            PlLocalLogicModule pllm;
            while (rs.next()) {
                name = rs.getString(1);
                try {
                    pllm = new PlLocalLogicModule(new PlStructArgs(PlLogicModule.PERSISTENT_LOGIC_MODULE_FUNCTOR,
                                    new PlAtom(name), null), new PersistentLogicModule(name, driver, url, user, password));      		
                    v.addElement(pllm);
                } catch (Exception e) {                    System.err.println(e);                }
            }
        } catch (SQLException e) {            System.err.println(e);        }
        return v.elements();
    }
	
    /**
     * Busca todas las clausulas con el Functor dado.
     * @param functor es el Functor de la clausula que se busca.
     * @return un enumeration con las clausulas que hacen matching
     */
    private Enumeration findClauses(String functor) {
        Statement st;
        ResultSetIterator rsi;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT PLSTRUCT FROM " + namePLM + "STRUCTS " +
                    "WHERE FUNCTOR = '" + functor + "' " +
                    "ORDER BY ARITY ");
            rsi = new ResultSetIterator(rs);
        } catch (SQLException e) {
            System.err.println(e);
            rsi = new ResultSetIterator(null);
        }
        return rsi;
    }
	
    /**
     * Busca todas las clausulas dentro del modulo.
     * 
     * @return un enumeration con todas las clausulas ordenadas por aridad.
     */
    public Enumeration findClauses() {
        Statement st;
        ResultSetIterator rsi;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT PLSTRUCT FROM " + namePLM + "STRUCTS ORDER BY ARITY");
            rsi = new ResultSetIterator(rs);
        } catch (SQLException e) {
            System.err.println(e);
            rsi = new ResultSetIterator(null);
        }
        return rsi;
    }

    /**
     * Agrega una clausula dentro de este modulo logico.
     * @param plc una estructura Prolog.
     * @see PlStruct
     */
    public void addFront(PlStruct plc) {
        this.add(plc);	
    }	

    /**
     * Borra las clausulas de igual functor y aridad que el parametro plc.
     * @param plc - una clausula.
     * @see JavaLog.PlClause.
     */
    public void removeEquals(PlClause plc) {
        String functor = plc.head().functor();	
        Integer arity = new Integer(plc.head().arity());
        Statement st;
        try {
            st = connection.createStatement();
            int i = st.executeUpdate("DELETE FROM " + namePLM + "STRUCTS" +
                    " WHERE FUNCTOR = '" + functor + "'" +
                    " AND ARITY = '" + arity.toString() + "'");
        } catch (SQLException e) {            System.err.println(e);        }
    }

    /**
     * Borra un modulo logico que esta dentro de este modulo logico.
     * @param moduleName - el nombre del modulo logico a borrar.
     */
    public void deleteLogicModule(String moduleName) {
        Statement st;
        try {
            st = connection.createStatement();
            int i = st.executeUpdate("DELETE FROM " + namePLM + "MODULES" +
                    " WHERE MODULE = '" + moduleName + "'");
        } catch (SQLException e) {            System.err.println(e);        }
    }
	
    public void delete(Enumeration enum) {
        int arity = ((PersistentLogicModuleIterator) enum).plStruct().arity();
        String functor = ((PersistentLogicModuleIterator) enum).plStruct().functor();
        Statement st;
        try {
            st = connection.createStatement();
            int i = st.executeUpdate("DELETE FROM " + namePLM + "STRUCTS" +
                    " WHERE FUNCTOR = '" + functor + "'" +
                    " AND ARITY = '" + arity + "'");     
        } catch (SQLException e) {            System.err.println(e);        }
  
    }

    public String toString(String functor) { 
        StringBuffer sb = new StringBuffer();
        Enumeration e = findClauses(functor);
        while (e.hasMoreElements()) {
            sb.append(((PlStruct) e.nextElement()).toString());
            sb.append("\n");
        }
        sb.append(toStringModules());
        return sb.toString();
    }

    /**
     * Retorna una representacion en String de un modulo logico persistente
     */
    public String toString_() {
        return this.toString();
    }

    public PersistentLogicModule append(PersistentLogicModule module) {
        return this;
    }

    public PersistentLogicModule override(PersistentLogicModule module) {
        return this;
    }

    public String toStringModules() {
        StringBuffer sb = new StringBuffer();
        Enumeration e = this.findModules();
        while (e.hasMoreElements()) {
            sb.append(((PlLogicModule) e.nextElement()).toString());
            sb.append("\n\n");
        }
        return sb.toString();
	
    } 	

    /**
     * Retorna una representacion en String de un modulo logico persistente
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Enumeration e = findClauses();
        while (e.hasMoreElements()) {
            sb.append(((PlStruct) e.nextElement()).toString());
            sb.append("\n");
        }
        sb.append(toStringModules());
        return sb.toString();
    }

    public GenericLogicModule unFreeze(PlVarTable varTable) {
        return this;
    } 	

    /**
     * Destructor de la clase - cierra la conexion con la base de datos.
     */
    protected void finalize() throws Throwable {
        try {
            connection.close();
        } catch (SQLException e) {            System.err.println(e);        }
        super.finalize();
    }
	
    public String acceptPV(PersistentVisitor pv, String name) {
        return pv.visitPersistent(this, name);
    }
		
}