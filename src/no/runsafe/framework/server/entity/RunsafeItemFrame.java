package no.runsafe.framework.server.entity;

import no.runsafe.framework.wrapper.entity.BukkitItemFrame;
import org.bukkit.entity.ItemFrame;

public class RunsafeItemFrame extends BukkitItemFrame
{
	public RunsafeItemFrame(ItemFrame toWrap)
	{
		super(toWrap);
	}
}
