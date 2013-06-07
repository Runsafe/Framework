package no.runsafe.framework.server.inventory;

import no.runsafe.framework.wrapper.inventory.BukkitInventoryView;
import org.bukkit.inventory.InventoryView;

public class RunsafeInventoryView extends BukkitInventoryView
{
	public RunsafeInventoryView(InventoryView toWrap)
	{
		super(toWrap);
	}
}
