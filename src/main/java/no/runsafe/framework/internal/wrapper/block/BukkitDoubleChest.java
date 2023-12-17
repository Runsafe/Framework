package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.DoubleChest;

public abstract class BukkitDoubleChest implements IInventoryHolder
{
	protected BukkitDoubleChest(DoubleChest toWrap)
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

	public ILocation getLocation()
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

	protected final DoubleChest chest;
}
