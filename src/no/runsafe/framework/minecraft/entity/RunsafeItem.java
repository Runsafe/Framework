package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitItem;
import org.bukkit.entity.Item;

public class RunsafeItem extends BukkitItem
{
	public RunsafeItem(Item toWrap)
	{
		super(toWrap);
	}
}
