package no.runsafe.framework.minecraft.player;

import no.runsafe.framework.internal.HookEngine;
import no.runsafe.framework.api.hook.IPlayerPermissions;
import no.runsafe.framework.minecraft.RunsafeWorld;

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
	public boolean isNotBanned()
	{
		return true;
	}

	@Override
	public boolean isVanished()
	{
		return false;
	}

	@Override
	public boolean shouldNotSee(RunsafePlayer target)
	{
		return false;
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
