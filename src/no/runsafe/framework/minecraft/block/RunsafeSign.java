package no.runsafe.framework.minecraft.block;

import no.runsafe.framework.internal.wrapper.block.BukkitSign;
import org.bukkit.block.Sign;

public class RunsafeSign extends BukkitSign implements no.runsafe.framework.api.block.ISign
{
	public RunsafeSign(Sign toWrap)
	{
		super(toWrap);
	}
}
