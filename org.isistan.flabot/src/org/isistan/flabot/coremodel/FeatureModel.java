/** * $Id: FeatureModel.java,v 1.6 2006/03/27 22:46:30 franco Exp $ * $Author: franco $ */package org.isistan.flabot.coremodel;
import org.eclipse.emf.common.util.EList;/**
 * @model
 */
public interface FeatureModel extends NamedElementModel, ExtensibleElement {		/**	 * The componenets providing this feature	 * @model type="ComponentModel" opposite="features"	 */	EList getComponents();
}
