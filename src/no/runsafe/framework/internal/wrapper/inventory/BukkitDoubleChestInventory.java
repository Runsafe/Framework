package no.runsafe.framework.internal.wrapper.inventory;

import no.runsafe.framework.minecraft.block.RunsafeDoubleChest;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.inventory.DoubleChestInventory;

public abstract class BukkitDoubleChestInventory extends RunsafeInventory
{
	protected BukkitDoubleChestInventory(DoubleChestInventory toWrap)
	{
		super(toWrap);
		doubleChestInventory = toWrap;
	}

	public RunsafeInventory getLeftSide()
	{
		return ObjectWrapper.convert(doubleChestInventory.getLeftSide());
	}

	public RunsafeInventory getRightSide()
	{
		return ObjectWrapper.convert(doubleChestInventory.getRightSide());
	}

	@Override
	public RunsafeDoubleChest getHolder()
	{
		return ObjectWrapper.convert(doubleChestInventory.getHolder());
	}

	@Override
	public DoubleChestInventory getRaw()
	{
		return doubleChestInventory;
	}

	protected final DoubleChestInventory doubleChestInventory;
}
