package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.IEnderDragon;
import org.bukkit.entity.*;

public class RunsafeEnderDragon extends RunsafeLivingEntity implements IEnderDragon
{
	public RunsafeEnderDragon(EnderDragon toWrap)
	{
		super(toWrap);
	}
}
