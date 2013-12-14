package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.IFakeableEvent;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDeathEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.entity.PlayerDeathEvent;

public class RunsafePlayerDeathEvent extends RunsafeEntityDeathEvent implements IFakeableEvent
{
	public RunsafePlayerDeathEvent(PlayerDeathEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public void setDeathMessage(String deathMessage)
	{
		event.setDeathMessage(deathMessage);
	}

	public String getDeathMessage()
	{
		return event.getDeathMessage();
	}

	public int getNewExp()
	{
		return event.getNewExp();
	}

	public void setNewExp(int exp)
	{
		event.setNewExp(exp);
	}

	public int getNewLevel()
	{
		return event.getNewLevel();
	}

	public void setNewLevel(int level)
	{
		event.setNewLevel(level);
	}

	public int getNewTotalExp()
	{
		return event.getNewTotalExp();
	}

	public void setNewTotalExp(int totalExp)
	{
		event.setNewTotalExp(totalExp);
	}

	public boolean getKeepLevel()
	{
		return event.getKeepLevel();
	}

	public void setKeepLevel(boolean keepLevel)
	{
		event.setKeepLevel(keepLevel);
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public boolean Fire()
	{
		isFake = true;
		for (IPlayerDeathEvent listener : RunsafePlugin.getAllPluginComponents(IPlayerDeathEvent.class))
			listener.OnPlayerDeathEvent(this);
		return true;
	}

	@Override
	public RunsafePlayer getEntity()
	{
		return ObjectWrapper.convert((OfflinePlayer) event.getEntity());
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	private final PlayerDeathEvent event;
	private boolean isFake;
}
