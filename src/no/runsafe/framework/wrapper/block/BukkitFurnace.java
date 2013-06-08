package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.BlockState;
import org.bukkit.block.Furnace;

public abstract class BukkitFurnace extends RunsafeBlockState implements IInventoryHolder
{
	public BukkitFurnace(Furnace toWrap)
	{
		super(toWrap);
		furnace = toWrap;
	}

	public short getBurnTime()
	{
		return furnace.getBurnTime();
	}

	public void setBurnTime(short i)
	{
		furnace.setBurnTime(i);
	}

	public short getCookTime()
	{
		return furnace.getCookTime();
	}

	public void setCookTime(short i)
	{
		furnace.setCookTime(i);
	}

	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(furnace.getInventory());
	}

	@Override
	public Furnace getRaw()
	{
		return furnace;
	}

	protected final Furnace furnace;
}
