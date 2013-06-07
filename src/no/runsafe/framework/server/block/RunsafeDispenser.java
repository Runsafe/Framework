package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitDispenser;
import org.bukkit.block.Dispenser;

public class RunsafeDispenser extends BukkitDispenser
{
	public RunsafeDispenser(Dispenser toWrap)
	{
		super(toWrap);
	}
}
