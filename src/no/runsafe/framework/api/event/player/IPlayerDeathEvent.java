package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerDeathEvent;

public interface IPlayerDeathEvent extends IRunsafeEvent
{
	public void OnPlayerDeathEvent(RunsafePlayerDeathEvent event);
}
