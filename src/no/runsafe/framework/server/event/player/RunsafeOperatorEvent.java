package no.runsafe.framework.server.event.player;

import no.runsafe.framework.IKernel;
import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.event.player.IPlayerOperatorEvent;
import no.runsafe.framework.server.event.RunsafeInternalEvent;
import no.runsafe.framework.server.player.RunsafePlayer;

public class RunsafeOperatorEvent extends RunsafeInternalEvent
{
	public RunsafeOperatorEvent(RunsafePlayer player, boolean wasMadeOP)
	{
		this.player = player;
		this.op = wasMadeOP;
	}

	public RunsafePlayer getPlayer()
	{
		return player;
	}

	public boolean wasMadeOP()
	{
		return op;
	}

	@Override
	public void Fire()
	{
		for (IKernel plugin : RunsafePlugin.Instances.values())
			for (IPlayerOperatorEvent listener : plugin.getComponents(IPlayerOperatorEvent.class))
				listener.OnPlayerOP(this);
	}

	private final RunsafePlayer player;
	private final boolean op;
}
