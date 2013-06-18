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
