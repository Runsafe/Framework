package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.BrewingStand;

public abstract class BukkitBrewingStand extends RunsafeBlockState implements IInventoryHolder
{
	protected BukkitBrewingStand(BrewingStand toWrap)
	{
		super(toWrap);
		stand = toWrap;
	}

	public int getBrewingTime()
	{
		return stand.getBrewingTime();
	}

	public void setBrewingTime(int i)
	{
		stand.setBrewingTime(i);
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(stand.getInventory());
	}

	protected final BrewingStand stand;
}
