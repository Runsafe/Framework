package no.runsafe.framework.event.listener.player;

public final class Registration
{
	public static void Run()
	{
		PlayerChangedWorld.Register();
		PlayerChat.Register();
		PlayerCommandPreprocess.Register();
		PlayerDeath.Register();
		PlayerDropItem.Register();
		PlayerInteract.Register();
		PlayerInteractEntity.Register();
		PlayerJoin.Register();
		PlayerKick.Register();
		PlayerLeftClick.Register();
		PlayerLogin.Register();
		PlayerMove.Register();
		PlayerPreLogin.Register();
		PlayerQuit.Register();
		PlayerRightClick.Register();
		PlayerRightClickListener.Register();
		PlayerRightClickSign.Register();
		PlayerTeleport.Register();
	}
}
