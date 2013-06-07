package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitFurnace;
import org.bukkit.block.Furnace;

public class RunsafeFurnace extends BukkitFurnace
{
	public RunsafeFurnace(Furnace toWrap)
	{
		super(toWrap);
	}
}
