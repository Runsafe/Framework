package no.runsafe.framework.messaging;

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
		return response;
	}

	public void setResponse(String response)
	{
		this.response = response;
	}

	public MessageBusStatus getStatus()
	{
		return status;
	}

	public void setStatus(MessageBusStatus status)
	{
		this.status = status;
	}

	private String sourceServiceName;
	private String response;
	private MessageBusStatus status;
}
