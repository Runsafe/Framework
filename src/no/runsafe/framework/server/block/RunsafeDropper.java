package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitDropper;
import org.bukkit.block.Dropper;

public class RunsafeDropper extends BukkitDropper
{
	public RunsafeDropper(Dropper toWrap)
	{
		super(toWrap);
	}
}
