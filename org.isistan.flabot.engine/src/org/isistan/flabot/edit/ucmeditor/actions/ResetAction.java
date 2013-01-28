/**

import java.util.HashMap;
	
	public static final String
		RESET = "RESET";   //$NON-NLS-1$

	public ResetAction(IWorkbenchPart part) {
		super(part);

		setText(Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.ResetAction.text")); //$NON-NLS-1$
		setId(RESET);
	}	
	
	@Override
		return canPerformAction();
	}
	
	private boolean canPerformAction() {
		if (getSelectedObjects().isEmpty())
			return false;
		List parts = getSelectedObjects();
		
		if (parts.size() > 1) 
			return false;
		
		Object o = parts.get(0);
		if (!(o instanceof PathNodeEditPart))
			return false;
		
		PathNodeEditPart part = (PathNodeEditPart)o;
		if (!(part.getSemanticModel() instanceof ResponsibilityNode))
			return false;
		return true;
	}

	@Override
		List editparts = getSelectedObjects();
		PathNodeEditPart part = (PathNodeEditPart)editparts.get(0);		
		CoreModel coreModel = visualNode.getDiagram().getCoreModel();
		
		ResponsibilityNode responsibilityNode =
			(ResponsibilityNode)part.getSemanticModel();
		// obtain the flabot file model parameter
		FlabotFileModel flabotFileModel = responsibilityNode.getMap()
			.getCoreModel().getFile();
		// add the file model to the parameters map
		Map parameters = new HashMap(2);
		// obtain a reference to the component locator manager
		ComponentLocatorManager locatorManager =
			FlabotPlugin.getDefault().getComponentLocatorManager();
		try {
			// ask the locator manager to find a runtime manager reference
			RuntimeManager runtimeManager = (RuntimeManager)
				locatorManager.getComponent(FlabotEngineLocator.LOCATOR_ID,
						parameters);
			// finally, reset the runtime manager
			runtimeManager.reset(coreModel);
		} catch (ComponentLocatorException e) {
			EnginePlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.ResetAction.componentLocatorError"), e); //$NON-NLS-1$
		} catch (Exception e) {
			EnginePlugin.getDefault().getLogger().error(
					Messages.getString("org.isistan.flabot.edit.ucmeditor.actions.ResetAction.exceptionError"), e); //$NON-NLS-1$
		}
	}
}