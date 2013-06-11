package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
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

	protected final Dropper dropper;
}
