package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import no.runsafe.framework.api.minecraft.IInventoryHolder;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.block.Dispenser;

public abstract class BukkitDispenser extends RunsafeBlockState implements IInventoryHolder
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
