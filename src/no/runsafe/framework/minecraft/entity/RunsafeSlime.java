package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.ISlime;
import no.runsafe.framework.minecraft.Sound;
import org.bukkit.entity.Slime;

import javax.annotation.Nullable;

public class RunsafeSlime extends RunsafeLivingEntity implements ISlime
{
	public RunsafeSlime(Slime toWrap)
	{
		super(toWrap);
		slime = toWrap;
	}

	@Override
	public int getSize()
	{
		return slime.getSize();
	}

	@Override
	public void setSize(int size)
	{
		slime.setSize(size);
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Slime.Walk;
	}

	private final Slime slime;
}
