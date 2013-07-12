package no.runsafe.framework.minecraft.entity;

import org.bukkit.entity.Fish;

public class RunsafeFish extends RunsafeProjectile
{
	public RunsafeFish(Fish toWrap)
	{
		super(toWrap);
		this.fish = toWrap;
	}

	public double getBiteChance()
	{
		return this.fish.getBiteChance();
	}

	public void setBiteChance(double chance)
	{
		this.fish.setBiteChance(chance);
	}

	private Fish fish;
}
