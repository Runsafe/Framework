package no.runsafe.framework.messaging;

@Deprecated
public interface IMessageBusService
{
	String getServiceName();

	Response processMessage(Message message);
}
