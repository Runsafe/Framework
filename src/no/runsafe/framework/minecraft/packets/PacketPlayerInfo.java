package no.runsafe.framework.minecraft.packets;

import no.runsafe.framework.internal.networking.NetworkPacket;

public class PacketPlayerInfo extends NetworkPacket
{
	public PacketPlayerInfo(String playerName, boolean flag, int i)
	{
		// ToDo: Figure out what all this does.
		setData("a", playerName);
		setData("b", flag);
		setData("c", i);
	}

	@Override
	public PacketType getPacketType()
	{
		return PacketType.PLAYER_INFO;
	}
}
