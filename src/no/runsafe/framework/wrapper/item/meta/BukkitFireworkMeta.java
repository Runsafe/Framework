package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import org.bukkit.inventory.meta.FireworkMeta;

@SuppressWarnings("deprecation")
@Deprecated
public abstract class BukkitFireworkMeta extends RunsafeItemMeta
{
	public BukkitFireworkMeta(FireworkMeta toWrap)
	{
		super(toWrap);
		fireworkMeta = toWrap;
	}

	public int getEffectsSize()
	{
		return fireworkMeta.getEffectsSize();
	}

	public void removeEffect(int index) throws IndexOutOfBoundsException
	{
		fireworkMeta.removeEffect(index);
	}

	public void clearEffects()
	{
		fireworkMeta.clearEffects();
	}

	public boolean hasEffects()
	{
		return fireworkMeta.hasEffects();
	}

	public int getPower()
	{
		return fireworkMeta.getPower();
	}

	public void setPower(int power) throws IllegalArgumentException
	{
		fireworkMeta.setPower(power);
	}

	@Override
	public FireworkMeta getRaw()
	{
		return fireworkMeta;
	}

	protected final FireworkMeta fireworkMeta;
}
