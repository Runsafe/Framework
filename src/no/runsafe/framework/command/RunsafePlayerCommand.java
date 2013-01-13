package no.runsafe.framework.command;

import java.util.Collection;

/**
 * Only use this if you cannot use Async commands.
 */
@Deprecated
public class RunsafePlayerCommand extends RunsafeCommand
{
	public RunsafePlayerCommand(String name, String... params)
	{
		super(name, params);
	}

	@Override
	public boolean Execute(String[] args)
	{
		Console.write("This command cannot be used from the console.");
		return true;
	}
}
