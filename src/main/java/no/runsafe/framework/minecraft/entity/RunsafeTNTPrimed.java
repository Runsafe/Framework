package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.api.entity.ITNTPrimed;
import no.runsafe.framework.internal.wrapper.entity.BukkitTNTPrimed;
import org.bukkit.entity.TNTPrimed;

public class RunsafeTNTPrimed extends BukkitTNTPrimed implements ITNTPrimed
{
	public RunsafeTNTPrimed(TNTPrimed toWrap)
	{
		super(toWrap);
	}
}
