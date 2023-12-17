package no.runsafe.framework.minecraft.event.player;

import org.bukkit.event.player.PlayerTeleportEvent;

public class RunsafePlayerTeleportEvent extends RunsafePlayerMoveEvent
{
	public RunsafePlayerTeleportEvent(PlayerTeleportEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	public boolean isByEnderPearl()
	{
		return event.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL;
	}

	public boolean isByCommand()
	{
		return event.getCause() == PlayerTeleportEvent.TeleportCause.COMMAND;
	}

	public boolean isByPlugin()
	{
		return event.getCause() == PlayerTeleportEvent.TeleportCause.PLUGIN;
	}

	public boolean isByNetherPortal()
	{
		return event.getCause() == PlayerTeleportEvent.TeleportCause.NETHER_PORTAL;
	}

	public boolean isByEndPortal()
	{
		return event.getCause() == PlayerTeleportEvent.TeleportCause.END_PORTAL;
	}

	public boolean isByUnknown()
	{
		return event.getCause() == PlayerTeleportEvent.TeleportCause.UNKNOWN;
	}

	private final PlayerTeleportEvent event;
}
