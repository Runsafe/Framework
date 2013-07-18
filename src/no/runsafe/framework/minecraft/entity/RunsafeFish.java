package no.runsafe.framework.minecraft.entity;

import org.bukkit.entity.Fish;

public class RunsafeFish extends RunsafeProjectile
{
	public RunsafeFish(Fish toWrap)
	{
		super(toWrap);
		fish = toWrap;
	}

	public double getBiteChance()
	{
		return fish.getBiteChance();
	}

	public void setBiteChance(double chance)
	{
		fish.setBiteChance(chance);
	}

	private final Fish fish;
}
