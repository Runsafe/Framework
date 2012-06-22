package no.runsafe.framework.messaging;

import no.runsafe.framework.server.player.RunsafePlayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayerStatus
{
	public PlayerStatus(IMessagePump pump)
	{
		messagePump = pump;
	}

	public boolean getVisibility(RunsafePlayer player)
	{
		Message question = new Message();
		question.setTargetService("PlayerStatus");
		question.setQuestion("get.player.invisibility.on");
		question.setPlayer(player);
		List<Response> response = messagePump.HandleMessageAll(question);
		return IsAny(response, MessageBusStatus.OK);
	}

	public void setVisibility(RunsafePlayer player, boolean visible)
	{
		Message question = new Message();
		question.setTargetService("PlayerStatus");
		if (visible)
			question.setQuestion("set.player.invisibility.off");
		else
			question.setQuestion("set.player.invisibility.on");
		question.setPlayer(player);
		messagePump.HandleMessageAll(question);
	}

	public boolean getInPVPZone(RunsafePlayer player)
	{
		Message question = new Message();
		question.setTargetService("WorldGuardBridge");
		question.setQuestion("PLAYER_IN_PVP_ZONE");
		question.setPlayer(player);
		List<Response> response = messagePump.HandleMessageAll(question);
		return IsAny(response, MessageBusStatus.OK);
	}

	public List<String> getCurrentRegions(RunsafePlayer player)
	{
		Message question = new Message();
		question.setTargetService("WorldGuardBridge");
		question.setQuestion("PLAYER_IN_REGION");
		question.setPlayer(player);
		List<Response> response = messagePump.HandleMessageAll(question);

		if (response == null || response.size() == 0)
			return null;

		ArrayList<String> regions = new ArrayList<String>();
		for (Response answer : response)
			if (answer.getStatus() == MessageBusStatus.OK)
				Collections.addAll(regions, answer.getResponse().split(";"));

		return regions;
	}

	protected boolean IsAny(List<Response> responses, MessageBusStatus status)
	{
		if (responses == null || responses.size() == 0)
			return false;

		for (Response response : responses)
			if (response.getStatus() == status)
				return true;

		return false;
	}

	protected boolean IsAll(List<Response> responses, MessageBusStatus status)
	{
		if (responses == null || responses.size() == 0)
			return false;

		for (Response response : responses)
			if (response.getStatus() != status)
				return false;

		return true;
	}

	private final IMessagePump messagePump;
}
