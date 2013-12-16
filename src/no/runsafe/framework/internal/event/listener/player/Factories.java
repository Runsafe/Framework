package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.internal.event.BukkitEventMapper;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		BukkitEventMapper.Register(PlayerChangedWorld.Factory());
		BukkitEventMapper.Register(Chat.Factory());
		BukkitEventMapper.Register(CommandPreprocess.Factory());
		BukkitEventMapper.Register(Death.Factory());
		BukkitEventMapper.Register(DropItem.Factory());
		BukkitEventMapper.Register(Interact.Factory());
		BukkitEventMapper.Register(InteractEntity.Factory());
		BukkitEventMapper.Register(Join.Factory());
		BukkitEventMapper.Register(Kick.Factory());
		BukkitEventMapper.Register(LeftClick.Factory());
		BukkitEventMapper.Register(Login.Factory());
		BukkitEventMapper.Register(Move.Factory());
		BukkitEventMapper.Register(PreLogin.Factory());
		BukkitEventMapper.Register(Quit.Factory());
		BukkitEventMapper.Register(Respawn.Factory());
		BukkitEventMapper.Register(RightClick.Factory());
		BukkitEventMapper.Register(RightClickSign.Factory());
		BukkitEventMapper.Register(Teleport.Factory());
		BukkitEventMapper.Register(Portal.Factory());
		BukkitEventMapper.Register(PortalEvent.Factory());
		BukkitEventMapper.Register(PickupItem.Factory());
		BukkitEventMapper.Register(TeleportEvent.Factory());
		BukkitEventMapper.Register(Damage.Factory());
		BukkitEventMapper.Register(Fish.Factory());
	}
}
