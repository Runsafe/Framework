package no.runsafe.framework.minecraft.player;

import com.google.common.collect.ImmutableList;
import no.runsafe.framework.api.IWorld;
import no.runsafe.framework.api.hook.IPlayerExtensions;
import no.runsafe.framework.api.player.IFakePlayer;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
import no.runsafe.framework.internal.wrapper.entity.BukkitEntity;
import org.bukkit.entity.Entity;

import javax.annotation.Nonnull;

public class RunsafeFakePlayer extends RunsafePlayer implements IFakePlayer
{
	public RunsafeFakePlayer(String playerName, String... groups)
	{
		super(null);
		this.playerName = playerName;
		this.groups = ImmutableList.copyOf(groups);
	}

	@Override
	public boolean hasPermission(String permission)
	{
		return InjectionPlugin.getGlobalComponent(IPlayerExtensions.class).hasPermission(this, groups, permission);
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
	public boolean shouldNotSee(@Nonnull IPlayer target)
	{
		return false;
	}

	@Override
	public void sendMessage(String message)
	{
	}

	@SuppressWarnings("ReturnOfCollectionOrArrayField")
	@Override
	public ImmutableList<String> getGroups()
	{
		return groups;
	}

	@Override
	public IWorld getWorld()
	{
		return world;
	}

	@Override
	public void setWorld(IWorld world)
	{
		this.world = world;
	}

	@Override
	public boolean equals(Object o)
	{
		if (this == o)
			return true;

		if(o == null)
			return false;

		if(o instanceof RunsafeFakePlayer)
			return this.playerName.equals(((RunsafeFakePlayer) o).getName());

		return false;
	}

	@Override
	public int hashCode()
	{
		return playerName.hashCode();
	}

	private final ImmutableList<String> groups;
	private boolean isOp;
	private IWorld world;
}
