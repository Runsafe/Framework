package no.runsafe.framework.internal;

import no.runsafe.framework.internal.log.ILogFormatProvider;
import no.runsafe.framework.internal.log.LogFileHandler;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public final class RunsafeLogFormatter extends SimpleFormatter
{
	public RunsafeLogFormatter(LogFileHandler handler)
	{
		this.handler = handler;
	}

	@SuppressWarnings("StringConcatenationInFormatCall")
	@Override
	public synchronized String format(LogRecord record)
	{
		String logFormat = null;
		String message = formatMessage(record);
		if (record.getParameters() != null && record.getParameters().length > 0)
		{
			Object param = record.getParameters()[0];
			if (param instanceof ILogFormatProvider)
				logFormat = ((ILogFormatProvider) param).getLogFormat();
		}
		return String.format(
			logFormat + '\n',
			datestamp.print(record.getMillis()),
			timestamp.print(record.getMillis()),
			handler.colorize(record.getLevel()),
			message
		);
	}

	private final LogFileHandler handler;
	private final DateTimeFormatter datestamp = new DateTimeFormatterBuilder()
		.appendYear(4, 4).appendLiteral('-').appendMonthOfYear(2).appendLiteral('-').appendDayOfMonth(2)
		.toFormatter();
	private final DateTimeFormatter timestamp = new DateTimeFormatterBuilder()
		.appendHourOfDay(2).appendLiteral(':').appendMinuteOfHour(2).appendLiteral(':').appendSecondOfMinute(2)
		.toFormatter();
}
