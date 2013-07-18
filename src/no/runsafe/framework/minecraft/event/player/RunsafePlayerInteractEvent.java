package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.Item;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.block.RunsafeBlock;
import no.runsafe.framework.minecraft.item.meta.RunsafeMeta;
import org.bukkit.block.BlockFace;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class RunsafePlayerInteractEvent extends RunsafeCancellablePlayerEvent
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

	private final PlayerInteractEvent event;
}
