/**

import java.util.LinkedList;
	
	List<Message> messages=new LinkedList<Message>();
	
	public void addMessage(Message problem) {
		messages.add(problem);
	}
	
	public Message[] getMessages(MessageSeverity minMessageSeverity, MessageSeverity maxMessageSeverity) {
		List<Message> matchingProblems=new LinkedList<Message>();
		for (Message message : messages) {
			if(message.getSeverity().compareTo(minMessageSeverity)>=0
					&& message.getSeverity().compareTo(maxMessageSeverity)<=0) {
				matchingProblems.add(message);
			}
		}
		return messages.toArray(new Message[messages.size()]);
	}

	
	public Message[] getMessages() {
		return getMessages(Enum.getMinimum(MessageSeverity.class), Enum.getMaximum(MessageSeverity.class));
	}

	public boolean areMessages(MessageSeverity minMessageSeverity, MessageSeverity maxMessageSeverity) {
		for (Message problem : messages) {
			if(problem.getSeverity().compareTo(minMessageSeverity)>=0
					&& problem.getSeverity().compareTo(maxMessageSeverity)<=0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean areMessages() {
		return areMessages(Enum.getMinimum(MessageSeverity.class), Enum.getMaximum(MessageSeverity.class));
	}
	
	@Override
		StringBuffer string=new StringBuffer("Messages:\n");
		for (Message message : messages) {
			string.append(message);
			string.append('\n');
		}
		return string.toString();
	}
}