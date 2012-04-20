package no.runsafe.framework.server.inventory;

import org.bukkit.inventory.PlayerInventory;

public class RunsafePlayerInventory extends RunsafeInventory
{
	public RunsafePlayerInventory(PlayerInventory toWrap)
	{
		super(toWrap);
		inventory = toWrap;
	}

	private PlayerInventory inventory;
}
