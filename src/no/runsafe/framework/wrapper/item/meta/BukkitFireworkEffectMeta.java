package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.RunsafeFireworkEffect;
import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.meta.FireworkEffectMeta;

public class BukkitFireworkEffectMeta extends RunsafeItemMeta
{
	public BukkitFireworkEffectMeta(FireworkEffectMeta meta)
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

	protected final FireworkEffectMeta effectMeta;
}
