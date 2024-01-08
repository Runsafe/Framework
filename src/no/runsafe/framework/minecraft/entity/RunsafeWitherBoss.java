package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.IWitherBoss;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wither;

public class RunsafeWitherBoss extends RunsafeLivingEntity implements IWitherBoss
{
	public RunsafeWitherBoss(Wither toWrap)
	{
		super(toWrap);
		wither = toWrap;
	}

	Wither wither;
}
