package no.runsafe.framework.server.event.inventory;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class RunsafeInventoryCloseEvent extends RunsafeInventoryEvent
{
	public RunsafeInventoryCloseEvent(InventoryCloseEvent toWrap)
	{
		super(toWrap);
		this.event = toWrap;
	}

	public RunsafePlayer getPlayer()
	{
		return ObjectWrapper.convert(this.event.getPlayer());
	}

	private final InventoryCloseEvent event;
}
