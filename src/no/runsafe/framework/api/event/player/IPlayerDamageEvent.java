package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public interface IPlayerDamageEvent extends IRunsafeEvent
{
	void OnPlayerDamage(RunsafePlayer player, RunsafeEntityDamageEvent event);
}
