package no.runsafe.framework.player;

import no.runsafe.framework.world.RunsafeWorld;

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
