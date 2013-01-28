/*
 * $Basename: ResultSetIterator.java $ $Revision: 1.1 $ $ProjectDate: 17 May 2002
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
import java.util.*;
import JavaLog.*;

/**
 * ResultSetIterator - Iterador sobre un ResultSet.
 * No mantiene ningun objeto en memoria, los trae a memoria 
 * desde la base de datos, a medida que los necesita. 
 * @author Mario Cañete - Gomez Mariano - UNICEN
 * @version $Revision: 1.1 $ $ProjectDate: 17 May 2002
 */
public class ResultSetIterator implements Enumeration {
    private ResultSet rs;
    private boolean flag, empty;
    private PlStruct current = null;
    /**
     * Constructor
     * @param rs un ResultSet que va a ser iterado
     */
    ResultSetIterator(ResultSet r) {
        rs = r;
        if (rs == null) return;
        try { 
            if (rs.next()) {
                flag = false;
                empty = false;
            } else {
                flag = true;
                empty = true;
            }	  
        } catch (SQLException e) {}
    }	 
	 
    /**
     * dice si la enumeracion tiene o no elementos
     * 
     * @return <CODE>true</CODE> si rs tiene  elementos.
     */
    public boolean hasMoreElements() {
        if (rs == null) return false;
        if ((flag == false) && (!empty)) return true;
        flag = false;
        try {
            empty = !(rs.next());
            return (!empty);
        } catch (SQLException e) {}
        return false;

    }
	 
    /**
     * devuelve el proximo elemento en la enumeracion
     * @return elelemento actual del rs
     */
    public Object nextElement() {
        PlStruct pls = null;
        Seriate seriate = new Seriate();
        if (hasMoreElements()) {
            flag = true;
            pls = seriate.deserialize(rs);
        }
        current = pls;
        return pls;
    }
   
    public Object get() {
        return current;
    }	  
}   	  
