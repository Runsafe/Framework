package no.runsafe.framework.tools.nms;

import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityTypes;
import net.minecraft.server.v1_12_R1.MinecraftKey;

import java.io.DataOutput;
import java.lang.reflect.Field;
import java.util.Map;
import java.lang.reflect.Method;

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

	private static Map getMap(Class typeClass, String fieldName)
	{
		try
		{
			Field field = typeClass.getDeclaredField(fieldName);
			field.setAccessible(true);
			return (Map) field.get(null);
		}
		catch (NoSuchFieldException e)
		{
			return null;
		}
		catch (IllegalAccessException e)
		{
			return null;
		}
	}
}
