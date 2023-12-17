package no.runsafe.framework.internal.event.listener.enchantment;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		BukkitEventMapper.Register(EnchantItem.Factory());
		BukkitEventMapper.Register(PrepareItemEnchant.Factory());
	}
}
