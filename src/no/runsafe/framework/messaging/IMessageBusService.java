package no.runsafe.framework.messaging;

public interface IMessageBusService
{
	public String getServiceName();
	public Response processMessage(Message message);
}
