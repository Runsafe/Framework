package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import no.runsafe.framework.server.potion.RunsafePotionEffect;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.List;

@SuppressWarnings("deprecation")
public class BukkitPotionMeta extends RunsafeItemMeta
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

	@Deprecated
	public List<RunsafePotionEffect> getCustomEffects()
	{
		return ObjectWrapper.convert(potion.getCustomEffects());
	}

	@Deprecated
	public boolean addCustomEffect(RunsafePotionEffect effect, boolean overwrite)
	{
		return potion.addCustomEffect(effect.getRaw(), overwrite);
	}

	public boolean clearCustomEffects()
	{
		return potion.clearCustomEffects();
	}

	private final PotionMeta potion;
}
