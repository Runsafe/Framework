package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.RunsafeFireworkEffect;
import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.List;

public class BukkitFireworkMeta extends RunsafeItemMeta
{
	public BukkitFireworkMeta(FireworkMeta toWrap)
	{
		super(toWrap);
		fireworkMeta = toWrap;
	}

	public void addEffect(RunsafeFireworkEffect effect) throws IllegalArgumentException
	{
		fireworkMeta.addEffect(effect.getRaw());
	}

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

	protected final FireworkMeta fireworkMeta;
}
