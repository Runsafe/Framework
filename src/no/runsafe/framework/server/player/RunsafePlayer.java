package no.runsafe.framework.server.player;

import no.runsafe.framework.server.RunsafeWorld;

import org.bukkit.entity.Player;

public class RunsafePlayer {
	
	public RunsafePlayer(Player toWrap)
	{
		player = toWrap;
	}
	
	public String getName()
	{
		return player.getName();
	}
	
	public RunsafeWorld getWorld()
	{
		return new RunsafeWorld(player.getWorld());
	}

    public Player getRaw()
    {
        return this.player;
    }
	
	private Player player;
}
