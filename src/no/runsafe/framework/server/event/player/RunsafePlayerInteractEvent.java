package no.runsafe.framework.server.event.player;

import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.block.RunsafeBlock;
import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.item.meta.RunsafeMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RunsafePlayerInteractEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafePlayerInteractEvent(PlayerInteractEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public boolean isRightClick()
	{
		return event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR;
	}

	public boolean isLeftClick()
	{
		return event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.LEFT_CLICK_AIR;
	}

	public boolean hasItem()
	{
		return this.event.hasItem();
	}

	public Item getMaterial()
	{
		return Item.get(this.event.getMaterial(), (byte) 0);
	}

	public boolean hasBlock()
	{
		return this.event.hasBlock();
	}

	public boolean isBlockInHand()
	{
		return this.event.isBlockInHand();
	}

	public RunsafeBlock getBlock()
	{
		return ObjectWrapper.convert(event.getClickedBlock());
	}

	public RunsafeMeta getItemStack()
	{
		return ObjectWrapper.convert(event.getItem());
	}

	public void removeItemStack()
	{
		event.getPlayer().getInventory().remove(event.getItem());
	}

	public RunsafeLocation getTargetBlock()
	{
		BlockFace face = event.getBlockFace();
		return new RunsafeLocation(
			getBlock().getWorld(),
			event.getClickedBlock().getX() + face.getModX(),
			event.getClickedBlock().getY() + face.getModY(),
			event.getClickedBlock().getZ() + face.getModZ()
		);
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
