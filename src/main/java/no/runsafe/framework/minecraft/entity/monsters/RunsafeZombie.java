package no.runsafe.framework.minecraft.entity.monsters;

import no.runsafe.framework.api.entity.monsters.IZombie;
import no.runsafe.framework.minecraft.Sound;
import org.bukkit.entity.Zombie;

import javax.annotation.Nullable;

public class RunsafeZombie extends RunsafeMonster implements IZombie
{
	public RunsafeZombie(Zombie toWrap)
	{
		super(toWrap);
		zombie = toWrap;
	}

	@Override
	public boolean isBaby()
	{
		return zombie.isBaby();
	}

	@Override
	public void setBaby(boolean baby)
	{
		zombie.setBaby(baby);
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Zombie.Idle;
	}

	private final Zombie zombie;
}
