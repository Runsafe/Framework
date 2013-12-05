package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.IConsole;
import no.runsafe.framework.api.command.ICommandExecutor;

import java.util.logging.Level;

public class RunsafeConsole implements ICommandExecutor
{
	public RunsafeConsole(IConsole output)
	{
		this.output = output;
	}

	@Override
	public String getName()
	{
		return "console";
	}

	@Override
	public void sendMessage(String message)
	{
		output.logInformation(message);
	}

	@Override
	public void sendColouredMessage(String message)
	{
		output.writeColoured(message, Level.INFO);
	}

	@Override
	public void sendColouredMessage(String format, Object... params)
	{
		output.writeColoured(format, Level.INFO, params);
	}

	@Override
	public boolean hasPermission(String permission)
	{
		return true;
	}

	private final IConsole output;
}
