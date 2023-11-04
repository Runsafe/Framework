package no.runsafe.framework.internal.log;

import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.text.ChatColour;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;

import java.io.IOException;
import java.util.logging.Level;

public final class Console extends LoggingBase implements IConsole
{
	@SuppressWarnings({"ReturnOfNull", "CallToPrintStackTrace", "NonThreadSafeLazyInitialization", "StaticVariableUsedBeforeInitialization"})
	public static IConsole Global()
	{
		try
		{
			if(globalConsole == null)
				globalConsole = new Console(InjectionPlugin.getGlobalComponent(FileManager.class));
		}
		catch (IOException e)
		{
			e.printStackTrace();
			return null;
		}
		return globalConsole;
	}

	private static IConsole globalConsole;

	public Console(InjectionPlugin plugin, FileManager handler) throws IOException
	{
		super(plugin, handler, "Console", "runsafe.log");
	}

	private Console(FileManager handler) throws IOException
	{
		super(handler, "Console", "runsafe.log");
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

	/**
	 * This will log a fatal error and make the server die in a great big fireball.
	 *
	 * @param message The message to print before exiting the process.
	 * @param params  Values to be passed into the message using {@link String#format(String, Object...)}
	 */
	@Override
	public void logFatal(String message, Object... params)
	{
		String formatted = String.format(message, params);
		String border = StringUtils.repeat("=", formatted.length());
		writeColoured("\n\n&4&l%1$s\n%2$s\n%1$s&r", Level.SEVERE, border, formatted);
		System.exit(1);
	}

	@Override
	public void writeColoured(String message, Level level, Object... params)
	{
		outputToConsole(ChatColour.ToConsole(String.format(message, params)), level);
	}

	// Sends the supplied String with the supplied logging level to the console/log the output handler has
	@Override
	public void outputToConsole(String message, Level level)
	{
		writeLog(level, message);
	}
}
