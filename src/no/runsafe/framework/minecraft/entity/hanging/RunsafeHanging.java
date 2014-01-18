package no.runsafe.framework.minecraft.entity.hanging;

import no.runsafe.framework.internal.wrapper.entity.BukkitHanging;
import org.bukkit.entity.Hanging;

public class RunsafeHanging extends BukkitHanging
{
	protected RunsafeHanging(Hanging toWrap)
	{
		super(toWrap);
	}
}
