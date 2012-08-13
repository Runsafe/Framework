package no.runsafe.framework.server.block;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.block.Furnace;

public class RunsafeFurnace extends RunsafeBlockState implements IInventoryHolder
{
	public RunsafeFurnace(Furnace toWrap)
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

	private final Furnace furnace;
}
