package no.runsafe.framework.internal;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class RunsafeLogFormatter extends SimpleFormatter
{
	@Override
	public synchronized String format(LogRecord record)
	{
		String message = formatMessage(record);
		return String.format(
			"[%s] %s: %s\n",
			timestamp.print(record.getMillis()),
			record.getLevel().getName(),
			message
		);
	}

	private final DateTimeFormatter timestamp = new DateTimeFormatterBuilder()
		.appendHourOfDay(2).appendLiteral(':').appendMinuteOfHour(2).appendLiteral(':').appendSecondOfMinute(2)
		.toFormatter();
}
