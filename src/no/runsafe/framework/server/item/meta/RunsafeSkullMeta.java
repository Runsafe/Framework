package no.runsafe.framework.server.item.meta;

import org.bukkit.inventory.meta.SkullMeta;

public class RunsafeSkullMeta extends RunsafeItemMeta
{
	public RunsafeSkullMeta(SkullMeta toWrap)
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

	public RunsafeSkullMeta clone()
	{
		return new RunsafeSkullMeta(skull.clone());
	}

	private final SkullMeta skull;
}
