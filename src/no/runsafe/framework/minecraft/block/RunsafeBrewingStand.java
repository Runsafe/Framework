package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitBrewingStand;
import org.bukkit.block.BrewingStand;

public class RunsafeBrewingStand extends BukkitBrewingStand implements no.runsafe.framework.api.block.IBrewingStand
{
	public RunsafeBrewingStand(BrewingStand toWrap)
	{
		super(toWrap);
	}
}
