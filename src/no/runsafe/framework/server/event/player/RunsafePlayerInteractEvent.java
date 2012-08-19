package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.event.CancellableEvent;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RunsafePlayerInteractEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafePlayerInteractEvent(PlayerInteractEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public Action getAction()
	{
		return event.getAction();
	}

	public RunsafeBlock getBlock()
	{
		return ObjectWrapper.convert(event.getClickedBlock());
	}

	public ItemStack getItemStack()
	{
		return event.getItem();
	}

	public void removeItemStack()
	{
		event.getPlayer().getInventory().remove(event.getItem());
	}

	public RunsafeLocation getTargetBlock()
	{
		BlockFace face = event.getBlockFace();
		RunsafeLocation target = new RunsafeLocation(
			getBlock().getWorld(),
			event.getClickedBlock().getX() + face.getModX(),
			event.getClickedBlock().getY() + face.getModY(),
			event.getClickedBlock().getZ() + face.getModZ()
		);
		return target;
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

	private final PlayerInteractEvent event;
}
