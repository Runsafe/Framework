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
	 * Converts joda time {@link DateTime} into an SQL {@link Timestamp}
	 *
	 * @param dateTime A joda time DateTime
	 * @return The SQL timestamp object
	 */
	@Deprecated
	protected static Timestamp convert(DateTime dateTime)
	{
		if (dateTime == null)
			return null;
		return new Timestamp(dateTime.getMillis());
	}
}
