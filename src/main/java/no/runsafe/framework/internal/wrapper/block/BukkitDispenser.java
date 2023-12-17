package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;

public abstract class BukkitDispenser extends BukkitBlockState implements IInventoryHolder
{
	protected BukkitDispenser(Block toWrap, Dispenser state)
	{
		super(toWrap, state);
		dispenser = state;
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

	protected final Dispenser dispenser;
}
