package no.runsafe.framework.internal.networking;

import net.minecraft.server.v1_6_R3.*;
import org.apache.commons.io.Charsets;

import java.util.Iterator;

public class RunsafePlayerList extends DedicatedPlayerList
{
	public RunsafePlayerList(DedicatedServer server)
	{
		super(server);
		this.server = server;
	}

	@Override
	public void a(INetworkManager inetworkmanager, EntityPlayer entityplayer)
	{
		// ToDO: Clean-up decompiled code.
		NBTTagCompound nbttagcompound = a(entityplayer);
		entityplayer.spawnIn(server.getWorldServer(entityplayer.dimension));
		entityplayer.playerInteractManager.a((WorldServer)entityplayer.world);

		String s = "local";
		if(inetworkmanager.getSocketAddress() != null)
			s = inetworkmanager.getSocketAddress().toString();

		server.getLogger().info(entityplayer.getName() + '[' + s + "] logged in with entity id " + entityplayer.id + " at ([" + entityplayer.world.worldData.getName() + "] " + entityplayer.locX + ", " + entityplayer.locY + ", " + entityplayer.locZ + ')');
		WorldServer worldserver = server.getWorldServer(entityplayer.dimension);
		ChunkCoordinates chunkcoordinates = worldserver.getSpawn();
		a(entityplayer, null, worldserver);
		RunsafePlayerConnection playerConnection = new RunsafePlayerConnection(server, inetworkmanager, entityplayer);
		int max = getMaxPlayers();
		if(max > 60)
			max = 60;
		playerConnection.sendPacket(new Packet1Login(entityplayer.id, worldserver.getWorldData().getType(), entityplayer.playerInteractManager.getGameMode(), worldserver.getWorldData().isHardcore(), worldserver.worldProvider.dimension, worldserver.difficulty, worldserver.getHeight(), max));
		entityplayer.getBukkitEntity().sendSupportedChannels();
		playerConnection.sendPacket(new Packet250CustomPayload("MC|Brand", getServer().getServerModName().getBytes(Charsets.UTF_8)));
		playerConnection.sendPacket(new Packet6SpawnPosition(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z));
		playerConnection.sendPacket(new Packet202Abilities(entityplayer.abilities));
		playerConnection.sendPacket(new Packet16BlockItemSwitch(entityplayer.inventory.itemInHandIndex));
		a((ScoreboardServer)worldserver.getScoreboard(), entityplayer);
		b(entityplayer, worldserver);
		c(entityplayer);
		playerConnection.a(entityplayer.locX, entityplayer.locY, entityplayer.locZ, entityplayer.yaw, entityplayer.pitch);
		server.ag().a(playerConnection);
		playerConnection.sendPacket(new Packet4UpdateTime(worldserver.getTime(), worldserver.getDayTime(), worldserver.getGameRules().getBoolean("doDaylightCycle")));
		if(!server.getTexturePack().isEmpty())
			entityplayer.a(server.getTexturePack(), server.U());

		MobEffect mobeffect;
		for (Iterator<?> iterator = entityplayer.getEffects().iterator(); iterator.hasNext(); playerConnection.sendPacket(new Packet41MobEffect(entityplayer.id, mobeffect)))
			mobeffect = (MobEffect)iterator.next();

		entityplayer.syncInventory();
		if(nbttagcompound != null && nbttagcompound.hasKey("Riding"))
		{
			Entity entity = EntityTypes.a(nbttagcompound.getCompound("Riding"), worldserver);
			if(entity != null)
			{
				entity.p = true;
				worldserver.addEntity(entity);
				entityplayer.mount(entity);
				entity.p = false;
			}
		}
	}

	private void a(EntityPlayer playerOne, EntityPlayer playerTwo, World world)
	{
		if(playerTwo != null)
			playerOne.playerInteractManager.setGameMode(playerTwo.playerInteractManager.getGameMode());
		else if(l != null)
			playerOne.playerInteractManager.setGameMode(l); // This is always null?!

		playerOne.playerInteractManager.b(world.getWorldData().getGameType());
	}

	private final DedicatedServer server;
	private EnumGamemode l;
}
