package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_7_R1.DataWatcher;
import net.minecraft.server.v1_7_R1.Packet;
import net.minecraft.server.v1_7_R1.PacketPlayOutSpawnEntityLiving;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.tools.reflection.ReflectionHelper;
import org.bukkit.entity.EntityType;

public class PacketSetBossBar extends RunsafePacket
{
	public PacketSetBossBar(String text, int health)
	{
		PacketSpawnLivingEntity spawnPacket = new PacketSpawnLivingEntity(1234, (byte) LivingEntity.Wither.getId(), 0, 0, 0);
		PacketPlayOutSpawnEntityLiving raw = (PacketPlayOutSpawnEntityLiving) spawnPacket.getRawPacket();

		DataWatcher watcher = new DataWatcher(null);
		watcher.a(0, (byte) 0x20);
		watcher.a(6, (float) health);
		watcher.a(10, (String) text);
		watcher.a(11, (byte) 1);

		ReflectionHelper.setField(raw, "l", watcher);
		setPacket(raw);
	}

	public PacketSetBossBar(String text)
	{
		this(text, 0);
	}
}
