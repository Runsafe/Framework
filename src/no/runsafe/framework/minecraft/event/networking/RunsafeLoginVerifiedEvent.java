package no.runsafe.framework.minecraft.event.networking;

public class RunsafeLoginVerifiedEvent extends RunsafeNetworkEvent
{
	public RunsafeLoginVerifiedEvent(String playerName)
	{
		this.playerName = playerName;
	}

	public String getPlayerName()
	{
		return playerName;
	}

	public void setPlayerName(String newName)
	{
		playerName = newName;
	}

	private String playerName;
}
