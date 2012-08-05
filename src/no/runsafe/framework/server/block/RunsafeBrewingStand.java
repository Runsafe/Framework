package no.runsafe.framework.server.block;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.block.BrewingStand;

public class RunsafeBrewingStand extends RunsafeBlockState implements IInventoryHolder
{
	public RunsafeBrewingStand(BrewingStand toWrap)
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

	// TODO replace inventory class
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(stand.getInventory());
	}

	private final BrewingStand stand;
}
