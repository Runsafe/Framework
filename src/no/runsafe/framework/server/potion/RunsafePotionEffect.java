package no.runsafe.framework.server.potion;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

@Deprecated
public class RunsafePotionEffect
{
	public RunsafePotionEffect(PotionEffect effect)
	{
		this.effect = effect;
	}

	public static RunsafePotionEffect create(int id, int duration, int amplifier)
	{
		return new RunsafePotionEffect(new PotionEffect(PotionEffectType.getById(id), duration, amplifier));
	}

	public int getAmplifier()
	{
		return effect.getAmplifier();
	}

	public int getDuration()
	{
		return effect.getDuration();
	}

	public boolean isAmbient()
	{
		return effect.isAmbient();
	}

	public PotionEffect getRaw()
	{
		return effect;
	}

	private final PotionEffect effect;
}
