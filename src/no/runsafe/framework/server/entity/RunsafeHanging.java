package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.entity.BukkitHanging;
import org.bukkit.entity.Hanging;

public class RunsafeHanging extends BukkitHanging
{
	public RunsafeHanging(Hanging toWrap)
	{
		super(toWrap);
	}
}
