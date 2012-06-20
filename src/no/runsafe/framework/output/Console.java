package no.runsafe.framework.output;

import java.util.logging.Level;

public class Console
{
	public static void setWriter(IOutput writer)
	{
		Console.writer = writer;
	}

	public static void write(String message)
	{
		writer.outputToConsole(message);
	}

	public static void severe(String message)
	{
		writer.outputDebugToConsole(message, Level.SEVERE);
	}

	public static void warning(String message)
	{
		writer.outputDebugToConsole(message, Level.WARNING);
	}

	public static void info(String message)
	{
		writer.outputDebugToConsole(message, Level.INFO);
	}

	public static void config(String message)
	{
		writer.outputDebugToConsole(message, Level.CONFIG);
	}

	public static void fine(String message)
	{
		writer.outputDebugToConsole(message, Level.FINE);
	}

	public static void finer(String message)
	{
		writer.outputDebugToConsole(message, Level.FINER);
	}

	public static void finest(String message)
	{
		writer.outputDebugToConsole(message, Level.FINEST);
	}

	static private IOutput writer;
}
