package no.runsafe.framework.minecraft.inventory;

import no.runsafe.framework.internal.wrapper.inventory.BukkitInventoryView;
import org.bukkit.inventory.InventoryView;

public class RunsafeInventoryView extends BukkitInventoryView
{
	public RunsafeInventoryView(InventoryView toWrap)
	{
		super(toWrap);
	}
}
