/*
 * $Basename: Seriate.java $ $Revision: 1.1 $ $ProjectDate: 17 May 2002
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
 * Seriate - Serializa y deserializa objetos Java.
 * @author Mario Cañete - Gomez Mariano - UNICEN
 * @version $Revision: 1.1 $ $ProjectDate: 17 May 2002
 */
public class Seriate {
	
    /**
     * constructor de la clase
     */
    Seriate() {
        super();
    }
	
    /**
     * Serializa un objeto PlStruct
     * @param p una estructura prolog que se debe serializar
     * @return el objeto p serializado
     */
    public ByteArrayOutputStream serialize(PlStruct p) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(p);
            out.close();	    	
        } catch (IOException e) {}
        return out;
    }
	
    /**
     * Serializa un modulo logico
     * @param m es el modulo logico que se debe serializar.
     * @return el modulo logico serializado.
     */
    public ByteArrayOutputStream serialize(PlLogicModule m) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(out);
            oos.writeObject(m);
            out.close();	    	
        } catch (IOException e) {}
        return out;
    }
	
    /**
     * Deserializa un objeto
     * @param rs es un resultset que contiene el objeto a deserializar
     * @return el objeto deserializado.
     */
    public PlStruct deserialize(ResultSet rs) {
        PlStruct pls = null;
        try {
            byte tmp[] = rs.getBytes("PLSTRUCT");
            ByteArrayInputStream bais = new ByteArrayInputStream(tmp);
            ObjectInputStream ois = new ObjectInputStream(bais); 
            pls = (PlStruct) ois.readObject();
        } catch (IOException e) {} catch (SQLException e) {} catch (Exception e) {}
        return pls;
    }
	
    /**
     * Deserializa un modulo logico
     * @param rs es un resultset que contiene el objeto a deserializar
     * @return el modulo logico deserializado.
     */
    public Object deserializeModule(ResultSet rs) {
        Object obj = new Object();
        try {
            byte tmp[] = rs.getBytes("SERIALMODULE");
            ByteArrayInputStream bais = new ByteArrayInputStream(tmp);
            ObjectInputStream ois = new ObjectInputStream(bais); 
            obj = ois.readObject();
        } catch (IOException e) {} catch (Exception e) {}
        return obj;
    }

}	
