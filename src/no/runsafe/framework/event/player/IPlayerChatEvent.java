package no.runsafe.framework.event.player;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.event.player.RunsafePlayerChatEvent;

public interface IPlayerChatEvent extends IRunsafeEvent
{
    public void OnPlayerChatEvent(RunsafePlayerChatEvent event);
}
