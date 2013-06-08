package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.MapMeta;

@Deprecated
public abstract class BukkitMapMeta extends RunsafeItemMeta
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

	@Override
	public MapMeta getRaw()
	{
		return mapMeta;
	}

	protected final MapMeta mapMeta;
}
