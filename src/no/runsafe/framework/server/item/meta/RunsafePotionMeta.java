package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.potion.RunsafePotionEffect;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.List;

public class RunsafePotionMeta extends RunsafeItemMeta
{
	public RunsafePotionMeta(PotionMeta toWrap)
	{
		super(toWrap);
		potion = toWrap;
	}

	public boolean hasCustomEffects()
	{
		return potion.hasCustomEffects();
	}

	public List<RunsafePotionEffect> getCustomEffects()
	{
		return ObjectWrapper.convert(potion.getCustomEffects());
	}

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
