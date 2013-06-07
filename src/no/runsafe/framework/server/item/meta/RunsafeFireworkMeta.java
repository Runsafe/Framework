package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.item.meta.BukkitFireworkMeta;
import org.bukkit.inventory.meta.FireworkMeta;

public class RunsafeFireworkMeta extends BukkitFireworkMeta
{

	public RunsafeFireworkMeta(FireworkMeta meta)
	{
		super(meta);
	}

	public RunsafeFireworkMeta clone()
	{
		return new RunsafeFireworkMeta(fireworkMeta.clone());
	}
}
