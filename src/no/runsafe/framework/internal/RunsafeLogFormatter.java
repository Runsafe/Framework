package no.runsafe.framework.internal;

import no.runsafe.framework.api.IConsole;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class RunsafeLogFormatter extends SimpleFormatter
{
	@SuppressWarnings("StringConcatenationInFormatCall")
	@Override
	public synchronized String format(LogRecord record)
	{
		String logFormat = null;
		String message = formatMessage(record);
		if (record.getParameters() != null && record.getParameters().length > 0)
		{
			Object param = record.getParameters()[0];
			if (param instanceof IConsole)
				logFormat = ((IConsole) param).getLogFormat();
		}
		return String.format(
			logFormat + '\n',
			datestamp.print(record.getMillis()),
			timestamp.print(record.getMillis()),
			Console.colorize(record.getLevel()),
			message
		);
	}

	private final DateTimeFormatter datestamp = new DateTimeFormatterBuilder()
		.appendYear(4, 4).appendLiteral('-').appendMonthOfYear(2).appendLiteral('-').appendDayOfMonth(2)
		.toFormatter();
	private final DateTimeFormatter timestamp = new DateTimeFormatterBuilder()
		.appendHourOfDay(2).appendLiteral(':').appendMinuteOfHour(2).appendLiteral(':').appendSecondOfMinute(2)
		.toFormatter();
}
