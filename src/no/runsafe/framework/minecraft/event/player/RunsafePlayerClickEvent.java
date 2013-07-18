package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.event.player.PlayerInteractEvent;

public class RunsafePlayerClickEvent extends RunsafeCancellablePlayerEvent
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

	public RunsafeMeta getItemStack()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	private final PlayerInteractEvent event;
}
