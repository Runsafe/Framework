package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.item.meta.BukkitMapMeta;
import org.bukkit.inventory.meta.MapMeta;

@Deprecated
public class RunsafeMapMeta extends BukkitMapMeta
{
	public RunsafeMapMeta(MapMeta toWrap)
	{
		super(toWrap);
	}

	public RunsafeMapMeta clone()
	{
		return new RunsafeMapMeta(mapMeta.clone());
	}
}
