package no.runsafe.framework.server.player;

import no.runsafe.framework.server.RunsafeLocation;
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

	public float getXP()
	{
		return player.getExp();
	}

	public void setXP(float points)
	{
		player.setExp(points);
	}

	public int getLevel()
	{
		return player.getLevel();
	}

	public void setLevel(int level)
	{
		player.setLevel(level);
	}

    public void setFallDistance(float distance)
    {
        player.setFallDistance(distance);
    }

    public void teleport(RunsafeLocation location)
    {
        player.teleport(location.getRaw());
    }

    public void sendMessage(String message)
    {
        player.sendMessage(message);
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
