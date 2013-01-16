package no.runsafe.framework.database;

import org.joda.time.DateTime;

import java.sql.Timestamp;

public abstract class Repository implements ISchemaChanges
{
	protected static DateTime convert(Timestamp timestamp)
	{
		if (timestamp == null)
			return null;
		return new DateTime(timestamp);
	}

	protected static Timestamp convert(DateTime dateTime)
	{
		if (dateTime == null)
			return null;
		return new Timestamp(dateTime.getMillis());
	}
}
