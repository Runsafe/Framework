package no.runsafe.framework.internal.log;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.time.DateFormatUtils;

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
			DateFormatUtils.format(record.getMillis(), "yyyy'-'MM'-'dd' 'HH':'mm':'ss"),
			fileManager.colorize(record.getLevel()),
			message
		);
	}

	private final String fallbackFormat;
	private final FileManager fileManager;
}
