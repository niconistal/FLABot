package org.isistan.flabot.launcher.filter;

import org.eclipse.gef.commands.Command;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.isistan.flabot.coremodel.Responsibility;
import org.isistan.flabot.edit.componenteditor.dialogs.responsibility.ResponsibilityEditionItem;
import org.isistan.flabot.gauge.Gauge;
import org.isistan.flabot.launcher.filter.filtermodel.FiltermodelFactory;
import org.isistan.flabot.launcher.filter.filtermodel.LogFilter;
import org.isistan.flabot.launcher.messages.Messages;
import org.isistan.flabot.util.edition.EditionItemStatus;
import org.isistan.flabot.util.edition.tab.EditionTabItemImpl;
import org.isistan.flabot.util.enums.Enum;

/**
 * Edits the settings referring to the type of gauges that should be collected
 * @author da Costa Cambio
 *
 */
public class LogFilterEditionItem extends EditionTabItemImpl<Responsibility>
		implements ResponsibilityEditionItem {

	private Composite control;
	private LogFilter logFilter;
	@Override
	public void initialize(TabFolder tabFolder, TabItem tabItem, Responsibility responsibility) {
		control=new Composite(tabFolder, SWT.NONE);
		
		GridLayout layout = new GridLayout(1, false);
		layout.verticalSpacing = 1;
		layout.horizontalSpacing = 1;
		control.setLayout(layout);
		
		tabItem.setText("Collection");
		
		logFilter=LogFilterManager.getLogFilter(responsibility);
		if(logFilter==null) {
			logFilter=FiltermodelFactory.eINSTANCE.createLogFilter();
			LogFilterManager.setLogFilter(responsibility, logFilter);
		}
		createCheckboxes();
	}

	public void activate() {
		
	}

	private Button[] optionButtons;
	private boolean[] oldSelectedOptions;
	private Enum[] options;
	private void createCheckboxes() {
		options=Enum.getOptions(Gauge.Type.class);
		optionButtons=new Button[options.length];
		oldSelectedOptions=new boolean[options.length];
		for (int i=0; i< options.length; i++) {
			Gauge.Type option= (Gauge.Type)options[i];
			Button optionButton=optionButtons[i]=new Button(control, SWT.CHECK);
			String text=Messages.getString("org.isistan.flabot.launcher.filter.LogFilterEditionItem.log",
					Messages.getString("org.isistan.flabot.launcher.filter.LogFilterEditionItem." + option.getName()));
			optionButton.setText(text);
			oldSelectedOptions[i]=logFilter.isGaugeType(option);
			optionButton.setSelection(oldSelectedOptions[i]);
		}
		Label label=new Label(control, SWT.CHECK);
		label=new Label(control, SWT.CHECK);
		label.setText(Messages.getString("org.isistan.flabot.launcher.filter.LogFilterEditionItem.someOptionsMayBeUnavailable"));
	}

	@Override
	public Control getControl() {
		return control;
	}

	public boolean canCreateCommand() {
		return true;
	}

	public EditionItemStatus getStatus() {
		return EditionItemStatus.DEFAULT_OK;
	}

	public Command getCommand() {
		final boolean[] newSelectedOptions=new boolean[options.length];
		for (int i = 0; i < newSelectedOptions.length; i++) {
			newSelectedOptions[i]=optionButtons[i].getSelection();
		}
		return new Command("Responsibility Log Filter Edition") {
			@Override
			public void execute() {
				for (int i = 0; i < options.length; i++) {
					logFilter.setGaugeType((Gauge.Type) options[i], newSelectedOptions[i]);
				}
			}
			
			@Override
			public void undo() {
				for (int i = 0; i < options.length; i++) {
					logFilter.setGaugeType((Gauge.Type) options[i], oldSelectedOptions[i]);
				}	
			}
		};
	}

	public boolean accepts(Responsibility element) {
		return true;
	}
	

}
