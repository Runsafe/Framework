package no.runsafe.framework.tools.nms;

import net.minecraft.server.v1_12_R1.Entity;
import net.minecraft.server.v1_12_R1.EntityTypes;

import java.lang.reflect.Field;
import java.util.Map;

public final class EntityRegister
{
	private EntityRegister()
	{
	}

	public static <E extends Entity> void registerEntity(Class<E> customClass, String name, int id)
	{
		Class<?> types = EntityTypes.class;

		getMap(types, "c").put(name, customClass);
		getMap(types, "d").put(customClass, name);
		//getMap(types, "e").put(id, customClass);
		getMap(types, "f").put(customClass, id);
		getMap(types, "g").put(name, id);
	}

	public static <E extends Entity> void registerOverrideEntity(Class<E> customClass, String name, int id)
	{
		Class<?> types = EntityTypes.class;

		getMap(types, "c").put(name, customClass);
		getMap(types, "d").put(customClass, name);
		getMap(types, "e").put(id, customClass);
		getMap(types, "f").put(customClass, id);
		getMap(types, "g").put(name, id);
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
