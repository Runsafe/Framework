package no.runsafe.framework.messaging;

public interface IMessagePump
{
	public void RegisterService(IMessageBusService service);
	public void UnregisterService(IMessageBusService service);
	public Response HandleMessage(Message message);
}
