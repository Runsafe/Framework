package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IChest;
import no.runsafe.framework.internal.wrapper.block.BukkitChest;
import org.bukkit.block.Chest;

public class RunsafeChest extends BukkitChest implements IChest
{
	public RunsafeChest(Chest toWrap)
	{
		super(toWrap);
	}
}
