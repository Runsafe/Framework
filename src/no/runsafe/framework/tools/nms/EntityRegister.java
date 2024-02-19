package no.runsafe.framework.tools.nms;

import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityTypes;
import net.minecraft.server.v1_12_R1.MinecraftKey;

public final class EntityRegister
{
	private EntityRegister()
	{
	}

	public static <E extends Entity> void registerEntity(Class<E> customClass, String name, int id)
	{
		MinecraftKey key = new MinecraftKey(name);
		EntityTypes.b.a(id, key, customClass);
		EntityTypes.d.add(key);
	}

	public static <E extends Entity> void registerOverrideEntity(Class<E> customClass, String name, int id)
	{
		registerEntity(customClass, name, id);
	}
}
