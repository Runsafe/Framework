package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.Packet;
import no.runsafe.framework.minecraft.packets.PacketType;

import javax.annotation.Nullable;

public final class PacketWrapper
{
	private PacketWrapper()
	{}

	@Nullable
	@SuppressWarnings("LocalVariableOfConcreteClass")
	public static NetworkPacket convert(Packet packet)
	{
		Class<? extends Packet> packetClass = packet.getClass();
		for (PacketType type : PacketType.values())
		{
			if (type.getWrapperClass().equals(packetClass))
			{
				try
				{
					NetworkPacket wrapper = type.makeWrapper();
					wrapper.setWrappedPacket(packet);
					return wrapper;
				}
				catch (Exception exception)
				{
					// Ignore.
				}
			}
		}
		return null;
	}
}
