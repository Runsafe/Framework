package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IDispenser;
import no.runsafe.framework.internal.wrapper.block.BukkitDispenser;
import org.bukkit.block.Block;
import org.bukkit.block.Dispenser;

public class RunsafeDispenser extends BukkitDispenser implements IDispenser
{
	public RunsafeDispenser(Block toWrap, Dispenser state)
	{
		super(toWrap, state);
	}
}
