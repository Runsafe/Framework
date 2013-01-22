package no.runsafe.framework.event.listener.entity;

public final class Registration
{
	public static void Run()
	{
		CreatureSpawn.Register();
		EntityDamageByEntity.Register();
		EntityDeath.Register();
		EntityShootBow.Register();
		SpawnEggUsed.Register();
	}
}
