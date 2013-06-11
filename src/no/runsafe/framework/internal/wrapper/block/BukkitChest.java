package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.Chest;

public abstract class BukkitChest extends RunsafeBlockState implements IInventoryHolder
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
