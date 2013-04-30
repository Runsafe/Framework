package no.runsafe.framework.event.listener.enchantment;

import no.runsafe.framework.event.EventEngine;

public class Factories
{
	public static void Register()
	{
		EventEngine.Register(EnchantItem.Factory());
		EventEngine.Register(PrepareItemEnchant.Factory());
	}
}
