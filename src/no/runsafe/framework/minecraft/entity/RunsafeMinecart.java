package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitMinecart;
import org.bukkit.entity.Minecart;

public class RunsafeMinecart extends BukkitMinecart
{
	public RunsafeMinecart(Minecart toWrap)
	{
		super(toWrap);
	}
}
