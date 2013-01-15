package no.runsafe.framework.server.item.meta;

import org.bukkit.inventory.meta.MapMeta;

public class RunsafeMapMeta extends RunsafeItemMeta
{
	public RunsafeMapMeta(MapMeta toWrap)
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

	public RunsafeMapMeta clone()
	{
		return new RunsafeMapMeta(mapMeta.clone());
	}

	private final MapMeta mapMeta;
}
