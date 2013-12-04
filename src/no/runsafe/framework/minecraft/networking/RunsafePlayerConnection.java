package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_6_R3.*;
import no.runsafe.framework.api.IOutput;

public class RunsafePlayerConnection extends PlayerConnection
{
	public RunsafePlayerConnection(MinecraftServer server, INetworkManager manager, EntityPlayer player, IOutput output)
	{
		super(server, manager, player);
		this.output = output;
	}

	@Override
	public void sendPacket(Packet packet)
	{
		super.sendPacket(packet);
		output.write("Packet send detected!");
	}

	private final IOutput output;
}
