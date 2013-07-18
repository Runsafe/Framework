package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.Hopper;

public abstract class BukkitHopper extends RunsafeBlockState implements IInventoryHolder
{
	protected BukkitHopper(Hopper toWrap)
	{
		super(toWrap);
		hopper = toWrap;
	}

	@Override
	public Hopper getRaw()
	{
		return hopper;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(hopper.getInventory());
	}

	protected final Hopper hopper;
}
