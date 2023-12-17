package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;

public abstract class BukkitDropper extends BukkitBlockState implements IInventoryHolder
{
	protected BukkitDropper(Block toWrap, Dropper state)
	{
		super(toWrap, state);
		dropper = (Dropper) toWrap.getState();
	}

	public void drop()
	{
		dropper.drop();
	}

	@Override
	public RunsafeInventory getInventory()
	{
		return ObjectWrapper.convert(dropper.getInventory());
	}

	protected final Dropper dropper;
}
