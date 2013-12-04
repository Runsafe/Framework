package no.runsafe.framework.internal.reflection;

import java.lang.reflect.Field;

public class ReflectionHelper
{
	public static Object getFieldObject(Object object, String fieldName) throws Exception
	{
		Field field = getField(object, fieldName);
		field.setAccessible(true);
		return field.get(object);
	}

	public static Field getField(Object object, String fieldName) throws Exception
	{
		return object.getClass().getDeclaredField(fieldName);
	}
}
