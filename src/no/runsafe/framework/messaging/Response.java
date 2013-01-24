package no.runsafe.framework.messaging;

@Deprecated
public class Response
{
	public String getSourceService()
	{
		return sourceServiceName;
	}

	public void setSourceService(String service)
	{
		sourceServiceName = service;
	}

	public String getResponse()
	{
		return responseMessage;
	}

	public void setResponse(String response)
	{
		responseMessage = response;
	}

	public MessageBusStatus getStatus()
	{
		return messageStatus;
	}

	public void setStatus(MessageBusStatus status)
	{
		this.messageStatus = status;
	}

	private String sourceServiceName;
	private String responseMessage;
	private MessageBusStatus messageStatus;
}
