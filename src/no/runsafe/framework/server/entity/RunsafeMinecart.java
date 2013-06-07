package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.entity.BukkitMinecart;
import org.bukkit.entity.Minecart;

public class RunsafeMinecart extends BukkitMinecart
{
	public RunsafeMinecart(Minecart toWrap)
	{
		super(toWrap);
	}
}
