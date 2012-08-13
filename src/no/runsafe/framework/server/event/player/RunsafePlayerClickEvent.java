package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.item.RunsafeItemStack;
import org.bukkit.event.player.PlayerInteractEvent;

public class RunsafePlayerClickEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafePlayerClickEvent(PlayerInteractEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeBlock getBlock()
	{
		return ObjectWrapper.convert(event.getClickedBlock());
	}

	public RunsafeItemStack getItemStack()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	@Override
	public boolean getCancelled()
	{
		return event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		event.setCancelled(cancel);
	}

	PlayerInteractEvent event;
}
