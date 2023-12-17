package no.runsafe.framework.internal.extension.block;

import no.runsafe.framework.api.block.IChest;
import no.runsafe.framework.internal.wrapper.block.BukkitChest;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;

public class RunsafeChest extends BukkitChest implements IChest
{
	public RunsafeChest(Block toWrap, Chest chest)
	{
		super(toWrap, chest);
	}
}
