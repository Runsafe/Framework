package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_7_R1.DataWatcher;
import net.minecraft.server.v1_7_R1.Packet;
import net.minecraft.server.v1_7_R1.PacketPlayOutSpawnEntityLiving;
import no.runsafe.framework.minecraft.entity.LivingEntity;
import no.runsafe.framework.tools.reflection.ReflectionHelper;
import org.bukkit.entity.EntityType;

import java.lang.reflect.Field;

public class PacketSetBossBar extends RunsafePacket
{
	public PacketSetBossBar(String text, int health)
	{
		PacketSpawnLivingEntity spawnPacket = new PacketSpawnLivingEntity(1234, (byte) 64, 0, 0, 0);
		PacketPlayOutSpawnEntityLiving raw = (PacketPlayOutSpawnEntityLiving) spawnPacket.getRawPacket();

		DataWatcher watcher = new DataWatcher(null);
		watcher.a(0, (byte) 0x20);
		watcher.a(6, (float) health);
		watcher.a(10, (String) text);
		watcher.a(11, (byte) 1);

		try
		{
			Field dataField = PacketPlayOutSpawnEntityLiving.class.getDeclaredField("l");
			dataField.setAccessible(true);
			dataField.set(raw, watcher);
		}
		catch (Exception e)
		{
			// Ru-roh!
		}
		setPacket(raw);
	}

	public PacketSetBossBar(String text)
	{
		this(text, 0);
	}
}
