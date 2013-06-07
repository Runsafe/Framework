package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.Chest;

public class BukkitChest extends RunsafeBlockState implements IInventoryHolder
{
	public BukkitChest(Chest toWrap)
	{
		super(toWrap);
		chest = toWrap;
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(chest.getBlockInventory());
	}

	public RunsafeInventory getBlockInventory()
	{
		return getInventory();
	}

	@Override
	public Chest getRaw()
	{
		return chest;
	}

	protected final Chest chest;
}
