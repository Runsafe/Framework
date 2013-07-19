package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RunsafePlayerFakeChatEvent extends RunsafePlayerChatEvent
{
	@Nullable
	public static String Run(RunsafePlayer player, String message)
	{
		RunsafePlayerFakeChatEvent event = new RunsafePlayerFakeChatEvent(player, message);
		if (!event.Fire())
			return null;

		return String.format(event.format, event.player.getName(), event.message);
	}

	public static void Broadcast(RunsafePlayer player, String message)
	{
		String result = Run(player, message);
		if (result != null)
			RunsafeServer.Instance.broadcastMessage(result);
	}

	public RunsafePlayerFakeChatEvent(RunsafePlayer player, String message)
	{
		super(null);
		this.player = player;
		this.message = message;
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
	@Nullable
	public List<RunsafePlayer> getRecipients()
	{
		return null;
	}

	@Override
	public boolean isCancelled()
	{
		return cancelled;
	}

	@Override
	public void cancel()
	{
		cancelled = true;
		for (Runnable callback : cancellationCallbacks)
			callback.run();
	}

	@Override
	public void addCancellationHandle(Runnable callback)
	{
		if (cancellationCallbacks == null)
			cancellationCallbacks = new ArrayList<Runnable>(1);
		cancellationCallbacks.add(callback);
	}

	private Collection<Runnable> cancellationCallbacks;
	private final RunsafePlayer player;
	private String message;
	private String format = "<%1$s> %2$s";
	private boolean cancelled;
}
