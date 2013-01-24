package no.runsafe.framework.messaging;

import java.util.List;

@Deprecated
public interface IMessagePump
{
	public void RegisterService(IMessageBusService service);
	public void UnregisterService(IMessageBusService service);
	public Response HandleMessage(Message message);
	public List<Response> HandleMessageAll(Message message);
}
