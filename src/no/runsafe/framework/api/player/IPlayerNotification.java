package no.runsafe.framework.api.player;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.block.IBlock;

public interface IPlayerNotification
{
	void sendColouredMessage(String format, Object... params);

	void sendBlockChange(IBlock block, byte data);

	void sendBlockChange(ILocation location, int itemId, byte data);
}
