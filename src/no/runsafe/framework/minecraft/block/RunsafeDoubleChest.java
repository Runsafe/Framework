package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitDoubleChest;
import org.bukkit.block.DoubleChest;

public class RunsafeDoubleChest extends BukkitDoubleChest implements no.runsafe.framework.api.block.IDoubleChest
{
	public RunsafeDoubleChest(DoubleChest toWrap)
	{
		super(toWrap);
	}
}
