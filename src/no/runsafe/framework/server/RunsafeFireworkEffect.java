package no.runsafe.framework.server;

import org.bukkit.FireworkEffect;

public class RunsafeFireworkEffect
{
	public RunsafeFireworkEffect(FireworkEffect toWrap)
	{
		effect = toWrap;
	}

	public FireworkEffect getRaw()
	{
		return effect;
	}

	FireworkEffect effect;
}
