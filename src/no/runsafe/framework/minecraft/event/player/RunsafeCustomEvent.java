package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.log.Debug;
import no.runsafe.framework.minecraft.event.RunsafeInternalEvent;

public abstract class RunsafeCustomEvent extends RunsafeInternalEvent
{
	protected RunsafeCustomEvent(IPlayer player, String event)
	{
		this.player = player;
		this.event = event;
	}

	public IPlayer getPlayer()
	{
		return player;
	}

	public String getEvent()
	{
		return event;
	}

	public abstract Object getData();

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public boolean Fire()
	{
		Debug.Global().debugFiner("Firing custom event %s.", getClass().getName());
		for (IPlayerCustomEvent listener : RunsafePlugin.getAllPluginComponents(IPlayerCustomEvent.class))
		{
			Debug.Global().debugFiner("Telling %s.", listener.getClass().getName());
			listener.OnPlayerCustomEvent(this);
		}
		return true;
	}

	private final IPlayer player;
	private final String event;
}
