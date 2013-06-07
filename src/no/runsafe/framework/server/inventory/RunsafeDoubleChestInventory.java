package no.runsafe.framework.server.inventory;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.block.RunsafeDoubleChest;
import org.bukkit.inventory.DoubleChestInventory;

public class RunsafeDoubleChestInventory
{
	public RunsafeDoubleChestInventory(DoubleChestInventory toWrap)
	{
		this.doubleChestInventory = toWrap;
	}

	public RunsafeInventory getLeftSide()
	{
		return ObjectWrapper.convert(this.doubleChestInventory.getLeftSide());
	}

	public RunsafeInventory getRightSide()
	{
		return ObjectWrapper.convert(this.doubleChestInventory.getRightSide());
	}

	public RunsafeDoubleChest getHolder()
	{
		return ObjectWrapper.convert(this.doubleChestInventory.getHolder());
	}

	private final DoubleChestInventory doubleChestInventory;
}
