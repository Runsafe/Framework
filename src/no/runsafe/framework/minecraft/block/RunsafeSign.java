package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.api.block.ISign;
import no.runsafe.framework.internal.wrapper.block.BukkitSign;
import org.bukkit.block.Sign;

public class RunsafeSign extends BukkitSign implements ISign
{
	public RunsafeSign(Sign toWrap)
	{
		super(toWrap);
	}
}
