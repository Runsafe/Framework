package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.Hopper;

public class BukkitHopper extends RunsafeBlockState implements IInventoryHolder
{
	public BukkitHopper(Hopper toWrap)
	{
		super(toWrap);
		this.hopper = toWrap;
	}

	public Hopper getRaw()
	{
		return this.hopper;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(this.hopper.getInventory());
	}

	protected final Hopper hopper;
}
