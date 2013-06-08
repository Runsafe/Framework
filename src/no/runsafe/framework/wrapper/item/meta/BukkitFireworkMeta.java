package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.RunsafeFireworkEffect;
import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public abstract class BukkitFireworkMeta extends RunsafeItemMeta
{
	public BukkitFireworkMeta(FireworkMeta toWrap)
	{
		super(toWrap);
		fireworkMeta = toWrap;
	}

	@Deprecated
	public void addEffect(RunsafeFireworkEffect effect) throws IllegalArgumentException
	{
		fireworkMeta.addEffect(effect.getRaw());
	}

	@Deprecated
	public List<RunsafeFireworkEffect> getEffects()
	{
		ArrayList<RunsafeFireworkEffect> effects = new ArrayList<RunsafeFireworkEffect>();
		for (FireworkEffect effect : fireworkMeta.getEffects())
			effects.add(ObjectWrapper.convert(effect));
		return effects;
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
