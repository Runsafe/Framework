package no.runsafe.framework.minecraft.event.networking;

import net.minecraft.server.v1_6_R3.Packet;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.networking.NetworkPacket;
import no.runsafe.framework.internal.networking.PacketWrapper;

public class RunsafeSendPacketEvent extends RunsafeCancellableNetworkEvent
{
	public RunsafeSendPacketEvent(Packet packet, IPlayer player)
	{
		this(PacketWrapper.convert(packet), player);
	}

	public RunsafeSendPacketEvent(NetworkPacket packet, IPlayer player)
	{
		this.packet = packet;
		this.player = player;
	}

	public NetworkPacket getPacket()
	{
		return packet;
	}

	public IPlayer getPlayer()
	{
		return player;
	}

	private final NetworkPacket packet;
	private final IPlayer player;
}
