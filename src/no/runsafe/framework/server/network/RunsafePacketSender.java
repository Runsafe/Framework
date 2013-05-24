package no.runsafe.framework.server.network;

import net.minecraft.server.v1_5_R3.EntityPlayer;
import net.minecraft.server.v1_5_R3.Packet3Chat;
import net.minecraft.server.v1_5_R3.PlayerConnection;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.bukkit.craftbukkit.v1_5_R3.entity.CraftPlayer;

public class RunsafePacketSender
{
	public RunsafePacketSender(RunsafePlayer player)
	{
		EntityPlayer rawPlayer = ((CraftPlayer) player.getRaw()).getHandle();
		this.playerConnection = rawPlayer.playerConnection;
	}

	public void sendChatPacket(String message)
	{
		this.playerConnection.sendPacket(new Packet3Chat(message));
	}

	private PlayerConnection playerConnection;
}
