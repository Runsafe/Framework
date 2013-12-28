package no.runsafe.framework.api.networking;

import no.runsafe.framework.api.player.IPlayer;

public interface IPacket
{
	void sendPacket(IPlayer player);
}
