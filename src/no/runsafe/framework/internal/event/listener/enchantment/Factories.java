package no.runsafe.framework.internal.event.listener.enchantment;

import no.runsafe.framework.internal.event.EventEngine;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		EventEngine.Register(EnchantItem.Factory());
		EventEngine.Register(PrepareItemEnchant.Factory());
	}
}
