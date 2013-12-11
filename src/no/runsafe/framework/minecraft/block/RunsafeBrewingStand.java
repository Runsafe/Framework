package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IBrewingStand;
import no.runsafe.framework.internal.wrapper.block.BukkitBrewingStand;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;

public class RunsafeBrewingStand extends BukkitBrewingStand implements IBrewingStand
{
	public RunsafeBrewingStand(Block toWrap, BrewingStand state)
	{
		super(toWrap, state);
	}
}
