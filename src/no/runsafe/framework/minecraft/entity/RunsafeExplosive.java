package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.IExplosive;
import no.runsafe.framework.internal.wrapper.entity.BukkitExplosive;
import org.bukkit.entity.Explosive;

public class RunsafeExplosive extends BukkitExplosive implements IExplosive
{
	public RunsafeExplosive(Explosive toWrap)
	{
		super(toWrap);
	}
}
