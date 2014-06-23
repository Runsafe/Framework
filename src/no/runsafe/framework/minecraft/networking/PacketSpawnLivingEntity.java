package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_7_R3.PacketPlayOutSpawnEntityLiving;
import no.runsafe.framework.tools.reflection.ReflectionHelper;

public class PacketSpawnLivingEntity extends RunsafePacket
{
	public PacketSpawnLivingEntity(int entityID, byte entityType, int x, int y, int z)
	{
		PacketPlayOutSpawnEntityLiving raw = new PacketPlayOutSpawnEntityLiving();

		ReflectionHelper.setField(raw, "a", entityID);
		ReflectionHelper.setField(raw, "b", entityType);
		ReflectionHelper.setField(raw, "c", x);
		ReflectionHelper.setField(raw, "d", y);
		ReflectionHelper.setField(raw, "e", z);
		ReflectionHelper.setField(raw, "f", (byte) 0);
		ReflectionHelper.setField(raw, "g", (byte) 0);
		ReflectionHelper.setField(raw, "h", (byte) 0);
		ReflectionHelper.setField(raw, "i", (byte) 0);
		ReflectionHelper.setField(raw, "j", (byte) 0);
		ReflectionHelper.setField(raw, "k", (byte) 0);

		setPacket(raw);
	}
}
