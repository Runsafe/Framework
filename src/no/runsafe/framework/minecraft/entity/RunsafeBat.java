package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.IBat;
import no.runsafe.framework.minecraft.Sound;
import no.runsafe.framework.minecraft.entity.RunsafeLivingEntity;
import org.bukkit.entity.Bat;

import javax.annotation.Nullable;

public class RunsafeBat extends RunsafeLivingEntity implements IBat
{
	public RunsafeBat(Bat toWrap)
	{
		super(toWrap);
		bat = toWrap;
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Bat.Idle;
	}

	private final Bat bat;
}
