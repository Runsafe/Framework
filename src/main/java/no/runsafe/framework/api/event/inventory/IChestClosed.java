package no.runsafe.framework.api.event.inventory;

import no.runsafe.framework.api.event.IRunsafeEvent;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.inventory.RunsafeInventory;

public interface IChestClosed extends IRunsafeEvent
{
	void OnChestClosed(IPlayer player, RunsafeInventory inventory);
}
