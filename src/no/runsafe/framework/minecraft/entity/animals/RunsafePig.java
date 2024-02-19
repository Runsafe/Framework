package no.runsafe.framework.minecraft.entity.animals;

import no.runsafe.framework.api.entity.animals.IPig;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import org.bukkit.entity.Pig;

import javax.annotation.Nullable;

public class RunsafePig extends RunsafeAgeable implements IPig
{
	public RunsafePig(Pig toWrap)
	{
		super(toWrap);
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Pig.Idle;
	}
}
