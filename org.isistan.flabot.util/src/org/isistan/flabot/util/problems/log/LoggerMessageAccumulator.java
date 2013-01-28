package org.isistan.flabot.util.problems.log;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.Plugin;
import org.isistan.flabot.util.log.DefaultLogStatusCodes;
import org.isistan.flabot.util.log.EclipsePlatformLogger;
import org.isistan.flabot.util.problems.Message;
import org.isistan.flabot.util.problems.MessageAccumulator;
import org.isistan.flabot.util.problems.MessageSeverity;
import org.slf4j.Logger;

public class LoggerMessageAccumulator extends MessageAccumulator {
	
	private Map<Plugin, Logger> loggers=new HashMap<Plugin, Logger>();
	
	@Override
	public void addMessage(Message message) {
		super.addMessage(message);
		log(message);
	}

	private void log(Message message) {
		Logger logger=getLogger(message.getPlugin(), message.getPluginId());
		if(message.getSeverity()==MessageSeverity.ERROR) {
			logger.error(message.getTitle() + ": " + message.getDescription(), message.getCause());
		} else if(message.getSeverity()==MessageSeverity.WARNING) {
			logger.warn(message.getTitle() + ": " + message.getDescription(), message.getCause());
		} else if(message.getSeverity()==MessageSeverity.INFORMATION) {
			logger.info(message.getTitle() + ": " + message.getDescription(), message.getCause());
		} else {
			logger.info(message.getTitle() + ": " + message.getDescription(), message.getCause());
		}
	}

	private Logger getLogger(Plugin generator, String pluginId) {
		Logger logger=loggers.get(generator);
		if(logger==null) {
			logger=new EclipsePlatformLogger(generator,
					pluginId,
					DefaultLogStatusCodes.getInstance());
			loggers.put(generator, logger);
		}
		return logger;
	}

}
