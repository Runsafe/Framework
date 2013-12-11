package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.IDoubleChest;
import no.runsafe.framework.internal.wrapper.block.BukkitDoubleChest;
import org.bukkit.block.DoubleChest;

public class RunsafeDoubleChest extends BukkitDoubleChest implements IDoubleChest
{
	public RunsafeDoubleChest(DoubleChest toWrap)
	{
		super(toWrap);
	}
}
