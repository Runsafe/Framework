package no.runsafe.framework.server.inventory;

import no.runsafe.framework.wrapper.inventory.BukkitInventoryHolder;
import org.bukkit.inventory.InventoryHolder;

public class RunsafeInventoryHolder extends BukkitInventoryHolder
{
	public RunsafeInventoryHolder(InventoryHolder toWrap)
	{
		super(toWrap);
	}
}
