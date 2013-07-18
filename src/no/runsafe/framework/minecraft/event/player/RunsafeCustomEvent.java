package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.player.IPlayerCustomEvent;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.minecraft.event.RunsafeInternalEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public abstract class RunsafeCustomEvent extends RunsafeInternalEvent
{
	public RunsafeCustomEvent(RunsafePlayer player, String event)
	{
		this.player = player;
		this.event = event;
	}

	public RunsafePlayer getPlayer()
	{
		return player;
	}

	public String getEvent()
	{
		return event;
	}

	public abstract Object getData();

	@Override
	public boolean Fire()
	{
		for (IKernel plugin : InjectionPlugin.Instances.values())
			for (IPlayerCustomEvent listener : plugin.getComponents(IPlayerCustomEvent.class))
				listener.OnPlayerCustomEvent(this);
		return true;
	}

	private final RunsafePlayer player;
	private final String event;
}
