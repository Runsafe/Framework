package no.runsafe.framework.server.item.meta;

import no.runsafe.framework.wrapper.item.meta.BukkitFireworkEffectMeta;
import org.bukkit.inventory.meta.FireworkEffectMeta;

@Deprecated
public class RunsafeFireworkEffectMeta extends BukkitFireworkEffectMeta
{
	public RunsafeFireworkEffectMeta(FireworkEffectMeta meta)
	{
		super(meta);
	}

	public RunsafeFireworkEffectMeta clone()
	{
		return new RunsafeFireworkEffectMeta(effectMeta.clone());
	}
}
