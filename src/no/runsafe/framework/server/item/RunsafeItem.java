package no.runsafe.framework.server.item;

import org.bukkit.entity.Item;

public class RunsafeItem 
{
	public RunsafeItem(Item toWrap)
	{
		item = toWrap;
	}
	
	public int getEntityId()
	{
		return item.getEntityId();
	}

	public Item getRaw()
	{
		return item;
	}
	
	private final Item item;
}
