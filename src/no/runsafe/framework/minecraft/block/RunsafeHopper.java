package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitHopper;
import org.bukkit.block.Hopper;

public class RunsafeHopper extends BukkitHopper
{
	public RunsafeHopper(Hopper toWrap)
	{
		super(toWrap);
	}
}
