package no.runsafe.framework.minecraft.entity.monsters;

import no.runsafe.framework.api.entity.monsters.ISilverfish;
import no.runsafe.framework.minecraft.Sound;
import org.bukkit.entity.Silverfish;

import javax.annotation.Nullable;

public class RunsafeSilverfish extends RunsafeMonster implements ISilverfish
{
	public RunsafeSilverfish(Silverfish toWrap)
	{
		super(toWrap);
		silverfish = toWrap;
	}

	@Override
	@Nullable
	public Sound getIdleSound()
	{
		return Sound.Creature.Silverfish.Idle;
	}

	private final Silverfish silverfish;
}
