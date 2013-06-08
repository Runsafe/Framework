package no.runsafe.framework.wrapper.item.meta;

import no.runsafe.framework.server.item.meta.RunsafeItemMeta;
import org.bukkit.inventory.meta.FireworkEffectMeta;

@Deprecated
public abstract class BukkitFireworkEffectMeta extends RunsafeItemMeta
{
	public BukkitFireworkEffectMeta(FireworkEffectMeta meta)
	{
		super(meta);
		effectMeta = meta;
	}

	public boolean hasEffect()
	{
		return effectMeta.hasEffect();
	}

	@Override
	public FireworkEffectMeta getRaw()
	{
		return effectMeta;
	}

	protected final FireworkEffectMeta effectMeta;
}
