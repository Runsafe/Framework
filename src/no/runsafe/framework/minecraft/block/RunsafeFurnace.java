package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitFurnace;
import org.bukkit.block.Furnace;

public class RunsafeFurnace extends BukkitFurnace implements no.runsafe.framework.api.block.IFurnace
{
	public RunsafeFurnace(Furnace toWrap)
	{
		super(toWrap);
	}
}
