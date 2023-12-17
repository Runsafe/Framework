package no.runsafe.framework.minecraft.entity;

import no.runsafe.framework.internal.wrapper.entity.BukkitItemFrame;
import org.bukkit.entity.ItemFrame;

public class RunsafeItemFrame extends BukkitItemFrame
{
	public RunsafeItemFrame(ItemFrame toWrap)
	{
		super(toWrap);
	}
}
