package no.runsafe.framework.internal.packets;

import no.runsafe.framework.minecraft.player.RunsafePlayer;

public abstract class Packet implements IPacket
{
	protected Packet(String packetName)
	{
		this.packetName = packetName;
	}

	public void send(RunsafePlayer player) throws Exception
	{
		PacketHelper.sendPacket(player, PacketHelper.stuffPacket(PacketHelper.getPacket(packetName), prepareData()));
	}

	private String packetName;
}
