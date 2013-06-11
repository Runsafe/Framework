package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitCreatureSpawner;
import org.bukkit.block.CreatureSpawner;

public class RunsafeCreatureSpawner extends BukkitCreatureSpawner
{
	public RunsafeCreatureSpawner(CreatureSpawner toWrap)
	{
		super(toWrap);
	}
}
