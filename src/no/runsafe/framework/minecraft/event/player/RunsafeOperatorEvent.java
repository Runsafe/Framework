package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.player.IPlayerOperatorEvent;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.minecraft.event.RunsafeInternalEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class RunsafeOperatorEvent extends RunsafeInternalEvent
{
	public RunsafeOperatorEvent(RunsafePlayer player, boolean wasMadeOP)
	{
		this.player = player;
		op = wasMadeOP;
	}

	public RunsafePlayer getPlayer()
	{
		return player;
	}

	public boolean wasMadeOP()
	{
		return op;
	}

	@SuppressWarnings("MethodWithMultipleLoops")
	@Override
	public boolean Fire()
	{
		for (IKernel plugin : InjectionPlugin.Instances.values())
			for (IPlayerOperatorEvent listener : plugin.getComponents(IPlayerOperatorEvent.class))
				listener.OnPlayerOP(this);
		return true;
	}

	private final RunsafePlayer player;
	private final boolean op;
}
