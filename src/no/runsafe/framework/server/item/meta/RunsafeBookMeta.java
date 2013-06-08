package no.runsafe.framework.server.item.meta;

import org.bukkit.inventory.meta.BookMeta;

@Deprecated
public class RunsafeBookMeta extends RunsafeItemMeta
{
	public RunsafeBookMeta(BookMeta meta)
	{
		super(meta);
		book = meta;
	}


	private final BookMeta book;
}
