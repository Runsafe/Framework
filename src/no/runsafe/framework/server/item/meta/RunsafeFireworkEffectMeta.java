package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.ObjectWrapper;
import no.runsafe.framework.server.RunsafeFireworkEffect;
import org.bukkit.inventory.meta.FireworkEffectMeta;

public class RunsafeFireworkEffectMeta extends RunsafeItemMeta
{
	public RunsafeFireworkEffectMeta(FireworkEffectMeta meta)
	{
		super(meta);
		effectMeta = meta;
	}

	public void setEffect(RunsafeFireworkEffect effect)
	{
		effectMeta.setEffect(effect.getRaw());
	}

	public boolean hasEffect()
	{
		return effectMeta.hasEffect();
	}

	public RunsafeFireworkEffect getEffect()
	{
		return ObjectWrapper.convert(effectMeta.getEffect());
	}

	public RunsafeFireworkEffectMeta clone()
	{
		return new RunsafeFireworkEffectMeta(effectMeta.clone());
	}

	final FireworkEffectMeta effectMeta;
}
