package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.IFakeableEvent;
import no.runsafe.framework.api.event.player.IPlayerChatEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import org.bukkit.OfflinePlayer;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.List;

//import org.bukkit.event.player.PlayerChatEvent;

public class RunsafePlayerChatEvent extends RunsafeCancellablePlayerEvent implements IFakeableEvent
{
	public RunsafePlayerChatEvent(AsyncPlayerChatEvent toWrap)
	{
		super(toWrap);
		event = toWrap;
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

	@Override
	public IPlayer getPlayer()
	{
		return ObjectWrapper.convert((OfflinePlayer) event.getPlayer());
	}

	public List<IPlayer> getRecipients()
	{
		return ObjectWrapper.convert(event.getRecipients());
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public boolean Fire()
	{
		isFake = true;
		for (IPlayerChatEvent listener : RunsafePlugin.getAllPluginComponents(IPlayerChatEvent.class))
			listener.OnPlayerChatEvent(this);
		return !isCancelled();
	}

	@Override
	public boolean isFake()
	{
		return isFake;
	}

	private final AsyncPlayerChatEvent event;
	private boolean isFake;
}
