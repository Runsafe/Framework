package no.runsafe.framework.internal.wrapper.block;

import no.runsafe.framework.minecraft.block.RunsafeBlockState;
import org.bukkit.block.Sign;

public abstract class BukkitSign extends RunsafeBlockState
{
	protected BukkitSign(Sign toWrap)
	{
		super(toWrap);
		sign = toWrap;
	}

	public String[] getLines()
	{
		return sign.getLines();
	}

	public String getLine(int i)
	{
		return sign.getLine(i);
	}

	public void setLine(int i, String s)
	{
		sign.setLine(i, s);
	}

	protected final Sign sign;
}
