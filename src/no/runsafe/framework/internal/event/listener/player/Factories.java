package no.runsafe.framework.internal.event.listener.player;

import no.runsafe.framework.internal.event.EventEngine;

public final class Factories
{
	private Factories()
	{
	}

	public static void Register()
	{
		EventEngine.Register(PlayerChangedWorld.Factory());
		EventEngine.Register(PlayerChat.Factory());
		EventEngine.Register(PlayerCommandPreprocess.Factory());
		EventEngine.Register(PlayerDeath.Factory());
		EventEngine.Register(PlayerDropItem.Factory());
		EventEngine.Register(PlayerInteract.Factory());
		EventEngine.Register(PlayerInteractEntity.Factory());
		EventEngine.Register(PlayerJoin.Factory());
		EventEngine.Register(PlayerKick.Factory());
		EventEngine.Register(PlayerLeftClick.Factory());
		EventEngine.Register(PlayerLogin.Factory());
		EventEngine.Register(PlayerMove.Factory());
		EventEngine.Register(PlayerPreLogin.Factory());
		EventEngine.Register(PlayerQuit.Factory());
		EventEngine.Register(PlayerRespawn.Factory());
		EventEngine.Register(PlayerRightClick.Factory());
		EventEngine.Register(PlayerRightClickSign.Factory());
		EventEngine.Register(PlayerTeleport.Factory());
		EventEngine.Register(PlayerPortal.Factory());
		EventEngine.Register(PlayerPortalEvent.Factory());
		EventEngine.Register(PlayerPickupItem.Factory());
		EventEngine.Register(PlayerTeleportEvent.Factory());
		EventEngine.Register(PlayerDamage.Factory());
		EventEngine.Register(PlayerFish.Factory());
	}
}
