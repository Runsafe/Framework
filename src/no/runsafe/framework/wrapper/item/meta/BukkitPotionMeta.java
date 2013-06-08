package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

@Deprecated
public abstract class BukkitPotionMeta extends RunsafeItemMeta
{
	public BukkitPotionMeta(PotionMeta toWrap)
	{
		super(toWrap);
		potion = toWrap;
	}

	public boolean hasCustomEffects()
	{
		return potion.hasCustomEffects();
	}

	public boolean clearCustomEffects()
	{
		return potion.clearCustomEffects();
	}

	@Override
	public PotionMeta getRaw()
	{
		return potion;
	}

	private final PotionMeta potion;
}
