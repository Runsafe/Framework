package no.runsafe.framework.internal.wrapper.entity;

import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import org.bukkit.entity.Minecart;

public abstract class BukkitMinecart extends RunsafeEntity
{
	public BukkitMinecart(Minecart toWrap)
	{
		super(toWrap);
		minecart = toWrap;
	}

	@Override
	public Minecart getRaw()
	{
		return minecart;
	}

	protected final Minecart minecart;
}
