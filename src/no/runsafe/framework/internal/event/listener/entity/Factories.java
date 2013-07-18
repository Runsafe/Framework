package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.internal.event.EventEngine;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		EventEngine.Register(CreatureSpawn.Factory());
		EventEngine.Register(EntityDamageByEntity.Factory());
		EventEngine.Register(EntityDeath.Factory());
		EventEngine.Register(EntityShootBow.Factory());
		EventEngine.Register(SpawnEggUsed.Factory());
		EventEngine.Register(NaturalSpawn.Factory());
		EventEngine.Register(EntityChangeBlock.Factory());
		EventEngine.Register(EntityPortalEnter.Factory());
		EventEngine.Register(EntityCreatePortal.Factory());
		EventEngine.Register(EntityDamage.Factory());
		EventEngine.Register(ProjectileHit.Factory());
	}
}
