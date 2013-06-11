package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.api.command.ICommandExecutor;

public class RunsafeConsole implements ICommandExecutor
{
	public RunsafeConsole(IOutput output)
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
		output.write(message);
	}

	@Override
	public void sendColouredMessage(String message)
	{
		output.writeColoured(message);
	}

	@Override
	public void sendColouredMessage(String format, Object... params)
	{
		output.writeColoured(format, params);
	}

	@Override
	public boolean hasPermission(String permission)
	{
		return true;
	}

	private final IOutput output;
}
