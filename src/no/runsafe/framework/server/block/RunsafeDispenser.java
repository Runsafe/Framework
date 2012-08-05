package no.runsafe.framework.server.block;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import org.bukkit.block.Dispenser;

public class RunsafeDispenser extends RunsafeBlockState implements IInventoryHolder
{
	public RunsafeDispenser(Dispenser toWrap)
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

	private final Dispenser dispenser;
}
