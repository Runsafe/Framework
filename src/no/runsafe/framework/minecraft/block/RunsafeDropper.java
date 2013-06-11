package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitDropper;
import org.bukkit.block.Dropper;

public class RunsafeDropper extends BukkitDropper
{
	public RunsafeDropper(Dropper toWrap)
	{
		super(toWrap);
	}
}
