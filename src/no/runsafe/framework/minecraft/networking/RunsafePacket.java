package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_7_R1.EntityPlayer;
import net.minecraft.server.v1_7_R1.Packet;
import no.runsafe.framework.api.networking.IPacket;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;


public abstract class RunsafePacket implements IPacket
{
	@Override
	public void sendPacket(IPlayer player)
	{
		if (packet == null)
			return;

		EntityPlayer rawPlayer = ObjectUnwrapper.convert(player);

		if (rawPlayer != null)
			rawPlayer.playerConnection.sendPacket(packet);
	}

	public void setPacket(Packet packet)
	{
		this.packet = packet;
	}

	protected Packet packet;
}
