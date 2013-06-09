package no.runsafe.framework.wrapper.inventory;

import no.runsafe.framework.server.block.RunsafeDoubleChest;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.DoubleChestInventory;

public abstract class BukkitDoubleChestInventory extends RunsafeInventory
{
	public BukkitDoubleChestInventory(DoubleChestInventory toWrap)
	{
		super(toWrap);
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

	@Override
	public DoubleChestInventory getRaw()
	{
		return doubleChestInventory;
	}

	protected final DoubleChestInventory doubleChestInventory;
}
