package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.wrapper.inventory.BukkitInventoryHolder;
import org.bukkit.inventory.InventoryHolder;

public class RunsafeInventoryHolder extends BukkitInventoryHolder
{
	public RunsafeInventoryHolder(InventoryHolder toWrap)
	{
		super(toWrap);
	}
}
