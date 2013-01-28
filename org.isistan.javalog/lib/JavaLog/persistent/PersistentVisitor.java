/*
 *  $Basename: PersistentVisitor.java $ $Revision: 1.1 $ $ProjectDate: Fri, 17 May 2002 $
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

import JavaLog.*;
import java.util.*;

/**
 * PersistentVisitor 
 * @author Mario Cañete - Gomez Mariano - UNICEN
 * @version $Revision: 1.1 $ $ProjectDate:Fri 17 May 2002 $
 */

public class PersistentVisitor {
    private String driver;
    private String url;
    private String user;
    private String password;
	
    public PersistentVisitor(String driver, String url, String user, String password) {
        super();
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.password = password;
    }
	
    private boolean equalsDB(PersistentLogicModule pllm) {
        return (driver.equals(pllm.driver()) && url.equals(pllm.url()) && user.equals(pllm.user()) && password.equals(pllm.password()));
    }	
	
    public String visitPersistent(PersistentLogicModule pllm, String name) {
        if (!equalsDB(pllm)) {			
            PersistentLogicModule newplm = null;
            try {
                newplm = new PersistentLogicModule("importPersistent_" + name, driver, url, user, password);
            } catch (Exception e) {                System.err.println(e);            }  
            for (Enumeration clauses = pllm.findClauses(); clauses.hasMoreElements();)
                newplm.add((PlStruct) clauses.nextElement());
            for (Enumeration modules = pllm.findModules(); modules.hasMoreElements();)
                newplm.add((PlLocalLogicModule) modules.nextElement());  
            return "importPersistent_";
        }
        return "";  	
    }
	
    public String visitLogicModule(LogicModule lm, String name) {
        PersistentLogicModule newplm = null;
        try {
            newplm = new PersistentLogicModule("transformPersistent_" + name, driver, url, user, password);
        } catch (Exception e) {            System.err.println(e);        }  
        for (Enumeration clauses = lm.findClauses(); clauses.hasMoreElements();)
            newplm.add((PlStruct) clauses.nextElement());
        for (Enumeration modules = lm.findModules(); modules.hasMoreElements();)
            newplm.add((PlLocalLogicModule) modules.nextElement()); 
        return "transformPersistent_";
    }
	
}