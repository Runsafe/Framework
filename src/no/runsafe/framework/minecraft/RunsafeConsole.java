package no.runsafe.framework.minecraft;

import no.runsafe.framework.api.log.IConsole;
import no.runsafe.framework.api.command.ICommandExecutor;
import no.runsafe.framework.internal.InjectionPlugin;
import no.runsafe.framework.internal.configuration.FrameworkConfiguration;
import org.apache.commons.lang.NotImplementedException;

import java.util.UUID;
import java.util.logging.Level;

public class RunsafeConsole implements ICommandExecutor
{
	public RunsafeConsole(IConsole output)
	{
		this.output = output;
		this.name = InjectionPlugin.getGlobalComponent(FrameworkConfiguration.class).getConfigValueAsString("console.name");
	}

	@Override
	public String getName()
	{
		return name;
	}

	/**
	* Gets the unique ID.
	* @return null. The console doesn't have a unique ID.
	*/
	@Override
	public UUID getUniqueId()
	{
		return null;
	}

	@Override
	public void sendMessage(String message)
	{
		output.logInformation(message);
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

	@Override
	public boolean performCommand(String command)
	{
		throw new NotImplementedException("It is not yet supported running commands as the console from code.");
	}

	private final IConsole output;
	private final String name;
}
