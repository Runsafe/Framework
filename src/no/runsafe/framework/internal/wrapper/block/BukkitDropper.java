package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.Dropper;

public abstract class BukkitDropper extends RunsafeBlockState implements IInventoryHolder
{
	protected BukkitDropper(Dropper toWrap)
	{
		super(toWrap);
		dropper = toWrap;
	}

	@Override
	public Dropper getRaw()
	{
		return dropper;
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(dropper.getInventory());
	}

	protected final Dropper dropper;
}
