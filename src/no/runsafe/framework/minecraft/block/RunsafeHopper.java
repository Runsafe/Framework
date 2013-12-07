package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IHopper;
import no.runsafe.framework.internal.wrapper.block.BukkitHopper;
import org.bukkit.block.Hopper;

public class RunsafeHopper extends BukkitHopper implements IHopper
{
	public RunsafeHopper(Hopper toWrap)
	{
		super(toWrap);
	}
}
