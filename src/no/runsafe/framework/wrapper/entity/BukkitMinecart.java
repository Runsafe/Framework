package no.runsafe.framework.wrapper.entity;

import no.runsafe.framework.server.entity.RunsafeEntity;
import org.bukkit.entity.Minecart;

public class BukkitMinecart extends RunsafeEntity
{
	public BukkitMinecart(Minecart toWrap)
	{
		super(toWrap);
		minecart = toWrap;
	}

	protected final Minecart minecart;
}
