package no.runsafe.framework.internal.networking;

import com.google.common.base.Charsets;
import net.minecraft.server.v1_7_R1.*;

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

		server.getLogger().info((new StringBuilder()).append(entityplayer.getName()).append("[").append(s).append("] logged in with entity id ").append(entityplayer.id).append(" at ([").append(entityplayer.world.worldData.getName()).append("] ").append(entityplayer.locX).append(", ").append(entityplayer.locY).append(", ").append(entityplayer.locZ).append(")").toString());
		WorldServer worldserver = server.getWorldServer(entityplayer.dimension);
		ChunkCoordinates chunkcoordinates = worldserver.getSpawn();
		a(entityplayer, null, worldserver);
		RunsafePlayerConnection playerconnection = new RunsafePlayerConnection(server, inetworkmanager, entityplayer);
		int maxPlayers = getMaxPlayers();
		if(maxPlayers > 60)
			maxPlayers = 60;
		playerconnection.sendPacket(new Packet1Login(entityplayer.id, worldserver.getWorldData().getType(), entityplayer.playerInteractManager.getGameMode(), worldserver.getWorldData().isHardcore(), worldserver.worldProvider.dimension, worldserver.difficulty, worldserver.getHeight(), maxPlayers));
		entityplayer.getBukkitEntity().sendSupportedChannels();
		playerconnection.sendPacket(new Packet250CustomPayload("MC|Brand", getServer().getServerModName().getBytes(Charsets.UTF_8)));
		playerconnection.sendPacket(new Packet6SpawnPosition(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z));
		playerconnection.sendPacket(new Packet202Abilities(entityplayer.abilities));
		playerconnection.sendPacket(new Packet16BlockItemSwitch(entityplayer.inventory.itemInHandIndex));
		a((ScoreboardServer)worldserver.getScoreboard(), entityplayer);
		b(entityplayer, worldserver);
		c(entityplayer);
		playerconnection.a(entityplayer.locX, entityplayer.locY, entityplayer.locZ, entityplayer.yaw, entityplayer.pitch);
		server.ag().a(playerconnection);
		playerconnection.sendPacket(new Packet4UpdateTime(worldserver.getTime(), worldserver.getDayTime(), worldserver.getGameRules().getBoolean("doDaylightCycle")));
		if(server.getTexturePack().length() > 0)
			entityplayer.a(server.getTexturePack(), server.U());

		MobEffect mobeffect;
		for (Iterator iterator = entityplayer.getEffects().iterator(); iterator.hasNext(); playerconnection.sendPacket(new Packet41MobEffect(entityplayer.id, mobeffect)))
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

	private void a(EntityPlayer entityplayer, EntityPlayer entityplayer1, World world)
	{
		if(entityplayer1 != null)
			entityplayer.playerInteractManager.setGameMode(entityplayer1.playerInteractManager.getGameMode());
		else if(l != null)
			entityplayer.playerInteractManager.setGameMode(l); // This is always null?!

		entityplayer.playerInteractManager.b(world.getWorldData().getGameType());
	}

	private final DedicatedServer server;
	private EnumGamemode l;
}
