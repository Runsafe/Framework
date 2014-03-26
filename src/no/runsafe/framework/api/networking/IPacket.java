package no.runsafe.framework.api.networking;

import net.minecraft.server.v1_7_R2.Packet;
import no.runsafe.framework.api.player.IPlayer;

public interface IPacket
{
	void sendPacket(IPlayer player);
	Packet getRawPacket();
}
