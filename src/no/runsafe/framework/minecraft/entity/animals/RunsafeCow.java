package no.runsafe.framework.minecraft.entity.animals;

import no.runsafe.framework.api.entity.animals.ICow;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeAgeable;
import org.bukkit.entity.Cow;

import javax.annotation.Nullable;

public class RunsafeCow extends RunsafeAgeable implements ICow
{
	public RunsafeCow(Cow toWrap)
	{
		super(toWrap);
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Cow.Idle;
	}
}
