package no.runsafe.framework.minecraft.networking;

import net.minecraft.server.v1_12_R1.PacketPlayOutSpawnEntityLiving;
import no.runsafe.framework.tools.reflection.ReflectionHelper;

public class PacketSpawnLivingEntity extends RunsafePacket
{
	public PacketSpawnLivingEntity(int entityID, byte entityType, int x, int y, int z)
	{
		PacketPlayOutSpawnEntityLiving raw = new PacketPlayOutSpawnEntityLiving();

		/*
		 * Variable names in various spigot versions:
		 * Type    1.8    1.10+  Description
		 * int     a      a      EntityID
		 * int     b      c      EntityType
		 * int     c      N/A    X location divided by 32
		 * int     d      N/A    Y location divided by 32
		 * int     e      N/A    Z location divided by 32
		 * double  N/A    d      Exact X location.
		 * double  N/A    e      Exact Y location.
		 * double  N/A    f      Exact Z location.
		 * int     f      g      Unknown
		 * int     g      h      Unknown
		 * int     h      i      Unknown
		 * byte    i      j      Yaw
		 * byte    j      k      Pitch
		 * byte    k      l      Head rotation
		 * UUID    N/A    b      Unique ID.
		 */
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
