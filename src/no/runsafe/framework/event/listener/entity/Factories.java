package no.runsafe.framework.event.listener.entity;

import no.runsafe.framework.event.EventEngine;

public final class Factories
{
	public static void Register()
	{
		EventEngine.Register(CreatureSpawn.Factory());
		EventEngine.Register(EntityDamageByEntity.Factory());
		EventEngine.Register(EntityDeath.Factory());
		EventEngine.Register(EntityShootBow.Factory());
		EventEngine.Register(SpawnEggUsed.Factory());
		EventEngine.Register(NaturalSpawn.Factory());
		EventEngine.Register(EntityChangeBlock.Factory());
	}
}
