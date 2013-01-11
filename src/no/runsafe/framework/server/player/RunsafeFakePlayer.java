package no.runsafe.framework.server.player;

import no.runsafe.framework.server.RunsafeWorld;

import java.util.ArrayList;
import java.util.List;

public class RunsafeFakePlayer extends RunsafePlayer
{
	public RunsafeFakePlayer(String playerName)
	{
		super(null);
		name = playerName;
	}

	@Override
	public String getName()
	{
		return name;
	}

	@Override
	public boolean isOnline()
	{
		return true;
	}

	@Override
	public boolean isOP()
	{
		return isOp;
	}

	@Override
	public void OP()
	{
		isOp = true;
	}

	@Override
	public void deOP()
	{
		isOp = false;
	}

	@Override
	public boolean isBanned()
	{
		return false;
	}

	@Override
	public boolean isVanished()
	{
		return false;
	}

	@Override
	public boolean canSee(RunsafePlayer target)
	{
		return true;
	}

	@Override
	public void sendMessage(String message)
	{
	}

	@Override
	public List<String> getGroups()
	{
		return groups;
	}

	@Override
	public RunsafeWorld getWorld()
	{
		return world;
	}

	public void setWorld(RunsafeWorld world)
	{
		this.world = world;
	}

	private final String name;
	private boolean isOp;
	private List<String> groups = new ArrayList<String>();
	private RunsafeWorld world;
}
