package no.runsafe.framework.internal.database;

public class DataConversionException extends RuntimeException
{
	public DataConversionException(String message)
	{
		super(message);
	}

	public DataConversionException(Object sourceType, Class<?> targetType)
	{
		super(String.format("Conversion from type %s to %s is unsupported", sourceType.getCanonicalName(), targetType.getCanonicalName()));
	}
}
