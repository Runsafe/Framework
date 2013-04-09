package no.runsafe.framework.event.inventory;

import no.runsafe.framework.event.IRunsafeEvent;
import no.runsafe.framework.server.inventory.RunsafeInventory;
import no.runsafe.framework.server.player.RunsafePlayer;

public interface IChestClosed extends IRunsafeEvent
{
	void OnChestClosed(RunsafePlayer player, RunsafeInventory inventory);
}
