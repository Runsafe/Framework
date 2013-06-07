package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitDoubleChest;
import org.bukkit.block.DoubleChest;

public class RunsafeDoubleChest extends BukkitDoubleChest
{
	public RunsafeDoubleChest(DoubleChest toWrap)
	{
		super(toWrap);
	}
}
