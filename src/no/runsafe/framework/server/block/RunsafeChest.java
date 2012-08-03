package no.runsafe.framework.server.block;

import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.block.Chest;

public class RunsafeChest extends RunsafeBlockState implements IInventoryHolder
{
	public RunsafeChest(Chest toWrap)
	{
		super(toWrap);
		chest = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return new RunsafeInventory(chest.getBlockInventory());
	}

	public RunsafeInventory getBlockInventory()
	{
		return getInventory();
	}

	private final Chest chest;
}
