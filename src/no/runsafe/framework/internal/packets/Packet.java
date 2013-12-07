package no.runsafe.framework.internal.packets;

import no.runsafe.framework.api.player.IPlayer;

public abstract class Packet implements IPacket
{
	protected Packet(String packetName)
	{
		this.packetName = packetName;
	}

	public void send(IPlayer player) throws Exception
	{
		PacketHelper.sendPacket(player, PacketHelper.stuffPacket(PacketHelper.getPacket(packetName), prepareData()));
	}

	private final String packetName;
}