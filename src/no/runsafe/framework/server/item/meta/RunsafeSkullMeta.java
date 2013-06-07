package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.item.meta.BukkitSkullMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class RunsafeSkullMeta extends BukkitSkullMeta
{
	public RunsafeSkullMeta(SkullMeta toWrap)
	{
		super(toWrap);
	}

	public RunsafeSkullMeta clone()
	{
		return new RunsafeSkullMeta(skull.clone());
	}
}
