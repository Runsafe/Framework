package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitHopper;
import org.bukkit.block.Hopper;

public class RunsafeHopper extends BukkitHopper
{
	public RunsafeHopper(Hopper toWrap)
	{
		super(toWrap);
	}
}
