package no.runsafe.framework.player;

import no.runsafe.framework.world.RunsafeWorld;

import org.bukkit.entity.Player;

public class RunsafePlayer {
	
	public RunsafePlayer(Player toWrap)
	{
		bukkitPlayer = toWrap;
	}
	
	public String getName()
	{
		return bukkitPlayer.getName();
	}
	
	public RunsafeWorld getWorld()
	{
		return new RunsafeWorld(bukkitPlayer.getWorld());
	}

	public Player getRaw()
	{
		return bukkitPlayer;
	}
	
	private Player bukkitPlayer;
}
