package no.runsafe.framework.internal.extension.block;

import no.runsafe.framework.api.block.IHopper;
import no.runsafe.framework.internal.wrapper.block.BukkitHopper;
import org.bukkit.block.Block;
import org.bukkit.block.Hopper;

public class RunsafeHopper extends BukkitHopper implements IHopper
{
	public RunsafeHopper(Block toWrap, Hopper state)
	{
		super(toWrap, state);
	}
}
