package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.EventEngine;

public final class Factories
{
	public static void Register() throws InstantiationException, IllegalAccessException
	{
		EventEngine.Register(CreatureSpawn.Factory.class);
		EventEngine.Register(EntityDamageByEntity.Factory.class);
		EventEngine.Register(EntityDeath.Factory.class);
		EventEngine.Register(EntityShootBow.Factory.class);
		EventEngine.Register(SpawnEggUsed.Factory.class);
	}
}
