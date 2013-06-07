package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.block.DoubleChest;

public class RunsafeDoubleChest implements IInventoryHolder
{
	public RunsafeDoubleChest(DoubleChest toWrap)
	{
		chest = toWrap;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return new RunsafeInventory(chest.getInventory());
	}

	public IInventoryHolder getLeftSide()
	{
		return new IInventoryHolder()
		{
			@Override
			public RunsafeInventory getInventory()
			{
				return ObjectWrapper.convert(chest.getLeftSide().getInventory());
			}
		};
	}

	public RunsafeLocation getLocation()
	{
		return ObjectWrapper.convert(chest.getLocation());
	}

	public IInventoryHolder getRightSide()
	{
		return new IInventoryHolder()
		{
			@Override
			public RunsafeInventory getInventory()
			{
				return ObjectWrapper.convert(chest.getRightSide().getInventory());
			}
		};
	}

	public double getX()
	{
		return chest.getX();
	}

	public double getY()
	{
		return chest.getY();
	}

	public double getZ()
	{
		return chest.getZ();
	}

	public DoubleChest getRaw()
	{
		return chest;
	}

	private final DoubleChest chest;
}
