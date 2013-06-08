package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.BrewingStand;

public abstract class BukkitBrewingStand extends RunsafeBlockState implements IInventoryHolder
{
	public BukkitBrewingStand(BrewingStand toWrap)
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

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(stand.getInventory());
	}

	@Override
	public BrewingStand getRaw()
	{
		return stand;
	}

	protected final BrewingStand stand;
}
