package no.runsafe.framework.server.block;

import no.runsafe.framework.wrapper.block.BukkitSign;
import org.bukkit.block.Sign;

public class RunsafeSign extends BukkitSign
{
	public RunsafeSign(Sign toWrap)
	{
		super(toWrap);
	}
}
