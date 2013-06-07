package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.Dispenser;

public class BukkitDispenser extends RunsafeBlockState implements IInventoryHolder
{
	public BukkitDispenser(Dispenser toWrap)
	{
		super(toWrap);
		dispenser = toWrap;
	}

	public boolean dispense()
	{
		return dispenser.dispense();
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(dispenser.getInventory());
	}

	@Override
	public Dispenser getRaw()
	{
		return dispenser;
	}

	protected final Dispenser dispenser;
}
