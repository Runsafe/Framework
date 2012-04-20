package no.runsafe.framework.server.event.player;

import no.runsafe.framework.server.event.CancellableEvent;
import no.runsafe.framework.server.player.RunsafePlayer;
import no.runsafe.framework.server.player.RunsafePlayerList;
import org.bukkit.event.player.PlayerChatEvent;

public class RunsafePlayerChatEvent extends RunsafePlayerEvent implements CancellableEvent
{
	public RunsafePlayerChatEvent(PlayerChatEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
	}

	@Override
	public boolean getCancelled()
	{
		return event.isCancelled();
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		event.setCancelled(cancel);
	}

	public String getFormat()
	{
		return event.getFormat();
	}

	public void setFormat(String format)
	{
		event.setFormat(format);
	}

	public String getMessage()
	{
		return event.getMessage();
	}

	public void setMessage(String message)
	{
		event.setMessage(message);
	}

    public RunsafePlayer getPlayer()
    {
        return new RunsafePlayer(event.getPlayer());
    }

	public void setPlayer(RunsafePlayer player)
	{
		event.setPlayer(player.getRaw());
	}

	public RunsafePlayerList getRecipients()
	{
		return new RunsafePlayerList(event.getRecipients());
	}

	PlayerChatEvent event;
}
