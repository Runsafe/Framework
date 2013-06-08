package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

@Deprecated
public abstract class BukkitSkullMeta extends RunsafeItemMeta
{
	public BukkitSkullMeta(SkullMeta toWrap)
	{
		super(toWrap);
		skull = toWrap;
	}

	public String getOwner()
	{
		return skull.getOwner();
	}

	public boolean hasOwner()
	{
		return skull.hasOwner();
	}

	public boolean setOwner(String owner)
	{
		return skull.setOwner(owner);
	}

	@Override
	public SkullMeta getRaw()
	{
		return skull;
	}

	protected final SkullMeta skull;
}
