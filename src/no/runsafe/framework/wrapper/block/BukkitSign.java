package no.runsafe.framework.wrapper.block;

import no.runsafe.framework.server.block.RunsafeBlockState;
import org.bukkit.block.Sign;

public abstract class BukkitSign extends RunsafeBlockState
{
	public BukkitSign(Sign toWrap)
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

	@Override
	public Sign getRaw()
	{
		return sign;
	}

	protected final Sign sign;
}
