package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.server.ObjectWrapper;
import no.runsafe.framework.server.RunsafeFireworkEffect;
import org.bukkit.FireworkEffect;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.List;

public class RunsafeFireworkMeta extends RunsafeItemMeta
{
	public RunsafeFireworkMeta(FireworkMeta toWrap)
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

	public RunsafeFireworkMeta clone()
	{
		return new RunsafeFireworkMeta(fireworkMeta.clone());
	}

	private final FireworkMeta fireworkMeta;
}
