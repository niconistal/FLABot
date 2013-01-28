/** * $Id: InterfacePrologCode.java,v 1.8 2006/02/09 23:07:39 franco Exp $ * $Author: franco $ */package org.isistan.flabot.coremodel;

import java.util.Vector;import org.eclipse.emf.ecore.EObject;public interface InterfacePrologCode extends EObject {
	
	
	Vector getPrologCode (Object value);

}
