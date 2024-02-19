package no.runsafe.framework.minecraft.entity.animals;

import no.runsafe.framework.api.entity.animals.IChicken;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import org.bukkit.entity.Chicken;

import javax.annotation.Nullable;

public class RunsafeChicken extends RunsafeAgeable implements IChicken
{
	public RunsafeChicken(Chicken toWrap)
	{
		super(toWrap);
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Chicken.Idle;
	}
}
