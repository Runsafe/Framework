package no.runsafe.framework.event.listener.player;

import no.runsafe.framework.event.EventEngine;

public final class Factories
{
	public static void Register() throws InstantiationException, IllegalAccessException
	{
		EventEngine.Register(PlayerChangedWorld.Factory.class);
		EventEngine.Register(PlayerChat.Factory.class);
		EventEngine.Register(PlayerCommandPreprocess.Factory.class);
		EventEngine.Register(PlayerDeath.Factory.class);
		EventEngine.Register(PlayerDropItem.Factory.class);
		EventEngine.Register(PlayerInteract.Factory.class);
		EventEngine.Register(PlayerInteractEntity.Factory.class);
		EventEngine.Register(PlayerJoin.Factory.class);
		EventEngine.Register(PlayerKick.Factory.class);
		EventEngine.Register(PlayerLeftClick.Factory.class);
		EventEngine.Register(PlayerLogin.Factory.class);
		EventEngine.Register(PlayerMove.Factory.class);
		EventEngine.Register(PlayerPreLogin.Factory.class);
		EventEngine.Register(PlayerQuit.Factory.class);
		EventEngine.Register(PlayerRightClick.Factory.class);
		EventEngine.Register(PlayerRightClickListener.Factory.class);
		EventEngine.Register(PlayerRightClickSign.Factory.class);
		EventEngine.Register(PlayerTeleport.Factory.class);
	}
}
