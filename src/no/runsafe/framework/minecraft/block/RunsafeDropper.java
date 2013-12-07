package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IDropper;
import no.runsafe.framework.internal.wrapper.block.BukkitDropper;
import org.bukkit.block.Dropper;

public class RunsafeDropper extends BukkitDropper implements IDropper
{
	public RunsafeDropper(Dropper toWrap)
	{
		super(toWrap);
	}
}
