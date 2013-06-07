package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitCreatureSpawner;
import org.bukkit.block.CreatureSpawner;

public class RunsafeCreatureSpawner extends BukkitCreatureSpawner
{
	public RunsafeCreatureSpawner(CreatureSpawner toWrap)
	{
		super(toWrap);
	}
}
