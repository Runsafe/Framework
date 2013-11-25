package no.runsafe.framework.internal;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

@SuppressWarnings("ThrowableResultOfMethodCallIgnored")
public class RunsafeLogFormatter extends SimpleFormatter
{
	@Override
	public synchronized String format(LogRecord record)
	{
		timestamp.setTime(record.getMillis());
		String source;
		if (record.getSourceClassName() != null) {
			source = record.getSourceClassName();
			if (record.getSourceMethodName() != null) {
				source += " " + record.getSourceMethodName();
			}
		} else {
			source = record.getLoggerName();
		}
		String message = formatMessage(record);
		return String.format(
			"[%s] (%s %s) %s: %s",
			timestamp, source, record.getLoggerName(), record.getLevel().getName(), message
		);
	}

	private final Date timestamp = new Date();
}
