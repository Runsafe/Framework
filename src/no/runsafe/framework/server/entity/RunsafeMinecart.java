package no.runsafe.framework.server.entity;

import org.bukkit.entity.Minecart;

public class RunsafeMinecart extends RunsafeVehicle
{
	public RunsafeMinecart(Minecart toWrap)
	{
		super(toWrap);
		minecart = toWrap;
	}

	private final Minecart minecart;
}
