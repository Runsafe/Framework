package no.runsafe.framework.minecraft.event.networking;

import net.minecraft.server.v1_6_R3.Packet;
import no.runsafe.framework.internal.networking.NetworkPacket;
import no.runsafe.framework.internal.networking.PacketWrapper;

public class RunsafeSendPacketEvent extends RunsafeCancellableNetworkEvent
{
	public RunsafeSendPacketEvent(Packet packet)
	{
		this(PacketWrapper.convert(packet));
	}

	public RunsafeSendPacketEvent(NetworkPacket packet)
	{
		this.packet = packet;
	}

	public NetworkPacket getPacket()
	{
		return packet;
	}

	private final NetworkPacket packet;
}
