package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitDropper;
import org.bukkit.block.Dropper;

public class RunsafeDropper extends BukkitDropper implements no.runsafe.framework.api.block.IDropper
{
	public RunsafeDropper(Dropper toWrap)
	{
		super(toWrap);
	}
}
