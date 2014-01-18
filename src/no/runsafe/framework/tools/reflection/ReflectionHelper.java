package no.runsafe.framework.tools.reflection;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class ReflectionHelper
{
	private ReflectionHelper()
	{}

	private static Map<String, Field> getFullFieldList(Object object, HashMap<String, Field> map, Class<?> type)
	{
		if (map == null)
			map = new HashMap<String, Field>(0);

		if (type == null)
			type = object.getClass();

		for (Field field : type.getDeclaredFields())
			map.put(field.getName(), field);

		if (type.getSuperclass() != null)
			getFullFieldList(object, map, type.getSuperclass());

		return map;
	}

	@Nullable
	private static Field getField(Object object, String fieldName)
	{
		try
		{
			return object.getClass().getDeclaredField(fieldName);
		}
		catch (NoSuchFieldException exception)
		{
			Map<String, Field> fullFieldList = getFullFieldList(object, null, null);
			if (fullFieldList.containsKey(fieldName))
				return fullFieldList.get(fieldName);
		}
		return null;
	}

	@Nullable
	public static Object getObjectField(Object object, String fieldName)
	{
		try
		{
			Field field = getField(object, fieldName);
			field.setAccessible(true);
			return field.get(object);
		}
		catch (Exception e)
		{
			return null;
		}
	}

	public static void setField(Object object, String fieldName, Object value)
	{
		try
		{
			Field field = getField(object, fieldName);
			field.set(object, value);
		}
		catch(Exception e)
		{
			// Ignore.
		}
	}
}
