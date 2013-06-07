package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.item.meta.BukkitPotionMeta;
import org.bukkit.inventory.meta.PotionMeta;

public class RunsafePotionMeta extends BukkitPotionMeta
{

	public RunsafePotionMeta(PotionMeta toWrap)
	{
		super(toWrap);
	}
}
