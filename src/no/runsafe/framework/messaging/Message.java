package no.runsafe.framework.messaging;

import no.runsafe.framework.server.player.RunsafePlayer;

public class Message
{
	public String getTargetService()
	{
		return targetServiceName;
	}

	public void setTargetService(String name)
	{
		targetServiceName = name;
	}

	public String getQuestion()
	{
		return message;
	}

	public void setQuestion(String message)
	{
		this.message = message;
	}

	public RunsafePlayer getPlayer()
	{
		return player;
	}

	public void setPlayer(RunsafePlayer player)
	{
		this.player = player;
	}

	private String targetServiceName;
	private String message;
	private RunsafePlayer player;
}
