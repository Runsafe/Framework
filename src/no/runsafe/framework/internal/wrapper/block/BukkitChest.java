package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;

public abstract class BukkitChest extends BukkitBlockState implements IInventoryHolder
{
	protected BukkitChest(Block toWrap, Chest chest)
	{
		super(toWrap, chest);
		this.chest = chest;
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
