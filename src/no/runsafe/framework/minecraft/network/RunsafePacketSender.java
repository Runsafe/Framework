package no.runsafe.framework.minecraft.network;

import net.minecraft.server.v1_6_R2.*;
import no.runsafe.framework.internal.wrapper.ObjectUnwrapper;
import no.runsafe.framework.minecraft.entity.RunsafeEntity;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

import javax.annotation.Nonnull;

public class RunsafePacketSender
{
	public RunsafePacketSender(@Nonnull RunsafePlayer player)
	{
		EntityPlayer nmsPlayer = ObjectUnwrapper.convert(player);
		assert nmsPlayer != null;
		playerConnection = nmsPlayer.playerConnection;
	}

	public void sendChatPacket(String message)
	{
		playerConnection.sendPacket(new Packet3Chat(message));
	}

	public void sendNamedEntitySpawnPacket(RunsafeEntity entity)
	{
		Entity rawEntity = ObjectUnwrapper.convert(entity);
		playerConnection.sendPacket(new Packet20NamedEntitySpawn((EntityHuman) rawEntity));
	}

	private final PlayerConnection playerConnection;
}
