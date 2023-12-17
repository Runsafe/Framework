package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.entity.RunsafeItem;
import org.bukkit.event.player.PlayerDropItemEvent;

public class RunsafePlayerDropItemEvent extends RunsafeCancellablePlayerEvent
{
	public RunsafePlayerDropItemEvent(PlayerDropItemEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public RunsafeItem getItem()
	{
		return ObjectWrapper.convert(event.getItemDrop());
	}

	private final PlayerDropItemEvent event;
}
