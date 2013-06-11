package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitBrewingStand;
import org.bukkit.block.BrewingStand;

public class RunsafeBrewingStand extends BukkitBrewingStand
{
	public RunsafeBrewingStand(BrewingStand toWrap)
	{
		super(toWrap);
	}
}
