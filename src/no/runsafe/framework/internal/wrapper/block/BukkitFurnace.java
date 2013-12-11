package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;

public abstract class BukkitFurnace extends BukkitBlockState implements IInventoryHolder
{
	protected BukkitFurnace(Block toWrap, Furnace state)
	{
		super(toWrap, state);
		furnace = state;
	}

	public short getBurnTime()
	{
		return furnace.getBurnTime();
	}

	public void setBurnTime(short time)
	{
		furnace.setBurnTime(time);
	}

	public short getCookTime()
	{
		return furnace.getCookTime();
	}

	public void setCookTime(short time)
	{
		furnace.setCookTime(time);
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(furnace.getInventory());
	}

	protected final Furnace furnace;
}
