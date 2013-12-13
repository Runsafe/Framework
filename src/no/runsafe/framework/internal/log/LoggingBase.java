package no.runsafe.framework.internal.log;

import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.text.ChatColour;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class LoggingBase implements ILogFormatProvider
{
	protected LoggingBase(LogFileHandler handler, String logName, String fileName) throws IOException
	{
		logFormat = handler.getFormat(logName);
		log = handler.getLogger(fileName);
		log.info("Debugging debugger in debugging with debugger");
		log.info("Created global logger with format '"+logFormat+"'");
	}

	protected LoggingBase(InjectionPlugin plugin, LogFileHandler handler, String logName, String fileName) throws IOException
	{
		logFormat = handler.getFormat(plugin, logName);
		log = handler.getLogger(fileName);
	}

	protected LoggingBase(Logger logger, String format)
	{
		logFormat = format;
		log = logger;
	}

	protected void writeLog(Level level, String message)
	{
		log.log(level, message, this);
	}

	@Override
	@Nullable
	public String getLogFormat()
	{
		if (logFormat == null)
			return "%1$s %2$s [%3$s] %4$s";
		return ChatColour.ToConsole(logFormat);
	}

	protected Logger log;
	protected final String logFormat;
}
