package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitArmourStand;
import org.bukkit.entity.ArmorStand;

public class RunsafeArmourStand extends BukkitArmourStand
{
	public RunsafeArmourStand(ArmorStand toWrap)
	{
		super(toWrap);
	}
}
