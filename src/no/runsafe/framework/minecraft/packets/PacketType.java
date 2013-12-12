package no.runsafe.framework.minecraft.packets;

import net.minecraft.server.v1_6_R3.Packet;
import net.minecraft.server.v1_6_R3.Packet130UpdateSign;
import net.minecraft.server.v1_6_R3.Packet63WorldParticles;

public enum PacketType
{
	WORLD_PARTICLES(Packet63WorldParticles.class),
	UPDATE_SIGN(Packet130UpdateSign.class);

	PacketType(Class<? extends Packet> packetClass)
	{
		this.packetClass = packetClass;
	}

	public Packet makePacket() throws Exception
	{
		return packetClass.newInstance();
	}

	private final Class<? extends Packet> packetClass;
}
