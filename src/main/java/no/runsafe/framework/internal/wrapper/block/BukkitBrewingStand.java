package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;

public abstract class BukkitBrewingStand extends BukkitBlockState implements IInventoryHolder
{
	protected BukkitBrewingStand(Block toWrap, BrewingStand state)
	{
		super(toWrap, state);
		stand = (BrewingStand) toWrap.getState();
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
