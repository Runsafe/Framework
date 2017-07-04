package no.runsafe.framework.minecraft.entity.monsters;

import no.runsafe.framework.api.entity.monsters.IPigZombie;
import no.runsafe.framework.minecraft.Sound;
import org.bukkit.entity.PigZombie;

import javax.annotation.Nullable;

public class RunsafePigZombie extends RunsafeZombie implements IPigZombie
{
	public RunsafePigZombie(PigZombie toWrap)
	{
		super(toWrap);
		pigZombie = toWrap;
	}

	@Override
	public int getAngerLevel()
	{
		return pigZombie.getAnger();
	}

	@Override
	public void setAngerLevel(int angerLevel)
	{
		pigZombie.setAnger(angerLevel);
	}

	@Override
	public boolean isAngry()
	{
		return pigZombie.isAngry();
	}

	@Override
	public void setAngry(boolean angry)
	{
		pigZombie.setAngry(angry);
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.PigZombie.Idle;
	}

	private final PigZombie pigZombie;
}
