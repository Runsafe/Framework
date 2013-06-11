package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

import java.util.List;

public class RunsafePlayerFakeChatEvent extends RunsafePlayerChatEvent
{
	public RunsafePlayerFakeChatEvent(RunsafePlayer player, String message)
	{
		super(null);
		this.player = player;
		this.message = message;
	}

	@Override
	public boolean getCancelled()
	{
		return cancelled;
	}

	@Override
	public void setCancelled(boolean cancel)
	{
		cancelled = cancel;
	}

	@Override
	public String getFormat()
	{
		return format;
	}

	@Override
	public void setFormat(String format)
	{
		this.format = format;
	}

	@Override
	public String getMessage()
	{
		return message;
	}

	@Override
	public void setMessage(String message)
	{
		this.message = message;
	}

	@Override
	public RunsafePlayer getPlayer()
	{
		return player;
	}

	@Override
	public List<RunsafePlayer> getRecipients()
	{
		return null;
	}

	private final RunsafePlayer player;
	private String message;
	private String format = "<%1$s> %2$s";
	private boolean cancelled;
}
