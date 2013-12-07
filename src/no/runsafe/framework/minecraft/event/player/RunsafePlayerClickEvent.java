package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.event.player.PlayerInteractEvent;

public class RunsafePlayerClickEvent extends RunsafeCancellablePlayerEvent
{
	public RunsafePlayerClickEvent(PlayerInteractEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public IBlock getBlock()
	{
		return ObjectWrapper.convert(event.getClickedBlock());
	}

	public RunsafeMeta getItemStack()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	private final PlayerInteractEvent event;
}
