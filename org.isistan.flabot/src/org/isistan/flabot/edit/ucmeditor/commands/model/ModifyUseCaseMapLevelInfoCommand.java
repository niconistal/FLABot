/**
 * $Id: ModifyUseCaseMapLevelInfoCommand.java,v 1.1 2006/03/09 21:37:23 franco Exp $
 * $Author: franco $
 */
package org.isistan.flabot.edit.ucmeditor.commands.model;

import java.util.Iterator;
import java.util.List;

import org.eclipse.gef.commands.CompoundCommand;
import org.isistan.flabot.coremodel.CoreModel;
import org.isistan.flabot.coremodel.StubNode;
import org.isistan.flabot.coremodel.UseCaseMap;

/**
 * @author $Author: franco $
 *
 */
public class ModifyUseCaseMapLevelInfoCommand extends CompoundCommand {

	private CoreModel coreModel;
	private UseCaseMap useCaseMap;
	
	public ModifyUseCaseMapLevelInfoCommand(CoreModel coreModel, UseCaseMap ucm) {
		this.coreModel = coreModel;
		this.useCaseMap = ucm;
	}
	
	public boolean canUndo() {
		return true;
	}
	
	public boolean canExecute() {
		return (coreModel != null);
	}
	
	public void execute() {
		if (useCaseMap.getLevelInfo().equals(UseCaseMap.architecturalLevel)) {
			List stubs = coreModel.getStubs();
			for (Iterator iter= stubs.iterator(); iter.hasNext(); ){
				StubNode stub = (StubNode)iter.next();	
				if (stub.getReferencedMap().equals(useCaseMap))
					add( new DeleteStubFromCoreModelCommand(coreModel, stub));
			}
		}
		
		if (useCaseMap.getLevelInfo().equals(UseCaseMap.functionalLevel)) {
			List stubs = coreModel.getStubs();
			for (Iterator iter= stubs.iterator(); iter.hasNext(); ){
				StubNode stub = (StubNode)iter.next();	
				if (stub.getReferencedMap().equals(useCaseMap))
					add (new DeleteAssociatedNodeFromFamilyCommand(stub.getFamily(), stub));
			}
		}
		super.execute();
		
		redo();
	}
}