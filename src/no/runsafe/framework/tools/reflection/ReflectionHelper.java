package no.runsafe.framework.tools.reflection;

import java.lang.reflect.Field;

public final class ReflectionHelper
{
	private ReflectionHelper()
	{}

	private static Field getField(Object object, String fieldName) throws Exception
	{
		return object.getClass().getField(fieldName);
	}

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
