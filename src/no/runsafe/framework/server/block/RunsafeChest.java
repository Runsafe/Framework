package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitChest;
import org.bukkit.block.Chest;

public class RunsafeChest extends BukkitChest
{
	public RunsafeChest(Chest toWrap)
	{
		super(toWrap);
	}
}
