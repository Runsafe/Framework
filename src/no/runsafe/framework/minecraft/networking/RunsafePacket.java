package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_12_R1.EntityPlayer;
import net.minecraft.server.v1_12_R1.Packet;
import no.runsafe.framework.api.networking.IPacket;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;


public abstract class RunsafePacket implements IPacket
{
	@Override
	public void sendPacket(IPlayer player)
	{
		if (packet == null)
			return;

		CraftPlayer craftPlayer = ObjectUnwrapper.convert(player);

		if (craftPlayer == null)
			return;

		EntityPlayer rawPlayer = craftPlayer.getHandle();

		if (rawPlayer != null)
			rawPlayer.playerConnection.sendPacket(packet);
	}

	public void setPacket(Packet packet)
	{
		this.packet = packet;
	}

	@Override
	public Packet getRawPacket()
	{
		return packet;
	}

	protected Packet packet;
}
