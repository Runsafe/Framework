package no.runsafe.framework.internal.extension.block;

import no.runsafe.framework.api.block.IFurnace;
import no.runsafe.framework.internal.wrapper.block.BukkitFurnace;
import org.bukkit.block.Block;
import org.bukkit.block.Furnace;

public class RunsafeFurnace extends BukkitFurnace implements IFurnace
{
	public RunsafeFurnace(Block toWrap, Furnace state)
	{
		super(toWrap, state);
	}
}
