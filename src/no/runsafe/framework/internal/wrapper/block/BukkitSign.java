package no.runsafe.framework.internal.wrapper.block;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public abstract class BukkitSign extends BukkitBlockState
{
	protected BukkitSign(Block toWrap, Sign state)
	{
		super(toWrap, state);
		sign = state;
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
