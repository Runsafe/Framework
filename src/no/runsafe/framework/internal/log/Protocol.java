package no.runsafe.framework.internal.log;

import no.runsafe.framework.api.log.IProtocol;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.text.ChatColour;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.io.IOException;
import java.util.logging.Level;

public final class Protocol extends LoggingBase implements IProtocol
{
	public Protocol(InjectionPlugin plugin, LogFileHandler handler) throws IOException
	{
		super(plugin, handler, "Protocol", "protocol.log");
	}

	@Override
	public void logException(Exception exception)
	{
		writeColoured(
			"Exception caught: &c%s&r\n%s",
			Level.SEVERE,
			ExceptionUtils.getMessage(exception),
			ExceptionUtils.getStackTrace(exception)
		);
	}

	@Override
	public void logInformation(String message, Object... params)
	{
		writeColoured("&2%s&r", Level.INFO, String.format(message.replace("&r", "&2"), params));
	}

	@Override
	public void logWarning(String message, Object... params)
	{
		writeColoured("&e%s&r", Level.WARNING, String.format(message.replace("&r", "&e"), params));
	}

	@Override
	public void logError(String message, Object... params)
	{
		writeColoured("&4%s&r", Level.SEVERE, String.format(message.replace("&r", "&4"), params));
	}

	private void writeColoured(String message, Level level, Object... params)
	{
		outputToConsole(ChatColour.ToConsole(String.format(message, params)), level);
	}

	private void outputToConsole(String message, Level level)
	{
		writeLog(level, message);
	}
}
