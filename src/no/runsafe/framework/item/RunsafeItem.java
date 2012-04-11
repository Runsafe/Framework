package no.runsafe.framework.item;

import org.bukkit.entity.Item;

public class RunsafeItem 
{
	public RunsafeItem(Item toWrap)
	{
		bukkitItem = toWrap;
	}
	
	public int getEntityId()
	{
		return bukkitItem.getEntityId();
	}
	
	private Item bukkitItem;
}
