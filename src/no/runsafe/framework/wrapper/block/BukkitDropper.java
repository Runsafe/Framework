package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import no.runsafe.framework.server.inventory.IInventoryHolder;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.block.Dropper;

public abstract class BukkitDropper extends RunsafeBlockState implements IInventoryHolder
{
	public BukkitDropper(Dropper toWrap)
	{
		super(toWrap);
		this.dropper = toWrap;
	}

	@Override
	public Dropper getRaw()
	{
		return this.dropper;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(this.dropper.getInventory());
	}

	private Dropper dropper;
}
