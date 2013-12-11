package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;

public abstract class BukkitHopper extends BukkitBlockState implements IInventoryHolder
{
	protected BukkitHopper(Block toWrap, Hopper state)
	{
		super(toWrap, state);
		hopper = state;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(hopper.getInventory());
	}

	protected final Hopper hopper;
}
