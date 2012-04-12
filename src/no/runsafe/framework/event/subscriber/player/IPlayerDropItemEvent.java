package no.runsafe.framework.event.subscriber.player;

import no.runsafe.framework.event.subscriber.IRunsafeEvent;
import no.runsafe.framework.item.RunsafeItem;
import no.runsafe.framework.player.RunsafePlayer;

public interface IPlayerDropItemEvent extends IRunsafeEvent
{
	public boolean OnPlayerDropItem(RunsafePlayer player, RunsafeItem item);
}
