package no.runsafe.framework.database;

import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
}
