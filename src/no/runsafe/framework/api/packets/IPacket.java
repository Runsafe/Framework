package no.runsafe.framework.api.packets;

import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.packets.PacketType;

public interface IPacket
{
	PacketType getPacketType();
	void send(IPlayer player);
}
