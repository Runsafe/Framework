package no.runsafe.framework.minecraft.packets;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.internal.networking.NetworkPacket;

public class PacketUpdateSign extends NetworkPacket
{
	public PacketUpdateSign(ILocation location, String... lines)
	{
		this(location.getBlockX(), location.getBlockY(), location.getBlockZ(), lines);
	}

	public PacketUpdateSign(int x, int y, int z, String... lines)
	{
		setData("x", x);
		setData("y", y);
		setData("z", z);
		setData("lines", lines);
	}

	@Override
	public PacketType getPacketType()
	{
		return PacketType.UPDATE_SIGN;
	}
}
