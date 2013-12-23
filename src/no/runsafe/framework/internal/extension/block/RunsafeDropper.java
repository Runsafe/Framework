package no.runsafe.framework.internal.extension.block;

import no.runsafe.framework.api.block.IDropper;
import no.runsafe.framework.internal.wrapper.block.BukkitDropper;
import org.bukkit.block.Block;
import org.bukkit.block.Dropper;

public class RunsafeDropper extends BukkitDropper implements IDropper
{
	public RunsafeDropper(Block toWrap, Dropper state)
	{
		super(toWrap, state);
	}
}
