package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitBrewingStand;
import org.bukkit.block.BrewingStand;

public class RunsafeBrewingStand extends BukkitBrewingStand
{
	public RunsafeBrewingStand(BrewingStand toWrap)
	{
		super(toWrap);
	}
}
