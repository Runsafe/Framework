package no.runsafe.framework.internal.log;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public final class RunsafeLogFormatter extends SimpleFormatter
{
	public RunsafeLogFormatter(FileManager handler)
	{
		fileManager = handler;
		fallbackFormat = fileManager.getFormat("*");
	}

	@SuppressWarnings("StringConcatenationInFormatCall")
	@Override
	public synchronized String format(LogRecord record)
	{
		String logFormat = fallbackFormat;
		String message = formatMessage(record);
		if (record.getParameters() != null && record.getParameters().length > 0)
		{
			Object param = record.getParameters()[0];
			if (param instanceof ILogFormatProvider)
				logFormat = ((ILogFormatProvider) param).getLogFormat();
		}
		Throwable exception = record.getThrown();
		if (exception != null)
			message = message + '\n' + ExceptionUtils.getFullStackTrace(exception);
		return String.format(
			logFormat + '\n',
			datestamp.print(record.getMillis()),
			timestamp.print(record.getMillis()),
			fileManager.colorize(record.getLevel()),
			message
		);
	}

	private final String fallbackFormat;
	private final FileManager fileManager;
	private final DateTimeFormatter datestamp = new DateTimeFormatterBuilder()
		.appendYear(4, 4).appendLiteral('-').appendMonthOfYear(2).appendLiteral('-').appendDayOfMonth(2)
		.toFormatter();
	private final DateTimeFormatter timestamp = new DateTimeFormatterBuilder()
		.appendHourOfDay(2).appendLiteral(':').appendMinuteOfHour(2).appendLiteral(':').appendSecondOfMinute(2)
		.toFormatter();
}
