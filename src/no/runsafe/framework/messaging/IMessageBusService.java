package no.runsafe.framework.messaging;

public interface IMessageBusService {
	String getServiceName();

	Response processMessage(Message message);
}
