package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.event.entity.RunsafeEntityDamageEvent;

public interface IPlayerDamageEvent extends IRunsafeEvent
{
	void OnPlayerDamage(IPlayer player, RunsafeEntityDamageEvent event);
}
