package no.runsafe.framework.minecraft.event.player;

import net.minecraft.server.v1_12_R1.EntityPlayer;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.IFakeableEvent;
import no.runsafe.framework.api.event.player.IPlayerDeathEvent;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDeathEvent;
import no.runsafe.framework.internal.extension.player.RunsafePlayer;
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

	public int getLevelAmount()
	{
		EntityPlayer entity = ObjectUnwrapper.getMinecraft(getEntity());
		return entity == null ? 0 : entity.oldLevel;
	}

	public void setNewLevelAmount(int level)
	{
		EntityPlayer entity = ObjectUnwrapper.getMinecraft(getEntity());
		if (entity == null)
			return;
		entity.expLevel = level;
	}

	private final PlayerDeathEvent event;
	private boolean isFake;
}
