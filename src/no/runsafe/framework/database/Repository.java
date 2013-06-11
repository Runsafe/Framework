package no.runsafe.framework.database;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;

/**
 * Base class for database repositories, providing methods for converting SQL Timestamp to and from Joda DateTime
 */
public abstract class Repository implements ISchemaChanges
{
	/**
	 * Converts an SQL {@link Timestamp} into a joda time {@link DateTime}
	 *
	 * @param timestamp The SQL timestamp object
	 * @return A joda time DateTime
	 */
	@Deprecated
	protected static DateTime convert(Object timestamp)
	{
		if (timestamp == null)
			return null;
		return new DateTime(timestamp);
	}

	/**
	 * Converts joda time {@link DateTime} into an SQL {@link Timestamp}
	 *
	 * @param dateTime A joda time DateTime
	 * @return The SQL timestamp object
	 */
	protected static Timestamp convert(DateTime dateTime)
	{
		if (dateTime == null)
			return null;
		return new Timestamp(dateTime.getMillis());
	}

	/**
	 * Use this to read a long value from the database.
	 * This will work around certain type bugs in the database driver.
	 *
	 * @param value A value fetched from the database
	 * @return A long value or NULL if the value is unsupported
	 */
	@Deprecated
	protected static Long getLongValue(Object value)
	{
		if (value instanceof BigDecimal)
			return ((BigDecimal) value).longValue();

		if (value instanceof String)
			return Long.valueOf((String) value);

		if (value instanceof Long)
			return (Long) value;

		if (value instanceof Integer)
			return Long.valueOf((Integer) value);

		return null;
	}

	@Deprecated
	protected static Double getDoubleValue(Map<String, Object> row, String key)
	{
		if(row == null || row.isEmpty() || !row.containsKey(key))
			return null;

		Object value = row.get(key);

		if(value instanceof Float)
			return ((Float) value).doubleValue();

		if(value instanceof Double)
			return (Double) value;

		if(value instanceof String)
			return Double.valueOf((String) value);

		if(value instanceof Long)
			return ((Long) value).doubleValue();

		if(value instanceof Integer)
			return ((Integer) value).doubleValue();

		return null;
	}

	@Deprecated
	protected static Float getFloatValue(Map<String, Object> row, String key)
	{
		if(row == null || row.isEmpty() || !row.containsKey(key))
			return null;

		Object value = row.get(key);

		if(value instanceof Float)
			return (Float)value;

		if(value instanceof Double)
			return ((Double) value).floatValue();

		if(value instanceof String)
			return Float.valueOf((String) value);

		if(value instanceof Long)
			return ((Long) value).floatValue();

		if(value instanceof Integer)
			return ((Integer) value).floatValue();

		return null;
	}
}
