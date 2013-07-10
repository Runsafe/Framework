package no.runsafe.framework.minecraft.network;

import net.minecraft.server.v1_6_R2.*;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.player.RunsafePlayer;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftPlayer;

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

	public void sendNamedEntitySpawnPacket(RunsafeEntity entity)
	{
		Entity rawEntity = ((CraftEntity) entity.getRaw()).getHandle();
		this.playerConnection.sendPacket(new Packet20NamedEntitySpawn((EntityHuman) rawEntity));
	}

	private final PlayerConnection playerConnection;
}
