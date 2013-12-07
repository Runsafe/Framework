package no.runsafe.framework.api.player;

import no.runsafe.framework.api.block.IBlock;
import no.runsafe.framework.minecraft.RunsafeLocation;

public interface IPlayerNotification
{
	void sendColouredMessage(String format, Object... params);

	void sendBlockChange(IBlock block, byte data);

	void sendBlockChange(RunsafeLocation location, int itemId, byte data);
}
