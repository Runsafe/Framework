package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitFurnace;
import org.bukkit.block.Furnace;

public class RunsafeFurnace extends BukkitFurnace
{
	public RunsafeFurnace(Furnace toWrap)
	{
		super(toWrap);
	}
}
