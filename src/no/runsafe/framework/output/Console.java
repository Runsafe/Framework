package no.runsafe.framework.output;

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

	static private IOutput writer;
}
