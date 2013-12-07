package no.runsafe.framework.minecraft.event.player;

import no.runsafe.framework.api.IKernel;
import no.runsafe.framework.api.event.player.IPlayerOperatorEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.minecraft.event.RunsafeInternalEvent;

public class RunsafeOperatorEvent extends RunsafeInternalEvent
{
	public RunsafeOperatorEvent(IPlayer player, boolean wasMadeOP)
	{
		this.player = player;
		op = wasMadeOP;
	}

	public IPlayer getPlayer()
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

	private final IPlayer player;
	private final boolean op;
}
