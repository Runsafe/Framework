package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.RunsafeFireworkEffect;
import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import no.runsafe.framework.wrapper.ObjectWrapper;
import org.bukkit.inventory.meta.FireworkEffectMeta;
import org.bukkit.inventory.meta.ItemMeta;

@SuppressWarnings("deprecation")
public abstract class BukkitFireworkEffectMeta extends RunsafeItemMeta
{
	public BukkitFireworkEffectMeta(FireworkEffectMeta meta)
	{
		super(meta);
		effectMeta = meta;
	}

	@Deprecated
	public void setEffect(RunsafeFireworkEffect effect)
	{
		effectMeta.setEffect(effect.getRaw());
	}

	public boolean hasEffect()
	{
		return effectMeta.hasEffect();
	}

	@Deprecated
	public RunsafeFireworkEffect getEffect()
	{
		return ObjectWrapper.convert(effectMeta.getEffect());
	}

	@Override
	public FireworkEffectMeta getRaw()
	{
		return effectMeta;
	}

	protected final FireworkEffectMeta effectMeta;
}
