package no.runsafe.framework.server.potion;

import org.bukkit.potion.PotionEffect;

public class RunsafePotionEffect
{
	public RunsafePotionEffect(PotionEffect effect)
	{
		this.effect = effect;
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
