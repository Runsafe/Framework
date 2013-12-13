package no.runsafe.framework.minecraft.packets;

import net.minecraft.server.v1_6_R3.Packet;
import net.minecraft.server.v1_6_R3.Packet130UpdateSign;
import net.minecraft.server.v1_6_R3.Packet201PlayerInfo;
import net.minecraft.server.v1_6_R3.Packet63WorldParticles;
import no.runsafe.framework.internal.networking.NetworkPacket;

public enum PacketType
{
	WORLD_PARTICLES(Packet63WorldParticles.class, PacketWorldParticles.class),
	UPDATE_SIGN(Packet130UpdateSign.class, PacketUpdateSign.class),
	PLAYER_INFO(Packet201PlayerInfo.class, PacketPlayerInfo.class);

	PacketType(Class<? extends Packet> packetClass, Class<? extends NetworkPacket> wrapper)
	{
		this.packetClass = packetClass;
		this.wrapper = wrapper;
	}

	public Class<? extends Packet> getPacketClass()
	{
		return packetClass;
	}

	public Class<? extends NetworkPacket> getWrapperClass()
	{
		return wrapper;
	}

	public Packet makePacket() throws Exception
	{
		return packetClass.newInstance();
	}

	public NetworkPacket makeWrapper() throws Exception
	{
		return wrapper.newInstance();
	}

	private final Class<? extends Packet> packetClass;
	private final Class<? extends NetworkPacket> wrapper;
}
