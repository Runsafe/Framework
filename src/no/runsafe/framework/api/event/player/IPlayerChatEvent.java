package no.runsafe.framework.api.event.player;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.minecraft.event.player.RunsafePlayerChatEvent;

public interface IPlayerChatEvent extends IRunsafeEvent
{
    void OnPlayerChatEvent(RunsafePlayerChatEvent event);
}
