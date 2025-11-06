package no.runsafe.framework.internal.event.listener.entity;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		BukkitEventMapper.Register(CreatureSpawn.Factory());
		BukkitEventMapper.Register(DamageByEntity.Factory());
		BukkitEventMapper.Register(Death.Factory());
		BukkitEventMapper.Register(ShootBow.Factory());
		BukkitEventMapper.Register(SpawnEggUsed.Factory());
		BukkitEventMapper.Register(NaturalSpawn.Factory());
		BukkitEventMapper.Register(ChangeBlock.Factory());
		BukkitEventMapper.Register(Teleport.Factory());
		BukkitEventMapper.Register(TeleportEvent.Factory());
		BukkitEventMapper.Register(PortalEnter.Factory());
		BukkitEventMapper.Register(Portal.Factory());
		BukkitEventMapper.Register(PortalEvent.Factory());
		BukkitEventMapper.Register(CreatePortal.Factory());
		BukkitEventMapper.Register(Damage.Factory());
		BukkitEventMapper.Register(ProjectileHit.Factory());
		BukkitEventMapper.Register(Tame.Factory());
		BukkitEventMapper.Register(ItemSpawn.Factory());
		BukkitEventMapper.Register(Explode.Factory());
		BukkitEventMapper.Register(ItemDespawn.Factory());
		BukkitEventMapper.Register(EntityToggleGlide.Factory());
	}
}
