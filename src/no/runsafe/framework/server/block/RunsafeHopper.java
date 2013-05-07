package no.runsafe.framework.server.block;

import org.bukkit.block.Hopper;

public class RunsafeHopper extends RunsafeBlockState
{
	public RunsafeHopper(Hopper toWrap)
	{
		super(toWrap);
		this.hopper = toWrap;
	}

	public Hopper getRaw()
	{
		return this.hopper;
	}

	private Hopper hopper;
}
