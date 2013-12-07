package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitCreatureSpawner;
import org.bukkit.block.CreatureSpawner;

public class RunsafeCreatureSpawner extends BukkitCreatureSpawner implements no.runsafe.framework.api.block.ICreatureSpawner
{
	public RunsafeCreatureSpawner(CreatureSpawner toWrap)
	{
		super(toWrap);
	}
}
