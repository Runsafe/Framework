package no.runsafe.framework.server.player;

import no.runsafe.framework.hook.HookEngine;
import no.runsafe.framework.hook.IPlayerPermissions;
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
	public boolean hasPermission(String permission)
	{
		List<String> groups = getGroups();
		for (IPlayerPermissions hook : HookEngine.hookContainer.getComponents(IPlayerPermissions.class))
		{
			List<String> permissions = hook.getPlayerPermissions(this);
			if (permissions != null && permissions.contains(permission))
				return true;

			for (String group : groups)
			{
				if (group == null)
					continue;
				permissions = hook.getGroupPermissions(group);
				if (permissions != null && permissions.contains(permission))
					return true;
			}
		}
		return false;
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
	private final List<String> groups = new ArrayList<String>();
	private boolean isOp;
	private RunsafeWorld world;
}
