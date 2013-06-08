package no.runsafe.framework.server;

import org.bukkit.FireworkEffect;

@Deprecated
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

	final FireworkEffect effect;
}
