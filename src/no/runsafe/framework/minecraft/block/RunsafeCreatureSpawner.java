package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.ICreatureSpawner;
import no.runsafe.framework.internal.wrapper.block.BukkitCreatureSpawner;
import org.bukkit.block.CreatureSpawner;

public class RunsafeCreatureSpawner extends BukkitCreatureSpawner implements ICreatureSpawner
{
	public RunsafeCreatureSpawner(CreatureSpawner toWrap)
	{
		super(toWrap);
	}
}
