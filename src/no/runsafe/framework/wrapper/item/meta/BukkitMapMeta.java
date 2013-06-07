package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import org.bukkit.inventory.meta.MapMeta;

public class BukkitMapMeta extends RunsafeItemMeta
{
	public BukkitMapMeta(MapMeta toWrap)
	{
		super(toWrap);
		mapMeta = toWrap;
	}

	public boolean isScaling()
	{
		return mapMeta.isScaling();
	}

	public void setScaling(boolean value)
	{
		mapMeta.setScaling(value);
	}

	protected final MapMeta mapMeta;
}
