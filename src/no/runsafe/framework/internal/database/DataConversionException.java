package no.runsafe.framework.internal.database;

public class DataConversionException extends RuntimeException
{
	public DataConversionException(String message)
	{
		super(message);
	}

	public DataConversionException(Object value, Class<?> targetType)
	{
		super(String.format(
			"Conversion of value \"%s\" from type %s to %s is unsupported",
			value.toString(),
			value.getClass().getCanonicalName(),
			targetType.getCanonicalName()
		));
	}
}
