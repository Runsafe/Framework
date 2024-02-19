package no.runsafe.framework.internal.wrapper.entity;

import org.bukkit.entity.TNTPrimed;

public abstract class BukkitTNTPrimed extends BukkitExplosive
{
	public BukkitTNTPrimed(TNTPrimed toWrap)
	{
		super(toWrap);
		tnt = toWrap;
	}

	public int getFuseTicks()
	{
		return tnt.getFuseTicks();
	}

	public void setFuseTicks(int fuseTicks)
	{
		tnt.setFuseTicks(fuseTicks);
	}

	@Override
	public TNTPrimed getRaw()
	{
		return tnt;
	}

	private final TNTPrimed tnt;
}
