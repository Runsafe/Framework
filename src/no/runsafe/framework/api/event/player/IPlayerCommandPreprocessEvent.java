package no.runsafe.framework.api.event.player;

import no.runsafe.framework.minecraft.event.player.RunsafePlayerCommandPreprocessEvent;
import no.runsafe.framework.api.event.IRunsafeEvent;

public interface IPlayerCommandPreprocessEvent extends IRunsafeEvent
{
	public void OnBeforePlayerCommand(RunsafePlayerCommandPreprocessEvent event);
}
