package no.runsafe.framework.player.event;

import no.runsafe.framework.item.RunsafeItem;
import no.runsafe.framework.player.RunsafePlayer;

public interface IPlayerDropItemEvent 
{
	public boolean OnPlayerDropItem(RunsafePlayer player, RunsafeItem item);
}
