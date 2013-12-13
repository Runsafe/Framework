package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.*;
import no.runsafe.framework.internal.wrapper.ObjectWrapper;
import no.runsafe.framework.minecraft.event.networking.RunsafeSendPacketEvent;

public class RunsafePlayerConnection extends PlayerConnection
{
	public RunsafePlayerConnection(MinecraftServer server, INetworkManager manager, EntityPlayer player)
	{
		super(server, manager, player);
	}

	@SuppressWarnings("LocalVariableOfConcreteClass")
	@Override
	public void sendPacket(Packet packet)
	{
		RunsafeSendPacketEvent event = new RunsafeSendPacketEvent(packet, ObjectWrapper.convert(player));
		event.Fire();

		if (!event.isCancelled())
			super.sendPacket(event.getPacket().getNMSPacket());
	}
}
