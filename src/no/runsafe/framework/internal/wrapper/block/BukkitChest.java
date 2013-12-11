package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.Chest;

public abstract class BukkitChest extends RunsafeBlockState implements IInventoryHolder
{
	protected BukkitChest(Chest toWrap)
	{
		super(toWrap);
		chest = toWrap;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(chest.getBlockInventory());
	}

	public RunsafeInventory getBlockInventory()
	{
		return getInventory();
	}

	protected final Chest chest;
}
